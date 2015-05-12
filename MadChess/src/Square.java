import java.util.Scanner;

public class Square {
	
	
	private int row;
	private int column;
	private Piece p;
	private Chest c;
	
	public Square(int row, int column){
		if (row < 0 || 11 < row || column < 0 || 15 < column)
			this = null;

		this.row = row;
		this.column = column;		
		p = null;
		c = null;
	}
	
	public Square(int row, int column, Piece p){
		this = Square(row, column);
		if (this != null)
			this.p = p;
	}
	
	public Square(int row, int column,Chest c){
		this = Square(row, column);
		if (this != null)
			this.c = c;
	}

	public static Square readSquare(){

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
	
	public void squareInfo(){
		System.out.println("coordinates:");
		System.out.println("row:" + row  + " column:" + column);
		if(this.p==null && this.c == null){
		}
		else if(p != null && c == null){
			System.out.print(p.getName());
		}
		
		else if(p == null && c != null){
			System.out.print(c.getName());
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
	
	public Piece getPiece() {
		return p;
	}
	
	public Chest getChest() {
		return c;
	}

}
