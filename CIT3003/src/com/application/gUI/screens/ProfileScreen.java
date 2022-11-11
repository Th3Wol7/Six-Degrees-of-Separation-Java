package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.application.gUI.utils.FrameUtility;
import com.application.models.Person;

@SuppressWarnings("serial")
public class ProfileScreen extends JPanel implements ActionListener {
	private static Icon profileIcon;
	private static JLabel Logo;
	private JLabel titleLabel, usernameLabel, firstNameLabel,lastNameLabel; 
	private JLabel phoneLabel, emailLabel, communityLabel, schoolLabel, employerLabel, privacyLabel;
	private JTextField usernameField, firstNameField, lastNameField; 
	private JTextField phoneField, emailField, communityField, schoolField, employerField;
	private JTextField lineSeparation;
	private JRadioButton yesBtn, noBtn;
	private JButton editBtn, saveBtn, cancelBtn;
	private ButtonGroup buttonGroup;
	private String user;
	private Person currentUser;

	public ProfileScreen(String username) {
		this.user = username;
		initializeComponents();
		addComponentsToPanel();
		setWindowProperties();
		registerListeners();
		// setupProfile();
	}

	public void initializeComponents() {
	
		// profileIcon = new ImageIcon(new
		// ImageIcon(ShowProfile.class.getResource("image file path here")).getImage()
		// .getScaledInstance(100, 60, Image.SCALE_DEFAULT));
		// Logo = new JLabel(profileIcon);
		FrameUtility.addExitButton();
		FrameUtility.exitButton.setBounds(755, 0, 45, 45);
		FrameUtility.exitButton.setForeground(Color.BLACK);
		this.add(FrameUtility.exitButton);
		
		titleLabel = new JLabel("My Profile", SwingConstants.CENTER);
		titleLabel.setBounds(280, 50, 200, 50);
		titleLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));

		usernameLabel = new JLabel("Username", SwingConstants.LEFT);
		usernameLabel.setBounds(40, 150, 200, 50);
		usernameLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		firstNameLabel = new JLabel("Firstname", SwingConstants.LEFT);
		firstNameLabel.setBounds(40, 235, 200, 50);
		firstNameLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		lastNameLabel = new JLabel("Lastname", SwingConstants.LEFT);
		lastNameLabel.setBounds(430, 235, 200, 50);
		lastNameLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		phoneLabel = new JLabel("Telephone");
		phoneLabel.setBounds(430, 405, 200, 50);
		phoneLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(430, 150, 200, 50);
		emailLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		communityLabel = new JLabel("Community");
		communityLabel.setBounds(430, 320, 200, 50);
		communityLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		schoolLabel = new JLabel("Education", SwingConstants.LEFT);
		schoolLabel.setBounds(40, 320, 200, 50);
		schoolLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		employerLabel = new JLabel("Employer");
		employerLabel.setBounds(40, 405, 200, 50);
		employerLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		privacyLabel = new JLabel("Privacy");
		privacyLabel.setBounds(40, 490, 200, 50);
		privacyLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));
		
		lineSeparation = new JTextField(20);
		lineSeparation.setBounds(0, 100, 800, 25);//125, 350, 250, uih
		lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
		lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
		lineSeparation.setBackground(null);
		lineSeparation.setCaretColor(Color.gray);
        
        
		usernameField = new JTextField(20);
		usernameField.setBounds(40, 190, 250, 25);// 125, 350, 250, uih
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		usernameField.setBackground(null);
		usernameField.setForeground(Color.white);
		usernameField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		usernameField.setCaretColor(Color.white);

		firstNameField = new JTextField(30);
		firstNameField.setBounds(40, 275, 250, 25);// 125, 350, 250, uih
		firstNameField.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		firstNameField.setBackground(null);
		firstNameField.setForeground(Color.white);
		firstNameField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		firstNameField.setCaretColor(Color.white);

		lastNameField = new JTextField(30);
		lastNameField.setBounds(430, 275, 250, 25);// 125, 350, 250, uih
		lastNameField.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		lastNameField.setBackground(null);
		lastNameField.setForeground(Color.white);
		lastNameField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		lastNameField.setCaretColor(Color.white);

		phoneField = new JTextField(20);
		phoneField.setBounds(430, 445, 250, 25);// 125, 350, 250, uih
		phoneField.setHorizontalAlignment(SwingConstants.CENTER);
		phoneField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		phoneField.setBackground(null);
		phoneField.setForeground(Color.white);
		phoneField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		phoneField.setCaretColor(Color.white);

		emailField = new JTextField(30);
		emailField.setBounds(430, 190, 250, 25);// 125, 350, 250, uih
		emailField.setHorizontalAlignment(SwingConstants.CENTER);
		emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		emailField.setBackground(null);
		emailField.setForeground(Color.white);
		emailField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		emailField.setCaretColor(Color.white);

		communityField = new JTextField(30);
		communityField.setBounds(430, 360, 250, 25);// 125, 350, 250, uih
		communityField.setHorizontalAlignment(SwingConstants.CENTER);
		communityField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		communityField.setBackground(null);
		communityField.setForeground(Color.white);
		communityField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		communityField.setCaretColor(Color.white);

		schoolField = new JTextField(30);
		schoolField.setBounds(40, 360, 250, 25);// 125, 350, 250, uih
		schoolField.setHorizontalAlignment(SwingConstants.CENTER);
		schoolField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		schoolField.setBackground(null);
		schoolField.setForeground(Color.white);
		schoolField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		schoolField.setCaretColor(Color.white);

		employerField = new JTextField(30);
		employerField.setBounds(40, 445, 250, 25);// 125, 350, 250, uih
		employerField.setHorizontalAlignment(SwingConstants.CENTER);
		employerField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		employerField.setBackground(null);
		employerField.setForeground(Color.white);
		employerField.setFont(new Font("Oswald", Font.TYPE1_FONT, 15));
		employerField.setCaretColor(Color.white);

		yesBtn = new JRadioButton("Yes");
		yesBtn.setBounds(140, 510, 65, 20);
		yesBtn.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		noBtn = new JRadioButton("No");
		noBtn.setBounds(230, 510, 50, 20);
		noBtn.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));

		editBtn = new JButton("Edit");
		editBtn.setBounds(510, 530, 120, 30);
		editBtn.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));
		editBtn.setOpaque(true);
		editBtn.setBorderPainted(false);
		editBtn.setBackground(new Color(224, 224, 224));
		editBtn.setFocusPainted(false);

		saveBtn = new JButton("Save");
		saveBtn.setBounds(450, 530, 120, 30);
		saveBtn.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));
		saveBtn.setOpaque(true);
		saveBtn.setBorderPainted(false);
		saveBtn.setBackground(new Color(224, 224, 224));
		saveBtn.setFocusPainted(false);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(590, 530, 120, 30);
		cancelBtn.setFont(new Font("Oswald", Font.TYPE1_FONT, 16));
		cancelBtn.setOpaque(true);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBackground(new Color(224, 224, 224));
		cancelBtn.setFocusPainted(false);

		usernameField.setEnabled(false);
		firstNameField.setEnabled(false);
		lastNameField.setEnabled(false);
		phoneField.setEnabled(false);
		emailField.setEnabled(false);
		communityField.setEnabled(false);
		schoolField.setEnabled(false);
		employerField.setEnabled(false);
		yesBtn.setEnabled(false);
		noBtn.setEnabled(false);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(yesBtn);
		buttonGroup.add(noBtn);
	}

	public Person getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Person currentUser) {
		this.currentUser = currentUser;
	}

	public void addComponentsToPanel() {
		/*profilePanel.add(titleLabel);//profilePanel.add(Logo);
		profilePanel.add(usernameLabel); profilePanel.add(usernameField);
		profilePanel.add(firstNameLabel);profilePanel.add(firstNameField);
		profilePanel.add(lastNameLabel); profilePanel.add(lastNameField);
		profilePanel.add(schoolLabel);   profilePanel.add(schoolField);
		profilePanel.add(communityLabel);profilePanel.add(communityField);
		profilePanel.add(employerLabel); profilePanel.add(employerField);
		profilePanel.add(phoneLabel); profilePanel.add(phoneField);
		profilePanel.add(privacyLabel);
		profilePanel.add(yesBtn); profilePanel.add(noBtn);
		profilePanel.add(editBtn);*/
		this.add(titleLabel); this.add(lineSeparation);
		//profilePanel.add(Logo);
		this.add(usernameLabel); this.add(usernameField);
		this.add(emailLabel); this.add(emailField);
		this.add(firstNameLabel);this.add(firstNameField);
		this.add(lastNameLabel); this.add(lastNameField);
		this.add(schoolLabel);   this.add(schoolField);
		this.add(communityLabel);this.add(communityField);
		this.add(employerLabel); this.add(employerField);
		this.add(phoneLabel); this.add(phoneField);
		this.add(privacyLabel);
		this.add(yesBtn); add(noBtn);
		this.add(editBtn);

	}

	public void setWindowProperties() {
		this.setSize(800, 600);
		this.setBackground(new Color(216, 227, 241));
		this.setLayout(null);
	}

	public void registerListeners() {
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
		editBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}
	

	// This method adds the users data to the respective fields on the screen
	public void setupProfile() {//NTS: Test this method

		Scanner inFileStream = null;

		try {
			inFileStream = new Scanner(new File("../database/people.txt"));

			while (inFileStream.hasNext()) {
				Person person;
				String username = inFileStream.next();
				String firstName = inFileStream.next();
				String lastName = inFileStream.next();
				String phone = inFileStream.next();
				String email = inFileStream.next();
				String community = inFileStream.next();
				String school = inFileStream.next();
				String employer = inFileStream.next();
				int privacy = inFileStream.nextInt();
				// ArrayList<String> activities = new ArrayList<>(); //Accounting for activity
				/*
				 * if(inFileStream.nextLine() != null) { activities = (ArrayList<String>)
				 * Arrays.asList(inFileStream.nextLine().split("\\s+"));
				 * 
				 * //OR!!!!!!!!!!!!! List<String> activityList =
				 * Arrays.stream(inFileStream.nextLine().split("\\s+"))
				 * .collect(Collectors.toList()); // collect to List }
				 */
				person = new Person(username, firstName, lastName, phone, email, community, school, employer,
						privacy /* ,activities2 */);

				if (user == person.getUsername()) {
					usernameField.setText(person.getUsername());
					firstNameField.setText(person.getFirstName());
					lastNameField.setText(person.getLastName());
					phoneField.setText(person.getPhone());
					emailField.setText(person.getEmail());
					communityField.setText(person.getCommunity());
					schoolField.setText(person.getSchool());
					employerField.setText(person.getEmployer());
					if (privacy == 1) {
						yesBtn.setSelected(true);
						noBtn.setSelected(false);
					} else {
						noBtn.setSelected(true);
						yesBtn.setSelected(false);
					}
					currentUser = person;
					return;
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("File could not be found: " + fnfe.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inFileStream != null) {
				inFileStream.close();
			}
		}
	}

	// This method updates the new info entered by the user;
	public void updateUser() {//NTS: Test this method
		String username = usernameField.getText().trim();
		String firstName = firstNameField.getText().trim();
		String lastName = lastNameField.getText().trim();
		String phone = phoneField.getText().trim();
		String email = emailField.getText().trim();
		String community = communityField.getText().trim();
		String school = schoolField.getText().trim();
		String employer = employerField.getText().trim();
		int privacy = 0;
		if (yesBtn.isSelected() == true) {
			privacy = 1;
		}
		Scanner inFileStream = null;
		FileWriter outFileStream = null;
		File dataTempFile = new File("tempDatabase.txt");
		File databaseFile = new File("../database/people.txt");
		try {
			inFileStream = new Scanner(databaseFile);
			outFileStream = new FileWriter(dataTempFile, true);
			while (inFileStream.hasNext()) {
				String username2 = inFileStream.next();
				String firstName2 = inFileStream.next();
				String lastName2 = inFileStream.next();
				String phone2 = inFileStream.next();
				String email2 = inFileStream.next();
				String community2 = inFileStream.next();
				String school2 = inFileStream.next();
				String employer2 = inFileStream.next();
				int privacy2 = inFileStream.nextInt();
				// ArrayList<String> activities2 = new ArrayList<>(); //Accounting for activity
				// implementation
				/*
				 * if(inFileStream.nextLine() != null) { activities2 = (ArrayList<String>)
				 * Arrays.asList(inFileStream.nextLine().split("\\s+"));
				 * 
				 * //OR!!!!!!!!!!!!! List<String> activityList2 =
				 * Arrays.stream(inFileStream.nextLine().split("\\s+"))
				 * .collect(Collectors.toList()); // collect to List }
				 */
				String record = username2 + "\t" + firstName2 + "\t" + lastName2 + "\t" + phone2 + "\t" + email2 + "\t"
						+ community2 + "\t" + school2 + "\t" + employer2 + "\t"
						+ privacy2 /* +currentUser.getActivity() */ + "\n";

				if (username2.equals(currentUser.getUsername())) {
					record = username + "\t" + firstName + "\t" + lastName + "\t" + phone + "\t" + email + "\t"
							+ community + "\t" + school + "\t" + employer + "\t" + privacy
							+ /* +currentUser.getActivity() */"\n";
				}
				outFileStream.write(record);
			}
			inFileStream.close();
			outFileStream.close();
		} catch (Exception e) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editBtn) {
			this.remove(editBtn);
			editBtn.setVisible(false);
			this.add(saveBtn);
			this.add(cancelBtn);

			usernameField.setEnabled(true);
			firstNameField.setEnabled(true);
			lastNameField.setEnabled(true);
			phoneField.setEnabled(true);
			emailField.setEnabled(true);
			communityField.setEnabled(true);
			schoolField.setEnabled(true);
			employerField.setEnabled(true);
			yesBtn.setEnabled(true);
			noBtn.setEnabled(true);

		}
		if (e.getSource() == saveBtn) {
			// conduct username duplication checks
			// remove spaces from address, school, employer and name entered
			// update file database, update tree
		}
		if (e.getSource() == cancelBtn) {
			this.remove(cancelBtn);
			this.remove(saveBtn);
			this.add(editBtn);
			editBtn.setVisible(true);
			usernameField.setEnabled(false);
			firstNameField.setEnabled(false);
			lastNameField.setEnabled(false);
			phoneField.setEnabled(false);
			emailField.setEnabled(false);
			communityField.setEnabled(false);
			schoolField.setEnabled(false);
			employerField.setEnabled(false);
			yesBtn.setEnabled(false);
			noBtn.setEnabled(false);
		}
		if (e.getSource() == yesBtn) {
			noBtn.setSelected(false);
		}
		if (e.getSource() == noBtn) {
			yesBtn.setSelected(false);
		}
	}

}
