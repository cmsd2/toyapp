package com.advancedtelematic.toyapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.Random;

public class GameScreen extends AbstractScreen<MyToyApp> {

    static final float TAU = (float)java.lang.Math.PI * 2;
    float x;
    float y;
    float vx;
    float vy;
    Random r;

    public GameScreen(MyToyApp app) {
        super(app);
        this.r = new Random();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void show() {
        super.show();

        this.x = r.nextFloat();
        this.y = r.nextFloat();
        float angle = r.nextFloat() * 2 * 3.14159f;
        this.vx = (float)java.lang.Math.cos(angle);
        this.vy = (float)java.lang.Math.sin(angle);

        //todo instead of going back to main menu, pause the game with pause screen?
        Gdx.input.setCatchBackKey(true);
        getStage().addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                if (keycode == Input.Keys.BACK || keycode == Input.Keys.ESCAPE) {
                    app.setScreen(app.getMainScreen());
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Override
    public void resize(final int width, final int height) {
        super.resize(width, height);

        Stage stage = getStage();

        Image image = new Image(new Texture(Gdx.files.internal("block.png")));

        image.setPosition(x * (width - image.getWidth()), y * (height - image.getHeight()));

        image.addAction(new Action() {
            @Override
            public boolean act(float delta) {
                x += vx * delta / 2;
                y += vy * delta / 2;

                if(x > 1) {
                    vx = -vx;
                    x = 2 - x;
                } else if(x < 0) {
                    vx = -vx;
                    x *= -1;
                }
                if(y > 1) {
                    vy = -vy;
                    y = 2 - y;
                } else if(y < 0) {
                    vy = -vy;
                    y *= -1;
                }

                this.actor.setPosition(x * (width - actor.getWidth()), y * (height - actor.getHeight()));
                return false;
            }
        });

        stage.addActor(image);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
}
