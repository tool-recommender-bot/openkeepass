package de.slackspace.openkeepass.filter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.slackspace.openkeepass.domain.Entry;

public class EntryFilterTest {

	@Test
	public void whenInputFilterIsMatchExactlyItShouldReturnMatchingEntries() {
		List<Entry> entries = createEntries();
		
		List<Entry> results = ListFilter.filter(entries, new Filter<Entry>() {
			public boolean matches(Entry item) {
				if(item.getTitle().equalsIgnoreCase("test")) {
					return true;
				}
				
				return false;
			};
		});
		
		Assert.assertEquals(1, results.size());
		Assert.assertEquals("test", results.get(0).getTitle());
	}
	
	private List<Entry> createEntries() {
		ArrayList<Entry> list = new ArrayList<Entry>();
		list.add(createEntry("test", "testPassword"));
		list.add(createEntry("My simple test case", "My simple test password"));
		list.add(createEntry("AAA BBB ccc", "aa bb CC"));

		return list;
	}

	private Entry createEntry(String title, String password) {
		Entry entry = new Entry(title);
		entry.setPassword(password);
		
		return entry;
	}
	
}
