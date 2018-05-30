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
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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
		setTitle("Three In A Row");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/image/ThreeInARow_Title.png")));
		label.setBounds(99, 46, 441, 223);
		contentPane.add(label);
		
		JLabel lblO = new JLabel("O");
		lblO.setForeground(Color.BLACK);
		lblO.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblO.setBounds(23, 397, 33, 16);
		contentPane.add(lblO);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblX.setBounds(579, 397, 33, 16);
		contentPane.add(lblX);
		
		// Text Jugador 1
		txtPlayer1 = new JTextField();
		txtPlayer1.setForeground(Color.BLACK);
		txtPlayer1.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer1.setText("Player 1");
		txtPlayer1.setBounds(51, 385, 244, 43);
		contentPane.add(txtPlayer1);
		
		// Text Jugador 2
		txtPlayer2 = new JTextField();
		txtPlayer2.setForeground(Color.BLACK);
		txtPlayer2.setText("Player 2");
		txtPlayer2.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer2.setColumns(10);
		txtPlayer2.setBounds(325, 385, 244, 43);
		contentPane.add(txtPlayer2);
		
		
		// Text Error
		JLabel lblError = new JLabel("Input a valid Name");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Dialog", Font.BOLD, 20));
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setBounds(179, 439, 275, 24);
		contentPane.add(lblError);
		
		JButton btnStart = new JButton("START");
		btnStart.setBackground(new Color(255, 215, 0));
		btnStart.setForeground(Color.BLACK);
		btnStart.setFont(new Font("Impact", Font.BOLD, 50));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty()) && (txtPlayer1.getText().length() < 20 && txtPlayer2.getText().length() < 20)) {
					Match match = new Match(new Player(txtPlayer1.getText(),"O"), new Player(txtPlayer2.getText(), "X"));
					match.setVisible(true);
					dispose();
				} else {
					lblError.setVisible(true);
				}
			}
		});
		
		btnStart.setBounds(179, 475, 268, 91);
		contentPane.add(btnStart);
		
		JButton btnScoreboard = new JButton("Scoreboard");
		btnScoreboard.setForeground(Color.BLACK);
		btnScoreboard.setBackground(Color.WHITE);
		btnScoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scoreboard scoreboard = new Scoreboard();
				scoreboard.setVisible(true);
				dispose();
			}
		});
		btnScoreboard.setBounds(519, 12, 117, 25);
		contentPane.add(btnScoreboard);
	}
}
