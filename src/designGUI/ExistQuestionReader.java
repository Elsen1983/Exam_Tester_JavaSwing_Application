package designGUI;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class ExistQuestionReader {
	static String[] fileName;
	static int questionNumber;

	static String pictureNumber;
	static int picNumInt;

	static String[] imageFolder;
	static String imageFoldername = "";

	static String part2;

	static String questionText;
	static String buttonAnswerTextA;
	static String buttonAnswerTextB;
	static String buttonAnswerTextC;
	static String buttonAnswerTextD;
	static String buttonAnswerTextE;
	static String rightAnswer;
	static String answerJustification;

	static String question = "QUESTION:";

	static String[] answersSentenceArray;
	static String[] answerLettersArray = {};
	static String answerText;
	static String answersString;

	static int arrValue;

	public static String sepMax2;
	// public static int questionNumbersMin;
	public static int questionNumberMaximum;

	//public static void main(String[] args) {
	//}

	public ExistQuestionReader() {
	}

	// Constructors
	public ExistQuestionReader(int numberofquestion) {
		ExistQuestionReader.questionNumber = numberofquestion;
		System.out.println("AZ ELSO SZAM az ARRAYBOL :" + numberofquestion);
		dataBankReader(questionNumber);
	}

	// METHODS

	//////////// FILEREADER /////////////
	public static void dataBankQuestionNumber() {
		System.out.println("2 - Meghivjuk a dataBankQuestionNumber method-ot!");
		File file = new File(ExamTesterApp.choosedFileNameForExistTest_String);
		System.out.println("A kivalasztott file neve: " + ExamTesterApp.choosedFileNameForExistTest_String);
		try (BufferedReader brQnum = new BufferedReader(new FileReader(file))) {

			String firstLine = brQnum.readLine();
			System.out.println("Elso sor a txt-ben: " + firstLine);

			if (firstLine != null) {

				if (firstLine.startsWith("QUESTIONNUMBER")) {

					String[] separate = firstLine.split(" ");
					// a new String, which equal with the first element in the
					// array (index 0)
					// String sep1 = separate[0];
					// second string from the array (index 1)
					sepMax2 = separate[1];

					System.out.println("3 - Ami visszaad egy Stringet (a kerdesek max szamaval) eloszor: " + sepMax2);

					try {
						questionNumberMaximum = Integer.parseInt(sepMax2);
						System.out.println("4 - Amit atalakitunk int-re: " + questionNumberMaximum);
					} catch (NumberFormatException e) {
						System.out.println("NumberFormatException on Integer.parseInt(sepMax2).");
					}

					ExamTesterApp.welcomeTestingPanel_QuestionInModulNumberLabel_Label.setText(sepMax2);
					// System.out.println("5a - Ezt az int-et elmentjuk qnum
					// int-kent a main class-ben.");
					// System.out.println("5b - Ezt az int-et kiirjuk a
					// questionNumberLabel-re.");
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't find file " + file.toString());
			ExamTesterApp.welcomeTestingPanel_ThirdStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));
			ExamTesterApp.welcomeTestingPanel_OpenExamButton_Button.setBorder(new LineBorder(Color.RED, 2, true));
		} catch (IOException e) {
			System.out.println("Unable to read file " + file.toString());
		}

	}

	//////////// FILEREADER /////////////
	public static void dataBankReader(int number) {
		// create new file
		File file = new File(ExamTesterApp.choosedFileNameForExistTest_String);
		// use bufferedreader and filereader together (only over Java7)
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String firstLine;
			// when the nextline is contain anything do ...
			while ((firstLine = br.readLine()) != null) {
				// when the line contain or starts with "QUESTION:" than ...
				if (firstLine.startsWith("QUESTION")) {
					// than create a String array which contain all element from
					// the text-line
					// splited by a space (" ")
					String[] parts = firstLine.split(" ");
					// a new String, which equal with the first element in the
					// array (index 0)
					String part1 = parts[0];
					// second string from the array (index 1)
					part2 = parts[1];

					// need try and catch because Integer.parseInt() need a
					// NumberFormatException
					try {
						// when the int number from the dataBankReader statement
						// is equal with
						// the second element of the array (part2) than ...
						if (number == Integer.parseInt(part2.trim())) {
							// console print out
							System.out.println(part1 + " " + part2);

							// try this way :
							// http://www.java-forums.org/advanced-java/42817-how-read-current-previous-next-line-text-file.html
							pictureNumber = br.readLine();
							questionText = br.readLine();
							buttonAnswerTextA = br.readLine();
							buttonAnswerTextB = br.readLine();
							buttonAnswerTextC = br.readLine();
							buttonAnswerTextD = br.readLine();
							buttonAnswerTextE = br.readLine();
							// answer
							rightAnswer = br.readLine();
							// justification
							answerJustification = br.readLine();

							// imageFoldername = imageFolder[0];
							// System.out.println(imageFoldername);
							// change image
							changeImage();

							// change Texts
							changeTexts();

							saveAnswer();
						}

					} catch (NumberFormatException e) {
						System.out.println("NumberFormatException on Integer.parseInt(part2.trim().");
					}

				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file " + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file " + file.toString());
		}
	}

	// save the answer from textfile into an array (answerLettersArray)
	public static void saveAnswer() {

		answersSentenceArray = rightAnswer.split(" ");

		// answerString = answersSentenceArray 2nd element (A,B, ...)
		answersString = answersSentenceArray[1];

		// CLEAN AnswerLettersArray
		List<String> list = new ArrayList<String>(Arrays.asList(answerLettersArray));
		list.clear();
		answerLettersArray = list.toArray(new String[0]);
		// System.out.println("Uresre torolt array: " +
		// Arrays.toString(answerLettersArray));

		// if answersString is contain ',' then split that into an other array
		// (answerLettersArray)
		if (answersString.contains(",")) {

			answerLettersArray = answersString.split(",");
			System.out.println("Tobb valasz van: " + Arrays.toString(answerLettersArray));
		}
		// if not contain ',' then
		else {
			answerLettersArray = new String[1];
			answerLettersArray[0] = answersString;
			System.out.println("Egy valasz van: " + Arrays.toString(answerLettersArray));
		}

	}

	// change image
	public static void changeImage() {
		// change image

		System.out.println(ExamTesterApp.choosedFileNameForExistTest_String);
		if (ExamTesterApp.choosedFileNameForExistTest_String.contains(".")) {

			imageFolder = ExamTesterApp.choosedFileNameForExistTest_String.split("\\.(?=[^\\.]+$)");
			imageFoldername = imageFolder[0];
			// String fileType = imageFolder[1];
		}else{}

			try {
				picNumInt = Integer.parseInt(pictureNumber);
				ImageIcon img = new ImageIcon("images/" + imageFoldername + "/" + picNumInt + ".jpg");
				img.getImage().flush();
				ImageDisplay.imageDisplayField.setIcon(img);
			} catch (NumberFormatException e) {
				System.out.println("NumberFormatException on Integer.parseInt(pictureNumber).");
			}

		if (picNumInt == 0) {
			ExamTesterApp.testingPanel_ShowImageButton_Button.setEnabled(false);

		} else {
			ExamTesterApp.testingPanel_ShowImageButton_Button.setEnabled(true);
		}
	}

	// change Texts
	public static void changeTexts() {
		ExamTesterApp.testingPanel_QuestionTextArea_TextArea.setText(questionText);
		ExamTesterApp.testingPanel_AnswerAText_TextArea.setText(buttonAnswerTextA);
		ExamTesterApp.testingPanel_AnswerBText_TextArea.setText(buttonAnswerTextB);
		ExamTesterApp.testingPanel_AnswerCText_TextArea.setText(buttonAnswerTextC);
		ExamTesterApp.testingPanel_AnswerDText_TextArea.setText(buttonAnswerTextD);
		ExamTesterApp.testingPanel_AnswerEText_TextArea.setText(buttonAnswerTextE);
	}

}
