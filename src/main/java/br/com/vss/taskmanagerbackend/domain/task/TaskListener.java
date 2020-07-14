package br.com.vss.taskmanagerbackend.domain.task;

import br.com.vss.taskmanagerbackend.domain.user.AppUser;
import br.com.vss.taskmanagerbackend.domain.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PrePersist;

@Component
public class TaskListener {

    @Autowired
    private static AppUserRepository appUserRepository;

    @PrePersist
    public void onPrePersistHandler(Task task){
        if (task.getAppUser()==null){
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            AppUser appUser = appUserRepository.findByUsername(username);

            if(appUser ==null){
                throw new EntityNotFoundException("O usuário "+username+" não foi encontrado");
            }
            task.setAppUser(appUser);

        }
    }
    @Autowired
    public void init(AppUserRepository appUserRepository){
        TaskListener.appUserRepository = appUserRepository;
    }
}
