package com.application.gUI.screens;
/*This class represents the look, feel and fucntionality of the
 * GUI  Frame
 * @author Tyrien Gilpin
 * Version 1
 */

import com.application.utils.gUI.FrameUtility.FrameDragListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.Objects;


public class BaseScreen {

    //Constants used in defining the properties of the screen
    final int panWidth = 1000;
    final int panHeight = 600;

    private static JFrame frame;
    private static Image appIcon;

    public BaseScreen() throws IOException {

        //Setting properties of frame
        frame = new JFrame();

        appIcon = ImageIO.read(Objects.requireNonNull(getClass().getResource("./res/mainImage.png")));

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

        //Allows user to move frame around
        FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);

    }

    public JFrame getBaseFrame() {
        return frame;

    }

}
