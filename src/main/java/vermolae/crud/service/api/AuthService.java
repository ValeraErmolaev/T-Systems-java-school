package vermolae.crud.service.api;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vermolae.model.entity.User;

public interface AuthService extends UserDetailsService {

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
//
//    public User getCurrentUser();
}
