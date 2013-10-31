package com.advancedtelematic.toyapp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class AbstractScreen<G extends Game> implements Screen {

    public final String LOG;
    protected final G app;
    private final Stage stage;
    protected final FPSLogger fpsLogger;

    private Skin skin;
    private BitmapFont font;
    private SpriteBatch batch;

    public AbstractScreen(G app) {
        this.LOG = getName();
        this.app = app;
        this.stage = new Stage( 0, 0, true );
        this.fpsLogger = new FPSLogger();
    }

    protected String getName() {
        return getClass().getSimpleName();
    }

    protected Stage getStage() {
        return stage;
    }

    public BitmapFont getFont()
    {
        if( font == null ) {
            font = new BitmapFont();
        }
        return font;
    }

    public SpriteBatch getBatch()
    {
        if( batch == null ) {
            batch = new SpriteBatch();
        }
        return batch;
    }

    protected Skin getSkin()
    {
        if( skin == null ) {
            TextureAtlas atlas;
            atlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));
            skin = new Skin( Gdx.files.internal( "uiskin.json" ), atlas );
        }
        return skin;
    }

    protected void setSkin(Skin skin) {
        this.skin = skin;
    }

    @Override
    public void show() {
        Gdx.app.log(this.LOG, "Showing screen");
        Gdx.input.setCatchBackKey(false);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act( delta );

        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        stage.draw();

        fpsLogger.log();
    }

    @Override
    public void hide() {
        Gdx.app.log(this.LOG, "Hiding screen");
    }

    @Override
    public void pause() {
        Gdx.app.log( this.LOG, "Pausing game");
    }

    @Override
    public void resume() {
        Gdx.app.log( this.LOG, "Resuming game" );
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log( this.LOG, "Resizing game to: " + width + " x " + height );

        stage.setViewport(width, height, true);
        stage.clear();
    }

    @Override
    public void dispose()
    {
        Gdx.app.log( this.LOG, "Disposing game" );
        stage.dispose();
        if( font != null ) font.dispose();
        if( batch != null ) batch.dispose();
        if( skin != null ) skin.dispose();
    }
}