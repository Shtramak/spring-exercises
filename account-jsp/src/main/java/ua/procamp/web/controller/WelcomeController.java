package ua.procamp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Welcome controller that consists of one method that handles get request to "/" and "/welcome" and respond with a message.
 * <p>
 * todo: 1. Mark this class as Spring controller
 * todo: 2. Configure HTTP GET mapping "/" and "/welcome" for method {@link WelcomeController#welcome()}
 * todo: 3. Forward the request to "welcome.jsp" view
 */
@Controller
@RequestMapping(path = {"/", "/welcome"})
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "welcome";
    }
}
