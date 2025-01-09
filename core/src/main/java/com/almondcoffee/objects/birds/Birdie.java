package com.almondcoffee.objects.birds;

import com.almondcoffee.attack.Attack;
import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;

public abstract class Birdie implements Serializable {
    transient protected Sprite bird;
    protected float speed;
    protected Attack attack;
    protected Attack spAttack;
    transient protected Sound sound;
    transient protected PhysicsExt physicsExt;
    private boolean isBird = true;
    private boolean isLaunched = false;
    protected float posX;
    protected float posY;

    public Birdie() {}

    public void setPosition(float x, float y){
        bird.setPosition(x, y);
        physicsExt.getBody().setTransform(x,y,0);
        this.posX = x;
        this.posY = y;
    }

    public void draw(SpriteBatch batch){
        bird.draw(batch);
    }

    public PhysicsExt getPhysicsExt() {
        return physicsExt;
    }

    public void setPhysicsExt(PhysicsExt physicsExt) {
        this.physicsExt = physicsExt;
    }

    public Sprite getBird() {
        return bird;
    }

    public void setBird(Sprite bird) {
        this.bird = bird;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Attack getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(Attack spAttack) {
        this.spAttack = spAttack;
    }

    public Sound getSound() {
        return sound;
    }

    public boolean getIsBird() {return isBird;}

    public void setIsBird(boolean isBird) {this.isBird = isBird;}

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public boolean isLaunched() { return isLaunched;}

    public void setLaunched(boolean isLaunched) {this.isLaunched = isLaunched;}
}
