package se.lexicon.service;

import se.lexicon.functional.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class SubscriberDAO {

    private final List<Subscriber> storage = new ArrayList<>();

    public void save(Subscriber subscriber) {
        storage.add(subscriber);
    }

    public List<Subscriber> findAll() {
        return new ArrayList<>(storage);
    }

    public Optional<Subscriber> findById(int id) {
        return storage.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    public abstract void update(Subscriber subscriber);

    public abstract void delete(int id);
}
