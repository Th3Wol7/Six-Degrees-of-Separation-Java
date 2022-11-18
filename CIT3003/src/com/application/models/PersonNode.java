package com.application.models;
/*This class represents a person node utilized in 
 * calculating degree of separation
 * @author Tyrien Gilpin
 * Version 1
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//new ShortestPath(node_A, node_E).bfs();

public class PersonNode implements Comparable<PersonNode>{
	private Person data;
    private boolean visited;
    private List<PersonNode> friends;
    private PersonNode previous;
    //private PersonNode left;
	//private PersonNode right;
	//private int colour;
	//private PersonNode parent;

    
    public PersonNode(Person user) {
    	this.data = user;
    	this.visited = false;
    	this.friends = new ArrayList<PersonNode>();
    	this.previous = null;
    }
    
    
    public PersonNode(Person user, Collection<Person> neighbours){
    	this.data = user;
    	this.friends = adjacent(neighbours);
    	this.visited = false;
    	this.previous = null;
    }
    
    public void addNeighbour(PersonNode node) {
    	friends.add(node);
    	//node.getFriends().add(this);
    }
    
    public List<PersonNode> adjacent(Collection<Person> neighbours){
    	List<PersonNode> converted =  new ArrayList<PersonNode>();
    	for(Person person: neighbours) {
    		converted.add(new PersonNode(person));
    	}
    	return converted;
    }
 
    public Person getData() {
		return data;
	}
	public void setData(Person data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<PersonNode> getFriends() {
		return friends;
	}
	public void setFriends(List<PersonNode> friends) {
		this.friends = friends;
	}
	public PersonNode getPrevious() {
		return previous;
	}
	public void setPrevious(PersonNode previous) {
		this.previous = previous;
	}


	@Override
	public String toString() {
		return "PersonNode [getData()=" + getData() + ", isVisited()=" + isVisited() + ", getFriends()=" + getFriends()
				+ ", getPrevious()=" + getPrevious() + "]";
	}


	@Override
	public int compareTo(PersonNode obj) {
		// TODO Auto-generated method stub
		return this.getData().getFirstName().compareTo(obj.getData().getFirstName());
	}


    
}
