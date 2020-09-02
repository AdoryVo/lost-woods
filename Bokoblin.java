public class Bokoblin extends Global
{
	public static void action()
	{
		String[] actions = {"jump", "backup", "duck"};
		String[] spots = {"legs", "torso", "head"};
		
		int index = rand.nextInt(3);
		int bonus = index;
		int critdmg = 0;
		String hit = "normal";
		
		if (rand.nextInt(4) == 0)
		{
			hit = "🌟CRITICAL🌟";
			critdmg = rand.nextInt(2) + 2;
		}
		
		System.out.printf("\nThe Bokoblin attacks your %s.\nQuick! How do you dodge? ⦗\"duck\", \"backup\", \"jump\"⦘\n", spots[index].toUpperCase());
		
		long endTime = System.currentTimeMillis() + 4500L;
		String fightChoice = kb.next().toLowerCase();
		System.out.print("\n");
		
		if (endTime < System.currentTimeMillis())
		{
			System.out.printf("You were too slow! The Bokoblin hits your %s with a %s hit.", spots[index], hit);
			System.out.printf("You take %d damage.\n", ead + critdmg + bonus);
			hp -= ead + critdmg + bonus;
		}
		
		else if (fightChoice.equals(actions[index]))
		{	
			System.out.printf("You dodge and land a hit on the Bokoblin with a %s strike.\n", hit);
			System.out.printf("You deal %d damage.\n", ad + critdmg);
			ehp -= ad + critdmg;
		}
		
		else
		{
			System.out.printf("You failed to dodge his attack! The Bokoblin hits your %s with a %s hit.\n", spots[index], hit);
			System.out.printf("You take %d damage.\n", ead + critdmg + bonus);
			hp -= ead + critdmg + bonus;
		}
	}
}