package com.almondcoffee.support;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.math.MathUtils;

import java.io.Serializable;

public class PhysicsExt {
    transient private World world;
    transient private Body body;
    transient private Vector2 velocity;
    transient private Vector2 position;

    public PhysicsExt(Sprite sprite, World world, boolean dynamic,float shift) {
        this.world = world;
        BodyDef bodyDef = new BodyDef();
        if (dynamic) bodyDef.type = BodyDef.BodyType.DynamicBody;
        else bodyDef.type = BodyDef.BodyType.StaticBody;
        if (shift!=0) bodyDef.position.set(sprite.getX()+sprite.getWidth() / 2, sprite.getY());
        else bodyDef.position.set(sprite.getX()+sprite.getWidth() / 2, sprite.getY()+sprite.getHeight() / 2);
        body = world.createBody(bodyDef);
        float initialAngle = sprite.getRotation() * MathUtils.degreesToRadians;  // Convert sprite's rotation to radians
        body.setTransform(body.getPosition(), initialAngle);
        PolygonShape shape = new PolygonShape();
        if (shift!=0) shape.setAsBox(sprite.getWidth() / 2, shift);
        else shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 100f;
        fixtureDef.restitution = 0.005f;

        body.createFixture(fixtureDef);
        shape.dispose();
    }

    public World getWorld() {return world;}

    public void setWorld(World world) {this.world = world;}

    public Body getBody() {return body;}

    public void setBody(Body body) {this.body = body;}

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void updateSpritePosition(Sprite sprite) {
        sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
        sprite.setPosition(body.getPosition().x-sprite.getWidth()/2, body.getPosition().y-sprite.getHeight()/2);
    }

    public void dispose(){
        world.destroyBody(body);
    }
}
