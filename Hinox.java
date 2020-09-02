public class Hinox extends Global
{
	public static void arrow()
	{
		String[] view = {" ", " ", " ", "ᕙ", "(", " ", "(", "⨀", ")", " ", ")", "ᕗ", " ", " ", " "};
		int hitmarker = 0;
		String previous = " ";
		
		if (rand.nextInt(2) == 0)
		{
			hitmarker = 14;
		}
		
		System.out.println("\n⨔╍╍╍╍╍➳ PHASE 1: SHOOT➳╍╍╍╍╍⨔");
		System.out.println("To shoot the arrow, Type x once the cross hairs are over his eye. Type anything to begin combat.");
		kb.nextLine();
		kb.nextLine();
		
		while (true)
		{
			if (hitmarker < 7)
			{
				view[hitmarker] = previous;
				previous = view[hitmarker + 1];
				view[hitmarker + 1] = "❌";
				hitmarker++;
			System.out.println("\n              Hinox");
			}
			
			else if (hitmarker > 7)
			{
				view[hitmarker] = previous;
				previous = view[hitmarker - 1];
				view[hitmarker - 1] = "❌";
				hitmarker--;
				System.out.println("\n             Hinox");
			}
			
			System.out.println(String.join(" ", view));

			if (hitmarker == 7)
			{
				System.out.println("\nQuick! Type x to shoot!");
				
				long endTime = System.currentTimeMillis() + 500L;
				String fightChoice = kb.next().toLowerCase();
				System.out.print("\n");
				
				if (endTime < System.currentTimeMillis())
				{
					System.out.printf("You were too slow! The Hinox moved and hits you for %d damage.\n", ead);
					hp -= ead;
					break;
				}
				
				else if (fightChoice.equals("x"))
				{
					System.out.println("You shoot the Hinox in the eye for 20 damage.");
					ehp -= 20;
					
					if (!(ehp <= 0))
					{
						preattack = "The Hinox lies on the ground stunned.";
						preattack();
						sword();
						break; 
					}
				}
			}
			
			else
			{
				try
				{
					Thread.sleep(500);
				}
				
				catch (InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
			}
		}
	}
	
	public static void sword()
	{
		String[] hpbar = {"⦕", "￤", "￤", "￤", "￤", "￤", "￤", "￤", "￤", "￤", "⦖"};
		int hitmarker = 10;
		
		System.out.println("\n⨔╍╍╍╍╍⚔ PHASE 2: SLASH⚔╍╍╍╍╍⨔");
		System.out.println("To slash, spam enter to reduce the Hinox's health bar. Type anything to begin combat.\n");
		kb.nextLine();
		kb.nextLine();
		
		long endTime = System.currentTimeMillis() + 1500L;
		String spaces = "";
		
		while (System.currentTimeMillis() < endTime && hitmarker > 0)
		{
			System.out.println("              HP");
			System.out.println(spaces + String.join(" ", hpbar).trim());
			
			if (kb.nextLine().equals(""))
			{
				hpbar[hitmarker] = " ";
				hpbar[hitmarker - 1] = "⦖";
				hitmarker--;
				spaces = spaces + "  ";
			}
		}
		
		System.out.printf("\nYou slash the Hinox for %d damage.\n", (10 - hitmarker) * 3);
		ehp -= (10 - hitmarker) * 3;
		
		preattack = "The Hinox stumbles around angrily.";
	}
}