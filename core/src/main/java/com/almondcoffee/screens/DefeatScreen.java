package com.almondcoffee.screens;

import com.almondcoffee.AngryBirds;
import com.almondcoffee.exceptions.UnableToRestartException;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.Serializable;

public class DefeatScreen implements Screen, Serializable {
    private final AngryBirds game;
    private SpriteBatch batch;
    private Sprite bg;
    private Sprite tryAgainBtn;
    private Sprite mainMenuBtn;
    private Vector2 touchPos;

    public DefeatScreen(final AngryBirds game){
        this.game = game;

        batch = new SpriteBatch();
        bg = new Sprite(new Texture("defeatbg.png"));
        bg.setSize(game.getViewport().getWorldWidth(),game.getViewport().getWorldHeight());

        tryAgainBtn = new Sprite(new Texture("tryagainbtn.png"));
        tryAgainBtn.setSize(4,2);
        tryAgainBtn.setPosition(0.25f, 0.25f);

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
        catch(UnableToRestartException e){
            System.out.println(e.getMessage());
        }
        logic();
        draw();
    }

    private void input() throws UnableToRestartException{
        if (Gdx.input.justTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            game.getViewport().unproject(touchPos);
            if (tryAgainBtn.getBoundingRectangle().contains(touchPos)) {
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
        tryAgainBtn.draw(batch);
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
