package a.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary {

	private Map<String, String> map = new HashMap<String, String>();

	public void add(String entry, String definition) throws DictionaryException {
		if (entry == null || entry.equals("")) {
			throw new DictionaryException("add failed. null or empty entry");
		}
		if (definition == null || definition.equals("")) {
			throw new DictionaryException("add failed. null or empty definition");
		}
		if (map.containsKey(entry)) {
			throw new DictionaryException("add failed. the entry " + entry + " already exist");
		}
		map.put(entry, definition);
	}

	public String getDefinition(String entry) {
		return map.get(entry);
	}

	public void editEntry(String entry, String newDefinition) throws DictionaryException {
		if (!map.containsKey(entry)) {
			throw new DictionaryException("editEntry failed. the entry " + entry + " not found");
		}

		map.put(entry, newDefinition);
	}

	public void deleteEntry(String entry) {
		map.remove(entry);
	}

	public Set<String> getAllEnriesSorted() {
		return new TreeSet<>(map.keySet());
	}

}
