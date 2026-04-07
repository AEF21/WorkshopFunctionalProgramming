package se.lexicon.service;

import se.lexicon.functional.Subscriber;

import java.util.concurrent.Flow;

@FunctionalInterface

public interface SubscriberFilter {


        boolean matches(Subscriber subscriber);
    }


