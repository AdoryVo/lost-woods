public class Ganon extends Global
{
	/* Forestblight Ganon */
	
	public static void runes()
	{
		String[] runes = {"bomb", "magnesis", "cryonis"};
		String[] scenarios = {"launches a ROCK BOULDER at you.", "hurls a METAL SPIKE at you.", "hurls an ICE SPHERE at you."};
		int turn = 0;
		
		System.out.println("\n⨔╍╍╍╍╍💠 PHASE 1: RUNE💠╍╍╍╍╍⨔");
		System.out.println("There are four runes: Bomb, Magnesis, Stasis, and Cryonis. Bomb is used to destroy rocks. Magnesis is used to manipulate metal objects. Stasis is used to freeze incoming objects, allowing you 5 more seconds to type your response. Cryonis is used to manipulate ice objects. You will have to type three runes in order to stop Ganon's attacks. Type anything to begin combat.");
		kb.nextLine();
		kb.nextLine();
		
		while (ehp > 0 && hp > 0 && turn < 3)
		{
			int index = rand.nextInt(3);
			
			System.out.printf("\nGanon %s Quick! Use a rune to stop it! (\"bomb\", \"magnesis\", \"stasis\", \"cryonis\")\n", scenarios[index]);
			
			long endTime = System.currentTimeMillis() + 7500L;
			String fightChoice = kb.next().toLowerCase();
			System.out.print("\n");
			
			if (fightChoice.equals("stasis"))
			{
				endTime += 5000L;
				System.out.println("You froze his attack, now quickly deflect it with the right rune! (\"bomb\", \"magnesis\", \"cryonis\")");
				fightChoice = kb.next().toLowerCase();
			}
			
			if (endTime < System.currentTimeMillis())
			{
				System.out.printf("You were too slow! Ganon's attack hits you for %d damage.\n", ead);
				hp -= ead;
				turn++;
			}
			
			else if (fightChoice.equals(runes[index]))
			{
				System.out.println("You interrupt his attack and shoot him in the eye with a light arrow for 100 damage.");
				ehp -= 100;
				turn++;
			}
			
			else
			{
				System.out.printf("You failed to interrupt his attack! Ganon's attack hits you for %d damage.\n", ead);
				hp -= ead;
				turn++;
			}
		}
	}
}