package petstore_smoketest;

import herokuapp_smoketest.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
//This class will run the classes below in this order.
        C01_CreatePet.class,
        C02_UpdatePet.class,
        C03_ReadBooking.class,
        C04_PatchBooking.class,
        C05_DeleteBooking.class
})

public class Runner {
}