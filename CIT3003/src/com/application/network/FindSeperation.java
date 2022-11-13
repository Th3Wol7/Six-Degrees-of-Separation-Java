package com.application.network;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

import com.application.models.Node;
//import org.apache.commons.lang3.StringUtils;
import com.application.models.Person;
import com.application.models.PersonNode;
import com.application.utils.network.BreadthFirstSearch;


public class FindSeperation {
	private  List<String> Activities;

	private final SocialNetworkService socialNet;

	// NTS: remember to Synchronize the tree for threading
	public FindSeperation(){
		this.socialNet = new SocialNetworkService();
		socialNet.createNetwork();//For Testing purposes 
		List<String> activity = new ArrayList<>();
		List<String> activity2 = new ArrayList<>();
		List<String> activity3 = new ArrayList<>();
		activity.add("reading");//For Testing purposes
		activity.add("movie");//For Testing purposes
		activity.add("running");//For Testing purposes
		
		//reading,movie,running
		activity2.add("reading");
		activity2.add("dancing");
		activity2.add("shopping");
		
		activity3.add("volunteering");
		activity3.add("running");
		activity3.add("dancing");
	
		
		Person person = new Person("kfly4",	"Kermait", "Ffly", "8765672010", "KeroFfly10@yahoo.com", "Papine",
							"UTECH", "none", 0, activity);
		
		Person person2 = new Person("jib1731", "Jim", "Bibby", "8765672032",	
							"Jibibby032@gmail.com", "Papine", "UTECH", "none" , 0, activity2);
		
		Person person3 = new Person("Kareem235","Kareem", "Feather", "8764132519", "KaFeat56@gmail.com", "Portmore", 
							"none", "none", 	0, activity3);
		
		if(!(socialNet.getNetwork().isEmpty())) {//For Testing purposes
			//System.out.println(getSocialNet().getNetwork().get(person));
			System.out.println(degreeOfSeperation(person, person2));	
		}
	}

	FindSeperation(SocialNetworkService sns) {
		socialNet = sns;
	}
	
	//Getter
	public SocialNetworkService getSocialNet() {
		return socialNet;
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
	public int degreeOfSeperation(Person user, Person user2) {
		if (friendsMatch(user, user2) == true) {
			System.out.print("Degree of seperation between" + user.getUsername() + " & " + user2.getUsername()
					+ " is 1. Because they are direct friends");
			return 1;
		} else {
			
		//If any of of the users friends is a friend of user2 return 2 degrees of separation	
		//two because they both have mutual friends that they are 1 degree away from
		//otherwise keep looping and record the 6 degree of separation
		if (findFriends(user) != null) {// If user has friends then...
			for (Person person : findFriends(user)) {
				List<Person> matches = new ArrayList<>();
				//for all friends in the source list
				//if that friends IDnumber equals to any frined in the destination
				for(Person person2: getSocialNet().getNetwork().get(user2)) {
				if (person2.getUsername().equals(person.getUsername())) {
					System.out.print("Degree of seperation between " + user.getFirstName() + " & " + user2.getFirstName()
					+ " is 2. Because they share a mutual friend.\nDegree: ");
					return 2;
				}
				}
			}					
		}
		return -1;
		
		/*PersonNode nodeA = new PersonNode(user);
		for(Person src1: getSocialNet().getNetwork().get(user)) {
			nodeA.addNeighbour(new PersonNode(src1));
		}
		
		PersonNode nodeB = new PersonNode(user2);
		for(Person src2: getSocialNet().getNetwork().get(user)) {
			System.out.println(src2);
			nodeB.addNeighbour(new PersonNode(src2));
		}
		
		return new BreadthFirstSearch(nodeA, nodeB).separationDegree();
		*/
		//Here we want to say, if we search and realize that the two person are not friends
		//then we search their individual friends list and find that the are no mutual friends there
		//we need to search the friends of the user's friends to see if any of them are friends with 
		//the user2's friends
		
		
		
		
		/*if (findFriends(user) != null) {// If user has friends then...
			List<Person> matches = new ArrayList<>();
			int i = 0;
			for (Person person : findFriends(user)) {
				
				if(getSocialNet().getNetwork().get(user2).contains(person)) {
					matches.add(person);
				}
				i++;
			}
			//If nothing is in the list
			if(matches == new ArrayList<Person>()) {
					for (Person person : findFriends(user)) {//for each friend of a the user	
						for(Person userFriends : getSocialNet().getNetwork().get(person)){//for each friend of the user friend
							if(!(matches.contains(userFriends))) {
								matches.add(userFriends);
								
							}
						}	
				}
				
			}
			
		}*/	
		}
	}

	
	//This method returns a list of all the friends of a person in the network
	public List<Person> findFriends(Person user) {//Working
		Collection<Person> currentFriends = new ArrayList<>();
		currentFriends = getSocialNet().getNetwork().get(user);// storing user's current friends
		return (List<Person>) currentFriends;
	}

	// This method checks if one person is a friend of the other
	public boolean friendsMatch(Person user, Person friend) {//working
		if (findFriends(user) != null) {// If user has friends then...
			for (Person person : findFriends(user)) {
				if (friend.getUsername().equalsIgnoreCase(person.getUsername())) {
					return true;
				}
			}
		}
		return false;
	}

	//This method returns a list of users in the network that share the same
	//employer, school or community. 
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
									if (entry.getKey().getActivity().contains(user.getActivity().get(i++))) {
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

			return activities;
		}
	
		//This method determine the average degree of separation of the nodes in the tree
		public int averageDegreeOfSeperation() {
			
			return 0;
		}
	
}
