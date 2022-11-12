package com.application.utils.network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.application.models.Node;
import com.application.models.Person;
import com.application.models.PersonNode;
import com.application.models.Vertex;

public class BreadthFirstSearch/* <Person> */ {
	private Vertex<Person> source;
	private Vertex<Person> end;
	private PersonNode start;
	private PersonNode destination;

	public BreadthFirstSearch(Vertex<Person> startVertex, Vertex<Person> endVertex) {
		this.source = startVertex;
		this.end = endVertex;
		traverse();
	}
	
	public BreadthFirstSearch(PersonNode begin, PersonNode stop) {
		this.start = begin;
		this.destination = stop;
	}

	public int separationDegree() {
		Queue<PersonNode> queue = new LinkedList<>();// queue to store nodes to be visited along the breadth
		start.setVisited(true); // mark source node as visited
		queue.add(start); // push src node to queue
		while (!queue.isEmpty()) {
			PersonNode currentNode = queue.poll();// traverse all nodes along the breadth
			// traverse along the node's breadth
			for (PersonNode node : currentNode.getFriends()) {
				if (!node.isVisited()) {
					node.setVisited(true);// // mark it visited
					queue.add(node);
					node.setPrevious(currentNode);
					if (node == destination) {
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
		PersonNode node = destination;
		List<PersonNode> route = new ArrayList<>();
		// Loop until node is null to reach start node
		// because start.prev == null
		while (node != null) {
			route.add(node);
			node = node.getPrevious();
		}
		// Reverse the route - bring start to the front
		Collections.reverse(route);
		// Output the route
		for (PersonNode links : route) {
			System.out.print(links.getData().getUsername() + "-->");
		}

		return (route.size() - 1);
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
