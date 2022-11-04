package com.application.network;

import java.util.ArrayList;
import java.util.List;

import com.application.models.Person;

public class FindSeperation {
	private final SocialNetworkService socialNet;
	//NTS: remember to Synchronize the tree for threading
	
	FindSeperation(SocialNetworkService sns){
		socialNet = sns;
	}
	
	
	//Returns the degree of separation between users in the social
	//network via the Dijkstra's algorithm another shortest path algorithm
	//or you could create your own conside the bidirectional search algorithm to 
	//reduce time complexity where first half is searched using BFS and second half search using 
	//DFS. Implication? you might visist one node twice that must be mitigated during 
	//divide bfs....bidirectional search employs divide and conquer techniques
	public int degreeOfSeperation(Person user, Person friend) {
	
		return -1;
	}
	
	
	//This method returns a list of all the person in the network
	//that is a friend of user passed to the method.
	//It should jump to the person node and store the nodes that have direct connections
	//to the user passed to the function
	public List<Person>findFriends(Person user){
		List<Person> friendList = new ArrayList<>();
		return null;
		//return null;
	}
	
	//This method returns a list of users in the network that share the same
	//employer, school or community. Ensure that each node is only checked onces
	//ensure that each node is check before stopping
	public List<Person>SuggestsFriends(Person user){
		
		return null;
	}
	
	
	
	
	
}
