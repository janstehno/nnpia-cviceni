package cz.upce.fei.nnpia.cviceni.controllers;

import cz.upce.fei.nnpia.cviceni.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NonParametricConstructorController {
    private final GreetingService greetingService;

    @Autowired
    public NonParametricConstructorController() {
        greetingService = new GreetingService();
    }

    public String sayGreeting() {
        return this.greetingService.sayGreeting();
    }
}
