package com.almondcoffee.objects.pigs;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;

public abstract class Piggie implements Serializable {
    transient protected Sprite pig;
    protected float health;
    transient protected Sound sound;
    transient protected PhysicsExt physicsExt;
    protected float posX;
    protected float posY;

    public Piggie(){
        pig = new Sprite(new Texture("pig.png"));
    }

    public void setPosition(float x, float y){
        pig.setPosition(x, y);
        physicsExt.getBody().setTransform(x,y,0);
        this.posX = x;
        this.posY = y;
    }

    public void draw(SpriteBatch batch){
        pig.draw(batch);
    };

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public Sprite getPig() {
        return pig;
    }

    public void setPig(Sprite pig) {
        this.pig = pig;
    }

    public PhysicsExt getPhysicsExt() {
        return physicsExt;
    }

    public void setPhysicsExt(PhysicsExt physicsExt) {
        this.physicsExt = physicsExt;
    }


}
