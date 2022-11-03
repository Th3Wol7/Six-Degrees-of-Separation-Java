package com.application.models;

public class PersonNode {

	//Node attributes
	private Person data;
	private PersonNode left;
	private PersonNode right;
	private int colour;
	private PersonNode parent;
	
	//Default Constructor
	public PersonNode() {
		this.data = null;
		this.left = null;
		this.right = null;
		this.colour = 1; //Where 1 represents red
		this.parent = null;
	}
	
	
	//Primary Constructor
	public PersonNode(Person data, PersonNode left, PersonNode right, int colour, PersonNode parent) {
		this.data = data;
		this.left = right;
		this.right = right;
		this.colour = colour;
		this.parent = parent;
	}
	
	//Primary Constructor 2
	public PersonNode(Person data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.colour = 1; //Where 1 represents red
		this.parent = null;
	}

	//Getters and setters
	public Person getData() {
		return data;
	}


	public void setData(Person data) {
		this.data = data;
	}


	public PersonNode getLeft() {
		return left;
	}


	public void setLeft(PersonNode left) {
		this.left = left;
	}


	public PersonNode getRight() {
		return right;
	}


	public void setRight(PersonNode right) {
		this.right = right;
	}


	public int getColour() {
		return colour;
	}


	public void setColour(int colour) {
		this.colour = colour;
	}


	public PersonNode getParent() {
		return parent;
	}


	public void setParent(PersonNode parent) {
		this.parent = parent;
	}

	
}
