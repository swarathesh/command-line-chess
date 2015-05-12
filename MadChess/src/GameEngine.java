import java.util.*;
	
public class GameEngine {

	private Player player1;
	private Player player2;
	private PieceColor turn;
	private Square[][] squares;
	Board board;
	
	
	public GameEngine(){
		board = new Board();
		squares = board.getSquares();
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

	public void playerTurn(){
		System.out.println("Turn of " + turn + " Player.");
		
		boolean isMoveSuccessful = false;
		while (isMoveSuccessful == false) {
			isMoveSuccessful = attemptMove();
		}

		if (turn == PieceColor.WHITE) {
			turn = PieceColor.BLACK;
		} else {
			turn = PieceColor.WHITE;
		}
	}

	public boolean attemptMove(){
		Scanner scan = new Scanner(System.in);

		Piece choosenPiece;
		int fromX = -1;
		int fromY = -1;
		int toX = -1;
		int toY = -1;

		do {
			System.out.print("Enter the coordinates of the piece you want to move: ");

			try{
				String coordinatesString = scan.nextLine();
				String[] coordinates = coordinatesString.split(" ");
				fromX = Integer.parseInt(coordinates[0]);
				fromY = Integer.parseInt(coordinates[1]);	
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Malformed input");
			}
		} while(fromX < 0 || 15 < fromX || fromY < 0 || 11 < fromY ||
				board.getSquare(fromX, fromY).getPiece() == null);

		choosenPiece = board.getSquare(fromX, fromY).getPiece();
		System.out.println(choosenPiece.getName() + " has been selected.");


		do {
			System.out.print("Enter the coordinates where you want to move: ");
			
			try{
				String coordinatesString = scan.nextLine();
				String[] coordinates = coordinatesString.split(" ");
				toX = Integer.parseInt(coordinates[0]);
				toY = Integer.parseInt(coordinates[1]);	
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Malformed input");
			}
		} while(toX < 0 || 15 < toX || toY < 0 || 11 < toY);
		
		return choosenPiece.move(board, fromX, fromY, toX, toY);
	}
}
