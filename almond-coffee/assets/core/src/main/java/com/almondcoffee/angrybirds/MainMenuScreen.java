package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.System.exit;

public class MainMenuScreen implements Screen {
    final AngryBirds game;
    public SpriteBatch batch;
    Sprite bg;
    Sprite exitBtn;
    Sprite startGameBtn;
    Sprite resumeGameBtn;
    Vector2 touchPos;


    public MainMenuScreen(final AngryBirds game) {
        this.game = game;
        batch = new SpriteBatch();
        bg = new Sprite( new Texture("mainmenubg.png"));
        bg.setSize(game.viewport.getWorldWidth(),game.viewport.getWorldHeight());
        exitBtn = new Sprite( new Texture("exitbtn.png"));
        exitBtn.setSize(2,1);
        exitBtn.setPosition(1,1);
        startGameBtn = new Sprite( new Texture("newgamebtn.png"));
        startGameBtn.setSize(4,2);
        startGameBtn.setPosition(game.viewport.getWorldWidth()/2-2,(0.65f)*game.viewport.getWorldHeight()-1);
        resumeGameBtn = new Sprite( new Texture("resumegamebtn.png"));
        resumeGameBtn.setSize(4,2);
        resumeGameBtn.setPosition(game.viewport.getWorldWidth()/2-2,(0.35f)*game.viewport.getWorldHeight()-1);
        touchPos = new Vector2();
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
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            System.out.println("Touch detected at: (" + Gdx.input.getX() + ", " + Gdx.input.getY() + ")");
            game.viewport.unproject(touchPos);
            System.out.println("Unprojected to: (" + touchPos.x + ", " + touchPos.y + ")");
            if (touchPos.x >= game.viewport.getWorldWidth()/2-2 && touchPos.x <= game.viewport.getWorldWidth()/2+2 && touchPos.y >= (0.65f)*game.viewport.getWorldHeight()-1 && touchPos.y <= (0.65f)*game.viewport.getWorldHeight()+1) {
                dispose();
                game.setScreen(new LevelOneScreen(game));
            }
            //for now, as there's only one level, that would be loaded
            else if (touchPos.x >= game.viewport.getWorldWidth()/2-2 && touchPos.x <= game.viewport.getWorldWidth()/2+2 && touchPos.y >= (0.35f)*game.viewport.getWorldHeight()-1 && touchPos.y <= (0.35f)*game.viewport.getWorldHeight()+1) {
                dispose();
                game.setScreen(new LevelOneScreen(game));
            }
            else if (touchPos.x >= 1 && touchPos.x <= 3 && touchPos.y >= 1 && touchPos.y <= 2) {
                Gdx.app.exit();
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
