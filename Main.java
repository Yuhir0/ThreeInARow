import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.xml.*;
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
	private JTextField txtSinglePlayer;

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
		lblO.setVisible(false);
		lblO.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblO.setBounds(23, 397, 33, 16);
		contentPane.add(lblO);
		
		JLabel lblX = new JLabel("X");
		lblX.setVisible(false);
		lblX.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblX.setBounds(579, 397, 33, 16);
		contentPane.add(lblX);
		
		// Text Jugador 1
		txtSinglePlayer = new JTextField();
		txtSinglePlayer.setVisible(false);
		txtSinglePlayer.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSinglePlayer.setText("Player 1");
		txtSinglePlayer.setBounds(200, 385, 244, 43);
		contentPane.add(txtSinglePlayer);
		
		// Text Jugador 1
		txtPlayer1 = new JTextField();
		txtPlayer1.setVisible(false);
		txtPlayer1.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer1.setText("Player 1");
		txtPlayer1.setBounds(51, 385, 244, 43);
		contentPane.add(txtPlayer1);
		
		// Text Jugador 2
		txtPlayer2 = new JTextField();
		txtPlayer2.setVisible(false);
		txtPlayer2.setText("Player 2");
		txtPlayer2.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer2.setColumns(10);
		txtPlayer2.setBounds(325, 385, 244, 43);
		contentPane.add(txtPlayer2);
		
		JButton btnStart = new JButton("START");
		btnStart.setVisible(false);
		btnStart.setFont(new Font("Impact", Font.BOLD, 50));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Match match = new Match(new Player("Player1","O"), new Player("Player2", "X"));
				match.setVisible(true);
				dispose();
			}
		});
		
		btnStart.setBounds(179, 475, 268, 91);
		contentPane.add(btnStart);
		JButton btnSinglePlayer = new JButton("SINGLE PLAYER");
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart.setVisible(true);
				lblO.setBounds(175, 397, 33, 16);
				lblO.setVisible(true);
				lblX.setVisible(false);
				txtSinglePlayer.setVisible(true);
				txtPlayer2.setVisible(false);
				txtPlayer1.setVisible(false);
				
			}
		});
		btnSinglePlayer.setFont(new Font("Arial", Font.BOLD, 20));
		btnSinglePlayer.setBounds(99, 281, 196, 43);
		contentPane.add(btnSinglePlayer);
		
		JButton btnMultiplayer = new JButton("MULTIPLAYER");
		btnMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart.setVisible(true);
				txtSinglePlayer.setVisible(false);
				txtPlayer2.setVisible(true);
				txtPlayer1.setVisible(true);
				lblO.setBounds(23, 397, 33, 16);
				lblO.setVisible(true);
				lblX.setVisible(true);
				
			}
		});
		btnMultiplayer.setFont(new Font("Arial", Font.BOLD, 20));
		btnMultiplayer.setBounds(325, 281, 196, 43);
		contentPane.add(btnMultiplayer);
	}
}
