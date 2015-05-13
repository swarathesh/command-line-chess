
public class Warlord extends Piece  {
	
	private final int level = 6;
	private String str;
	int value;
	
	public Warlord(PieceColor c){
		super();
		this.pColor = c;
		switch (c){
		case WHITE:
			str = "WW";
			break;
		case BLACK:
			str = "BW";
			break;
		}
	}
	
	private boolean isStraightMove(int fromX, int fromY, int toX, int toY){
		
		if((fromX-toX == 0 && Math.abs(fromY-toY) == 1) ||(fromY-toY == 0 && Math.abs(fromX-toX) == 1) )
			return true;
		
		return false;
				
	}
	
	private boolean isDiagonalMove(int fromX, int fromY, int toX, int toY){
		if(Math.abs(fromX-toX)==2 && Math.abs(fromY-toY)==2)
			return true;
		return false;
				
		
	}
	
	public boolean move(Board b, int fromX, int fromY, int toX, int toY){
				
		if(!super.isOutofBoard(b,fromX, fromY, toX, toY))
			return false;
		
		if(!isStraightMove(fromX, fromY, toX, toY)&&!isDiagonalMove(fromX, fromY, toX, toY)){
			System.out.println("You cannot do that move");
			return false;
		}
			
		if(isStraightMove(fromX, fromY, toX, toY)){			
			b.getSquare(toX, toY).setPiece(this);
			b.getSquare(fromX,fromY).setPiece(null);
			super.isMovedOnChest(b, toX, toY);
			return true;
		}	
		else{
			
			if(b.getSquare(fromX+((toX- fromX)/2), fromY+((toY- fromY)/2)).getPiece()!= null){
				System.out.println("You cannot do that move");
				return false;
			}
			else{
				b.getSquare(toX, toY).setPiece(this);
				b.getSquare(fromX,fromY).setPiece(null);
				super.isMovedOnChest(b, toX, toY);
				return true;
			}
		}	
	}
	
	public String getName(){
		return this.str;
	}
	
	public int getLevel(){
		return this.level;
	}
	
}
