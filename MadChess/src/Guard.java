
public class Guard extends Piece  {

	private final int level = 2;
	private String str;
	int value;
	PieceColor c;
	
	public Guard(PieceColor c){
		super();
		this.c = c;
		switch (c){
		case WHITE:
			str = "WG";
			break;
		case BLACK:
			str = "BG";
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
