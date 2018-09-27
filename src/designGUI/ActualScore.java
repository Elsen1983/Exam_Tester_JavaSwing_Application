package designGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ActualScore extends JDialog {

	public static JPanel contentPanel = new JPanel();
	public static JLabel labelgood = new JLabel("0");
	public static JLabel labelwrong = new JLabel("0");
	public static JLabel labelall = new JLabel("0");
	public static JLabel scorePercentage = new JLabel("0");

	public static JScrollPane scrollPane = new JScrollPane();
	public static JTextArea wrongAnswersTextArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ActualScore dialog = new ActualScore(ExamTesterApp.goodAsweredNumber, ExamTesterApp.wrongAnswerNumber, ExamTesterApp.allAnswered, ExamTesterApp.scoreAnsweredPercentage);
			dialog.revalidate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	/**
	 * Create the dialog.
	 * @param good, int wrong, int all
	 */
	public ActualScore(int good, int wrong, int all, double percent) {
			setBounds(100, 100, 400, 400);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBackground(new Color(204, 255, 255));
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				JLabel lblActualScore = new JLabel("Current Score");
				lblActualScore.setHorizontalAlignment(SwingConstants.CENTER);
				lblActualScore.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblActualScore.setBounds(123, 11, 139, 32);
				contentPanel.add(lblActualScore);
			}
			{
				JLabel lblFinishedQuestion = new JLabel("Finished question :");
				lblFinishedQuestion.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblFinishedQuestion.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFinishedQuestion.setBounds(40, 72, 139, 25);
				contentPanel.add(lblFinishedQuestion);
			}
			{

				String allAnsweredStr = String.valueOf(all);
				labelgood.setText(allAnsweredStr);
				labelgood.setFont(new Font("Tahoma", Font.BOLD, 12));
				labelgood.setHorizontalAlignment(SwingConstants.CENTER);
				labelgood.setBounds(272, 72, 46, 19);
				contentPanel.add(labelgood);
			}
			{
				JLabel lblCorrectAnswers = new JLabel("Correct answers : ");
				lblCorrectAnswers.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblCorrectAnswers.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCorrectAnswers.setBounds(40, 104, 139, 25);
				contentPanel.add(lblCorrectAnswers);
			}
			{

				String goodAnsweredStr = String.valueOf(good);
				labelwrong.setText(goodAnsweredStr);
				labelwrong.setFont(new Font("Tahoma", Font.BOLD, 12));
				labelwrong.setHorizontalAlignment(SwingConstants.CENTER);
				labelwrong.setBounds(272, 106, 46, 14);
				contentPanel.add(labelwrong);
			}
			{
				JLabel lblIncorrectAnswers = new JLabel("Incorrect answers : ");
				lblIncorrectAnswers.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblIncorrectAnswers.setHorizontalAlignment(SwingConstants.RIGHT);
				lblIncorrectAnswers.setBounds(40, 130, 139, 25);
				contentPanel.add(lblIncorrectAnswers);
			}
			{

				String wrongAsweredStr = String.valueOf(wrong);
				labelall.setText(wrongAsweredStr);
				labelall.setFont(new Font("Tahoma", Font.BOLD, 12));
				labelall.setHorizontalAlignment(SwingConstants.CENTER);
				labelall.setBounds(272, 131, 46, 14);
				contentPanel.add(labelall);
			}
			{
				JLabel lblPercentOfThe = new JLabel("Percent of the Score : ");
				lblPercentOfThe.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblPercentOfThe.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPercentOfThe.setBounds(40, 164, 139, 25);
				contentPanel.add(lblPercentOfThe);
			}
			{
				//String.format( "%.2f", percent );
				String scorePercentageStr = String.valueOf(String.format( "%.2f", percent ) + "%");
				scorePercentage.setText(scorePercentageStr);
				scorePercentage.setFont(new Font("Tahoma", Font.BOLD, 12));
				scorePercentage.setHorizontalAlignment(SwingConstants.CENTER);
				scorePercentage.setBounds(245, 169, 94, 14);
				contentPanel.add(scorePercentage);
			}

			JLabel lblWrong = new JLabel("Wrong Answers : ");
			lblWrong.setHorizontalAlignment(SwingConstants.RIGHT);
			lblWrong.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblWrong.setBounds(40, 200, 139, 25);
			contentPanel.add(lblWrong);


			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(200, 203, 139, 49);
			scrollPane.setBorder(null);
			contentPanel.add(scrollPane);

			wrongAnswersTextArea.setBackground(new Color(204, 255, 255));
			wrongAnswersTextArea.setWrapStyleWord(true);
			wrongAnswersTextArea.setLineWrap(true);
			wrongAnswersTextArea.setFont(new Font("Tahoma", Font.BOLD, 12));
			wrongAnswersTextArea.setEditable(false);
			scrollPane.setViewportView(wrongAnswersTextArea);
		}
}
