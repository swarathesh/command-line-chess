import java.util.ArrayList;
public class Board {

	final int rowNumber = 12;
	final int columnNumber = 16;
	private Square[][] squares = new Square[12][16];
	private ArrayList<Piece> blackSet;
	private ArrayList<Piece> whiteSet;
	
	public Board(){
	
		blackSet = new ArrayList<Piece>();
		whiteSet = new ArrayList<Piece>();
		
		blackSet.add(new Guard (PieceColor.BLACK));
		blackSet.add(new Cavalier (PieceColor.BLACK));
		blackSet.add(new Eagle (PieceColor.BLACK));
		blackSet.add(new Dragon (PieceColor.BLACK));
		blackSet.add(new Warlord (PieceColor.BLACK));
		blackSet.add(new Eagle (PieceColor.BLACK));
		blackSet.add(new Cavalier (PieceColor.BLACK));
		blackSet.add(new Guard (PieceColor.BLACK));
		blackSet.add(new Guard (PieceColor.BLACK));
		blackSet.add(new Cavalier (PieceColor.BLACK));
		blackSet.add(new Eagle (PieceColor.BLACK));
		blackSet.add(new Dragon (PieceColor.BLACK));
		blackSet.add(new Warlord (PieceColor.BLACK));
		blackSet.add(new Eagle (PieceColor.BLACK));
		blackSet.add(new Cavalier (PieceColor.BLACK));
		blackSet.add(new Guard (PieceColor.BLACK));
		
		for(int a = 0; a<16; a++){
			blackSet.add(new Slave(PieceColor.BLACK));
		}
		
		for(int a = 0; a<16; a++){
			whiteSet.add(new Slave(PieceColor.WHITE));
		}
		
		whiteSet.add(new Guard (PieceColor.WHITE));
		whiteSet.add(new Cavalier (PieceColor.WHITE));
		whiteSet.add(new Eagle (PieceColor.WHITE));
		whiteSet.add(new Dragon (PieceColor.WHITE));
		whiteSet.add(new Warlord (PieceColor.WHITE));
		whiteSet.add(new Eagle (PieceColor.WHITE));
		whiteSet.add(new Cavalier (PieceColor.WHITE));
		whiteSet.add(new Guard (PieceColor.WHITE));
		whiteSet.add(new Guard (PieceColor.WHITE));
		whiteSet.add(new Cavalier (PieceColor.WHITE));
		whiteSet.add(new Eagle (PieceColor.WHITE));
		whiteSet.add(new Dragon (PieceColor.WHITE));
		whiteSet.add(new Warlord (PieceColor.WHITE));
		whiteSet.add(new Eagle (PieceColor.WHITE));
		whiteSet.add(new Cavalier (PieceColor.WHITE));
		whiteSet.add(new Guard (PieceColor.WHITE));
		
		//black
		for(int k = 0; k<16; k++){
			squares[0][k] = new Square(0,k,blackSet.get(k));
		}
		
		for(int k = 0; k<16; k++){
			squares[1][k] = new Square(1,k,blackSet.get(k+16));
		}
		
		// empty 
		for(int i = 2; i<10; i++){
			for(int k = 0; k<16; k++){
				squares[i][k] = new Square(i,k);
			}
		}
		
		// white
		for(int k = 0; k<16; k++){
			squares[10][k] = new Square(10,k,whiteSet.get(k));
		}
		
		for(int k = 0; k<16; k++){
			squares[11][k] = new Square(11,k,whiteSet.get(k+16));
		}
	}
	
	public void printInitialBoard(){
		for(int i = 0; i<12; i++){
			for(int k = 0; k<16; k++){
				squares[i][k].printSquare();
			}
			System.out.print("  " + (i+1));
			System.out.println();
		}
		System.out.println();
		for(int i = 1; i<10; i++)
			System.out.print(i + "  ");
		for(int i = 10; i<=16; i++)
			System.out.print(i + " ");
	}
	
	public Square[][] getSquares(){
		return this.squares;
	}
	
	
	
}
