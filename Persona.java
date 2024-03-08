import java.util.Scanner;

//persona class
public class Persona {
	
	//all persona stats
    Scanner scan = new Scanner(System.in);
    String motivations;
    String personality;
    String values;
    
    //final power counter
    int slashDash;
    int psychicBlast;
    int fireBlast;

    //motivations
    public void motivationChoices() {
        boolean validChoice = false;
        int choice;
        //loop for choices
        while (!validChoice) {
            System.out.println("\nHere are some motivations for your character: ");
            System.out.println("1. Save the world from the World Eater Dragon");
            System.out.println("2. Recover the Timeloop Hourglass from the evil wizard");
            System.out.println("3. Live in a farmland, far away from the city");
            System.out.print("\nOption: ");
            //validation
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        motivations = "Save the world from the World Eater Dragon";
                        validChoice = true;
                        slashDash ++;
                        break;
                    case 2:
                        motivations = "Recover the Timeloop Hourglass from the evil wizard";
                        validChoice = true;
                        psychicBlast++;
                        break;
                    case 3:
                        motivations = "Live in a farmland, far away from the city";
                        validChoice = true;
                        fireBlast++;
                        break;
                    default:
                        System.out.println("That's not a valid motivation option. Please try again.");
                        break;
                }
            } else {
                System.out.println("That's not a number. Please enter 1, 2, or 3.");
                scan.next();
            }
        }
    }
    //displaying result
    public void displayPersona() {
        System.out.println("Character Motivation: " + motivations +"\nYour character personality is: " + personality + "\nYour character values are: " + values);
    }
    
    //personality
    public void personality() {
    	boolean validChoice2 = false;
        int choice2;
        while (!validChoice2) {
            System.out.println("\nHow would you define your character: ");
            System.out.println("1. Likes to fight");
            System.out.println("2. Highly persistent");
            System.out.println("3. Somewhat of a clown");
            System.out.print("\nOption: ");
            //validation
            if (scan.hasNextInt()) {
                choice2 = scan.nextInt();
                switch (choice2) {
                    case 1:
                        personality = "Likes to fight";
                        validChoice2 = true;
                        slashDash++;
                        break;
                    case 2:
                        personality = "Highly persistent";
                        validChoice2 = true;
                        fireBlast++;
                        break;
                    case 3:
                        personality = "Somewhat of a clown";
                        validChoice2 = true;
                        psychicBlast++;
                        break;
                    default:
                        System.out.println("That's not a valid motivation option. Please try again.");
                        break;
                }
            } else {
                System.out.println("That's not a number. Please enter 1, 2, or 3.");
                scan.next();
            }
        }	
    }
    
    public void values() {
    	boolean validChoice3 = false;
        int choice3;
        while (!validChoice3) {
            System.out.println("\nHow would you define your character most important value: ");
            System.out.println("1. Friends and Family");
            System.out.println("2. Knowledge and Power");
            System.out.println("3. Peace and Soltitude");
            System.out.print("\nOption: ");
            //validation
            if (scan.hasNextInt()) {
                choice3 = scan.nextInt();
                switch (choice3) {
                    case 1:
                        values = "Friends and Family";
                        validChoice3 = true;
                        slashDash++;
                        break;
                    case 2:
                        values = "Knowledge and Power";
                        validChoice3 = true;
                        fireBlast++;
                        break;
                    case 3:
                        values = "Peace and Soltitude";
                        validChoice3 = true;
                        psychicBlast++;
                        break;
                    default:
                        System.out.println("That's not a valid motivation option. Please try again.");
                        break;
                }
            } else {
                System.out.println("That's not a number. Please enter 1, 2, or 3.");
                scan.next();
            }
        }	
    }
    //main
    public static void main(String[] args) {
        System.out.println("Hello, let's define your character's personality.");
        System.out.println("First, let's define your character's motivations...\n");
        Persona persona = new Persona();
        persona.motivationChoices();
        persona.personality();
        persona.values();
        persona.displayPersona();
    }
}
