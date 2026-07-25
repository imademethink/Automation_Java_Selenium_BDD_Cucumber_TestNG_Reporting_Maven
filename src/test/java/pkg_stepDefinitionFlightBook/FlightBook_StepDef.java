package pkg_stepDefinitionFlightBook;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pkg_global.GlobalObjects;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

//   Fluent / Chain of Responsibility Pattern

public class FlightBook_StepDef extends GlobalObjects {

    @Given("User navigate to flight booking home")
    public void user_navigate_to_flight_booking_home() {
        pgHomeFlightBook.NavigateHomeFlightBooking();
    }

    @When("Book below flights:")
    public void book_below_flights(DataTable dt) {
        List<Map<String, String>> ecomData = dt.asMaps(String.class, String.class);

        for (Map<String, String> row : ecomData) {
            String fromLocation = row.get("From Location");
            String toLocation = row.get("To Location");
            String chooseResult = row.get("Choose Result");
//            Fluent / Chain of Responsibility Pattern
            pgHomeFlightBook.
                    SearchFlightsFor(fromLocation, toLocation).
                    ChooseThisFlight(chooseResult).
                    PurchaseThisFlight().
                    NavigateHomeBack();
        }
        pgIternaryFlightBook.allBookingDone = true;
    }

    @Then("Flight booking should be successful")
    public void flight_booking_should_be_successful() {
        if(!pgIternaryFlightBook.allBookingDone){
            Assert.fail("Log: Flight Booking failed");
        }
    }
}

