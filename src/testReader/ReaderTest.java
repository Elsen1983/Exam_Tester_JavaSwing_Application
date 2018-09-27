package testReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReaderTest {
static String question = "QUESTION:";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dataBankReader(1);
	}

////////////FILEREADER /////////////
	public static void dataBankReader(int number){
	//create new file
	File file = new File("questiondataBank.txt");
	//use bufferedreader and filereader together (only over Java7)
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String firstLine;
			//when the nextline is contain anything do ...
			while ((firstLine = br.readLine()) != null) {
				//when the line contain or starts with "QUESTION:" than ...
				if(firstLine.startsWith("QUESTION:")){
					//than create a String array which contain all element from the text-line
					//splited by a space (" ")
					String[] parts = firstLine.split(" ");
					//a new String, which equal with the first element in the array (index 0)
					String part1 = parts[0];
					//second string from the array (index 1)
					String part2 = parts[1];
					//print arrays element to the console
					//System.out.println("If line.CONTAINS('QUESTION:') - " + part1 + " " + part2);

					//need try and catch because Integer.parseInt() need a NumberFormatException
					try{
						//when the int number from the dataBankReader statement is equal with
						//the second element of the array (part2) than ...
						//http://alvinalexander.com/java/edu/qanda/pjqa00010.shtml
						if(number == Integer.parseInt(part2.trim()) ){
							//console print out
							System.out.println(part1 + " " + part2);

							// try this way : http://www.java-forums.org/advanced-java/42817-how-read-current-previous-next-line-text-file.html
							String lineSecond = br.readLine();
							String lineThird = br.readLine();
							String lineFourth = br.readLine();
							String lineFifth = br.readLine();
							String lineSixth = br.readLine();





							System.out.println(lineSecond);
							System.out.println(lineThird);
							System.out.println(lineFourth);
							System.out.println(lineFifth);
							System.out.println(lineSixth);
						break;

						}

					} catch (NumberFormatException e) {
							      //No problem this time, but still it is good practice to care about exceptions.
							      //Never trust user input :)
							      //Do something! Anything to handle the exception.
						}

					//br.ready();
				}

			}
		} catch (FileNotFoundException e) {
				System.out.println("Can't find file " + file.toString());
			} catch (IOException e) {
					System.out.println("Unable to read file " + file.toString());
				}

	}

}
