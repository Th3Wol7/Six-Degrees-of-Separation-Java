package com.application.gUI.screens;

import java.io.IOException;

import javax.swing.*;

public class MainScreen {

	final int panWidth = 1000;
    final int panHeight = 600;
    final int uih = 25;
    final int newUserSetX = 140;
    final int newUserSetY = 520;
    final int newUserOffsetX = newUserSetX + 60;
    final int newUserOffsetY = newUserSetY + 9;

    private static JFrame frame;

      public MainScreen() {

        //Try Catch block For frame creation
        // Calls Function To create main background Plate 

        try {
            BaseScreen baseFrame = new BaseScreen();
            frame = baseFrame.getBaseFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new LoginScreen(frame);
    }
    
    public static void main(String[] args) {
    	new MainScreen();
    }
    
 
}
