package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.System.exit;

public class PauseScreen implements Screen {
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite bg;
    Sprite resumeBtn;
    Sprite mainMenuBtn;
    Vector2 touchPos;

    public PauseScreen(AngryBirds game) {
        this.game = game;
        batch = new SpriteBatch();
        bg = new Sprite(new Texture("pausescreenbg.png"));
        bg.setSize(game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        resumeBtn = new Sprite(new Texture("resumebtn.png"));
        resumeBtn.setSize(4, 2);
        resumeBtn.setPosition(0.25f, 0.25f);
        mainMenuBtn = new Sprite(new Texture("mainmenubtn.png"));
        mainMenuBtn.setSize(4,2);
        mainMenuBtn.setPosition(game.viewport.getWorldWidth()-4.25f, 0.25f);
        touchPos = new Vector2();
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
        if (Gdx.input.justTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            System.out.println("Touch detected at: (" + Gdx.input.getX() + ", " + Gdx.input.getY() + ")");
            game.viewport.unproject(touchPos);
            System.out.println("Unprojected to: (" + touchPos.x + ", " + touchPos.y + ")");
            if (touchPos.x >= 0.25f && touchPos.x <= 4.25f && touchPos.y >= 0.25f && touchPos.y <= 2.25f) {
                dispose();
                game.setScreen(new LevelOneScreen(game));
            }
            else if (touchPos.x >= game.viewport.getWorldWidth()-4.25f && touchPos.x <= game.viewport.getWorldWidth()-0.25f && touchPos.y >= 0.25f && touchPos.y <= 2.25f) {
                dispose();
                game.setScreen(new MainMenuScreen(game));
            }
        }
    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1, true);
        game.viewport.apply();
        batch.setProjectionMatrix(game.viewport.getCamera().combined);

        batch.begin();
        bg.draw(batch);
        resumeBtn.draw(batch);
        mainMenuBtn.draw(batch);
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
