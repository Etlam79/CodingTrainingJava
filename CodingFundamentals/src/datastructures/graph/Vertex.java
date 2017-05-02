package datastructures.graph;

import java.util.Hashtable;
import java.util.Iterator;


import datastructures.helper.Node;

public class Vertex<V> extends Node<V> {
		Hashtable<Vertex, Integer> neighbours;
		private boolean visited;
		
		public Vertex(V val) {
			super(val);
			neighbours = new Hashtable<Vertex, Integer>();
		}
		

		public void addNext(Vertex to, int val) {
			neighbours.put(to, val);			
		}
		
		public Iterator<Vertex> getNeighbours() {
			return neighbours.keySet().iterator();
		}
		
		public int getEdge(Vertex to) {
			return neighbours.get(to);
		}


		public void setVisited(boolean b) {
			visited = b;			
		}
		
		public boolean isVisited() {
			return visited;
		}
	}
