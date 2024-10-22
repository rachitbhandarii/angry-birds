package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Catapult {
    Sprite catapult;

    public Catapult(){
        catapult = new Sprite(new Texture("catapultstretched.png"));
        catapult.setSize(1.5f,2.5f);
        catapult.setCenter(3.5f,2);
    }

    public void draw(SpriteBatch batch){
        catapult.draw(batch);
    }
}
