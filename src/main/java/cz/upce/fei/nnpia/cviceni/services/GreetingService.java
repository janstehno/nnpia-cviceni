package cz.upce.fei.nnpia.cviceni.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements GreetingServiceI {

    @Override
    public String sayGreeting() {
        return "Greetings, traveler!";
    }
}
