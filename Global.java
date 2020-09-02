import java.util.Random;
import java.util.Scanner;

abstract class Global
{
	static Random rand = new Random();
	static Scanner kb = new Scanner(System.in);
	
	// Player variables
	static int hp = rand.nextInt(6) + 5; // 5-10 HP
	static int maxHp = hp;
	static int ad = rand.nextInt(4) + 2; // 2-5 AD
	static int potion = rand.nextInt(2) + 1; // 1-2 potions
	static int enemiesKilled = 0;
	
	// Enemy variables
	static String name;
	static String encounter;
	static String fight;
	static String preattack;
	static int ehp;
	static int ead;
	static int item;
	
	static int duration = 2000;
	static boolean pauses = true;
	
	/** 
	* Pauses for 2 seconds if pauses are enabled.
	*/
	static void pause()
	{
		try
		{
			if (pauses)
			{
				Thread.sleep(duration);
				duration = 2000;
			}
		}
		
		catch (InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	
	/** 
	* Initializes enemy stats.
	* <p><b>Stat Range: </b>8-12 HP, 2-4 AD, 1-2 Items</p>
	*/
	static void enemy()
	{
		ehp = rand.nextInt(5) + 8;
		ead = rand.nextInt(3) + 2;
		item = rand.nextInt(2) + 1;
	}
	
	/** 
	* Prints "⚠️Invalid response!⚠️"
	*/
	static void invalid()
	{
		System.out.println("\n⚠️Invalid response!⚠️");
	}
	
	/** 
	* Prints player stats.
	*/
	static void stats()
	{
		System.out.println("\n⨔╍╍╍╍╍📊 STATS📊╍╍╍╍╍⨔");
		System.out.printf("💗 : %d/%d ￤ 💪 : %d ￤ Potions: %d ￤ Kills: %d\n", hp, maxHp, ad, potion, enemiesKilled);
	}
	
	/** 
	* Prints enemy stats.
	*/
	static void examine()
	{
		System.out.println("\n⨔╍╍╍╍╍🔎 EXAMINE🔎╍╍╍╍╍⨔");
		System.out.printf("%s ￤ 💗 : %d ￤ 💪 : %d\n", name, ehp, ead);
	}
	
	/** 
	* Prints attempt to drink potion.
	*/
	static void heal()
	{
		if (potion > 0 && hp != maxHp)
		{
			System.out.println("\n⨔╍╍╍╍╍💖 HEAL💖╍╍╍╍╍⨔");
			System.out.println("You drink a health potion.");
			
			if (hp + 5 > maxHp)
			{
				hp = maxHp;
				potion -= 1;
				System.out.printf("You have %d health now.\nYou have %d health potions left.\n", hp, potion);
			}
			
			else
			{
				hp += 5;
				potion -= 1;
				System.out.printf("You have %d health now.\nYou have %d health potions left.\n", hp, potion);
			}
		}
		
		else if (potion == 0)
		{
			System.out.println("\nYou don't have any health potions.");
		}
		
		else
		{
			System.out.println("\nYour health is full already.");
		}
	}

	/** 
	* Begins enemy encounter.
	*/
	static void encounter()
	{
		pause();
		
		enemy();
		System.out.println(encounter);
		String choice = kb.next().toLowerCase();
		
		if (choice.equals("heal"))
		{
			heal();
			encounter();
		}
		
		else if (choice.equals("stats"))
		{
			stats();
			encounter();
		}
		
		else if (choice.equals("run"))
		{
			if (name == "Hinox")
			{
				System.out.println("\nThe Hinox wakes up from your footsteps and blocks your path.");
				ehp = 200;
				ead += 2;
				item++;
				
				duration = 1000;
				pause();
				
				fight();
			}
			
			else if (name == "Forestblight Ganon")
			{
				System.out.println("\nThere is nowhere to run! The only option is to fight!");
				ehp = 1000;
				ead += 4;
				
				duration = 1000;
				pause();
				
				fight();
			}
			
			else
			{
				flee();
			}
		}
		
		else if (choice.equals("fight"))
		{
			if (name == "Bokoblin")
			{
				fight = "You decide to stand your ground. You pull out your sword.\n\nIn a Bokoblin fight, the Bokoblin attacks you and you must quickly dodge his attack in 4.5 seconds with a typed response.";
				fight();
			}
			
			else if (name == "Lizalfos")
			{
				ehp += 5;
				fight = "You decide to stand your ground. You pull out your sword.\n\nIn a Lizalfos fight, the Lizalfos defends himself and you must quickly attack him where he is vulnerable in 4.5 seconds with a typed response.";
				fight();
			}
			
			else if (name == "Hinox")
			{
				ehp = 200;
				ead += 2;
				item++;
				fight = "You decide to ready your bow.\n\nIn a Hinox fight, there are two repeated phases, you must first hit his eye with an arrow by typing x when the crosshairs are over its eye. While he is stunned by the arrow, you have 1.5 seconds in order to spam click enter to quickly slash him.";
				fight();
			}
			
			else if (name == "Forestblight Ganon")
			{
				ehp = 1000;
				ead += 4;
				potion += 2;
				fight = "You pick up two health potions that are behind you.\nYou decide to ready your Shiekah Slate's runes.\n\nIn this fight, there are two phases. While he is above half health, you must utilize your runes to deflect Ganon's attacks.";
				fight();
			}
		}
		
		else if (choice.equals("console"))
		{
			console();
		}
		
		else
		{
			invalid();
			encounter();
		}
	}

	/** 
	* Begins fight sequence.
	*/
	static void fight()
	{
		System.out.println("\n⨔╍╍╍╍╍⚔️ FIGHT⚔️╍╍╍╍╍⨔");
		System.out.println(fight);
		
		if (name.equals("Bokoblin"))
		{
			duration = 5000;
			
			while (ehp > 0 && hp > 0)
			{
				preattack();
				Bokoblin.action();
			}
		}
		
		else if (name.equals("Lizalfos"))
		{
			duration = 5000;
			
			while (ehp > 0 && hp > 0)
			{
				preattack();
				Lizalfos.action();
			}
		}
		
		else if (name.equals("Hinox"))
		{
			duration = 10000;
			
			while (ehp > 0 && hp > 0)
			{
				preattack();
				Hinox.arrow();
			}
		}
		
		
		else if (name.equals("Forestblight Ganon"))
		{
			duration = 10000;
			
			//ehp > 500 after done with second phase
			while (ehp > 0 && hp > 0)
			{
				preattack();
				Ganon.runes();
			}
			
			while (ehp > 0 && hp > 0)
			{
				
			}
		}
		
		if (ehp <= 0)
		{
			potion += item;
			enemiesKilled += 1;
			
			pause();
			System.out.println("\n⨔╍╍╍╍╍🏆 VICTORY🏆╍╍╍╍╍⨔");
			System.out.printf("You killed the %s.\nIt dropped %d potions! You now have %d potions.\nYou have killed %d enemies.\n\n", name, item, potion, enemiesKilled);
			duration = 6000;
			
			if (enemiesKilled == 10)
			{
				pause();
				System.out.println("\n\n⨔╍╍╍╍╍🏁 WIN🏁╍╍╍╍╍⨔");
				System.out.println("You found the exit! You retrieve the Master Sword from the Korok Forest!");
				System.exit(0);
			}
			
			System.out.printf("You need to kill %d more enemies to return home.\n", (10 - enemiesKilled));
		}
	}

	/** 
	* Prompts player for action.
	*/
	static void preattack()
	{
		pause();
		
		if (ehp < 6)
		{
			preattack = String.format("The %s is exhausted and injured.", name);
		}
		
		System.out.println("\n⨔╍╍╍╍╍💥 COMBAT💥╍╍╍╍╍⨔");
		System.out.printf("%s ⦗\"fight\"⦘ ⦑\"heal\", \"stats\", \"examine\"⦒\n", preattack);
		String choice = kb.next().toLowerCase();
		
		if (choice.equals("heal"))
		{
			heal();
			preattack();
		}
		
		else if (choice.equals("stats"))
		{
			stats();
			preattack();
		}
		
		else if (choice.equals("examine"))
		{
			examine();
			preattack();
		}
		
		else if (!choice.equals("fight"))
		{
			invalid();
			preattack();
		}
	}
	
	/** 
	* Rolls to flee battle.
	*/
	static void flee()
	{
		int dmgRoll = rand.nextInt(3);
		
		System.out.println("\n⨔╍╍╍╍╍💨 FLEE💨╍╍╍╍╍⨔");
		
		if (dmgRoll == 0)
		{
			System.out.printf("As you turn to run, the %s hits you in the back.\n", name);
			System.out.printf("You take %d damage.\n", ead);
			hp -= ead;
		}
		
		else
		{
			System.out.println("You make it out safely.");
		}
	}
	
	/** 
	* Opens admin console.
	*/
	static void console()
	{
		/* 
		Console Commands
		
		boko - begin Bokoblin encounter
		lizal - begin Lizalfos encounter
		mush - begin Mushroom event
		hinox - begin Hinox encounter
		ganon - begin Ganon encounter
		
		sethp - set amount of HP
		setpotion - set amount of potions
		setad - set amount of AD
		setkills - change number of enemies killed
		pause - toggles pauses on/off
		*/
		
		System.out.println("\n⨔╍╍╍╍╍💻 CONSOLE💻╍╍╍╍╍⨔");
		System.out.println("Hello developer, enter a command. (Command explanations in Global.java, Line 227)\n⦗\"boko\", \"lizal\", \"mush\", \"hinox\", \"ganon\"⦘ ⦑\"heal\", \"stats\", \"sethp\", \"setpotion\", \"setad\", \"setkills\", \"pause\"⦒");
		String choice = kb.next().toLowerCase();
		
		if (choice.equals("boko"))
		{
			name = "Bokoblin";
			preattack = "The Bokoblin holds his club ready to attack.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear rustling in the bushes.\nA Bokoblin walks out of a bush.\n\nWhat do you do? ⦗\"fight\", \"run\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (choice.equals("lizal"))
		{
			name = "Lizalfos";
			preattack = "The Lizalfos holds his shield up.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear a screech coming from above.\nA Lizalfos jumps down from the trees.\n\nWhat do you do? ⦗\"fight\", \"run\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (choice.equals("mush"))
		{
			Mushroom.mushroom();
		}
		
		else if (choice.equals("hinox"))
		{
			name = "Hinox";
			preattack = "The Hinox stumbles around angrily.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear a snoring sound.\nYou stumble upon a giant Hinox sleeping in a forest field clearing.\n\nWhat do you do? ⦗\"fight\", \"run\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (choice.equals("ganon"))
		{
			name = "Forestblight Ganon";
			preattack = "Forestblight Ganon is charging his attack.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear a loud roar.\nYou fall through a pit into a large cavern where Forestblight Ganon awaits you.\n\nWhat do you do? ⦗\"fight\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (choice.equals("heal"))
		{
			heal();
			console();
		}
		
		else if (choice.equals("stats"))
		{
			stats();
			console();
		}
		
		else if (choice.equals("sethp"))
		{
			set("HP");
			console();
		}
		
		else if (choice.equals("setpotion"))
		{
			set("Potions");
			console();
		}
		
		else if (choice.equals("setad"))
		{
			set("AD");
			console();
		}
		
		else if (choice.equals("setkills"))
		{
			set("enemies killed");
			console();
		}
		
		else if (choice.equals("pause"))
		{
			pauses = !pauses;
			
			if (!pauses)
			{
			System.out.println("\nPauses are now toggled off.");
			}
			
			else
			{
				System.out.println("\nPauses are now toggled on.");
			}
			
			console();
		}
		
		else
		{
			invalid();
			console();
		}
	}
	
	/** 
	* Sets a specified stat.
	*
	* @param stat stat to change
	*/
	static void set(String stat)
	{
		try
		{
			System.out.printf("\nEnter amount of %s: \n", stat);
			int input = kb.nextInt();
			
			if (stat.equals("HP") && input > 0)
			{
				maxHp = input;
				hp = input;
				System.out.printf("\n💕 MAX HP = %d💕\n💗 HP = %d💗\n", maxHp, hp);
			}
			
			else if (stat.equals("Potions") && input >= 0)
			{
				potion = input;
				System.out.printf("\nPotions = %d\n", potion);
			}
			
			else if (stat.equals("AD") && input >= 0)
			{
				ad = input;
				System.out.printf("\n💪 AD = %d💪\n", ad);
			}
			
			else if (stat.equals("enemies killed") && input < 10)
			{
				enemiesKilled = input;
				System.out.printf("\nEnemies killed = %d\n", enemiesKilled);
			}
			
			else
			{
				invalid();
				set(stat);
			}
		}
		
		catch (Exception e)
		{
			kb.nextLine();
			invalid();
			set(stat);
		}
	}
}