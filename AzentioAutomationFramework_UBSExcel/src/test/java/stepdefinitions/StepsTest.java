package stepdefinitions;

import io.cucumber.java.en.Given;

public class StepsTest {
	
	@Given("^test1$")
    public void test1() throws Throwable {
System.out.println("Test 1");

    }

    @Given("^test2$")
    public void test2() throws Throwable {
    	System.out.println("Test 2");     
    }

}
