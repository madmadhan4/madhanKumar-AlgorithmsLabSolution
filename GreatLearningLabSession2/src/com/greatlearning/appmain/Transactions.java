package com.greatlearning.appmain;
import java.util.Scanner;
public class Transactions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = inputarray(sc);
		System.out.println("Enter the total no of targets that needs to be achieved ");
		int target = sc.nextInt();
		for(int i=0; i<target; i++) {
			System.out.println("Enter the value of the target ");
			int value = sc.nextInt();
			int numtran = transaction(arr,value);
			if(numtran == -1) {
				System.out.println("Given target is not achieved ");
			}
			else {
				System.out.println("Target achieved after " + numtran + " transactions");
			}
			System.out.println();
				
		}
	}

	private static int[] inputarray(Scanner sc) {
		//Get the size of the Transaction Array
		System.out.println("Enter the size of transaction array ");
		int size = sc.nextInt();
		System.out.println("Enter the values of the array ");
		//Allocate the array of size entered by the user
		int arr[] = new int[size]; //Array Declaration
		//Iterate through the loop to get the values of the transactions
		for(int i = 0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	private static int transaction(int[] arr, int value) {
		//Sum variable to store the sum of elements in the array
		//Count variable to store the count the number of transaction
		int sum = 0, count = 1;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
			if(value<=sum) {
				return count; //return the count value
			}
			count++;
		}
		return -1;
	}

}
