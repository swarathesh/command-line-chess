public abstract class Chest {

	private String name;
	private int timeLeft;
	
	public abstract  boolean activate(Board b, int locX, int locY);
	public void postMessage(String s){
		
	}
	
	//methods to register or unregister observers
	public abstract void register(Observer obj);
	public abstract void unRegister(Observer obj);
	
	// method to notify observer of change
	public abstract void notifyObservers();
	
	// method to get updates from subject
	public abstract Object getUpdate(Observer obj);

	
	public Chest(){
		timeLeft = 3;
	}
	
	public String getName() {
		return name;
	}	

	public boolean decay() {
		timeLeft--;
		return timeLeft == 0;
	}
}
