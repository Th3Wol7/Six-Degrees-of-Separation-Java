package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.application.models.Person;

@SuppressWarnings("serial")
public class ShowProfile implements ActionListener {
	private static Icon profileIcon;
	private static JLabel Logo;
	private static JLabel titleLabel;
	private JLabel usernameLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel;
	private JLabel communityLabel;
	private JLabel schoolLabel;
	private JLabel employerLabel;
	private JLabel privacyLabel;
	private JTextField usernameField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField communityField;
	private JTextField schoolField;
	private JTextField employerField;
	private JTextField privacyField;
	private JPanel profilePanel;
	private JRadioButton yesBtn, noBtn;
	private JButton editBtn, saveBtn, cancelBtn;
	private ButtonGroup buttonGroup;
	private String user;
	private Person currentUser;
	
	public ShowProfile(String username) {
		this.user = username;
		initializeComponents();
		addComponentsToPanel();
		setWindowProperties();
		registerListeners();
		setupProfile();
	}
	
	
	public void initializeComponents() {
		profilePanel = new JPanel();

		profileIcon = new ImageIcon(new ImageIcon(ShowProfile.class.getResource("image file path here")).getImage()
				.getScaledInstance(100, 60, Image.SCALE_DEFAULT));
		Logo = new JLabel(profileIcon);

		usernameLabel = new JLabel("Username");
		firstNameLabel = new JLabel("Firstname");
		lastNameLabel = new JLabel("Lastname");
		phoneLabel = new JLabel("Telephone");
		emailLabel = new JLabel("Email");
		communityLabel = new JLabel("Community");
		schoolLabel = new JLabel("Education");
		employerLabel = new JLabel("Employer");
		privacyLabel = new JLabel("Privacy");

		usernameField = new JTextField(20);
		firstNameField = new JTextField(30);
		lastNameField = new JTextField(30);
		phoneField = new JTextField(20);
		emailField = new JTextField(30);
		communityField = new JTextField(30);
		schoolField = new JTextField(30);
		employerField = new JTextField(30);
		privacyField = new JTextField(30);
		yesBtn = new JRadioButton("Yes");
		noBtn = new JRadioButton("No");
	
		usernameField.setEnabled(false);
		firstNameField.setEnabled(false);
		lastNameField.setEnabled(false);
		phoneField.setEnabled(false);
		emailField.setEnabled(false);
		communityField.setEnabled(false);
		schoolField.setEnabled(false);
		employerField.setEnabled(false);
		privacyField.setEnabled(false);
		yesBtn.setEnabled(false);
		noBtn.setEnabled(false);

		
		buttonGroup.add(yesBtn);
		buttonGroup.add(noBtn);
		editBtn = new JButton("Edit");
		saveBtn = new JButton("Save");
		cancelBtn = new JButton("Cancel");
		
		
		
		
	}

	public Person getCurrentUser() {
		return currentUser;
	}


	public void setCurrentUser(Person currentUser) {
		this.currentUser = currentUser;
	}

	public void addComponentsToPanel() {
		profilePanel.add(Logo);
		profilePanel.add(titleLabel);
		profilePanel.add(editBtn);
		profilePanel.add(usernameLabel);
		profilePanel.add(usernameField);
		profilePanel.add(firstNameLabel);
		profilePanel.add(firstNameField);
		profilePanel.add(lastNameLabel);
		profilePanel.add(lastNameField);
		profilePanel.add(schoolLabel);
		profilePanel.add(schoolField);
		profilePanel.add(communityLabel);
		profilePanel.add(communityField);
		profilePanel.add(employerLabel);
		profilePanel.add(employerField);
		profilePanel.add(phoneLabel);
		profilePanel.add(phoneField);
		profilePanel.add(privacyLabel);
		profilePanel.add(yesBtn);
		profilePanel.add(noBtn);
	}

	public void setWindowProperties() {
		profilePanel.setPreferredSize(new Dimension(800, 600));
		profilePanel.setVisible(true);
	}

	public void registerListeners() {
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
		editBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}
	
	//This method adds the users data to the respective fields on the screen
	public void setupProfile() {

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
					privacyField.setText(String.valueOf(person.getPrivacy()));

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
	
	
	//This method updates the new info entered by the user;
	public void updateUser() {
		String username = usernameField.getText().trim();
		String firstName = firstNameField.getText().trim();
		String lastName = lastNameField.getText().trim();
		String phone = phoneField.getText().trim();
		String email = emailField.getText().trim();
		String community = communityField.getText().trim();
		String school = schoolField.getText().trim();
		String employer = employerField .getText().trim();
		int privacy = 0;
		if(yesBtn.isSelected()==true) {
			privacy = 1;
		}
		Scanner inFileStream = null;
		FileWriter outFileStream = null;
		File dataTempFile = new File("tempDatabase.txt");
		File databaseFile = new File("../database/people.txt");
		try{
			inFileStream = new Scanner(databaseFile);
			outFileStream = new FileWriter(dataTempFile, true);
			while(inFileStream.hasNext()){
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
				String record = username2 +"\t"+ firstName2 +"\t"+ lastName2 +"\t"+ phone2 +"\t"+ email2 +
						"\t"+ community2 +"\t"+ school2 +"\t"+ employer2 +"\t"+ privacy2 /*+currentUser.getActivity()*/+ "\n";
				
				if(username2.equals(currentUser.getUsername())){ 
					record = username +"\t"+ firstName +"\t"+ lastName +"\t"+ phone +"\t"+ email +
							"\t"+ community +"\t"+ school +"\t"+ employer +"\t"+ privacy + /*+currentUser.getActivity()*/"\n";
				}				
				outFileStream.write(record);
			}
			inFileStream.close();
			outFileStream.close();
		}catch(Exception e) {
			
		}

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editBtn) {
			profilePanel.remove(editBtn);
			profilePanel.add(saveBtn);
			profilePanel.add(cancelBtn);

			usernameField.setEnabled(true);
			firstNameField.setEnabled(true);
			lastNameField.setEnabled(true);
			phoneField.setEnabled(true);
			emailField.setEnabled(true);
			communityField.setEnabled(true);
			schoolField.setEnabled(true);
			employerField.setEnabled(true);
			privacyField.setEnabled(true);
			yesBtn.setEnabled(true);
			noBtn.setEnabled(true);

		}
		if (e.getSource() == saveBtn) {
			// conduct username duplication checks
			// remove spaces from address, school, employer and name entered
			// update file database, update tree
		}
		if (e.getSource() == cancelBtn) {
			profilePanel.remove(cancelBtn);
			profilePanel.remove(saveBtn);
			profilePanel.add(editBtn);
		}
		if (e.getSource() == yesBtn) {
			noBtn.setSelected(false);
		}
		if (e.getSource() == noBtn) {
			yesBtn.setSelected(false);
		}
	}

}
