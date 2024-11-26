package com.almondcoffee.angrybirds;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Piggie {
    protected Sprite pig;
    protected float health;
    protected Sound sound;

    public Piggie(){
        pig = new Sprite(new Texture("pig.png"));
    }

    public void setPosition(float x, float y){
        pig.setCenter(x, y);
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

}
