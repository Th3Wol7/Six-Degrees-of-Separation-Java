package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import com.application.models.Person;
import com.application.network.FindSeperation;
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
	private FindSeperation networkService = new FindSeperation();
	private String currentUser;
	private String friendsName[], friendsID[];

	public FriendsScreen(String username) {
		this.currentUser = username;
		initializeComponents();
		addComponentsToPanel();
		setWindowProperties();
		registerListeners();
	}

	public void initializeComponents() {
		// collectFriends();
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

		friendList = new JComboBox<>(friendsName); // new GenerateFriendsList().getFriends()
		friendList.setFont(fieldFont);
		friendList.setBounds(200, 160, 230, 30);
		;
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

		String columns[] = { "Tyrien", "Gilpin" };
		String data[][] = { { "Jamie Oliver" }, { "John Doe" } };

		suggestionTable = new JTable();
		suggestionTable.setBounds(content.getBounds());
		// suggestionTable.setShowGrid(true);
		// suggestionTable.setShowVerticalLines(true);

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

	// collect data of the users friend
	public void collectFriends() {
		Set<Map.Entry<Person, Collection<Person>>> entries = getNetworkService().getSocialNet().getNetwork().entrySet();
		entries.forEach(entry -> {
			if (entry.getKey().getUsername().equals(getCurrentUser())) {
				int i = 0;
				for (Person friend : entry.getValue()) {
					friendsName[i] = friend.getFirstName() + " " + friend.getLastName();
					friendsID[i] = friend.getUsername();
					i++;
				}
				return;
			}
		});
	}

	// removes an element from an array
	private String[] removeElement(String persons[], int index) {
		List<String> arrayList = Arrays.asList(persons);// Stream.of(persons).boxed().collect(Collectors.toList());
		// Remove the specified element
		arrayList.remove(index);
		String personUpdate[] = {};
		// return the resultant array
		personUpdate = arrayList.toArray(personUpdate);
		return personUpdate;

	}

	// update the file if a user removes a person from his/her friends list
	public void updateRemoval() {
		Scanner inFileStream = null;
		FileWriter outFileStream = null;

		File dataTempFile = new File("./database/tempDatabase.txt");
		File databaseFile = new File("./database/friends.txt");
		try {
			inFileStream = new Scanner(databaseFile);
			outFileStream = new FileWriter(dataTempFile, true);
			while (inFileStream.hasNextLine()) {// Reading the friends list an entire line at a time
				String[] userFriends;
				String record = "";
				// System.out.println(inFileStream2.hasNextLine());//For Testing purposes
				// Separating words in line to retrieve individual friend user names
				userFriends = inFileStream.nextLine().split("\\s+");

				if (userFriends[0].equals(currentUser)) {
					for (int i = 1; i < userFriends.length; i++) {
						if (userFriends[i].equals(friendsID[friendList.getSelectedIndex()])) {
							userFriends[i] = "";
							friendsID = removeElement(friendsID, i);// Possibly problematic code
							friendsName = removeElement(friendsName, i); // Possibly problematic code
							break;
						}
					}
				}

				if (userFriends[0].equals(friendsID[friendList.getSelectedIndex()])) {
					for (int i = 1; i < userFriends.length; i++) {
						if (userFriends[i].equals(currentUser)) {
							userFriends[i] = "";
							break;
						}
					}
				}

				for (int i = 0; i < userFriends.length; i++) {
					record += userFriends[i] + "\t";
				}
				record += "\n";
				outFileStream.write(record);

			}
			inFileStream.close();
			outFileStream.close();
			// rename the files here
			// dataTempFile.renameTo(databaseFile);
			// databaseFile.delete(); //do not uncomment this line until project is complete
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

	// update the file if a user adds a new friend
	public void updateAddition() {
		Scanner inFileStream = null;
		FileWriter outFileStream = null;

		File dataTempFile = new File("./database/tempDatabase.txt");
		File databaseFile = new File("./database/friends.txt");
		try {
			inFileStream = new Scanner(databaseFile);
			outFileStream = new FileWriter(dataTempFile, true);
			while (inFileStream.hasNextLine()) {// Reading the friends list an entire line at a time
				String[] userFriends;
				String record = "";
				// Separating words in line to retrieve individual friend user names
				userFriends = inFileStream.nextLine().split("\\s+");
				if (userFriends[0].equals(currentUser)) {
					// userFriends[userFriends.length+1] = insert username number of selected person
					// here;
					// friendsID[friendsName.length+1] = insert username of selected person here;
					// friendsName[friendsName.length+1] = insert username of selected person here;
				}
				/*
				 * if(userFriends[0].equals(insert username of selected person here)) {
				 * //userFriends[userFriends.length+1] = currentUser; }
				 */
				for (int i = 0; i < userFriends.length; i++) {
					record += userFriends[i] + "\t";
				}
				record += "\n";
				outFileStream.write(record);

			}
			inFileStream.close();
			outFileStream.close();
			// rename the files here
			// dataTempFile.renameTo(databaseFile);
			// databaseFile.delete(); //do not uncomment this line until project is complete
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

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public FindSeperation getNetworkService() {
		return networkService;
	}

	public void setNetworkService(FindSeperation networkService) {
		this.networkService = networkService;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == removeBtn) {// unable to test until file organization is complete
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you wish to remove this friend?",
					"Remove Friend", JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				Person user, newFriend;
				List<Person> users = new ArrayList<>();
				Set<Map.Entry<Person, Collection<Person>>> entries = getNetworkService().getSocialNet().getNetwork()
						.entrySet();
				entries.forEach(entry -> {
					if (entry.getKey().getUsername().equals(getCurrentUser())) {
						Person networkUser = entry.getKey();
						users.add(networkUser);
						return;
					}
				});

				entries.forEach(entry -> {
					if (entry.getKey().getUsername().equals(friendsID[friendList.getSelectedIndex()])) {
						Person networkUser = entry.getKey();
						users.add(networkUser);
						return;
					}
				});

				user = users.get(0);
				newFriend = users.get(1);
				if (user != null && newFriend != null) {
					getNetworkService().getSocialNet().removeFriend(user, newFriend);
					updateRemoval();
				}

				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}

		// This button is not working because of missing info inside the commented
		// section
		if (e.getSource() == addBtn) {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			int option = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Log Out", JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				Person user, newFriend;
				List<Person> users = new ArrayList<>();
				Set<Map.Entry<Person, Collection<Person>>> entries = getNetworkService().getSocialNet().getNetwork()
						.entrySet();
				entries.forEach(entry -> {
					if (entry.getKey().getUsername().equals(getCurrentUser())) {
						Person networkUser = entry.getKey();
						users.add(networkUser);
						return;
					}
				});

				/*
				 * entries.forEach(entry -> { if(entry.getKey().getUsername().equals(/*Insert
				 * user name of selected friend suggestion*)) { Person networkUser =
				 * entry.getKey(); users.add(networkUser); return; } });
				 */
				user = users.get(0);
				newFriend = users.get(1);
				if (user != null && newFriend != null) {
					getNetworkService().getSocialNet().addFriend(user, newFriend);
					updateAddition();
				}
			}

			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
