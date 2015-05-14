
public class Eagle extends Piece  {

	
	private final int level = 4;
	private String str;
	
	public Eagle(PieceColor c){
		super();
		this.pColor = c;
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
		if(!super.isOutofBoard(b, fromX, fromY, toX, toY))
			return false;
		
		if(Math.abs(fromX-toX)!=3 || Math.abs(fromY-toY)!=3){
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
