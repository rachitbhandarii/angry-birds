package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class VictoryScreen implements Screen {
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite bg;
    Sprite nextLevelBtn;
    Sprite mainMenuBtn;
    Vector2 touchPos;

    public VictoryScreen(final AngryBirds game){
        batch = new SpriteBatch();
        bg = new Sprite(new Texture("victorybg.png"));
        bg.setSize(game.viewport.getWorldWidth(),game.viewport.getWorldHeight());
        nextLevelBtn = new Sprite(new Texture("nextlevelbtn.png"));
        nextLevelBtn.setSize(4,2);
        nextLevelBtn.setPosition(0.25f, 0.25f);
        mainMenuBtn = new Sprite(new Texture("mainmenubtn.png"));
        mainMenuBtn.setSize(4,2);
        mainMenuBtn.setPosition(game.viewport.getWorldWidth()-4.25f, 0.25f);
        this.game = game;
        touchPos = new Vector2();
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
        ScreenUtils.clear(Color.BLACK);
        game.viewport.apply();
        batch.setProjectionMatrix(game.viewport.getCamera().combined);

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

    }
}
