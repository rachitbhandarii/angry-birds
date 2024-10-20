package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class VictoryScreen implements Screen {
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite bg;

    public VictoryScreen(final AngryBirds game){
        batch = new SpriteBatch();
        bg = new Sprite(new Texture("victorybg.png"));
        bg.setSize(game.viewport.getWorldWidth(),game.viewport.getWorldHeight());
        this.game = game;
    }

    @Override
    public void show(){}

    @Override
    public void render(float v) {
        input();
        logic();
        draw();
    }

    private void input() {
        //save&exit or nextLevel
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        game.viewport.apply();
        batch.setProjectionMatrix(game.viewport.getCamera().combined);

        batch.begin();
        bg.draw(batch);
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

    }
}
