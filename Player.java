
public class Player {
	private String name;
	private String piece;
	public Player(String name, String piece) {
		this.name = name;
		if (piece.equals("X") || piece.equals("O")) {
			this.piece = piece;
		}
	}
	public String getName() {
		return name;
	}
	public String getPiece() {
		return piece;
	}

}
