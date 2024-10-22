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
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite bg;
    Sprite pauseBtn;
    Sprite retryBtn;
    Vector2 touchPos;
    Structure struct;
    ArrayList<Birdie> birdies;
    Catapult catapult;

    public LevelOneScreen(AngryBirds game) {
        this.game = game;
        batch = new SpriteBatch();
        bg = new Sprite( new Texture("gameplaybg.png"));
        bg.setSize(game.viewport.getWorldWidth(),game.viewport.getWorldHeight());
        pauseBtn = new Sprite( new Texture("pausebtn.png"));
        pauseBtn.setSize(1.2f,0.9f);
        pauseBtn.setPosition(0.25f, game.viewport.getWorldHeight()-1.2f);
        retryBtn = new Sprite( new Texture("retrybtn.png"));
        retryBtn.setSize(0.8f,0.8f);
        retryBtn.setPosition(1.5f, game.viewport.getWorldHeight()-1.2f);
        touchPos = new Vector2();
        struct = new Structure();
        birdies = new ArrayList<>();
        birdies.add(new Red(0f,1));
        birdies.add(new Blue(2.25f,1));
        birdies.add(new Yellow(1f,1));
        catapult = new Catapult();
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
            if (touchPos.x >= 0.25f && touchPos.x <= 1.45f && touchPos.y >= game.viewport.getWorldHeight()-1.2f && touchPos.y <= game.viewport.getWorldHeight()-0.3f) {
                dispose();
                game.setScreen(new PauseScreen(game));
            }
            if (touchPos.x >= 1.5f && touchPos.x <= 2.3f && touchPos.y >= game.viewport.getWorldHeight()-1.2f && touchPos.y <= game.viewport.getWorldHeight()-0.4f) {
                dispose();
                game.setScreen(new LevelOneScreen(game));
            }
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
        //.................................................................
    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(0, 0, 0, 1, true);
        game.viewport.apply();
        batch.setProjectionMatrix(game.viewport.getCamera().combined);

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
