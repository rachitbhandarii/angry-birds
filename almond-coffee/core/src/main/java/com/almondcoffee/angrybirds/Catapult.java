package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Catapult {
    Sprite catapult;
    float pullBackStrength;
    float angle;

    public Catapult(){
        catapult = new Sprite(new Texture("catapultstretched.png"));
        catapult.setSize(1.5f,2.5f);
        catapult.setCenter(3.5f,2);
    }

    public void draw(SpriteBatch batch){
        catapult.draw(batch);
    }

    public float getPullBackStrength() {
        return pullBackStrength;
    }

    public void setPullBackStrength(float pullBackStrength) {
        this.pullBackStrength = pullBackStrength;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public Sprite getCatapult() {
        return catapult;
    }

    public void setCatapult(Sprite catapult) {
        this.catapult = catapult;
    }

}
