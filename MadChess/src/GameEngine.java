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
		String menuDisplay = "Welcome to Mad Chess"
				+ "\n1.Play the game"
				+ "\n2.See the Instructions"
				+ "\n3.See Credits"
				+ "\n4 Quit.\n";
		
		String instructions = "\tSince Mad Chess is a turn based chess game each player will make their moves one by one\n"+
								"\tThere are six different pieces that player can play with. \n" + 
								"\tThese are and their moving styles and their levels are:\n\n"+
								"\tSlave:(Level 1) can move 2 squares straight if the path is empty\n"+
								"\tand can move 1 square diagonally in order to beat opponents piece\n\n"+        
								"\tGuard:(Level 2) can move 3 squares straight in both directions if the path is empty\n"+          
								"\tCavalier:(Level 3) can move 3 squares up or down and 2 squares right or left if the path is empty\n"+          
								"\tEagle:(Level 4) can move 3 squares diagonally, path does not have to be empty\n"+          
								"\tDragon:(Level 5) can move 4 squares straight in both directions or can move 4 squares diagonally, path does not have to be empty\n"+          
								"\tWarlord:(Level 6) can move 1 squares straight in both directions or can move 2 squares diagonally, if the path empty\n "+         
								"\tWhen a piece moves on to a chest on the board chests special effect becomes activated.\n"+
								"\tThere are five different chests either with good or bad effects these are:\n\n "+         
								"\tLevel Up: Levels up the piece by one (can level up maximum to Warlord).\n"+
								"\tLevel Down: Levels down the piece by one (can level down minimum to slave.\n"+
								"\tCreate Random Piece: Creates a random colored and leveled piece to empty square.\n"+
								"\tDestroy Random Piece: Destroys a random colored and leveled piece from empty square.\n"+
								"\tMove to Random Square: The piece that opens this chest teleported to a random square in the board.\n\n"+
								"\tIf your opponent is run out of Warlords you win!\n";
		
		String credits = 	"\t\t MAD CHESS: a Bilkent University CS 319 Project\n\n" +
							"\tWritten By:  Ersin Gunes, Emrehan Tuzun, Caner Bozkurt, Omer Celik\n" +
							"\tSpecial thanks to Ertugurul Kartal Tabak\n\n";
		
		String input = "";
		do {
			
			System.out.println(menuDisplay);
			System.out.print("Enter a number: ");
			input = scan.nextLine();
			System.out.println("\n");
			
			if(input.equals("1")){
				attemptMove();
			}
			else if(input.equals("2")){
				System.out.println(instructions);
			}
			else if(input.equals("3")){
				System.out.println(credits);
			}
			else if (input.equals("4")){
				System.out.println("Thank you for playing.")	;
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
		
		collectChests();
		createChests(2);
	
	}

	public void createChests(int i) {
		if(random.nextInt(i) == 0) {
			int randomChestId = random.nextInt(5);
			
			Chest randomChest = new LevelUpChest();
			switch(randomChestId) {
				case 0:
					randomChest = new DestroyRandomPieceChest();
					randomChest.postMessage("Chest : DestroyRandomPiece");
					break;
				case 1:
					randomChest = new LevelUpChest();
					randomChest.postMessage("Chest : LevelUp");
					break;
				case 2:
					randomChest = new LevelDownChest();
					randomChest.postMessage("Chest : LevelDown");
					break;
				case 3:
					randomChest = new RandomBlockChest();
					randomChest.postMessage("Chest : RandomBlockTeleport");
					break;
				case 4:
					randomChest = new CreateRandomPieceChest();
					randomChest.postMessage("Chest : CreateRandomPiece");
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
					
						if(fromX < 0 || 11 < fromX || fromY < 0 || 15 < fromY )
							System.out.println("The coordinates you entered are out of board");
						else {
							if(board.getSquare(fromX, fromY).getPiece() == null || board.getSquare(fromX, fromY).getPiece().pColor != PieceColor.WHITE)
								System.out.println("You did not choose your own piece");
						}
					} catch(Exception e) {
							//e.printStackTrace();
							System.out.println("Malformed input");
					}
						
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
					
						if(toX < 0 || 11 < toX || toY < 0 || 15 < toY )
							System.out.println("The coordinates you entered are out of board");
					} catch(Exception e) {
						//e.printStackTrace();
						System.out.println("Malformed input");
					}
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
					else{
						if(board.getSquare(fromX, fromY).getPiece() == null || board.getSquare(fromX, fromY).getPiece().pColor != PieceColor.BLACK)
							System.out.println("You did not choose your own piece");
					}
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
					
						if(toX < 0 || 11 < toX || toY < 0 || 15 < toY )
							System.out.println("The coordinates you entered are out of board");
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("Malformed input");
					}
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
