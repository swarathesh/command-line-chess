import java.util.Scanner;
public class Test {
	
	

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int row;
		int column;
		Board b = new Board();
		b.printBoard();
		b.getSquare(1, 4).getPiece().move(b, 1, 4, 3, 4);
		System.out.println();
		b.printBoard();
		System.out.println();
		b.getSquare(0, 4).getPiece().move(b, 0, 4, 1, 4);

		GameEngine gameEngine = new GameEngine();

	//	gameEngine.attemptMove();
		
		b.printBoard();
		System.out.println();
		b.getSquare(1, 4).getPiece().move(b, 1, 4, 3, 6);
		b.printBoard();
		
		
		
	}
}
