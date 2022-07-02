package Main;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import funtion.sort;
import utils.Constant;
import utils.IOReadWriteFile;
import utils.RandomArray;
import utils.Validator;

public class Main {

	static float[] array;
	static float[] tempArray;
	static IOReadWriteFile file = new IOReadWriteFile();
	static sort sort = new sort();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean repeatProgram = false;

		do {
			showMenu();
			String choice;
			do {
				System.out.print(" Please choose function you'd like to do [1->9]: ");
				choice = scanner.nextLine();
			} while (!Validator.isChoice(choice.trim(), 1, 9));

			switch (choice) {
			case "1":
				try {
					feature1(scanner);
				} catch (IOException e) {
					System.out.println("Error in feature 1.");
				}
				stopScreen("\n     ===      End input data.      ===", scanner);
				break;
			case "2":
				try {
					feature2();
				} catch (IOException e) {
					System.out.println("Error in feature 2.");
				}
				stopScreen("\n     ===     End read data.     ===", scanner);
				break;
			case "3":
				if (array == null) {
					System.out
							.println("The array is emlpty. Let's go back to the feature 1 again and import the array!");
				} else {
					feature3();
				}
				stopScreen("\n     ===     End display algorithm.     ===", scanner);
				break;
			case "4":
				if (array == null) {
					System.out
							.println("The array is emlpty. Let's go back to the feature 1 again and import the array!");
				} else {
					feature4();
				}
				stopScreen("\n     ===     End display algorithm.     ===", scanner);
				break;
			case "5":
				if (array == null) {
					System.out
							.println("The array is emlpty. Let's go back to the feature 1 again and import the array!");
				} else {
					feature5();
				}
				stopScreen("\n     ===     End display algorithm.     ===", scanner);
				break;
			case "6":
				if (array == null) {
					System.out
							.println("The array is emlpty. Let's go back to the feature 1 again and import the array!");
				} else {
					feature6(scanner);
				}
				stopScreen("\n     ===     End search data.     ===", scanner);
				break;
			case "7":
				if (array == null) {
					System.out
							.println("The array is emlpty. Let's go back to the feature 1 again and import the array!");
				} else {
					feature7(scanner);
				}
				stopScreen("\n     ===     End search data.     ===", scanner);
				break;
			case "8":
				feature8();
				stopScreen("\n     ===     End display data.     ===", scanner);
				break;
			case "9":
				System.out.println("\n Exit Program.\n");
				repeatProgram = true;
				break;
			default:
				break;
			}

		} while (!repeatProgram);
	}

	// Show all program features
	private static void showMenu() {
		System.out.println("=============================================================");
		System.out.println("==          ==========     MENU     =============          ==");
		System.out.println("=============================================================");
		System.out.println("==       1. Input.                                         ==");
		System.out.println("==       2. Output.                                        ==");
		System.out.println("==       3. Bubble sort.                                   ==");
		System.out.println("==       4. Selection sort.                                ==");
		System.out.println("==       5. Insertion sort.                                ==");
		System.out.println("==       6. Search > value.                                ==");
		System.out.println("==       7. Search = value.                                ==");
		System.out.println("==       8. Compare algorithm running time with data.      ==");
		System.out.println("==       9. Exit.                                          ==");
		System.out.println("=============================================================");
		System.out.println("==          =====================================          ==");
		System.out.println("=============================================================");
	}

	private static void feature1(Scanner scanner) throws IOException {
		String fileName = Constant.FILE_INPUT;
		// Create a file storage
		boolean isExist = file.isNewFile(fileName);

		// Check if file exists
		if (!isExist) {
			System.out.println("Error. Not Create File!");
		} else {
			System.out.print("Input number of elements: ");
			int number = scanner.nextInt();
			array = new float[number];

			// Enter value into array
			for (int i = 0; i < number; i++) {
				System.out.print("Input elements " + i + ": ");
				array[i] = scanner.nextFloat();
			}
			boolean isWrite = file.isWriteFile(fileName, array, null);
			// Check if it's written to the file
			if (!isWrite) {
				System.out.println("Not write to file!");
			}
		}
	}

	private static void feature2() throws IOException {
		String fileName = Constant.FILE_INPUT;
		System.out.println("Read from file");
		System.out.print("Array array: ");
		array = file.readFile(fileName);
		printArray(array);

	}

	private static void feature3() {
		String fileName = Constant.FILE_OUTPUT_1;
		// Create a file storage
		boolean isExist = file.isNewFile(fileName);

		// Check if file exists
		if (!isExist) {
			System.out.println("Error. Not Create File!");
		} else {
			System.out.println("Bubble Sort");
			tempArray = sort.ascBubbleSort(fileName, array);

			boolean isWrite = file.isWriteFile(fileName, tempArray, null);
			// Check if it's written to the file
			if (!isWrite) {
				System.out.println("Not write to file!");
			}
		}
	}

	private static void feature4() {
		String fileName = Constant.FILE_OUTPUT_2;
		// Create a file storage
		boolean isExist = file.isNewFile(fileName);

		// Check if file exists
		if (!isExist) {
			System.out.println("Error. Not Create File!");
		} else {
			System.out.println("Selection Sort");
			tempArray = sort.ascSelectionSort(fileName, array);

			boolean isWrite = file.isWriteFile(fileName, tempArray, null);
			// Check if it's written to the file
			if (!isWrite) {
				System.out.println("Not write to file!");
			}
		}
	}

	private static void feature5() {
		String fileName = Constant.FILE_OUTPUT_3;
		// Create a file storage
		boolean isExist = file.isNewFile(fileName);

		// Check if file exists
		if (!isExist) {
			System.out.println("Error. Not Create File!");
		} else {
			System.out.println("Insertion Sort");
			tempArray = sort.ascInsertionSort(fileName, array);

			boolean isWrite = file.isWriteFile(fileName, tempArray, null);
			// Check if it's written to the file
			if (!isWrite) {
				System.out.println("Not write to file!");
			}
		}
	}

	private static void feature6(Scanner scanner) {
		String fileName = Constant.FILE_OUTPUT_4;
		// Create a file storage
		boolean isExist = file.isNewFile(fileName);

		// Check if file exists
		if (!isExist) {
			System.out.println("Error. Not Create File!");
		} else {
			System.out.println("Linear Search");
			System.out.print("Input value: ");
			float value = scanner.nextFloat();

			// Delete an existing file
			boolean isDelete = file.isDeleteFile(fileName);
			if (isDelete) {
				file.isNewFile(fileName);
				sort.linearSearch(fileName, array, value);
			}
		}
	}

	private static void feature7(Scanner scanner) {
		String fileName = Constant.FILE_OUTPUT_5;
		// Create a file storage
		boolean isExist = file.isNewFile(fileName);

		// Check if file exists
		if (!isExist) {
			System.out.println("Error. Not Create File!");

		} else {
			if (tempArray != null) {
				int right, number;
				System.out.println("Binary Search");
				System.out.print("Input value: ");
				float value = scanner.nextFloat();

				right = tempArray.length - 1;
				number = sort.binarySearch(tempArray, 0, right, value);

				// Delete an existing file
				boolean isDelete = file.isDeleteFile(fileName);
				if (isDelete) {
					file.isNewFile(fileName);
					if (number != -1) {
						System.out.print("Index of first element: " + number);
						file.isWriteFile(fileName, null, String.valueOf(number));
					} else {
						file.isWriteFile(fileName, null, String.valueOf(number));
						System.out.println("Not Found.");
					}
				}
			} else {
				System.out.println(
						"Sort array by 1 of 3 algorithms Bubble Sort, Selection Sort, Insertion Sort installed in steps 3, 4, 5;");
			}
		}
	}

	private static void feature8() {
		RandomArray randomArray = new RandomArray();
		long start, end;
		int total;
		float[] array1 = randomArray.randomGenerator(1, 10);
		float[] array2 = randomArray.randomGenerator(1, 10);
		Arrays.sort(array2);
		float[] tempArray = array2.clone();
		float[] array3 = decSort(tempArray);

		start = 0;
		end = 0;
		total = 0;
		System.out.println("\n1. Bubble Sort");
		System.out.print("\nNgau nhien: ");
		//printArray(array1);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array1);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.print("\nTang dan: ");
		//printArray(array2);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array2);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("Total: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.print("\nGiam dan: ");
		//printArray(array3);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array3);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.println("\n\n2. Selection Sort");
		System.out.print("\nNgau nhien: ");
		//printArray(array1);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array1);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.print("\nTang dan: ");
		//printArray(array2);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array2);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.print("\nGiam dan: ");
		//printArray(array3);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array3);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.println("\n\n3. Insertion Sort");
		System.out.print("\nNgau nhien: ");
		//printArray(array1);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array1);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.print("\nTang dan: ");
		//printArray(array2);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array2);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

		start = 0;
		end = 0;
		total = 0;
		System.out.print("\nGiam dan: ");
		//printArray(array3);
		System.out.println();
		start = System.nanoTime();
		sort.ascBubbleSort(null, array3);
		end = System.nanoTime();
		total = (int) (end - start);
		System.out.println("\nTotal: " + total);

	}

	// Sort of Decrease
	public static float[] decSort(float[] arr) {
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			// Swap
			float temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}

	// Display array
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	// Display array
	public static void printArray(float[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	// Stop the screen and wait
	private static void stopScreen(String message, Scanner scanner) {
		System.out.println(message);
		System.out.println("Press enter to turn back.");
		scanner.nextLine();
	}
}