// Dani Gonzalo
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import openfile.OpenFile;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Scoreboard extends JFrame {

	private JPanel contentPane;
	private JList list_name;
	private JList list_vict;
	private JList list_def;
	private JList list_draw;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	
	public Scoreboard(){
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(Color.BLACK);
		lblName.setBounds(121, 122, 76, 23);
		contentPane.add(lblName);
		
		JLabel lblVictory = new JLabel("Victory");
		lblVictory.setForeground(Color.WHITE);
		lblVictory.setBackground(Color.BLACK);
		lblVictory.setBounds(298, 122, 76, 23);
		contentPane.add(lblVictory);
		
		JLabel lblDraw = new JLabel("Draw");
		lblDraw.setForeground(Color.WHITE);
		lblDraw.setBackground(Color.BLACK);
		lblDraw.setBounds(491, 122, 76, 23);
		contentPane.add(lblDraw);
		
		JLabel Defeat = new JLabel("Defeat");
		Defeat.setForeground(Color.WHITE);
		Defeat.setBackground(Color.BLACK);
		Defeat.setBounds(396, 122, 76, 23);
		contentPane.add(Defeat);
		
		ArrayList<DefaultListModel<String>> score = read();
		list_name = new JList(score.get(0));
		list_name.setEnabled(false);
		list_name.setSelectionBackground(Color.WHITE);
		list_name.setSelectionForeground(Color.WHITE);
		list_name.setForeground(Color.WHITE);
		list_name.setBackground(Color.BLACK);
		list_name.setBounds(94, 153, 202, 374);
		contentPane.add(list_name);
		
		list_vict = new JList(score.get(1));
		list_vict.setEnabled(false);
		list_vict.setSelectionForeground(Color.WHITE);
		list_vict.setSelectionBackground(Color.WHITE);
		list_vict.setForeground(Color.WHITE);
		list_vict.setBackground(Color.BLACK);
		list_vict.setBounds(313, 153, 61, 374);
		contentPane.add(list_vict);
		
		list_def = new JList(score.get(2));
		list_def.setEnabled(false);
		list_def.setSelectionForeground(Color.WHITE);
		list_def.setSelectionBackground(Color.WHITE);
		list_def.setForeground(Color.WHITE);
		list_def.setBackground(Color.BLACK);
		list_def.setBounds(406, 153, 61, 374);
		contentPane.add(list_def);
		
		list_draw = new JList(score.get(3));
		list_draw.setEnabled(false);
		list_draw.setSelectionForeground(Color.WHITE);
		list_draw.setSelectionBackground(Color.WHITE);
		list_draw.setForeground(Color.WHITE);
		list_draw.setBackground(Color.BLACK);
		list_draw.setBounds(501, 153, 61, 374);
		contentPane.add(list_draw);
	}
	
	public ArrayList<DefaultListModel<String>> read() {
		BufferedReader file = null;
		ArrayList <DefaultListModel<String>> values = new ArrayList<DefaultListModel<String>>();
		
		try {
			file = OpenFile.r("./src/score/score");
			String line;
			values.add(new DefaultListModel<String>());
			values.add(new DefaultListModel<String>());
			values.add(new DefaultListModel<String>());
			values.add(new DefaultListModel<String>());
			
			while((line=file.readLine())!=null) {
            	String[] splice = line.split(",");
            	values.get(0).addElement(splice[0]);
            	values.get(1).addElement(splice[1]);
            	values.get(2).addElement(splice[2]);
            	values.get(3).addElement(splice[3]);
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
