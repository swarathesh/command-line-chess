import java.util.Scanner;
public class Test {
	
	

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int row;
		int column;
		Board b = new Board();
		b.printBoard();
		b.getSquare(1, 4).getPiece().move(b, 1, 4, 30, 40);

		//	System.out.println("\u2709\uFE0E");
	//	GameEngine gameEngine = new GameEngine();

	//	gameEngine.attemptMove();
	
		
		
		
	}
}
