package com.application.gUI.screens;

import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class BaseScreen {

	//Constants used in defining the properties of the screen
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
    private static Image appIcon;

    public BaseScreen() throws IOException {

    	//Setting properties of frame
        frame = new JFrame();
        
        appIcon = ImageIO.read(getClass().getResource("logo5.jpg"));

        frame.setIconImage(appIcon); //Sets icon of application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.setBackground(null);
        
        // Removes title bar, rounds the edge of the frame and sets default size
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, panWidth, panHeight, 30, 30));
        frame.setSize(panWidth, panHeight);
        
        //sets Pop up location of frame to center of the screen and make visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JFrame getBaseFrame() {
        return frame;

    }

}
