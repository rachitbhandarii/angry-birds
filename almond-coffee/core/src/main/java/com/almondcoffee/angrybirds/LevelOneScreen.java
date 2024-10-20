package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class LevelOneScreen implements Screen {
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite bg;
    Sprite pauseBtn;

    public LevelOneScreen(AngryBirds game) {
        this.game = game;
        batch = new SpriteBatch();
        bg = new Sprite( new Texture("gameplaybg.png"));
        bg.setSize(game.viewport.getWorldWidth(),game.viewport.getWorldHeight());
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        input();
        logic();
        draw();
    }

    private void input() {

    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1, true);
        game.viewport.apply();
        batch.setProjectionMatrix(game.viewport.getCamera().combined);

        batch.begin();
        bg.draw(batch);
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
