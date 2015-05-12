import java.util.*;
	
public class GameEngine {
	private Player player1;
	private Player player2;
	private PieceColor turn;
	private Square[][] squares;
	private Board board;
	private Random random;
	private Scanner scan;

	public GameEngine(){
		board = new Board();
		squares = board.getSquares();
		random = new Random();
		scan = new Scanner(System.in);
	}

	public boolean isEnded(){
		int whiteWarlordCount = 0;
		int blackWarlordCount = 0;

		for (int i = 0; i<12; i++){
			for (int k = 0; k<16; k++){
				if (squares[i][k].getPiece().getLevel() == 6) {
					if(squares[i][k].getPiece().getColor() == PieceColor.WHITE) {
						whiteWarlordCount++;
					} else {
						blackWarlordCount++;
					}
				}
			}
		}

		if (whiteWarlordCount == 0 || blackWarlordCount == 0) {
			return true;
		} else {
			return false;
		}
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

		board.printBoard();

		collectChests();
		createChests(10);
	}

	public void createChests(int i) {
		if(random.nextInt(i) == 0) {
			int randomChestId = random.nextInt(5);
			
			Chest randomChest = new LevelUpChest();
			switch(randomChestId) {
				case 0:
					randomChest = new DestroyRandomPieceChest();
					break;
				case 1:
					randomChest = new LevelUpChest();
					break;
				case 2:
					randomChest = new LevelDownChest();
					break;
				case 3:
					randomChest = new RandomBlockChest();
					break;
				case 4:
					randomChest = new CreateRandomPieceChest();
					break;
			}

			Square randomSquare;
			do {
				randomSquare = board.getRandomSquare();
			} while(randomSquare.getPiece() != null || randomSquare.getChest() != null);
			randomSquare.setChest(randomChest);
		}
	}

	public void collectChests() {
		for (int i = 0; i<12; i++){
			for (int k = 0; k<16; k++){
				if(squares[i][k].getChest() != null) {
					if(squares[i][k].getChest().decay()) {
						squares[i][k].removeChest();
					}
				}
			}
		}
	}

	public boolean attemptMove(){

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
