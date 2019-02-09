package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book by alphabetical order temporarily.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        
        List<Person> allPersons = addressBook.getAllPersons().mutableListView();

        Collections.sort(allPersons, new Comparator() {
            @Override
            public int compare(Object firstPerson, Object secondPerson) {
                String firstPersonName = ((Person) firstPerson).getName().toString();
                String secondPersonName = ((Person) secondPerson).getName().toString();
                return firstPersonName.compareTo(secondPersonName);
            }
        });
   
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}

