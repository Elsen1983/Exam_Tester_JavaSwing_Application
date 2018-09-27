package testReader;

import java.util.Arrays;

public class IntArrayUpdate {
	static int[] mainArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createNormalArrays();

	}

	public static void createNormalArrays() {
		/// ARRAYS
		// create an array with number(no repeat) between 1 and 40
		int qnum = 40;
		int[] oldArray = new int [qnum];
		for(int f=0; f<oldArray.length; f++){
			oldArray[f]=f+1;


		}
		System.out.println("Int Array: " + Arrays.toString(oldArray));
		System.out.println(oldArray.length);



		// Here you would assign and fill oldArray
		Integer[] newArray = new Integer[oldArray.length];
		int i = 0;
		for (int value : oldArray) {
		    newArray[i++] = Integer.valueOf(value);

		}
		System.out.println("NUMBER OF QUESTION: " + Arrays.toString(newArray));
		System.out.println(newArray.length);







	}
}
