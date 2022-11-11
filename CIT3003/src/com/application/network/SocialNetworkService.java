package com.application.network;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.application.models.Person;

public class SocialNetworkService {
	
	private TreeMap<Person, Collection<Person>> network = new TreeMap<Person, Collection<Person>>();
	// you might want to write a helper method; you might want to make it recursive;
	// and you might want to read about in-order tree

	public TreeMap<Person, Collection<Person>> getNetwork() {
		return network;
	}

	public void setNetwork(TreeMap<Person, Collection<Person>> network) {
		this.network = network;
	}

	//This method retreives user data from the file database and create the network and connections
	public void createNetwork() {
		Scanner inFileStream1 = null;
		Scanner inFileStream2 = null;
		Scanner inFileStream3 = null;
		Person person = null, person2 = null;
		try {
			inFileStream1 = new Scanner(new File("../database/people.txt"));
			inFileStream2 = new Scanner(new File("../database/friends.txt"));
			inFileStream3 = new Scanner(new File("../database/people.txt"));

			while (inFileStream1.hasNext()) {
				String username = inFileStream1.next();
				String firstName = inFileStream1.next();
				String lastName = inFileStream1.next();
				String phone = inFileStream1.next();
				String email = inFileStream1.next();
				String community = inFileStream1.next();
				String school = inFileStream1.next();
				String employer = inFileStream1.next();
				int privacy = inFileStream1.nextInt();
				// ArrayList<String> activities = new ArrayList<>(); //Accounting for activity
				/*
				 * if(inFileStream.nextLine() != null) { activities = (ArrayList<String>)
				 *		 Arrays.asList(inFileStream.nextLine().split("\\s+"));
				 * 
				 *		 //OR!!!!!!!!!!!!! List<String> activityList =
				 * 		 Arrays.stream(inFileStream.nextLine().split("\\s+"))
				 * 		 .collect(Collectors.toList()); // collect to List 
				 * }
				 */
				person = new Person(username, firstName, lastName, phone, email, community, school, 
								employer, privacy /* ,activities2 */);

				Collection<Person> friends = new ArrayList<>();
				while (inFileStream2.hasNextLine()) {// Reading the friends list an entire line at a time
					String[] friendsListing;
					// Separating words in line to retrieve individual friend usernames
					friendsListing = inFileStream2.nextLine().split("\\s+");

					// If the first ID number of the line is equal to that of the current person
					if (friendsListing[0].equalsIgnoreCase(person.getUsername())) {
						while (inFileStream3.hasNext()) {// Reading the database again
							String username2 = inFileStream1.next();
							String firstName2 = inFileStream1.next();
							String lastName2 = inFileStream1.next();
							String phone2 = inFileStream1.next();
							String email2 = inFileStream1.next();
							String community2 = inFileStream1.next();
							String school2 = inFileStream1.next();
							String employer2 = inFileStream1.next();
							int privacy2 = inFileStream1.nextInt();
							// ArrayList<String> activities2 = new ArrayList<>(); //Accounting for activity
							// implementation
							/*
							 * if(inFileStream.nextLine() != null) { activities2 = (ArrayList<String>)
							 * Arrays.asList(inFileStream.nextLine().split("\\s+"));
							 * 
							 * //OR!!!!!!!!!!!!! List<String> activityList2 =
							 * Arrays.stream(inFileStream.nextLine().split("\\s+"))
							 * .collect(Collectors.toList()); // collect to List }
							 */

							person2 = new Person(username2, firstName2, lastName2, phone2, email2, community2,
									school2,employer2, privacy2 /* ,activities2 */);

							// Check if any user name retrieved from the friends list
							// matches the user name of the current person that was read
							for (int i = 1; i < friendsListing.length; i++) {
								if (person2.getUsername().equalsIgnoreCase(friendsListing[i])) {
									friends.add(person2);
								} // search key value
							}
						}
						break;
					}
				}
				network.put(person, friends);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("File could not be found: " + fnfe.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inFileStream1 != null) {
				inFileStream1.close();
			}
		}
	}

	// This method returns a collection of the users that are
	// immediate friends of the user passed to the method
	Collection<Person> userFriends(Person user) {
		return network.get(user);
	}
	
	// Stores a person in map and adds the list of his/her friends to the
	// node in the network
	public void addPerson(Person user) {
		network.put(user, new ArrayList<>());
	}

	// This methods makes a connection between two friends in the Social network
	public void addFriend(Person user, Person friend) {
		// Checking the existence of both friends in the Map- Might not be necessary
		if (!(network.containsKey(user))) {
			addPerson(user);
		}
		if (!(network.containsKey(friend))) {
			addPerson(user);
		}

		// Creating link between the two persons in the network by adding a friend
		// to the collections of friends assigned to the user node data value
		network.get(user).add(friend);
		network.get(friend).add(user);
	}

}
