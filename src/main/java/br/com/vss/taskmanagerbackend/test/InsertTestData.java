package br.com.vss.taskmanagerbackend.test;

import br.com.vss.taskmanagerbackend.domain.task.Task;
import br.com.vss.taskmanagerbackend.domain.task.TaskRepository;
import br.com.vss.taskmanagerbackend.domain.user.AppUser;
import br.com.vss.taskmanagerbackend.domain.user.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InsertTestData {

    private TaskRepository taskRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    public InsertTestData(TaskRepository taskRepository, AppUserRepository appUserRepository){
        this.taskRepository =taskRepository;
        this.appUserRepository=appUserRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        //TODO: Criptografar password
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        AppUser appUser = new AppUser("vagner",encoder.encode("abc@123"),"Vagner Silva");
        appUserRepository.save(appUser);

        LocalDate localDate = LocalDate.parse("2021-03-01");

        for (int i=1;i<=15;i++){
            Task task = new Task("Tarefea : "+i,localDate.plusDays(i),false);
            task.setAppUserID(appUser);
            taskRepository.save(task);
        }
    }
}
