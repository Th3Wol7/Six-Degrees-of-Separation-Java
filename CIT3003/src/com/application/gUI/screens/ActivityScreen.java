package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.application.models.Person;
import com.application.utils.gUI.FrameUtility;

public class ActivityScreen extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel topPanel, suggestPanel, content;
	private JLabel code, fName, lName, suggestLabel, titleLabel;
	private JTextField lineSeparation,codeField, fNameField, lNameField;
	private TextArea area;
	private JButton add, remove;
	private JTable suggestionTable;
	private String user;
	private Person currentUser;
	
	ActivityScreen(String username){
		this.user = username;
		initializeComponents();
		addComponentsToPanel();
		addPanelToWindow();
		setWindowProperties();
		registerListeners();
	}
	public void initializeComponents() {
		FrameUtility.addExitButton();
		FrameUtility.exitButton.setBounds(755, 0, 45, 45);
		FrameUtility.exitButton.setForeground(Color.BLACK);
		this.add(FrameUtility.exitButton);
		
		titleLabel = new JLabel("Activities", SwingConstants.CENTER);
		titleLabel.setBounds(280, 20, 200, 50);
		titleLabel.setFont(new Font("arial", Font.BOLD, 35));
		
		lineSeparation = new JTextField(20);
		lineSeparation.setBounds(1, 60, 800, 25);// 125, 350, 250, uih
		lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
		lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
		lineSeparation.setBackground(null);
		lineSeparation.setCaretColor(Color.gray);
		
		code = new JLabel("UserName");
		codeField = new JTextField();
		code.setBounds(50,75,100,25);
		codeField.setBounds(75,75,150,25);
		code.setFont(new Font("arial", Font.BOLD, 16));
		codeField.setFont(new Font("arial", Font.BOLD, 14));
		
		topPanel = new JPanel(); // new GridLayout(0,1)
		topPanel.setBounds(25, 90, 750, 265);
		topPanel.setBackground(Color.BLUE);
		
		suggestPanel = new JPanel();
		suggestPanel.setBounds(25, 365, 750, 480);
		suggestPanel.setBackground(Color.yellow);
		
		
		
	}
	
	public void addComponentsToPanel() {
		this.add(titleLabel);
		this.add(lineSeparation);
		topPanel.add(code);
		topPanel.add(codeField);
	}
	public void addPanelToWindow() {
		this.add(topPanel);
		this.add(suggestPanel);
	}
	
	public void setWindowProperties() {
		this.setVisible(true);
		this.setSize(800, 600);
		this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
		this.setLayout(null);
	}
	public void registerListeners() {
		/*confirm.addActionListener(this);
		edit.addActionListener(this);
		cancel.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
