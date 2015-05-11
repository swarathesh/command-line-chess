
public class Dragon extends Piece  {

	private final int level = 5;
	private String str;
	int value;
	PieceColor c;
	
	public Dragon(PieceColor c){
		super();
		this.c =c;
		switch (c){
		case WHITE:
			str = "WD";
			break;
		case BLACK:
			str = "BD";
			break;
		}
	}
	
	public String getName(){
		return this.str;
	}
	
	public int getLevel(){
		return this.level;
	}
}
