package digital.future.vote.backend.security;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    String login;
    String name;
    String email;

}
