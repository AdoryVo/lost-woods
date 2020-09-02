package revamp;

public class Mushroom extends Encounterable {
    public void prompt()
    {
        Global.pause();

        System.out.println("\n⨔╍╍╍╍╍🍄MUSHROOM🍄╍╍╍╍╍⨔");
		System.out.println("You come across a patch of mushrooms.\n\nDo you eat a mushroom? ⦗\"yes\", \"no\"⦘ ⦑\"heal\", \"stats\"⦒");
    }

    public String encounter()
    {
        prompt();

        return null;
    }
}