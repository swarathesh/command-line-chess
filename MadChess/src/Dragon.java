
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
		if(!super.isOutofBoard(b, fromX, fromY, toX, toY))
			return false;
		if((Math.abs(fromX-toX)!=4 || fromY-toY!=0)&& (Math.abs(fromY-toY)!=4 || fromX-toX!=0) && (Math.abs(fromX-toX)!=4 || Math.abs(fromY-toY)!=4)){
			System.out.println("You cannot do that move");
			return false;
		}
		b.getSquare(toX, toY).setPiece(this);
		b.getSquare(fromX,fromY).setPiece(null);
		super.isMovedOnChest(b, toX, toY);
		return true;
	}
	
	public String getName(){
		return this.str;
	}
	
	public int getLevel(){
		return this.level;
	}
}
