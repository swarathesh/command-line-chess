import java.util.Scanner;
public class Test {
	
	

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		String s = "Welcome to Mad Chess"
				+ "\n1. play game"
				+ "\n2. see instructions"
				+ "\n3.see credits"
				+ "\n4 Quit.\n";
		
		System.out.println(s);
		System.out.println("enter a number");
		int input = scan.nextInt();
		
		
		while(input >1 || input < 4){
			
			if(input == 1){
				GameEngine gameEngine = new GameEngine();
				gameEngine.attemptMove();
			}
			else if(input ==2){
				
			}
			else if(input == 3){
				
			}
			else{
				
			}
			
			System.out.println("enter correct number");
			input = scan.nextInt();
			
		}
		
		
	
		
		
		
	}
}
