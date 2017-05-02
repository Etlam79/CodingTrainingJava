package datastructures.graph;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import datastructures.ArrayList;
import datastructures.helper.Node;


public class Graph<V> { 
	
	private Hashtable<V, Vertex> verteces;
	
	public Graph() {
		verteces = new Hashtable<V, Vertex>();
	}
	
	
	public Vertex addVertex(V toBeAdded) {
		if (verteces.containsKey(toBeAdded)) {
			return verteces.get(toBeAdded);			
		}
		Vertex v = new Vertex(toBeAdded);
		verteces.put(toBeAdded, v);	
		return v;
	}
	
	
	
	public boolean addEdge(Vertex from, Vertex to, int val) {
		if (!verteces.contains(from) || !verteces.contains(to))
			return false;
		from.addNext(to, val);
		to.addNext(from, val);
		return true;
	}
	
	
	
	public static void main(String[] args) {
		Graph<String> g = new Graph<String>();
		Vertex<String> koeln = g.addVertex("Koeln");
	    Vertex<String> duesseldorf = g.addVertex("Duesseldorf");
	    Vertex<String> bonn = g.addVertex("Bonn");
	    Vertex<String> berlin = g.addVertex("Berlin");
	    Vertex<String> muenchen = g.addVertex("München");
		
	    
	    g.addEdge(duesseldorf, koeln, 50);
	    g.addEdge(duesseldorf, berlin, 600);
		g.addEdge(bonn, koeln, 50);
		g.addEdge(koeln, berlin, 600);
		g.addEdge(bonn, muenchen, 500);
		g.addEdge(muenchen, berlin, 600);
		
		System.out.println(g.findShortestPath(bonn, berlin));
		
		//System.out.println(g.findShortestPath(duesseldorf, muenchen));
	}


	public String findShortestPath(Vertex from, Vertex to) {
		ArrayList<String> buffer = new ArrayList<String>();
		int path = findShortestPath(from, to, 0, buffer);
		return buffer.toString() + " " + path;
		
	}
	
/*	private void  dijkstra(Vertex start){
		int[] distance = new int[verteces.size()]; 		
		Hashtable<Vertex, Integer> predecessor = new Hashtable<Vertex, Integer>();
		LinkedList<Vertex> q = new LinkedList<Vertex>();
		initDijkstra(start, distance, predecessor,q);
		 
		while (!q.isEmpty()) { 
			Vertex u = extractMinDistanceVertex(distance, q);
			for (Iterator<Vertex> iterator = u.getNeighbours(); iterator.hasNext();) {
				Vertex v = (Vertex) iterator.next();
				if( q.contains(v))
					updateDistance(u, v ...);
			}
				
			}
			for (int i = 0; i < distance.length; i++) {
				
			}
//		 6          für jeden Nachbarn v von u:
//		 7              falls v in Q:
//		 8                 distanz_update(u,v,abstand[],vorgänger[])   // prüfe Abstand vom Startknoten zu v
//		 9      return vorgänger[]
		}
	}
	
	


	private void initDijkstra(Vertex start, int[] distance, Hashtable<Vertex, Integer> pre, List<Vertex> q) {
		Arrays.fill(distance, Integer.MAX_VALUE);		
		int i = 0;
		for (Vertex v: verteces.values()) {
			 pre.put(v, null);
			 q.add(v);
			 if ( v == start)
				 distance[i] = 0;
			 i++;
		 } 
	}
*/
	
	
	private Vertex extractMinDistanceVertex(int[] distance, List<Vertex> q) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int j = 0; j < distance.length; j++) {
			if (distance[j]< min) {
				min = distance[j];
				index = j;
			}
		}		
		return q.remove(index);		
	}

	private int findShortestPath(Vertex from, Vertex to, int path, ArrayList<String> buffer) {
		buffer.add(from.getVal().toString());
		System.out.printf("V:%s, current length %s\n", from.getVal().toString(), path);
		if (from == to) {			
			return path;		
		}
	
		from.setVisited(true);
	
		Enumeration<Vertex> en = from.neighbours.keys();		
		while (en.hasMoreElements()) {			
			Vertex neighbour = en.nextElement();
			int retPath = Integer.MAX_VALUE;
			if(!neighbour.isVisited()) {
				int weight = from.getEdge(neighbour);
				System.out.println(weight);
				retPath = Math.min(retPath,findShortestPath(neighbour, to, path + weight, buffer));
				
			}
			if (retPath < Integer.MAX_VALUE)
				path = retPath;
		}	
		
		from.setVisited(false);
		buffer.removeLast();
		return path;
		
	}

}
