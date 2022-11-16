package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.application.models.Person;
import com.application.network.FindSeperation;
import com.application.utils.gUI.FrameUtility;

public class ActivityScreen  extends JPanel implements ActionListener {
	private static Icon profileIcon;
	private static JLabel Logo;
	private JLabel titleLabel, userActivitiesLabel, userDefinedLabel;
	private JButton saveBtn, cancelBtn;
	private JTextField lineSeparation, userDefinedField;
	private Font labelFont, fieldFont;
	private FindSeperation networkService = new FindSeperation();
	private Person user;
	
	
	
	public ActivityScreen(Person user) {
		this.user = user;
		initializeComponents();
		addComponentsToPanel();
		setWindowProperties();
		registerListeners();
		
	}

	
	public void initializeComponents() {		
		FrameUtility.addExitButton();
		FrameUtility.exitButton.setBounds(755, 0, 45, 45);
		FrameUtility.exitButton.setForeground(Color.BLACK);
		this.add(FrameUtility.exitButton);
		
		labelFont = new Font("Oswald", Font.TYPE1_FONT, 18);
		fieldFont = new Font("Oswald", Font.TYPE1_FONT, 15);
		Color buttonColour = new Color(224, 224, 224);

		titleLabel = new JLabel("My Activity", SwingConstants.CENTER);
		titleLabel.setBounds(280, 50, 200, 50);
		titleLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));

		lineSeparation = new JTextField(20);
		lineSeparation.setBounds(0, 100, 800, 25);// 125, 350, 250, uih
		lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
		lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
		lineSeparation.setBackground(null);
		lineSeparation.setCaretColor(Color.gray);
		
		userActivitiesLabel = new JLabel("Activity Checklist", SwingConstants.LEFT);
		userActivitiesLabel.setBounds(40, 150, 200, 50);
		userActivitiesLabel.setFont(labelFont);

		userDefinedLabel = new JLabel("Add your own activity:", SwingConstants.LEFT);
		userDefinedLabel.setBounds(40, 355, 200, 50);
		userDefinedLabel.setFont(labelFont);
		
		userDefinedField = new JTextField(25);
		userDefinedField.setBounds(300, 370, 250, 25);
		userDefinedField.setHorizontalAlignment(SwingConstants.CENTER);
		userDefinedField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
		userDefinedField.setBackground(null);
		userDefinedField.setForeground(Color.black);
		userDefinedField.setFont(fieldFont);
		userDefinedField.setCaretColor(Color.BLACK);
		userDefinedField.setEditable(true);
		
		saveBtn = new JButton("Save");
		saveBtn.setBounds(450, 530, 120, 30);
		saveBtn.setFont(labelFont);
		saveBtn.setOpaque(true);
		saveBtn.setBorderPainted(false);
		saveBtn.setBackground(new Color(224, 224, 224));
		saveBtn.setFocusPainted(false);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(590, 530, 120, 30);
		cancelBtn.setFont(labelFont);
		cancelBtn.setOpaque(true);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBackground(new Color(224, 224, 224));
		cancelBtn.setFocusPainted(false);
	}

	// adding the components to the panel
	public void addComponentsToPanel() {
		this.add(titleLabel);
		this.add(lineSeparation);
		this.add(userActivitiesLabel);
		this.add(userDefinedLabel);
		this.add(userDefinedField);
		this.add(saveBtn);
		this.add(cancelBtn);
	}
	
	public void setWindowProperties() {
		this.setSize(800, 600);
		this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
		this.setLayout(null);
	}
	
	public void registerListeners() {
		saveBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
