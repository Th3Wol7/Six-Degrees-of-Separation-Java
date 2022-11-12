package com.application.utils.network;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.application.models.Node;
import com.application.models.Person;

public class DijkstrasSearch<Person> {

    public void calculateShortestPath(Node<Person> source) {
        source.setDistance(0);
        Set<Node<Person>> settledNodes = new HashSet<>();
        Queue<Node<Person>> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));
        while (!unsettledNodes.isEmpty()) {
            Node<Person> currentNode = unsettledNodes.poll();
            currentNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }
    }

    private void evaluateDistanceAndPath(Node<Person> adjacentNode, Integer edgeWeight, Node<Person> sourceNode) {
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList());
        }
    }

    public void printPaths(List<Node<Person>> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getUser).map(Objects::toString)
                    .collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank()
                    ? "%s : %s".formatted(node.getUser(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getUser().toString(), node.getDistance()))
            );
        });
    }
}
