package com.almondcoffee.objects;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;

public class Flower implements Serializable {
    private Sprite flower;
    transient private PhysicsExt physicsExt;
    private boolean isOpen;
    private float timer;
    private Object contained;
    protected float posX;
    protected float posY;

    public Flower(){
        flower = new Sprite(new Texture("flower.png"));
        flower.setSize(1.25f, 1.25f);
    }

    public Flower(float x, float y, boolean rotate){
        flower = new Sprite(new Texture("flower.png"));
        flower.setSize(1.25f, 1.25f);
        flower.setPosition(x, y);
        if (!rotate) flower.rotate90(rotate);
    }

    public void setContained(Object contained) {
        this.contained = contained;
    }

    public void setPosition(float x, float y){
        flower.setCenter(x, y);
    }

    public void draw(SpriteBatch batch){
        flower.draw(batch);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Sprite getFlower() {
        return flower;
    }

    public void setFlower(Sprite flower) {
        this.flower = flower;
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }

    public Object getContained() {
        return contained;
    }


    public PhysicsExt getPhysicsExt() {
        return physicsExt;
    }

    public void setPhysicsExt(PhysicsExt physicsExt) {
        this.physicsExt = physicsExt;
    }


}
