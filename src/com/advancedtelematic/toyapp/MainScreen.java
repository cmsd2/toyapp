package com.advancedtelematic.toyapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainScreen extends AbstractScreen<MyToyApp> {
    // constant useful for logging

    // a libgdx helper class that logs the current FPS each second
    private static final float BUTTON_WIDTH = 300f;
    private static final float BUTTON_HEIGHT = 60f;
    private static final float BUTTON_SPACING = 10f;

    public MainScreen(MyToyApp app) {
        super(app);
    }

    @Override
    public void show()
    {
        super.show();
    }

    @Override
    public void hide()
    {
        super.hide();
    }

    @Override
    public void resize(
            int width,
            int height )
    {
        super.resize(width, height);

        Skin skin = getSkin();
        Stage stage = getStage();

        // create the table actor
        Table table = new Table( getSkin() );
        table.setSize(width, height);

        // add the table to the stage and retrieve its layout
        stage.addActor(table);
        //TableLayout layout = table.getTableLayout();

        // [edit] this section is not needed
        // register the label "welcome"
        // Label welcomeLabel = new Label( "Welcome to Tyrian for Android!", skin );
        // layout.register( "welcomeMessage", welcomeLabel );

        // register the button "start game"
        TextButton startGameButton = new TextButton( "Start game", skin );

        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y)
            {
                app.setScreen( app.getGameScreen() );
            }
        });
        table.add(startGameButton).pad(10);
        table.row();

        // register the button "options"
        TextButton optionsButton = new TextButton( "About", skin );
        optionsButton.addListener( new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y)
            {
                Gdx.app.log( MainScreen.this.LOG, "About button clicked" );
                app.setScreen( app.getAboutScreen() );
            }
        } );
        table.add(optionsButton).pad(10);
        table.row();
    }

    @Override
    public void render(float delta)
    {
        super.render(delta);
    }

    @Override
    public void pause()
    {
        super.pause();
    }

    @Override
    public void resume()
    {
        super.resume();
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
