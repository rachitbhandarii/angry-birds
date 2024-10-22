package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Piggie {
    Sprite pig;

    public Piggie(){
        pig = new Sprite(new Texture("pig.png"));
    }

    public void setPosition(float x, float y){
        pig.setCenter(x, y);
    }

    public void draw(SpriteBatch batch){
        pig.draw(batch);
    };
}
