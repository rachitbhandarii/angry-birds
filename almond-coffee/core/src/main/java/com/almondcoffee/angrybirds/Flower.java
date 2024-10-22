package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Flower {
    Sprite flower;

    public Flower(){
        flower = new Sprite(new Texture("flower.png"));
        flower.setSize(1.25f, 1.25f);
    }

    public Flower(float x, float y, boolean rotate){
        flower = new Sprite(new Texture("flower.png"));
        flower.setSize(1.25f, 1.25f);
        flower.setPosition(x, y);
        if (!rotate) flower.rotate90(rotate);
    }

    public void setPosition(float x, float y){
        flower.setCenter(x, y);
    }

    public void draw(SpriteBatch batch){
        flower.draw(batch);
    }

}
