import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblEnterANumber;
	private int theNumber;
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess > theNumber) {
				message = guess + " is too high. Try again.";
			}
			else if (guess < theNumber) {
				message = guess + " is too low. Try again.";
			}
			else {
				message = guess + " is correct. You win!";
			}
		}
		catch (Exception e) {
			message = "Enter a whole number between 1 and 100";
		}
		finally {
			lblEnterANumber.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		
		setFont(new Font("FreeMono", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Micah's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Micah's Hi-Lo Guessing Game");
		lblNewLabel.setBounds(0, 0, 0, 0);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("FreeMono", Font.BOLD, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblGuessANumber = new JLabel("  Guess a number between 1 and 100:");
		lblGuessANumber.setBounds(204, 167, 523, 32);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuessANumber.setFont(new Font("FreeMono", Font.PLAIN, 24));
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(717, 168, 149, 32);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setFont(new Font("FreeMono", Font.PLAIN, 24));
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setFont(new Font("Dialog", Font.BOLD, 40));
		btnGuess.setBounds(377, 304, 346, 179);
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		getContentPane().add(btnGuess);
		
		lblEnterANumber = new JLabel("Enter a number between 1 and 100 and click guess.");
		lblEnterANumber.setBounds(32, 588, 1035, 62);
		lblEnterANumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterANumber.setFont(new Font("FreeMono", Font.PLAIN, 24));
		getContentPane().add(lblEnterANumber);
		
		JLabel title = new JLabel("Micah's Hi-Lo Guessing Game");
		title.setBounds(179, 0, 741, 62);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("FreeMono", Font.BOLD, 40));
		getContentPane().add(title);
	}
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(1100,900));
		theGame.setVisible(true);

	}
}
