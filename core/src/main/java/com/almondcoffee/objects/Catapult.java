package com.almondcoffee.objects;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;

public class Catapult implements Serializable {
    private Sprite catapult;
    private float pullBackStrength;
    private float angle;

    public Catapult(){
        catapult = new Sprite(new Texture("catapultstretched.png"));
        catapult.setSize(1.5f,2.5f);
        catapult.setCenter(3.5f,2.5f);
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



}
