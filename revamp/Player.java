package revamp;

public class Player 
{
    int health;
    int maxHealth;
    int strength;
    int potionCount;
    int enemiesKilled;

    public Player() 
    {
        health = Global.rand.nextInt(6) + 5; // 5-10 HP
        maxHealth = health;
        strength = Global.rand.nextInt(4) + 2; // 2-5 Strength
        potionCount = Global.rand.nextInt(2) + 1; // 1-2 Potions
        enemiesKilled = 0;
    }

    /** 
	* Prints player stats.
	*/
	void stats()
	{
		System.out.println("\n⨔╍╍╍╍╍📊STATS📊╍╍╍╍╍⨔");
		System.out.printf("💗: %d/%d ￤ 💪: %d ￤ Potions: %d ￤ Kills: %d\n", health, maxHealth, strength, potionCount, enemiesKilled);
    }
}