package com.almondcoffee;

import com.almondcoffee.screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashSet;

public class AngryBirds extends Game implements Serializable {
    private static int level;
    private FitViewport viewport;
    private Music bgm;

    @Override
    public void create() {
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        viewport = new FitViewport(16, 9);
        bgm = Gdx.audio.newMusic(Gdx.files.internal("bgm.mp3"));
        bgm.setLooping(true);
        bgm.play();
        bgm.setVolume(0.5f);
        level = 0;
        this.setScreen(new SplashScreen(this));
        try {
            FileInputStream file = new FileInputStream("level.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            level = in.readInt();
            in.close();
            file.close();
        } catch(IOException ex) {
            level = 0;
        } catch (Exception e) {
            System.exit(1);
        }
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

    public FitViewport getViewport() {
        return viewport;
    }

    public void setViewport(FitViewport viewport) {
        this.viewport = viewport;
    }

    public Music getBgm() {
        return bgm;
    }

    public void setBgm(Music bgm) {
        this.bgm = bgm;
    }

    public static int getLevel() {return level+1;}

    public static void incrLevel() {level++; level%=3;}

    public static void setLevel(int level) {AngryBirds.level = level;}
}
