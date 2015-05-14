
public class Guard extends Piece  {

	private final int level = 2;
	private String str;
	
	public Guard(PieceColor c){
		super();
		this.pColor = c;
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
		
		if(!super.isOutofBoard(b,fromX, fromY, toX, toY))
			return false;
		
		if(!(Math.abs(fromX-toX) == 3 && fromY-toY == 0) ||(Math.abs(fromY-toY) == 3 && fromX-toX == 0)){
			System.out.println("You cannot do that move");
			return false;
		}
		
		if(b.getSquare(fromX+((toX-fromX)/3),fromY+((toY-fromY)/3)).getPiece()!=null || b.getSquare(fromX+(((toX-fromX)/3)*2),fromY+(((toY-fromY)/3))*2).getPiece()!=null ){
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
