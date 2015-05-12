
public abstract class  Piece {

	private int level;
	PieceColor pColor;
	String name;
	
	public abstract boolean move(Board b, int fromX, int fromY, int toX, int toY);
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public String getName(){
		return this.name;
	}

	public PieceColor getColor(){
		return pColor;
	}
	
	public boolean isOutofBoard(Board b,int fromX, int fromY, int toX, int toY){
		
		if(fromX==toX && fromY == toY){
			System.out.println("You cannot move at same place");
			return false;
		}
			

		if(toX<0 || toX>11 || toY<0 ||toY>15){
			System.out.println("You are out of board");
			return false;
		}
			
		if(b.getSquare(toX, toY).getPiece()!= null &&b.getSquare(toX, toY).getPiece().pColor == this.pColor){
			System.out.println("you cannot move on your own piece");
			return false;
		}
			
		return true;
	}

}
