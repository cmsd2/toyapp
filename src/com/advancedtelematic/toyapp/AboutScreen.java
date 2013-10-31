package com.advancedtelematic.toyapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AboutScreen extends AbstractScreen<MyToyApp> {

    public AboutScreen(MyToyApp app) {
        super(app);
    }

    @Override
    public void show() {
        super.show();
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
    public void resize(int width, int height) {
        super.resize(width, height);    //To change body of overridden methods use File | Settings | File Templates.

        Stage stage = getStage();
        Skin skin = getSkin();

        Label licenseLabel = new Label(Gdx.files.internal("freebsd_license.txt").readString("UTF-8"), skin);

        ScrollPane pane = new ScrollPane(licenseLabel);
        pane.setFillParent(true);

        stage.addActor(pane);
    }
}
