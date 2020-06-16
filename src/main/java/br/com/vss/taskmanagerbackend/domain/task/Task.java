package br.com.vss.taskmanagerbackend.domain.task;

import br.com.vss.taskmanagerbackend.domain.user.AppUser;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private LocalDate whenToDO;
    private Boolean done =false;

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Task(){}

    public Task(String description, LocalDate whenToDO, Boolean done) {
        this.description = description;
        this.whenToDO = whenToDO;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getWhenToDO() {
        return whenToDO;
    }

    public void setWhenToDO(LocalDate whenToDO) {
        this.whenToDO = whenToDO;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
