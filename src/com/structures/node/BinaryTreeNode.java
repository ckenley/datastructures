package com.structures.node;


public class BinaryTreeNode<T> implements Node<T> {
	
	private T value;
	private boolean discovered;
	private BinaryTreeNode<T> parent;
	private BinaryTreeNode<T> leftNode;
	private BinaryTreeNode<T> rightNode;
	
	public BinaryTreeNode(){}
	
	public BinaryTreeNode(T value) {
		this.value = value;
		this.leftNode = new BinaryTreeNode<T>();
		this.rightNode = new BinaryTreeNode<T>();
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
	public BinaryTreeNode<T> getParent() {
		return parent;
	}
	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
	}
	public BinaryTreeNode<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(BinaryTreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}
	public BinaryTreeNode<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(BinaryTreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
}
