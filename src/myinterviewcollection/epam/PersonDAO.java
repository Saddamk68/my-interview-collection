/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterviewcollection.epam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 *
 * @author Saddam Khan
 */
public class PersonDAO {
    
    private Map<Integer, Person> cache;
    private Map<Integer, Person> placeholderCache;

    public PersonDAO() {
        cache = new ConcurrentHashMap<>();
        placeholderCache = new HashMap<>();
    }

    public Person getById(int id) {
        Person person = cache.get(id);
        if (person == null) {
            // Placeholder logic to simulate data retrieval from a database
            person = placeholderCache.get(id);
            if (person != null) {
                cache.put(id, person);
            }
        }
        return person;
    }

    public void addOrUpdate(Person person) {
        cache.put(person.getId(), person);
    }

    public void removeFromCache(int id) {
        cache.remove(id);
    }

    public void clearCache() {
        cache.clear();
    }

    public List<Person> getPersonsByIds(List<Integer> ids) {
        return ids.stream()
                .map(this::getById)
                .collect(Collectors.toList());
    }
    
}
