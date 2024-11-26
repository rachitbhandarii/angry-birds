package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class LevelOneScreen implements Screen {
    private final AngryBirds game;
    private SpriteBatch batch;
    private Sprite bg;
    private Sprite pauseBtn;
    private Sprite retryBtn;
    private Vector2 touchPos;
    private Sprite power;
    private Sprite angle;
    private Structure struct;
    private ArrayList<Birdie> birdies;
    private Birdie currentBird;
    private boolean isDragging = false;
    private Vector2 launchVelocity = new Vector2();
    AngryBirdsPhysics birdPhysics = new AngryBirdsPhysics(new Vector2(200, 300), new Vector2(500, 600), -9.8f);

    private Catapult catapult;

    public LevelOneScreen(AngryBirds game) {
        this.game = game;
        batch = new SpriteBatch();
        bg = new Sprite( new Texture("gameplaybg.png"));
        bg.setSize(game.getViewport().getWorldWidth(),game.getViewport().getWorldHeight());
        pauseBtn = new Sprite( new Texture("pausebtn.png"));
        pauseBtn.setSize(1.2f,0.9f);
        pauseBtn.setPosition(0.25f, game.getViewport().getWorldHeight()-1.2f);
        retryBtn = new Sprite( new Texture("retrybtn.png"));
        retryBtn.setSize(0.8f,0.8f);
        retryBtn.setPosition(1.5f, game.getViewport().getWorldHeight()-1.2f);
        touchPos = new Vector2();
        struct = new Structure();
        birdies = new ArrayList<>();
        birdies.add(new Red(0f,0.2f));
        birdies.add(new Blue(2.25f,0.2f));
        birdies.add(new Yellow(1f,0.2f));
        catapult = new Catapult();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        try{
            input();
        }
        catch(UnableToPauseException | UnableToRestartException e){
            System.out.println(e.getMessage());
        }
        logic();
        draw();
    }

    private void input() throws UnableToPauseException,UnableToRestartException{
//        float deltaTime = Gdx.graphics.getDeltaTime();
//        birdPhysics.update(deltaTime);
//
//// Get bird's updated position
//        Vector2 birdPos = birdPhysics.getBirdPosition();
//        batch.draw(birdies.get(0).getBird().getTexture(), birdPos.x - birdies.get(0).getBird().getTexture().getWidth() / 2f, birdPos.y - birdies.get(0).getBird().getTexture().getHeight() / 2f);
//
//// Reset if bird goes off-screen
////        if (birdPos.y < 0 || birdPos.x > Gdx.graphics.getWidth()) {
////            birdPhysics.reset(new Vector2(200, 300), new Vector2(500, 600));
////        }

        if (Gdx.input.justTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            System.out.println("Touch detected at: (" + Gdx.input.getX() + ", " + Gdx.input.getY() + ")");
            game.getViewport().unproject(touchPos);
            System.out.println("Unprojected to: (" + touchPos.x + ", " + touchPos.y + ")");
            if (touchPos.x >= 0.25f && touchPos.x <= 1.45f && touchPos.y >= game.getViewport().getWorldHeight()-1.2f && touchPos.y <= game.getViewport().getWorldHeight()-0.3f) {
                dispose();
                game.setScreen(new PauseScreen(game));
            }
            if (touchPos.x >= 1.5f && touchPos.x <= 2.3f && touchPos.y >= game.getViewport().getWorldHeight()-1.2f && touchPos.y <= game.getViewport().getWorldHeight()-0.4f) {
                dispose();
                game.setScreen(new LevelOneScreen(game));
            }
//            if (currentBird != null && currentBird.isReady() && catapult.isWithinBounds(touchPos)) {
//                isDragging = true;
//                currentBird.setPosition(touchPos.x, touchPos.y); // Move bird to touch point
//            }
        }
        // only for testing..............................................
        else if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            dispose();
            game.setScreen(new DefeatScreen(game));
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            dispose();
            game.setScreen(new VictoryScreen(game));
        }
//        else if (isDragging) {
//            // Calculate launch velocity when touch is released
//            isDragging = false;
//            launchVelocity.set(catapult.getPosition()).sub(currentBird.getPosition()).scl(-1); // Inverse direction
//            currentBird.launch(launchVelocity);
//        }
        //.................................................................
    }

    private void logic() {
//        if (currentBird != null) {
//            currentBird.update(Gdx.graphics.getDeltaTime());
//        }
    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1, true);
        game.getViewport().apply();
        batch.setProjectionMatrix(game.getViewport().getCamera().combined);

        batch.begin();
        bg.draw(batch);
        pauseBtn.draw(batch);
        retryBtn.draw(batch);
        struct.draw(batch);
        for (Birdie birdie:birdies){
            birdie.draw(batch);
        }
        catapult.draw(batch);
        batch.end();
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
        batch.dispose();
    }
}
