package com.application.utils.network;
/*This class represents the customized implementation of the Breadth First Search
 * algorithm taken from
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * @author Tyrien Gilpin
 * Version 1
 */

import com.application.models.PersonNode;

import java.util.*;

public class BreadthFirstSearch/* <Person> */ {
    private PersonNode start;
    private PersonNode destination;
    private TreeMap<PersonNode, Collection<PersonNode>> RBTree;
    private List<PersonNode> printer = new ArrayList<>();


    public BreadthFirstSearch(PersonNode begin, PersonNode stop,
                              TreeMap<PersonNode, Collection<PersonNode>> tree) {
        this.start = begin;
        this.destination = stop;
        this.RBTree = tree;
    }

    //Getters and Setters
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

    //BFS Algorithm Demonstration
    public String separationDegree() {
        Queue<PersonNode> queue = new LinkedList<>();// queue to store nodes to be visited along the breadth
        String output = "";
        start.setVisited(true); // mark source node as visited
        queue.add(start); // push src node to queue
        while (!(queue.isEmpty())) {
            PersonNode currentNode = queue.poll();// traverse all nodes along the breadth
            for (PersonNode node : getRBTree().get(currentNode)) {//currentNode.getFriends()
                if (node.isVisited() == false) {
                    node.setVisited(true);// // mark it visited
                    queue.add(node);
                    node.setPrevious(currentNode);
                    printer.add(node);
                    //update the key of the node to this now
                    if (node.getData().getFirstName().equalsIgnoreCase(destination.getData().getFirstName())) {
                        output = "Degree found to be: \n";
                        queue.clear();
                        break;
                    }
                }
            }

        }
        return traceRoute(output);
    }


    // Computes and prints shortest path
    private String traceRoute(String output) {
        //List<PersonNode> node1 = new ArrayList<>();
        List<PersonNode> route = new ArrayList<>();
        for (PersonNode node : printer) {
            if (node.getData().getUsername()
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
            output += links.getData().getFirstName() + "-->";
        }
        if ((route.size() - 1) < 0) {
            String display = "No Connection\n";
            if (start.getData().getCommunity().equalsIgnoreCase(destination.getData().getCommunity())) {
                display += start.getData().getFirstName() + "(you) and " + destination.getData().getFirstName() +
                        " has community in common\n";
            }
            if (start.getData().getSchool().equalsIgnoreCase(destination.getData().getSchool())) {
                display += start.getData().getFirstName() + "(you) and " + destination.getData().getFirstName() +
                        " has school in common\n";
            }
            if (start.getData().getEmployer().equalsIgnoreCase(destination.getData().getEmployer())) {
                display += start.getData().getFirstName() + "(you) and " + destination.getData().getFirstName() +
                        " has employer in common\n";
            }
            return display;
        }
        return output += "\n" + String.valueOf((route.size() - 1));
    }


}
