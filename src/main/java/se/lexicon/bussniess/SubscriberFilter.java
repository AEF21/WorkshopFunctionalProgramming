package se.lexicon.bussniess;

import se.lexicon.functional.Subscriber;

@FunctionalInterface

public interface SubscriberFilter {


        boolean matches(Subscriber subscriber);
    }


