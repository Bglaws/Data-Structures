
import java.lang.Math;


public class Quicksort {


	public static void quickSort(int[] arr, int start, int end) {

		if ((end - start) <= 1) {

			return;
		}

		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot);
	       	quickSort(arr, pivot + 1, end);	

	}

	public static void quickSort(int[] arr) {
	
		quickSort(arr, 0, arr.length - 1);

	}

	public static int partition(int[] arr, int start, int end) {

		int pivot = (int) ((Math.random()) * arr.length);

		int i = start;

		for (int j = start + 1; j < end; j++) {

			if (arr[j] <= pivot) {

				i++;
				swap(arr, i ,j);
			}
		}
		
		swap(arr, i, start);
		return i;
	}

	
	public static void swap(int[] arr, int num1, int num2) {
		
		int temp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = temp;


	}


	public static void main(String[] args) {

	
		int[] arr = {9,2,4,1,8,5,6,4,3,2};


		quickSort(arr);

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[1]);
		}
	}

}
