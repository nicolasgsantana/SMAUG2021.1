package com.neterusgames.entities.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.neterusgames.entities.BaseEntity;

public class Rock extends BaseEntity {

    private float frameTime = 0.25f;
    private float stateTime;
    private boolean remove = false;

    private Animation<TextureRegion> animation;

    public Rock(float x, float y){
        super(x, y);

        if(getTexture() == null){
            setTexture(new Texture("entities/rock.png"));
        }

        setWidth(24);
        setHeight(24);

        setRectangle(getX(),getY(),getWidth(),getHeight());

        animation = createAnimation(frameTime);

        setSpeed(350);

    }

    public void update(float deltaTime) {
        setY(getY() - getSpeed()*deltaTime);
        if(getY() < -getHeight()){
            remove = true;
        }

        moveRectangle(getCenterX(),getCenterY());

        stateTime += deltaTime;

    }

    public void render(SpriteBatch batch) {
        batch.draw(animation.getKeyFrame(stateTime,true), getX(), getY(), getWidth(), getHeight());
    }

    public boolean isRemove() {
        return remove;
    }
}