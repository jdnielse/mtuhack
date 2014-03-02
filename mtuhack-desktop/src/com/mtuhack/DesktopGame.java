package com.mtuhack;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopGame {
        public static void main (String[] args) {
             new LwjglApplication(new Main(), "mtuhack", 1200, 600, false);
        }
}