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
		turn = PieceColor.WHITE;
	}

	public boolean isEnded(){
		int whiteWarlordCount = 0;
		int blackWarlordCount = 0;

		for (int i = 0; i<12; i++){
			for (int k = 0; k<16; k++){
				if ((squares[i][k].getPiece() != null)&&(squares[i][k].getPiece().getLevel() == 6)) {
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
	
	public void mainMenu(){
		
		
		String input = "";
		do {
			String s = "Welcome to Mad Chess"
					+ "\n1.Play the game"
					+ "\n2.See the Instructions"
					+ "\n3.See Credits"
					+ "\n4 Quit.\n";
			
			System.out.println(s);
			System.out.print("Enter a number: ");
			input = scan.nextLine();
			
			if(input.equals("1")){
				attemptMove();
			}
			else if(input.equals("2")){
				
			}
			else if(input.equals("3")){
				
			}
			else if (input.equals("4")){
				System.out.println("Thank you for playing.")	;
				break;
			}
			else{
				System.out.println("Try a number between 1 and 4");	
			}
		} while (!( input.equals("4") ));
		
	}

	public void playerTurn(){

		if (turn == PieceColor.WHITE) {
			turn = PieceColor.BLACK;
		} else {
			turn = PieceColor.WHITE;
		}
		
		//collectChests();
		createChests(1);
	
	}

	public void createChests(int i) {
		if(random.nextInt(i) == 0) {
			int randomChestId = random.nextInt(5);
			
			Chest randomChest = new LevelUpChest();
			switch(randomChestId) {
				case 0:
					randomChest = new DestroyRandomPieceChest();
					System.out.println("Chest : DestroyRandomPiece");
					break;
				case 1:
					randomChest = new LevelUpChest();
					System.out.println("Chest : LevelUp");
					break;
				case 2:
					randomChest = new LevelDownChest();
					System.out.println("Chest : LevelDown");
					break;
				case 3:
					randomChest = new RandomBlockChest();
					System.out.println("Chest : RandomBlockTeleport");
					break;
				case 4:
					randomChest = new CreateRandomPieceChest();
					System.out.println("Chest : CreateRandomPiece");
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
	
	public void attemptMove(){

		Piece choosenPiece;
		int fromX = -1;
		int fromY = -1;
		int toX = -1;
		int toY = -1;
		String coordinatesString = "";
		
		while(!isEnded()){
		
			if(turn == PieceColor.WHITE){
				do {
					board.printBoard();
					System.out.println("\nWHITE's Turn");
					System.out.print("Enter the coordinates of the piece you want to move: ");
	
					try{
						coordinatesString = scan.nextLine();
						if(coordinatesString.equalsIgnoreCase("exit")){
							break;
						}
						
						String[] coordinates = coordinatesString.split(" ");
						fromX = Integer.parseInt(coordinates[0]) -1 ;
						fromY = Integer.parseInt(coordinates[1]) -1;	
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("Malformed input");
					}
					
					if(fromX < 0 || 11 < fromX || fromY < 0 || 15 < fromY )
						System.out.println("The coordinates you entered are out of board");
					if(board.getSquare(fromX, fromY).getPiece() == null || board.getSquare(fromX, fromY).getPiece().pColor != PieceColor.WHITE)
						System.out.println("You did not choose your own piece");
				} while(fromX < 0 || 11 < fromX || fromY < 0 || 15 < fromY ||
						board.getSquare(fromX, fromY).getPiece() == null || board.getSquare(fromX, fromY).getPiece().pColor != PieceColor.WHITE);
				
				if(coordinatesString.equalsIgnoreCase("exit")){
					break;
				}
				
				choosenPiece = board.getSquare(fromX, fromY).getPiece();
				System.out.println(choosenPiece.getName() + " has been selected.");
	
	
				do {
					System.out.print("Enter the coordinates where you want to move: ");
					
					try{
						coordinatesString = scan.nextLine();
						String[] coordinates = coordinatesString.split(" ");
						toX = Integer.parseInt(coordinates[0]) - 1 ;
						toY = Integer.parseInt(coordinates[1]) -1;	
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("Malformed input");
					}
					if(toX < 0 || 11 < toX || toY < 0 || 15 < toY )
						System.out.println("The coordinates you entered are out of board");
				} while(toX < 0 || 11 < toX || toY < 0 || 15 < toY);
			
				if(choosenPiece.move(board, fromX, fromY, toX, toY))
					playerTurn();	
			}
			else{
				do {
					board.printBoard();
					System.out.println("\nBLACK's Turn");
					System.out.print("Enter the coordinates of the piece you want to move: ");
	
					try{
						coordinatesString = scan.nextLine();
						String[] coordinates = coordinatesString.split(" ");
						fromX = Integer.parseInt(coordinates[0]) -1;
						fromY = Integer.parseInt(coordinates[1]) -1;	
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("Malformed input");
					}
					
					if(fromX < 0 || 11 < fromX || fromY < 0 || 15 < fromY )
						System.out.println("The coordinates you entered are out of board");
					if(board.getSquare(fromX, fromY).getPiece() == null)
						System.out.println("You did not choose your own piece");
				} while(fromX < 0 || 11 < fromX || fromY < 0 || 15 < fromY ||
						board.getSquare(fromX, fromY).getPiece() == null);
	
				choosenPiece = board.getSquare(fromX, fromY).getPiece();
				System.out.println(choosenPiece.getName() + " has been selected.");
	
	
				do {
					System.out.print("Enter the coordinates where you want to move: ");
					
					try{
						coordinatesString = scan.nextLine();
						String[] coordinates = coordinatesString.split(" ");
						toX = Integer.parseInt(coordinates[0]) -1;
						toY = Integer.parseInt(coordinates[1]) -1;	
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("Malformed input");
					}
					if(toX < 0 || 11 < toX || toY < 0 || 15 < toY )
						System.out.println("The coordinates you entered are out of board");
				} while(toX < 0 || 11 < toX || toY < 0 || 15 < toY);
				
				if(choosenPiece.move(board, fromX, fromY, toX, toY))
					playerTurn();
			}
		}
		if(isEnded()){
			if(turn == PieceColor.WHITE)
				System.out.println("Black has won");
			else
				System.out.println("White has won");
		}
		System.out.println("Game is over\n");
			
	}
}
