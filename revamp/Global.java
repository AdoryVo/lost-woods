package revamp;

import java.util.Random;
import java.util.Scanner;

public class Global {
    static Player singlePlayer = null;

    // Helper objects
    static Random rand = new Random();
    static Scanner kb = new Scanner(System.in);

    // Pause variables
    /**
     * Default pause duration in milliseconds.
     */
    static final int DEFAULT_PAUSE_DURATION = 2000;
    static boolean pausesOn = true;

    /**
     * If pauses are enabled, pauses for specified duration.
     *
     * @param duration the duration of the pause
     */
    static void pause(int duration) {
        try {
            if (pausesOn) {
                Thread.sleep(duration);
            }
        }

        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Pauses for the default pause duration
     */
    static void pause() {
        pause(DEFAULT_PAUSE_DURATION);
    }

    /**
     * Prints "⚠️Invalid response!⚠️"
     */
    static void invalid() {
        System.out.println("\n⚠️Invalid response!⚠️");
    }

    static void heal(Player player) {
        if (player.potionCount > 0 && player.health < player.maxHealth) {
            System.out.println("\n⨔╍╍╍╍╍💖HEAL💖╍╍╍╍╍⨔");
            System.out.println("You drink a health potion.");

            if (player.health + 5 > player.maxHealth) {
                player.health = player.maxHealth;
                player.potionCount--;
                System.out.printf("You have %d health now.\nYou have %d health potions left.\n", player.health,
                        player.potionCount);
            }

            else {
                player.health += 5;
                player.potionCount--;
                System.out.printf("You have %d health now.\nYou have %d health potions left.\n", player.health,
                        player.potionCount);
            }
        }

        else if (player.potionCount == 0) {
            System.out.println("\nYou don't have any health potions.");
        }

        else if (player.health == player.maxHealth) {
            System.out.println("\nYour health is full already.");
        }
    }

    static void heal() {
        if (singlePlayer != null) {
            heal(singlePlayer);
        } else {
            System.err.println("null Global.singlePlayer in Global.heal()");
        }
    }

    /**
     * Console Commands
     * 
     * boko - begin Bokoblin encounter 
     * lizal - begin Lizalfos encounter 
     * mush - begin
     * Mushroom event 
     * hinox - begin Hinox encounter 
     * ganon - begin Ganon encounter
     * 
     * setHealth - set amount of health
     * setPotionCount - set amount of potions 
     * setStrength - set amount of strength
     * setKills - change number of enemies killed 
     * togglePause - toggles pauses on/off
     */
    static void console() {
        if (singlePlayer != null) {
            System.out.println("\n⨔╍╍╍╍╍💻CONSOLE💻╍╍╍╍╍⨔");
            System.out.println("Hello developer, enter a command. (Command explanations in Global.java)");
            System.out.println("⦗\"boko\", \"lizal\", \"mush\", \"hinox\", \"ganon\"⦘ ⦑\"heal\", \"stats\", \"setHealth\", \"setPotionCount\", \"setStrength\", \"setKills\", \"togglePause\"⦒");
            
            String choice = kb.next().toLowerCase();

            switch(choice)
            {
                case "boko":
                    Bokoblin bokoblin = new Bokoblin();
                    bokoblin.encounter();
                    break;
                case "lizal":
                    Lizalfos lizalfos = new Lizalfos();
                    lizalfos.encounter();
                    break;
                case "mush":
                    Mushroom mushroom = new Mushroom();
                    mushroom.encounter();
                    break;
                case "hinox":
                    Hinox hinox = new Hinox();
                    hinox.encounter();
                    break;
                case "ganon":
                    Ganon ganon = new Ganon();
                    ganon.encounter();
                    break;
                case "heal":
                    Global.heal();
                    console();
                    break;
                case "stats":
                    if (singlePlayer != null)
                    {
                        singlePlayer.stats();
                    }
                    console();
                    break;
                case "sethealth":
                    set("health");
                    console();
                    break;
                case "setpotioncount":
                    set("potionCount");
                    console();
                    break;
                case "setstrength":
                    set("strength");
                    console();
                    break;
                case "setkills":
                    set("enemiesKilled");
                    console();
                    break;
                case "togglepause":
                    pausesOn = !pausesOn;
                    System.out.printf("\nPauses are now toggled %s.", pausesOn ? "on" : "off");
                    break;
                default:
                    invalid();
                    console();
            }
        }
    }

    static void set(String stat)
    {
        try
		{
            if (singlePlayer != null)
            {
                System.out.printf("\nEnter amount of %s: \n", stat);
                int input = kb.nextInt();
                
                if (stat.equals("health") && input > 0)
                {
                    singlePlayer.health = input;
                    singlePlayer.maxHealth = input;
                    System.out.printf("\n💕Max Health = %d💕\n💗Health = %d💗\n", singlePlayer.maxHealth, singlePlayer.health);
                }
                
                else if (stat.equals("potionCount") && input >= 0)
                {
                    singlePlayer.potionCount = input;
                    System.out.printf("\nPotions = %d\n", singlePlayer.potionCount);
                }
                
                else if (stat.equals("strength") && input >= 0)
                {
                    singlePlayer.strength = input;
                    System.out.printf("\n💪Strength = %d💪\n", singlePlayer.strength);
                }
                
                else if (stat.equals("enemiesKilled") && input < 10)
                {
                    singlePlayer.enemiesKilled = input;
                    System.out.printf("\nEnemies Killed = %d\n", singlePlayer.enemiesKilled);
                }
                
                else
                {
                    invalid();
                    set(stat);
                }
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