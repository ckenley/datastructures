package com.structures.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.structures.node.TreeNode;
import com.structures.tree.Tree;

public class TreeAlgorithms {

	public static void main(String[] args) {
		Tree<String> tree = new Tree<String>("root");
		tree.getRoot().addChild("0");
		tree.getRoot().addChild("1");
		tree.getRoot().addChild("2");
		// Child 0 has 3 children
		tree.getRoot().getChildren().get(0).addChild("999");
		tree.getRoot().getChildren().get(0).addChild("888");
		tree.getRoot().getChildren().get(0).addChild("777");
		// Child 1 has 2 children
		tree.getRoot().getChildren().get(1).addChild("22");
		tree.getRoot().getChildren().get(1).addChild("33");
		// Child 2 has 1 child
		tree.getRoot().getChildren().get(2).addChild("6");
		// And that will have 3 children
		tree.getRoot().getChildren().get(2).getChildren().get(0).addChild("9999");
		tree.getRoot().getChildren().get(2).getChildren().get(0).addChild("5555");
		tree.getRoot().getChildren().get(2).getChildren().get(0).addChild("0000");

		System.out.println("DEPTH FIRST:");
		printDepthFirst(tree);
		System.out.println("DEPTH FIRST RECURSIVE:");
		depthFirstRecursive(tree.getRoot());
		System.out.println("BREADTH FIRST:");
		printBreadthFirst(tree);
	}

	/*
	 * Prints a Tree<T> in Depth First order.
	 */
	public static <T> void printDepthFirst(Tree<T> tree) {
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(tree.getRoot());
		while (!stack.isEmpty()) {
			TreeNode<T> next = stack.pop();
			if (!next.isDiscovered()) {
				System.out.println(next.getValue());
				for (TreeNode<T> node : next.getChildren()) {
					stack.push(node);
				}
			}
		}
	}

	/*
	 * Prints a Tree<T> in Depth First order recursively.
	 */
	public static <T> void depthFirstRecursive(TreeNode<T> vertex) {
		System.out.println(vertex.getValue());
		vertex.setDiscovered(true);
		for (TreeNode<T> child : vertex.getChildren()) {
			if (!child.isDiscovered()) {
				depthFirstRecursive(child);
			}
		}
	}

	/*
	 * Prints a Tree<T> in Breadth First order.
	 */
	public static <T> void printBreadthFirst(Tree<T> tree) {
		TreeNode<T> root = tree.getRoot();
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		System.out.println(root.getValue());
		queue.add(root);
		root.setDiscovered(true);
		while (!queue.isEmpty()) {
			TreeNode<T> vertex = queue.poll();
			for (TreeNode<T> child : vertex.getChildren()) {
				if (!child.isDiscovered()) {
					System.out.println(child.getValue());
					queue.add(child);
				}
			}
		}
	}

}
