
public class Cavalier extends Piece {

	
	private final int level = 3;
	private String str;
	int value;
	PieceColor c;
	
	public Cavalier(PieceColor c){
		super();
		this.c = c;
		switch (c){
		case WHITE:
			str = "WC";
			break;
		case BLACK:
			str = "BC";
			break;
		}
	}
	
	public boolean move(Board b, int fromX, int fromY, int toX, int toY){
		return true;
	}
	
	public String getName(){
		return this.str;
	}
	
	public int getLevel(){
		return this.level;
	}
}
