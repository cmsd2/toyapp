package com.advancedtelematic.toyapp;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

public class MyToyApp extends Game {
    @Override
    public void create() {
        setScreen(new MainScreen());
    }
}
