package com.application.network;

import com.application.models.PersonNode;

public class SocialNetworkTree {
	private PersonNode root;
	//Need to use a TreeMap to implement social network because
	//Tree maps uses red black trees
	public SocialNetworkTree() {
		super();
		root = null;
	}
	
	 PersonNode rotateLeft(PersonNode node)
	    {
		 PersonNode x = node.getRight();
		 PersonNode y = x.getLeft();
	        x.setLeft(node);
	        node.setRight(y);
	        node.setParent(x); //Setting x as parent.
	        if(y!=null)
	            y.setParent(node);
	        return(x);
	    }
	 
	 
	    //method to performs right rotation
	 PersonNode rotateRight(PersonNode node)
	    {
		 PersonNode nodeA = node.getLeft();
		 PersonNode nodeB = nodeA.getRight();
		 nodeA.setRight(node);
	        node.setLeft(nodeB);
	        node.setParent(nodeA);
	        if(nodeB != null)
	        	nodeB.setParent(node);
	        return(nodeA);
	    } 
	 
	 
	
}
