package com.application.gUI.screens;

import javax.swing.*;

import com.application.gUI.utils.FrameUtility;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class UserScreen {
 final int panWidth = 1000;
 final int panHeight = 600;
 final int uih = 25;
 final int sideButtons = 220;

 private static Font Oswald;
 private static Color buttonColor;
 
 private static JPanel sidePanel;
 private static JPanel primaryPanel;
 private static JPanel userPanel;

 private static JLabel Logo;
 private static Icon defaultLogoIcon;

 private static JButton viewProfileButton;
 private static JButton friendsButton;
 private static JButton activitiesButton;
 private static JButton networkButton;
 private static JButton LogOutButton;
 private static JButton quitButton;
 
 private static JFrame parentFrame;

 public UserScreen( JFrame frame){
	 
	 frame.setShape(new RoundRectangle2D.Double(0, 0, panWidth, panHeight, 30, 30));
     frame.setSize(panWidth, panHeight);
     frame.setLayout(new BorderLayout());
     parentFrame = frame;
     Oswald = new Font("Oswald", Font.TYPE1_FONT, 15);

     // Assigns default image to variable
     defaultLogoIcon = new ImageIcon();
     Logo = new JLabel(defaultLogoIcon);
     buttonColor  = new Color(0,0,0);
     
     createPanel();
     configureButtons();
     addComponentsToPanels();
     registeringListeners(parentFrame);
     
   }

 public void createPanel() {
     userPanel = new JPanel();
     sidePanel = new JPanel();
     primaryPanel = new JPanel();

     
     //Setting panel background colour
     sidePanel.setBackground(new Color(65, 172, 158));
     sidePanel.setLayout(null);
     
     // sets layout to be null, to allow for free placement of JAttributes
     primaryPanel.setBackground(new Color(216, 227, 241));
     primaryPanel.setLayout(null);  
     
     userPanel.setBounds(0, 0, panWidth, panHeight);
     userPanel.setLocation(0, 0);
     userPanel.setSize(panWidth, panHeight);
     userPanel.setLayout(new BorderLayout());
     userPanel.setBackground(Color.black);
     
  
     FrameUtility.addExitButton();
     FrameUtility.exitButton.setBounds(755, 0, 45, 45);
     FrameUtility.exitButton.setForeground(buttonColor);
     primaryPanel.add(FrameUtility.exitButton); 
         
     //Sets size and location of logo
     Logo.setBounds(0, 0, 200, 150);

     //adding Logo to top of side panel
     sidePanel.add(Logo);
     
     //adds created panels to main Panel
     sidePanel.setPreferredSize(new Dimension(200, 600));
     userPanel.add(sidePanel, BorderLayout.WEST);

     primaryPanel.setPreferredSize(new Dimension(800, 600));
     userPanel.add(primaryPanel, BorderLayout.CENTER);
     
     parentFrame.add(userPanel);
 }

 //Setting up buttons and their properties
 public void configureButtons() {
     viewProfileButton = new JButton("PROFILE");
     viewProfileButton.setBounds(0, sideButtons-60, 200, 50);
     viewProfileButton.setOpaque(false);
     viewProfileButton.setFocusPainted(false);
     viewProfileButton.setContentAreaFilled(false);
     viewProfileButton.setForeground(Color.white);
     viewProfileButton.setFont(Oswald);
     viewProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     viewProfileButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
     
     friendsButton = new JButton("FRIENDS");
     friendsButton.setBounds(0, sideButtons+10, 200, 50);
     friendsButton.setOpaque(false);
     friendsButton.setFocusPainted(false);
     friendsButton.setContentAreaFilled(false);
     friendsButton.setForeground(Color.white);
     friendsButton.setFont(Oswald);
     friendsButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
     friendsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

     activitiesButton = new JButton("ACTIVITIES");
     activitiesButton.setBounds(0, sideButtons+85, 200, 50);
     activitiesButton.setOpaque(false);
     activitiesButton.setFocusPainted(false);
     activitiesButton.setContentAreaFilled(false);
     activitiesButton.setForeground(Color.white);
     activitiesButton.setFont(Oswald);
     activitiesButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
     activitiesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     
     networkButton = new JButton("NETWORK");
     networkButton.setBounds(0, sideButtons+160, 200, 50);
     networkButton.setOpaque(false);
     networkButton.setFocusPainted(false);
     networkButton.setContentAreaFilled(false);
     networkButton.setForeground(Color.white);
     networkButton.setFont(Oswald);
     networkButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
     networkButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     
     LogOutButton = new JButton("LOGOUT");
     LogOutButton.setBounds(0, sideButtons+240, 200, 50);
     LogOutButton.setOpaque(false);
     LogOutButton.setFocusPainted(false);
     LogOutButton.setContentAreaFilled(false);
     LogOutButton.setForeground(Color.white);
     LogOutButton.setFont(Oswald);
     LogOutButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
     LogOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         
     quitButton = new JButton("EXIT");
     quitButton.setBounds(0, sideButtons+310, 200, 50);
     quitButton.setOpaque(false);
     quitButton.setFocusPainted(false);
     quitButton.setContentAreaFilled(false);
     quitButton.setForeground(Color.white);
     quitButton.setFont(Oswald);
     quitButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
     quitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     
  }
 	
 private void addComponentsToPanels() {
	 sidePanel.add(viewProfileButton);
     sidePanel.add(friendsButton);
     sidePanel.add(activitiesButton);
     sidePanel.add(networkButton);
	 sidePanel.add(LogOutButton);
	 sidePanel.add(quitButton);
 }
 
 public void registeringListeners(JFrame frame) {
	 
	 viewProfileButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	 primaryPanel = new ShowProfile("jcar3").getProfilePanel();
        	 //userPanel.add(new ShowProfile("jcar3"), BorderLayout.CENTER);            
         }
     });
	 
	 friendsButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //showFriendsAndSuggestions();
         }
     });
	 
	 activitiesButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //showActivitiesAndSuggestions();
         }
     });
	 
     networkButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             //showNetwork();
         }
     });
     
     LogOutButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             frame.remove(userPanel);;
             new LoginScreen(frame);
         }
     });
     
     quitButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	 System.exit(0);
         }
     });
 }
 
}

