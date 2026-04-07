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




}

