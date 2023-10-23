package com.application.gUI.screens;
/*This class represents the look, feel and fucntionality of the
 * GUI Activity Screen
 * @author Tyrien Gilpin
 * Version 1
 */

import com.application.models.Person;
import com.application.network.FindSeperation;
import com.application.utils.gUI.FrameUtility;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActivityScreen extends JPanel implements ActionListener {
    private static Icon profileIcon;
    private static JLabel Logo;
    private final String[] tableHeaders = {"Activities"};
    private JLabel titleLabel, userActivitiesLabel, userDefinedLabel, suggestionLabel;
    private JButton saveBtn, cancelBtn, addBtn;
    private JTextField lineSeparation, userDefinedField;
    private Font labelFont, fieldFont;
    private FindSeperation networkService;
    private JScrollPane tablePanel;
    private JTable suggestionTable;
    private DefaultTableModel model;
    private Person user;
    private JCheckBox movie, running, reading, volunteering, dancing, shopping;

    public ActivityScreen(Person user, FindSeperation netService) {
        this.user = user;
        this.networkService = netService;
        initializeComponents();
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();

    }

    public void initializeComponents() {
        model = new DefaultTableModel(tableHeaders, 0);
        suggestionTable = new JTable(model);

        FrameUtility.addExitButton();
        FrameUtility.exitButton.setBounds(755, 0, 45, 45);
        FrameUtility.exitButton.setForeground(Color.BLACK);
        this.add(FrameUtility.exitButton);

        labelFont = new Font("Oswald", Font.TYPE1_FONT, 18);
        fieldFont = new Font("Oswald", Font.TYPE1_FONT, 15);
        Color buttonColour = new Color(224, 224, 224);
        Color bkgrdColour = new Color(253, 252, 252);

        titleLabel = new JLabel("My Activity", SwingConstants.CENTER);
        titleLabel.setBounds(280, 50, 200, 50);
        titleLabel.setFont(new Font("Oswald", Font.TYPE1_FONT, 34));

        lineSeparation = new JTextField(20);
        lineSeparation.setBounds(0, 100, 800, 25);// 125, 350, 250, uih
        lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
        lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        lineSeparation.setBackground(null);
        lineSeparation.setCaretColor(Color.gray);

        userActivitiesLabel = new JLabel("Your Activity Checklist", SwingConstants.LEFT);
        userActivitiesLabel.setBounds(40, 150, 200, 50);
        userActivitiesLabel.setFont(labelFont);

        suggestionLabel = new JLabel("Suggestions", SwingConstants.LEFT);
        suggestionLabel.setBounds(450, 145, 200, 50);
        suggestionLabel.setFont(labelFont);

        movie = new JCheckBox("movie");
        movie.setBounds(40, 200, 200, 50);
        movie.setFont(labelFont);
        movie.setEnabled(true);
        movie.setOpaque(true);
        movie.setBackground(new Color(253, 252, 252));
        movie.setFocusPainted(false);

        running = new JCheckBox("running");
        running.setBounds(40, 240, 200, 50);
        running.setFont(labelFont);
        running.setEnabled(true);
        running.setOpaque(true);
        running.setBackground(bkgrdColour);
        running.setFocusPainted(false);

        reading = new JCheckBox("reading");
        reading.setBounds(40, 280, 200, 50);
        reading.setFont(labelFont);
        reading.setEnabled(true);
        reading.setOpaque(true);
        reading.setBackground(bkgrdColour);
        reading.setFocusPainted(false);

        volunteering = new JCheckBox("volunteering");
        volunteering.setBounds(40, 320, 200, 50);
        volunteering.setFont(labelFont);
        volunteering.setEnabled(true);
        volunteering.setOpaque(true);
        volunteering.setBackground(bkgrdColour);
        volunteering.setFocusPainted(false);

        dancing = new JCheckBox("dancing");
        dancing.setBounds(40, 360, 200, 50);
        dancing.setFont(labelFont);
        dancing.setEnabled(true);
        dancing.setOpaque(true);
        dancing.setBackground(bkgrdColour);
        movie.setFocusPainted(false);

        shopping = new JCheckBox("shopping");
        shopping.setBounds(40, 400, 200, 50);
        shopping.setFont(labelFont);
        shopping.setEnabled(true);
        shopping.setOpaque(true);
        shopping.setBackground(bkgrdColour);
        shopping.setFocusPainted(false);

        userDefinedLabel = new JLabel("Add your own activity:", SwingConstants.LEFT);
        userDefinedLabel.setBounds(40, 440, 200, 50);
        userDefinedLabel.setFont(labelFont);

        userDefinedField = new JTextField(25);
        userDefinedField.setBounds(300, 460, 250, 25);
        userDefinedField.setHorizontalAlignment(SwingConstants.CENTER);
        suggestionTable.getTableHeader().setBackground(Color.white);
        userDefinedField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        userDefinedField.setBackground(null);
        userDefinedField.setForeground(Color.black);
        userDefinedField.setFont(fieldFont);
        userDefinedField.setCaretColor(Color.BLACK);
        userDefinedField.setEditable(true);

        addBtn = new JButton("Add");
        addBtn.setBounds(600, 460, 120, 30);
        addBtn.setFont(labelFont);
        addBtn.setOpaque(true);
        addBtn.setBorderPainted(false);
        addBtn.setBackground(buttonColour);
        addBtn.setFocusPainted(false);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(450, 530, 120, 30);
        saveBtn.setFont(labelFont);
        saveBtn.setOpaque(true);
        saveBtn.setBorderPainted(false);
        saveBtn.setBackground(buttonColour);
        saveBtn.setFocusPainted(false);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(590, 530, 120, 30);
        cancelBtn.setFont(labelFont);
        cancelBtn.setOpaque(true);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setBackground(buttonColour);
        cancelBtn.setFocusPainted(false);

        suggestionTable.setPreferredScrollableViewportSize(new Dimension(350, 230));
        suggestionTable.setDefaultEditor(Object.class, null);
        suggestionTable.setAutoCreateRowSorter(true);
        suggestionTable.getTableHeader().setOpaque(false);
        suggestionTable.getTableHeader().setFont(fieldFont);
        suggestionTable.setBackground(bkgrdColour);
        suggestionTable.setForeground(Color.black);
        suggestionTable.setFont(fieldFont);
        suggestionTable.setRowHeight(40);
        suggestionTable.setOpaque(true);
        suggestionTable.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
        suggestionTable.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));

        tablePanel = new JScrollPane(suggestionTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tablePanel.setOpaque(true);
        tablePanel.getViewport().setOpaque(false);
        tablePanel.setBackground(bkgrdColour);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        tablePanel.setBounds(400, 200, 350, 230);
        addSuggestions();
    }

    // adding the components to the panel
    public void addComponentsToPanel() {
        this.add(titleLabel);
        this.add(lineSeparation);
        this.add(userActivitiesLabel);
        this.add(suggestionLabel);
        this.add(tablePanel);
        this.add(movie);
        this.add(running);
        this.add(reading);
        this.add(volunteering);
        this.add(dancing);
        this.add(shopping);
        this.add(userDefinedLabel);
        this.add(userDefinedField);
        this.add(addBtn);
        this.add(saveBtn);
        this.add(cancelBtn);
    }

    public void setWindowProperties() {
        this.setSize(800, 600);
        this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
        this.setLayout(null);
    }

    public void registerListeners() {
        addBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }

    public FindSeperation getNetworkService() {
        return networkService;
    }

    public void setNetworkService(FindSeperation networkService) {
        this.networkService = networkService;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    // This method populates the suggestions to the table and check the boxes
    // of the activities the user is engaged in
    public void addSuggestions() {
        if (user != null && !user.getUsername().equals("")) {
            for (String activity : user.getActivity()) {
                switch (activity.toLowerCase()) {
                    case "movie":
                        movie.setSelected(true);
                        break;
                    case "running":
                        running.setSelected(true);
                        break;
                    case "reading":
                        reading.setSelected(true);
                        break;
                    case "volunteering":
                        volunteering.setSelected(true);
                        break;
                    case "dancing":
                        dancing.setSelected(true);
                        break;
                    case "shopping":
                        shopping.setSelected(true);
                        break;
                    default:
                        userDefinedField.setText(activity);
                }
            }
        }
        // If users privacy is turned off make suggestions
        if (user.getPrivacy() != 1) {
            // Clear the model
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            // Get the suggested activities
            List<String> suggestedActivities = getNetworkService().suggestActivities(user);
            for (int i = 0; i < suggestedActivities.size(); i++) {
                model.insertRow(i, new Object[]{suggestedActivities.get(i)});
            }
        }
    }


    // This method accepts changes user makes to his or her activities and update
    // them in real time
    public void updateUserActivities() {
        int selectionCount = 0;
        List<String> newActivities = new ArrayList<>();
        if (movie.isSelected()) {
            selectionCount += 1;
            newActivities.add("movie");
        }
        if (running.isSelected()) {
            selectionCount += 1;
            newActivities.add("running");
        }
        if (reading.isSelected()) {
            selectionCount += 1;
            newActivities.add("reading");
        }
        if (volunteering.isSelected()) {
            selectionCount += 1;
            newActivities.add("volunteering");
        }
        if (dancing.isSelected()) {
            selectionCount += 1;
            newActivities.add("dancing");
        }
        if (shopping.isSelected()) {
            selectionCount += 1;
            newActivities.add("shopping");
        }
        if (!(userDefinedField.getText().equals("")) && !(userDefinedField.getText().equals(" "))) {
            selectionCount += 1;
            newActivities.add(userDefinedField.getText().trim().replaceAll("\\s", ""));
        }

        if (suggestionTable.getSelectedRow() != -1) {
            selectionCount += 1;
            newActivities.add((String) suggestionTable.getValueAt(suggestionTable.getSelectedRow(),
                    suggestionTable.getSelectedColumn()));
        }

        if (selectionCount > 3 || newActivities.size() > 3) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                JOptionPane.showMessageDialog(null, "You can ony engage in 3 activties at a time", "You Activities",
                        JOptionPane.INFORMATION_MESSAGE);
                addSuggestions();
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            user.setActivity(new ArrayList<>());
            user.setActivity(newActivities);
            addSuggestions();

            File dataTempFile = new File("CIT3003/src/com/application/database/tempActivities.txt");
            File databaseFile = new File("CIT3003/src/com/application/database/ActivitiesCopy.txt");
            try (Scanner inFileStream = new Scanner(databaseFile);
                 FileWriter outFileStream = new FileWriter(dataTempFile)) {

                while (inFileStream.hasNext()) {
                    String record = "";
                    String username = inFileStream.next();
                    String fName = inFileStream.next();
                    String lName = inFileStream.next();
                    String activities = inFileStream.next();
                    record += username + "\t" + fName + "\t" + lName + "\t" + activities;

                    if (user.getUsername().equals(username)) {
                        record = "";
                        record += user.getUsername() + "\t" + fName + "\t" + lName + "\t";
                        for (int i = 0; i < newActivities.size(); i++) {
                            record += newActivities.get(i);
                            if (i < (newActivities.size() - 1)) {
                                record += ",";
                            }
                        }
                    }

                    record += "\n";
                    outFileStream.write(record);
                }
                inFileStream.close();
                outFileStream.close();
            } catch (FileNotFoundException fnfe) {
                System.err.println("File could not be found: " + fnfe.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            updateUserActivities();
            // rename the files here and delete here
            File tempFile = new File("CIT3003/src/com/application/database/tempActivities.txt");
            File oldFile = new File("CIT3003/src/com/application/database/ActivitiesCopy.txt");
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
        if (e.getSource() == cancelBtn) {
            addSuggestions();
        }
        if (e.getSource() == addBtn) {
            updateUserActivities();
        }
    }

}
