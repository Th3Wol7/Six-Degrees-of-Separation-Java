package com.application.gUI.screens;

import java.awt.Color;
<<<<<<< HEAD
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
		
=======
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.application.models.Person;
import com.application.network.FindSeperation;
import com.application.utils.gUI.FrameUtility;

public class ActivityScreen extends JPanel implements ActionListener {
	private static Icon profileIcon;
	private static JLabel Logo;
	private final String[] tableHeaders = {"Activities"};
	private JLabel titleLabel, userActivitiesLabel, userDefinedLabel, suggestionLabel;
	private JButton saveBtn, cancelBtn, addBtn;
	private JTextField lineSeparation, userDefinedField;
	private Font labelFont, fieldFont;
	private FindSeperation networkService = new FindSeperation();
	private JScrollPane tablePanel;
	private JTable suggestionTable;
	private DefaultTableModel model;
	private Person user;
	private JCheckBox movie, running, reading, volunteering, dancing, shopping;
	private JTextArea tabel;

	public ActivityScreen(Person user) {
		this.user = user;
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
		saveBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	public void addSuggestions() {
		if (user != null && !(user.getUsername().equals(""))) {
			for (String activity : getUser().getActivity()) {
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
				case "shopping.setSelected(true);":
					shopping.setSelected(true);
					break;
				default:
					userDefinedField.setText(activity);
				}
			}
		}
		int count = 0;
        int rowCount = model.getRowCount();
        int counter = 0;

        while (counter < rowCount) {
            model.removeRow(count);
            counter++;
        } 
        for (int count1 = 0; count1 < getNetworkService().suggestActivities(user).size(); count1++) {
            System.out.println(getNetworkService().suggestActivities(user).get(count1));
        	model.insertRow(count1, new Object[]{
            		getNetworkService().suggestActivities(user).get(count1)});
        }
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveBtn) {

		}
		if (e.getSource() == cancelBtn) {

		}
	}

}
