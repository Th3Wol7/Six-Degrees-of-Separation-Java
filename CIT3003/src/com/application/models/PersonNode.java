package com.application.models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

//new ShortestPath(node_A, node_E).bfs();

public class PersonNode {
	private Person data;
    private boolean visited;
    private List<PersonNode> friends;
    private PersonNode previous;
	
    
    public PersonNode(Person user) {
    	this.data = user;
    	this.visited = false;
    	this.friends = new LinkedList<PersonNode>();
    	this.previous = null;
    }
    
    
    public PersonNode(Person user, Collection<Person> neighbours){
    	this.data = user;
    	this.friends = adjacent(neighbours);
    	this.visited = false;
    	this.previous = null;
    }
    
    public void addNeighbour(PersonNode node) {
    	this.friends.add(node);
    	node.getFriends().add(this);
    }
    
    public List<PersonNode> adjacent(Collection<Person> neighbours){
    	List<PersonNode> converted =  new LinkedList<PersonNode>();
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
    
}
