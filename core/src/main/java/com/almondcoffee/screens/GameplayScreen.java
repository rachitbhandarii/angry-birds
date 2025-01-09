package com.almondcoffee.screens;

import com.almondcoffee.AngryBirds;
import com.almondcoffee.exceptions.UnableToPauseException;
import com.almondcoffee.exceptions.UnableToRestartException;
import com.almondcoffee.objects.Catapult;
import com.almondcoffee.objects.Structure;
import com.almondcoffee.objects.birds.Birdie;
import com.almondcoffee.objects.birds.Blue;
import com.almondcoffee.objects.birds.Red;
import com.almondcoffee.objects.birds.Yellow;
import com.almondcoffee.objects.materials.Material;
import com.almondcoffee.objects.pigs.Piggie;
import com.almondcoffee.support.PhysicsExt;
import com.almondcoffee.support.Trajectory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.physics.box2d.*;

import java.io.*;
import java.util.ArrayList;

public class GameplayScreen implements Screen, Serializable {

    private final AngryBirds game;
    private SpriteBatch batch;
    private Sprite bg;
    private PhysicsExt bgPhy;
    private Sprite pauseBtn;
    private Sprite retryBtn;

    private Structure struct;
    private ArrayList<Birdie> birdies;
    private Birdie currentBird;
    private Catapult catapult;

    private Vector2 touchPos;
    private Trajectory trajectory;

    private World world;
    private boolean pause;

    public GameplayScreen(AngryBirds game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.world = new World(new Vector2(0, -0.098f), true);

        // background
        bg = new Sprite( new Texture("gameplaybg.png"));
        bg.setSize(game.getViewport().getWorldWidth(),game.getViewport().getWorldHeight());
        bg.setPosition(0,0);
        bgPhy = new PhysicsExt(bg,world,false,1.25f);

        // pause button
        pauseBtn = new Sprite( new Texture("pausebtn.png"));
        pauseBtn.setSize(0.8f,0.8f);
        pauseBtn.setPosition(0.25f, game.getViewport().getWorldHeight()-1.2f);

        // retry button
        retryBtn = new Sprite( new Texture("retrybtn.png"));
        retryBtn.setSize(0.8f,0.8f);
        retryBtn.setPosition(1.5f, game.getViewport().getWorldHeight()-1.2f);

        // instantiating the rest of the structures
        struct = new Structure(AngryBirds.getLevel());
        for (Piggie piggie:struct.getPiggies()){
            piggie.setPhysicsExt(new PhysicsExt(piggie.getPig(),world,true,0));
            piggie.getPhysicsExt().getBody().setUserData(piggie);
        }
        for (Material material:struct.getMaterials()){
            material.setPhysicsExt(new PhysicsExt(material.getMaterial(),world,true,0));
            material.getPhysicsExt().getBody().setUserData(material);
        }
        birdies = new ArrayList<>();
        birdies.add(new Red(0f,0.1f));
        birdies.add(new Yellow(1.2f,0.1f));
        birdies.add(new Blue(2.4f,0.1f));
        for (Birdie birdie:birdies){
            birdie.setPhysicsExt(new PhysicsExt(birdie.getBird(),world,true,0));
            birdie.getPhysicsExt().getBody().setUserData(birdie);
            birdie.getPhysicsExt().getBody().setActive(false);
            birdie.getPhysicsExt().getBody().setAwake(false);
        }

        catapult = new Catapult();
        trajectory = new Trajectory();
        trajectory.create();

        // assigning a vector value to the touch of mouse
        touchPos = new Vector2();
    }

    public GameplayScreen(AngryBirds game,boolean serializable) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.world = new World(new Vector2(0, -0.098f), true);

        // background
        bg = new Sprite( new Texture("gameplaybg.png"));
        bg.setSize(game.getViewport().getWorldWidth(),game.getViewport().getWorldHeight());
        bg.setPosition(0,0);
        bgPhy = new PhysicsExt(bg,world,false,1.25f);

        // pause button
        pauseBtn = new Sprite( new Texture("pausebtn.png"));
        pauseBtn.setSize(0.8f,0.8f);
        pauseBtn.setPosition(0.25f, game.getViewport().getWorldHeight()-1.2f);

        // retry button
        retryBtn = new Sprite( new Texture("retrybtn.png"));
        retryBtn.setSize(0.8f,0.8f);
        retryBtn.setPosition(1.5f, game.getViewport().getWorldHeight()-1.2f);

        // instantiating the rest of the structures
        try {
            FileInputStream file = new FileInputStream("struct.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            struct = (Structure) in.readObject();
            in.close();
            file.close();
        } catch(IOException ex) {
            struct = new Structure(AngryBirds.getLevel());
            for (Piggie piggie:struct.getPiggies()){
                piggie.setPhysicsExt(new PhysicsExt(piggie.getPig(),world,true,0));
                piggie.getPhysicsExt().getBody().setUserData(piggie);
            }
            for (Material material:struct.getMaterials()){
                material.setPhysicsExt(new PhysicsExt(material.getMaterial(),world,true,0));
                material.getPhysicsExt().getBody().setUserData(material);
            }
        } catch (Exception e) {
            System.exit(1);
        }
        try {
            FileInputStream file = new FileInputStream("birdies.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            birdies = (ArrayList<Birdie>) in.readObject();
            in.close();
            file.close();
        } catch(IOException ex) {
            birdies = new ArrayList<>();
            birdies.add(new Red(0f,0.1f));
            birdies.add(new Yellow(1.2f,0.1f));
            birdies.add(new Blue(2.4f,0.1f));
            for (Birdie birdie:birdies){
                birdie.setPhysicsExt(new PhysicsExt(birdie.getBird(),world,true,0));
                birdie.getPhysicsExt().getBody().setUserData(birdie);
                birdie.getPhysicsExt().getBody().setActive(false);
                birdie.getPhysicsExt().getBody().setAwake(false);
            }
        } catch (Exception e) {
            System.exit(1);
        }

        catapult = new Catapult();
        trajectory = new Trajectory();
        trajectory.create();

        // assigning a vector value to the touch of mouse
        touchPos = new Vector2();
    }

    private void launch(Birdie birdie){
        birdie.getPhysicsExt().getBody().setAwake(true);
        birdie.getPhysicsExt().getBody().setActive(true);

        // Calculate force based on trajectory input
        Vector2 launchVelocity = new Vector2(
            (trajectory.getSlingPosition().x - trajectory.getDragPosition().x) / 50,
            (trajectory.getSlingPosition().y - trajectory.getDragPosition().y) / 50
        );

        birdie.getPhysicsExt().getBody().setLinearVelocity(launchVelocity);
        birdie.setLaunched(true);
    }

    private void input(float v) throws UnableToPauseException,UnableToRestartException{
        if (Gdx.input.justTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            game.getViewport().unproject(touchPos);

            if (pauseBtn.getBoundingRectangle().contains(touchPos)) {
//                try {
//                    FileOutputStream file = new FileOutputStream("struct.ser");
//                    ObjectOutputStream out = new ObjectOutputStream(file);
//                    out.writeObject(struct);
//                    out.close();
//                    file.close();
//
//                } catch(IOException ex) {
//                    System.out.println("Error storing data.");
//                    System.exit(1);
//                }
//                try {
//                    FileOutputStream file = new FileOutputStream("birdies.ser");
//                    ObjectOutputStream out = new ObjectOutputStream(file);
//                    out.writeObject(birdies);
//                    out.close();
//                    file.close();
//
//                } catch(IOException ex) {
//                    System.out.println("Error storing data.");
//                    System.exit(1);
//                }
                dispose();
                game.setScreen(new PauseScreen(game));
                return;
            }
            else if (retryBtn.getBoundingRectangle().contains(touchPos)) {
                dispose();
                game.setScreen(new GameplayScreen(game));
                return;
            }
            else if (currentBird == null){
                for (Birdie birdie: birdies){
                    if (birdie.getBird().getBoundingRectangle().contains(touchPos)){
                        currentBird = birdie;
                        currentBird.setPosition(3,2.5f);
                        break;
                    }
                }
            }
        }
        else if (currentBird!=null && (!bg.getBoundingRectangle().contains(currentBird.getBird().getX(),currentBird.getBird().getY()) || (currentBird.isLaunched() && currentBird.getPhysicsExt().getBody().getLinearVelocity().x==0 && currentBird.getPhysicsExt().getBody().getLinearVelocity().y==0))){
            currentBird.setIsBird(false);
            currentBird.getPhysicsExt().getBody().setTransform(100,100,0);
            currentBird = null;
        }

        boolean gameWon = true;
        for (Piggie piggie: struct.getPiggies()){
            if (bg.getBoundingRectangle().contains(piggie.getPig().getX(),piggie.getPig().getY())) {gameWon = false; break;}
        }
        if (gameWon){
            dispose();
            AngryBirds.incrLevel();
            game.setScreen(new VictoryScreen(game));
            return;
        }

        boolean gameLost = true;
        for (Birdie birdie: birdies){
            if (bg.getBoundingRectangle().contains(birdie.getBird().getX(),birdie.getBird().getY())) {gameLost = false; break;}
        }
        if (gameLost){
            dispose();
            game.setScreen(new DefeatScreen(game));
            return;
        }
    }

    private void logic() {


    }

    private void draw() {

        // clearing and screen setup
        ScreenUtils.clear(0, 0, 0, 1, true);
        game.getViewport().apply();
        batch.setProjectionMatrix(game.getViewport().getCamera().combined);

        // drawing the sprites to the batch

        batch.begin();
        bg.draw(batch);
        pauseBtn.draw(batch);
        retryBtn.draw(batch);
        catapult.draw(batch);
        struct.draw(batch);
        for (Birdie birdie:birdies) if (birdie.getIsBird()) birdie.draw(batch);
        batch.end();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        try{
            input(v);
        }
        catch(UnableToPauseException | UnableToRestartException e){
            System.out.println(e.getMessage());
        }
        logic();
        draw();

        if (!pause)
        world.step(1 / 60f, 6, 2);
        game.getViewport().getCamera().update();
        //debugRenderer.render(world, game.getViewport().getCamera().combined);
        // Sync sprites with physics bodies
        for (Birdie birdie : birdies) {
            birdie.getPhysicsExt().updateSpritePosition(birdie.getBird());
        }
        for (Piggie piggie : struct.getPiggies()) {
            piggie.getPhysicsExt().updateSpritePosition(piggie.getPig());
        }
        for (Material material : struct.getMaterials()) {
            material.getPhysicsExt().updateSpritePosition(material.getMaterial());
        }

        if (currentBird!=null && currentBird.getBird().getBoundingRectangle().contains(touchPos)){
            trajectory.render();
            if (!trajectory.getIsDragging()) launch(currentBird);
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        try {
            trajectory.dispose();
            if (bg != null) bg.getTexture().dispose();
            if (pauseBtn != null) pauseBtn.getTexture().dispose();
            if (retryBtn != null) retryBtn.getTexture().dispose();

            for (Birdie birdie : birdies) {
                if (birdie.getBird() != null) {
                    birdie.getBird().getTexture().dispose();
                    birdie.getPhysicsExt().dispose();
                }
            }
            birdies.clear();
            for (Piggie piggie : struct.getPiggies()) {
                if (piggie.getPig() != null) {
                    piggie.getPig().getTexture().dispose();
                    piggie.getPhysicsExt().dispose();
                }
            }
            struct.getPiggies().clear();
            for (Material material : struct.getMaterials()) {
                if (material.getMaterial() != null) {
                    material.getMaterial().getTexture().dispose();
                    material.getPhysicsExt().dispose();
                }
            }
            struct.getMaterials().clear();
            bgPhy.dispose();

            batch.dispose();
            pause = true;
            if (world != null) world.dispose();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            Gdx.app.exit();
        }
    }
}
