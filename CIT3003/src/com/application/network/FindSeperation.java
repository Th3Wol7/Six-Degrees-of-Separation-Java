package com.application.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import com.application.models.Person;
import com.application.models.PersonNode;
import com.application.utils.network.BreadthFirstSearch;

public class FindSeperation {
	private final SocialNetworkService socialNet;

	// NTS: remember to Synchronize the tree for threading
	public FindSeperation() {
		this.socialNet = new SocialNetworkService();
		socialNet.createNetwork();// For Testing purposes
		List<String> activity = new ArrayList<>();
		List<String> activity2 = new ArrayList<>();
		List<String> activity3 = new ArrayList<>();
		List<String> activity4 = new ArrayList<>();
		activity.add("reading");// For Testing purposes
		activity.add("movie");// For Testing purposes
		activity.add("running");// For Testing purposes

		// reading,movie,running
		activity2.add("reading");
		activity2.add("dancing");
		activity2.add("shopping");

		activity3.add("volunteering");
		activity3.add("running");
		activity3.add("dancing");
	
		activity4.add("running");
		activity4.add("reading");
		activity4.add("volunteering");
		Person person = new Person("kfly4", "Kermait", "Ffly", "8765672010", "KeroFfly10@yahoo.com", "Papine", "UTECH",
				"none", 0, activity);

		Person person2 = new Person("jib1731", "Jim", "Bibby", "8765672032", "Jibibby032@gmail.com", "Papine", "UTECH",
				"none", 0, activity2);

		Person person3 = new Person("Kareem235", "Kareem", "Feather", "8764132519", "KaFeat56@gmail.com", "Portmore",
				"none", "none", 0, activity3);

		// System.out.println(suggestActivities(person)); Testing suggested activities
		// method
		
		Person person4 = new Person("aks1738", "Ackeem", "Shwarct", "8765672033", "Ackshwarct033@gmail.com", "Papine",
				"UTECH", "none", 0, activity4);
		
		System.out.println(suggestFriends(person4)); // for testing 
		
		if (!(socialNet.getNetwork().isEmpty())) {// For Testing purposes
			System.out.print(degreeOfSeperation(person, person2));
		}
	}

	FindSeperation(SocialNetworkService sns) {
		socialNet = sns;
	}

	// Getter
	public SocialNetworkService getSocialNet() {
		return socialNet;
	}

	// Returns the degree of separation between users in the social
	public String degreeOfSeperation(Person user, Person user2) {
		String output = "";
		if (friendsMatch(user, user2) == true) {
			output+= "Degree of seperation between" + user.getUsername() + " & " + user2.getUsername()
					+ " is 1. Because they are direct friends" + "\n1";
			return output;
		} else {
			// If any of of the users friends is a friend of user2 return 2 degrees of
			// separation because they both have a mutual friend that they is 1 degree from
			// them
			if (findFriends(user) != null) {// If user has friends then...
				for (Person person : findFriends(user)) {
					// for all friends in the source list
					// if that friends Username = any Friend friends Username
					for (Person person2 : getSocialNet().getNetwork().get(user2)) {
						if (person2.getUsername().equals(person.getUsername())) {
							output+= "Degree of seperation between " + user.getFirstName() + " & "
									+ user2.getFirstName() + " is 2 because they share a mutual friend.\nDegree:\n2";
							return output;
						}
					}
				}
			}

			TreeMap<PersonNode, Collection<PersonNode>> RBTree = new TreeMap<PersonNode, Collection<PersonNode>>();
			Set<Map.Entry<Person, Collection<Person>>> entries = getSocialNet().getNetwork().entrySet();
			entries.forEach(entry -> {
				PersonNode NodeA = new PersonNode(entry.getKey());
				for (Person src : entry.getValue()) {
					NodeA.addNeighbour(new PersonNode(src));
				}
				RBTree.put(NodeA, NodeA.getFriends());
				/*
				 * OR PersonNode NodeB = new PersonNode(entry.getKey, entry.getValue);
				 * RBTree.put(NodeB, NodeB.getFriends());
				 */

			});

			PersonNode nodeC = new PersonNode(user);
			for (Person src1 : getSocialNet().getNetwork().get(user)) {
				nodeC.addNeighbour(new PersonNode(src1));
			}
			PersonNode nodeB = new PersonNode(user2);
			for (Person src2 : getSocialNet().getNetwork().get(user2)) {
				nodeB.addNeighbour(new PersonNode(src2));
			}

			return new BreadthFirstSearch(nodeC, nodeB, RBTree).separationDegree();
		}
	}

	// This method returns a list of all the friends of a person in the network
	public List<Person> findFriends(Person user) {// Working
		Collection<Person> currentFriends = new ArrayList<>();
		currentFriends = getSocialNet().getNetwork().get(user);// storing user's current friends
		return (List<Person>) currentFriends;
	}

	// This method checks if one person is a friend of the other
	public boolean friendsMatch(Person user, Person friend) {// working
		if (findFriends(user) != null) {// If user has friends then...
			for (Person person : findFriends(user)) {
				if (friend.getUsername().equalsIgnoreCase(person.getUsername())) {
					return true;
				}
			}
		}
		return false;
	}

	// This method returns a list of users in the network that share the same
	// employer, school or community.
	public List<Person> suggestFriends(Person user) {
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
						if(user.getUsername().equals(entry.getKey().getUsername())) {
							//System.out.println("user cannot be friend with themselves");
							suggestedFriends.remove(entry.getKey());
						}else {
						suggestedFriends.add(entry.getKey());
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

		return suggestedFriends;
	}

	
	public List<String> suggestActivities(Person user) {
		List<String> activitySuggestions = new ArrayList<>();
		try {
			Set<Map.Entry<Person, Collection<Person>>> entries = getSocialNet().getNetwork().entrySet();
			entries.forEach(entry -> {
				// if person in the network is of same community, school or employer as user
				if (entry.getKey().getCommunity().equals(user.getCommunity())
						|| entry.getKey().getEmployer().equals(user.getEmployer())
						|| entry.getKey().getSchool().equals(user.getSchool())) {
					if (user.getActivity() != null) {
						for (String entryActivity : entry.getKey().getActivity()) {// for every string in the user
																					// activity list
							boolean contains = user.getActivity().stream().anyMatch(entryActivity::equalsIgnoreCase);
							if (contains == false) {// if on users activity list
								boolean addCheck = activitySuggestions.stream()
										.anyMatch(entryActivity::equalsIgnoreCase);
								if (addCheck == false) {// if activity is not already added to suggested activity list
									activitySuggestions.add(entryActivity);
								}
							}
						}
					} else {
						for (String entryActivity : entry.getKey().getActivity()) {// for every string in the user
																					// activity list
							boolean addCheck = activitySuggestions.stream().anyMatch(entryActivity::equalsIgnoreCase);
							if (addCheck == false) {// if activity is not already added to suggested activity list
								activitySuggestions.add(entryActivity);
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

		return activitySuggestions;
	}

	// This method determine the average degree of separation of the nodes in the
	// tree
	public int averageDegreeOfSeperation() {

		return 0;
	}

}
