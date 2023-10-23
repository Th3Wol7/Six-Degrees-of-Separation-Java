package com.application.gUI.screens;
/*This class represents the look, feel and functionality of the
 * GUI Users Profile Screen
 * @author Tyrien Gilpin
 * Version 1
 */

import com.application.models.Person;
import com.application.utils.gUI.FrameUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProfileScreen extends JPanel implements ActionListener {
    private static Icon profileIcon;
    private static JLabel Logo;
    private JLabel titleLabel, usernameLabel, firstNameLabel, lastNameLabel;
    private JLabel phoneLabel, emailLabel, communityLabel, schoolLabel, employerLabel, privacyLabel;
    private JTextField usernameField, firstNameField, lastNameField;
    private JTextField phoneField, emailField, communityField, schoolField, employerField;
    private JTextField lineSeparation;
    private JRadioButton yesBtn, noBtn;
    private JButton editBtn, saveBtn, cancelBtn;
    private ButtonGroup buttonGroup;
    private Font fieldFont, labelFont;
    private Person user;

    public ProfileScreen(Person user) {
        this.user = user;
        initializeComponents();
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();
        setupProfile();
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
        fieldFont = new Font("Oswald", Font.TYPE1_FONT, 15);
        labelFont = new Font("Oswald", Font.TYPE1_FONT, 16);

        titleLabel = new JLabel("My Profile", SwingConstants.CENTER);
        titleLabel.setBounds(280, 50, 200, 50);
        titleLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));

        usernameLabel = new JLabel("Username", SwingConstants.LEFT);
        usernameLabel.setBounds(40, 150, 200, 50);
        usernameLabel.setFont(labelFont);

        firstNameLabel = new JLabel("Firstname", SwingConstants.LEFT);
        firstNameLabel.setBounds(40, 235, 200, 50);
        firstNameLabel.setFont(labelFont);

        lastNameLabel = new JLabel("Lastname", SwingConstants.LEFT);
        lastNameLabel.setBounds(430, 235, 200, 50);
        lastNameLabel.setFont(labelFont);

        phoneLabel = new JLabel("Telephone");
        phoneLabel.setBounds(430, 405, 200, 50);
        phoneLabel.setFont(labelFont);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(430, 150, 200, 50);
        emailLabel.setFont(labelFont);

        communityLabel = new JLabel("Community");
        communityLabel.setBounds(430, 320, 200, 50);
        communityLabel.setFont(labelFont);

        schoolLabel = new JLabel("Education", SwingConstants.LEFT);
        schoolLabel.setBounds(40, 320, 200, 50);
        schoolLabel.setFont(labelFont);

        employerLabel = new JLabel("Employer");
        employerLabel.setBounds(40, 405, 200, 50);
        employerLabel.setFont(labelFont);

        privacyLabel = new JLabel("Privacy");
        privacyLabel.setBounds(40, 490, 200, 50);
        privacyLabel.setFont(labelFont);

        lineSeparation = new JTextField(20);
        lineSeparation.setBounds(0, 100, 800, 25);// 125, 350, 250, uih
        lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
        lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        lineSeparation.setBackground(null);
        lineSeparation.setCaretColor(Color.gray);

        usernameField = new JTextField(20);
        usernameField.setBounds(40, 190, 250, 25);// 125, 350, 250, uih
        usernameField.setHorizontalAlignment(SwingConstants.CENTER);
        usernameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        usernameField.setBackground(getBackground());
        usernameField.setForeground(Color.black);
        usernameField.setFont(fieldFont);

        firstNameField = new JTextField(30);
        firstNameField.setBounds(40, 275, 250, 25);// 125, 350, 250, uih
        firstNameField.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        firstNameField.setBackground(null);
        firstNameField.setForeground(Color.black);
        firstNameField.setFont(fieldFont);

        lastNameField = new JTextField(30);
        lastNameField.setBounds(430, 275, 250, 25);// 125, 350, 250, uih
        lastNameField.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        lastNameField.setBackground(null);
        lastNameField.setForeground(Color.black);
        lastNameField.setFont(fieldFont);

        phoneField = new JTextField(20);
        phoneField.setBounds(430, 445, 250, 25);// 125, 350, 250, uih
        phoneField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        phoneField.setBackground(null);
        phoneField.setForeground(Color.black);
        phoneField.setFont(fieldFont);

        emailField = new JTextField(30);
        emailField.setBounds(430, 190, 250, 25);// 125, 350, 250, uih
        emailField.setHorizontalAlignment(SwingConstants.CENTER);
        emailField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        emailField.setBackground(null);
        emailField.setForeground(Color.black);
        emailField.setFont(fieldFont);

        communityField = new JTextField(30);
        communityField.setBounds(430, 360, 250, 25);// 125, 350, 250, uih
        communityField.setHorizontalAlignment(SwingConstants.CENTER);
        communityField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        communityField.setBackground(null);
        communityField.setForeground(Color.black);
        communityField.setFont(fieldFont);

        schoolField = new JTextField(30);
        schoolField.setBounds(40, 360, 250, 25);// 125, 350, 250, uih
        schoolField.setHorizontalAlignment(SwingConstants.CENTER);
        schoolField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        schoolField.setBackground(null);
        schoolField.setForeground(Color.black);
        schoolField.setFont(fieldFont);

        employerField = new JTextField(30);
        employerField.setBounds(40, 445, 250, 25);// 125, 350, 250, uih
        employerField.setHorizontalAlignment(SwingConstants.CENTER);
        employerField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        employerField.setBackground(null);
        employerField.setForeground(Color.black);
        employerField.setFont(fieldFont);

        yesBtn = new JRadioButton("Yes");
        yesBtn.setBounds(140, 510, 65, 20);
        yesBtn.setFont(labelFont);
        yesBtn.setOpaque(false);
        yesBtn.setFocusPainted(false);

        noBtn = new JRadioButton("No");
        noBtn.setBounds(230, 510, 50, 20);
        noBtn.setFont(labelFont);
        noBtn.setOpaque(false);
        noBtn.setFocusPainted(false);

        editBtn = new JButton("Edit");
        editBtn.setBounds(510, 530, 120, 30);
        editBtn.setFont(labelFont);
        editBtn.setOpaque(true);
        editBtn.setBorderPainted(false);
        editBtn.setBackground(new Color(224, 224, 224));
        editBtn.setFocusPainted(false);

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

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public void addComponentsToPanel() {
        // profilePanel.add(Logo);
        this.add(titleLabel);
        this.add(lineSeparation);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(firstNameLabel);
        this.add(firstNameField);
        this.add(lastNameLabel);
        this.add(lastNameField);
        this.add(schoolLabel);
        this.add(schoolField);
        this.add(communityLabel);
        this.add(communityField);
        this.add(employerLabel);
        this.add(employerField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(privacyLabel);
        this.add(yesBtn);
        add(noBtn);
        this.add(editBtn);
    }

    public void setWindowProperties() {
        this.setSize(800, 600);
        this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
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
    public void setupProfile() {
        if (user != null) {
            usernameField.setText(user.getUsername());
            firstNameField.setText(user.getFirstName());
            lastNameField.setText(user.getLastName());
            phoneField.setText(user.getPhone());
            emailField.setText(user.getEmail());
            communityField.setText(user.getCommunity());
            schoolField.setText(user.getSchool());
            employerField.setText(user.getEmployer());
            if (user.getPrivacy() == 1) {
                yesBtn.setSelected(true);
                noBtn.setSelected(false);
            } else {
                noBtn.setSelected(true);
                yesBtn.setSelected(false);
            }
        }
    }

    // This method updates the new info entered by the user;
    // This method only updates the user in the file not in the network
    //Optimized version
    public void updateUser() {
        String username = usernameField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String community = communityField.getText().trim();
        String school = schoolField.getText().trim();
        String employer = employerField.getText().trim();
        int privacy = yesBtn.isSelected() ? 1 : 0;

        Scanner inFileStream = null;
        FileWriter outFileStream = null;

        File dataTempFile = new File("CIT3003/src/com/application/database/tempPeopleDatabase.txt");
        File databaseFile = new File("CIT3003/src/com/application/database/peopleCopy.txt");

        try {
            inFileStream = new Scanner(databaseFile);
            outFileStream = new FileWriter(dataTempFile);
            while (inFileStream.hasNext()) {
                StringBuilder record = new StringBuilder();
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.next()).append("\t");
                record.append(inFileStream.nextInt()).append("\n");

                if (username.equals(getUser().getUsername())) {
                    Person person1 = new Person(username, firstName, lastName, phone, email, community, school,
                            employer, privacy, getUser().getActivity());
                    setUser(person1);
                    record.setLength(0); // clear the StringBuilder
                    record.append(username).append("\t");
                    record.append(firstName).append("\t");
                    record.append(lastName).append("\t");
                    record.append(phone).append("\t");
                    record.append(email).append("\t");
                    record.append(community).append("\t");
                    record.append(school).append("\t");
                    record.append(employer).append("\t");
                    record.append(privacy).append("\n");
                }
                outFileStream.write(record.toString());
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("File could not be found: " + fnfe.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inFileStream != null) {
                inFileStream.close();
            }
            if (outFileStream != null) {
                try {
                    outFileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editBtn) {
            editBtn.setVisible(false);
            this.remove(editBtn);
            this.add(saveBtn);
            this.add(cancelBtn);
            cancelBtn.setVisible(true);
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
            // remove spaces from address, school, employer and name entered
            // update file com.database.database, update tree
            if (!usernameField.getText().equals("") && !firstNameField.getText().equals("")
                    && !lastNameField.getText().equals("") && !phoneField.getText().equals("")
                    && !emailField.getText().equals("") && !communityField.getText().equals("")
                    && !schoolField.getText().equals("") && !employerField.getText().equals("")) {
                updateUser();
                File tempFile = new File("CIT3003/src/com/application/database/tempPeopleDatabase.txt");
                File oldFile = new File("CIT3003/src/com/application/database/peopleCopy.txt");
                if (tempFile.exists()) {
                    if (oldFile.delete()) {
                        System.out.println("Old file deleted.");
                    } else {
                        System.out.println("Failed to delete old file.");
                    }
                    if (tempFile.renameTo(oldFile)) {
                        System.out.println("Temp file renamed to old file.");
                    } else {
                        System.out.println("Failed to rename temp file.");
                    }
                } else {
                    System.out.println("Temp file does not exist.");
                }
                this.add(editBtn);
                cancelBtn.setVisible(false);
                this.remove(cancelBtn);
                this.remove(saveBtn);
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
            } else {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "One or more field empty", "Missing info",
                        JOptionPane.INFORMATION_MESSAGE);

                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (e.getSource() == cancelBtn) {
            this.add(editBtn);
            cancelBtn.setVisible(false);
            // saveBtn.setVisible(false);
            this.remove(cancelBtn);
            this.remove(saveBtn);
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

            usernameField.setText(user.getUsername());
            firstNameField.setText(user.getFirstName());
            lastNameField.setText(user.getLastName());
            phoneField.setText(user.getPhone());
            emailField.setText(user.getEmail());
            communityField.setText(user.getCommunity());
            schoolField.setText(user.getSchool());
            employerField.setText(user.getEmployer());
            if (user.getPrivacy() == 1) {
                yesBtn.setSelected(true);
                noBtn.setSelected(false);
            } else {
                noBtn.setSelected(true);
                yesBtn.setSelected(false);
            }

        }
        if (e.getSource() == yesBtn) {
            noBtn.setSelected(false);
        }
        if (e.getSource() == noBtn) {
            yesBtn.setSelected(false);
        }
    }

}
/* For use in updating action listerner method

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == editBtn) {
        switchToEditMode();
    }
    if (e.getSource() == saveBtn) {
        if (isFormComplete()) {
            updateUser();
            renameFiles();
            switchToViewMode();
        } else {
            showErrorMessage("One or more field empty", "Missing info");
        }
    }
    if (e.getSource() == cancelBtn) {
        switchToViewMode();
    }
}

private void switchToEditMode() {
    editBtn.setVisible(false);
    this.remove(editBtn);
    this.add(saveBtn);
    this.add(cancelBtn);
    cancelBtn.setVisible(true);
    setFieldsEnabled(true);
}

private void switchToViewMode() {
    this.add(editBtn);
    cancelBtn.setVisible(false);
    this.remove(cancelBtn);
    this.remove(saveBtn);
    editBtn.setVisible(true);
    setFieldsEnabled(false);
}

private void setFieldsEnabled(boolean enabled) {
    usernameField.setEnabled(enabled);
    firstNameField.setEnabled(enabled);
    lastNameField.setEnabled(enabled);
    phoneField.setEnabled(enabled);
    emailField.setEnabled(enabled);
    communityField.setEnabled(enabled);
    schoolField.setEnabled(enabled);
    employerField.setEnabled(enabled);
    yesBtn.setEnabled(enabled);
    noBtn.setEnabled(enabled);
}

private boolean isFormComplete() {
    return !usernameField.getText().equals("") && !firstNameField.getText().equals("")
            && !lastNameField.getText().equals("") && !phoneField.getText().equals("")
            && !emailField.getText().equals("") && !communityField.getText().equals("")
            && !schoolField.getText().equals("") && !employerField.getText().equals("");
}

private void renameFiles() {
    File tempFile = new File("CIT3003/src/com/application/database/tempPeopleDatabase.txt");
    File oldFile = new File("CIT3003/src/com/application/database/peopleCopy.txt");

    if (tempFile.exists()) {
        if (oldFile.delete()) {
            System.out.println("Old file deleted.");
        } else {
            System.out.println("Failed to delete old file.");
        }
        if (tempFile.renameTo(oldFile)) {
            System.out.println("Temp file renamed to old file.");
        } else {
            System.out.println("Failed to rename temp file.");
        }
    } else {
        System.out.println("Temp file does not exist.");
    }
}

private void showErrorMessage(String message, String title) {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}



 */