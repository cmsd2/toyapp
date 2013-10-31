package com.advancedtelematic.toyapp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;

public class MainScreen implements Screen {
    // constant useful for logging
    public static final String LOG = MainScreen.class.getSimpleName();

    // a libgdx helper class that logs the current FPS each second
    private FPSLogger fpsLogger;

    @Override
    public void show()
    {
        Gdx.app.log( MainScreen.LOG, "Showing main screen" );
        fpsLogger = new FPSLogger();
    }

    @Override
    public void hide()
    {
        Gdx.app.log( MainScreen.LOG, "Hiding main screen" );
    }

    @Override
    public void resize(
            int width,
            int height )
    {
        Gdx.app.log( MainScreen.LOG, "Resizing game to: " + width + " x " + height );
    }

    @Override
    public void render(float delta)
    {
        // the following code clears the screen with the given RGB color (green)
        Gdx.gl.glClearColor( 0f, 1f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        // output the current FPS
        fpsLogger.log();
    }

    @Override
    public void pause()
    {
        Gdx.app.log( MainScreen.LOG, "Pausing game" );
    }

    @Override
    public void resume()
    {
        Gdx.app.log( MainScreen.LOG, "Resuming game" );
    }

    @Override
    public void dispose()
    {
        Gdx.app.log( MainScreen.LOG, "Disposing game" );
    }
}
