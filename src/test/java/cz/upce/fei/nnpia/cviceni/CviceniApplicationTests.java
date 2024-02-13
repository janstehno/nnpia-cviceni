package cz.upce.fei.nnpia.cviceni;

import cz.upce.fei.nnpia.cviceni.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CviceniApplicationTests {

    private final String greetings = "Greetings, traveler!";

    @Autowired
    InstanceAttributeController instanceAttributeController;

    @Autowired
    NonParametricConstructorController nonParametricConstructorController;

    @Autowired
    ParametricConstructorController parametricConstructorController;

    @Autowired
    SetParameterController setParameterController;

    @Test
    void NonParametricConstructorControllerTest() {
        assertEquals(nonParametricConstructorController.sayGreeting(), greetings);
    }

    @Test
    void ParametricConstructorControllerTest() {
        assertEquals(parametricConstructorController.sayGreeting(), greetings);
    }

    @Test
    void SetParameterControllerTest() {
        assertEquals(setParameterController.sayGreeting(), greetings);
    }

    @Test
    void InstanceAttributeTest() {
        assertEquals(instanceAttributeController.sayGreeting(), greetings);
    }

}
