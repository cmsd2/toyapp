package com.advancedtelematic.toyapp;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

public class MyToyApp extends Game {
    private MainScreen mainScreen;
    private AboutScreen aboutScreen;
    private GameScreen gameScreen;

    @Override
    public void create() {
        setScreen(getMainScreen());
    }

    public MainScreen getMainScreen() {
        if(mainScreen == null) {
            this.mainScreen = new MainScreen(this);
        }
        return mainScreen;
    }

    public AboutScreen getAboutScreen() {
        if(aboutScreen == null) {
            this.aboutScreen = new AboutScreen(this);
        }
        return aboutScreen;
    }

    public GameScreen getGameScreen() {
        if(gameScreen == null) {
            this.gameScreen = new GameScreen(this);
        }
        return gameScreen;
    }

}
