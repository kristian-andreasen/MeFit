package noroff.mefit.runners;


import jakarta.transaction.Transactional;
import noroff.mefit.services.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * Client class for the Services.
 * This class exists to demonstrate the use of services.
 * It implements ApplicationRunner to be able to use dependency injection.
 */
@Component
public class AppRunner implements ApplicationRunner {




    @Override
    @Transactional
    //need to add @Transactional to be able to delete from both sides of the relationship.
    public void run(ApplicationArguments args) throws Exception {



    }
}