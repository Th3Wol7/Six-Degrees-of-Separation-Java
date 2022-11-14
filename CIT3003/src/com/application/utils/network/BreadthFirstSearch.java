package com.application.utils.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;


import com.application.models.Person;
import com.application.models.PersonNode;
import com.application.models.Vertex;
import com.application.network.SocialNetworkTree;

public class BreadthFirstSearch/* <Person> */ {
	private Vertex<Person> source;
	private Vertex<Person> end;
	private PersonNode start;
	private PersonNode destination;
	private TreeMap<PersonNode, Collection<PersonNode>> RBTree;
	private List<PersonNode> printer = new ArrayList<>();
	
	public BreadthFirstSearch(Vertex<Person> startVertex, Vertex<Person> endVertex) {
		this.source = startVertex;
		this.end = endVertex;
		traverse();
	}
	
	public BreadthFirstSearch(PersonNode begin, PersonNode stop, 
			TreeMap<PersonNode, Collection<PersonNode>> tree) {
		this.start = begin;
		this.destination = stop;
		this.RBTree = tree;
	}

	
	public Vertex<Person> getSource() {
		return source;
	}

	public void setSource(Vertex<Person> source) {
		this.source = source;
	}

	public Vertex<Person> getEnd() {
		return end;
	}

	public void setEnd(Vertex<Person> end) {
		this.end = end;
	}

	public PersonNode getStart() {
		return start;
	}

	public void setStart(PersonNode start) {
		this.start = start;
	}

	public PersonNode getDestination() {
		return destination;
	}

	public void setDestination(PersonNode destination) {
		this.destination = destination;
	}

	public TreeMap<PersonNode, Collection<PersonNode>> getRBTree() {
		return RBTree;
	}

	public void setRBTree(TreeMap<PersonNode, Collection<PersonNode>> rBTree) {
		RBTree = rBTree;
	}

	public int separationDegree() {
		Queue<PersonNode> queue = new LinkedList<>();// queue to store nodes to be visited along the breadth
		start.setVisited(true); // mark source node as visited
		queue.add(start); // push src node to queue
		while (!(queue.isEmpty())) {
			PersonNode currentNode = queue.poll();// traverse all nodes along the breadth
			for(PersonNode node: getRBTree().get(currentNode)) {//currentNode.getFriends()
				if (node.isVisited() == false) {
					node.setVisited(true);// // mark it visited
					queue.add(node);	
					node.setPrevious(currentNode);
					printer.add(node);
					//update the key of the node to this now
					if (node.getData().getFirstName().equalsIgnoreCase(destination.getData().getFirstName())) {
						System.out.println("Degree found to be: ");
						queue.clear();
						break;
					}
				}
			}
			
		}
		return traceRoute();
	}

	
	// Computes and prints shortest path
	private int traceRoute() {
		//List<PersonNode> node1 = new ArrayList<>();
		List<PersonNode> route = new ArrayList<>();
		//PersonNode node = destination;
		/*Set<Map.Entry<PersonNode, Collection<PersonNode>>> entries = RBTree.entrySet();
		entries.forEach(entry -> {
			if(entry.getKey().getData().getUsername()
				.equalsIgnoreCase(destination.getData().getUsername())) {
				 node1.add(entry.getKey());
				//break;
			}
			
		});
		List<PersonNode> printer = new ArrayList<>();
		
		node = node1.get(0);
		*/
		
		for(PersonNode node: printer) {
			if(node.getData().getUsername()
					.equalsIgnoreCase(destination.getData().getUsername())) {
				while (node != null) {
					route.add(node);
					node = node.getPrevious();
				}
			}
		}	
		// Reverse the route - bring start to the front
		Collections.reverse(route);
		// Output the route
		for (PersonNode links : route) {
			//Printing the username connection
			//System.out.print(links.getData().getUsername() + "-->");
		}
		return (route.size()-1);
	}

	

	public int traverse() {
		if (source == null) {
			return -1;
		} else {
			Queue<Vertex<Person>> queue = new LinkedList<>();
			queue.add(source);
			while (!queue.isEmpty()) {
				Vertex<Person> current = queue.poll();
				if (!current.isVisited()) {
					current.setVisited(true);
					System.out.println(current);
					if (current.equals(end)) {
						// return distance;
					}
					queue.addAll(current.getFriends());
				}
			}
		}
		return -1;
	}

}
