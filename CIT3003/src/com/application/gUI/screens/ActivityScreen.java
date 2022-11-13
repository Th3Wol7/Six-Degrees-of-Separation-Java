package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.application.gUI.utils.FrameUtility;

public class ActivityScreen extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static Icon profileIcon;
	private static JLabel Logo, suggestLabel;
	private JCheckBox volunteer,dance,run,shop,read, movie;
	private JPanel suggestPanel, topPanel,sidePanel;
	private JButton confirm, cancel,edit;
	private TextArea area;
	
	public ActivityScreen(){
		initializeComponents();
		addComponentsToPanel();
		addPanelToWindow();
		setWindowProperties();
		registerListeners();
		
	}
	public void initializeComponents(){
		
		FrameUtility.addExitButton();
		FrameUtility.exitButton.setBounds(755, 0, 45, 45);
		FrameUtility.exitButton.setForeground(Color.BLACK);
		this.add(FrameUtility.exitButton);
		
		volunteer = new JCheckBox("Volunteering");
		volunteer.setFont(new Font("arial", Font.PLAIN, 15));
		
		dance = new JCheckBox("Dancing");
		dance.setFont(new Font("arial", Font.PLAIN, 15));
		
		run = new JCheckBox("Running");
		run.setFont(new Font("arial", Font.PLAIN, 15));
		
		shop= new JCheckBox("Shopping");
		shop.setFont(new Font("arial", Font.PLAIN, 15));
		
		read = new JCheckBox("Reading");
		read.setFont(new Font("arial", Font.PLAIN, 15));
		
		movie = new JCheckBox("Movies");
		movie.setFont(new Font("arial", Font.PLAIN, 15));
		
		confirm = new JButton("Confirm");
		confirm.setPreferredSize(new Dimension(120, 30));
		confirm.setFont(new Font("arial", Font.PLAIN, 15));
		confirm.setFocusPainted(false);
		
		cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(120, 30));
		cancel.setFont(new Font("arial", Font.PLAIN, 15));
		cancel.setFocusPainted(false);
		
		edit = new JButton("Edit");
		edit.setPreferredSize(new Dimension(120, 30));
		edit.setFont(new Font("arial", Font.PLAIN, 15));
		edit.setFocusPainted(false);
		
		suggestLabel = new JLabel("Suggestions", SwingConstants.LEFT);
		suggestLabel.setFont(new Font("arial", Font.BOLD, 20));
        suggestLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		suggestLabel.setBounds(40, 255, 200, 50);
		
		area = new TextArea();
		area.setFont(new Font("arial", Font.BOLD, 14));
		area.setSize(175, 50);
		//area.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		topPanel = new JPanel(new GridLayout(1,0));
		sidePanel = new JPanel(new GridLayout(2,0));
		suggestPanel = new JPanel();
		
		
		
	}
	public void addComponentsToPanel(){
		topPanel.add(volunteer);
		topPanel.add(dance);
		topPanel.add(run);
		topPanel.add(shop);
		topPanel.add(read);
		topPanel.add(movie);
		topPanel.add(confirm);
		topPanel.add(edit);
		topPanel.add(cancel);
		sidePanel.add(area);
		//topPanel.add(suggestLabel);
		
	}
	public void addPanelToWindow() {
		this.add(topPanel);
		this.add(sidePanel);
	}
	public void setWindowProperties() {
		this.setVisible(true);
		this.setSize(800, 600);
		this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
		this.setLayout(null);
	}
	public void registerListeners() {
		confirm.addActionListener(this);
		edit.addActionListener(this);
		cancel.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(confirm)) {
			
			
		}
		if (e.getSource().equals(cancel)) {
			
		}
		if (e.getSource().equals(edit)) {
	
		}
	}

}
