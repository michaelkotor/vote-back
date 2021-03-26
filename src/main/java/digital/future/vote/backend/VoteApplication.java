package digital.future.vote.backend;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@OpenAPIDefinition(
//        info = @Info(
//                title = "Vote",
//                version = "1.0",
//                description = "Vote API",
//                //TODO: fill in contact if required
//                license = @License(name = "Apache 2.0", url = "https://foo.bar"),
//                contact = @Contact(url = "http://something.com", name = "something", email = "something")
//        )
//)
@SpringBootApplication
public class VoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(VoteApplication.class, args);


    }
}
