package com.almondcoffee.angrybirds;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Material {
    protected Sprite material;
    protected float strength;
    protected Sound sound;

    public Material(){}

    public void setPosition(float x, float y){
        material.setCenter(x, y);
    }

    public void draw(SpriteBatch batch){
        material.draw(batch);
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public Sprite getMaterial() {
        return material;
    }

    public void setMaterial(Sprite material) {
        this.material = material;
    }

}
