

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Izymi
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(  QueryTests.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }

        System.out.println("Tests success: " + result.wasSuccessful());
        System.exit(0);
    }
}
