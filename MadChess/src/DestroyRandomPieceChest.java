import java.util.Random;
public class DestroyRandomPieceChest extends Chest {
	
	
	public void destroy(Board b){
	
		Random rn = new Random();
		int r1 = rn.nextInt(12);
		int r2 = rn.nextInt(16);
		
		while(b.getSquare(r1, r2).getPiece() == null){
			r1 = rn.nextInt(12);
			r2 = rn.nextInt(16);
		}
		
		b.getSquare(r1, r2).setPiece(null);
	}
}
