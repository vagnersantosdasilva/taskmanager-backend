package br.com.vss.taskmanagerbackend.infrastructure.web.security;

import br.com.vss.taskmanagerbackend.domain.user.AppUser;
import br.com.vss.taskmanagerbackend.domain.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    @Autowired
    public UserDatailsServiceImpl(AppUserRepository appUserRepository){
        this.appUserRepository=appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser==null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(appUser);
    }
}
