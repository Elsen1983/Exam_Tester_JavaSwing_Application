package designGUI;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ImageDisplay extends JDialog {



	public static ImageIcon displayedImage = new ImageIcon("images/0.jpg");
	public static JLabel imageDisplayField = new JLabel(displayedImage);
	public static int picNum = ExistQuestionReader.picNumInt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

				try {

					ImageDisplay imageDialog = new ImageDisplay(picNum);
					imageDialog.revalidate();
					imageDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					imageDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}



	/**
	 * Create the dialog.
	 */
	public ImageDisplay(int picNum) {

		setEnabled(true);
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 362);
		getContentPane().add(panel);
		panel.setLayout(null);
		imageDisplayField.setBounds(0, 41, 484, 321);
		panel.add(imageDisplayField);

		JLabel lblImage = new JLabel("IMAGE " + picNum);
		lblImage.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(176, 11, 75, 25);
		panel.add(lblImage);

	}
}
