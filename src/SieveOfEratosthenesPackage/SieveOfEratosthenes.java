package SieveOfEratosthenesPackage;

import java.util.Arrays;

public class SieveOfEratosthenes {
	static int len = 0;//global static variable for length

	public static void main(String args[]) {
		int[] arrA = new int[Integer.parseInt(args[0])];// Array to be operated for primes.
		int[] arrB = new int[Integer.parseInt(args[0])];// Array to be operated for even numbers.

		for (int l1 = 0; l1 < arrA.length; l1++) {
			arrA[l1] = l1 + 1;
		}

		for (int l2 = 0; l2 < arrA.length; l2++) {
			arrB[l2] = l2 + 1;
		}

		len = arrA.length;
		System.out.println("\nArray with all the numbers\n");
		System.out.println(Arrays.toString(arrA));
		System.out.println("\nArray with the prime numbers\n");
		sieve(arrA);// calling the sieve method
		System.out.println("\nArray with the even numbers\n");
		goldbach(arrB);// calling the goldbach method

	}

	public static void displayArr(int[] array) { // Method to display the array
		System.out.println(Arrays.toString(array));
	}

	static int[] arrayStore;// array to store the prime numbers.

	public static void sieve(int[] array) {// method for the sieve algorithm.
		int j = 0;
		while (j < array.length) {
			if (array[j] != 0 && array[j] != 1) {
				int k = 0;
				while (k < array.length) {
					if (array[k] != 0) {
						if (array[k] != array[j]) {
							if ((array[k] % array[j]) == 0) {
								array[k] = 0;
							}
						}
					}
					k++;
				}
			}
			j++;
			// System.out.println(j);
		}

		array[0] = 0;// This will remove one from the list of prime numbers.
		System.out.println(Arrays.toString(array));// This will print the converted prime numbers.
		arrayStore = new int[len];
		// System.out.println("length "+arrayStore.length);
		for (int h = 0; h < arrayStore.length; h++) {//stores the prime number in the array
			arrayStore[h] = array[h];
		}

	}

	//
	public static void goldbach(int[] arrayE) {// Method to print the even numbers.

		int x = 0;
		while (x < arrayE.length) {
			if (arrayE[x] < 4) {
				arrayE[x] = 0;

			}
			if (arrayE[x] > 3) {
				if (arrayE[x] % 2 != 0) {
					arrayE[x] = 0;
				}
			}
			x++;
		}
		System.out.println(Arrays.toString(arrayE) + "\n");// It Prints the array of even numbers between 4 and entered
															// limit.

		System.out.println("Two primes that add to even numbers\n");

		for (int m = 0; m < arrayE.length; m++) {// This loop sends the Even number to get the sum of two primes.
			// System.out.println(arrayE[m]);
			checkSum(arrayE[m], arrayStore);

		}

	}

	public static void checkSum(int t, int[] art) {// Method to find out the sum.
		int sum = 0;
		int count = 0;
		if (t != 0) {// For efficient performance will skip the O.
			for (int y = 0; y < art.length; y++) {
				if (count == 1) {// This will stop double printing (3+5) and (5+3)
					break;
				}
				for (int z = 0; z < art.length; z++) {
					sum = art[y] + art[z];
					if (sum == t) {
						System.out.println(t + " =( " + art[y] + " + " + art[z] + ")");// the sum will be printed here.
						count++;
					}
					if (sum > t) {
						break;
					}
					if (count == 1) {// This will stop double printing (3+5) and (5+3).
						break;
					}

				}
			}
		}

	}
}
