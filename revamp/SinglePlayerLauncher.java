package revamp;

public class SinglePlayerLauncher 
{
    public static void main(String[] args) 
    {
        Player player = new Player();
        Global.singlePlayer = player;

        // Intro sequence
        System.out.println("🌲 You are lost inside the Lost Woods with deadly enemies and strange plants!\n");
        System.out.println("🚩 Kill 10 enemies to escape.\n");
        System.out.printf("📊 You have %d health, %d strength, and %d health potions which heal 5 health each.\n\n",
                player.health, player.strength, player.potionCount);
        System.out.println(
                "⦑Side Actions⦒ When prompted, you can type \"heal\" in order to drink a health potion, or type \"stats\" to see your stats. During combat, you can type \"examine\" to see enemy stats.");
        Global.pause(5000);

        // Encounter loop
        while (player.health > 0 && player.enemiesKilled < 10)
        {
            Global.pause();
			System.out.println("\n⨔╍╍╍╍╍👣ACTION👣╍╍╍╍╍⨔");
            System.out.println("You walk further down the path.");
            Global.pause(500);
            encounterRoll(player.enemiesKilled);
        }

        if (player.health <= 0)
        {
            Global.pause();
            System.out.println("\n⨔╍╍╍╍╍💀GAME OVER💀╍╍╍╍╍⨔");
			System.out.println("Your health has reached 0. You have been defeated.");
        }

        else
        {
            Global.pause();
            System.out.println("\n\n⨔╍╍╍╍╍🏁WIN🏁╍╍╍╍╍⨔");
			System.out.println("You find and retrieve the Master Sword from the Korok Forest to escape!");
        }
    }

    public static void encounterRoll(int enemiesKilled)
	{ 
		
		int roll = Global.rand.nextInt(6); // [0, 5] Domain
        
        switch(enemiesKilled)
        {
            case 5:
                Hinox hinox = new Hinox();
                hinox.encounter();
                break;
            case 9:
                Ganon ganon = new Ganon();
                ganon.encounter();
                break;
        }

        switch(roll)
        {
            case 0:
            case 1:
                Bokoblin bokoblin = new Bokoblin();
                bokoblin.encounter();
                break;
            case 2:
            case 3:
                Lizalfos lizalfos = new Lizalfos();
                lizalfos.encounter();
                break;
            case 4:
            case 5:
                Mushroom mushroom = new Mushroom();
                mushroom.encounter();
                break;
        }
	}
}