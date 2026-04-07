package se.lexicon.service;



import se.lexicon.SubscriberAction;
import se.lexicon.functional.Subscriber;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;

public class SubscriberProcessor {


        public List<Flow.Subscriber> findSubscribers(List<Flow.Subscriber> list, SubscriberFilter filter) {
            return list.stream()
                    .filter(filter::matches)
                    .collect(Collectors.toList());
        }

        public List<Subscriber> applyToMatching(List<Subscriber> list,
                                                SubscriberFilter filter,
                                                SubscriberAction action) {

            list.stream()
                    .filter(filter::matches)
                    .forEach(subscriber -> action.run((Flow.Subscriber) subscriber));

            return list;
        }
    }







