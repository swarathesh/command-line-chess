import java.util.Random;


public class CreateRandomPieceChest extends Chest {
	
	public boolean activate(Board b ,int locX, int locY){
		
		Random rn = new Random();
		int r1 = rn.nextInt(12);
		int r2 = rn.nextInt(16);
		
		while(b.getSquare(r1, r2).getPiece() != null || b.getSquare(r1, r2).getChest() != null){
			r1 = rn.nextInt(12);
			r2 = rn.nextInt(16);
		}
		b.getSquare(r1,r2).setPiece(createRandomPiece());
		System.out.println(b.getSquare(r1, r2).getPiece().getName() + "on location " + r1 + " " + r2 + " has been created ");
		return true;
	}
	
	public Piece createRandomPiece(){
		Random rn = new Random();
		int r1 = rn.nextInt(5) + 1;
		int r2 = rn.nextInt(2);
		
		if(r1 == 1){
			
			if(r2 == 0)
				return new Slave(PieceColor.WHITE);
			else
				return new Slave(PieceColor.BLACK);
		}
		
		else if(r1 == 2){
			
			if(r2 == 0)
				return new Guard(PieceColor.WHITE);
			else
				return new Guard(PieceColor.BLACK);
		}

		else if(r1 == 3){
	
			if(r2 == 0)
				return new Cavalier(PieceColor.WHITE);
			else
				return new Cavalier(PieceColor.BLACK);
		}
		
		else if(r1 == 4){
			
			if(r2 == 0)
				return new Eagle(PieceColor.WHITE);
			else
				return new Eagle(PieceColor.BLACK);
		}

		else{
			if(r2 == 0)
				return new Dragon(PieceColor.WHITE);
			else
				return new Dragon(PieceColor.BLACK);
		}

	}
}
