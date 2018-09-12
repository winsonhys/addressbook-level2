package seedu.addressbook.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TestUtil;

import java.util.Collections;
import java.util.List;

public class SortCommandTest {


    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), Collections.emptySet());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), Collections.emptySet());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), Collections.emptySet());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                Collections.emptySet());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
    }

    @Test
    public void correctlySort() {
        Command sort = new SortCommand("name");
        sort.setData(addressBook, emptyAddressBook.getAllPersons().immutableListView());
        String initial = sort.addressBook.getAllPersons().immutableListView().get(0).getName().fullName;
        sort.execute();
        String after = sort.addressBook.getAllPersons().immutableListView().get(0).getName().fullName;
        Assert.assertFalse(initial.equals(after));

    }
}
