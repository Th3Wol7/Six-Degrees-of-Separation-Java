package com.application.network;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import java.util.List;
import java.util.Map;

import java.util.Set;
//import org.apache.commons.lang3.StringUtils;
import com.application.models.Person;


public class FindSeperation {
	private  List<String> Activities;

	private final SocialNetworkService socialNet;

	// NTS: remember to Synchronize the tree for threading
	public FindSeperation(){
		this.socialNet = new SocialNetworkService();
	
	}

	FindSeperation(SocialNetworkService sns) {
		socialNet = sns;
	}
	
	/*public List<String> getActivities() {
		return Activities;
	}

	
	private static List<String> getActivities(){
		return new ArrayList<>(Arrays.asList("run", "walk/jog", "Fascinated by nike", "Listen to music", 
				"Take photographs", "read", "playing game", "eduactor","i am a advocate","i love designing" ,
				"fascinated by art","Lifestyle is Everything", "i am a computer geek", "fascinated by Pets",
				"Gardening", "Get a manicure or pedicure", "Cooking", "volunteering"));
		 
	 }*/
	// Returns the degree of separation between users in the social
	// network via the Dijkstra's algorithm another shortest path algorithm
	// or you could create your own conside the bidirectional search algorithm to
	// reduce time complexity where first half is searched using BFS and second half
	// search using
	// DFS. Implication? you might visit one node twice that must be mitigated
	// during
	// divide bfs....bidirectional search employs divide and conquer techniques
	public int degreeOfSeperation(Person user, Person friend) {
		if (friendsMatch(user, friend) == true) {
			System.out.print("Degree of seperation between" + user.getUsername() + " & " + friend.getUsername()
					+ " is 1. Because they are direct friends");
			return 1;
		} else {
			// search degree of separation
			// need to be filled with code
		}
		return -1;
	}

	// This method returns a list of all the person in the network
	// that is a friend of user passed to the method.
	// It should jump to the person node and store the nodes that have direct
	// connections
	// to the user passed to the function
	public List<Person> findFriends(Person user) {
		Collection<Person> currentFriends = new ArrayList<>();
		currentFriends = getSocialNet().getNetwork().get(user);// storing user's current friends
		return (List<Person>) currentFriends;
	}

	// Getter
	public SocialNetworkService getSocialNet() {
		return socialNet;
	}

	// This method checks if one person is a friend of the other
	public boolean friendsMatch(Person user, Person friend) {
		if (findFriends(user) != null) {// If user has friends then...
			for (Person person : findFriends(user)) {
				if (friend.equals(person)) {
					return true;
				}
			}
		}
		return false;
	}

	// This method returns a list of users in the network that share the same
	// employer, school or community. Ensure that each node is only checked once
	// ensure that each node is check before stopping
	public List<Person> SuggestsFriends(Person user) {
		List<Person> suggestedFriends = new ArrayList<>();
		try {
			Set<Map.Entry<Person, Collection<Person>>> entries = getSocialNet().getNetwork().entrySet();

			entries.forEach(entry -> {

				// if person in the network is of same community, school or employer as user
				if (entry.getKey().getCommunity().equals(user.getCommunity())
						|| entry.getKey().getEmployer().equals(user.getEmployer())
						|| entry.getKey().getSchool().equals(user.getSchool())) {

					// if current person in network is not on users friends list
					// then add the user to the suggested friends list
					if (friendsMatch(user, entry.getKey()) == false) {
						suggestedFriends.add(entry.getKey());
					}
				}

				// System.out.println(entry.getKey() + "->"
				// + entry.getValue());
			});

		} catch (NullPointerException ne) {
			System.out.println("Null pointer Exception Thrown in friend finder class");
			ne.printStackTrace();
		} catch (UnsupportedOperationException uoe) {
			System.out.println("UnsupportedOperationException Thrown in friend finder class");
			uoe.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Exception Thrown in friend finder class suggestedfriends methos");
			ex.printStackTrace();
		}

		return suggestedFriends;
	}
	
	
	
	
		//This method returns a list of activities suggestions to a user based 
		//on the activities of the users in the network that share the same
		// employer, school or community. Ensure that each node is only checked once
		// ensure that each node is check before stopping
		/*for(i=1; i<=n; i++) {
		activity = getActivities();
		}*/
		public List<String> SuggestsActivities(Person user) {
			List<String> activities = new ArrayList<>();

			try {
				Set<Map.Entry<Person, Collection<Person>>> entries = getSocialNet().getNetwork().entrySet();
				entries.forEach(entry -> {
					// if person in the network is of same community, school or employer as user
					if (entry.getKey().getCommunity().equals(user.getCommunity())
							|| entry.getKey().getEmployer().equals(user.getEmployer())
							|| entry.getKey().getSchool().equals(user.getSchool())) {
						if (user.getActivity() != null) {
							int index = -1;
							for (String activity : user.getActivity()) {
								while (entry.getKey().getActivity().get(index++) != null) {
									int i = index++;
									/*
									 * boolean compare; compare = user.getActivity().get(i++)
									 * .equalsIgnoreCase(entry.getKey().getActivity().get(i++)); if (compare ==
									 * true) { System.out.println("match:" + compare); } else {
									 * System.out.println("The list of activity" + compare);
									 */
									if (entry.getKey().getActivity().containsIgnoreCase(user.getActivity().get(i++))) {
										System.out.println("The user is participating in these activities already.");

									} else {
										activities.add(entry.getKey().getActivity().get(i++));
									}
									// }
								}
							}
						}

					}
				});

			} catch (NullPointerException ne) {
				System.out.println("Null pointer Exception Thrown in friend finder class");
				ne.printStackTrace();
			} catch (UnsupportedOperationException uoe) {
				System.out.println("UnsupportedOperationException Thrown in friend finder class");
				uoe.printStackTrace();
			} catch (Exception ex) {
				System.out.println("Exception Thrown in friend finder class suggestedfriends methos");
				ex.printStackTrace();
			}
			System.out.println(activities);
			return activities;
		}
	
		//This method should determine the average degree of separation of the nodes in the tree
		//then return the value
		public int averageDegreeOfSeperation() {
			
			return 0;
		}
	
		/*Add an implementation of how the activities of a user
		 *  will be tracked and stored in the file database.
		 *  Ensure that proper connections are made in 
			conformity with TreeMap and our current implementation
		 */
				


}
