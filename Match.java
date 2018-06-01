// @author: Oscar Garcia

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import openfile.OpenFile;
import player.Player;
import player.AI;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Match extends JFrame {

	private JPanel contentPane;
	private Button cell00;
	private Button cell01;
	private Button cell02;
	private Button cell10;
	private Button cell11;
	private Button cell12;
	private Button cell20;
	private Button cell21;
	private Button cell22;
	private JLabel endText;
	private JButton btnBack;
	private JLabel lblPlayerTurn;
	
	private int turn = 0;
	private Player[] players;
	
	private Button[][] board;
	
	private boolean canClick = true;
	private JButton btnRestart;
	
	private String scorePath = "./src/score/score";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Match frame = new Match(new Player("Player1","O"), new AI("Player2", "X"));
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
	public Match(Player p1, Player p2) {
		setTitle("Three in a Row");
		
		players = new Player[] {p1,p2};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cell00 = new Button();
		cell00.setForeground(Color.DARK_GRAY);
		cell00.setBackground(Color.WHITE);
		cell00.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell00.setFocusable(false);
		cell00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell00,0,0);
			}
		});
		cell00.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell00.setBounds(181, 109, 100, 100);
		contentPane.add(cell00);
		
		cell01 = new Button();
		cell01.setForeground(Color.DARK_GRAY);
		cell01.setBackground(Color.WHITE);
		cell01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell01.setFocusable(false);
		cell01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell01,0,1);
			}
		});
		cell01.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell01.setBounds(281, 109, 100, 100);
		contentPane.add(cell01);
		
		cell02 = new Button();
		cell02.setForeground(Color.DARK_GRAY);
		cell02.setBackground(Color.WHITE);
		cell02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell02.setFocusable(false);
		cell02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell02,0,2);
			}
		});
		cell02.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell02.setBounds(381, 109, 100, 100);
		contentPane.add(cell02);
		
		cell10 = new Button();
		cell10.setForeground(Color.DARK_GRAY);
		cell10.setBackground(Color.WHITE);
		cell10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell10.setFocusable(false);
		cell10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell10,1,0);
			}
		});
		cell10.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell10.setBounds(181, 209, 100, 100);
		contentPane.add(cell10);
		
		cell11 = new Button();
		cell11.setForeground(Color.DARK_GRAY);
		cell11.setBackground(Color.WHITE);
		cell11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell11.setFocusable(false);
		cell11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell11,1,1);
			}
		});
		cell11.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell11.setBounds(281, 209, 100, 100);
		contentPane.add(cell11);
		
		cell12 = new Button();
		cell12.setForeground(Color.DARK_GRAY);
		cell12.setBackground(Color.WHITE);
		cell12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell12.setFocusable(false);
		cell12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell12,1,2);
			}
		});
		cell12.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell12.setBounds(381, 209, 100, 100);
		contentPane.add(cell12);
		
		cell20 = new Button();
		cell20.setForeground(Color.DARK_GRAY);
		cell20.setBackground(Color.WHITE);
		cell20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell20.setFocusable(false);
		cell20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell20,2,0);
			}
		});
		cell20.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell20.setBounds(181, 309, 100, 100);
		contentPane.add(cell20);
		
		cell21 = new Button();
		cell21.setForeground(Color.DARK_GRAY);
		cell21.setBackground(Color.WHITE);
		cell21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell21.setFocusable(false);
		cell21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell21,2,1);
			}
		});
		cell21.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell21.setBounds(281, 309, 100, 100);
		contentPane.add(cell21);
		
		cell22 = new Button();
		cell22.setForeground(Color.DARK_GRAY);
		cell22.setBackground(Color.WHITE);
		cell22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cell22.setFocusable(false);
		cell22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClicked(cell22,2,2);
			}
		});
		cell22.setFont(new Font("Arial Black", Font.BOLD, 50));
		cell22.setBounds(381, 309, 100, 100);
		contentPane.add(cell22);
		
		board = new Button[][] {{cell00,cell01,cell02},{cell10,cell11,cell12},{cell20,cell21,cell22}};
		
		if (p2 instanceof AI) {
			((AI) p2).setBoard(board);
		}
		
		endText = new JLabel();
		endText.setFont(new Font("Arial", Font.BOLD, 20));
		endText.setHorizontalAlignment(SwingConstants.CENTER);
		endText.setBounds(191, 441, 290, 46);
		contentPane.add(endText);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(181, 540, 117, 25);
		contentPane.add(btnBack);
		
		btnRestart = new JButton("Restart");
		btnRestart.setBackground(SystemColor.info);
		btnRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestart.setFocusable(false);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartMatch();
			}
		});
		btnRestart.setBounds(364, 540, 117, 25);
		contentPane.add(btnRestart);
		
		lblPlayerTurn = new JLabel(players[0].getName());
		lblPlayerTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTurn.setFont(new Font("Arial", Font.BOLD, 15));
		lblPlayerTurn.setBounds(181, 53, 300, 25);
		contentPane.add(lblPlayerTurn);
		
		
	}
	
	public void buttonClicked(Button b, int x, int y) {
		if ((canClick && b.getLabel().isEmpty())) {
			
			board[x][y].setLabel(players[turn].getPiece());
			
			
			if (!haveWinner()) {
				nextTurn();
				
				if (players[turn] instanceof AI) {
					canClick = false;
					
					try {
						((AI)players[turn]).nextMovement();
					} catch (Exception e) { System.out.println(e.getMessage()); }
					canClick = true;
					if (!haveWinner()) nextTurn();
				}
				
			}
		}
	}
	
	public boolean haveWinner() {
		if (completedRow() || completedColumn() || completedDiagonal()) {
			endText.setText("The winner is " + players[turn].getName());
			canClick = false;
			
			lblPlayerTurn.setText("");
			
			writeScore(players[turn], 1);
			nextTurn();
			writeScore(players[turn], -1);
			return true;
		} else if (allFill()) {
			endText.setText("Draw!");
			canClick = false;
			
			lblPlayerTurn.setText("");
			
			writeScore(players[turn], 0);
			nextTurn();
			writeScore(players[turn], 0);
			return true;
		}
		return false;
	}
	
	public boolean completedRow() {
		for (Button[] r: board) {
			int row = 0;
	        for (Button c: r) {
	        	String s = c.getLabel();
	            if (!s.isEmpty() && s.equals(players[turn].getPiece())) {
	                row++;
	            }
	        }
	        if(row == 3) return true;
		}
	    return false;
	}
	
	public boolean completedColumn() {
		for (int r = 0; r < board.length; r++) {
			int col = 0;
	        for (int c = 0; c < board[r].length; c++) {
	        	String s = board[c][r].getLabel();
	            if (!s.isEmpty() && s.equals(players[turn].getPiece())) {
	                col++;
	            }
	        }
	        if(col == 3) return true;
	       
		}
	    return false;
	}

	public boolean completedDiagonal() {
		int diag = 0;
		for (int i = 0; i < board.length; i++) {
			String s = board[i][i].getLabel();
		    if (!s.isEmpty() && s.equals(players[turn].getPiece())) {
		        diag++;
		    }
		}
		if (diag == 3) return true;
		
		diag = 0;
		for (int i = 0; i < board.length; i++) {
			String s = board[i][2-i].getLabel();
		    if (!s.isEmpty() && s.equals(players[turn].getPiece())) {
		        diag++;
		    }
		}
		if (diag == 3) return true;
		
		return false;
	}
	
	public boolean allFill() {
		int empty = 0;
		for (Button[] r: board) {
	        for (Button c: r) {
	            if (c.getLabel().isEmpty()) {
	                empty++;
	            }
	        }
		}
		return empty == 0;
	}
	
	public void restartMatch() {
		if (!canClick) {			
			for (Button[] r: board) {
		        for (Button c: r) {
		            c.setLabel("");
		        }
			}
			
			turn = 0;
			endText.setText("");
			canClick = true;
			
			lblPlayerTurn.setText(players[turn].getName());
		}
	}
	
	public void nextTurn() {
		if (turn == 0) turn++;
		else turn--;
		
		lblPlayerTurn.setText(players[turn].getName());
	}
	
	public void writeScore(Player p, int state) {
		BufferedWriter fileScoreW = null;
		int c;
		String newScore;
		try {
			String[] playerScore = playerInScore(p.getName());
			if (playerScore == null) playerScore = new String[] {p.getName(),"0","0","0"};
			
			if (state == 1) {
				c = Integer.parseInt(playerScore[1]);
				c++;
				newScore = playerScore[0] + "," + c + "," + playerScore[2] + "," + playerScore[3];
			} else if (state == -1) {
				c = Integer.parseInt(playerScore[2]);
				c++;
				newScore = playerScore[0] + "," + playerScore[1] + "," + c + "," + playerScore[3];
			} else {
				c = Integer.parseInt(playerScore[3]);
				c++;
				newScore = playerScore[0] + "," + playerScore[1] + "," + playerScore[2] + "," + c;
			}
			
			fileScoreW = OpenFile.a(scorePath);
			fileScoreW.write(newScore);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {				
				if (fileScoreW != null)  fileScoreW.close();
			} catch (IOException e) {System.out.println(e.getMessage());}
		}
	}
	
	public String[] playerInScore (String n) {
		BufferedReader fileScoreR = null;
		BufferedWriter fileScoreW = null;
		String line = null;
		String file = "";
		String[] player = null;
		
		try {
			fileScoreR = OpenFile.r(scorePath);
			while ((line = fileScoreR.readLine()) != null) {
				String[] splice = line.split(",");
				if (!splice[0].equals(n)) {
					file += line + "\n";
				} else {
					player = splice;
				}
			}
			
			fileScoreR.close();
			fileScoreW = OpenFile.w(scorePath);
			fileScoreW.write(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fileScoreR != null) fileScoreR.close();
				
				if (fileScoreW != null) fileScoreW.close();
			} catch (IOException e) {System.out.println(e.getMessage());}
		}
		return player;
	}
}