package com.almondcoffee.screens;

import com.almondcoffee.AngryBirds;
import com.almondcoffee.exceptions.UnableToContinueException;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.Serializable;

public class VictoryScreen implements Screen, Serializable {
    private final AngryBirds game;
    private SpriteBatch batch;
    private Sprite bg;
    private Sprite nextLevelBtn;
    private Sprite mainMenuBtn;
    private Vector2 touchPos;

    public VictoryScreen(final AngryBirds game){
        this.game = game;

        batch = new SpriteBatch();
        bg = new Sprite(new Texture("victorybg.png"));
        bg.setSize(game.getViewport().getWorldWidth(),game.getViewport().getWorldHeight());

        nextLevelBtn = new Sprite(new Texture("nextlevelbtn.png"));
        nextLevelBtn.setSize(4,2);
        nextLevelBtn.setPosition(0.25f, 0.25f);

        mainMenuBtn = new Sprite(new Texture("mainmenubtn.png"));
        mainMenuBtn.setSize(4,2);
        mainMenuBtn.setPosition(game.getViewport().getWorldWidth()-4.25f, 0.25f);

        touchPos = new Vector2();
    }

    @Override
    public void show(){}

    @Override
    public void render(float v) {
        try{
            input();
        }
        catch(UnableToContinueException e){
            System.out.println(e.getMessage());
        }
        logic();
        draw();
    }

    private void input() throws UnableToContinueException{
        if (Gdx.input.justTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            game.getViewport().unproject(touchPos);
            if (nextLevelBtn.getBoundingRectangle().contains(touchPos)) {
                dispose();
                game.setScreen(new GameplayScreen(game));
            }
            else if (mainMenuBtn.getBoundingRectangle().contains(touchPos)) {
                dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        }
    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        game.getViewport().apply();
        batch.setProjectionMatrix(game.getViewport().getCamera().combined);

        batch.begin();
        bg.draw(batch);
        nextLevelBtn.draw(batch);
        mainMenuBtn.draw(batch);
        batch.end();
    }

    public void resize(int width, int height) {}

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
