package com.almondcoffee.support;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;

public class Trajectory extends ApplicationAdapter implements Serializable {
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private Vector2 slingPosition;
    private Vector2 dragPosition;
    private boolean isDragging;
    private final float gravity = -9.8f;

    @Override
    public void create() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false);

        shapeRenderer = new ShapeRenderer();

        slingPosition = new Vector2(390, 320);
        dragPosition = new Vector2(slingPosition);
        isDragging = false;
    }

    @Override
    public void render() {
        handleInput();

        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        drawTrajectory();
        shapeRenderer.end();
    }

    private void handleInput() {
        if (Gdx.input.isTouched()) {
            isDragging = true;
            dragPosition.set(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
        } else {
            isDragging = false;
        }
    }

    private void drawTrajectory() {
        if (!isDragging) return;

        shapeRenderer.setColor(Color.BLACK);

        Vector2 velocity = new Vector2(slingPosition.x - dragPosition.x, slingPosition.y - dragPosition.y);
        float timeStep = 0.3f;

        Vector2 currentPosition = new Vector2(slingPosition);
        Vector2 currentVelocity = new Vector2(velocity);

        for (int i = 0; i < 50; i++) {
            currentPosition.x += currentVelocity.x * timeStep;
            currentPosition.y += currentVelocity.y * timeStep;
            currentVelocity.y += gravity * timeStep;
            if (currentPosition.y < 0) break;
            shapeRenderer.circle(currentPosition.x, currentPosition.y, 3);
        }
    }

    public boolean getIsDragging(){return isDragging;}

    public Vector2 getSlingPosition(){return slingPosition;}
    public Vector2 getDragPosition(){return dragPosition;}

    @Override
    public void dispose() {
        camera = null;
        shapeRenderer.dispose();
    }
}
