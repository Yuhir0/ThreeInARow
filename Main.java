import java.awt.EventQueue;
<<<<<<< HEAD
import javax.xml.*;
=======
>>>>>>> e5ce7722e59f316d1b59c54dffcfb511484cf302
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlayer1;
	private JTextField txtPlayer2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/image/ThreeInARow_Title.png")));
		label.setBounds(99, 46, 441, 223);
		contentPane.add(label);
		
		JLabel lblO = new JLabel("O");
		lblO.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblO.setBounds(23, 397, 33, 16);
		contentPane.add(lblO);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblX.setBounds(579, 397, 33, 16);
		contentPane.add(lblX);
		
		// Text Jugador 1
		txtPlayer1 = new JTextField();
		txtPlayer1.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer1.setText("Player 1");
		txtPlayer1.setBounds(51, 385, 244, 43);
		contentPane.add(txtPlayer1);
		
		// Text Jugador 2
		txtPlayer2 = new JTextField();
		txtPlayer2.setText("Player 2");
		txtPlayer2.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer2.setColumns(10);
		txtPlayer2.setBounds(325, 385, 244, 43);
		contentPane.add(txtPlayer2);
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Impact", Font.BOLD, 50));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Match match = new Match(new Player(txtPlayer1.getText(),"O"), new Player(txtPlayer2.getText(), "X"));
				match.setVisible(true);
				dispose();
			}
		});
		
		btnStart.setBounds(179, 475, 268, 91);
		contentPane.add(btnStart);
	}
}
