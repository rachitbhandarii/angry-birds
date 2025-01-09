package com.almondcoffee.objects.materials;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;

public abstract class Material implements Serializable {
    transient protected Sprite material;
    protected float strength;
    transient protected Sound sound;
    transient protected PhysicsExt physicsExt;
    protected float posX;
    protected float posY;

    public Material(){}

    public void setPosition(float x, float y){
        material.setPosition(x, y);
        physicsExt.getBody().setTransform(x,y,0);
        this.posX = x;
        this.posY = y;
    }

    public void draw(SpriteBatch batch){
        material.draw(batch);
    }

    public PhysicsExt getPhysicsExt() {
        return physicsExt;
    }

    public void setPhysicsExt(PhysicsExt physicsExt) {
        this.physicsExt = physicsExt;
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
