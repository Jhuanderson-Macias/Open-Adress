import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.userInterface();
		
		// TODO Auto-generated method stub

	}
	
	public void doIt() {

	}
	
	public void userInterface() {
		OpenAddress sim = new OpenAddress();

		Scanner kbd = new Scanner(System.in);
		String input;
		String command;
		boolean done = false;
		int index;
		System.out.println("Welcome to your Has Table\n");
		
	
		while(done == false) {
			System.out.print("Enter command (? for help)\n--> ");
			System.out.println("Please Enter a command");
			input = kbd.nextLine();
			command = input.toLowerCase().trim();
			
			switch(command) {
			
			case "?":
			case "h":
			case "help":
				
				System.out.println("Commands:");
				System.out.println("\td, quit : Quit");
				System.out.println("\ts : search for string");
				System.out.println("\tc : See if string is contained");
				System.out.println("\tp : Prints Table");
				System.out.println("\tput : put item in table");
				
				break;
			
			case "q":
			case "quit":
				
				System.out.println("Ending");
				done = true;
				
				break;
			
			case "put":

				System.out.println("what String would you like to put it in");
				input = kbd.nextLine();
				sim.put(input);
				break;
				
			case "d":
				
				System.out.println("which String would you like to delete?");
				input = kbd.nextLine();
				
				sim.delete(input);
				break;
				
			case "p":
				
				sim.printHash();

				break;
				
			case "s":
				System.out.println("which index would you like to search?");
				input = kbd.nextLine();
				try {
					index = Integer.parseInt(input);	
					} catch(NumberFormatException e){		
					System.out.println("Hey Buddy, please pick a index");
					break;
					}
				System.out.println(sim.get(index));

				break;
			
			case "c":
				System.out.println("What would you like to search");
				input = kbd.nextLine();

				System.out.println(sim.contains(input));
				break;
				
				
			}
		}
	}
}
	
		
