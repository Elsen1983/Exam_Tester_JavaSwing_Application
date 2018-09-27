package designGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class ExamTesterApp {

	// -----------JFRAME-------------- JFRAME ---------------JFRAME-----------
	public static JFrame mainFrame_Frame;

	// ----------- PANELS + elements-------------- PANELS + elements
	// --------------- PANELS + elements -----------

	// *******************
	// *** MAIN-SCREEN ***
	// *******************
	public static JPanel mainScreenPanel_Panel = new JPanel();
	public static JLabel mainscreenCreatedByLabel_Label = new JLabel("created by Norbert Korom");
	public static JLabel mainscreenAppNameLabel_Label = new JLabel("Exam Questions");
	public static JLabel mainscreenLaguageSelection_Label = new JLabel("Selected Language");
	public static JComboBox<String> mainscreenLanguageSelection_ComboBox = new JComboBox<String>();

	public static JButton mainscreenCreateQuiz_Button = new JButton("Create Quiz");
	public static JButton mainscreenExistQuizTest_Button = new JButton("Exist Quiz Test");

	// ********************************************
	// *** WELCOME PANEL FOR CREATING QUESTIONS ***
	// ********************************************
	private final static JPanel welcomeCreatingPanel_Panel = new JPanel();
	public static Label welcomeCreatingPanel_WelcomeAndGoodLabel_Label = new Label("Welcome And Good Work!");
	private final static JPanel welcomeCreatingPanel_OptionOnePanel_Panel = new JPanel();
	public static JLabel welcomeCreatingPanel_OptionOneLabel_Label = new JLabel("Option 1 - Create a new Quiz");
	public static JCheckBox welcomeCreatingPanel_CreateNewCheckBox_CheckBox = new JCheckBox("Create New Quiz  ");
	public static JTextField welcomeCreatingPanel_CreateNewQuizNameTextField_TextField = new JTextField();
	public static JButton welcomeCreatingPanel_ValidateNewQuizNameButton_Button = new JButton("Validation");
	private final static JPanel welcomeCreatingPanel_OptionTwoPanel_Panel = new JPanel();
	public static JLabel welcomeCreatingPanel_OptionTwoLabel_Label = new JLabel(
			"Option 2 - Expand an exist quiz...add one or more question to the exist quiz.");
	public static JCheckBox welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox = new JCheckBox(
			"Expand Exist Quiz  ");
	public static JLabel welcomeCreatingPanel_ExpandExistQuizNameLabel_Label = new JLabel("Exist Quiz Name");
	public static JLabel welcomeCreatingPanel_ExpandExistQuizNumberLabel_Label = new JLabel("Last question number ");
	public static JLabel welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label = new JLabel("0");
	private final static JPanel welcomeCreatingPanel_OptionThreePanel_Panel = new JPanel();
	private final static JLabel welcomeCreatingPanel_OptionThreeLabel_Label = new JLabel(
			"Option 3 - Modify an exist quiz question or answer.");
	private final JPanel welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel = new JPanel();
	public static JCheckBox welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox = new JCheckBox(
			"Change a question.");
	public static JLabel welcomeCreatingPanel_ChangeExistQuestionNameLabel_Label = new JLabel("Exist Quiz Name");
	public static JLabel welcomeCreatingPanel_ChangeExistQuestionNumberLabel_Label = new JLabel(
			"Questions in the file: ");
	public static JLabel welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label = new JLabel("0");
	public static JLabel welcomeCreatingPanel_ModifyQuestionNumberLabel_Label = new JLabel("Question number ");
	public static JComboBox<Integer> welcomeCreatingPanel_ModifyQuestionNumberList_List = new JComboBox<Integer>();
	public static JButton welcomeCreatingPanel_CreateQuizButton_Button = new JButton("Create Quiz");
	public static JButton welcomeCreatingPanel_BackToMainScreenButton_Button = new JButton("Back to Main Screen");

	// *******************************************
	// *** CREATE NEW QUIZ PANEL ***
	// *******************************************
	public static JPanel createNewQuizPanel_Panel = new JPanel();

	private final JPanel createNewQuiz_QuestionPanel_Panel = new JPanel();
	public static JLabel createNewQuiz_NameOfTheFileLavel_Label = new JLabel("Name of the File");
	private final JLabel createNewQuiz_QuestionsLabel_Label = new JLabel("Question :");

	private final JButton createNewQuiz_AddQuestionButton_Button = new JButton("Add Question");
	// create a JButton with 2 line Label :
	// http://www.javaworld.com/article/2077368/learn-java/a-multiline-button-is-possible.html
	// private final JLabel questionBtnText1 = new JLabel("Add/Change");
	// private final JLabel questionBtnText2 = new JLabel("Question");

	private final JScrollPane createNewQuiz_AddNewQuestionsScrollPane_ScrollPane = new JScrollPane();
	private final JTextArea createNewQuiz_AddNewQuestionsTeaxtArea_TextArea = new JTextArea();
	private final JButton createNewQuiz_AddAnImageButton_Button = new JButton("Add Image");
	private final JButton createNewQuiz_NoImageButton_Button = new JButton("No Image");

	private final JPanel createNewQuiz_AnswersPanel_Panel = new JPanel();
	private final JLabel createNewQuiz_AnswersLabel_Label = new JLabel("Answer(s) :");

	protected static JButton createNewQuiz_AddAnswerAButton_Button = new JButton("Add '1st'");
	private final JScrollPane createNewQuiz_AddAnswerAScrollPane_ScrollPane = new JScrollPane();
	protected static JTextArea createNewQuiz_AddAnswerATextArea_TextArea = new JTextArea();
	protected static JButton createNewQuiz_AddAnswerBButton_Button = new JButton("Add '2nd'");
	private final JScrollPane createNewQuiz_AddAnswerBScrollPane_ScrollPane = new JScrollPane();
	protected static JTextArea createNewQuiz_AddAnswerBTextArea_TextArea = new JTextArea();
	protected static JButton createNewQuiz_AddAnswerCButton_Button = new JButton("Add '3rd'");
	private final JScrollPane createNewQuiz_AddAnswerCScrollPane_ScrollPane = new JScrollPane();
	protected static JTextArea createNewQuiz_AddAnswerCTextArea_TextArea = new JTextArea();
	protected static JButton createNewQuiz_AddAnswerDButton_Button = new JButton("Add '4th'");
	private final JScrollPane createNewQuiz_AddAnswerDScrollPane_ScrollPane = new JScrollPane();
	protected static JTextArea createNewQuiz_AddAnswerDTextArea_TextArea = new JTextArea();
	protected static JButton createNewQuiz_AddAnswerEButton_Button = new JButton("Add '5th'");
	private final JScrollPane createNewQuiz_AddAnswerEScrollPane_ScrollPane = new JScrollPane();
	protected static JTextArea createNewQuiz_AddAnswerETextArea_TextArea = new JTextArea();

	private final JLabel createNewQuiz_AnswersJustificationLabel_Label = new JLabel("Justification :");
	public static JButton createNewQuiz_AddExplanationButton_Button = new JButton("Add Explanation");
	private final JScrollPane createNewQuiz_AnswersJustificationScrollPane_ScrollPane = new JScrollPane();
	private final JTextArea createNewQuiz_AnswersJustificationTextArea_TextArea = new JTextArea();
	private final JLabel createNewQuiz_ChooseCorrectAnswersLabel_Label = new JLabel("Correct answer(s) :");
	private final JCheckBox chckbxAnswerA = new JCheckBox("Answer 1");
	private final JCheckBox chckbxAnswerB = new JCheckBox("Answer 2");
	private final JCheckBox chckbxAnswerC = new JCheckBox("Answer 3");
	private final JCheckBox chckbxAnswerD = new JCheckBox("Answer 4");
	private final JCheckBox chckbxAnswerE = new JCheckBox("Answer 5");
	
	private final JButton btnNewButton = new JButton("Save & Next");
	private final JButton btnNewButton_1 = new JButton("Save & Finish");
	private final JButton btnNewButton_2 = new JButton("Back to Main Screen");
	private final JButton btnExit = new JButton("Exit");

	public static Border thickRedBorder = BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.RED, 2), BorderFactory.createEmptyBorder(5, 5, 5, 5));
	public static Border thickBlueBorder = BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.BLUE, 1), BorderFactory.createEmptyBorder(5, 5, 5, 5));

	public static Border defaultBorder = UIManager.getBorder("Button.border");

	public static ImageIcon imgYes = new ImageIcon(ExamTesterApp.class.getResource("sign-check.jpg"));
	public static ImageIcon imgNo = new ImageIcon(ExamTesterApp.class.getResource("sign-error.jpg"));
	public static ImageIcon imgQuestion = new ImageIcon(ExamTesterApp.class.getResource("sign-question.jpg"));

	private final JLabel createNewQuiz_imageLabelQ = new JLabel(imgNo);
	private final JLabel createNewQuiz_imageLabelImg = new JLabel(
			new ImageIcon(ExamTesterApp.class.getResource("/designGUI/sign-error.jpg")));
	protected final static JLabel createNewQuiz_imageLabelA = new JLabel(imgNo);
	protected final static JLabel createNewQuiz_imageLabelB = new JLabel("");
	protected final static JLabel createNewQuiz_imageLabelC = new JLabel("");
	protected final static JLabel createNewQuiz_imageLabelD = new JLabel("");
	protected final static JLabel createNewQuiz_imageLabelE = new JLabel("");

	// *******************************************
	// *** WELCOME PANEL FOR TESTING QUESTIONS ***
	// *******************************************
	public static JPanel welcomeTestingPanel_Panel = new JPanel();
	public static JPanel welcomeTestingPanel_FromToPanel_Panel = new JPanel();
	public static JTextArea welcomeTestingPanel_TextArea_TextArea = new JTextArea("Welcome and Good Luck!\r\n\r\n");
	public static JLabel welcomeTestingPanel_FirstStepLabel_Label = new JLabel(
			"1st Step - Choose and Open the ExamQuestions!");

	// workingDirectory - the current folder where the application opened
	public static File workingDirectory = new File(System.getProperty("user.dir"));
	// filterFileType - file type which will displayed only in the filechooser
	public static FileNameExtensionFilter filterFileType = new FileNameExtensionFilter("Quiz-TextFile", "txt", "docx");

	public static JButton welcomeTestingPanel_OpenExamButton_Button = new JButton("Open Exam");
	public static JFileChooser openThisFile_FileChooser = new JFileChooser();
	public static JLabel welcomeTestingPanel_ChoosedExamNameLabel_Label = new JLabel("Choosed Exam.");
	public static JLabel welcomeTestingPanel_SecondStepLabel_Label = new JLabel();
	public static JPanel welcomeTestingPanel_NormalOrRandomPanel_Panel = new JPanel();
	public static JCheckBox welcomeTestingPanel_NormalSequenceCheckBox_CheckBox = new JCheckBox("Normal Sequence");
	public static JCheckBox welcomeTestingPanel_RandomSequenceCheckBox_CheckBox = new JCheckBox("Random Sequence");
	public static JPanel welcomeTestingPanel_QuestionInModulePanel_Panel = new JPanel();
	public static JLabel welcomeTestingPanel_QuestionInModulLabel_Label = new JLabel("");
	public static JLabel welcomeTestingPanel_QuestionInModulNumberLabel_Label = new JLabel("");

	public static JLabel welcomeTestingPanel_ThirdStepLabel_Label = new JLabel(
			"3rd Step - Choose the questions numbers in the test!");
	public static JPanel welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel = new JPanel();
	public static JCheckBox welcomeTestingPanel_QuestionAllCheckBox_CheckBox = new JCheckBox("All questions");
	public static JCheckBox welcomeTestingPanel_QuestionFromToCheckBox_CheckBox = new JCheckBox("Selected questions");
	public static JLabel welcomeTestingPanel_FromLabel_Label = new JLabel("From");
	public static JLabel welcomeTestingPanel_ToLabel_Label = new JLabel("To");
	public static JTextField welcomeTestingPanel_QuestionFromTextField_TextField = new JTextField("");
	public static JTextField welcomeTestingPanel_QuestionToTextField_TextField = new JTextField("");
	public static JLabel welcomeTestingPanel_MessageFieldLabel_Label = new JLabel("");
	public static JButton welcomeTestingPanel_STARTButton_Button = new JButton("Start Test");
	public static JButton welcomeTestingPanel_BackToMainScreenButton_Button = new JButton("Back to Main Screen");

	// *************************
	// *** PANEL FOR TESTING ***
	// *************************
	// --- mainTesingPanel ---
	public static JPanel mainTestingPanel_Panel = new JPanel();
	// --- Question(s) & Answer(s) Panel ---
	public static JPanel testingPanel_QuestionAndAnswer_Panel = new JPanel();
	public static JLabel testingPanel_QestionNumberTitle_Label = new JLabel("Question");
	public static JLabel testingPanel_QestionNumber_Label = new JLabel("999");
	public static JLabel testingPanel_QuestionsSelectedFrom_Label = new JLabel("Questions selected from");
	public static JLabel testingPanel_QuestionSelectedFromNumber_Label = new JLabel("999");
	public static JLabel testingPanel_QuestionsSelectedTo_Label = new JLabel("to");
	public static JLabel testingPanel_QuestionSelectedToNumber_Label = new JLabel("999");
	public static JScrollPane testingPanel_ScrollPaneQuestion_ScrollPane = new JScrollPane();
	public static JTextArea testingPanel_QuestionTextArea_TextArea = new JTextArea(" ");
	public static JCheckBox testingPanel_AnswerACheckBox_CheckBox = new JCheckBox("Answer: A");
	public static JCheckBox testingPanel_AnswerBCheckBox_CheckBox = new JCheckBox("Answer: B");
	public static JCheckBox testingPanel_AnswerCCheckBox_CheckBox = new JCheckBox("Answer: C");
	public static JCheckBox testingPanel_AnswerDCheckBox_CheckBox = new JCheckBox("Answer: D");
	public static JCheckBox testingPanel_AnswerECheckBox_CheckBox = new JCheckBox("Answer: E");
	// - Answer(s) JScrollPane(s) + Answer(s) TextArea(s)
	private final JScrollPane testingPanel_ScrollPaneAnswerA_ScrollPane = new JScrollPane();
	public static JTextArea testingPanel_AnswerAText_TextArea = new JTextArea("Answer text");
	private final JScrollPane testingPanel_ScrollPaneAnswerB_ScrollPane = new JScrollPane();
	public static JTextArea testingPanel_AnswerBText_TextArea = new JTextArea("Answer text");
	private final JScrollPane testingPanel_ScrollPaneAnswerC_ScrollPane = new JScrollPane();
	public static JTextArea testingPanel_AnswerCText_TextArea = new JTextArea("Answer text");
	private final JScrollPane testingPanel_ScrollPaneAnswerD_ScrollPane = new JScrollPane();
	public static JTextArea testingPanel_AnswerDText_TextArea = new JTextArea("Answer text");
	private final JScrollPane testingPanel_ScrollPaneAnswerE_ScrollPane = new JScrollPane();
	public static JTextArea testingPanel_AnswerEText_TextArea = new JTextArea("Answer text");

	// --- Any error message field ---
	public static JLabel testingPanel_AnyErrorMessageField_Label = new JLabel("");

	// --- Button(s) Panel ---
	public static JPanel testingPanel_ButtonsPanel_Panel = new JPanel();
	// - Button(s)
	public static JButton testingPanel_NextButton_Button = new JButton("Next");
	public static JButton testingPanel_BackButton_Button = new JButton("Back");
	public static JButton testingPanel_ShowImageButton_Button = new JButton("Show Image");
	public static JButton testingPanel_ShowAnswersButton_Button = new JButton("Show Answer(s)");
	public static JButton testingPanel_CurrentScoreButton_Button = new JButton("Current Score");
	public static JButton testingPanel_BackToMainButton_Button = new JButton("Back to Main Screen");
	public static JButton testingPanel_NewTestButton_Button = new JButton("New Test");
	public static JButton testingPanel_ExitButton_Button = new JButton("Exit");

	// - Show Answer(s) & Justification(s) Panel
	public static JPanel testingPanel_ShowAnswersPanel_Panel = new JPanel();
	public static JScrollPane testingPanel_JustificationScrollPane_ScrollPane = new JScrollPane();
	public static JLabel testingPanel_CorrectAnswersMessageField_Label = new JLabel(" ");
	public static JTextArea testingPanel_JustificationLabel_Label = new JTextArea(" ");

	// **************************
	// *** PANEL FOR CREATION ***
	// **************************
	public static JPanel mainCreating_Panel_Panel = new JPanel();

	// *****************
	// *** VARIABLES ***
	// *****************
	// - FileChooser

	public static String choosedFileNameForExistTest_String = "";

	// Strings, Integers, Arrays
	public static String sequenceLetter = " ";
	public static int picNum = ExistQuestionReader.picNumInt;
	public static String backNormalOrRandom = "";
	public static String answerA;
	public static String answerB;
	public static String answerC;
	public static String answerD;
	public static String answerE;
	public static String justification = "JUSTIFICATION:\n";

	public static String scoreAddOrNO = "ADD";
	public static boolean usedShowAnser = false;

	public static int qnumFirst;
	public static int qnumLast;
	public static int qFirstGet;
	public static int qLastGet;

	public static int[] mainArr;
	public static int[] reversedArray;
	public static int reversedArrayLastElement;

	public static int[] randomArr;
	public static int[] shuffledArray;
	public static int shuffledArrayLastElement;

	public static int[] rebuildArray;
	public static int rebuildArrayNewElement;

	public static String[] answerArray = new String[5];
	// list of the wrong answered questions
	public static List<Integer> wrongQuestionsListArray = new ArrayList<Integer>();
	public static String wrongNumbersString;
	public static int wrongNumbersInteger;

	public static int number;
	public static int numberDifferent = 0;
	public static int numberNoScore = 0;

	public static int goodAsweredNumber = 0;
	public static int wrongAnswerNumber = 0;
	public static int allAnswered;
	public static double scoreAnsweredPercentage;
	public static List<String> wrongAnswersStringList = new ArrayList<String>();

	private final JPanel panel_1 = new JPanel();
	private final JPanel mainBtnsPanel = new JPanel();

	// -------------------------------------------------------------

	// Create the application.
	public ExamTesterApp() {
		initialize();
	}

	/* MAIN METHOD - Launch the application. */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				try {
					// check:
					// http://www.java2s.com/Tutorials/Java/java.awt/EventQueue/Java_EventQueue_invokeLater_Runnable_runnable_.htm
					ExamTesterApp appwindow = new ExamTesterApp();
					appwindow.mainFrame_Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// hide all show mainscreen
		hideAllShowMainScreen();

		// MAINSCREEN BUTTONS
		// mainscreenLanguageSelection_ComboBox ACTION
		mainscreenLanguageSelection_ComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				@SuppressWarnings("unchecked")
				JComboBox<String> mainscreenLanguageSelection_ComboBox = (JComboBox<String>) event.getSource();
				Object selected = mainscreenLanguageSelection_ComboBox.getSelectedItem();

				if (selected.toString().equals("English")) {
					mainscreenLaguageSelection_Label.setText("English Language");
				} else if (selected.toString().equals("Hungarian")) {
					mainscreenLaguageSelection_Label.setText("Hungarian Language");
				} else {
					mainscreenLaguageSelection_Label.setText("Not Selected Language");
				}
				;
			}
		});

		// mainscreenExistQuizTest_Btn ACTION
		mainscreenExistQuizTest_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hideMainScreenAndShowExistTestWelcomePanel();
			}
		});

		// mainscreenCreateQuiz_Btn ACTION
		mainscreenCreateQuiz_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hideMainScreenAndShowCreateTestWelcomePanel();

			}
		});

		// *************************************************************
		// ****** welcometestingPanel Buttons and etc. ACTION **********
		// *************************************************************

		// btnOPENEXAM - file chooser ACTION
		welcomeTestingPanel_OpenExamButton_Button.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent arg0) {
				// current folder

				if ((openThisFile_FileChooser
						.showOpenDialog(welcomeTestingPanel_OpenExamButton_Button) == JFileChooser.APPROVE_OPTION)) {

					// labels border
					welcomeTestingPanel_FirstStepLabel_Label.setBorder(null);
					welcomeTestingPanel_ThirdStepLabel_Label.setBorder(null);
					welcomeTestingPanel_SecondStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));

					welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setSelected(false);

					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);

					welcomeTestingPanel_FromToPanel_Panel.setBorder(null);
					welcomeTestingPanel_FromToPanel_Panel.setEnabled(false);

					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					welcomeTestingPanel_QuestionFromTextField_TextField.setEnabled(false);
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");
					welcomeTestingPanel_QuestionToTextField_TextField.setEnabled(false);

					welcomeTestingPanel_STARTButton_Button.setEnabled(false);

					choosedFileNameForExistTest_String = openThisFile_FileChooser.getSelectedFile().getName();
					System.out.println(
							"1 - Megnyitott fajl neve: " + openThisFile_FileChooser.getSelectedFile().getName());
					welcomeTestingPanel_ChoosedExamNameLabel_Label
							.setText(openThisFile_FileChooser.getSelectedFile().getName());
					// language filter need
					welcomeTestingPanel_QuestionInModulLabel_Label.setText("Questions in the modul:");

					ExistQuestionReader.dataBankQuestionNumber();
					welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setEnabled(true);

				} else {
					ExamTesterApp.welcomeTestingPanel_FirstStepLabel_Label
							.setBorder(new LineBorder(Color.RED, 2, true));
					ExamTesterApp.welcomeTestingPanel_OpenExamButton_Button
							.setBorder(new LineBorder(Color.RED, 2, true));
					// language filter need
					welcomeTestingPanel_MessageFieldLabel_Label
							.setText("The file is invalid, please choose an exist file from the folder!");
				}

			}
		});
		welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setBackground(new Color(245, 255, 250));

		// normalSequenceCheckBox ACTION
		welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.isSelected()) {
					welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setEnabled(false);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setSelected(false);
					// labels border
					welcomeTestingPanel_SecondStepLabel_Label.setBorder(null);
					welcomeTestingPanel_ThirdStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));

					welcomeTestingPanel_FromToPanel_Panel.setBorder(null);
					welcomeTestingPanel_FromToPanel_Panel.setEnabled(false);

					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					// questionFrom.setEnabled(false);
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");
					// questionTo.setEnabled(false);

				} else {
					welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(false);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_STARTButton_Button.setEnabled(false);
					welcomeTestingPanel_SecondStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));
					welcomeTestingPanel_ThirdStepLabel_Label.setBorder(null);

					welcomeTestingPanel_FromToPanel_Panel.setBorder(null);
					welcomeTestingPanel_FromToPanel_Panel.setEnabled(false);

					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					// questionFrom.setEnabled(false);
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");
					// questionTo.setEnabled(false);
				}
			}
		});
		welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setBackground(new Color(245, 255, 250));
		// randomSequenceCheckBox ACTION
		welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.isSelected()) {
					welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setEnabled(false);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setSelected(false);
					// labels border
					welcomeTestingPanel_SecondStepLabel_Label.setBorder(null);
					welcomeTestingPanel_ThirdStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));

					welcomeTestingPanel_FromToPanel_Panel.setBorder(null);
					welcomeTestingPanel_FromToPanel_Panel.setEnabled(false);

					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");

				} else {
					welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(false);
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setSelected(false);
					welcomeTestingPanel_STARTButton_Button.setEnabled(false);
					welcomeTestingPanel_SecondStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));
					welcomeTestingPanel_ThirdStepLabel_Label.setBorder(null);

					welcomeTestingPanel_FromToPanel_Panel.setBorder(null);
					welcomeTestingPanel_FromToPanel_Panel.setEnabled(false);

					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					// questionFrom.setEnabled(false);
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");
					// questionTo.setEnabled(false);
				}
			}
		});
		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setBackground(new Color(245, 255, 250));

		// questionFromToCheckBox ACTION
		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.isSelected()) {

					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(false);

					welcomeTestingPanel_FromToPanel_Panel.setBorder(new LineBorder(Color.RED, 2, true));

					welcomeTestingPanel_QuestionFromTextField_TextField.setEnabled(true);
					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					welcomeTestingPanel_QuestionToTextField_TextField.setEnabled(true);
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");
					welcomeTestingPanel_STARTButton_Button.setEnabled(true);
				} else {
					welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(true);

					welcomeTestingPanel_FromToPanel_Panel.setBorder(null);

					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					welcomeTestingPanel_QuestionFromTextField_TextField.setEnabled(false);
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");
					welcomeTestingPanel_QuestionToTextField_TextField.setEnabled(false);

					welcomeTestingPanel_STARTButton_Button.setEnabled(false);
				}
			}
		});
		welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setBackground(new Color(245, 255, 250));

		// questionAllCheckBox ACTION
		welcomeTestingPanel_QuestionAllCheckBox_CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (welcomeTestingPanel_QuestionAllCheckBox_CheckBox.isSelected()) {

					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);

					welcomeTestingPanel_FromToPanel_Panel.setBorder(null);
					welcomeTestingPanel_FromToPanel_Panel.setEnabled(false);

					welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
					welcomeTestingPanel_QuestionToTextField_TextField.setText("");

					qnumFirst = 1;
					qnumLast = ExistQuestionReader.questionNumberMaximum;
					System.out.println("All Question Selected between " + qnumFirst + " and " + qnumLast);
					testingPanel_QuestionSelectedFromNumber_Label.setText(String.valueOf(qnumFirst));
					testingPanel_QuestionSelectedToNumber_Label.setText(String.valueOf(qnumLast));

					welcomeTestingPanel_STARTButton_Button.setEnabled(true);

					System.out.println(qnumFirst + " - " + qnumLast);
				} else {
					welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(true);
					welcomeTestingPanel_STARTButton_Button.setEnabled(false);

				}
			}
		});

		// questionFrom and questionTo FOCUSGAIN and FOCUSLOST ACTION
		welcomeTestingPanel_QuestionFromTextField_TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				welcomeTestingPanel_QuestionFromTextField_TextField.setText("1");
			}
		});

		welcomeTestingPanel_QuestionFromTextField_TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});

		// questionTo FOCUS Actions
		welcomeTestingPanel_QuestionToTextField_TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				welcomeTestingPanel_QuestionToTextField_TextField
						.setText(welcomeTestingPanel_QuestionInModulNumberLabel_Label.getText());
			}
		});
		welcomeTestingPanel_QuestionToTextField_TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});

		// welcomeTestingBtnSTART ACTION
		welcomeTestingPanel_STARTButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(qnumFirst + " - " + qnumLast);
				// System.out.println("6 - aktivaljuk a Start gombot.");
				// qSelectedFrom.setText(questionFrom.getText());
				// qSelectedTo.setText(questionTo.getText());
				checkFromToNumbersValid();
				mainFrame_Frame.setTitle(openThisFile_FileChooser.getSelectedFile().getName());
			}
		});

		// welcomeTestingBackToMainScreen_Btn ACTION
		welcomeTestingPanel_BackToMainScreenButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hideAllShowMainScreen();
				// language filter need
				mainFrame_Frame.setTitle("Exam Tester/Creater Application");
			}
		});

		// *************************************************************
		// ****** testingPanel Buttons and etc. ACTION **********
		// *************************************************************
		// btnNEXT ACTION
		testingPanel_NextButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				testingPanel_BackButton_Button.setEnabled(true);

				System.out.println("-----------NEXT QUESTION--------------");

				if (checkCheckBox() == true) {
					checkAnswer();
					testingPanel_ShowAnswersButton_Button.setEnabled(true);
					// System.out.println("NEXT 1 - Meghivjuk a
					// deleteLastElement method-ot egy String-el (N vagy R)!");
					deleteLastELement(sequenceLetter);

					System.out.println("Meghivom a getQuestionNumber egy szammal:" + number);

					if (number >= qnumFirst && number <= qnumLast) {

						System.out.println("NEXT - NUMBER after if statement : " + number);

						new ExistQuestionReader(number);

						testingPanel_QestionNumber_Label.setText(String.valueOf(number));

						testingPanel_ShowAnswersPanel_Panel.hide();
						testingPanel_CorrectAnswersMessageField_Label.setVisible(false);
						testingPanel_AnyErrorMessageField_Label.setVisible(false);
						testingPanel_JustificationLabel_Label.setVisible(false);

						testingPanel_JustificationScrollPane_ScrollPane.hide();

						clearCheckBox();

						scoreAddOrNO = "ADD";
						usedShowAnser = false;

					} else {
					}

				} else {
					testingPanel_AnyErrorMessageField_Label.setVisible(true);
					testingPanel_AnyErrorMessageField_Label.setText("Answer not selected. Please choose one or more!");
				}
			}
		});

		// btnBACK ACTION
		testingPanel_BackButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				rebuildBackButtonArray(sequenceLetter);

				if (number >= qnumFirst && number <= qnumLast) {

					clearCheckBox();

					new ExistQuestionReader(number);

					testingPanel_QestionNumber_Label.setText(String.valueOf(number));

					testingPanel_CorrectAnswersMessageField_Label.setVisible(false);
					testingPanel_AnyErrorMessageField_Label.setVisible(false);
					testingPanel_BackButton_Button.setEnabled(false);
					testingPanel_JustificationScrollPane_ScrollPane.hide();
					testingPanel_ShowAnswersPanel_Panel.hide();
					scoreAddOrNO = "NoAdd";
					// number = numberNoScore;
					System.out.println("BACK - NUMBER after = numberNoScore : " + number);

				} else {
					testingPanel_AnyErrorMessageField_Label.setVisible(true);
					testingPanel_AnyErrorMessageField_Label.setText("Answer not selected. Please choose one or more!");
				}
			}
		});

		// btnSHOW/HIDE
		testingPanel_ShowAnswersButton_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				scoreAddOrNO = "NoAdd";
				usedShowAnser = true;

				wrongAnswerNumber = wrongAnswerNumber + 1;
				addElementToWrongAnswerArray();

				testingPanel_CorrectAnswersMessageField_Label.show();
				testingPanel_CorrectAnswersMessageField_Label.setText("ANSWER: " + ExistQuestionReader.answersString);

				testingPanel_JustificationScrollPane_ScrollPane.show();
				testingPanel_ShowAnswersPanel_Panel.show();
				testingPanel_JustificationLabel_Label.setVisible(true);

				testingPanel_JustificationLabel_Label.setText(justification + ExistQuestionReader.answerJustification);
				testingPanel_ShowAnswersButton_Button.setEnabled(false);
			}

		});

		// btnCURRENT_SCORE
		testingPanel_CurrentScoreButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// frmExamsoftwareV.hide();
				allAnswered = goodAsweredNumber + wrongAnswerNumber;
				scoreAnsweredPercentage = (goodAsweredNumber / (double) allAnswered) * (100 / 1);
				if (allAnswered >= 1) {
					// System.out.printf("dexp: %.0f\n",
					// scoreAnsweredPercentage);
					// System.out.println(scoreAnsweredPercentage);
					ActualScore scoreWindow = new ActualScore(goodAsweredNumber, wrongAnswerNumber, allAnswered,
							scoreAnsweredPercentage);
					scoreWindow.setLocationRelativeTo(null);
					scoreWindow.setVisible(true);
				} else {
					testingPanel_AnyErrorMessageField_Label.setVisible(true);
					testingPanel_AnyErrorMessageField_Label
							.setText("Current score is not avilable jet! Answer minimum one question!");
				}

			}
		});

		// btnShowImage
		testingPanel_ShowImageButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ImageDisplay ImageWindow = new ImageDisplay(picNum);
				ImageWindow.setVisible(true);

			}

		});

		// btnBackToMain
		testingPanel_BackToMainButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hideAllShowMainScreen();
				mainFrame_Frame.setTitle("Exam Tester/Creater Application");
			}
		});

		// btnEXIT
		testingPanel_ExitButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame_Frame.dispose();
			}
		});

		// bntNEW_TEST
		testingPanel_NewTestButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// create a new test, so clean all variable, and hide
				// everything, and show the welcomePanel again
				hideMainTestingPanelAndShowTestWelcomePanel();
				// language filter need
				mainFrame_Frame.setTitle("Exam Tester/Creater Application");

				goodAsweredNumber = 0;
				wrongAnswerNumber = 0;
				allAnswered = 0;
				scoreAnsweredPercentage = 0;
				wrongAnswersStringList.clear();
				wrongQuestionsListArray.clear();
				testingPanel_AnswerACheckBox_CheckBox.setSelected(false);
				testingPanel_AnswerBCheckBox_CheckBox.setSelected(false);
				testingPanel_AnswerCCheckBox_CheckBox.setSelected(false);
				testingPanel_AnswerDCheckBox_CheckBox.setSelected(false);
				testingPanel_AnswerECheckBox_CheckBox.setSelected(false);

			}
		});

		// *************************************************************
		// ****** welcomeCreatinggPanel Buttons and etc. ACTION ********
		// *************************************************************

		// -------- MouseListeners (MOUSE-ENTERED) Actions ------------
		// MainPanel
		welcomeCreatingPanel_Panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (welcomeCreatingPanel_CreateNewCheckBox_CheckBox.isSelected() == false
						&& welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.isSelected() == false
						&& welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.isSelected() == false) {
					welcomeCreatingPanel_OptionOneLabel_Label.setBorder(null);
					welcomeCreatingPanel_OptionTwoLabel_Label.setBorder(null);
					welcomeCreatingPanel_OptionThreeLabel_Label.setBorder(null);
				}
			}
		});
		// Option One Panel
		welcomeCreatingPanel_OptionOnePanel_Panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.isSelected() == false
						&& welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.isSelected() == false) {
					welcomeCreatingPanel_OptionOneLabel_Label.setBorder(new LineBorder(Color.RED, 1, true));
					welcomeCreatingPanel_OptionTwoLabel_Label.setBorder(null);
					welcomeCreatingPanel_OptionThreeLabel_Label.setBorder(null);
				}
			}
		});
		// Option Two Panel
		welcomeCreatingPanel_OptionTwoPanel_Panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (welcomeCreatingPanel_CreateNewCheckBox_CheckBox.isSelected() == false
						&& welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.isSelected() == false) {
					welcomeCreatingPanel_OptionOneLabel_Label.setBorder(null);
					welcomeCreatingPanel_OptionTwoLabel_Label.setBorder(new LineBorder(Color.RED, 1, true));
					welcomeCreatingPanel_OptionThreeLabel_Label.setBorder(null);
				}
			}
		});
		// Option Three Panel
		welcomeCreatingPanel_OptionThreePanel_Panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (welcomeCreatingPanel_CreateNewCheckBox_CheckBox.isSelected() == false
						&& welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.isSelected() == false) {
					welcomeCreatingPanel_OptionOneLabel_Label.setBorder(null);
					welcomeCreatingPanel_OptionTwoLabel_Label.setBorder(null);
					welcomeCreatingPanel_OptionThreeLabel_Label.setBorder(new LineBorder(Color.RED, 1, true));
				}
			}
		});

		// -------- ActionListeners CheckBoxes/Buttons Actions ------------

		// welcomeCreatingPanel_CreateNewQuizButton_Button ACTION
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				CreateQuestionWriter.createFullNewQuiz();
			}
		});

		welcomeCreatingPanel_ValidateNewQuizNameButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// if textfield valid do...
				// need validation for text and special characters
				welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(true);
			}
		});

		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.isSelected()) {
					CreateQuestionWriter.expandExistQuiz();
				} else {
					welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setSelected(false);
					welcomeCreatingPanel_ExpandExistQuizNameLabel_Label.setText("Exist Quiz Name");
					welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label.setText("0");
					CreateQuestionWriter.createExpandExistQuizCheckBoxIsNotSelected();
				}
			}
		});

		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.isSelected()) {
					CreateQuestionWriter.changeExistQuizQuestion();
				} else {
					welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setSelected(false);
					welcomeCreatingPanel_ChangeExistQuestionNameLabel_Label.setText("Exist Quiz Name");
					welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label.setText("0");
					CreateQuestionWriter.createChangeExistQuizQuestionCheckBoxIsNotSelected();
				}
			}
		});

		// create CreateQuiz Button Action (Start)
		welcomeCreatingPanel_CreateQuizButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateQuestionWriter.createQuizButtonActions();
			}
		});
		// create BACK to Main Button Action
		welcomeCreatingPanel_BackToMainScreenButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hideAllShowMainScreen();
				// language filter need
				CreateQuestionWriter.cleanAllCreateWelcomeComponentsAfterBackToMain();

			}
		});

		// END OF THE MAIN METHOD
	}

	// ******** METHODS ********* METHODS ********* METHODS ********* METHODS
	// *********

	// hide every panel every elements, and just show the main screen
	@SuppressWarnings("deprecation")
	private static void hideAllShowMainScreen() {

		// show MainScreen
		mainScreenPanel_Panel.setVisible(true);
		mainscreenCreatedByLabel_Label.setVisible(true);
		mainscreenAppNameLabel_Label.setVisible(true);
		mainscreenCreateQuiz_Button.setVisible(true);
		mainscreenExistQuizTest_Button.setVisible(true);

		welcomeCreatingPanel_Panel.setBackground(new Color(245, 255, 250));

		// hide all other panels and elements
		welcomeCreatingPanel_Panel.hide();
		welcomeTestingPanel_Panel.hide();
		mainCreating_Panel_Panel.hide();
		mainTestingPanel_Panel.hide();

	}

	@SuppressWarnings("deprecation")
	private static void hideMainScreenAndShowExistTestWelcomePanel() {

		welcomeTestingPanel_Panel.show();
		welcomeTestingPanel_FirstStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));
		welcomeTestingPanel_SecondStepLabel_Label.setBorder(BorderFactory.createEmptyBorder());
		welcomeTestingPanel_ThirdStepLabel_Label.setBorder(BorderFactory.createEmptyBorder());
		welcomeTestingPanel_FromToPanel_Panel.setBorder(BorderFactory.createEmptyBorder());
		welcomeTestingPanel_ChoosedExamNameLabel_Label.setText("");
		welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_QuestionInModulLabel_Label.setText("");
		welcomeTestingPanel_QuestionInModulNumberLabel_Label.setText("");
		welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
		welcomeTestingPanel_QuestionToTextField_TextField.setText("");

		welcomeTestingPanel_STARTButton_Button.setEnabled(false);
		welcomeTestingPanel_STARTButton_Button.setVisible(true);

		mainScreenPanel_Panel.hide();
	}

	@SuppressWarnings("deprecation")
	private static void hideMainScreenAndShowCreateTestWelcomePanel() {
		mainScreenPanel_Panel.hide();
		welcomeCreatingPanel_Panel.show();

	}

	@SuppressWarnings("deprecation")
	private static void hideExistTestWelcomePanelAndShowTestingPanel() {
		welcomeTestingPanel_Panel.hide();

		mainTestingPanel_Panel.show();

		testingPanel_ShowAnswersPanel_Panel.setVisible(false);

		// buttons
		testingPanel_NextButton_Button.setVisible(true);
		testingPanel_NextButton_Button.setEnabled(true);
		testingPanel_BackButton_Button.setVisible(true);
		testingPanel_BackButton_Button.setEnabled(false);
		testingPanel_ShowImageButton_Button.setVisible(true);
		testingPanel_ShowImageButton_Button.setEnabled(false);
		testingPanel_ShowAnswersButton_Button.setVisible(true);
		testingPanel_ShowAnswersButton_Button.setEnabled(true);
		testingPanel_CurrentScoreButton_Button.setVisible(true);
		testingPanel_CurrentScoreButton_Button.setEnabled(true);
		testingPanel_ExitButton_Button.setVisible(true);
		testingPanel_ExitButton_Button.setEnabled(true);
		testingPanel_NewTestButton_Button.setVisible(true);
		testingPanel_NewTestButton_Button.setEnabled(true);
	}

	@SuppressWarnings("deprecation")
	private static void hideMainTestingPanelAndShowTestWelcomePanel() {
		welcomeTestingPanel_Panel.show();
		welcomeTestingPanel_FirstStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));
		welcomeTestingPanel_SecondStepLabel_Label.setBorder(BorderFactory.createEmptyBorder());
		welcomeTestingPanel_ThirdStepLabel_Label.setBorder(BorderFactory.createEmptyBorder());
		welcomeTestingPanel_FromToPanel_Panel.setBorder(BorderFactory.createEmptyBorder());
		welcomeTestingPanel_ChoosedExamNameLabel_Label.setText("");
		welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_QuestionInModulLabel_Label.setText("");
		welcomeTestingPanel_QuestionInModulNumberLabel_Label.setText("");
		welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);
		welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setSelected(false);
		welcomeTestingPanel_QuestionFromTextField_TextField.setText("");
		welcomeTestingPanel_QuestionToTextField_TextField.setText("");

		welcomeTestingPanel_STARTButton_Button.setEnabled(false);
		welcomeTestingPanel_STARTButton_Button.setVisible(true);

		mainTestingPanel_Panel.hide();
	}

	private static void checkFromToNumbersValid() {
		// IF All Question Selected
		if (welcomeTestingPanel_QuestionAllCheckBox_CheckBox.isSelected()) {
			welcomeTestingPanel_MessageFieldLabel_Label.setText("");
			qnumFirst = 1;
			qnumLast = ExistQuestionReader.questionNumberMaximum;
			System.out.println("All Question Selected between " + qnumFirst + " and " + qnumLast);
			testingPanel_QuestionSelectedFromNumber_Label.setText(String.valueOf(qnumFirst));
			testingPanel_QuestionSelectedToNumber_Label.setText(String.valueOf(qnumLast));
			checkNormalOrRandom();
		}

		// IF From & To Selected
		if (welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.isSelected() == true) {

			// IF FROM have text do ...
			if (welcomeTestingPanel_QuestionFromTextField_TextField.getText() != "") {

				welcomeTestingPanel_MessageFieldLabel_Label.setText("");
				System.out.println("questionFrom before parsing : "
						+ welcomeTestingPanel_QuestionFromTextField_TextField.getText());

				// TRY Statement - parsing the qFirstGet from
				// questionFrom.getText()
				try {
					qFirstGet = Integer.parseInt(welcomeTestingPanel_QuestionFromTextField_TextField.getText());
					System.out.println("questionFrom after parsing : " + qFirstGet);

					qLastGet = Integer.parseInt(welcomeTestingPanel_QuestionToTextField_TextField.getText());
					System.out.println("questionTo after parsing : " + qLastGet);

					// IF - qFirstGet validation == true
					if ((qFirstGet >= 1) && (qFirstGet < ExistQuestionReader.questionNumberMaximum - 1)
							&& (qFirstGet < qLastGet)) {
						qnumFirst = qFirstGet;
						testingPanel_QuestionSelectedFromNumber_Label.setText(String.valueOf(qnumFirst));

						System.out.println("questionFrom is " + qnumFirst + " after validation!");

						// IF TO have text do ...
						if (welcomeTestingPanel_QuestionToTextField_TextField.getText() != "") {

							welcomeTestingPanel_MessageFieldLabel_Label.setText("");
							System.out.println("questionTo before parsing : "
									+ welcomeTestingPanel_QuestionToTextField_TextField.getText());

							// TRY Statement - parsing the qFirstGet from
							// questionFrom.getText()
							try {
								qLastGet = Integer
										.parseInt(welcomeTestingPanel_QuestionToTextField_TextField.getText());
								System.out.println("questionTo after parsing : " + qLastGet);

								// IF - qLastGet validation == true
								if ((qLastGet >= qFirstGet + 1)
										&& (qLastGet <= ExistQuestionReader.questionNumberMaximum)) {
									qnumLast = qLastGet;
									testingPanel_QuestionSelectedToNumber_Label.setText(String.valueOf(qnumLast));

									System.out.println("questionTo is " + qnumLast + " after validation!");
									System.out.println("Call the checkNormalOrRandom() method!");
									checkNormalOrRandom();
								}
								// ELSE - qLastGet validation != true
								else {
									welcomeTestingPanel_MessageFieldLabel_Label.setText("Invalid number on TO Field.");

								}

							}
							// TRY Statement END (catch)
							catch (NumberFormatException ex) {
								welcomeTestingPanel_MessageFieldLabel_Label
										.setText("PARSING - The characters in 'To' field are not numbers!");

							}

						}
						// Else of TO FROM have text do ...
						else {
							welcomeTestingPanel_MessageFieldLabel_Label.setText("Question TO is invalid! - EMPTY");
							welcomeTestingPanel_QuestionToTextField_TextField.transferFocus();
						}

					}
					// ELSE - qFirstGet validation != true
					else {
						welcomeTestingPanel_MessageFieldLabel_Label.setText("Invalid number on FROM Field.");

					}

				}
				// TRY Statement END (catch)
				catch (NumberFormatException ex) {
					welcomeTestingPanel_MessageFieldLabel_Label
							.setText("PARSING - The characters in 'From' field are not numbers!");

				}

			}
			// Else of IF FROM have text do ...
			else {
				welcomeTestingPanel_MessageFieldLabel_Label.setText("Question FROM is invalid! - EMPTY");
				welcomeTestingPanel_QuestionFromTextField_TextField.transferFocus();
			}
			/*
			 * //and IF if(fromCheckString == "yes" && toCheckString== "yes"){
			 * btnSTART.setEnabled(true); welcomeMessageField.setText(
			 * "Questions From " + questionFrom.getText() + " To " +
			 * questionTo.getText()); checkNormalOrRandom(); }else{
			 * //welcomeMessageField.setText("INVALID NUMBERS SELECTED");
			 * btnSTART.setEnabled(false); }
			 */

			// END of IF From & To Selected
		}

	}

	@SuppressWarnings("deprecation")
	private static void checkNormalOrRandom() {

		if (welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.isSelected()
				&& !welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.isSelected()) {
			System.out.println("NORMAL SELECTED");
			sequenceLetter = "N";
			// design modification
			// hide welcome panel
			// welcomeForTestingPanel.hide();
			// hide Start button
			// welcomeTestingBtnSTART.hide();
			// call showDesign
			hideExistTestWelcomePanelAndShowTestingPanel();
			// create the Main Array

			// if(qnumFirst>=1 &&
			// qnumLast<=questionDataBank.questionNumberMaximum){
			createNormalArrays(qnumFirst, qnumLast);

			// !!! NEED
			new ExistQuestionReader(reversedArrayLastElement);

			testingPanel_QestionNumber_Label.setText(String.valueOf(reversedArrayLastElement));
			// }

		}
		if (!welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.isSelected()
				&& welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.isSelected()) {
			System.out.println("RANDOM SELECTED");
			sequenceLetter = "R";
			// design modification
			// hide welcome panel
			welcomeTestingPanel_Panel.hide();
			// hide Start button
			welcomeTestingPanel_STARTButton_Button.hide();
			// call showDesign
			hideExistTestWelcomePanelAndShowTestingPanel();
			// create Random Array
			// qnumFirst = Integer.parseInt(questionFrom.getText());
			// qnumLast = Integer.parseInt(questionTo.getText());
			createRandomArrays(qnumFirst, qnumLast);

			// !!!! NEED
			new ExistQuestionReader(shuffledArrayLastElement);

			testingPanel_QestionNumber_Label.setText(String.valueOf(shuffledArrayLastElement));
		}

	}

	// METHODS FOR NORMAL ARRAY
	public static void createNormalArrays(int min, int max) {
		/// ARRAYS
		// create an Integer array with number(no repeat) between 1 and 40
		int arraylength = (max + 1) - min;
		System.out.println("MainArray hossza: " + arraylength);

		mainArr = new int[arraylength];
		for (int i = 0; i < mainArr.length; i++) {
			// i+1 because 0 is'nt good for question number, so now first number
			// is 1 in the mainArray
			mainArr[i] = i + min;
		}

		// print out the arr array
		System.out.println("7 - Letrehozzuk a MainArray-t " + min + " es a " + max + " szammal : ");
		System.out.println(Arrays.toString(mainArr));
		doReverseArray();

	}

	public static void doReverseArray() {
		System.out.println(
				"8 - Meghivjuk a doReverseArray-t, ami megforditja az elemek sorrendjet (Collections.reverse) : ");
		// create a clone (new array) from the mainArray and this name is
		// reversedArray
		reversedArray = mainArr.clone();
		System.out.println("Reversed array a reverse elott: " + Arrays.toString(reversedArray));
		// create a Collection which shuffle the arr array elements
		for (int i = 0; i < reversedArray.length / 2; i++) {
			int temp = reversedArray[i];
			reversedArray[i] = reversedArray[reversedArray.length - i - 1];
			reversedArray[reversedArray.length - i - 1] = temp;
		}

		Collections.reverse(Arrays.asList(reversedArray));

		System.out.println("Reversed array a reverse utan: " + Arrays.toString(reversedArray));

		reversedArrayLastElement = reversedArray[reversedArray.length - 1];

		System.out.println("REVERSED ARRAY LAST ELEMENT: " + reversedArrayLastElement);

	}

	// METHODS FOR RANDOM ARRAY
	public static void createRandomArrays(int min, int max) {
		/// ARRAYS
		// create an array with 40 random number(no repeat) between 1 and 40
		int arraylength = (max + 1) - min;

		System.out.println("RandomArray hossza: " + arraylength);
		randomArr = new int[arraylength];
		for (int i = 0; i < randomArr.length; i++) {
			// i+1 because 0 is'nt good for question number, so now first number
			// is 1 in the mainArray
			randomArr[i] = i + min;
		}
		System.out.println("7 - Letrehozzuk a RandomArray-t " + min + " es a " + max + " szammal : ");
		System.out.println(Arrays.toString(randomArr));
		doShuffleArray();

	}

	public static void doShuffleArray() {
		System.out.println(
				"8 - Meghivjuk a doShuffleArray-t, ami osszekeveri az elemek sorrendjet (Implementing Fisher–Yates shuffle) : ");
		// create a clone (new array) from the mainArray and this name is
		// shuffledArray
		shuffledArray = randomArr.clone();
		System.out.println("Shuffled array shuffle elott :" + Arrays.toString(shuffledArray));
		// Implementing Fisher–Yates shuffle !!
		// thx :
		// http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
		Random rnd = ThreadLocalRandom.current();
		for (int i = shuffledArray.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = shuffledArray[index];
			shuffledArray[index] = shuffledArray[i];
			shuffledArray[i] = a;
		}

		System.out.println("Shuffled array shuffle utan :" + Arrays.toString(shuffledArray));

		shuffledArrayLastElement = shuffledArray[shuffledArray.length - 1];
		System.out.println("SHUFFLED ARRAY LAST ELEMENT :" + shuffledArrayLastElement);
	}

	public static void deleteLastELement(String str) {

		try {

			// if normal array
			if (str == "N") {
				// System.out.println("NEXT 2 - Ha a String = N");
				if (reversedArray.length >= 1 && reversedArray.length != allAnswered) {
					// System.out.println("NEXT 3 - Ha a megforditott array
					// hossza nagyobb mint 1, akkor...");

					// before delete an element we add that to the rebuildarray
					// too
					rebuildArray = Arrays.copyOf(reversedArray, reversedArray.length);
					// System.out.println("NEXT 4 - Letrehozunk egy uj array-t
					// (rebuildArray), amiben ugyanazok az elemek vannak, es a
					// hossza is ugyanakkora!");
					// System.out.println("Rebuilded array: " +
					// Arrays.toString(rebuildArray));

					// delete the last element from the array (shuffledArray)
					reversedArray = Arrays.copyOf(reversedArray, reversedArray.length - 1);
					// System.out.println("NEXT 5 - Majd kitoroljuk az utolso
					// elemet az eredeti megforditott array-bol.");
					System.out.println("Changed Reversed array: " + Arrays.toString(reversedArray));

					// System.out.println("UJ ARRAY" +
					// Arrays.toString(shuffledArray));
					number = reversedArray[reversedArray.length - 1];
				}

			}

			// if random array
			else if (str == "R") {
				// System.out.println("NEXT 2 - Ha a String = R");
				if (shuffledArray.length >= 1) {
					System.out.println("NEXT 3 - Ha az osszekevert array hossza nagyobb mint 1, akkor...");

					// before delete an element we add that to the rebuildarray
					// too
					rebuildArray = Arrays.copyOf(shuffledArray, shuffledArray.length);
					// System.out.println("Rebuilded array: " +
					// Arrays.toString(rebuildArray));

					// delete the last element from the array (shuffledArray)
					shuffledArray = Arrays.copyOf(shuffledArray, shuffledArray.length - 1);
					System.out.println("UJ ARRAY" + Arrays.toString(shuffledArray));

					number = shuffledArray[shuffledArray.length - 1];
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			testingPanel_AnyErrorMessageField_Label.setVisible(true);
			testingPanel_AnyErrorMessageField_Label.setText("No more question in the current test.");

			testingPanel_CurrentScoreButton_Button.doClick();

			testingPanel_CurrentScoreButton_Button.setEnabled(false);
			testingPanel_NextButton_Button.setEnabled(false);
			testingPanel_BackButton_Button.setEnabled(false);
			testingPanel_ShowAnswersButton_Button.setEnabled(false);
			testingPanel_ShowImageButton_Button.setEnabled(false);

		}
	}

	public static void rebuildBackButtonArray(String str) {
		System.out.println("2 - Meghivjuk a rebuildArray method-ot!");
		try {
			if (rebuildArray.length >= 1) {

				number = rebuildArray[rebuildArray.length - 1];

				if (str == "N") {
					System.out.println("Number after BACK : " + number);
					reversedArray = Arrays.copyOf(reversedArray, reversedArray.length + 1);
					reversedArray[reversedArray.length - 1] = number;
				}
				if (str == "R") {
					System.out.println("Number after BACK : " + number);
					shuffledArray = Arrays.copyOf(shuffledArray, shuffledArray.length + 1);
					shuffledArray[shuffledArray.length - 1] = number;
				}

			}

		} catch (ArrayIndexOutOfBoundsException e) {
			testingPanel_CorrectAnswersMessageField_Label.setText("NO MORE");
			testingPanel_CurrentScoreButton_Button.setEnabled(true);

		}

	}

	// CHECK CHECKBOX
	public static boolean checkCheckBox() {
		if ((testingPanel_AnswerACheckBox_CheckBox.isSelected() == true)
				|| (testingPanel_AnswerBCheckBox_CheckBox.isSelected() == true)
				|| (testingPanel_AnswerCCheckBox_CheckBox.isSelected() == true)
				|| (testingPanel_AnswerDCheckBox_CheckBox.isSelected() == true)
				|| (testingPanel_AnswerECheckBox_CheckBox.isSelected() == true)) {
			return true;
		} else {
			return false;
		}
	}

	// CLEAR CHECKBOX
	public static void clearCheckBox() {
		testingPanel_AnswerACheckBox_CheckBox.setSelected(false);
		testingPanel_AnswerBCheckBox_CheckBox.setSelected(false);
		testingPanel_AnswerCCheckBox_CheckBox.setSelected(false);
		testingPanel_AnswerDCheckBox_CheckBox.setSelected(false);
		testingPanel_AnswerECheckBox_CheckBox.setSelected(false);
	}

	public static void checkAnswer() {

		if (testingPanel_AnswerACheckBox_CheckBox.isSelected() == true) {
			answerA = "A,";
		} else {
			answerA = "";
		}

		if (testingPanel_AnswerBCheckBox_CheckBox.isSelected() == true) {
			answerB = "B,";
		} else {
			answerB = "";
		}

		if (testingPanel_AnswerCCheckBox_CheckBox.isSelected() == true) {
			answerC = "C,";
		} else {
			answerC = "";
		}

		if (testingPanel_AnswerDCheckBox_CheckBox.isSelected() == true) {
			answerD = "D,";
		} else {
			answerD = "";
		}

		if (testingPanel_AnswerECheckBox_CheckBox.isSelected() == true) {
			answerE = "E";
		} else {
			answerE = "";
		}

		String answersToString = answerA + answerB + answerC + answerD + answerE;
		// System.out.println("ValaszString: " + answersToString);

		if (answersToString.contains(",")) {
			answerArray = answersToString.split(",");
			// System.out.println("Tobb valasz van kijelolve: " +
			// Arrays.toString(answerArray));
		} else {
			answerArray = new String[1];
			answerArray[0] = answersToString;
			// System.out.println("Egy valasz van kijelolve: " +
			// Arrays.toString(answerArray));
		}

		System.out.println("A kivalasztott valasz(ok): " + Arrays.toString(answerArray));
		System.out.println("Helyes valasz(ok): " + Arrays.toString(ExistQuestionReader.answerLettersArray));

		scoreCalculation();
	}

	// Score Calculation + save wrong answered questions - METHOD
	public static void scoreCalculation() {

		System.out.println("PressedBack = " + scoreAddOrNO);

		if (scoreAddOrNO == "ADD") {
			// ha a ket valasz array egyforma (questionDataBank, es a jelenlegi
			// kivalasztott valasz-array)
			if (Arrays.equals(ExistQuestionReader.answerLettersArray, answerArray)) {
				System.out.println("HELYES valasz!");
				// System.out.println(Arrays.toString(questionDataBank.answerLettersArray));
				// System.out.println(Arrays.toString(answerArray));
				goodAsweredNumber = goodAsweredNumber + 1;
				System.out.println("Helyes valaszok szama: " + goodAsweredNumber);
			} else {
				System.out.println("PressedBack = " + scoreAddOrNO);
				System.out.println("HELYTELEN valasz!");
				wrongAnswerNumber = wrongAnswerNumber + 1;
				addElementToWrongAnswerArray();
			}
		}

	}

	public static void addElementToWrongAnswerArray() {
		// wrongNumbersString = questionNumberLabel Label text (it's a number)
		wrongNumbersString = testingPanel_QestionNumber_Label.getText();
		// wrongNumbersInteger = parsed wrongNumbersString
		wrongNumbersInteger = Integer.parseInt((wrongNumbersString));

		wrongQuestionsListArray.add(wrongNumbersInteger);

		wrongAnswersStringList = new ArrayList<String>(wrongQuestionsListArray.size());

		for (Integer myInt : wrongQuestionsListArray) {
			wrongAnswersStringList.add(String.valueOf(myInt));
		}
		Collections.sort(wrongQuestionsListArray);
		Collections.sort(wrongAnswersStringList);

		System.out.println(wrongAnswersStringList);
		ActualScore.wrongAnswersTextArea.setText(wrongAnswersStringList.toString());
		System.out.println(wrongQuestionsListArray);
	}

	// Initialize the contents of the frame.
	public void initialize() {

		// ******************
		// *** Main Frame ***
		// ******************
		mainFrame_Frame = new JFrame();
		mainFrame_Frame.setTitle("Exam Tester/Creater Application");
		mainFrame_Frame.setResizable(false);
		mainFrame_Frame.getContentPane().setBackground(new Color(153, 255, 255));
		mainFrame_Frame.setBounds(100, 100, 800, 670);
		mainFrame_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame_Frame.getContentPane().setLayout(null);
		mainFrame_Frame.setLocationRelativeTo(null);
				
						// *****************************
						// *** Welcome Testing Panel ***
						// *****************************
						welcomeTestingPanel_Panel.setBounds(37, 45, 720, 550);
						welcomeTestingPanel_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
						welcomeTestingPanel_Panel.setBackground(new Color(245, 255, 250));
						welcomeTestingPanel_Panel.setLayout(null);
						mainFrame_Frame.getContentPane().add(welcomeTestingPanel_Panel);
						
								welcomeTestingPanel_TextArea_TextArea.setBackground(SystemColor.inactiveCaptionBorder);
								welcomeTestingPanel_TextArea_TextArea.setLineWrap(true);
								welcomeTestingPanel_TextArea_TextArea.setEditable(false);
								welcomeTestingPanel_TextArea_TextArea.setFont(new Font("Tahoma", Font.BOLD, 19));
								welcomeTestingPanel_TextArea_TextArea.setBounds(235, 10, 250, 31);
								welcomeTestingPanel_Panel.add(welcomeTestingPanel_TextArea_TextArea);
								
										welcomeTestingPanel_NormalOrRandomPanel_Panel.setBackground(new Color(245, 255, 250));
										welcomeTestingPanel_NormalOrRandomPanel_Panel.setBounds(280, 187, 160, 55);
										welcomeTestingPanel_NormalOrRandomPanel_Panel.setBorder(BorderFactory.createEmptyBorder());
										welcomeTestingPanel_NormalOrRandomPanel_Panel.setLayout(null);
										welcomeTestingPanel_Panel.add(welcomeTestingPanel_NormalOrRandomPanel_Panel);
										
												welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setBounds(0, 0, 160, 25);
												welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
												welcomeTestingPanel_NormalSequenceCheckBox_CheckBox.setEnabled(false);
												welcomeTestingPanel_NormalSequenceCheckBox_CheckBox
														.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
												welcomeTestingPanel_NormalSequenceCheckBox_CheckBox
														.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
												welcomeTestingPanel_NormalOrRandomPanel_Panel.add(welcomeTestingPanel_NormalSequenceCheckBox_CheckBox);
												
														welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setBounds(0, 30, 160, 25);
														welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
														welcomeTestingPanel_RandomSequenceCheckBox_CheckBox.setEnabled(false);
														welcomeTestingPanel_RandomSequenceCheckBox_CheckBox
																.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
														welcomeTestingPanel_RandomSequenceCheckBox_CheckBox
																.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
														welcomeTestingPanel_NormalOrRandomPanel_Panel.add(welcomeTestingPanel_RandomSequenceCheckBox_CheckBox);
														welcomeTestingPanel_FirstStepLabel_Label.setBackground(new Color(245, 255, 250));
														
																welcomeTestingPanel_FirstStepLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
																welcomeTestingPanel_FirstStepLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
																welcomeTestingPanel_FirstStepLabel_Label.setBounds(160, 52, 400, 25);
																welcomeTestingPanel_FirstStepLabel_Label.setBorder(new LineBorder(Color.RED, 2, true));
																welcomeTestingPanel_Panel.add(welcomeTestingPanel_FirstStepLabel_Label);
																welcomeTestingPanel_SecondStepLabel_Label.setBackground(new Color(245, 255, 250));
																
																		welcomeTestingPanel_SecondStepLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
																		welcomeTestingPanel_SecondStepLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
																		welcomeTestingPanel_SecondStepLabel_Label.setBorder(null);
																		welcomeTestingPanel_SecondStepLabel_Label.setText("2nd Step - Choose the questions sequence!");
																		welcomeTestingPanel_SecondStepLabel_Label.setBounds(160, 157, 400, 25);
																		welcomeTestingPanel_Panel.add(welcomeTestingPanel_SecondStepLabel_Label);
																		
																				welcomeTestingPanel_OpenExamButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
																				welcomeTestingPanel_OpenExamButton_Button.setBounds(285, 87, 150, 25);
																				welcomeTestingPanel_OpenExamButton_Button.setBorder(new BevelBorder(BevelBorder.RAISED,
																						UIManager.getColor("CheckBoxMenuItem.selectionBackground"), null, null, null));
																				welcomeTestingPanel_Panel.add(welcomeTestingPanel_OpenExamButton_Button);
																				welcomeTestingPanel_ChoosedExamNameLabel_Label.setBackground(new Color(245, 255, 250));
																				
																						welcomeTestingPanel_ChoosedExamNameLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
																						welcomeTestingPanel_ChoosedExamNameLabel_Label.setFont(new Font("Monospaced", Font.PLAIN, 13));
																						welcomeTestingPanel_ChoosedExamNameLabel_Label.setBounds(160, 127, 400, 25);
																						welcomeTestingPanel_Panel.add(welcomeTestingPanel_ChoosedExamNameLabel_Label);
																						
																								welcomeTestingPanel_QuestionInModulePanel_Panel.setBackground(new Color(245, 255, 250));
																								welcomeTestingPanel_QuestionInModulePanel_Panel.setBounds(271, 252, 177, 25);
																								welcomeTestingPanel_QuestionInModulePanel_Panel.setBorder(BorderFactory.createEmptyBorder());
																								welcomeTestingPanel_QuestionInModulePanel_Panel.setLayout(null);
																								welcomeTestingPanel_Panel.add(welcomeTestingPanel_QuestionInModulePanel_Panel);
																								welcomeTestingPanel_QuestionInModulLabel_Label.setBackground(new Color(245, 255, 250));
																								
																										welcomeTestingPanel_QuestionInModulLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
																										welcomeTestingPanel_QuestionInModulLabel_Label.setBounds(0, 0, 150, 25);
																										welcomeTestingPanel_QuestionInModulePanel_Panel.add(welcomeTestingPanel_QuestionInModulLabel_Label);
																										welcomeTestingPanel_QuestionInModulNumberLabel_Label.setBackground(new Color(245, 255, 250));
																										
																												welcomeTestingPanel_QuestionInModulNumberLabel_Label.setBounds(152, 0, 25, 25);
																												welcomeTestingPanel_QuestionInModulNumberLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 13));
																												welcomeTestingPanel_QuestionInModulePanel_Panel.add(welcomeTestingPanel_QuestionInModulNumberLabel_Label);
																												welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel.setBackground(new Color(245, 255, 250));
																												
																														welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel.setBounds(280, 312, 160, 55);
																														welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel.setBorder(BorderFactory.createEmptyBorder());
																														welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel.setLayout(null);
																														welcomeTestingPanel_Panel.add(welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel);
																														
																																welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
																																welcomeTestingPanel_QuestionAllCheckBox_CheckBox
																																		.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
																																welcomeTestingPanel_QuestionAllCheckBox_CheckBox
																																		.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
																																welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setEnabled(false);
																																welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);
																																welcomeTestingPanel_QuestionAllCheckBox_CheckBox.setBounds(0, 0, 160, 25);
																																welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel.add(welcomeTestingPanel_QuestionAllCheckBox_CheckBox);
																																
																																		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setBounds(0, 30, 160, 25);
																																		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
																																		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox
																																				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
																																		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox
																																				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
																																		welcomeTestingPanel_QuestionFromToCheckBox_CheckBox.setEnabled(false);
																																		welcomeTestingPanel_AllOrSelectedQuestionPanel_Panel.add(welcomeTestingPanel_QuestionFromToCheckBox_CheckBox);
																																		
																																				welcomeTestingPanel_FromToPanel_Panel.setBackground(new Color(245, 255, 250));
																																				welcomeTestingPanel_FromToPanel_Panel.setBorder(new EmptyBorder(0, 0, 0, 0));
																																				welcomeTestingPanel_FromToPanel_Panel.setBounds(260, 372, 200, 50);
																																				welcomeTestingPanel_FromToPanel_Panel.setLayout(null);
																																				welcomeTestingPanel_Panel.add(welcomeTestingPanel_FromToPanel_Panel);
																																				
																																						welcomeTestingPanel_FromLabel_Label.setBounds(10, 11, 40, 25);
																																						welcomeTestingPanel_FromLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
																																						welcomeTestingPanel_FromToPanel_Panel.add(welcomeTestingPanel_FromLabel_Label);
																																						
																																								welcomeTestingPanel_ToLabel_Label.setBounds(110, 11, 25, 25);
																																								welcomeTestingPanel_ToLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
																																								welcomeTestingPanel_FromToPanel_Panel.add(welcomeTestingPanel_ToLabel_Label);
																																								
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setBounds(55, 11, 50, 25);
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setBorder(BorderFactory.createEmptyBorder());
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setEnabled(false);
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setColumns(10);
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setHorizontalAlignment(SwingConstants.CENTER);
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setFont(new Font("Tahoma", Font.BOLD, 12));
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setForeground(SystemColor.activeCaptionText);
																																										welcomeTestingPanel_QuestionFromTextField_TextField.setBackground(SystemColor.inactiveCaption);
																																										welcomeTestingPanel_FromToPanel_Panel.add(welcomeTestingPanel_QuestionFromTextField_TextField);
																																										
																																												welcomeTestingPanel_QuestionToTextField_TextField.setHorizontalAlignment(SwingConstants.CENTER);
																																												welcomeTestingPanel_QuestionToTextField_TextField.setFont(new Font("Tahoma", Font.BOLD, 12));
																																												welcomeTestingPanel_QuestionToTextField_TextField.setForeground(SystemColor.activeCaptionText);
																																												welcomeTestingPanel_QuestionToTextField_TextField.setBackground(SystemColor.inactiveCaption);
																																												welcomeTestingPanel_QuestionToTextField_TextField.setBounds(140, 11, 50, 25);
																																												welcomeTestingPanel_QuestionToTextField_TextField.setBorder(BorderFactory.createEmptyBorder());
																																												welcomeTestingPanel_QuestionToTextField_TextField.setEnabled(false);
																																												welcomeTestingPanel_QuestionToTextField_TextField.setColumns(10);
																																												welcomeTestingPanel_FromToPanel_Panel.add(welcomeTestingPanel_QuestionToTextField_TextField);
																																												
																																														welcomeTestingPanel_ThirdStepLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
																																														welcomeTestingPanel_ThirdStepLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
																																														welcomeTestingPanel_ThirdStepLabel_Label.setBounds(110, 282, 500, 25);
																																														welcomeTestingPanel_Panel.add(welcomeTestingPanel_ThirdStepLabel_Label);
																																														welcomeTestingPanel_MessageFieldLabel_Label.setBackground(new Color(245, 255, 250));
																																														
																																																welcomeTestingPanel_MessageFieldLabel_Label.setForeground(Color.RED);
																																																welcomeTestingPanel_MessageFieldLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
																																																welcomeTestingPanel_MessageFieldLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 15));
																																																welcomeTestingPanel_MessageFieldLabel_Label.setBounds(160, 422, 400, 25);
																																																welcomeTestingPanel_Panel.add(welcomeTestingPanel_MessageFieldLabel_Label);
																																																
																																																		welcomeTestingPanel_STARTButton_Button.setEnabled(false);
																																																		welcomeTestingPanel_STARTButton_Button.setBounds(285, 452, 150, 25);
																																																		welcomeTestingPanel_STARTButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
																																																		welcomeTestingPanel_STARTButton_Button
																																																				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 255), null, null, null));
																																																		welcomeTestingPanel_Panel.add(welcomeTestingPanel_STARTButton_Button);
																																																		
																																																				welcomeTestingPanel_BackToMainScreenButton_Button.setBounds(272, 500, 175, 25);
																																																				welcomeTestingPanel_Panel.add(welcomeTestingPanel_BackToMainScreenButton_Button);
		
				// *************************
				// *** Main Screen Panel ***
				// *************************
				mainScreenPanel_Panel.setBorder(new LineBorder(new Color(224, 255, 255), 1, true));
				mainScreenPanel_Panel.setBackground(new Color(224, 255, 255));
				mainScreenPanel_Panel.setBounds(0, 0, 794, 641);
				mainScreenPanel_Panel.setLayout(null);
				mainFrame_Frame.getContentPane().add(mainScreenPanel_Panel);
				
						mainscreenAppNameLabel_Label.setBounds(306, 1, 168, 27);
						mainscreenAppNameLabel_Label.setFont(new Font("Monospaced", Font.BOLD, 20));
						mainscreenAppNameLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
						mainScreenPanel_Panel.add(mainscreenAppNameLabel_Label);
						
								mainscreenCreatedByLabel_Label.setBounds(616, 13, 131, 11);
								mainscreenCreatedByLabel_Label.setVerticalAlignment(SwingConstants.TOP);
								mainscreenCreatedByLabel_Label.setHorizontalAlignment(SwingConstants.RIGHT);
								mainscreenCreatedByLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 9));
								mainScreenPanel_Panel.add(mainscreenCreatedByLabel_Label);
								
										mainscreenCreateQuiz_Button.setBounds(317, 207, 146, 23);
										mainScreenPanel_Panel.add(mainscreenCreateQuiz_Button);
										
												mainscreenExistQuizTest_Button.setBounds(317, 284, 146, 23);
												mainScreenPanel_Panel.add(mainscreenExistQuizTest_Button);
												
														mainscreenLanguageSelection_ComboBox.addItem("English");
														mainscreenLanguageSelection_ComboBox.addItem("Hungarian");
														mainscreenLanguageSelection_ComboBox.setBounds(600, 76, 131, 20);
														mainScreenPanel_Panel.add(mainscreenLanguageSelection_ComboBox);
														
																mainscreenLaguageSelection_Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
																mainscreenLaguageSelection_Label.setHorizontalAlignment(SwingConstants.RIGHT);
																mainscreenLaguageSelection_Label.setBounds(600, 51, 131, 25);
																mainScreenPanel_Panel.add(mainscreenLaguageSelection_Label);

		createNewQuizPanel_Panel.setBackground(new Color(245, 255, 250));
		createNewQuizPanel_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		createNewQuizPanel_Panel.setBounds(37, 35, 720, 570);
		createNewQuizPanel_Panel.setLayout(null);
		mainFrame_Frame.getContentPane().add(createNewQuizPanel_Panel);

		createNewQuiz_QuestionPanel_Panel.setBackground(new Color(245, 255, 250));
		createNewQuiz_QuestionPanel_Panel.setBounds(20, 15, 690, 135);

		createNewQuizPanel_Panel.add(createNewQuiz_QuestionPanel_Panel);
		createNewQuiz_QuestionPanel_Panel.setLayout(null);
		createNewQuiz_QuestionsLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);

		createNewQuiz_QuestionsLabel_Label.setBounds(0, 0, 120, 25);
		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_QuestionsLabel_Label);
		createNewQuiz_QuestionsLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		createNewQuiz_NameOfTheFileLavel_Label.setBounds(195, 0, 280, 25);
		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_NameOfTheFileLavel_Label);
		createNewQuiz_NameOfTheFileLavel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		createNewQuiz_NameOfTheFileLavel_Label.setFont(new Font("Tahoma", Font.BOLD, 13));

		// next few line if we want 2 line in a Jbutton :
		// http://www.javaworld.com/article/2077368/learn-java/a-multiline-button-is-possible.html
		// createNewQuiz_AddQuestionButton_Button.setLayout(new BorderLayout());
		// questionBtnText1.setFont(new Font("Tahoma", Font.BOLD, 12));
		// questionBtnText1.setHorizontalAlignment(SwingConstants.CENTER);
		// createNewQuiz_AddQuestionButton_Button.add(BorderLayout.NORTH,questionBtnText1);
		// questionBtnText2.setFont(new Font("Tahoma", Font.BOLD, 12));
		// questionBtnText2.setHorizontalAlignment(SwingConstants.CENTER);
		// createNewQuiz_AddQuestionButton_Button.add(BorderLayout.SOUTH,questionBtnText2)

		createNewQuiz_AddQuestionButton_Button.setBorder(thickRedBorder);
		createNewQuiz_AddQuestionButton_Button.setBounds(0, 25, 120, 35);
		createNewQuiz_AddQuestionButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		createNewQuiz_AddQuestionButton_Button.setToolTipText("Add a new Question, use right format!");
		createNewQuiz_AddQuestionButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.getText().equals("")) {
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.requestFocus();
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setEnabled(true);
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setText("");
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setBorder(thickRedBorder);
					// change button border to factory default
					createNewQuiz_AddQuestionButton_Button.setBorder(defaultBorder);
					createNewQuiz_AddQuestionButton_Button.setEnabled(false);

				} else {
				}

			}
		});

		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_AddQuestionButton_Button);

		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setWrapStyleWord(true);
		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setLineWrap(true);
		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setText("Field of the question(s)...");
		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setMargin(new Insets(10, 10, 10, 10));
		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setEnabled(false);

		// KEY - LISTENER - QUESTION
		// http://stackoverflow.com/questions/10876491/how-to-use-keylistener
		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				int key = e.getKeyChar();
				// when delete question text with backspace
				if (key == KeyEvent.VK_BACK_SPACE) {

					System.out.println("BACKSPACE");

					if (createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.getText().equals("")) {

						createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setEnabled(false);
						createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setBorder(defaultBorder);

						createNewQuiz_AddQuestionButton_Button.setBorder(thickRedBorder);
						createNewQuiz_AddQuestionButton_Button.setEnabled(true);

						createNewQuiz_AddAnImageButton_Button.setEnabled(false);
						createNewQuiz_AddAnImageButton_Button.setBorder(defaultBorder);
						createNewQuiz_NoImageButton_Button.setEnabled(false);
						createNewQuiz_NoImageButton_Button.setBorder(defaultBorder);

						createNewQuiz_imageLabelQ.setIcon(imgNo);

						// MINDEN EGYEB ELEMET TILTANI KELL HA TORLI A KERDEST
						CreateNewQuestionClass.changeTxtAreaAndButtonSelectionToDefault(
								createNewQuiz_AddAnswerATextArea_TextArea, createNewQuiz_AddAnswerAButton_Button);
						CreateNewQuestionClass.changeTxtAreaAndButtonSelectionToDefault(
								createNewQuiz_AddAnswerBTextArea_TextArea, createNewQuiz_AddAnswerBButton_Button);
						CreateNewQuestionClass.changeTxtAreaAndButtonSelectionToDefault(
								createNewQuiz_AddAnswerCTextArea_TextArea, createNewQuiz_AddAnswerCButton_Button);
						CreateNewQuestionClass.changeTxtAreaAndButtonSelectionToDefault(
								createNewQuiz_AddAnswerDTextArea_TextArea, createNewQuiz_AddAnswerDButton_Button);
						CreateNewQuestionClass.changeTxtAreaAndButtonSelectionToDefault(
								createNewQuiz_AddAnswerETextArea_TextArea, createNewQuiz_AddAnswerEButton_Button);

						createNewQuiz_imageLabelImg.setIcon(imgNo);
						createNewQuiz_imageLabelA.setIcon(imgNo);
						createNewQuiz_imageLabelB.setIcon(imgNo);
						createNewQuiz_imageLabelC.setIcon(imgNo);
						createNewQuiz_imageLabelD.setIcon(imgNo);
						createNewQuiz_imageLabelE.setIcon(imgNo);
						
						CreateNewQuestionClass.minimumAnswerAdded();

					}
				}

				else {
					createNewQuiz_AddAnImageButton_Button.setEnabled(true);
					createNewQuiz_AddAnImageButton_Button.setBorder(thickRedBorder);
					createNewQuiz_NoImageButton_Button.setEnabled(true);
					createNewQuiz_NoImageButton_Button.setBorder(thickRedBorder);
				}

			}
		});

		// FOCUS - LISTENER - QUESTION
		createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				// if the textfield not equal with a simple " " (space) or
				// nothing ""
				String questionStr = createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.getText();
				String questionStrNoSpace = questionStr.replaceAll(" ", "");

				if (questionStrNoSpace.length() > 0) {
					createNewQuiz_imageLabelQ.setIcon(imgYes);
				} else {

					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setText("Field of the question(s)...");

					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setEnabled(false);
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setBorder(defaultBorder);

					createNewQuiz_AddQuestionButton_Button.setBorder(thickRedBorder);
					createNewQuiz_AddQuestionButton_Button.setEnabled(true);

					createNewQuiz_AddAnImageButton_Button.setEnabled(false);
					createNewQuiz_AddAnImageButton_Button.setBorder(defaultBorder);
					createNewQuiz_NoImageButton_Button.setEnabled(false);
					createNewQuiz_NoImageButton_Button.setBorder(defaultBorder);

					createNewQuiz_imageLabelQ.setIcon(imgNo);

					CreateNewQuestionClass.changeForAnswersField(createNewQuiz_AddAnswerAButton_Button,
							createNewQuiz_AddAnswerATextArea_TextArea);
					CreateNewQuestionClass.changeForAnswersField(createNewQuiz_AddAnswerBButton_Button,
							createNewQuiz_AddAnswerBTextArea_TextArea);
					CreateNewQuestionClass.changeForAnswersField(createNewQuiz_AddAnswerCButton_Button,
							createNewQuiz_AddAnswerCTextArea_TextArea);
					CreateNewQuestionClass.changeForAnswersField(createNewQuiz_AddAnswerDButton_Button,
							createNewQuiz_AddAnswerDTextArea_TextArea);
					CreateNewQuestionClass.changeForAnswersField(createNewQuiz_AddAnswerEButton_Button,
							createNewQuiz_AddAnswerETextArea_TextArea);

					createNewQuiz_imageLabelA.setIcon(imgNo);
					createNewQuiz_imageLabelB.setIcon(imgNo);
					createNewQuiz_imageLabelC.setIcon(imgNo);
					createNewQuiz_imageLabelD.setIcon(imgNo);
					createNewQuiz_imageLabelE.setIcon(imgNo);
				}
			}
		});

		createNewQuiz_AddNewQuestionsScrollPane_ScrollPane.setBounds(125, 25, 500, 70);
		createNewQuiz_AddNewQuestionsScrollPane_ScrollPane
				.setViewportView(createNewQuiz_AddNewQuestionsTeaxtArea_TextArea);
		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_AddNewQuestionsScrollPane_ScrollPane);

		//

		createNewQuiz_imageLabelQ.setBounds(640, 25, 35, 35);
		createNewQuiz_imageLabelQ.setBackground(new Color(245, 255, 250));
		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_imageLabelQ);

		createNewQuiz_AddAnImageButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// pop-up window for image choose
				// have to validate the question Field in a method!!!!

				// --- if the textfield not equal with a simple " " (space) or
				// with nothing ""
				String questionStr = createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.getText();
				String questionStrNoSpace = questionStr.replaceAll(" ", "");

				if (questionStrNoSpace.length() > 0) {
					createNewQuiz_imageLabelImg.setIcon(imgYes);
					createNewQuiz_AddAnswerAButton_Button.setEnabled(true);
					createNewQuiz_AddAnswerAButton_Button.setBorder(thickRedBorder);
					createNewQuiz_AddAnImageButton_Button.setBorder(thickBlueBorder);
					createNewQuiz_NoImageButton_Button.setBorder(defaultBorder);
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setBorder(thickBlueBorder);
				} else {
					createNewQuiz_imageLabelImg.setIcon(imgNo);
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setText("");
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.requestFocus();
				}

			}
		});
		createNewQuiz_AddAnImageButton_Button.setEnabled(false);
		createNewQuiz_AddAnImageButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		createNewQuiz_AddAnImageButton_Button.setBounds(125, 100, 120, 35);
		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_AddAnImageButton_Button);

		createNewQuiz_NoImageButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// delete any choosed image
				// have to validate the question Field in a method!!!!

				// --- if the textfield not equal with a simple " " (space) or
				// with nothing ""
				String questionStr = createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.getText();
				String questionStrNoSpace = questionStr.replaceAll(" ", "");

				if (questionStrNoSpace.length() > 0) {
					createNewQuiz_imageLabelImg.setIcon(imgYes);
					createNewQuiz_AddAnswerAButton_Button.setEnabled(true);
					createNewQuiz_AddAnswerAButton_Button.setBorder(thickRedBorder);
					createNewQuiz_AddAnImageButton_Button.setBorder(defaultBorder);
					createNewQuiz_NoImageButton_Button.setBorder(thickBlueBorder);
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setBorder(thickBlueBorder);
				} else {
					createNewQuiz_imageLabelImg.setIcon(imgNo);
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.setText("");
					createNewQuiz_AddNewQuestionsTeaxtArea_TextArea.requestFocus();
				}
			}
		});
		createNewQuiz_NoImageButton_Button.setEnabled(false);
		createNewQuiz_NoImageButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		createNewQuiz_NoImageButton_Button.setBounds(255, 100, 120, 35);
		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_NoImageButton_Button);
		createNewQuiz_imageLabelImg.setBackground(new Color(245, 255, 250));
		createNewQuiz_imageLabelImg.setBounds(640, 100, 35, 35);

		createNewQuiz_QuestionPanel_Panel.add(createNewQuiz_imageLabelImg);

		createNewQuiz_AnswersPanel_Panel.setBackground(new Color(245, 255, 250));
		createNewQuiz_AnswersPanel_Panel.setBounds(20, 150, 690, 225);

		createNewQuizPanel_Panel.add(createNewQuiz_AnswersPanel_Panel);
		createNewQuiz_AnswersPanel_Panel.setLayout(null);
		createNewQuiz_AnswersLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		createNewQuiz_AnswersLabel_Label.setBounds(0, 0, 120, 25);
		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AnswersLabel_Label);
		createNewQuiz_AnswersLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 15));

		// Answer A Button Action
		createNewQuiz_AddAnswerAButton_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				CreateNewQuestionClass.checkAnswerButtonActionWithTextArea(createNewQuiz_AddAnswerAButton_Button, createNewQuiz_AddAnswerBButton_Button, createNewQuiz_AddAnswerATextArea_TextArea,createNewQuiz_imageLabelA);
				
				
			}
		});
		createNewQuiz_AddAnswerAButton_Button.setEnabled(false);
		createNewQuiz_AddAnswerAButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		createNewQuiz_AddAnswerAButton_Button.setBounds(0, 26, 120, 35);
		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerAButton_Button);

		// FOCUS - LOST - ANSWER 'A' TEXTFIELD
		createNewQuiz_AddAnswerATextArea_TextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				CreateNewQuestionClass.checkAnswerFieldFocusLost(createNewQuiz_AddAnswerATextArea_TextArea,
						createNewQuiz_AddAnswerAButton_Button, createNewQuiz_imageLabelA);

				CreateNewQuestionClass.minimumAnswerAdded();
			}
		});

		// KEY - LISTENER --- ANSWER 'A'
		createNewQuiz_AddAnswerATextArea_TextArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				int key = e.getKeyChar();
				// when delete question text with backspace
				if (key == KeyEvent.VK_BACK_SPACE) {
					System.out.println("BACKSPACE on Answer A");

					if (createNewQuiz_AddAnswerATextArea_TextArea.getText().equals("")) {

						CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualNothing(
								createNewQuiz_AddAnswerATextArea_TextArea, createNewQuiz_AddAnswerAButton_Button,
								createNewQuiz_imageLabelA, chckbxAnswerA);
						CreateNewQuestionClass.minimumAnswerAdded();
					}
				}

				else {
					
					CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualSomething(createNewQuiz_AddAnswerATextArea_TextArea, createNewQuiz_imageLabelA, createNewQuiz_AddAnswerBButton_Button, 
							chckbxAnswerA);
				}

			}
		});

		createNewQuiz_AddAnswerATextArea_TextArea.setEnabled(false);
		createNewQuiz_AddAnswerATextArea_TextArea.setWrapStyleWord(true);
		createNewQuiz_AddAnswerATextArea_TextArea.setLineWrap(true);
		createNewQuiz_AddAnswerATextArea_TextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		createNewQuiz_AddAnswerATextArea_TextArea.setMargin(new Insets(5, 5, 5, 5));
		createNewQuiz_AddAnswerATextArea_TextArea.setText("Answer...");

		createNewQuiz_AddAnswerAScrollPane_ScrollPane.setBounds(125, 26, 500, 35);
		createNewQuiz_AddAnswerAScrollPane_ScrollPane.setViewportView(createNewQuiz_AddAnswerATextArea_TextArea);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerAScrollPane_ScrollPane);
		createNewQuiz_imageLabelA.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/sign-error.jpg")));
		createNewQuiz_imageLabelA.setBackground(new Color(245, 255, 250));
		createNewQuiz_imageLabelA.setBounds(640, 26, 35, 35);
		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_imageLabelA);

		createNewQuiz_AddAnswerBButton_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CreateNewQuestionClass.checkAnswerButtonActionWithTextArea(createNewQuiz_AddAnswerBButton_Button,createNewQuiz_AddAnswerCButton_Button, createNewQuiz_AddAnswerBTextArea_TextArea,createNewQuiz_imageLabelB);
				
			}
		});
		createNewQuiz_AddAnswerBButton_Button.setEnabled(false);
		createNewQuiz_AddAnswerBButton_Button.setHorizontalAlignment(SwingConstants.CENTER);
		createNewQuiz_AddAnswerBButton_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
		createNewQuiz_AddAnswerBButton_Button.setBounds(0, 66, 120, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerBButton_Button);
		createNewQuiz_AddAnswerBScrollPane_ScrollPane.setBounds(125, 66, 500, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerBScrollPane_ScrollPane);
		createNewQuiz_AddAnswerBTextArea_TextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				CreateNewQuestionClass.checkAnswerFieldFocusLost(createNewQuiz_AddAnswerBTextArea_TextArea,
						createNewQuiz_AddAnswerBButton_Button, createNewQuiz_imageLabelB);
				
				CreateNewQuestionClass.minimumAnswerAdded();
			}
		});
		
		createNewQuiz_AddAnswerBTextArea_TextArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				

					int key = e.getKeyChar();
					// when delete question text with backspace
					if (key == KeyEvent.VK_BACK_SPACE) {
						System.out.println("BACKSPACE on Answer B");

						if (createNewQuiz_AddAnswerBTextArea_TextArea.getText().equals("")) {

							CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualNothing(
									createNewQuiz_AddAnswerBTextArea_TextArea, createNewQuiz_AddAnswerBButton_Button,
									createNewQuiz_imageLabelB, chckbxAnswerB);
							CreateNewQuestionClass.minimumAnswerAdded();
						}
					}

					else {
						
						CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualSomething(createNewQuiz_AddAnswerBTextArea_TextArea, createNewQuiz_imageLabelB, createNewQuiz_AddAnswerCButton_Button, 
								chckbxAnswerB);
					}

				}
			
		});
		createNewQuiz_AddAnswerBTextArea_TextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		createNewQuiz_AddAnswerBTextArea_TextArea.setEnabled(false);

		createNewQuiz_AddAnswerBTextArea_TextArea.setLineWrap(true);
		createNewQuiz_AddAnswerBTextArea_TextArea.setWrapStyleWord(true);
		createNewQuiz_AddAnswerBTextArea_TextArea.setText("Answer...");
		createNewQuiz_AddAnswerBTextArea_TextArea.setMargin(new Insets(5, 5, 5, 5));
		createNewQuiz_AddAnswerBScrollPane_ScrollPane.setViewportView(createNewQuiz_AddAnswerBTextArea_TextArea);
		createNewQuiz_imageLabelB.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/sign-error.jpg")));
		createNewQuiz_imageLabelB.setBackground(new Color(245, 255, 250));
		createNewQuiz_imageLabelB.setBounds(640, 66, 35, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_imageLabelB);
		createNewQuiz_AddAnswerCButton_Button.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
				CreateNewQuestionClass.checkAnswerButtonActionWithTextArea(createNewQuiz_AddAnswerCButton_Button, createNewQuiz_AddAnswerDButton_Button,
						createNewQuiz_AddAnswerCTextArea_TextArea,createNewQuiz_imageLabelC);

			}
		});
		createNewQuiz_AddAnswerCButton_Button.setEnabled(false);

		createNewQuiz_AddAnswerCButton_Button.setHorizontalAlignment(SwingConstants.CENTER);
		createNewQuiz_AddAnswerCButton_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
		createNewQuiz_AddAnswerCButton_Button.setBounds(0, 106, 120, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerCButton_Button);
		createNewQuiz_AddAnswerCScrollPane_ScrollPane.setBounds(125, 106, 500, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerCScrollPane_ScrollPane);
		
		createNewQuiz_AddAnswerCTextArea_TextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CreateNewQuestionClass.checkAnswerFieldFocusLost(createNewQuiz_AddAnswerCTextArea_TextArea,
						createNewQuiz_AddAnswerCButton_Button, createNewQuiz_imageLabelC);
				
				CreateNewQuestionClass.minimumAnswerAdded();
			}
		});
		createNewQuiz_AddAnswerCTextArea_TextArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				// when delete question text with backspace
				if (key == KeyEvent.VK_BACK_SPACE) {
					System.out.println("BACKSPACE on Answer C");

					if (createNewQuiz_AddAnswerCTextArea_TextArea.getText().equals("")) {
						CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualNothing(
								createNewQuiz_AddAnswerCTextArea_TextArea, createNewQuiz_AddAnswerCButton_Button,
								createNewQuiz_imageLabelC, chckbxAnswerC);
						CreateNewQuestionClass.minimumAnswerAdded();
					}
				}else {
					CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualSomething(createNewQuiz_AddAnswerCTextArea_TextArea, createNewQuiz_imageLabelC,createNewQuiz_AddAnswerDButton_Button,chckbxAnswerC);
					
				}
			}
		});
		
		createNewQuiz_AddAnswerCTextArea_TextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		createNewQuiz_AddAnswerCTextArea_TextArea.setEnabled(false);
		createNewQuiz_AddAnswerCTextArea_TextArea.setWrapStyleWord(true);
		createNewQuiz_AddAnswerCTextArea_TextArea.setLineWrap(true);
		createNewQuiz_AddAnswerCTextArea_TextArea.setText("Answer...");
		createNewQuiz_AddAnswerCTextArea_TextArea.setMargin(new Insets(5, 5, 5, 5));
		createNewQuiz_AddAnswerCScrollPane_ScrollPane.setViewportView(createNewQuiz_AddAnswerCTextArea_TextArea);
		createNewQuiz_imageLabelC.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/sign-error.jpg")));
		createNewQuiz_imageLabelC.setBackground(new Color(245, 255, 250));
		createNewQuiz_imageLabelC.setBounds(640, 106, 35, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_imageLabelC);
		createNewQuiz_AddAnswerDButton_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewQuestionClass.checkAnswerButtonActionWithTextArea(createNewQuiz_AddAnswerDButton_Button, createNewQuiz_AddAnswerEButton_Button,
						createNewQuiz_AddAnswerDTextArea_TextArea,createNewQuiz_imageLabelD);
			}
		});
		createNewQuiz_AddAnswerDButton_Button.setEnabled(false);

		createNewQuiz_AddAnswerDButton_Button.setHorizontalAlignment(SwingConstants.CENTER);
		createNewQuiz_AddAnswerDButton_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
		createNewQuiz_AddAnswerDButton_Button.setBounds(0, 146, 120, 35);
		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerDButton_Button);

		createNewQuiz_AddAnswerDScrollPane_ScrollPane.setBounds(125, 146, 500, 35);
		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerDScrollPane_ScrollPane);
		
		createNewQuiz_AddAnswerDTextArea_TextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CreateNewQuestionClass.checkAnswerFieldFocusLost(createNewQuiz_AddAnswerDTextArea_TextArea,
						createNewQuiz_AddAnswerDButton_Button, createNewQuiz_imageLabelD);
				CreateNewQuestionClass.minimumAnswerAdded();
			}
		});
		createNewQuiz_AddAnswerDTextArea_TextArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				// when delete question text with backspace
				if (key == KeyEvent.VK_BACK_SPACE) {
					System.out.println("BACKSPACE on Answer D");

					if (createNewQuiz_AddAnswerDTextArea_TextArea.getText().equals("")) {
						CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualNothing(
								createNewQuiz_AddAnswerDTextArea_TextArea, createNewQuiz_AddAnswerDButton_Button,
								createNewQuiz_imageLabelD, chckbxAnswerD);
						CreateNewQuestionClass.minimumAnswerAdded();
					}
				}else {
					CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualSomething(createNewQuiz_AddAnswerDTextArea_TextArea, createNewQuiz_imageLabelD,createNewQuiz_AddAnswerEButton_Button,chckbxAnswerD);
					
				}
			}
		});
		
		createNewQuiz_AddAnswerDTextArea_TextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		createNewQuiz_AddAnswerDTextArea_TextArea.setEnabled(false);

		createNewQuiz_AddAnswerDTextArea_TextArea.setWrapStyleWord(true);
		createNewQuiz_AddAnswerDTextArea_TextArea.setLineWrap(true);
		createNewQuiz_AddAnswerDTextArea_TextArea.setText("Answer...");
		createNewQuiz_AddAnswerDTextArea_TextArea.setMargin(new Insets(5, 5, 5, 5));
		createNewQuiz_AddAnswerDScrollPane_ScrollPane.setViewportView(createNewQuiz_AddAnswerDTextArea_TextArea);
		createNewQuiz_imageLabelD.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/sign-error.jpg")));
		createNewQuiz_imageLabelD.setBackground(new Color(245, 255, 250));
		createNewQuiz_imageLabelD.setBounds(640, 146, 35, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_imageLabelD);
		createNewQuiz_AddAnswerEButton_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewQuestionClass.checkAnswerButtonActionWithTextArea(createNewQuiz_AddAnswerEButton_Button, createNewQuiz_AddAnswerEButton_Button,
						createNewQuiz_AddAnswerETextArea_TextArea,createNewQuiz_imageLabelE);
			}
		});
		createNewQuiz_AddAnswerEButton_Button.setEnabled(false);

		createNewQuiz_AddAnswerEButton_Button.setHorizontalAlignment(SwingConstants.CENTER);
		createNewQuiz_AddAnswerEButton_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
		createNewQuiz_AddAnswerEButton_Button.setBounds(0, 186, 120, 35);
		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerEButton_Button);

		createNewQuiz_AddAnswerEScrollPane_ScrollPane.setBounds(125, 186, 500, 35);
		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_AddAnswerEScrollPane_ScrollPane);
		
		createNewQuiz_AddAnswerETextArea_TextArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CreateNewQuestionClass.checkAnswerFieldFocusLost(createNewQuiz_AddAnswerETextArea_TextArea,
						createNewQuiz_AddAnswerEButton_Button, createNewQuiz_imageLabelE);
				
				CreateNewQuestionClass.minimumAnswerAdded();
			}
		});
		createNewQuiz_AddAnswerETextArea_TextArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				// when delete question text with backspace
				if (key == KeyEvent.VK_BACK_SPACE) {
					System.out.println("BACKSPACE on Answer E");

					if (createNewQuiz_AddAnswerETextArea_TextArea.getText().equals("")) {
						CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualNothing(
								createNewQuiz_AddAnswerETextArea_TextArea, createNewQuiz_AddAnswerEButton_Button,
								createNewQuiz_imageLabelE, chckbxAnswerE);
						CreateNewQuestionClass.minimumAnswerAdded();
					}
				}else {
					CreateNewQuestionClass.answerFieldKeyTypedBackspaceEqualSomething(createNewQuiz_AddAnswerETextArea_TextArea, createNewQuiz_imageLabelE,createNewQuiz_AddAnswerEButton_Button,chckbxAnswerE);
					
				}
			}
		});
		
		createNewQuiz_AddAnswerETextArea_TextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		createNewQuiz_AddAnswerETextArea_TextArea.setEnabled(false);

		createNewQuiz_AddAnswerETextArea_TextArea.setWrapStyleWord(true);
		createNewQuiz_AddAnswerETextArea_TextArea.setLineWrap(true);
		createNewQuiz_AddAnswerETextArea_TextArea.setText("Answer...");
		createNewQuiz_AddAnswerETextArea_TextArea.setMargin(new Insets(5, 5, 5, 5));
		createNewQuiz_AddAnswerEScrollPane_ScrollPane.setViewportView(createNewQuiz_AddAnswerETextArea_TextArea);
		createNewQuiz_imageLabelE.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/sign-error.jpg")));
		createNewQuiz_imageLabelE.setBackground(new Color(245, 255, 250));
		createNewQuiz_imageLabelE.setBounds(640, 186, 35, 35);

		createNewQuiz_AnswersPanel_Panel.add(createNewQuiz_imageLabelE);
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBounds(20, 375, 690, 135);

		createNewQuizPanel_Panel.add(panel_1);
		panel_1.setLayout(null);
		createNewQuiz_AnswersJustificationLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);

		createNewQuiz_AnswersJustificationLabel_Label.setBounds(0, 0, 125, 25);
		createNewQuiz_AnswersJustificationLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(createNewQuiz_AnswersJustificationLabel_Label);
		createNewQuiz_AddExplanationButton_Button.setEnabled(false);
		
		
		createNewQuiz_AddExplanationButton_Button.setToolTipText("Add a new Question, use right format!");
		createNewQuiz_AddExplanationButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		createNewQuiz_AddExplanationButton_Button.setBorder(thickRedBorder);
		createNewQuiz_AddExplanationButton_Button.setBounds(0, 25, 120, 35);
		panel_1.add(createNewQuiz_AddExplanationButton_Button);

		createNewQuiz_AnswersJustificationScrollPane_ScrollPane.setBounds(125, 25, 500, 55);
		panel_1.add(createNewQuiz_AnswersJustificationScrollPane_ScrollPane);

		createNewQuiz_AnswersJustificationTextArea_TextArea.setWrapStyleWord(true);
		createNewQuiz_AnswersJustificationTextArea_TextArea.setLineWrap(true);
		createNewQuiz_AnswersJustificationTextArea_TextArea.setText("Justification field .....");
		createNewQuiz_AnswersJustificationTextArea_TextArea.setMargin(new Insets(5, 5, 5, 5));
		createNewQuiz_AnswersJustificationScrollPane_ScrollPane
				.setViewportView(createNewQuiz_AnswersJustificationTextArea_TextArea);
		createNewQuiz_ChooseCorrectAnswersLabel_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		createNewQuiz_ChooseCorrectAnswersLabel_Label.setBounds(0, 85, 160, 25);
		panel_1.add(createNewQuiz_ChooseCorrectAnswersLabel_Label);
		createNewQuiz_ChooseCorrectAnswersLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxAnswerA.setHorizontalAlignment(SwingConstants.RIGHT);

		chckbxAnswerA.setEnabled(false);
		chckbxAnswerA.setBounds(167, 87, 90, 25);
		chckbxAnswerA
		.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		chckbxAnswerA
		.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		panel_1.add(chckbxAnswerA);
		chckbxAnswerA.setBackground(new Color(245, 255, 250));
		chckbxAnswerB.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxAnswerB.setEnabled(false);
		chckbxAnswerB.setBounds(259, 87, 90, 25);
		chckbxAnswerB
		.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		chckbxAnswerB
		.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		panel_1.add(chckbxAnswerB);
		chckbxAnswerB.setBackground(new Color(245, 255, 250));
		chckbxAnswerC.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxAnswerC.setEnabled(false);
		chckbxAnswerC.setBounds(351, 87, 90, 25);
		chckbxAnswerC
		.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		chckbxAnswerC
		.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		panel_1.add(chckbxAnswerC);
		chckbxAnswerC.setBackground(new Color(245, 255, 250));
		chckbxAnswerD.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxAnswerD.setEnabled(false);
		chckbxAnswerD.setBounds(443, 87, 90, 25);
		chckbxAnswerD
		.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		chckbxAnswerD
		.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		panel_1.add(chckbxAnswerD);
		chckbxAnswerD.setBackground(new Color(245, 255, 250));
		chckbxAnswerE.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxAnswerE.setEnabled(false);
		chckbxAnswerE.setBounds(535, 87, 90, 25);
		chckbxAnswerE
		.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		chckbxAnswerE
		.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		panel_1.add(chckbxAnswerE);
		chckbxAnswerE.setBackground(new Color(245, 255, 250));
		mainBtnsPanel.setBackground(new Color(245, 255, 250));
		mainBtnsPanel.setBounds(25, 513, 685, 35);

		createNewQuizPanel_Panel.add(mainBtnsPanel);
		mainBtnsPanel.setLayout(null);
		btnNewButton.setBounds(0, 0, 130, 35);
		mainBtnsPanel.add(btnNewButton);
		btnNewButton_1.setBounds(140, 0, 130, 35);
		mainBtnsPanel.add(btnNewButton_1);
		btnNewButton_2.setBounds(280, 0, 160, 35);
		mainBtnsPanel.add(btnNewButton_2);
		btnExit.setBounds(452, 0, 130, 35);
		mainBtnsPanel.add(btnExit);

		// ******************************
		// *** Welcome Creation Panel ***
		// ******************************

		welcomeCreatingPanel_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		welcomeCreatingPanel_Panel.setBounds(37, 45, 720, 550);
		welcomeCreatingPanel_Panel.setLayout(null);
		mainFrame_Frame.getContentPane().add(welcomeCreatingPanel_Panel);

		welcomeCreatingPanel_WelcomeAndGoodLabel_Label.setEnabled(false);
		welcomeCreatingPanel_WelcomeAndGoodLabel_Label.setAlignment(Label.CENTER);
		welcomeCreatingPanel_WelcomeAndGoodLabel_Label.setBounds(235, 10, 250, 31);
		welcomeCreatingPanel_WelcomeAndGoodLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 19));
		welcomeCreatingPanel_WelcomeAndGoodLabel_Label.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_Panel.add(welcomeCreatingPanel_WelcomeAndGoodLabel_Label);

		welcomeCreatingPanel_OptionOnePanel_Panel.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_OptionOnePanel_Panel.setBounds(10, 47, 700, 90);
		welcomeCreatingPanel_OptionOnePanel_Panel.setLayout(null);
		welcomeCreatingPanel_Panel.add(welcomeCreatingPanel_OptionOnePanel_Panel);

		welcomeCreatingPanel_OptionOneLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		welcomeCreatingPanel_OptionOneLabel_Label.setBounds(199, 0, 302, 25);
		welcomeCreatingPanel_OptionOneLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_OptionOnePanel_Panel.add(welcomeCreatingPanel_OptionOneLabel_Label);

		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setBounds(250, 26, 200, 25);
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		welcomeCreatingPanel_CreateNewCheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_OptionOnePanel_Panel.add(welcomeCreatingPanel_CreateNewCheckBox_CheckBox);

		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setText("'ExampleFilename' here without extension.");
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setToolTipText("");
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setBounds(195, 53, 310, 25);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEnabled(false);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setEditable(false);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_CreateNewQuizNameTextField_TextField.setColumns(10);
		welcomeCreatingPanel_OptionOnePanel_Panel.add(welcomeCreatingPanel_CreateNewQuizNameTextField_TextField);

		welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setFont(new Font("Tahoma", Font.BOLD, 13));
		welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setBounds(515, 54, 103, 23);
		welcomeCreatingPanel_ValidateNewQuizNameButton_Button.setEnabled(false);
		welcomeCreatingPanel_OptionOnePanel_Panel.add(welcomeCreatingPanel_ValidateNewQuizNameButton_Button);

		welcomeCreatingPanel_OptionTwoPanel_Panel.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_OptionTwoPanel_Panel.setBounds(10, 148, 700, 115);
		welcomeCreatingPanel_OptionTwoPanel_Panel.setLayout(null);
		welcomeCreatingPanel_Panel.add(welcomeCreatingPanel_OptionTwoPanel_Panel);

		welcomeCreatingPanel_OptionTwoLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		welcomeCreatingPanel_OptionTwoLabel_Label.setBounds(62, 0, 575, 25);
		welcomeCreatingPanel_OptionTwoLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_OptionTwoPanel_Panel.add(welcomeCreatingPanel_OptionTwoLabel_Label);

		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setBounds(250, 34, 200, 25);
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));

		welcomeCreatingPanel_OptionTwoPanel_Panel.add(welcomeCreatingPanel_ExpandExistQuizCheckBox_CheckBox);

		welcomeCreatingPanel_ExpandExistQuizNameLabel_Label.setBounds(62, 65, 575, 25);
		welcomeCreatingPanel_ExpandExistQuizNameLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_OptionTwoPanel_Panel.add(welcomeCreatingPanel_ExpandExistQuizNameLabel_Label);

		welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label
				.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label.setBounds(400, 90, 25, 25);
		welcomeCreatingPanel_OptionTwoPanel_Panel
				.add(welcomeCreatingPanel_ExpandExistQuizStoredQuestionNumberLabel_Label);

		welcomeCreatingPanel_ExpandExistQuizNumberLabel_Label.setBounds(274, 90, 130, 25);
		welcomeCreatingPanel_OptionTwoPanel_Panel.add(welcomeCreatingPanel_ExpandExistQuizNumberLabel_Label);

		welcomeCreatingPanel_OptionThreePanel_Panel.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_OptionThreePanel_Panel.setBounds(10, 290, 700, 160);
		welcomeCreatingPanel_OptionThreePanel_Panel.setLayout(null);
		welcomeCreatingPanel_Panel.add(welcomeCreatingPanel_OptionThreePanel_Panel);

		welcomeCreatingPanel_OptionThreeLabel_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		welcomeCreatingPanel_OptionThreeLabel_Label.setBounds(147, 0, 406, 25);
		welcomeCreatingPanel_OptionThreeLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_OptionThreePanel_Panel.add(welcomeCreatingPanel_OptionThreeLabel_Label);

		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel.setBounds(10, 36, 680, 113);
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel.setLayout(null);

		welcomeCreatingPanel_OptionThreePanel_Panel.add(welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel);

		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setBackground(new Color(245, 255, 250));
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox.setBounds(240, 5, 200, 25);
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel
				.add(welcomeCreatingPanel_ChangeExistQuestionCheckBox_CheckBox);

		welcomeCreatingPanel_ModifyQuestionNumberLabel_Label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		welcomeCreatingPanel_ModifyQuestionNumberLabel_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		welcomeCreatingPanel_ModifyQuestionNumberLabel_Label.setBounds(240, 80, 122, 25);
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel
				.add(welcomeCreatingPanel_ModifyQuestionNumberLabel_Label);

		welcomeCreatingPanel_ModifyQuestionNumberList_List.setBounds(360, 80, 55, 25);
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setBackground(new Color(255, 255, 255));
		welcomeCreatingPanel_ModifyQuestionNumberList_List
				.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { null }));
		welcomeCreatingPanel_ModifyQuestionNumberList_List.setEnabled(false);
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel
				.add(welcomeCreatingPanel_ModifyQuestionNumberList_List);

		welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label.setBounds(392, 55, 25, 25);
		welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel
				.add(welcomeCreatingPanel_ExistQuizQuestionsNumberLabel_Label);

		welcomeCreatingPanel_ChangeExistQuestionNameLabel_Label.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeCreatingPanel_ChangeExistQuestionNameLabel_Label.setBounds(217, 30, 245, 25);
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel
				.add(welcomeCreatingPanel_ChangeExistQuestionNameLabel_Label);

		welcomeCreatingPanel_ChangeExistQuestionNumberLabel_Label.setBounds(270, 55, 122, 25);
		welcomeCreatingPanel_AddNewOrChangeExistQuestionPanel_Panel
				.add(welcomeCreatingPanel_ChangeExistQuestionNumberLabel_Label);

		welcomeCreatingPanel_CreateQuizButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		welcomeCreatingPanel_CreateQuizButton_Button.setEnabled(false);
		welcomeCreatingPanel_CreateQuizButton_Button
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(51, 153, 255), null, null, null));
		welcomeCreatingPanel_CreateQuizButton_Button.setBounds(282, 464, 155, 25);
		welcomeCreatingPanel_Panel.add(welcomeCreatingPanel_CreateQuizButton_Button);

		welcomeCreatingPanel_BackToMainScreenButton_Button.setBounds(272, 500, 175, 25);
		welcomeCreatingPanel_BackToMainScreenButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		welcomeCreatingPanel_Panel.add(welcomeCreatingPanel_BackToMainScreenButton_Button);

		// **************************
		// *** Main Testing Panel ***
		// **************************
		mainTestingPanel_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainTestingPanel_Panel.setBackground(new Color(224, 255, 255));
		mainTestingPanel_Panel.setBounds(36, 28, 721, 585);
		mainTestingPanel_Panel.setLayout(null);
		mainFrame_Frame.getContentPane().add(mainTestingPanel_Panel);

		testingPanel_QuestionAndAnswer_Panel.setBounds(0, 0, 721, 363);
		testingPanel_QuestionAndAnswer_Panel.setBackground(new Color(153, 255, 255));
		testingPanel_QuestionAndAnswer_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		testingPanel_QuestionAndAnswer_Panel.setLayout(null);
		mainTestingPanel_Panel.add(testingPanel_QuestionAndAnswer_Panel);

		testingPanel_QestionNumberTitle_Label.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_QestionNumberTitle_Label.setBounds(12, 6, 62, 14);
		testingPanel_QestionNumberTitle_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_QestionNumberTitle_Label);

		testingPanel_QestionNumber_Label.setBounds(84, 6, 30, 14);
		testingPanel_QestionNumber_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		testingPanel_QestionNumber_Label.setHorizontalAlignment(SwingConstants.LEFT);
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_QestionNumber_Label);

		testingPanel_QuestionsSelectedFrom_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_QuestionsSelectedFrom_Label.setBounds(243, 6, 153, 14);
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_QuestionsSelectedFrom_Label);

		testingPanel_QuestionSelectedFromNumber_Label.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_QuestionSelectedFromNumber_Label.setToolTipText("");
		testingPanel_QuestionSelectedFromNumber_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_QuestionSelectedFromNumber_Label.setBounds(399, 6, 25, 14);
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_QuestionSelectedFromNumber_Label);

		testingPanel_QuestionsSelectedTo_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_QuestionsSelectedTo_Label.setBounds(429, 6, 20, 14);
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_QuestionsSelectedTo_Label);

		testingPanel_QuestionSelectedToNumber_Label.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_QuestionSelectedToNumber_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_QuestionSelectedToNumber_Label.setBounds(454, 7, 25, 14);
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_QuestionSelectedToNumber_Label);

		testingPanel_AnswerACheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_AnswerACheckBox_CheckBox.setBounds(6, 135, 110, 40);
		testingPanel_AnswerACheckBox_CheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		testingPanel_AnswerACheckBox_CheckBox.setBackground(new Color(153, 255, 255));
		testingPanel_AnswerACheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		testingPanel_AnswerACheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_AnswerACheckBox_CheckBox);

		testingPanel_AnswerBCheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_AnswerBCheckBox_CheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		testingPanel_AnswerBCheckBox_CheckBox.setBounds(6, 175, 110, 40);
		testingPanel_AnswerBCheckBox_CheckBox.setBackground(new Color(153, 255, 255));
		testingPanel_AnswerBCheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		testingPanel_AnswerBCheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_AnswerBCheckBox_CheckBox);

		testingPanel_AnswerCCheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_AnswerCCheckBox_CheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		testingPanel_AnswerCCheckBox_CheckBox.setBounds(6, 218, 110, 40);
		testingPanel_AnswerCCheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		testingPanel_AnswerCCheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		testingPanel_AnswerCCheckBox_CheckBox.setBackground(new Color(153, 255, 255));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_AnswerCCheckBox_CheckBox);

		testingPanel_AnswerDCheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_AnswerDCheckBox_CheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		testingPanel_AnswerDCheckBox_CheckBox.setBounds(6, 261, 110, 40);
		testingPanel_AnswerDCheckBox_CheckBox.setBackground(new Color(153, 255, 255));
		testingPanel_AnswerDCheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		testingPanel_AnswerDCheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_AnswerDCheckBox_CheckBox);

		testingPanel_AnswerECheckBox_CheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		testingPanel_AnswerECheckBox_CheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		testingPanel_AnswerECheckBox_CheckBox.setBackground(new Color(153, 255, 255));
		testingPanel_AnswerECheckBox_CheckBox.setBounds(6, 304, 110, 40);
		testingPanel_AnswerECheckBox_CheckBox
				.setIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Empty.png")));
		testingPanel_AnswerECheckBox_CheckBox
				.setSelectedIcon(new ImageIcon(ExamTesterApp.class.getResource("/designGUI/Checkbox_Full.png")));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_AnswerECheckBox_CheckBox);

		testingPanel_ScrollPaneQuestion_ScrollPane.setBounds(12, 27, 700, 95);
		testingPanel_ScrollPaneQuestion_ScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		testingPanel_ScrollPaneQuestion_ScrollPane.setViewportView(testingPanel_QuestionTextArea_TextArea);
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_ScrollPaneQuestion_ScrollPane);

		testingPanel_ScrollPaneAnswerA_ScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		testingPanel_ScrollPaneAnswerA_ScrollPane.setBounds(122, 135, 590, 40);
		testingPanel_ScrollPaneAnswerA_ScrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		testingPanel_ScrollPaneAnswerA_ScrollPane.setViewportView(testingPanel_AnswerAText_TextArea);
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_ScrollPaneAnswerA_ScrollPane);

		testingPanel_AnswerAText_TextArea.setBackground(new Color(255, 255, 255));
		testingPanel_AnswerAText_TextArea.setEditable(false);
		testingPanel_AnswerAText_TextArea.setWrapStyleWord(true);
		testingPanel_AnswerAText_TextArea.setLineWrap(true);
		testingPanel_AnswerAText_TextArea.setFont(new Font("Times New Roman", Font.BOLD, 14));

		testingPanel_ScrollPaneAnswerB_ScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		testingPanel_ScrollPaneAnswerB_ScrollPane.setBounds(122, 178, 590, 40);
		testingPanel_ScrollPaneAnswerB_ScrollPane.setViewportView(testingPanel_AnswerBText_TextArea);
		testingPanel_ScrollPaneAnswerB_ScrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_ScrollPaneAnswerB_ScrollPane);

		testingPanel_AnswerBText_TextArea.setEditable(false);
		testingPanel_AnswerBText_TextArea.setWrapStyleWord(true);
		testingPanel_AnswerBText_TextArea.setLineWrap(true);
		testingPanel_AnswerBText_TextArea.setFont(new Font("Times New Roman", Font.BOLD, 14));

		testingPanel_ScrollPaneAnswerC_ScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		testingPanel_ScrollPaneAnswerC_ScrollPane.setBounds(122, 220, 590, 40);
		testingPanel_ScrollPaneAnswerC_ScrollPane.setViewportView(testingPanel_AnswerCText_TextArea);
		testingPanel_ScrollPaneAnswerC_ScrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_ScrollPaneAnswerC_ScrollPane);

		testingPanel_AnswerCText_TextArea.setEditable(false);
		testingPanel_AnswerCText_TextArea.setWrapStyleWord(true);
		testingPanel_AnswerCText_TextArea.setLineWrap(true);
		testingPanel_AnswerCText_TextArea.setFont(new Font("Times New Roman", Font.BOLD, 14));

		testingPanel_ScrollPaneAnswerD_ScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		testingPanel_ScrollPaneAnswerD_ScrollPane.setBounds(122, 262, 590, 40);
		testingPanel_ScrollPaneAnswerD_ScrollPane.setViewportView(testingPanel_AnswerDText_TextArea);
		testingPanel_ScrollPaneAnswerD_ScrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_ScrollPaneAnswerD_ScrollPane);

		testingPanel_AnswerDText_TextArea.setEditable(false);
		testingPanel_AnswerDText_TextArea.setWrapStyleWord(true);
		testingPanel_AnswerDText_TextArea.setLineWrap(true);
		testingPanel_AnswerDText_TextArea.setFont(new Font("Times New Roman", Font.BOLD, 14));

		testingPanel_ScrollPaneAnswerE_ScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		testingPanel_ScrollPaneAnswerE_ScrollPane.setBounds(122, 304, 590, 40);
		testingPanel_ScrollPaneAnswerE_ScrollPane.setViewportView(testingPanel_AnswerEText_TextArea);
		testingPanel_ScrollPaneAnswerE_ScrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		testingPanel_QuestionAndAnswer_Panel.add(testingPanel_ScrollPaneAnswerE_ScrollPane);

		testingPanel_AnswerEText_TextArea.setEditable(false);
		testingPanel_AnswerEText_TextArea.setWrapStyleWord(true);
		testingPanel_AnswerEText_TextArea.setLineWrap(true);
		testingPanel_AnswerEText_TextArea.setFont(new Font("Times New Roman", Font.BOLD, 14));

		testingPanel_QuestionTextArea_TextArea.setEditable(false);
		testingPanel_QuestionTextArea_TextArea.setWrapStyleWord(true);
		testingPanel_QuestionTextArea_TextArea.setLineWrap(true);
		testingPanel_QuestionTextArea_TextArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		// change border padding
		testingPanel_QuestionTextArea_TextArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		testingPanel_AnyErrorMessageField_Label.setBounds(10, 365, 699, 25);
		mainTestingPanel_Panel.add(testingPanel_AnyErrorMessageField_Label);

		testingPanel_AnyErrorMessageField_Label.setFont(new Font("Monospaced", Font.BOLD, 13));

		testingPanel_ButtonsPanel_Panel.setBounds(5, 390, 210, 189);
		mainTestingPanel_Panel.add(testingPanel_ButtonsPanel_Panel);
		testingPanel_ButtonsPanel_Panel.setBackground(new Color(224, 255, 255));
		testingPanel_ButtonsPanel_Panel.setLayout(null);

		testingPanel_BackButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_BackButton_Button.setBounds(10, 5, 90, 25);

		testingPanel_NextButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_NextButton_Button.setBounds(105, 5, 90, 25);

		testingPanel_ShowAnswersButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_ShowAnswersButton_Button.setBounds(10, 65, 185, 25);

		testingPanel_CurrentScoreButton_Button.setBounds(10, 95, 185, 25);
		testingPanel_CurrentScoreButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));

		testingPanel_ExitButton_Button.setBounds(105, 161, 90, 25);
		testingPanel_ExitButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));

		testingPanel_ButtonsPanel_Panel.add(testingPanel_BackButton_Button);
		testingPanel_ButtonsPanel_Panel.add(testingPanel_NextButton_Button);
		testingPanel_ButtonsPanel_Panel.add(testingPanel_ShowAnswersButton_Button);
		testingPanel_ButtonsPanel_Panel.add(testingPanel_CurrentScoreButton_Button);
		testingPanel_ButtonsPanel_Panel.add(testingPanel_ExitButton_Button);
		testingPanel_ShowImageButton_Button.setBounds(10, 35, 185, 25);
		testingPanel_ShowImageButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_ButtonsPanel_Panel.add(testingPanel_ShowImageButton_Button);

		testingPanel_NewTestButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_NewTestButton_Button.setBounds(10, 161, 90, 25);
		testingPanel_ButtonsPanel_Panel.add(testingPanel_NewTestButton_Button);

		testingPanel_BackToMainButton_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_BackToMainButton_Button.setBounds(10, 127, 185, 23);
		testingPanel_ButtonsPanel_Panel.add(testingPanel_BackToMainButton_Button);

		testingPanel_ShowAnswersPanel_Panel.setBounds(244, 390, 470, 189);
		testingPanel_ShowAnswersPanel_Panel.setBackground(new Color(224, 255, 255));
		mainTestingPanel_Panel.add(testingPanel_ShowAnswersPanel_Panel);

		testingPanel_ShowAnswersPanel_Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		testingPanel_ShowAnswersPanel_Panel.setLayout(null);
		testingPanel_JustificationScrollPane_ScrollPane.setBounds(5, 40, 460, 110);
		// hide the border around the scrollPane
		testingPanel_JustificationScrollPane_ScrollPane.setBorder(BorderFactory.createEmptyBorder());
		testingPanel_JustificationLabel_Label.setWrapStyleWord(true);
		testingPanel_JustificationLabel_Label.setEditable(false);
		testingPanel_JustificationScrollPane_ScrollPane.setViewportView(testingPanel_JustificationLabel_Label);
		testingPanel_ShowAnswersPanel_Panel.add(testingPanel_JustificationScrollPane_ScrollPane);

		// Justification Label
		testingPanel_JustificationLabel_Label.setBackground(new Color(224, 255, 255));
		testingPanel_JustificationLabel_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		testingPanel_JustificationLabel_Label.setForeground(Color.RED);
		testingPanel_JustificationLabel_Label.setLineWrap(true);
		testingPanel_CorrectAnswersMessageField_Label.setBounds(5, 5, 460, 30);
		testingPanel_ShowAnswersPanel_Panel.add(testingPanel_CorrectAnswersMessageField_Label);
		testingPanel_CorrectAnswersMessageField_Label.setForeground(Color.RED);
		testingPanel_CorrectAnswersMessageField_Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		testingPanel_CorrectAnswersMessageField_Label.setHorizontalAlignment(SwingConstants.LEFT);

		// ***************************
		// *** Main Creation Panel ***
		// ***************************
		mainCreating_Panel_Panel.setBackground(new Color(224, 255, 255));
		mainCreating_Panel_Panel.setBounds(37, 45, 720, 550);
		mainFrame_Frame.getContentPane().add(mainCreating_Panel_Panel);
		mainCreating_Panel_Panel.setLayout(null);

		// *****************
		// *** Variables ***
		// *****************

		// FileChooser in DialogBox
		// -
		// http://www.javaworld.com/article/2074920/learn-java/enterprise-application-integration-customizing-swing-s-file-chooser.html
		// - http://stackoverflow.com/a/4169224/4269580
		openThisFile_FileChooser.setCurrentDirectory(workingDirectory);
		openThisFile_FileChooser.setDialogTitle("Choose the Exam text file!");
		openThisFile_FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		openThisFile_FileChooser.setFileFilter(filterFileType);
		// - http://stackoverflow.com/a/5284637/4269580
		openThisFile_FileChooser.removeChoosableFileFilter(openThisFile_FileChooser.getAcceptAllFileFilter());
		// setEditable(false) the FileName field
		MetalFileChooserUI ui = (MetalFileChooserUI) openThisFile_FileChooser.getUI();
		Field field;
		try {
			field = MetalFileChooserUI.class.getDeclaredField("fileNameTextField");
			field.setAccessible(true);
			JTextField tf = (JTextField) field.get(ui);
			tf.setEditable(false);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
