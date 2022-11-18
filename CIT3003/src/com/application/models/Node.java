package com.application.models;
/*This class represents A user node and it's attributes 
 * @author Tyrien Gilpin
 * Version 1
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node<Person> implements Comparable<Node<Person>> {

	// Node attributes
	private final Person user;
	private Integer distance = Integer.MAX_VALUE;
	private List<Node<Person>> shortestPath = new LinkedList<>();
	private Map<Node<Person>, Integer> adjacentNodes = new HashMap<>();
	private Person data;
	private Node left;
	private Node right;
	private int colour;
	private Node parent;

	public Node(Person person) {
		this.user = person;
		this.data = person;
		this.left = null;
		this.right = null;
		this.colour = 1; // Where 1 representsred
		this.parent = null;
	}

	// Default Constructor
	public Node() {
		this.user = null;
		this.data = null;
		this.left = null;
		this.right = null;
		this.colour = 1; // Where 1 represents red
		this.parent = null;
	}

	// Primary Constructor
	public Node(Person data, Node left, Node right, int colour, Node parent) {
		this.user = null;
		this.data = data;
		this.left = right;
		this.right = right;
		this.colour = colour;
		this.parent = parent;
	}

	public void addAdjacentNode(Node<Person> node, int weight) {
		adjacentNodes.put(node, weight);
	}

	@Override
	public int compareTo(Node node) {
		return Integer.compare(this.distance, node.getDistance());
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public List<Node<Person>> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node<Person>> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Map<Node<Person>, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node<Person>, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public Person getUser() {
		return user;
	}

	// Getters and setters
	public Person getData() {
		return data;
	}

	public void setData(Person data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

}
