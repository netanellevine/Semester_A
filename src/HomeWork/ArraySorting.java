package HomeWork;

import java.util.Arrays;


public class ArraySorting {


	public static void swap (int[] arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	
	
	public static void counterSort (int[] arr) {
		int max=arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max<arr[i]) {max=arr[i];}
		}
		int[] sum= new int[max+1];
		for (int i = 0; i < arr.length; i++) {
			int index= arr[i];
			sum[index]++;
		}
		int k=0;
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[i]; j++) {
				arr[k++]=i;
							
			}		
		}
	}
	
	
	
	public static void bubbleSort (int[] arr) {
		for (int i = arr.length-1 ; i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				if( arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}


	public static void selectionSort (int[] arr) {
		for (int i = 0 ; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) { minIndex=j; }
			}
			swap(arr,i,minIndex);
		}
	}


	public static int[] randomArray(int a,int b) {
		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*b)+1;
		}
		return arr;
	}
	
	public static int[] mergeArrays(int[] a, int[] b) {
		int[] ans = new int[a.length+b.length];
		int min=Math.min(a.length, b.length);
		int i=0,j=0;
		while(i<min &&j<min) {
			if(a[i]<b[j]) {
				ans[i+j]=a[i++];
			}
			else {
				ans[i+j]=b[j++];
			}
		}
		while(i<a.length) {
			ans[i+j]=a[i++];
		}
		while(j<b.length) {
			ans[i+j]=b[j++];
		}
		return ans;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int[] arr= randomArray(15,20);
		int[] arr2= randomArray(15,40);
		int[] arr3= randomArray(10,20);
		System.out.println("arr1   ---------------> "+Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("arr1 after Bubble Sort: "+Arrays.toString(arr));
		System.out.println("arr2:  ------------------> "+Arrays.toString(arr2));
		selectionSort(arr2);
		System.out.println("arr2 after Selection Sort: "+Arrays.toString(arr2));
		System.out.println("arr3:  ------------------> "+Arrays.toString(arr3));
		counterSort(arr3);
		System.out.println("arr3 after Counting Sort: "+Arrays.toString(arr3));
		int[] arr4=mergeArrays(arr, arr2);
		System.out.println("arr1+arr2  ----->"+Arrays.toString(arr4));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
	}
}