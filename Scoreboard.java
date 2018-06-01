// Dani Gonzalo
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.JList;

public class Scoreboard extends JFrame {

	private JPanel contentPane;
	private JList list_name;
	private JList list_vict;
	private JList list_def;
	private JList list_draw;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scoreboard frame = new Scoreboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Scoreboard() throws IOException {
		setTitle("Three in a Row");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScoreboard = new JLabel("Scoreboard");
		lblScoreboard.setForeground(Color.WHITE);
		lblScoreboard.setFont(new Font("Arial", Font.BOLD, 60));
		lblScoreboard.setBounds(148, 25, 353, 89);
		contentPane.add(lblScoreboard);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(34, 555, 117, 25);
		contentPane.add(btnBack);
		
		JRadioButton rdbtnName = new JRadioButton("Name");
		buttonGroup.add(rdbtnName);
		rdbtnName.setForeground(Color.WHITE);
		rdbtnName.setBackground(Color.BLACK);
		rdbtnName.setBounds(121, 122, 76, 23);
		contentPane.add(rdbtnName);
		
		JRadioButton rdbtnVictory = new JRadioButton("Victory");
		buttonGroup.add(rdbtnVictory);
		rdbtnVictory.setForeground(Color.WHITE);
		rdbtnVictory.setBackground(Color.BLACK);
		rdbtnVictory.setBounds(298, 122, 76, 23);
		contentPane.add(rdbtnVictory);
		
		JRadioButton rdbtnDraw = new JRadioButton("Draw");
		buttonGroup.add(rdbtnDraw);
		rdbtnDraw.setForeground(Color.WHITE);
		rdbtnDraw.setBackground(Color.BLACK);
		rdbtnDraw.setBounds(491, 122, 76, 23);
		contentPane.add(rdbtnDraw);
		
		JRadioButton rdbtnDefeat = new JRadioButton("Defeat");
		buttonGroup.add(rdbtnDefeat);
		rdbtnDefeat.setForeground(Color.WHITE);
		rdbtnDefeat.setBackground(Color.BLACK);
		rdbtnDefeat.setBounds(396, 122, 76, 23);
		contentPane.add(rdbtnDefeat);
		
		ArrayList<ArrayList<String>> score = read();
		list_name = new JList((ListModel) score.get(0));
		list_name.setSelectionBackground(Color.WHITE);
		list_name.setSelectionForeground(Color.WHITE);
		list_name.setForeground(Color.WHITE);
		list_name.setBackground(Color.BLACK);
		list_name.setBounds(94, 153, 202, 374);
		contentPane.add(list_name);
		
		list_vict = new JList((ListModel) score.get(1));
		list_vict.setSelectionForeground(Color.WHITE);
		list_vict.setSelectionBackground(Color.WHITE);
		list_vict.setForeground(Color.WHITE);
		list_vict.setBackground(Color.BLACK);
		list_vict.setBounds(313, 153, 61, 374);
		contentPane.add(list_vict);
		
		list_def = new JList((ListModel) score.get(2));
		list_def.setSelectionForeground(Color.WHITE);
		list_def.setSelectionBackground(Color.WHITE);
		list_def.setForeground(Color.WHITE);
		list_def.setBackground(Color.BLACK);
		list_def.setBounds(406, 153, 61, 374);
		contentPane.add(list_def);
		
		list_draw = new JList((ListModel) score.get(3));
		list_draw.setSelectionForeground(Color.WHITE);
		list_draw.setSelectionBackground(Color.WHITE);
		list_draw.setForeground(Color.WHITE);
		list_draw.setBackground(Color.BLACK);
		list_draw.setBounds(501, 153, 61, 374);
		contentPane.add(list_draw);
	}
	public ArrayList<ArrayList<String>> read() throws IOException {
		BufferedReader file = null;
		ArrayList <ArrayList<String>> values = new ArrayList<ArrayList<String>>();
		try {
			file = OpenFile.r("./src/score/score");
			String line;
			values.add(new ArrayList<String>());
			values.add(new ArrayList<String>());
			values.add(new ArrayList<String>());
			values.add(new ArrayList<String>());
			while((line=file.readLine())!=null) {
                for (int i = 0; i < line.length(); i++){
                    if ((line.charAt(i) == ',' || i + 1 == line.length()) && line.charAt(i-1) != ','){
                    	String[] splice = line.split(",");
                    	values.get(0).add(splice[0]);
                    	values.get(1).add(splice[1]);
                    	values.get(2).add(splice[2]);
                    	values.get(3).add(splice[3]);
                    }
                }
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
	         try{
	             if( null != file ){
	                file.close();
	             }
	          }catch (Exception e2){
	             e2.printStackTrace();
	          }
		}
		return values;
	}
}
