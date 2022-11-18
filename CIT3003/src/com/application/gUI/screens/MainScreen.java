package com.application.gUI.screens;

import java.io.IOException;

import javax.swing.JFrame;

import com.application.network.FindSeperation;

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
		/*NB: DO NOT PRESS THE BUTTONS ON THE FRIENDS SCREEN
			SURROUND THIS TEXT WITH COMMENT SPECIFIERS TO RUN
			THE FRIEND SCREEN DISPLAY IS WORKING, BUT THE BUTTONS AREN'T
			YOU MAY TEST THE DISPLAY BY INSERTING A USERNAME BEFORE LOGIN INTO 
		SYSTEM
		PS: GUI WILL TAKE A WHILE TO START UP BECAUSE FILE READING BE PATIENT
		*/
		
		// Try Catch block For frame creation
		// Calls Function To create main background Plate
		FindSeperation socialNet = new FindSeperation();
		socialNet.getSocialNet().createNetwork();
		try {
			BaseScreen baseFrame = new BaseScreen();
			frame = baseFrame.getBaseFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}

		new LoginScreen(frame, socialNet);
	}

	public static void main(String[] args) {
		new MainScreen();
	}

}
