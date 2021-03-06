package cuke4duke.junit;

import cuke4duke.annotation.I18n.EN.*;
import cuke4duke.Table;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JunitCukeSteps {
    private final Map<String,Integer> cukes = new HashMap<String,Integer>();

    @Given("I have (\\d+) (.*) cukes")
    public void iHaveNCukes(int n, String color) {
        this.cukes.put(color, n);
    }

    @Then("I should have (\\d+) (.*) cukes")
    public void iShouldHaveNCukes(int n, String color) {
        int cukesOfColor = cukes.get(color);
        if(n != cukesOfColor) {
            throw new RuntimeException("Expected " + n + ", got " + cukes.get(color));
        }
    }

    @When("^I add a table$")
    public void aTable(Table table) {
        assertEquals(1, table.hashes().size());
    }

    @Given("Longs: (\\d+)")
    public void longs(long n) {
    }

    public void thisIsNotAStep() {}
}