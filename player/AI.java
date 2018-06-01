// @author: Oscar Garcia

package player;

import java.awt.Button;

public class AI extends Player{
	
	private Button[][] board;
	
	public AI(String name, String piece) {
		super(name, piece);
	}
	
	public void setBoard(Button[][] board) {
		this.board = board;
	}
	
	public void nextMovement() {
		if (canWin() ||
			rowWarning("O") ||
			columnWarnnig("O") ||
			diagonalWarnnig("O") ||
			simpleMovement());
	}
	
	private boolean canWin() {
		return 	rowWarning("X") ||
				columnWarnnig("X") ||
				diagonalWarnnig("X");
	}
	
	private boolean rowWarning(String p) {
		
		for (int c = 0; c < board.length; c++) {
			int setPosition = -1;
			int row = 0;
	        for (int r = 0; r < board[c].length; r++) {
	        	String s = board[c][r].getLabel();
	            if (!s.isEmpty() && s.equals(p)) {
	                row++;
	            } else if (s.isEmpty()){
	            	setPosition = r;
	            }
	        }
	        if(row == 2 && setPosition >= 0) {
	        	board[c][setPosition].setLabel(this.piece);
	        	return true;
	        }
		}
		return false;
	}
	
	private boolean columnWarnnig(String p) {
		
		for (int r = 0; r < board.length; r++) {
			int setPosition = -1;
			int col = 0;
	        for (int c = 0; c < board[r].length; c++) {
	        	String s = board[c][r].getLabel();
	            if (!s.isEmpty() && s.equals(p)) {
	                col++;
	            } else if (s.isEmpty()) {
	            	setPosition = c;
	            }
	        }
	        if(col == 2 && setPosition >= 0) {
	        	board[setPosition][r].setLabel(this.piece);
	        	return true;
	        }
		}
		return false;
	}
	
	private boolean diagonalWarnnig(String p) {
		int setPosition = -1;
		int diag = 0;
		for (int i = 0; i < board.length; i++) {
			String s = board[i][i].getLabel();
		    if (!s.isEmpty() && s.equals(p)) {
		        diag++;
		    } else if (s.isEmpty()) {
		    	setPosition = i;
		    }
		}
		if (diag == 2 && setPosition >= 0) {
			board[setPosition][setPosition].setLabel(this.piece);
			return true;
		}
		
		setPosition = -1;
		diag = 0;
		for (int i = 0; i < board.length; i++) {
			String s = board[i][2-i].getLabel();
		    if (!s.isEmpty() && s.equals(p)) {
		        diag++;
		    } else if (s.isEmpty()) {
		    	setPosition = i;
		    }
		}
		if (diag == 2 && setPosition >= 0) {
			board[setPosition][2-setPosition].setLabel(this.piece);
			return true;
		}
		
		return false;
	}
	
	private boolean simpleMovement() {
		for (Button[] r: board) {
	        for (Button c: r) {
	            if (c.getLabel().isEmpty()) {
	                c.setLabel(this.piece);
	                return true;
	            }
	        }
		}
		return false;
	}
}
