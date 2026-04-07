package se.lexicon.functional;
import java.util.List;

public class Main {
    static void main() {

        List<Subscriber> subscribers = List.of(
                new Subscriber(102,"elias.andersson@mail.se",Plan.Free, true),
                new Subscriber(101,"sara_tech@mail.com",Plan.Medium,true),
                new Subscriber(103,"johan.lind@outlook.com",Plan.Basic,false),
                new Subscriber(104,"dev_queen88@not.com",Plan.Medium,true),
                new Subscriber(105,"Markus.vlog@youtobe.com",Plan.Basic,true),
                new Subscriber(106,"info@foretaget.se",Plan.Medium,true),
                new Subscriber(107,"info@me.se", Plan.Free,true)
        );








    }
}
