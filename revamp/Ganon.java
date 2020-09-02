package revamp;

public class Ganon extends Enemy {
    public Ganon()
    {
        super("Ganon", 1000, 7);
    }

    public void prompt()
    {
        prompt("As you are walking, you hear a loud roar.\nYou fall through a pit into a large cavern where Forestblight Ganon awaits you.");
    }

    public void fight()
    {

    }
}