package designGUI;

/// JTextfield + filewrite : http://www.java2s.com/Tutorials/Java/Java_Swing/0820__Java_Swing_JTextField.htm
// http://www.java2s.com/Tutorial/Java/0260__Swing-Event/ValidatingaJTextFieldWhenPermanentlyLosingtheFocus.htm

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CreateQuestionWriter extends ExamTesterApp {

	// store the TextField default border from UIManager
	static Border mainBorder = UIManager.getBorder("TextField.border");
	static String newQuizNametext = welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.getText();
	static String newQuizFileName_String = "";

	// CREATE NEW QUIZ
	public static void createFullNewQuiz() {

		if (welcomeCreatingPanel_CreateNewCheckBox_CheckBox.isSelected() == true) {

			createNewCheckBoxIsSelectedMethod();

			newQuizNameTextFieldFocus();

		} else {
			createNewCheckBoxIsNotSelectedMethod();
		}
	}

	// hide or change components when createNewCheckBox isSelected == true
	private static void createNewCheckBoxIsSelectedMethod() {

		welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(false);

		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEnabled(true);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEditable(true);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setBorder(new LineBorder(Color.RED, 2, true));

		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setEnabled(false);

		welcomeCreatingPanel_ExpandExistQuizNameLabel_Label.setText("Exist Quiz Name");
		welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label.setText("0");
		welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label.setText("0");

		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setEnabled(false);
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(false);

	}

	// show or change components when createNewCheckBox isSelected == false
	private static void createNewCheckBoxIsNotSelectedMethod() {

		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEditable(false);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEnabled(false);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setBorder(mainBorder);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setText(newQuizNametext);

		welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setEnabled(false);

		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setEnabled(true);

		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setEnabled(true);

		// welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(true);
		// welcomeCreatingPanel_ModifyQuestionNumberList_List.setSelectedIndex(0);

		welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(false);

	}

	private static void newQuizNameTextFieldFocus() {

		// focusListener on Create-New-Quiz-TextField ...
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.addFocusListener(new FocusListener() {
			// FOUCUS - GAINED
			@Override
			public void focusGained(FocusEvent arg0) {
				welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setEnabled(true);
				welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setText("");
			}

			// FOCUS - LOST
			@Override
			public void focusLost(FocusEvent arg0) {
				if (welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.getText().isEmpty()) {
					textFieldIsEmpty();
				} else {
					welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setEnabled(true);

				}
			}

			// if the TextField is Empty ...
			private void textFieldIsEmpty() {

				System.out.println("Nem jo a sszoveeeeeg");

				welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setText(newQuizNametext);
				welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setBorder(new LineBorder(Color.RED, 2, true));

				welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setEnabled(false);

				welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(false);

			}
		});
	}

	// EXPAND EXIST QUIZ METHOD
	public static void expandExistQuiz() {

		// status necesarry for the cancel button option
		int status = openThisFile_FileChooser.showOpenDialog(null);

		// if checkbox selected
		if (welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.isSelected()) {

			createExpandExistQuizCheckBoxIsSelectedMethod();

			// file selected
			if ((status == JFileChooser.APPROVE_OPTION)) {

				choosedFileNameForExistTest_String = openThisFile_FileChooser.getSelectedFile().getName();

				System.out.println("1 - Megnyitott fajl neve: " + openThisFile_FileChooser.getSelectedFile().getName());

				welcomeCreatingPanel_ExpandExistQuizNameLabel_Label
						.setText(openThisFile_FileChooser.getSelectedFile().getName());

				readExistQuizQuestionNumber("expandquiz");

				welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(true);

			}
			// file not selected
			else if (status == JFileChooser.CANCEL_OPTION) {
				System.out.println("Cancel pressed");
				welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setSelected(false);
				createExpandExistQuizCheckBoxIsNotSelected();
			}

		} else {
			createExpandExistQuizCheckBoxIsNotSelected();
		}

	}

	// if checkbox is selected
	public static void createExpandExistQuizCheckBoxIsSelectedMethod() {

		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setEnabled(false);

		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setEnabled(false);

		welcomeCreatingPanel_ModifyQuestionNumberList_List.setSelectedItem(false);
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(false);

	}

	// if checkbox is not selected
	public static void createExpandExistQuizCheckBoxIsNotSelected() {

		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setEnabled(true);
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setEnabled(true);
		welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(false);
	}

	/*
	 * public static void setEnabledFalseAllComponent(){
	 *
	 * welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setEnabled(false);
	 * welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setEnabled(false);
	 * welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setEnabled(false);
	 * welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setEnabled(
	 * false);
	 * welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(false);
	 * welcomeCreatingPanel_STARTButton_Button.setEnabled(false); }
	 */

	// CHANGE EXIST QUIZ QUESTION OR ANSWER METHODS
	public static void changeExistQuizQuestion() {

		// status necesarry for the cancel button option
		int status2 = openThisFile_FileChooser.showOpenDialog(null);

		// if checkbox selected
		if (welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.isSelected() == true) {

			createChangeExistQuizQuestionCheckBoxIsSelectedMethod();

			// file selected
			if ((status2 == JFileChooser.APPROVE_OPTION)) {

				choosedFileNameForExistTest_String = openThisFile_FileChooser.getSelectedFile().getName();

				System.out.println("1 - Megnyitott fajl neve: " + openThisFile_FileChooser.getSelectedFile().getName());

				welcomeCreatingPanel_ChangeExistQuestionNameLabel_Label
						.setText(openThisFile_FileChooser.getSelectedFile().getName());

				readExistQuizQuestionNumber("changequestion");

				welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(true);
				createChangeExistQuestionNumbersArray();
			}
			// file not selected
			else if (status2 == JFileChooser.CANCEL_OPTION) {
				System.out.println("Cancel pressed on change checkbox");
				welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setSelected(false);
				createChangeExistQuizQuestionCheckBoxIsNotSelected();
			}

		}
		// when not selected
		else {
			createChangeExistQuizQuestionCheckBoxIsNotSelected();
		}

	}



	// if checkbox is selected
	public static void createChangeExistQuizQuestionCheckBoxIsSelectedMethod() {

		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setEnabled(false);

		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setEnabled(false);

		welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(true);

	}

	// if checkbox is not selected
	public static void createChangeExistQuizQuestionCheckBoxIsNotSelected() {

		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setEnabled(true);
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setEnabled(true);
		welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(false);
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(false);
		//.setSelectedIndex(-1) for empty field
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setSelectedIndex(-1);
	}

	//create an int Array (numbers of question in the file)
	private static void createChangeExistQuestionNumbersArray() {
		// TODO Auto-generated method stub
		try{
			int parsedQuestionNumber = Integer.parseInt(welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label.getText());

			createNormalArraysForComboBox(1, parsedQuestionNumber);
				if(welcomeCreatingPanel_ModifyQuestionNumberList_List.getSelectedItem()!=null){
					welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(true);
				}

		}catch (NumberFormatException ex) {
			System.out.println("NumberFormat Exception on createChangeExistQuestionNumbersArray() method ");
		}

	}

	// METHODS FOR NORMAL ARRAY
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static void createNormalArraysForComboBox(int min, int max) {
			/// ARRAYS
			// create an Integer array with number(no repeat) between min and max
			int arraylength = (max + 1) - min;

			mainArr = new int[arraylength];
			for (int i = 0; i < mainArr.length; i++) {
				// i+1 because 0 is'nt good for question number, so now first number
				// is 1 in the mainArray
				mainArr[i] = i + min;
			}
			System.out.println(Arrays.toString(mainArr));

			ArrayList <Integer>mainArrayList = new ArrayList<Integer>();
			for (int index = 0; index < mainArr.length; index++)
			{
				mainArrayList.add(mainArr[index]);
			}

			welcomeCreatingPanel_ModifyQuestionNumberList_List.setModel(new DefaultComboBoxModel(mainArrayList.toArray()));

		}

		public static void grabChoosedNumberFromComboBox(){
			if(welcomeCreatingPanel_ModifyQuestionNumberList_List.isEnabled()){
				int choosedNumber;
				choosedNumber = welcomeCreatingPanel_ModifyQuestionNumberList_List.getSelectedIndex()+1;
				System.out.println("Selected Number is: " + choosedNumber);
			}
		}



	public static void createQuizButtonActions() {
		// Option 1 is active
		if (welcomeCreatingPanel_CreateNewCheckBox_CheckBox.isSelected() == true)
		{

		}
		else if(welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.isSelected()==true){

		}
		else if(welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.isSelected() && welcomeCreatingPanel_ModifyQuestionNumberList_List.isEnabled()){
		{
			grabChoosedNumberFromComboBox();
		}

		}

	}

	// change components to clear after pressed 'back to main' button
	public static void cleanAllCreateWelcomeComponentsAfterBackToMain() {
		mainFrame_Frame.setTitle("Exam Tester/Creater Application");

		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setEnabled(true);

		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setText("'ExampleFilename' here without extension.");
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEnabled(false);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEditable(false);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setBorder(CreateQuestionWriter.mainBorder);
		welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setEnabled(false);

		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setEnabled(true);

		welcomeCreatingPanel_ExpandExistQuizNameLabel_Label.setText("Exist Quiz Name");
		welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label.setText("0");

		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setSelected(false);
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setEnabled(true);
		welcomeCreatingPanel_ChangeExistQuestionNameLabel_Label.setText("Exist Quiz Name");
		welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label.setText("0");
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(false);
		//.setSelectedIndex(-1) for empty field
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setSelectedIndex(-1);

		welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(false);

		// change more few thing (.set....
	}

	// read questions number from the file first line
	public static void readExistQuizQuestionNumber(String labelName) {
		File file = new File(ExamTesterApp.choosedFileNameForExistTest_String);
		try (BufferedReader brQnum = new BufferedReader(new FileReader(file))) {
			String firstLine = brQnum.readLine();
			if (firstLine != null) {

				if (firstLine.startsWith("QUESTIONNUMBER")) {

					String[] separate = firstLine.split(" ");

					String sepMax2 = separate[1];

					if(labelName == "expandquiz"){
						welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label.setText(sepMax2);
					}
					else{
						welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label.setText(sepMax2);
					}
				} else {
					System.out.println(file.toString() + "is invalid!");
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't find file " + file.toString());

		} catch (IOException e) {
			System.out.println("Unable to read file " + file.toString());
		}
	}




}
