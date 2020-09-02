public class Lizalfos extends Global
{
	public static void action()
	{
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
		
		System.out.printf("\nThe Lizalfos blocks his %s.\nQuick! Where do you attack? ⦗\"head\", \"torso\", \"legs\"⦘\n", spots[index].toUpperCase());
	
		long endTime = System.currentTimeMillis() + 4500L;
		String fightChoice = kb.next().toLowerCase();
		System.out.print("\n");
	
		if (endTime < System.currentTimeMillis())
		{
			System.out.printf("You were too slow! The Lizalfos dodges and lands a %s hit.\n", hit);
			System.out.printf("You take %d damage.\n", ead + critdmg);
			hp -= ead + critdmg;	
		}
		
		else if (!fightChoice.equals(spots[index]))
		{
			System.out.printf("You land a hit on his %s with a %s strike.\n", fightChoice, hit);
			System.out.printf("You deal %d damage.\n", ad + critdmg + bonus);
			ehp -= ad + critdmg + bonus;
		}
		
		else
		{
			System.out.printf("The Lizalfos blocks it and retaliates with a %s strike.\n", hit);
			System.out.printf("You take %d damage.\n", ead + critdmg);
			hp -= ead + critdmg;
		}
	}
}