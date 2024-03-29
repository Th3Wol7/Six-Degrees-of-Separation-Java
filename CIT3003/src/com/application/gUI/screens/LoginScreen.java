package com.application.gUI.screens;
/*This class represents the look, feel and functionality of the
 * GUI Login Screen upon start
 * @author Tyrien Gilpin
 * Version 1.2
 */

import com.application.models.Person;
import com.application.network.FindSeperation;
import com.application.utils.gUI.FrameUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;

public class LoginScreen {

    private static Color userPicColor;
    private static Color userLogColor;
    private static Color newUserPicColor;
    private static Color newUserLogColor;
    private static Font Oswald;
    private static JPanel imagePanel;
    private static JPanel mainPanel;
    private static JPanel loginPanel;
    private static JLabel welcomeLabel;
    private static JLabel welcomeNewUserLabel;
    private static JLabel picLabel;
    private static Icon users;
    private static Icon prospects;
    private static JTextField userName;
    private static JTextArea userSwap;
    private static JPasswordField passwordText;
    private static JToggleButton registerButton;
    private static JButton loginButton;
    final int panWidth = 1000;
    final int panHeight = 600;
    final int uih = 25;
    final int newUserSetX = 140;
    final int newUserSetY = 520;
    final int newUserOffsetX = newUserSetX + 60;
    final int newUserOffsetY = newUserSetY + 9;
    private final JFrame frame;
    private final FindSeperation network;
    private Person user = new Person();

    public LoginScreen(JFrame frame, FindSeperation socialNet) {
        this.frame = frame;
        this.network = socialNet;
        initializeComponents();
        setAll();
    }

    public void initializeComponents() {
        frame.setShape(new RoundRectangle2D.Double(0, 0, panWidth, panHeight, 30, 30));
        frame.setSize(panWidth, panHeight);
        createPanel(frame);

        newUserPicColor = new Color(207, 209, 219);
        newUserLogColor = new Color(190, 71, 11);

        userPicColor = new Color(216, 227, 241);
        userLogColor = new Color(65, 172, 158);

        Oswald = new Font("Oswald", Font.TYPE1_FONT, 15);

        users = new ImageIcon(new ImageIcon(Objects.requireNonNull(MainScreen.class.getResource("./res/loginlogo.png"))).getImage()
                .getScaledInstance(500, 550, Image.SCALE_DEFAULT));

        prospects = new ImageIcon(new ImageIcon(Objects.requireNonNull(MainScreen.class.getResource("./res/logo2.png"))).getImage()
                .getScaledInstance(500, 550, Image.SCALE_DEFAULT));

        loginPanel.setLayout(new GridLayout(1, 2));

        imagePanel = new JPanel();
        mainPanel = new JPanel();

        // Assigns default image to variable
        picLabel = new JLabel(users);
        picLabel.setBounds(0, 0, 500, 600);

        // adds created panels to main Panel
        loginPanel.add(mainPanel);
        loginPanel.add(imagePanel);

        // sets layout to be null, to allow for free placement of JAttributes
        imagePanel.setLayout(null);
        mainPanel.setLayout(null);

        // Calling custom util methods to build ui
        // Calls Function To create and add Exit Button
        FrameUtility.addExitButton();
        FrameUtility.exitButton.setBounds(455, 0, 45, 45);
        imagePanel.add(FrameUtility.exitButton);

        // WelcomeLabel Message display
        // Creates and defines welcomeLabel! message
        welcomeLabel = new JLabel("WELCOME", SwingConstants.CENTER);
        welcomeLabel.setBounds(150, 150, 200, 50);
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));

        welcomeNewUserLabel = new JLabel("USER!", SwingConstants.CENTER);
        welcomeNewUserLabel.setBounds(150, 200, 200, 50);
        welcomeNewUserLabel.setForeground(Color.white);
        welcomeNewUserLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));

        // adds welcomeLabel! message and adds picture to right panel
        mainPanel.add(welcomeLabel);
        mainPanel.add(welcomeNewUserLabel);
        imagePanel.add(picLabel);

        imagePanel.setBackground(userPicColor);
        mainPanel.setBackground(userLogColor);

        frame.add(loginPanel);
    }

    public void createPanel(JFrame frame) {
        // Setting login panel properties
        loginPanel = new JPanel();
        loginPanel.setBounds(0, 0, panWidth, panHeight);
        loginPanel.setLayout(null);

    }


    public void findUser() {
        // Create maps to store people and their activities
        Map<String, Person> peopleMap = new HashMap<>();
        Map<String, List<String>> activitiesMap = new HashMap<>();

        try {
            // Open the files
            Scanner peopleScanner = new Scanner(new File("CIT3003/src/com/application/database/peopleCopy.txt"));
            Scanner activitiesScanner = new Scanner(new File("CIT3003/src/com/application/database/ActivitiesCopy.txt"));

            // Read people from the file and store them in the map
            while (peopleScanner.hasNext()) {
                String username = peopleScanner.next();
                String firstName = peopleScanner.next();
                String lastName = peopleScanner.next();
                String phone = peopleScanner.next();
                String email = peopleScanner.next();
                String community = peopleScanner.next();
                String school = peopleScanner.next();
                String employer = peopleScanner.next();
                int privacy = peopleScanner.nextInt();

                Person person = new Person(username, firstName, lastName, phone, email, community, school, employer, privacy,
                        new ArrayList<>());
                // Store the person in the map with their username as the key
                peopleMap.put(username, person);
            }

            // Read activities from the file and store them in the map
            while (activitiesScanner.hasNext()) {
                String username = activitiesScanner.next();
                String actUser = activitiesScanner.next();
                String actFName = activitiesScanner.next();
                String act = activitiesScanner.next();
                String[] act1 = act.split(",");
                // Store the activities in the map with the username as the key
                activitiesMap.put(username, Arrays.asList(act1));
            }

            // Assign activities to each person and check if they are the user we're looking for
            for (Person person : peopleMap.values()) {
                person.setActivity(activitiesMap.get(person.getUsername()));

                // If this is the user we're looking for, assign them to 'user' and break the loop
                if (userName.getText().trim().equals(person.getUsername())) {
                    user = person;
                    break;
                }
            }
            // Close the scanners after use
            peopleScanner.close();
            activitiesScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Setting properties of user login screen attributes
    public void addLoginFields() {
        // setting user name input text field properties
        userName = new JTextField(25);
        userName.setText("username");
        userName.setBounds(125, 270, 250, uih);// 125, 350, 250, uih
        userName.setHorizontalAlignment(SwingConstants.CENTER);
        userName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        userName.setBackground(null);
        userName.setForeground(Color.white);
        userName.setFont(Oswald);
        userName.setCaretColor(Color.white);
        userName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userName.getText().equals("username")) {
                    userName.setText(null);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userName.getText().equals("")) {
                    userName.setText("username");

                }

            }

        });

        // setting password text field properties
        passwordText = new JPasswordField("password");
        passwordText.setBounds(125, 350, 250, uih);
        passwordText.setVisible(true);// false/////
        passwordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        passwordText.setBackground(null);
        passwordText.setForeground(Color.white);
        passwordText.setFont(Oswald);
        passwordText.setCaretColor(Color.white);
        passwordText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                char[] passwordchar = passwordText.getPassword();
                String password = String.valueOf(passwordchar);
                if (password.equalsIgnoreCase("Password")) {
                    passwordText.setText(null);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                char[] passwordchar = passwordText.getPassword();
                String password = String.valueOf(passwordchar);
                if (password.equals("")) {
                    passwordText.setText("Password");
                }

            }

        });

        mainPanel.add(userName);
        mainPanel.add(passwordText);

    }

    // Setting properties of options to swap screens
    public void screenSwitch() {
        Font oswald_Small = new Font("Oswald", Font.TYPE1_FONT, 10);

        userSwap = new JTextArea("Don't have an account?");

        userSwap.setEditable(false);
        userSwap.setBounds(newUserSetX, newUserSetY, 100, 150);

        // Sets text area so that the words wrap properly in the box
        userSwap.setLineWrap(true);
        userSwap.setWrapStyleWord(true);

        // Sets the text box to the style of the ui
        userSwap.setOpaque(false);
        userSwap.setFont(oswald_Small);
        userSwap.setForeground(Color.white);
        userSwap.setBackground(null);
        userSwap.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        // Adds Functionality to the button
        registerButton = new JToggleButton("<HTML><U>Click Here</U></HTML>");

        registerButton.setBounds(newUserOffsetX, newUserOffsetY, 100, uih);
        // Setting button to look and feel of main ui
        registerButton.setForeground(Color.white);
        registerButton.setFont(oswald_Small);
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(false);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                registerPressed(itemEvent);
            }
        });

        // Adding fields to login panel
        mainPanel.add(userName);
        mainPanel.add(registerButton);
        mainPanel.add(userSwap);

    }

    // Setting properties of login button
    public void addLoginButton(JFrame frame) {

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 400, 100, uih);
        mainPanel.add(loginButton);
        loginButton.setOpaque(false);
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setForeground(Color.white);
        loginButton.setFont(Oswald);
        loginButton.setBorder(new FrameUtility.RoundedBorder(25));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.setVisible(false);
                loginPanel.removeAll();
                frame.remove(loginPanel);
                findUser();
                network.getSocialNet().createNetwork();
                new UserScreen(frame, user, network);
            }

        });

    }

    public void setAll() {
        addLoginFields();
        screenSwitch();
        addLoginButton(frame);
    }

    // specifying actions based on user type
    protected void registerPressed(ItemEvent itemEvent) {

        int state = itemEvent.getStateChange();

        if (state == ItemEvent.SELECTED) {

            welcomeNewUserLabel.setVisible(false);
            picLabel.setBounds(-20, 0, 500, 600);
            imagePanel.setBackground(newUserPicColor);
            mainPanel.setBackground(newUserLogColor);

            picLabel.setIcon(prospects);

            welcomeLabel.setText("Register");
            userSwap.setText("Already have an account?");

        } else {
            welcomeNewUserLabel.setVisible(true);
            picLabel.setBounds(0, 0, 500, 600);
            imagePanel.setBackground(userPicColor);
            mainPanel.setBackground(userLogColor);

            picLabel.setIcon(users);

            welcomeLabel.setText("WELCOME");
            userSwap.setText("Don't have an account?");
        }

    }

}
