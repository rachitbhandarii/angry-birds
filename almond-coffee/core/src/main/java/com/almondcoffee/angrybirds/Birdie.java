package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Birdie {
    Sprite bird;

    public Birdie() {}

    public void setPosition(float x, float y){
        bird.setCenter(x, y);
    }

    public void draw(SpriteBatch batch){
        bird.draw(batch);
    }
}
