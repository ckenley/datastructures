package com.structures.node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> implements Node<T> {

	private T value;
	private boolean discovered;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;
	
	public TreeNode(){}
	
	public TreeNode(T value){
		this.value = value;
		this.children = new LinkedList<TreeNode<T>>();
	}
	
	public TreeNode<T> addChild(T value) {
        TreeNode<T> childNode = new TreeNode<T>(value);
        childNode.setParent(this);
        this.children.add(childNode);
        return childNode;
    }
	
	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<TreeNode<T>> children) {
		this.children = children;
	}
}
