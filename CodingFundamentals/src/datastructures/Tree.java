package datastructures;

import java.util.ArrayList;
import java.util.List;

import datastructures.helper.Node;

public class Tree<T> {
	
	private TreeNode<T> root;
	
	public Tree() {
		root = null;
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}
	
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode<T> findLowestCommonAncestor(TreeNode<T> a, TreeNode<T> b) {
		if (a == b)
			return a;
		return findLowestCommonAncestor(a.getParent(), b.getParent());
	}
	
	
	public class TreeNode<T> extends Node<T> {
		private TreeNode<T> parent;
		private List<TreeNode<T>> children;
		
		
		public TreeNode(T val) {
			super(val);
			this.children = new ArrayList<TreeNode<T>>();
			
		}
		public TreeNode(TreeNode<T> parent, T val) {
			this(val);
			this.parent = parent;
			
		}
		
		public TreeNode<T> getParent() {
			return parent;
		}
		
		public void setChild(TreeNode<T> child) {
			this.children.add(child);
		}
		
		
		
	}

}
