package com.structures.node;


public class BinaryTreeNode<T> implements Node<T> {
	
	private T value;
	private boolean discovered;
	private TreeNode<T> parent;
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;
	
	
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
	public TreeNode<T> getParent() {
		return parent;
	}
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	public TreeNode<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
}
