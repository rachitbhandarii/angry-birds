
package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;

public class SplashScreen implements Screen {
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite splash;

    public SplashScreen(final AngryBirds game) {
        this.game = game;
        batch = new SpriteBatch();
        splash = new Sprite( new Texture("splashscreen.png"));
        splash.setSize(game.viewport.getWorldWidth(),game.viewport.getWorldHeight());
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        input();
        logic();
        draw();
    }

    private void input() {
        if (Gdx.input.justTouched()) {
            dispose();
            game.setScreen(new MainMenuScreen(game));
        }
    }

    private void logic() {
    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1, true);
        game.viewport.apply();
        batch.setProjectionMatrix(game.viewport.getCamera().combined);

        batch.begin();
        splash.draw(batch);
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
