
public class Eagle extends Piece  {

	
	private final int level = 4;
	private String str;
	int value;
	PieceColor c;
	
	public Eagle(PieceColor c){
		super();
		this.c = c;
		switch (c){
		case WHITE:
			str = "WE";
			break;
		case BLACK:
			str = "BE";
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
