package com.almondcoffee.angrybirds;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Birdie {
    protected Sprite bird;
    protected float speed;
    protected Attack attack;
    protected Attack spAttack;
    protected Sound sound;
    protected Vector2 velocity = new Vector2();
    protected Vector2 acceleration = new Vector2(0, -9.8f); // Gravity
    protected boolean launched = false;

    public Birdie() {}

    public void setPosition(float x, float y){
        bird.setCenter(x, y);
    }

    public void draw(SpriteBatch batch){
        bird.draw(batch);
    }

    public void load(){

    }

    public void fly(){

    }

    public void collide(){

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

    public void setSound(Sound sound) {
        this.sound = sound;
    }
}
