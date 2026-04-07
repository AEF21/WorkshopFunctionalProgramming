package se.lexicon.service;

import se.lexicon.functional.Subscriber;
import se.lexicon.bussniess.SubscriberFilter;
import se.lexicon.bussniess.SubscriberAction;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriberProcessor {

    public List<Subscriber> findSubscribers(List<Subscriber> list, SubscriberFilter filter) {
        return list.stream()
                .filter(filter::matches)
                .collect(Collectors.toList());
    }

    public List<Subscriber> applyToMatching(List<Subscriber> list,
                                            SubscriberFilter filter,
                                            SubscriberAction action) {

        list.stream()
                .filter(filter::matches)
                .forEach(action::run);

        return list;
    }
}
