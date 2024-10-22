package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Material {
    Sprite material;

    public Material(){}

    public void setPosition(float x, float y){
        material.setCenter(x, y);
    }

    public void draw(SpriteBatch batch){
        material.draw(batch);
    }
}
