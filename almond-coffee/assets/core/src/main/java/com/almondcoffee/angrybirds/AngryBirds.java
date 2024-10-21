package com.almondcoffee.angrybirds;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.Gdx;

public class AngryBirds extends Game {
    FitViewport viewport;
    Music bgm;

    @Override
    public void create() {
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        viewport = new FitViewport(16, 9);
        bgm = Gdx.audio.newMusic(Gdx.files.internal("bgm.mp3"));
        bgm.setLooping(true);
        bgm.play();
        bgm.setVolume(0.5f);
        this.setScreen(new SplashScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

}
