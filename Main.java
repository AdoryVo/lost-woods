public class Main extends Global
{
	/* 
	LOST WOODS
	A text adventure based on The Legend of Zelda: Breath of the Wild by @AdoryVo and @Parabola
	HOW TO PLAY: Click run at the top of the screen and use the console to input responses.
	TESTING / DEVELOPMENT: Type console as an action/command once the game begins.
	*/

	/* 
	Future Additions
	- phase 2 of Ganon fight
	- use bar of several hearts to indicate health like in the actual game
	- add if statements to fix plural grammar
	- separate strings' sentences to make easier to edit
	- more console features
		- change enemy stats
		- begin new game
	- varied Hinox damage based on player AD
	- in battle coding, organize and simplify output calculations
	- reword/rewrite sentences using better grammar, explanations, and vocabulary
	- colored text?
	- use switch for if-statements
	*/
	
	public static void main(String[] args)
	{
		System.out.println("🌿 You are lost inside the Lost Woods with deadly enemies and strange plants!\n");
		System.out.println("🚩 Kill 10 enemies to escape.\n");
		System.out.printf("📊 You have %d health, %d attack damage, and %d health potions which heal 5 health each.\n", hp, ad, potion);
		System.out.println("\n⦑Side Actions⦒ Once prompted, you can type \"heal\" in order to drink a health potion, or type \"stats\" to see your stats. During combat, you can type \"examine\" to see enemy stats.");
		duration = 7500;
		
		while (hp > 0 && enemiesKilled != 10)
		{
			pause();
			System.out.println("\n⨔╍╍╍╍╍👣 ACTION👣╍╍╍╍╍⨔");
			System.out.println("You walk further down the path.");
			duration = 500;
			pause();
			happen();
		}
		
		if (hp <= 0)
		{
			pause();
			System.out.println("\n⨔╍╍╍╍╍💀 GAME OVER💀╍╍╍╍╍⨔");
			System.out.println("Your health has reached 0. You have been defeated.");
		}
		
		else
		{
			pause();
			System.out.println("\n\n⨔╍╍╍╍╍🏁 WIN🏁╍╍╍╍╍⨔");
			System.out.println("You found the exit! You retrieve the Master Sword from the Korok Forest!");
			System.exit(0);
		}
	}
	
	public static void happen()
	{ 
		
		int happen = rand.nextInt(6);
		
		if (enemiesKilled == 9)
		{
			name = "Forestblight Ganon";
			preattack = "Forestblight Ganon is charging his attack.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear a loud roar.\nYou fall through a pit into a large cavern where Forestblight Ganon awaits you.\n\nWhat do you do? ⦗\"fight\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (enemiesKilled == 5)
		{
			name = "Hinox";
			preattack = "The Hinox stumbles around angrily.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear a snoring sound.\nYou stumble upon a giant Hinox sleeping in a forest field clearing.\n\nWhat do you do? ⦗\"fight\", \"run\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (happen == 0 || happen == 1)
		{
			name = "Bokoblin";
			preattack = "The Bokoblin holds his club ready to attack.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear rustling in the bushes.\nA Bokoblin walks out of a bush.\n\nWhat do you do? ⦗\"fight\", \"run\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (happen == 2 || happen == 3)
		{
			name = "Lizalfos";
			preattack = "The Lizalfos holds his shield up.";
			encounter = "\n⨔╍╍╍╍╍👿 ENCOUNTER👿╍╍╍╍╍⨔\nAs you are walking, you hear a screech coming from above.\nA Lizalfos jumps down from the trees.\n\nWhat do you do? ⦗\"fight\", \"run\"⦘ ⦑\"heal\", \"stats\"⦒";
			encounter();
		}
		
		else if (happen == 4 || happen == 5)
		{
			Mushroom.mushroom();
		}
	}
}