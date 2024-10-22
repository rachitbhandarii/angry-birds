package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Structure {
    ArrayList<Piggie> piggies;
    ArrayList<Material> materials;

    public Structure() {
        piggies = new ArrayList<>();
        materials = new ArrayList<>();
        test();
    }

    private void test(){
        materials.add(new Wood(8.2f,1));
        materials.add(new Stone(10.5f,1.05f));
        materials.add(new Glass(9.25f,1.05f));
        piggies.add(new Small(8.5f,3.25f));
        piggies.add(new Medium(10.85f,3.45f));
        piggies.add(new Large(9.51f,3.5f));
    }

    public void draw(SpriteBatch batch){
        for (Material material: materials){
            material.draw(batch);
        }
        for (Piggie piggie: piggies){
            piggie.draw(batch);
        }
        new Flower(6.25f, 0.8f, true).draw(batch);
        new Flower(12, 0.8f, false).draw(batch);
    }
}
