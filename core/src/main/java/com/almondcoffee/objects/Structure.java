package com.almondcoffee.objects;

import com.almondcoffee.objects.materials.Glass;
import com.almondcoffee.objects.materials.Material;
import com.almondcoffee.objects.materials.Stone;
import com.almondcoffee.objects.materials.Wood;
import com.almondcoffee.objects.pigs.Large;
import com.almondcoffee.objects.pigs.Medium;
import com.almondcoffee.objects.pigs.Piggie;
import com.almondcoffee.objects.pigs.Small;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;
import java.util.ArrayList;

public class Structure implements Serializable {

    private ArrayList<Piggie> piggies;
    private ArrayList<Material> materials;
    private ArrayList<Flower> flowers;

    public Structure(int lvl) {
        piggies = new ArrayList<>();
        materials = new ArrayList<>();
        flowers = new ArrayList<>();
        level(lvl);
    }

    private void level(int lvl){
        switch(lvl){
            case 1:
                materials.add(new Wood(9.75f,1.26f));
                materials.add(new Stone(12.3f,1.26f));
                materials.add(new Glass(11,3, true));
                //piggies.add(new Small(11.2f,1.5f));
                //piggies.add(new Medium(14,1.6f));
                piggies.add(new Large(10.3f,4.1f));
                break;
            case 2:
                materials.add(new Wood(8,1.26f));
                materials.add(new Stone(10.5f,1.26f));
                materials.add(new Glass(9.1f,3, true));
                materials.add(new Wood(13,1.26f));
                materials.add(new Glass(11.87f,3, true));
                //piggies.add(new Small(9.5f,3.9f));
                piggies.add(new Large(9.4f,4.75f));
                piggies.add(new Medium(12,4.75f));
                //piggies.add(new Small(12.05f,1.55f));
                //piggies.add(new Large(14.5f,1.75f));
                break;
            case 3:
                materials.add(new Wood(8,1.26f));
                materials.add(new Stone(10.5f,1.26f));
                materials.add(new Glass(9.1f,3, true));
                materials.add(new Wood(13,1.26f));
                materials.add(new Glass(11.87f,3, true));
                piggies.add(new Small(9.5f,4.9f));
                piggies.add(new Large(9.4f,4.75f));
                piggies.add(new Medium(12,4.75f));
                piggies.add(new Small(8.2f,5.9f));
                piggies.add(new Small(10.5f,5.1f));
                //piggies.add(new Small(12.05f,1.55f));
                //piggies.add(new Large(14.5f,7.75f));
                break;
        }
    }

    public void draw(SpriteBatch batch){
        for (Material material: materials){
            material.draw(batch);
        }
        for (Piggie piggie: piggies){
            piggie.draw(batch);
        }
        for (Flower flower: flowers){
            flower.draw(batch);
        }
    }

    public ArrayList<Piggie> getPiggies() {
        return piggies;
    }

    public void setPiggies(ArrayList<Piggie> piggies) {
        this.piggies = piggies;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

}
