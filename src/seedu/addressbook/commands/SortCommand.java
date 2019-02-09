package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book by alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

        Collections.sort(allPersons, new Comparator() {
            @Override
            public int compare(Object firstReadOnlyPerson, Object secondReadOnlyPerson) {
                String firstPersonName = ((ReadOnlyPerson) firstReadOnlyPerson).getName().toString();
                String secondPersonName = ((ReadOnlyPerson) secondReadOnlyPerson).getName().toString();
                return firstPersonName.compareTo(secondPersonName);
               
            }
        });
        
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}

