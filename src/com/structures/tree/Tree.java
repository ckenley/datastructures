package com.structures.tree;

import java.util.ArrayList;
import com.structures.node.TreeNode;

public class Tree<T> {
	
	private TreeNode<T> root;
    
    public Tree (T value) {
        root = new TreeNode<T>(value);
        root.setChildren(new ArrayList<TreeNode<T>>());
    }

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
}
