package com.almondcoffee.screens;

import com.almondcoffee.AngryBirds;
import com.almondcoffee.exceptions.UnableToExitException;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MainMenuScreen implements Screen, Serializable {
    private final AngryBirds game;
    private SpriteBatch batch;
    private Sprite bg;
    private Sprite exitBtn;
    private Sprite startGameBtn;
    private Sprite resumeGameBtn;
    private Vector2 touchPos;


    public MainMenuScreen(final AngryBirds game) {

        this.game = game;
        batch = new SpriteBatch();
        bg = new Sprite( new Texture("mainmenubg.png"));
        bg.setSize(game.getViewport().getWorldWidth(),game.getViewport().getWorldHeight());

        exitBtn = new Sprite( new Texture("exitbtn.png"));
        exitBtn.setSize(2,1);
        exitBtn.setPosition(1,1);

        startGameBtn = new Sprite( new Texture("newgamebtn.png"));
        startGameBtn.setSize(4,2);
        startGameBtn.setPosition(game.getViewport().getWorldWidth()/2-2,(0.65f)*game.getViewport().getWorldHeight()-1);

        resumeGameBtn = new Sprite( new Texture("resumegamebtn.png"));
        resumeGameBtn.setSize(4,2);
        resumeGameBtn.setPosition(game.getViewport().getWorldWidth()/2-2,(0.35f)*game.getViewport().getWorldHeight()-1);

        touchPos = new Vector2();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        try{
            input();
        }
        catch(UnableToExitException e){
            System.out.println(e.getMessage());
        }
        logic();
        draw();
    }


    private void input() throws UnableToExitException {
        if (Gdx.input.justTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            game.getViewport().unproject(touchPos);
            if (startGameBtn.getBoundingRectangle().contains(touchPos)) {
                dispose();
                AngryBirds.setLevel(0);
                game.setScreen(new GameplayScreen(game));
                return;
            }
            else if (resumeGameBtn.getBoundingRectangle().contains(touchPos)) {
                dispose();
                game.setScreen(new GameplayScreen(game,true));
                return;
            }
            else if (exitBtn.getBoundingRectangle().contains(touchPos)) {
                try {
                    FileOutputStream file = new FileOutputStream("level.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);
                    out.writeInt(AngryBirds.getLevel()-1);
                    out.close();
                    file.close();

                } catch(IOException ex) {
                    System.out.println("Error storing data.");
                    System.exit(1);
                }
                Gdx.app.exit();
                return;
            }
        }
    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1, true);
        game.getViewport().apply();
        batch.setProjectionMatrix(game.getViewport().getCamera().combined);

        batch.begin();
        bg.draw(batch);
        exitBtn.draw(batch);
        startGameBtn.draw(batch);
        resumeGameBtn.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
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

