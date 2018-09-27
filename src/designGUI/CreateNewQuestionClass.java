package designGUI;



import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CreateNewQuestionClass extends ExamTesterApp{

	static boolean activate = false;
	
	public static void changeTxtAreaAndButtonSelectionToDefault(JTextArea txtArea, JButton button){
		button.setBorder(defaultBorder);
		button.setEnabled(false);

		txtArea.setBorder(defaultBorder);
		txtArea.setEnabled(false);
	}

	public static void changeForAnswersField(JButton button, JTextArea txtArea){
		button.setBorder(defaultBorder);
		button.setEnabled(false);

		txtArea.setBorder(defaultBorder);
		txtArea.setEnabled(false);

	}
	
	public static void checkAnswerButtonActionWithTextArea(JButton button,JButton button2, JTextArea textArea, JLabel label){
		
		button.setBorder(thickBlueBorder);
		textArea.setEnabled(true);
		
		

		if (textArea.getText().equals("Answer...")) {
			textArea.setText("");
			textArea.setBorder(thickRedBorder);
			textArea.setEditable(true);
			textArea.requestFocus();
			
		}else{
			textArea.setBorder(thickRedBorder);
			textArea.setEditable(true);
			textArea.requestFocus();
			button2.setBorder(thickBlueBorder);
			button2.setEnabled(true);
			label.setIcon(imgYes);
			
		}
		
	}
	
	public static void minimumAnswerAdded(){
		
		int answer1=0;
		int answer2=0;
		int answer3=0;
		int answer4=0;
		int answer5=0;
		
		
		
		if(createNewQuiz_AddAnswerATextArea_TextArea.getBorder().equals(thickBlueBorder)){
			System.out.println("COLOR Blue");
			answer1 = 1;
		}else if(createNewQuiz_AddAnswerATextArea_TextArea.getBorder().equals(thickRedBorder) || createNewQuiz_AddAnswerATextArea_TextArea.getBorder().equals(defaultBorder)){
			answer1 = 0;
			System.out.println("COLOR Red");
		}
		
		if(createNewQuiz_AddAnswerBTextArea_TextArea.getBorder().equals(thickBlueBorder)){
			System.out.println("COLOR Blue");
			answer2 = 1;
		}else if(createNewQuiz_AddAnswerBTextArea_TextArea.getBorder().equals(thickRedBorder) || createNewQuiz_AddAnswerBTextArea_TextArea.getBorder().equals(defaultBorder)){
			answer2 = 0;
			System.out.println("COLOR Red");
		}
		
		if(createNewQuiz_AddAnswerCTextArea_TextArea.getBorder().equals(thickBlueBorder)){
			System.out.println("COLOR Blue");
			answer3 = 1;
		}else if(createNewQuiz_AddAnswerCTextArea_TextArea.getBorder().equals(thickRedBorder) || createNewQuiz_AddAnswerCTextArea_TextArea.getBorder().equals(defaultBorder)){
			answer3 = 0;
			System.out.println("COLOR Red");
		}
		if(createNewQuiz_AddAnswerDTextArea_TextArea.getBorder().equals(thickBlueBorder)){
			System.out.println("COLOR Blue");
			answer4 = 1;
		}else if(createNewQuiz_AddAnswerDTextArea_TextArea.getBorder().equals(thickRedBorder) || createNewQuiz_AddAnswerDTextArea_TextArea.getBorder().equals(defaultBorder)){
			answer4 = 0;
			System.out.println("COLOR Red");
		}
		
		if(createNewQuiz_AddAnswerETextArea_TextArea.getBorder().equals(thickBlueBorder)){
			System.out.println("COLOR Blue");
			answer5 = 1;
		}else if(createNewQuiz_AddAnswerETextArea_TextArea.getBorder().equals(thickRedBorder) || createNewQuiz_AddAnswerETextArea_TextArea.getBorder().equals(defaultBorder)){
			answer5 = 0;
			System.out.println("COLOR Red");
		}
		
		///////
		int numberAnswer = (answer1) + (answer2) +(answer3) +(answer4) +(answer5);
		
		System.out.println("Active answer: "+numberAnswer);
		
		
		if(numberAnswer>=2){
			activate = true;
		}else{
			activate = false;
		}
		
		///////
		if(activate==true){
			createNewQuiz_AddExplanationButton_Button.setEnabled(true);
		}else{
			createNewQuiz_AddExplanationButton_Button.setEnabled(false);
		}
		
		
	}
	
	public static void checkAnswerFieldFocusLost(JTextArea textArea, JButton button, JLabel label){
				//if the text-field not equal with a simple " " (space) or nothing ""
				String questionStr = textArea.getText();
				String questionStrNoSpace = questionStr.replaceAll(" ", "");

				
				if(questionStrNoSpace.length()>0){
					label.setIcon(imgYes);
					textArea.setBorder(thickBlueBorder);
					textArea.setEditable(false);
				}
				else{
					textArea.setText("Answer...");

					textArea.setEnabled(false);
					textArea.setBorder(defaultBorder);

					button.setBorder(thickRedBorder);
					button.setEnabled(true);

					label.setIcon(imgNo);
				}
				
				

	}
	
	public static void answerFieldKeyTypedBackspaceEqualNothing(JTextArea textArea, JButton button, JLabel label, JCheckBox checkBox){
		textArea.setEnabled(false);
		textArea.setBorder(defaultBorder);

		button.setBorder(thickRedBorder);
		button.requestFocus();

		label.setIcon(imgNo);
		
		checkBox.setEnabled(false);
		
		CreateNewQuestionClass.minimumAnswerAdded();
		
		
	}
	public static void answerFieldKeyTypedBackspaceEqualSomething(JTextArea textArea, JLabel label, JButton button, JCheckBox checkBox){

		label.setIcon(imgYes);
		textArea.setBorder(thickBlueBorder);
		
		if (!button.isEnabled()) {
			button.setEnabled(true);
			button.setBorder(thickRedBorder);
			
			CreateNewQuestionClass.minimumAnswerAdded();
		}
		checkBox.setEnabled(true);
		CreateNewQuestionClass.minimumAnswerAdded();
	}
	
}
