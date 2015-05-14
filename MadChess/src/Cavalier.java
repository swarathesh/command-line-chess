
public class Cavalier extends Piece {

	
	private final int level = 3;
	private String str;
	
	public Cavalier(PieceColor c){
		super();
		this.pColor = c;
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
		if(!super.isOutofBoard(b, fromX, fromY, toX, toY))
			return false;
		
		if((Math.abs(fromX-toX)!=3 || Math.abs(fromY-toY)!= 2) && (Math.abs(fromX-toX)!=2 || Math.abs(fromY-toY)!=3)){
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
