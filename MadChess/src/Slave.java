
public class Slave extends Piece  {

	private final int level = 1;
	private String str;
	int value;
	
	public Slave(PieceColor c){
		super();
		this.pColor = c;
		switch (this.pColor){
		case WHITE:
			str = "WS";
			break;
		case BLACK:
			str = "BS";
			break;
		}
	}
	
	private boolean isStraightMove(int fromX, int fromY, int toX, int toY){
		
		if(this.pColor == PieceColor.BLACK && toX-fromX == 2 || this.pColor == PieceColor.WHITE && toX-fromX == -2)
			return true;
		return false;	
	}
	
	private boolean isDiagonalMove(int fromX, int fromY, int toX, int toY){
		if((this.pColor== PieceColor.BLACK && toX-fromX==1 && Math.abs(fromY-toY)==1) ||(this.pColor== PieceColor.WHITE && fromX-toX ==1 && Math.abs(fromY-toY)==1) )
			return true;
		return false;
	}
	
	public boolean move(Board b, int fromX, int fromY, int toX, int toY){
		
		if(!super.isOutofBoard(b,fromX, fromY, toX, toY))
			return false;
		
		if(!isStraightMove(fromX, fromY, toX, toY)&&!isDiagonalMove(fromX, fromY, toX, toY))
			return false;
		if(isStraightMove(fromX, fromY, toX, toY)){
			
			if(b.getSquare(toX, toY).getPiece()!= null)
				return false;
			else if (b.getSquare(fromX+((toX-fromX)/2), fromY+((toY-fromY)/2)).getPiece()!= null ){
				return false;
			} 
			else{
				b.getSquare(toX, toY).setPiece(this);
				b.getSquare(fromX,fromY).setPiece(null);
				return true;
			}
		}	
		else{
			if(b.getSquare(toX, toY).getPiece()== null)
				return false;
			b.getSquare(toX, toY).setPiece(this);
			b.getSquare(fromX,fromY).setPiece(null);
			return true;	
		}	
	}
	public String getName(){
		return this.str;
	}
	
	public int getLevel(){
		return this.level;
	}
}
