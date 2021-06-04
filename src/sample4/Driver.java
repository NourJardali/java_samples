package sample4;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	public static void occurence(int arr[]) {
		int count[] = new int[51];
		Arrays.sort(arr);
		Arrays.fill(count,  0);
		int n;
		for(int i = 0; i < arr.length; i++) {
			n = arr[i];
			count[n]++;
		}
		for(int i = 0; i < count.length; i++) {
			if(count[i] > 0) {
				if(count[i] == 1)
					System.out.println(i + " occurs " + count[i] + " time");
				else
					System.out.println(i + " occurs " + count[i] + " times");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter how many integers: ");
		int n = scan.nextInt();
		System.out.println("Enter the " + n + " integers between 1 and 50: ");
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		occurence(arr);
	}

}
