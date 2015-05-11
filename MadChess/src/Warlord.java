
public class Warlord extends Piece  {
	
	private final int level = 6;
	private String str;
	int value;
	PieceColor c;
	
	public Warlord(PieceColor c){
		super();
		this.c = c;
		switch (c){
		case WHITE:
			str = "WW";
			break;
		case BLACK:
			str = "BW";
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
