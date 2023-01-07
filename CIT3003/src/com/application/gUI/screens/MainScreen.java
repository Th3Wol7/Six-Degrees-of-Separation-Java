package com.application.gUI.screens;
/*This class domain class in which the application runs
 * @author Tyrien Gilpin
 * Version 1
 */

import java.io.IOException;

import javax.swing.JFrame;

import com.application.network.FindSeperation;

public class MainScreen {
	private static JFrame frame;

	public MainScreen() {
		
		// Try Catch block For frame creation
		// Calls Function To create main background Plate
		FindSeperation socialNet = new FindSeperation();
		//socialNet.getSocialNet().createNetwork();
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
