
public class Chest {

	private String name;
	private int timeLeft;
	
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
