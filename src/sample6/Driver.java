package sample6;

import java.util.Scanner;

public class Driver {
	public static int indexOfLargestElement(int[] array) {
		int max = array[0];
		int index = -1;
		for(int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
				index = i;
			}
			else {
				if(max == array[i])
					index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 10 numbers: ");
		int array[] = new int[10];
		for(int i = 0; i < 10; i++) {
			array[i] = scan.nextInt();
		}
		int index = indexOfLargestElement(array);
		System.out.println("Index of the largest element = " + index);
		System.out.println("Element = " + array[index]);
	}

}
