
public abstract class  Piece {

	private int level;
	PieceColor pColor;
	String name;
	
	
	public Piece(){
		
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isOutofBoard(Board b,int fromX, int fromY, int toX, int toY){
		
		if(fromX==toX && fromY == toY)
			return false;
		if(toX<0 || toX>11 || toY<0 ||toY>15)
			return false;
		if(b.getSquare(toX, toY).getPiece()!= null &&b.getSquare(toX, toY).getPiece().pColor == this.pColor  )
			return false;
		
		return true;
	}
	
	public abstract boolean move(Board b, int fromX, int fromY, int toX, int toY);
		
		
	
}
