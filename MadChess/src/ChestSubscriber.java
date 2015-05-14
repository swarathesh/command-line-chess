
public class ChestSubscriber implements Observer {
	
	
		private String name;
		private Chest topic;
		
		public ChestSubscriber(String name){
			this.name = name;
		}
		
		public void update(){
			
		}
		
		// attach with chest to observe
		public void setSubject(Chest chest){
			
		}
	
}
