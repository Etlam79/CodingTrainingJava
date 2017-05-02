package datastructures;

public class Trie {
	private Node root;
	
	public Node getWord(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			Node potentialNext = current.children[mapLetter(currentChar)];
			if(potentialNext == null) {
				return null;
			}
			current = potentialNext;
			
		}
		return current;
	}
	
	
	public void addWord(String word) {
		if(word.length() == 0)
			return;
		
		int i = 0;
		char first = word.charAt(i++);
		Node current = root;
		while (current.hasChild(first)) {
			current = current.getChild(first);
			first = word.charAt(i++);
		}
		
	}
	
	private int mapLetter(char currentChar) {
		return 0;
	}

	class Node {
		char value;
		Node[] children;
		
		Node(char c) {
			c = value;
			children = new Node[27];
		}

		public Node getChild(char first) {
			return children[mapLetter(first)];
			
		}

		public boolean hasChild(char first) {			
			return children[mapLetter(first)] != null;
		}
		
		
		
		
	}

}
