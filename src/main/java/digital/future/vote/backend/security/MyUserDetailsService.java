package digital.future.vote.backend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Value("foo")
private String userName;
    @Value("foo")
private String userPassword;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User(userName, userPassword,
                new ArrayList<>());
    }
}