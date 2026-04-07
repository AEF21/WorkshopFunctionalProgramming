package se.lexicon;


import java.util.concurrent.Flow;

@FunctionalInterface
public interface SubscriberAction {


    void run(Flow.Subscriber subscriber);
}
