package com.application.network;
/*This class represents the model and attributes of the network
 * @author Tyrien Gilpin
 * Version 1
 */

import com.application.models.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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


    /*
    // This method retrieves user data from the file com.database.database and create the network
    // with connections
    public void createNetwork() {
        Scanner inFileStream1 = null;
        Scanner inFileStream2 = null;
        Scanner inFileStream3 = null;
        Scanner inFileStream4 = null;
        Person person = null, person2 = null;
        try {
            inFileStream1 = new Scanner(new File("CIT3003/src/com/application/database/peopleCopy.txt"));
            inFileStream2 = new Scanner(new File("CIT3003/src/com/application/database/friends.txt"));
            inFileStream3 = new Scanner(new File("CIT3003/src/com/application/database/peopleCopy.txt"));
            inFileStream4 = new Scanner(new File("CIT3003/src/com/application/database/ActivitiesCopy.txt"));
            while (inFileStream1.hasNext()) { // #while 1
                String username = inFileStream1.next();
                String firstName = inFileStream1.next();
                String lastName = inFileStream1.next();
                String phone = inFileStream1.next();
                String email = inFileStream1.next();
                String community = inFileStream1.next();
                String school = inFileStream1.next();
                String employer = inFileStream1.next();
                int privacy = inFileStream1.nextInt();

                List<String> activities = new ArrayList<>(); // Accounting for activity
                inFileStream4 = new Scanner(new File("CIT3003/src/com/application/database/ActivitiesCopy.txt"));
                while (inFileStream4.hasNext()) {// #while 2
                    if (username.equals(inFileStream4.next())) {
                        String actUser = inFileStream4.next();// this variables are necessary
                        String actFName = inFileStream4.next();// this variables are necessary
                        String act = inFileStream4.next();
                        String act1[] = act.split(",");
                        for (int i = 0; i < act1.length; i++) {
                            activities.add(act1[i]);
                        }
                        // System.out.println(activities); For testing
                        // resetting in file stream
                        break;// exit #while 2
                    }
                }
                person = new Person(username, firstName, lastName, phone, email, community, school, employer, privacy,
                        activities);

                Collection<Person> friends = new ArrayList<>();
                inFileStream2 = new Scanner(new File("CIT3003/src/com/application/database/friends.txt"));
                // #while 3
                while (inFileStream2.hasNextLine()) {// Reading the friends list an entire line at a time
                    String[] friendsListing;
                    // System.out.println(inFileStream2.hasNextLine());//For Testing purposes
                    // Separating words in line to retrieve individual friend user names
                    friendsListing = inFileStream2.nextLine().split("\\s+");

                    // If the first ID number of the line is equal to that of the current person
                    if (friendsListing[0].equalsIgnoreCase(person.getUsername())) {
                        inFileStream3 = new Scanner(new File("CIT3003/src/com/application/database/peopleCopy.txt"));
                        while (inFileStream3.hasNext()) {// Reading the com.database.database again //#while 4
                            String username2 = inFileStream3.next();
                            String firstName2 = inFileStream3.next();
                            String lastName2 = inFileStream3.next();
                            String phone2 = inFileStream3.next();
                            String email2 = inFileStream3.next();
                            String community2 = inFileStream3.next();
                            String school2 = inFileStream3.next();
                            String employer2 = inFileStream3.next();
                            // System.out.println(employer2);///For testing
                            int privacy2 = inFileStream3.nextInt();
                            ArrayList<String> activities2 = new ArrayList<>(); // Accounting for activity
                            inFileStream4 = new Scanner(new File("CIT3003/src/com/application/database/ActivitiesCopy.txt"));
                            while (inFileStream4.hasNext()) {// #while 5
                                if (username2.equals(inFileStream4.next())) {
                                    String actUser = inFileStream4.next();// this variables are necessary
                                    String actFName = inFileStream4.next();// this variables are necessary
                                    String act = inFileStream4.next();
                                    String act1[] = act.split(",");
                                    for (int i = 0; i < act1.length; i++) {
                                        activities2.add(act1[i]);
                                    }
                                    // resetting in file stream
                                    break;// exit #while 2
                                }
                            }
                            person2 = new Person(username2, firstName2, lastName2, phone2, email2, community2, school2,
                                    employer2, privacy2, activities2);

                            // Check if any user name retrieved from the friends list
                            // matches the user name of the current person that was read
                            for (int i = 1; i < friendsListing.length; i++) {
                                if (person2.getUsername().equalsIgnoreCase(friendsListing[i])) {
                                    friends.add(person2);
                                    // System.out.println(person2);//For Testing Purposes
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
                inFileStream4.close();
            }
        }
    }
*/
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

    // remove a person from the network
    public void removePerson(Person user) {
        network.remove(user);
        Set<Map.Entry<Person, Collection<Person>>> entries = getNetwork().entrySet();
        entries.forEach(entry -> { // For each person in the network
            for (Person friend : entry.getValue()) {// for each of their friends
                if (friend.equals(user)) {// if their friends is the user being removed,
                    entry.getValue().remove(user);// remove the user as that persons friend

                }
            }
        });
    }

    // This methods makes a connection between two friends in the Social network
    public void addFriend(Person user, Person friend) {
        // Checking the existence of both friends in the Map- Might not be necessary
        if (!(network.containsKey(user))) {
            addPerson(user);
        }
        if (!(network.containsKey(friend))) {
            addPerson(friend);
        }

        // Creating link between the two persons in the network by adding a friend
        // to the collections of friends assigned to the user node data value
        network.get(user).add(friend);
        network.get(friend).add(user);
    }

    public void removeFriend(Person user, Person friend) {
        // Checking the existence of both friends in the Map- Might not be necessary
        if (!(network.containsKey(user))) {
            addPerson(user);
        }
        if (!(network.containsKey(friend))) {
            addPerson(friend);
        }

        // removing link between the two persons in the network by adding a friend
        // to the collections of friends assigned to the user node data value
        network.get(user).remove(friend);
        network.get(friend).remove(user);
    }

    //This method retrieves user data from the file com.database.database and create the network with connections
    public void createNetwork2() {
        Scanner inFileStream1 = null;
        Scanner inFileStream2 = null;
        Person person = null, person2 = null;
        try {
            // Open the files
            inFileStream1 = new Scanner(new File("CIT3003/src/com/application/database/peopleCopy.txt"));
            inFileStream2 = new Scanner(new File("CIT3003/src/com/application/database/friends.txt"));
            // Read each line of the people file
            while (inFileStream1.hasNext()) {
                // Read the values for the current person
                String username = inFileStream1.next();
                String firstName = inFileStream1.next();
                String lastName = inFileStream1.next();
                String phone = inFileStream1.next();
                String email = inFileStream1.next();
                String community = inFileStream1.next();
                String school = inFileStream1.next();
                String employer = inFileStream1.next();
                int privacy = inFileStream1.nextInt();

                // Read the activities for the current person
                List<String> activities = new ArrayList<>();
                Scanner inFileStream4 = new Scanner(new File("CIT3003/src/com/application/database/ActivitiesCopy.txt"));
                while (inFileStream4.hasNext()) {
                    if (username.equals(inFileStream4.next())) {
                        String actUser = inFileStream4.next();
                        String actFName = inFileStream4.next();
                        String act = inFileStream4.next();
                        String[] act1 = act.split(",");
                        for (int i = 0; i < act1.length; i++) {
                            activities.add(act1[i]);
                        }
                        break;
                    }
                }
                inFileStream4.close();

                // Create a Person object for the current person
                person = new Person(username, firstName, lastName, phone, email, community, school, employer, privacy,
                        activities);

                // Read the friends list for the current person
                Collection<Person> friends = new ArrayList<>();
                // Read each line of the friends file
                while (inFileStream2.hasNextLine()) {
                    String[] friendsListing = inFileStream2.nextLine().split("\\s+");
                    // If the first ID number of the line is equal to that of the current person
                    if (friendsListing[0].equalsIgnoreCase(person.getUsername())) {
                        Scanner inFileStream3 = new Scanner(new File("CIT3003/src/com/application/database/peopleCopy.txt"));
                        // Read each line of the people file
                        while (inFileStream3.hasNext()) {
                            // Read the values for the current friend
                            String username2 = inFileStream3.next();
                            String firstName2 = inFileStream3.next();
                            String lastName2 = inFileStream3.next();
                            String phone2 = inFileStream3.next();
                            String email2 = inFileStream3.next();
                            String community2 = inFileStream3.next();
                            String school2 = inFileStream3.next();
                            String employer2 = inFileStream3.next();
                            int privacy2 = inFileStream3.nextInt();

                            List<String> activities2 = new ArrayList<>(); // Accounting for activity
                            inFileStream4 = new Scanner(new File("CIT3003/src/com/application/database/ActivitiesCopy.txt"));
                            while (inFileStream4.hasNext()) {// #while 5
                                if (username2.equals(inFileStream4.next())) {
                                    String actUser2 = inFileStream4.next();// these variables are necessary
                                    String actFName2 = inFileStream4.next();// these variables are necessary
                                    String act2 = inFileStream4.next();
                                    String act12[] = act2.split(",");
                                    for (int i = 0; i < act12.length; i++) {
                                        activities2.add(act12[i]);
                                    }
                                    // resetting in file stream
                                    break;// exit #while 5
                                }
                            }

                            // Create a new person object for the current friend
                            person2 = new Person(username2, firstName2, lastName2, phone2, email2, community2, school2,
                                    employer2, privacy2, activities2);

                            // Add the current friend to the list of friends
                            friends.add(person2);
                        }

                        // Add the current person and their list of friends to the network
                        getNetwork().put(person, friends);
                    }

                    inFileStream1.close();
                    inFileStream2.close();
                    //inFileStream3.close();
                    inFileStream4.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


	//optimized function
	public void createNetwork() {
		Map<String, Person> peopleMap = new HashMap<>();
		Map<String, List<String>> friendsMap = new HashMap<>();
		Map<String, List<String>> activitiesMap = new HashMap<>();

		try {
			Scanner peopleScanner = new Scanner(new File("CIT3003/src/com/application/database/peopleCopy.txt"));
			Scanner friendsScanner = new Scanner(new File("CIT3003/src/com/application/database/friends.txt"));
			Scanner activitiesScanner = new Scanner(new File("CIT3003/src/com/application/database/ActivitiesCopy.txt"));

			while (peopleScanner.hasNext()) {
				String username = peopleScanner.next();
				String firstName = peopleScanner.next();
				String lastName = peopleScanner.next();
				String phone = peopleScanner.next();
				String email = peopleScanner.next();
				String community = peopleScanner.next();
				String school = peopleScanner.next();
				String employer = peopleScanner.next();
				int privacy = peopleScanner.nextInt();

				Person person = new Person(username, firstName, lastName, phone, email, community, school, employer, privacy, new ArrayList<>());
				peopleMap.put(username, person);
			}

			while (friendsScanner.hasNextLine()) {
				String[] friendsListing;
				friendsListing = friendsScanner.nextLine().split("\\s+");
				friendsMap.put(friendsListing[0], Arrays.asList(friendsListing).subList(1, friendsListing.length));
			}

			while (activitiesScanner.hasNext()) {
				String username = activitiesScanner.next();
				String actUser = activitiesScanner.next();
				String actFName = activitiesScanner.next();
				String act = activitiesScanner.next();
				String act1[] = act.split(",");
				activitiesMap.put(username, Arrays.asList(act1));
			}

			for (Person person : peopleMap.values()) {
				person.setActivity(activitiesMap.get(person.getUsername()));

				/*List<Person> friendsList = new ArrayList<>();
				for (String friendUsername : friendsMap.get(person.getUsername())) {
					friendsList.add(peopleMap.get(friendUsername));
				}*/
                List<Person> friendsList = new ArrayList<>();
                List<String> friendUsernames = friendsMap.get(person.getUsername());
                if (friendUsernames != null) {
                    for (String friendUsername : friendUsernames) {
                        friendsList.add(peopleMap.get(friendUsername));
                    }
                }



                network.put(person, friendsList);
			}

			peopleScanner.close();
			friendsScanner.close();
			activitiesScanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
