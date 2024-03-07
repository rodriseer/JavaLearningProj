import java.util.Scanner;

public class Hero {
	//hero paper chart
	//hero str
	private int strength;
	//hero agi
	private int agility;
	//hero defense
	private int defense;
	
	//constructor
	public Hero() {
		//initial str
		strength = 0;
		//initial agi
		agility = 0;
		//initial defense
		defense = 0;
	}
	//method to display hero stats
	public String stats() {
		//return payer stats
		return "STR: " + strength + "\nAGI: " + agility + "DEF: " + defense;

	}
	//method t enhance hero stats
	public void enhanceStats(int additionalStrength, int additionalAgility, int additionalDefense) {
		strength += additionalStrength;
		agility += additionalAgility;
		defense += additionalDefense;
	}
	
	//main method
    public static void main(String[] args) {
    	//creating objects
        Scanner scan = new Scanner(System.in);
        Hero hero = new Hero();
        boolean weaponChosen = false;
        boolean armorChosen = false;
        
        //prompts
        System.out.print("Hello!\nMay I have your name, please: ");
        String player_name = scan.nextLine();
        System.out.println("Hello " + player_name + "!");
        System.out.println("I am a hero battle system calculator.");
        System.out.println("First, I am going to show you your initial stats...\n");
        System.out.println(hero.stats());
        System.out.println("\nAs you can see, your hero is not powerful yet...");
        System.out.println("Lets choose some equipment to enhance stats...");
        
        //options loop starts
        int user_choice;
        do {
        	System.out.print("\nSelect an option below...\n1. Weapons\n2. Armor\n3. Hero stats\n0. Exit\nOption: ");
        	while(!scan.hasNextInt()) {
        		System.out.println("Invalid option....");
        		scan.next();
        	}
        	user_choice = scan.nextInt();
        
        	switch(user_choice) {
        	
        	case 0: System.out.println("Exiting..."); break;
        	//str enhancing option
        	case 1: if (!weaponChosen) {
        		str_options(scan, hero);
        		//change bool to true
                weaponChosen = true;
            } else {
                System.out.println("You have already chosen a weapon.");
            }break;
            
        	case 2: if (!armorChosen) {
        		agi_options(scan, hero);
        		armorChosen = true;
        	}else {
                System.out.println("You have already chosen a weapon.");	
        	}break;

        	case 3: System.out.println("Your hero stats: \n"+ hero.stats()); break;
        	default: System.out.println("Invalid option!"); break;
        	}
        }while(user_choice !=0);
    }
   
    //weapon options
    public static void str_options(Scanner scan, Hero hero) {
        System.out.println("Choose a weapon: \n");
        //str, agi and def respectively, later magic
        Object[][] weapons = {{"Sword", 10, 8, 5}, {"Dagger", 8 , 12, 1}, {"Axe", 12, 6, 4}};

        for (int i = 0; i < weapons.length; i++) {
        	System.out.println((i + 1) + ". " + weapons[i][0] + " (Attack: " + weapons[i][1] + ", Agility: " + weapons[i][2] + ", Defense: " + weapons[i][3] + ")");
        }

        int choice;
        do {
            System.out.print("\nChoose your weapon: ");
            while (!scan.hasNextInt()) {
                System.out.println("That's not a number!");
                scan.next();
            }
            choice = scan.nextInt();
            if (choice < 1 || choice > weapons.length) {
            	System.out.println("Sorry, invalid option, try again...");
            }
        } while (choice < 1 || choice > weapons.length);

        String wpn = (String) weapons[choice - 1][0];
        int str = (int) weapons[choice - 1][1];
        int agi = (int) weapons[choice -1][2];
        
        
        System.out.println("You have chosen " + wpn + " with \nAttack: " + str + "\nAgility: " + agi);
        
        //returning STR enhancing
        hero.enhanceStats(str, agi);
    }
    
    //armor options lets goooo
    public static void agi_options(Scanner scan, Hero hero) {
    	System.out.println("Choose your armor; ");
    	//str, agi respectively, defense code later, then magic even later
    	Object[][] armors = {{"Heavy plate armor", 5 , 1}, {"Leather armor", 2, 5}, {"Magic Robe", 1, 4}};
    	for (int i = 0; i < armors.length; i++) {
    		System.out.println((i+1)+ ". " + armors[i][0] + " (Attack enhancement: " + armors[i][1] + " Agility enhancement: " + armors[i][2] + ")");

    	}
    	//loop fr user choice
    	int choice;
    	do {
            System.out.print("\nChoose your armor: ");
            while (!scan.hasNextInt()) {
                System.out.println("That's not a number!");
                scan.next();
            }
            choice = scan.nextInt();
            if (choice < 1 || choice > armors.length) {
            	System.out.println("Sorry, invalid option, try again...");
            }
        } while (choice < 1 || choice > armors.length);
    	
    	//variables being enhanced and armor name
        String arm = (String) armors[choice - 1][0];
        int str = (int) armors[choice - 1][1];
        int agi = (int) armors[choice -1][2];
        
        //display which armor was chosen
        System.out.println("You have chosen " + arm + " with \nAttack: " + str + "\nAgility: " + agi);
        //returning STR enhancing
        hero.enhanceStats(str, agi);
	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
