package com.advancedtelematic.toyapp;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopStarter {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Title";
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 480;
        cfg.useCPUSynch = false;
        cfg.vSyncEnabled = true;
        new LwjglApplication(new MyToyApp(), cfg);
    }
}
