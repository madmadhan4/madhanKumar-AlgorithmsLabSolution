package com.greatlearning.appmain;
import com.greatlearning.services.MergeSort;
import java.util.Scanner;

public class MinimumNotes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MergeSort mergesort = new MergeSort();
		int[] arr = inputarray(sc);
		int[] numNotes = new int[arr.length];
		mergesort.mergeSort(arr,0,arr.length - 1,"DEC");
		System.out.println("Enter the amount you want to pay ");
		int amount = sc.nextInt();
		//Pick the number of notes
		int tempAmt = amount;
		int m = 0, index = 0;
		boolean divisible = false;
		try {
			for(int i=0; i<arr.length; i++) {
				//find out how many notes of arr[i] to select
				int n = (int)(amount/arr[i]);
				numNotes[i] = n;
				//set the amount to remaining amount
				amount = amount - (n * arr[i]);
				//Check if the actual amount is divisible by the array element
				//This is to handle the cases where the above logic will not work
				//We are checking if the actual amount is divisible by any denominations present in the array
				//If yes, we are setting a flag and storing the number we get after dividing into an array
				//We are using this array later to display the minimum number of denominations
				if(tempAmt%arr[i]==0 && divisible == false) {
					m = tempAmt/arr[i];
					index = i;
					divisible = true;//set the flag to true
				}
				//write a condition to find if it is not possible to pay an amount
				//and print a message "Not possible to pay the amount"
				if(i==arr.length-1 && amount !=0 && divisible == false) {
					System.out.println("Not Possible to pay the amount ");
				}
				else if(i==arr.length-1 && amount ==0) {
					System.out.println("Your payment approach in order to give min no of notes will be ");
					for(int j = 0; j<numNotes.length; j++) {
						if(numNotes[j] > 0) {
							System.out.println(arr[j]+ " : "+ numNotes[j]);
						}
					}
				}
				else if(i==arr.length-1 && amount !=0 && divisible == true) {
					System.out.println("Your payment approach in order to give min no of notes will be ");
					if(m > 0) {
						System.out.println(arr[index]+ " : "+ m);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Entered 0 as the denomination. Please correct it ");
		}
	}

	private static int[] inputarray(Scanner sc) {
		//Get the Number of denominations
		System.out.println("Enter the size of currency denominations ");
		int size = sc.nextInt();
		System.out.println("Enter the currency denominations value ");
		//Allocate the array of size entered by the user
		int arr[] = new int[size]; //Array Declaration
		//Iterate through the loop to get the values of the transactions
		for(int i = 0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}
}
