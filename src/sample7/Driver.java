package sample7;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Driver {
	public static int[] eliminateDuplicates(int[] list) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		//adding element to LinkedHashSet
		for(int i = 0; i < list.length; i++)
			set.add(list[i]);
		int[] temp = new int[set.size()];
		int j = 0;
		for(Integer i : set) {
			temp[j++] = i;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 10 numbers: ");
		int array[] = new int[10];
		for(int i = 0; i < 10; i++) {
			array[i] = scan.nextInt();
		}
		int[] res = eliminateDuplicates(array);
		System.out.print("The distinct numbers are: ");
		for(int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}

}
