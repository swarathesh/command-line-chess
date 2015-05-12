
public class Dragon extends Piece  {

	private final int level = 5;
	private String str;
	int value;
	
	public Dragon(PieceColor c){
		super();
		this.pColor =c;
		switch (c){
		case WHITE:
			str = "WD";
			break;
		case BLACK:
			str = "BD";
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
