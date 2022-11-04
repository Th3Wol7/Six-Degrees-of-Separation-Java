package com.application.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import com.application.models.Person;

public class SocialNetworkService {
	
	private TreeMap<Person, Collection<Person>> network = new TreeMap<Person, Collection<Person>>();
	 //you might want to write a helper method; you might want to make it recursive;
	 //and you might want to read about in-order tree
	
	public TreeMap<Person, Collection<Person>> getNetwork() {
		return network;
	}


	public void setNetwork(TreeMap<Person, Collection<Person>> network) {
		this.network = network;
	}


	//This method returns a collection of the users that are
	//immediate friends of the user passed to the method
	Collection<Person> userFriends(Person user){
		return network.get(user);
	}
	
	
	//Stores a person in map and adds the list of his/her friends to the
	//node in the network
	public void addPerson(Person user) {
		network.put(user, new ArrayList<>());
	}
	
	//This methods makes a connection between two friends in the Social network
	public void addFriend(Person user, Person friend) {
		//Checking the existence of both friends in the Map- Might not be necessary
		if(!(network.containsKey(user))) {
			addPerson(user);
		}
		if(!(network.containsKey(friend))) {
			addPerson(user);
		}
		
		//Creating link between the two persons in the network
		network.get(user).add(friend);
		network.get(friend).add(user);		
	}
	
	
}
