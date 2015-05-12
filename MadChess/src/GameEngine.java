import java.util.*;
	
public class GameEngine {

	private Player player1;
	private Player player2;
	private PieceColor turn;
	private Square[][] squares;
	Board b;
	
	
	public GameEngine(){
		b = new Board();
		squares = b.getSquares();
	}
	
	public boolean isPieceMoved(){
		return true;
	}
	
	public boolean isChecked(){
		return true;
	}
	
	public boolean isEnded(){
		return true;
	}
	
	public void updateBoard(){
		//if(isPieceMoved())
	}

	/*public boolean attemptMove(){
		System.out.println("Turn of Player " + turn + ": ");
		
		Scanner scan = new Scanner(System.in);

		try{
			String coordinatesString = scan.nextLine();
			String[] coordinates = coordinatesString.split(" ");
			int x = Integer.parseInt(coordinates[0]);
			int y = Integer.parseInt(coordinates[1]);	
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Malformed input");
			return false;
		}

		Square source = null;
		while(s == null || s.getPiece() == null) {
			System.out.println("Enter the coordinates of the piece you want to move: ");
			s = Square.readSquare();
		}
		source.squareInfo();
		
		Square destination = null;
		while(s == null) {
			System.out.println("Enter the coordinates you want to move it: ");
			destination = Square.readSquare();
		}
		s.squareInfo();

		if ()
		
		return true;
	}*/
}
