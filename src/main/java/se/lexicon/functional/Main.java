package se.lexicon.functional;

import se.lexicon.bussniess.SubscriberAction;
import se.lexicon.bussniess.SubscriberFilter;
import se.lexicon.service.SubscriberDAO;
import se.lexicon.service.SubscriberProcessor;

import java.util.List;
import java.util.concurrent.Flow;

public abstract class Main {

    public static void main(String[] args) {

        SubscriberDAO dao = new SubscriberDAO() {
            @Override
            public void update(Subscriber subscriber) {
                
            }

            @Override
            public void delete(int id) {

            }
        };
        SubscriberProcessor processor = new SubscriberProcessor();

        dao.save(new Subscriber(102, "elias.andersson@mail.se", Plan.Free, true, 1));
        dao.save(new Subscriber(101, "sara_tech@mail.com", Plan.Medium, true, 3));
        dao.save(new Subscriber(103, "johan.lind@outlook.com", Plan.Basic, false, 0));
        dao.save(new Subscriber(104, "dev_queen88@not.com", Plan.Medium, true, 1));
        dao.save(new Subscriber(105, "Markus.vlog@youtobe.com", Plan.Basic, true, 12));
        dao.save(new Subscriber(106, "info@foretaget.se", Plan.Medium, true, 0));

        List<Subscriber> all = dao.findAll();

        SubscriberFilter active = s -> s.isActive();
        SubscriberFilter expiring = s -> s.getMonthsRemaining() <= 1;
        SubscriberFilter paying = s -> s.getPlan() == Plan.Basic || s.getPlan() == Plan.Medium;

        SubscriberAction extend = Main::run;
        SubscriberAction deactivate = Main::run2;

        System.out.println("=== Active Subscribers ===");
        processor.findSubscribers(all, active).forEach(System.out::println);

        System.out.println("\n=== Expiring Subscribers ===");
        processor.findSubscribers(all, expiring).forEach(System.out::println);

        System.out.println("\n=== Extend Paying Expiring Subscribers ===");
        processor.applyToMatching(all, s -> paying.matches(s) && expiring.matches(s), extend);
        all.forEach(System.out::println);

        System.out.println("\n=== Deactivate Expired Free Subscribers ===");
        processor.applyToMatching(all,
                s -> s.getPlan() == Plan.Free && s.getMonthsRemaining() == 0,
                deactivate);
        all.forEach(System.out::println);
    }

    private static void run(Flow.Subscriber s) {
        s.toString(s.getMonthsRemaining() + 3);
    }

    private static void run2(Flow.Subscriber s) {
        s.setActive(false);
    }
}
