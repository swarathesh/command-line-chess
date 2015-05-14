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
	
		//methods to register or unregister observers
		public  void register(Observer obj){
			
		}
		public  void unRegister(Observer obj){
			
		}
		
		// method to notify observer of change
		public  void notifyObservers(){
			
		}
		
		// method to get updates from subject
		public  Object getUpdate(Observer obj){
			return null;
		}
		
		//method to post message to the topic
	    public void postMessage(String msg){
	        System.out.println("Message: "+msg);
	    }
	
}
