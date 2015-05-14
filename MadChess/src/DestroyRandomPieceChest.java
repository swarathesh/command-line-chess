import java.util.Random;
public class DestroyRandomPieceChest extends Chest {
	
	
	public boolean activate(Board b, int locX, int locY){
	
		Random rn = new Random();
		int r1 = rn.nextInt(12);
		int r2 = rn.nextInt(16);
		
		while(b.getSquare(r1, r2).getPiece() == null){
			r1 = rn.nextInt(12);
			r2 = rn.nextInt(16);
		}
		
		System.out.println(b.getSquare(r1, r2).getPiece().getName() + "on location " + r1 + " " + r2 + " has been destroyed ");
		b.getSquare(r1, r2).setPiece(null);
		
		return true;
	}
	
}
