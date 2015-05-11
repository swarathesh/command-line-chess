
public class Square {
	
	
	private int row;
	private int column;
	Piece p = null;
	Chest c = null;
	
	public Square(int row, int column){
		this.row = row;
		this.column = column;		
	}
	
	public Square(int row, int column, Piece p){
		this.row = row;
		this.column = column;
		this.p = p;
	}
	
	public Square(int row, int column,Chest c){
		this.row = row;
		this.column = column;
		this.c = c;
	}
	
	public void printSquare(){
		if(this.p==null && this.c == null){
			System.out.print("X  ");
		}
		else if(p != null && c == null){
			System.out.print(p.getName() + " ");
		}
		
		else if(p == null && c != null){
			
		}
	}
	
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.row;
	}
	
	public void setColumn(int column){
		this.column = column;
	}
	
	public void setRow(int row){
		this.row = row;
	}
	
	


}
