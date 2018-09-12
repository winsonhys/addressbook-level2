package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;

import java.util.Comparator;

public class SortCommand extends Command {

    private String args;

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort.\n"
            + "Example: " + COMMAND_WORD;

    public SortCommand(String args) {
        this.args = args.trim();
    }

    @Override
    public CommandResult execute() {
        String message;
        switch (this.args) {
            case "name":
                this.sortAddressBookByName();
                message = "Sorted by name";
                break;
            default:
                message = "Invalid sort field";
        }
        return new CommandResult(message);
    }

    private void sortAddressBookByName() {
        addressBook.sort( new Comparator<> () {
            public int compare(Person a, Person b) {
                int comparisonResult = a.getName().toString().compareTo(b.getName().toString());
                return comparisonResult;
            }
        });
    }
}