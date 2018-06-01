// Dani Gonzalo
import java.awt.EventQueue;
import player.AI;
import player.Player;
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
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblError;
	private JTextField txtPlayer1;
	private JTextField txtPlayer2;
	private JTextField txtSinglePlayer;
	private boolean singlePlayer;
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
		label.setBounds(105, 46, 440, 200);
		contentPane.add(label);
		
		JLabel lblO = new JLabel("O");
		lblO.setVisible(false);
		lblO.setForeground(Color.BLACK);
		lblO.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		contentPane.add(lblO);
		
		JLabel lblX = new JLabel("X");
		lblX.setVisible(false);
		lblX.setForeground(Color.BLACK);
		lblX.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblX.setBounds(600, 395, 25, 16);
		contentPane.add(lblX);
		
		
		// 1 jugador 
		txtSinglePlayer = new JTextField();
		txtSinglePlayer.setVisible(false);
		txtSinglePlayer.setFont(new Font("Arial", Font.PLAIN, 20));
		txtSinglePlayer.setText("Player 1");
		txtSinglePlayer.setBounds(202, 385, 245, 40);
		contentPane.add(txtSinglePlayer);
		
		// Text Jugador 1
		txtPlayer1 = new JTextField();
		txtPlayer1.setVisible(false);
		txtPlayer1.setForeground(Color.BLACK);
		txtPlayer1.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer1.setText("Player1");
		txtPlayer1.setBounds(65, 385, 245, 40);
		contentPane.add(txtPlayer1);
		
		// Text Jugador 2
		txtPlayer2 = new JTextField();
		txtPlayer2.setVisible(false);
		txtPlayer2.setForeground(Color.BLACK);
		txtPlayer2.setText("Player2");
		txtPlayer2.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPlayer2.setColumns(10);
		txtPlayer2.setBounds(340, 385, 245, 40);
		contentPane.add(txtPlayer2);
		
		
		// Text Error
		lblError = new JLabel("Input a valid Name");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Dialog", Font.BOLD, 20));
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setBounds(195, 439, 260, 24);
		contentPane.add(lblError);
		
		JButton btnStart = new JButton("START");
		btnStart.setFocusable(false);
		btnStart.setVisible(false);
		btnStart.setBackground(new Color(255, 215, 0));
		btnStart.setForeground(Color.BLACK);
		btnStart.setFont(new Font("Impact", Font.BOLD, 50));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		btnStart.setBounds(190, 475, 270, 90);
		contentPane.add(btnStart);
		
		JButton btnSinglePlayer = new JButton("SINGLE PLAYER");
		btnSinglePlayer.setFocusable(false);
		btnSinglePlayer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			singlePlayer = true;
			btnStart.setVisible(true);
			lblO.setBounds(170, 395, 25, 16);
			lblO.setVisible(true);
			lblX.setVisible(false);
			txtSinglePlayer.setVisible(true);
			txtPlayer2.setVisible(false);
			txtPlayer1.setVisible(false);
			}
		});
		btnSinglePlayer.setFont(new Font("Arial", Font.BOLD, 20));
		btnSinglePlayer.setBounds(115, 280, 195, 45);
		contentPane.add(btnSinglePlayer);
		
		JButton btnMultiplayer = new JButton("MULTIPLAYER");
		btnMultiplayer.setFocusable(false);
		btnMultiplayer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			singlePlayer = false;
			btnStart.setVisible(true);
			txtSinglePlayer.setVisible(false);
			txtPlayer2.setVisible(true);
			txtPlayer1.setVisible(true);
			lblO.setBounds(30, 395, 25, 16);
			lblO.setVisible(true);
			lblX.setVisible(true);
			}
		});
		btnMultiplayer.setFont(new Font("Arial", Font.BOLD, 20));
		btnMultiplayer.setBounds(340, 280, 195, 45);
		contentPane.add(btnMultiplayer);
		
		JButton btnScoreboard = new JButton("Scoreboard");
		btnScoreboard.setFocusable(false);
		btnScoreboard.setForeground(Color.BLACK);
		btnScoreboard.setBackground(Color.WHITE);
		btnScoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scoreboard scoreboard = null;
				scoreboard = new Scoreboard();
				scoreboard.setVisible(true);
				dispose();
			}
		});
		btnScoreboard.setBounds(519, 12, 117, 25);
		contentPane.add(btnScoreboard);
	}
	public void startGame() {
		if (singlePlayer) {
			if ((!txtSinglePlayer.getText().isEmpty() && txtSinglePlayer.getText().length() < 20)) {
				Match match = new Match(new Player(txtSinglePlayer.getText(),"O"), new AI("AI","X"));
				match.setVisible(true);
				dispose();
			}else {
				lblError.setVisible(true);
			}
		}else {
			if ((!txtPlayer1.getText().isEmpty() && !txtPlayer2.getText().isEmpty()) && (txtPlayer1.getText().length() < 20 && txtPlayer2.getText().length() < 20)) {
				Match match = new Match(new Player(txtPlayer1.getText(),"O"), new Player(txtPlayer2.getText(), "X"));
				match.setVisible(true);
				dispose();
			} else {
				lblError.setVisible(true);
			}
		}
	}
}
