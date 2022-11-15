package com.application.gUI.screens;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.JTextComponent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.application.models.Person;
import com.application.utils.gUI.FrameUtility;

public class ActivityScreen extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static Icon profileIcon;
	private static JLabel Logo, suggestLabel, titleLabel, label;
	private JCheckBox volunteer,dance,run,shop,read, movie;
	private JPanel suggestPanel, topPanel,sidePanel, content;
	private JButton confirm, cancel,edit, add, remove;
	private JTable suggestionTable;
	private JTextField lineSeparation;
	private TextArea area;
	
	public ActivityScreen(){
		initializeComponents();
		addComponentsToPanel();
		addPanelToWindow();
		setWindowProperties();
		registerListeners();
		
	}
	public void initializeComponents(){
		
		FrameUtility.addExitButton();
		FrameUtility.exitButton.setBounds(755, 0, 45, 45);
		FrameUtility.exitButton.setForeground(Color.BLACK);
		this.add(FrameUtility.exitButton);

	
		titleLabel = new JLabel("Activities", SwingConstants.CENTER);
		titleLabel.setBounds(280, 5, 200, 50);
		titleLabel.setFont(new Font("arial", Font.BOLD, 25));
		
		lineSeparation = new JTextField(20);
		lineSeparation.setBounds(0, 10, 800, 25);// 125, 350, 250, uih
		lineSeparation.setHorizontalAlignment(SwingConstants.CENTER);
		lineSeparation.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
		lineSeparation.setBackground(null);
		lineSeparation.setCaretColor(Color.gray);
		
		volunteer = new JCheckBox("Volunteering");
		volunteer.setBounds(50, 100, 50, 50);
		volunteer.setFont(new Font("arial", Font.PLAIN, 15));
		
		dance = new JCheckBox("Dancing");
		dance.setBounds(50, 120, 50, 50);
		dance.setFont(new Font("arial", Font.PLAIN, 15));
		
		run = new JCheckBox("Running");
		run.setBounds(50, 140, 50, 50);
		run.setFont(new Font("arial", Font.PLAIN, 15));
		
		shop= new JCheckBox("Shopping");
		shop.setBounds(50, 160, 50, 50);
		shop.setFont(new Font("arial", Font.PLAIN, 15));
		
		read = new JCheckBox("Reading");
		read.setBounds(50, 180, 50, 50);
		read.setFont(new Font("arial", Font.PLAIN, 15));
		
		movie = new JCheckBox("Movies");
		movie.setBounds(50, 200, 50, 50);
		movie.setFont(new Font("arial", Font.PLAIN, 15));
		
		confirm = new JButton("Confirm");
		confirm.setPreferredSize(new Dimension(120, 30));
		confirm.setBounds(150, 250, 5, 5);
		confirm.setFont(new Font("arial", Font.PLAIN, 15));
		confirm.setFocusPainted(false);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(175, 270, 5, 5);
		cancel.setPreferredSize(new Dimension(120, 30));
		cancel.setFont(new Font("arial", Font.PLAIN, 15));
		cancel.setFocusPainted(false);
		
		edit = new JButton("Edit");
		edit.setBounds(165, 260, 5, 5);
		edit.setPreferredSize(new Dimension(120, 30));
		edit.setFont(new Font("arial", Font.PLAIN, 15));
		edit.setFocusPainted(false);
		
		add = new JButton("Add Activities");
		add.setBounds(750, 450, 10, 5);
		add.setPreferredSize(new Dimension(120, 30));
		add.setFont(new Font("arial", Font.PLAIN, 15));
		add.setFocusPainted(false);
		
		remove = new JButton("Delete");
		remove.setBounds(760, 450, 5, 5);
		remove.setPreferredSize(new Dimension(120, 30));
		remove.setFont(new Font("arial", Font.PLAIN, 15));
		remove.setFocusPainted(false);
		
		area = new TextArea();
		area.setVisible(true);
		area.setBounds(20, 20, 150, 75);
		area.setFont(new Font("arial", Font.BOLD, 14));
		area.setSize(175, 100);
		//area.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		suggestLabel = new JLabel("Suggestions", SwingConstants.LEFT);
		suggestLabel.setFont(new Font("arial", Font.BOLD, 20));
        suggestLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		suggestLabel.setBounds(40, 255, 200, 50);
		
		suggestionTable = new JTable();    
        suggestionTable.setBounds(0,300 , 750, 550);
        suggestionTable.setFont(new Font("arial", Font.PLAIN, 15));
        suggestionTable.setRowHeight(40);
        suggestionTable.setOpaque(false);
        suggestionTable.setEnabled(true);
        suggestionTable.setBackground(getBackground());
        suggestionTable.setShowGrid(false);
        suggestionTable.setShowHorizontalLines(true);
        
		topPanel = new JPanel(); //new GridLayout(0,1)
		topPanel.setBounds(25, 50, 365, 315);
		topPanel.setBackground(Color.BLUE);
		
		sidePanel = new JPanel();//new GridLayout(2,0)
		sidePanel.setBounds(410, 50, 365, 315);
		sidePanel.setBackground(Color.green);
		
		suggestPanel = new JPanel();
		suggestPanel.setBounds(25, 375, 750, 500);
		suggestPanel.setBackground(Color.yellow);
		suggestPanel.add(suggestionTable);//getViewport()
        suggestPanel.setOpaque(false);
        //suggestPanel.getViewport().setOpaque(false);
        suggestPanel.setBackground(getBackground());
        suggestPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
		
		content = new JPanel();
		content.setBounds(25,375 , 750, 500);
		
	}
	public void addComponentsToPanel(){
		this.add(titleLabel);
		topPanel.add(volunteer);
		topPanel.add(dance);
		topPanel.add(run);
		topPanel.add(shop);
		topPanel.add(read);
		topPanel.add(movie);
		topPanel.add(confirm);
		topPanel.add(edit);
		topPanel.add(cancel);
		sidePanel.add(area);
		suggestPanel.add(suggestLabel);
		suggestPanel.add(suggestionTable);
		suggestPanel.add(add);
		suggestPanel.add(remove);
		
		
	}
	public void addPanelToWindow() {
		this.add(topPanel);
		this.add(sidePanel);
		add(suggestPanel);
	}
	public void setWindowProperties() {
		this.setVisible(true);
		this.setSize(800, 600);
		this.setBackground(new Color(253, 252, 252));/// (new Color(216, 227, 241));
		this.setLayout(null);
	}
	public void registerListeners() {
		confirm.addActionListener(this);
		edit.addActionListener(this);
		cancel.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
	}
	
	public void getSuggestedActivity(Person user) {
		
		for(String activity: user.getActivity()) {
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(confirm)) {
			if(volunteer.isSelected()){
				volunteer.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						label.setText("volunteering checkbox: " + (e.getStateChange()==1?"checked":"unchecked"));
						
					}
				});
			String vol = volunteer.getText();
			area.setText(vol);
			}else if(dance.isSelected()) {
				dance.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						label.setText("dancing checkbox: " + (e.getStateChange()==1?"checked":"unchecked"));
						
					}
				});
				 String dan = dance.getText();
				 area.setText(dan);
			}else if(run.isSelected()) {
				run.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						label.setText("running checkbox: " + (e.getStateChange()==1?"checked":"unchecked"));
						
					}
				});
				 String runs = run.getText();
				 area.setText(runs);
			}else if(shop.isSelected()) {
				shop.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						label.setText("shopping checkbox: " + (e.getStateChange()==1?"checked":"unchecked"));
						
					}
				});
				String shops = shop.getText();
				area.setText(shops);
			}else if(read.isSelected()) {
				read.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						label.setText("reading checkbox: " + (e.getStateChange()==1?"checked":"unchecked"));
						
					}
				});
				String reads = read.getText();
				area.setText(reads);
			}else if(movie.isSelected()) {
				movie.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						label.setText("movies checkbox: " + (e.getStateChange()==1?"checked":"unchecked"));
						
					}
				});
				String movies = movie.getText();
				  area.setText(movies);
				}
			
		}
		if (e.getSource().equals(cancel)) {
			// unselected the check box
			volunteer.setSelected(false);
			dance.setSelected(false);
			run.setSelected(false);
			shop.setSelected(false);
			read.setSelected(false);
			movie.setSelected(false);
			//suppose to clear text area
			area.setText(null);
			// OR area.setText(area.getText().replace(area.getSelectedText(),""));
		}
		if (e.getSource().equals(edit)) {
			volunteer.setSelected(false);
			dance.setSelected(false);
			run.setSelected(false);
			shop.setSelected(false);
			read.setSelected(false);
			movie.setSelected(false);
			//for loop// 2.  mayb can set a global string to collect all string then add it to te textarea
			if(volunteer.isSelected()){
			 String vol = volunteer.getText();
			 area.setText(vol);
			}else if(dance.isSelected()) {
			 String dan = dance.getText();
			 area.setText(dan);
			}else if(run.isSelected()) {
			 String runs = run.getText();
			 area.setText(runs);
			}else if(shop.isSelected()) {
			String shops = shop.getText();
			System.out.println("the value of shop is :" +shop);
			area.setText(shops); 
			}else if(read.isSelected()) {
			String reads = read.getText();
			area.setText(reads);
			}else if(movie.isSelected()) {
			String movies = movie.getText();
			  area.setText(movies);
			}
		}
		if (e.getSource().equals(add)) {
			boolean isSelected = false;
			if (suggestionTable.getSelectedRow() != -1) {
		         isSelected = true;
		         // need to check if the value from the suggested table equals to any activity the user have already if yes 
		         // suggest u add this activity already, joptionpane warning etc. else if not then add the activity to the textbox
		        // if(suggestionTable.getValueAt(suggestionTable.getSelectedRow(),0).equals("dancing"||"running"||"volunteering"||"movie"||"reading"||"shopping")) {
		        	//string value= pass it the  string from the above it equal to
		        	 // mayb should pass it a list of string/ array then but that means a loop n a incrementing varible to pass thru the array 
		        	 //compare(value, wat in textbox)
		         
			}else {
				isSelected=false;
				JOptionPane.showMessageDialog(null, "There is no row that have been selected","Warning", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(remove)) {
			boolean isSelected = false;
			if (suggestionTable.getSelectedRow() != -1) {
		         isSelected = true;
		         int choice = JOptionPane.showConfirmDialog(
		                    null,
		                    "Remove this Activity",
		                    "Remove prompt",
		                    JOptionPane.YES_NO_OPTION,
		                    JOptionPane.QUESTION_MESSAGE
		            );
		         if (choice ==JOptionPane.YES_OPTION) {
		        	 suggestionTable.remove(suggestionTable.getSelectedRow());
		         }
			}
		}
		
	}

}
