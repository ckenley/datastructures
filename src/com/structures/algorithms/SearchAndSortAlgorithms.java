package com.structures.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchAndSortAlgorithms {

	public static void main(String[] args) {
		int[] arr = {9, 5, 12, 6, 3, 7, 3, 5, 8, 2, 3, 4};
		StringBuilder sb = new StringBuilder();
		sb.append("Array 1: ");
		for (int i = 0; i < arr.length; i++){
			sb.append(arr[i] + ", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("\nArray 2: ");
		arr = mergeSort(arr);
		for (int i = 0; i < arr.length; i++){
			sb.append(arr[i] + ", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		System.out.println(sb.toString());
	}
	
	public static int[] mergeSort(int[] arr){
		if (arr.length <= 1){
			return arr;
		}
		int pos = arr.length / 2;
		
		int[] left = Arrays.copyOfRange(arr, 0, pos);
		int[] right = Arrays.copyOfRange(arr, pos, arr.length);
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	public static int[] merge(int[] left, int[] right){
		int[] result = new int[left.length + right.length];
		int index = 0;
		while (left.length != 0 && right.length != 0){
			if (left[0] <= right[0]){
				result[index++] = left[0];
				left = Arrays.copyOfRange(left, 1, left.length);
			}
			else {
				result[index++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}
		}
		while (left.length != 0){
			result[index++] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
		}
		while (right.length != 0){
			result[index++] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);
		}
		return result;
	}
	
	public <T> int binarySearch(ArrayList<T> list, T key, int min, int max){
		
		return 0;
	}

}
