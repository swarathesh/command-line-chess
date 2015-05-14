
public class LevelUpChest extends Chest {
	
	
	
	public boolean activate(Board b, int locX, int locY){
		
		int currentPieceLevel = b.getSquare(locX, locY).getPiece().getLevel();
		PieceColor currentPieceColor = b.getSquare(locX, locY).getPiece().getColor();
		int newPieceLevel = currentPieceLevel++;
		System.out.print(b.getSquare(locX, locY).getPiece().getName()  +  " has been leveled up to ");
		b.getSquare(locX, locY).setPiece(null);
		
		if(newPieceLevel == 2){
			b.getSquare(locX, locY).setPiece(new Guard(currentPieceColor));
		}
		
		else if(newPieceLevel == 3){
			b.getSquare(locX, locY).setPiece(new Cavalier(currentPieceColor));
		}
		
		else if(newPieceLevel == 4){
			b.getSquare(locX, locY).setPiece(new Eagle(currentPieceColor));
		}
		
		else if(newPieceLevel == 5){
			b.getSquare(locX, locY).setPiece(new Dragon(currentPieceColor));
		}
		else if(newPieceLevel == 6){
			b.getSquare(locX, locY).setPiece(new Warlord(currentPieceColor));
		}
		else
			b.getSquare(locX, locY).setPiece(new Warlord(currentPieceColor));
		System.out.println(b.getSquare(locX, locY).getPiece().getName());
		return true;
	}

}
