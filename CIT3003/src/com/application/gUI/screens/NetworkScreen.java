package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.application.models.Person;
import com.application.network.FindSeperation;
import com.application.utils.gUI.FrameUtility;

public class NetworkScreen extends JPanel implements ActionListener {
	private static Icon profileIcon;
	private static JLabel Logo;
	private JLabel titleLabel, averageLabel, separationLabel;
	private JButton searchBtn;
	private JTextField lineSeparation, averageField;
	private JTextArea info;
	private JComboBox<String> friendsList;
	private Font labelFont, fieldFont;
	private String username;
	private FindSeperation networkService = new FindSeperation();
	
	public NetworkScreen(String username) {
		this.username = username;
		initializeComponents();
		addComponentsToPanel();
		setWindowProperties();
		registerListeners();
	}

	public void initializeComponents() {
		// profileIcon = new ImageIcon(new
		// ImageIcon(ShowProfile.class.getResource("image file path here")).getImage()
		// .getScaledInstance(100, 60, Image.SCALE_DEFAULT));
		// Logo = new JLabel(profileIcon);
		
		labelFont = new Font("Oswald", Font.TYPE1_FONT, 18);
		fieldFont = new Font("Oswald", Font.TYPE1_FONT, 15);
		Color buttonColour = new Color(224, 224, 224);
		
		FrameUtility.addExitButton();
		FrameUtility.exitButton.setBounds(755, 0, 45, 45);
		FrameUtility.exitButton.setForeground(Color.BLACK);
		this.add(FrameUtility.exitButton);
		fieldFont = new Font("Oswald", Font.TYPE1_FONT, 15);
		labelFont = new Font("Oswald", Font.TYPE1_FONT, 16);

		titleLabel = new JLabel("Network", SwingConstants.CENTER);
		titleLabel.setBounds(280, 50, 200, 50);
		titleLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));
		
		lineSeparation = new JTextField(20);
		lineSeparation.setBounds(0, 100, 800, 25);// 125, 350, 250, uih
		lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
		lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
		lineSeparation.setBackground(null);
		lineSeparation.setCaretColor(Color.gray);

		averageLabel = new JLabel("Average Degree of seperation in network", SwingConstants.LEFT);
		averageLabel.setBounds(40, 150, 350, 50);
		averageLabel.setFont(labelFont);
		
		averageField = new JTextField(20);
		averageField.setBounds(400, 160, 200, 30);
		averageField.setFont(fieldFont);
		averageField.setHorizontalAlignment(SwingConstants.CENTER);
		averageField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		averageField.setBackground(null);
		averageField.setForeground(Color.black);
		averageField.setCaretColor(Color.black);
		//averageField.setText(String.valueOf(getNetworkService().averageDegreeOfSeperation()));
		
		separationLabel = new JLabel("Find Seperation between you and", SwingConstants.LEFT);
		separationLabel.setBounds(40, 255, 280, 50);
		separationLabel.setFont(labelFont);
		
		friendsList = new JComboBox<>(); // new GenerateFriendsList().getFriends()
		friendsList.setFont(fieldFont);
		friendsList.setBounds(310, 268, 230, 30);;
		friendsList.setOpaque(false);
		friendsList.setFocusable(false);
		
		
		info = new JTextArea();
		info.setBounds(40, 330, 700, 250);
		info.setFont(fieldFont);
		info.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
		info.setBackground(null);
		info.setForeground(Color.black);
		info.setCaretColor(Color.black);
		
		searchBtn = new JButton("search");
		searchBtn.setBounds(580, 268, 120, 30);
		searchBtn.setFont(labelFont);
		searchBtn.setOpaque(true);
		searchBtn.setBorderPainted(false);
		searchBtn.setBackground(buttonColour);
		searchBtn.setEnabled(false);
		searchBtn.setFocusPainted(false);
	}

	public void addComponentsToPanel() {
		this.add(titleLabel);
		this.add(lineSeparation);
		this.add(averageLabel);
		this.add(averageField);
		this.add(separationLabel);
		this.add(friendsList);
		this.add(searchBtn);
		this.add(info);
	}

	public void setWindowProperties() {
		this.setSize(800, 600);
		this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
		this.setLayout(null);
	}


	public void registerListeners() {
		searchBtn.addActionListener(this);
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public FindSeperation getNetworkService() {
		return networkService;
	}

	public void setNetworkService(FindSeperation networkService) {
		this.networkService = networkService;
	}
	
	
	public void displaySeparation() {
		Person currentUser, searchValue;
		List<Person> users = new ArrayList<>();
		Set<Map.Entry<Person, Collection<Person>>> entries = getNetworkService().getSocialNet().getNetwork().entrySet();
		entries.forEach(entry -> {
			if(entry.getKey().getUsername().equals(username)) { 
				Person user = entry.getKey();
				users.add(user);
			}
		});
		entries.forEach(entry -> {
			if(entry.getKey().getUsername().equals(friendsList.getSelectedItem())) { 
				Person user = entry.getKey();
				users.add(user);
			}
		});
		
		currentUser = users.get(0);
		searchValue = users.get(1);
		//NTS: Check fix this to display data in textArea on screen
		getNetworkService().degreeOfSeperation(currentUser, searchValue);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchBtn) {
			///displaySeparation
		}
	}

}
