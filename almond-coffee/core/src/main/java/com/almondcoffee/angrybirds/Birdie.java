package com.almondcoffee.angrybirds;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Birdie {
    Sprite bird;
    float speed;
    Attack attack;
    Attack spAttack;
    Sound sound;

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
