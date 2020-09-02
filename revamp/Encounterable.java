package revamp;

public abstract class Encounterable {
    abstract void prompt();

    String encounter()
    {
        prompt();

        String choice = Global.kb.nextLine().toLowerCase();

        switch(choice)
        {
            case "heal":
                Global.heal();
                encounter();
                break;
            case "stats":
                if (Global.singlePlayer != null)
                {
                    Global.singlePlayer.stats();
                }
                else
                {
                    System.err.println("null Global.singlePlayer in Encounterable.encounter()");
                }

                encounter();
                break;
            case "console":
                Global.console();
                break;
            case "fight":
            case "flee":
                break;
            default:
                Global.invalid();
                encounter();
                break;
        }

        return choice;
    }
}