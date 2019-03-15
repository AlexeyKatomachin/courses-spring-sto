package by.katomakhin.app.sto.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class StoDetailService implements UserDetailsService {

    private static final Map<String, UserDetails> userStorage = new HashMap<>();

    static {
        userStorage.put("user", new StoUser("user",
                "user",
                Collections.singletonList(new SimpleGrantedAuthority("USER"))));


        userStorage.put("admin", new StoUser("admin",
                "admin",
                Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userStorage.getOrDefault(username, new DeniedUser());
    }
}
