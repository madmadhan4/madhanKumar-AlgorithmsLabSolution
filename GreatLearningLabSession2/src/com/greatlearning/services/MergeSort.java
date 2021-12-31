package com.greatlearning.services;

public class MergeSort {
	public void mergeSort(int[] arr, int left, int right, String order) {
		if(left < right) {
			sort(arr,left,right,order);
		}
		else {
			System.out.println("Invalid left and right pointers");
		}
	}
	private void sort(int[] arr, int left, int right, String order) {
		if(left<right) {
			//Find the middle element
			int mid = left + (right - left)/2 ;
			//Divide the array into 2 halves
			//Sort the first and second halves
			sort(arr,left,mid,order);
			sort(arr,mid+1,right,order);
			//Merge the sorted halves
			merge(arr,left,mid,right,order);
		}
	}
	private void merge(int[] arr, int left, int mid, int right, String order) {
		//Find size of two sub arrays
		int n1 = mid - left + 1; // 1 because it's size and not index. Size is always 1 greater than index in array
		int n2 = right - mid; //No +1 because we have already declared mid+1 at the top
		//Create temporary arrays
		int leftarr[] = new int[n1];
		int rightarr[] = new int[n2];
		//Copy data to temporary arrays
		for(int i=0; i<n1; i++) {
			leftarr[i] = arr[left + i];
		}
		for(int j=0; j<n2; j++) {
			rightarr[j] = arr[mid + 1 + j];
		}
		//Merge the temporary arrays
		//Initialize
		int i = 0, j = 0;//for left and right subarrays
		int k = left; // for original array
		//Across both temporary arrays, find the least and prepare the final sorted array
		while(i<n1 && j<n2) {
			if(order == "dec" || order == "DEC") {
				if(leftarr[i]>=rightarr[j]) {
					arr[k] = leftarr[i];
					i++;
				}
				else {
					arr[k] = rightarr[j];
					j++;
				}
				k++;
			}
			else {
				if(leftarr[i]<=rightarr[j]) {
					arr[k] = leftarr[i];
					i++;
				}
				else {
					arr[k] = rightarr[j];
					j++;
				}
				k++;
			}
		}
		//copy remaining elements if any from left and right array
		while(i<n1) {
			arr[k] = leftarr[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k] = rightarr[j];
			j++;
			k++;
		}
	}

}
