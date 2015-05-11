
public class Slave extends Piece  {

	private final int level = 1;
	private String str;
	int value;
	PieceColor c;
	
	public Slave(PieceColor c){
		super();
		this.c = c;
		switch (c){
		case WHITE:
			str = "WS";
			break;
		case BLACK:
			str = "BS";
			break;
		}
	}
	
	public void getPossibleMoves(int row, int column){
		
		switch(this.c){
		case WHITE:
			row = row -1;
			break;
		case BLACK:
			row = row +1;
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
