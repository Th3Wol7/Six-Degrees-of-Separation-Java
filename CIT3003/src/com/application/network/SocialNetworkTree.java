package com.application.network;

import com.application.models.Node;

public class SocialNetworkTree {
	private Node root;
	//Need to use a TreeMap to implement social network because
	//Tree maps uses red black trees
	public SocialNetworkTree() {
		super();
		root = null;
	}
	
	 Node rotateLeft(Node node)
	    {
		 Node x = node.getRight();
		 Node y = x.getLeft();
	        x.setLeft(node);
	        node.setRight(y);
	        node.setParent(x); //Setting x as parent.
	        if(y!=null)
	            y.setParent(node);
	        return(x);
	    }
	 
	 
	    //method to performs right rotation
	 Node rotateRight(Node node)
	    {
		 Node nodeA = node.getLeft();
		 Node nodeB = nodeA.getRight();
		 nodeA.setRight(node);
	        node.setLeft(nodeB);
	        node.setParent(nodeA);
	        if(nodeB != null)
	        	nodeB.setParent(node);
	        return(nodeA);
	    } 
	 	 
	
}
