public class GameEngine {
	
	private Player player1;
	private Player player2;
	private PieceColor turn;
	private Square[][] squares;
	Board b;
	
	
	public GameEngine(){
		
		b= new Board();
		squares = b.getSquares();
	}
	
	public boolean isPieceMoved(){
		return true;
	}
	
	public boolean isChecked(){
		return true;
	}
	
	public boolean isEnded(){
		return true;
	}
	
	public void updateBoard(){
		
		//if(isPieceMoved())
			
			
		
	}
}
