package funtion;



import utils.IOReadWriteFile;

public class sort {

	static IOReadWriteFile file = new IOReadWriteFile();

	/**
	 * 
	 * Sorting the input array arr using Bubble Sort algorithm.
	 *
	 * @param arr Input array using for sorting
	 * 
	 * @return Returning a sorted array by using the Bubble Sort algorithm
	 */

	public float[] ascBubbleSort(String fileName, float[] arr) {
		float[] tempArray = arr.clone();
		int n = tempArray.length;
		boolean isSwap;

		for (int i = 0; i < n - 1; i++) {
			isSwap = false;
			for (int j = 0; j < n - i - 1; j++) {
				// Compares a < b
				if (tempArray[j] > tempArray[j + 1]) {
					// Swap
					float temp = tempArray[j + 1];
					tempArray[j + 1] = tempArray[j];
					tempArray[j] = temp;
					isSwap = true;
				}
			}
			printArray(tempArray);
			if (!isSwap) {
				// No swap so terminate sorting
				printArray(tempArray);
				break;
			}
		}
		return tempArray;
	}

	/**
	 * 
	 * Sorting the input array arr using Selection Sort algorithm.
	 *
	 * @param arr Input array using for sorting
	 * 
	 * @return Returning a sorted array by using the Selection Sort algorithm
	 * 
	 */

	public float[] ascSelectionSort(String fileName, float[] arr) {
		float minIndex, temp;
		float[] tempArray = arr.clone();
		for (int i = 0; i < tempArray.length - 1; i++) {
			// Assign position into
			minIndex = i;
			for (int j = i + 1; j < tempArray.length; j++) {
				if (tempArray[(int) minIndex] > tempArray[j]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				// Swap
				temp = tempArray[(int) i];
				tempArray[i] = tempArray[(int) minIndex];
				tempArray[(int) minIndex] = temp;
			}
			printArray(tempArray);
		}
		return tempArray;
	}

	/**
	 * 
	 * Sorting the input array arr using Insertion Sort algorithm.
	 *
	 * @param arr Input array using for searching
	 * 
	 * @return Returning a sorted array by using the Insertion Sort algorithm
	 *
	 */

	public float[] ascInsertionSort(String fileName, float arr[]) {
		float valueToInsert;
		int holePosition;
		float[] tempArray = arr.clone();

		for (int i = 0; i < tempArray.length; i++) {
			valueToInsert = tempArray[i];
			holePosition = i;
			while (holePosition > 0 && tempArray[holePosition - 1] > valueToInsert) {
				tempArray[holePosition] = tempArray[holePosition - 1];
				holePosition = holePosition - 1;
			}
			tempArray[holePosition] = valueToInsert;
			printArray(tempArray);
		}
		return tempArray;
	}

	/**
	 * 
	 * Searching the indices of elements in array [arr] greater than value. Printing
	 * and writing all indices to the console screen and file OUTPUT4.TXT separated
	 * by space.
	 * 
	 * @param arr   Input array using for searching
	 * 
	 * @param value The value for searching
	 * 
	 */

	public void linearSearch(String fileName, float arr[], float value) {
		boolean check = false;
		System.out.print("Chi so la: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > value) {
				System.out.print(i + " ");
				file.isWriteFile(fileName, null, String.valueOf(i));
				check = true;
			}
		}
		
		if (check == false) {
			System.out.print("-1");
			file.isWriteFile(fileName, null, String.valueOf(-1));
		}
	}

	/**
	 * 
	 * Searching by using the Binary Search algorithm. Returning the first index of
	 * value if it is present in array arr, otherwise, return -1. The index also
	 * written to file OUTPUT5.TXT and shown on the console screen.
	 *
	 * 
	 * @param arr   Input array using for searching
	 * 
	 * @param left  The left index
	 * 
	 * @param right The right index
	 * 
	 * @param value The value for searching
	 * 
	 * @return The index of the element if found, otherwise, return -1
	 *
	 */

	public int binarySearch(float arr[], int left, int right, float value) {
		while (right > left) {
			int middle = (right + left) / 2;

			if (arr[middle] < value) {
				left = middle + 1;
			} else {
				right = middle;
			}
		}

		if (arr[left] == value) {
			return left;
		}

		return -1;
	}

	private void printArray(float[] tempArray) {
		for (int i = 0; i < tempArray.length; i++) {
			System.out.print(tempArray[i] + " ");
		}
		System.out.println();
	}
}