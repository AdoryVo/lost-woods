package revamp;

public abstract class Enemy extends Encounterable {
    String name;
    String fightDesc;
    int health;
    int strength;
    int potionsDropped;

    public Enemy(String name) {
        this.name = name;
        this.health = Global.rand.nextInt(5) + 8; // 8-12 HP
        this.strength = Global.rand.nextInt(3) + 2; // 2-4 Strength
        this.potionsDropped = Global.rand.nextInt(2) + 1; // 1-2 Potions
    }

    public Enemy(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.potionsDropped = Global.rand.nextInt(2) + 1; // 1-2 Potions
    }

    abstract void fight();

    void examine() {
        System.out.println("\n⨔╍╍╍╍╍🔎EXAMINE🔎╍╍╍╍╍⨔");
        System.out.printf("%s ￤ 💗: %d ￤ 💪: %d\n", name, health, strength);
    }

    void prompt(String description)
    {
        Global.pause();
        System.out.printf("\n⨔╍╍╍╍╍👿ENCOUNTER👿╍╍╍╍╍⨔\n%s\n\nWhat do you do? ⦗\"fight\", \"flee\"⦘ ⦑\"heal\", \"stats\"⦒\n", description);
    }

    String encounter()
    {
        String choice = super.encounter();
        System.out.println("choice");

        switch(choice)
        {
            case "fight":
                System.out.println(fightDesc);
                fight();
                break;
            case "flee":
                if (name == "Ganon" || name == "Hinox")
                {
                    System.out.println(fightDesc);
                    fight();
                    break;
                }
                else if (Global.singlePlayer != null)
                {
                    flee();
                }
                else
                {
                    System.err.println("null Global.singlePlayer in Enemy.encounter()");
                }
                break;
        }

        return choice;
    }

    void flee()
    {
        int hitRoll = Global.rand.nextInt(3);
		
		System.out.println("\n⨔╍╍╍╍╍💨FLEE💨╍╍╍╍╍⨔");
		
		if (hitRoll == 0)
		{
			System.out.printf("As you flee, the %s hits you in the back.\n", name);
			System.out.printf("You take %d damage.\n", strength);
            if (Global.singlePlayer != null)
            {
                Global.singlePlayer.health -= strength;
            }
            else
            {
                System.err.println("null Global.singlePlayer in Enemy.flee()");
            }
		}
		
		else
		{
			System.out.println("You make it out safely.");
		}
    }
}