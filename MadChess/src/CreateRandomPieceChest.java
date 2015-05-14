import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class CreateRandomPieceChest extends Chest {
	
	private List <Observer> obj;
	private String message;
	private boolean changed;
	
	public CreateRandomPieceChest(){
		this.obj = new ArrayList<>();
	}
	
	public boolean activate(Board b ,int locX, int locY){
		
		Random rn = new Random();
		int r1 = rn.nextInt(12);
		int r2 = rn.nextInt(16);
		
		while(b.getSquare(r1, r2).getPiece() != null || b.getSquare(r1, r2).getChest() != null){
			r1 = rn.nextInt(12);
			r2 = rn.nextInt(16);
		}
		b.getSquare(r1,r2).setPiece(createRandomPiece());
		
		//System.out.println(b.getSquare(r1, r2).getPiece().getName() + "on location " + r1 + " " + r2 + " has been created ");
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
	
	
	//methods to register or unregister observers
	public  void register(Observer obj){
		if(obj == null) throw new NullPointerException("Null Observer");
        
        if(!this.obj.contains(obj)) this.obj.add(obj);
	}
	public  void unRegister(Observer obj){
		this.obj.remove(obj);
	}
	
	// method to notify observer of change
	public  void notifyObservers(){
		 List<Observer> observersLocal = null;
	        //synchronization is used to make sure any observer registered after message is received is not notified
	        
	            if (!changed)
	                return;
	            observersLocal = new ArrayList<>(this.obj);
	            this.changed=false;
	        
	        for (Observer obj : observersLocal) {
	            obj.update();
	        }
	 
	}
	
	// method to get updates from subject
	public  Object getUpdate(Observer obj){
		return this.message;
	}
	
	//method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message: "+msg);
    }
}
