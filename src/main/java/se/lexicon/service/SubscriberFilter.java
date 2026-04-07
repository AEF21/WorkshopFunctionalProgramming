package se.lexicon.service;

import java.util.concurrent.Flow;

@FunctionalInterface

public interface SubscriberFilter {
    matches(subscriber:Flow.Subscriber)
    return boolean;
}
