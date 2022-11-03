package com.application.gUI.screens;

import java.io.IOException;

import javax.swing.*;

public class MainScreen {

    // #region Constants
    final int panWidth = 1000;
    final int panHeight = 600;
    final int uih = 25;
    final int admin = 1;
    final int customer = 0;
    final int adminsetX = 140;
    final int adminsetY = 520;
    final int adminoffsetX = adminsetX + 60;
    final int adminoffsetY = adminsetY + 9;
    
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
        //#endregion
        new LoginScreen(frame);
    }
    
    public static void main(String[] args) {
    	new MainScreen();
    }
    
    
    
    

}
