package com.application.models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Vertex<Person> {

    private final Person data;
    private boolean visited;
    private List<Vertex<Person>> friends;
    private Vertex<Person> previous;
    
    
    public Vertex(Person user) {
    	this.data = user;
    	this.visited = false;
    	this.friends =new LinkedList<Vertex<Person>>();
    	this.previous = null;
    }
    
    public Vertex(Person user, Collection<Person> friends){
    	this.data = user;
    	this.friends = convertToVectorList(friends);
     	this.visited = false;
     	this.previous = null;
    }
  
    
    public Vertex<Person> getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex<Person> previous) {
		this.previous = previous;
	}

	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex<Person>> getFriends() {
		return friends;
	}

	public void setFriends(List<Vertex<Person>> friends) {
		this.friends = friends;
	}

	public Person getData() {
		return data;
	}
	
	public 	List<Vertex<Person>>  convertToVectorList(Collection<Person> friends) {
		List<Vertex<Person>> converted =  new LinkedList<Vertex<Person>>();
    	for(Person person: friends) {
    		converted.add(new Vertex<Person>(person));
    	}
    	return converted;
	}
    
}
