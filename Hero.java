import java.util.Scanner;
import java.util.Random;

public class Hero {
	//hero paper chart
	//hp is a random number that the player can roll
	private int HP;
	//hero str
	private int strength;
	//hero agi
	private int agility;
	//hero defense
	private int defense;
	//Mana
	private int mana;
	//constructor
	public Hero() {
		//initial HP
		HP = 1;
		//initial str
		strength = 1;
		//initial agi
		agility = 1;
		//initial defense
		defense = 1;
		//initial mana
		mana = 0;
	}
	//method to display hero stats
	public String stats() {
		//return payer stats
		return "HP: " + HP + "\nSTR: " + strength + "\nAGI: " + agility + "\nDEF: " + defense + "\nMana: " + mana;

	}
	//method to enhance hero stats
	//using wrapper Integer for stats not being modified in some methods, aka returning null
	public void enhanceStats(Integer additionalStrength, Integer additionalAgility, Integer additionalDefense, Integer additionalHP, Integer additionalMana) {
		if (additionalStrength != null) {
			strength += additionalStrength;
		}
		if (additionalAgility != null) {
			agility += additionalAgility;
		}
		if (additionalDefense != null) {
			defense += additionalDefense;
		}
		if (additionalHP != null) {
			HP += additionalHP;
		}
		if (additionalMana != null) {
			mana += additionalMana;
		}
	}
	
	//main method
    public static void main(String[] args) {
    	//creating objects
        Scanner scan = new Scanner(System.in);
        Hero hero = new Hero();
        boolean weaponChosen = false;
        boolean armorChosen = false;
        boolean HPRoll = false;
        boolean manaRoll = false;
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
        	System.out.print("\nSelect an option below...\n1. Roll HP\n2. Weapons\n3. Armor\n4. View Stats\n5. Mana roll\n0. Exit\nOption: ");
        	while(!scan.hasNextInt()) {
        		System.out.println("Invalid option....");
        		scan.next();
        	}
        	user_choice = scan.nextInt();
        
        	switch(user_choice) {
        	//option to exit program
        	case 0: System.out.println("Exiting..."); break;
        	//option to roll HP
        	case 1: if (!HPRoll) {
        		HPDice(hero);
        		HPRoll = true;
        	}else {
        		System.out.println("You have already set your HP!");
        	}
        	break;
        	//str enhancing option
        	case 2: if (!weaponChosen) {
        		str_options(scan, hero);
        		//change bool to true
                weaponChosen = true;
            } else {
                System.out.println("You have already chosen a weapon.");
            }break;
            //armor options
        	case 3: if (!armorChosen) {
        		agi_options(scan, hero);
        		armorChosen = true;
        	}else {
                System.out.println("You have already chosen armor.");	
        	}break;
        	
        	//view stats option
        	case 4: System.out.println("Your hero stats: \n"+ hero.stats()); break;
        	//mana roll
        	case 5: if(!manaRoll) {
        		manaDice(hero);
        		manaRoll = true;
        	}else {
        		System.out.println("You have already rolled your mana!");
        	}break;
        	//def
        	default: System.out.println("Invalid option!"); break;
        	}
        }while(user_choice !=0);
    }
   
    //time to roll mana
    public static void manaDice(Hero hero) {
    	//prompt
    	System.out.println("Lets roll your mana!");
    	Random random = new Random();
    	//rolling
    	int roll = 1 + random.nextInt(20);
    	//assigning new mana
    	hero.enhanceStats(null, null, null, null, roll);
        System.out.println("You rolled: " + roll + "!");
        System.out.println("Your new Mana is: " + hero.mana + "!");
    }
    
    //time to roll HP
    public static void HPDice(Hero hero) {
    	//prompt for HP
    	System.out.println("Lets roll your HP...");
    	//importing lib
    	Random random = new Random();
    	//rolling 1 to 99
    	int roll = 1 + random.nextInt(99);
    	//assigning variables
    	hero.enhanceStats(null, null, null, roll-1, null);
        System.out.println("You rolled: " + roll + "!");
        System.out.println("Your new HP is: " + hero.HP + "!");
    }
    
    //weapon options
    public static void str_options(Scanner scan, Hero hero) {
        System.out.println("Choose a weapon: \n");
        //str, agi and def respectively, later magic
        Object[][] weapons = {{"Sword", 10, 8, 5}, {"Dagger", 8 , 12, 1}, {"Axe", 12, 6, 4}};
        //loop to display weapon stats
        for (int i = 0; i < weapons.length; i++) {
        	System.out.println((i + 1) + ". " + weapons[i][0] + " (Attack: " + weapons[i][1] + ", Agility: " + weapons[i][2] + ", Defense: " + weapons[i][3] + ")");
        }
        //loop for user choice of weapons
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
        //weapon assignment
        String wpn = (String) weapons[choice - 1][0];
        int str = (int) weapons[choice - 1][1];
        int agi = (int) weapons[choice -1][2];
        int def = (int)weapons[choice -1][3];
        //prompt
        System.out.println("You have chosen " + wpn + " with \nAttack: " + str + "\nAgility: " + agi);
        //returning all enhancement to enhnce stats method, note that this equivalent to the additional----- values in the method
        hero.enhanceStats(str-1, agi-1, def-1, null, null);
    }
    
    //armor options lets goooo
    public static void agi_options(Scanner scan, Hero hero) {
    	System.out.println("Choose your armor; ");
    	//str, agi respectively, defense, then magic even later
    	Object[][] armors = {{"Heavy plate armor", 2 , 1, 12, 1}, {"Leather armor", 5, 7, 5, 3}, {"Magic Robe", 1, 5, 3, 15}};
    	for (int i = 0; i < armors.length; i++) {
    		System.out.println((i+1) + ". " + armors[i][0] + " (Attack enhancement: " + armors[i][1] + ", Agility enhancement: " + armors[i][2] + ", Defense enhancement: " + armors[i][3] + ", Mana enhancement: " + armors[i][4] + ")");
    	}
    	//loop for user choice
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
        int def = (int) armors[choice -1][3];
        int mana = (int) armors[choice -1][4];
        //display which armor was chosen
        System.out.println("You have chosen " + arm + " with \nAttack: " + str + "\nAgility: " + agi +"\nDefense: " + def + "\nMana: " + mana);
        //returning STR enhancing
        hero.enhanceStats(str, agi, def, null, mana);
    }
 
}
