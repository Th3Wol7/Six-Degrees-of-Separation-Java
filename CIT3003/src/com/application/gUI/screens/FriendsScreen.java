package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.application.utils.gUI.FrameUtility;

public class FriendsScreen extends JPanel implements ActionListener {
	private static Icon profileIcon;
	private static JLabel Logo;
	private JLabel titleLabel, friendsLabel, suggestionsLabel;
	private JButton removeBtn, addBtn;
	private JTextField lineSeparation;
	private JComboBox<String> friendList;
	private Font labelFont, fieldFont;
	private JPanel content;
	private JScrollPane tablePanel;
	private JTable suggestionTable;

	public FriendsScreen() {
		initializeComponents();
		addComponentsToPanel();
		setWindowProperties();
		registerListeners();
		// addActivities();
	}

	public void initializeComponents() {
		FrameUtility.addExitButton();
		FrameUtility.exitButton.setBounds(755, 0, 45, 45);
		FrameUtility.exitButton.setForeground(Color.BLACK);
		this.add(FrameUtility.exitButton);
		
		labelFont = new Font("Oswald", Font.TYPE1_FONT, 18);
		fieldFont = new Font("Oswald", Font.TYPE1_FONT, 15);
		Color buttonColour = new Color(224, 224, 224);
		
		content = new JPanel();
		content.setBounds(0, 305, 800, 230);
		
		
		titleLabel = new JLabel("My Friends", SwingConstants.CENTER);
		titleLabel.setBounds(280, 50, 200, 50);
		titleLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));

		lineSeparation = new JTextField(20);
		lineSeparation.setBounds(0, 100, 800, 25);// 125, 350, 250, uih
		lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
		lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
		lineSeparation.setBackground(null);
		lineSeparation.setCaretColor(Color.gray);

		friendsLabel = new JLabel("Friends", SwingConstants.LEFT);
		friendsLabel.setBounds(40, 150, 200, 50);
		friendsLabel.setFont(labelFont);

		friendList = new JComboBox<>(); // new GenerateFriendsList().getFriends()
		friendList.setFont(fieldFont);
		friendList.setBounds(200, 160, 230, 30);;
		friendList.setOpaque(false);
		friendList.setFocusable(false);

		suggestionsLabel = new JLabel("Suggestions", SwingConstants.LEFT);
		suggestionsLabel.setBounds(40, 255, 200, 50);
		suggestionsLabel.setFont(labelFont);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(550, 550, 120, 30);
		addBtn.setFont(labelFont);
		addBtn.setOpaque(true);
		addBtn.setBorderPainted(false);
		addBtn.setBackground(buttonColour);
		addBtn.setEnabled(false);
		addBtn.setFocusPainted(false);
		
		removeBtn = new JButton("remove");
		removeBtn.setBounds(550, 160, 120, 30);
		removeBtn.setFont(labelFont);
		removeBtn.setOpaque(true);
		removeBtn.setBorderPainted(false);
		removeBtn.setBackground(buttonColour);
		removeBtn.setEnabled(false);
		removeBtn.setFocusPainted(false);
		
		
		String columns[] = {"Tyrien", "Gilpin"};
        String data[][] = {{"Jamie Oliver"}, {"John Doe"}};
		
        suggestionTable = new JTable();    
        suggestionTable.setBounds(content.getBounds());  
        //suggestionTable.setShowGrid(true);
        //suggestionTable.setShowVerticalLines(true);        
        
        tablePanel = new JScrollPane();  
        tablePanel.getViewport().add(suggestionTable);
        tablePanel.setOpaque(false);
        tablePanel.getViewport().setOpaque(false);
        tablePanel.setBackground(getBackground());

        tablePanel.setBounds(content.getBounds());
        tablePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
        suggestionTable.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
        suggestionTable.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
        
        suggestionTable.setBackground(getBackground());
        suggestionTable.setShowGrid(false);
        suggestionTable.setShowHorizontalLines(true);

        suggestionTable.setFont(fieldFont);
        suggestionTable.setRowHeight(40);
        suggestionTable.setOpaque(false);
        suggestionTable.setEnabled(true);
	}

	// adding the components to the panel
	public void addComponentsToPanel() {
		content.add(tablePanel);
		this.add(titleLabel);
		this.add(friendsLabel);
		this.add(lineSeparation);
		this.add(friendsLabel);
		this.add(friendList);
		this.add(addBtn);
		this.add(content);
		this.add(suggestionsLabel);
		this.add(removeBtn);
	}

	// setting properties of panel
	public void setWindowProperties() {
		this.setSize(800, 600);
		this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
		this.setLayout(null);
	}

	// registering button listeners
	public void registerListeners() {
		addBtn.addActionListener(this);
		removeBtn.addActionListener(this);
	}

	// public void addActivities(){}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
