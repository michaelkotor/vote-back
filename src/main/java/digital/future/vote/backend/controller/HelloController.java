package digital.future.vote.backend.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

// For testing purposes //TODO: remove on prod
@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping("/hello")
   // @PreAuthorize("hasAnyRole('ROLE_USER') and hasRole('ROLE_ADMIN')")
    public String getHome(Principal principal) {
        return "Hello, " + principal.getName();
    } //юзеров нет поэтому будет nullpointer

    @GetMapping
   // @Secured({"ROLE_ANONYMOUS"})
    public String getRoot() {
        return "Vote Backend";
    }
}
