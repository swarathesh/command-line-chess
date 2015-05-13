
public abstract class Chest {

	private String name;
	private int timeLeft;
	
	public abstract  boolean activate(Board b, int locX, int locY);
	
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
