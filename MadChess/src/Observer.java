
public interface Observer {
	
	// method to update the observer used by chest
	public void update();
	
	// attach with chest to observe
	public void setSubject(Chest chest);
	

}
