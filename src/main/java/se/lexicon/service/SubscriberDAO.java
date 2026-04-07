package se.lexicon.service;

import se.lexicon.functional.Subscriber;

import java.util.List;
@FunctionalInterface
public interface SubscriberDAO {

    void save(Subscriber subscriber);        // create
    List<Subscriber> findAll();              // read
    Subscriber findById(int id);             // read
    void update(Subscriber subscriber);      // update
    void delete(int id);                     // delete





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
    }


