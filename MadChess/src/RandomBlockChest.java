import java.util.Random;
public class RandomBlockChest extends Chest {
	
	public boolean activate(Board b,int locX, int locY){
		Random rn = new Random();
		int r1 = rn.nextInt(12);
		int r2 = rn.nextInt(16);
		
		while(b.getSquare(r1, r2).getPiece() != null){
			r1 = rn.nextInt(12);
			r2 = rn.nextInt(16);
		}
		
		Piece p = b.getSquare(locX,locY).getPiece();
		b.getSquare(locX,locY).setPiece(null);
		b.getSquare(r1,r2).setPiece(p);
		return true;
		
	}
}
