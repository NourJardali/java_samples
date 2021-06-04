package sample5;

import java.util.Random;

public class Main {
	//Function to build Max-Heap from the array
	static int[] buildMaxHeap(int [] arr) {
		int n = arr.length;
		int startIdx = (n / 2) - 1;
		for(int i = startIdx; i >= 0; i--)
			heapify(arr, n, i);
		return arr;
	}
	
	static void heapify(int arr[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < n && arr[l] > arr[largest])
			largest = l;
		
		if(r < n && arr[r] > arr[largest])
			largest = r;
		
		if(largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}
	
	static int[] heapSort(int[] arr) {
		buildMaxHeap(arr);
		for(int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		return arr;
	}
	
	static int[] simpleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < (n-1); j++) {
				if(arr[j-1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	static void printHeap(int arr[]) {
		for(int i = 0; i < arr.length; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = new int[100000];
		Random rd = new Random();
		for(int i = 0; i < a.length; i ++)
			a[i] = Math.abs(rd.nextInt());
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		
		System.out.println("HeapSort: ");
		
		long startTime = System.nanoTime();
		heapSort(a);
		long stopTime = System.nanoTime();
		System.out.print("HeapSort took ");
		long d = stopTime - startTime;
		System.out.println(d + " ms");
		
		System.out.println("SimpleSort: ");
		
		startTime = System.nanoTime();
		simpleSort(b);
		stopTime = System.nanoTime();
		System.out.print("simpleSort took ");
		d = stopTime - startTime;
		System.out.println(d + " ms");
	}

}
