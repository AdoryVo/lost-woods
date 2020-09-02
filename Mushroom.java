public class Mushroom extends Global
{
	public static void mushroom()
	{
		int effect = rand.nextInt(3);
		
		pause();
		
		System.out.println("\n⨔╍╍╍╍╍🍄 MUSHROOM🍄╍╍╍╍╍⨔");
		System.out.println("You come across a patch of mushrooms.\n\nDo you eat a mushroom? ⦗\"yes\", \"no\"⦘ ⦑\"heal\", \"stats\"⦒");
		String choice = kb.next().toLowerCase();
		
		if (choice.equals("heal"))
		{
			heal();
			mushroom();
		}
		
		else if (choice.equals("stats"))
		{
			stats();
			mushroom();
		}
		
		else if (choice.equals("console"))
		{
			console();
		}
		
		else if (choice.equals("yes"))
		{
			System.out.println("\nYou decide to eat a mushroom.");
			
			if (effect == 0)
			{
				System.out.println("You feel strength returning to you.\n\n💪AD + 2💪");
				ad += 2;
				System.out.printf("Your AD is now %d.\n", ad);
			}
			
			else if (effect == 1)
			{
				System.out.println("You feel rejuvenated.\n");
				
				if (hp == maxHp)
				{
					maxHp += 2;
					System.out.printf("💕 MAX HP + 2💕\nYour MAX HP is now %d.\n", maxHp);
				}
				
				else if (hp + 5 > maxHp)
				{
					System.out.printf("💗 HP + %d💗\nYour HP is now full.\n", maxHp - hp);
					hp = maxHp;
				}
				
				else
				{
					System.out.println("💗 HP + 5💗");
					hp += 5;
					System.out.printf("Your hp is now %d.\n", hp);
				}
			}
			
			else
			{
				int poison = rand.nextInt(2) + 3;
				hp -= poison;
				System.out.printf("You feel the mushroom eating you from the inside out.\n☠️ HP - %d☠️", poison);
				
				if (hp > 0)
				{
					System.out.printf("Your HP is now %d.\n", hp);
				}
			}
		}
		
		else if (choice.equals("no"))
		{
			System.out.println("\nYou decide not to risk it and skip the mushroom.");
		}
		
		else
		{
			invalid();
			mushroom();
		}
	}
}
				