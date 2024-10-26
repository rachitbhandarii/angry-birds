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

public class DefeatScreen implements Screen {
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite bg;
    Sprite tryAgainBtn;
    Sprite mainMenuBtn;
    Vector2 touchPos;

    public DefeatScreen(final AngryBirds game){
        batch = new SpriteBatch();
        bg = new Sprite(new Texture("defeatbg.png"));
        bg.setSize(game.getViewport().getWorldWidth(),game.getViewport().getWorldHeight());
        tryAgainBtn = new Sprite(new Texture("tryagainbtn.png"));
        tryAgainBtn.setSize(4,2);
        tryAgainBtn.setPosition(0.25f, 0.25f);
        mainMenuBtn = new Sprite(new Texture("mainmenubtn.png"));
        mainMenuBtn.setSize(4,2);
        mainMenuBtn.setPosition(game.getViewport().getWorldWidth()-4.25f, 0.25f);
        this.game = game;
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
            System.out.println("Touch detected at: (" + Gdx.input.getX() + ", " + Gdx.input.getY() + ")");
            game.getViewport().unproject(touchPos);
            System.out.println("Unprojected to: (" + touchPos.x + ", " + touchPos.y + ")");
            if (touchPos.x >= 0.25f && touchPos.x <= 4.25f && touchPos.y >= 0.25f && touchPos.y <= 2.25f) {
                dispose();
                game.setScreen(new LevelOneScreen(game));
            }
            else if (touchPos.x >= game.getViewport().getWorldWidth()-4.25f && touchPos.x <= game.getViewport().getWorldWidth()-0.25f && touchPos.y >= 0.25f && touchPos.y <= 2.25f) {
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
