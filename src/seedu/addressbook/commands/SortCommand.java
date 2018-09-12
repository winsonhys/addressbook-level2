package seedu.addressbook.commands;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        return new CommandResult("Lawl");
    }
}