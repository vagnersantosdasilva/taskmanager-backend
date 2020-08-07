package br.com.vss.taskmanagerbackend.domain.task;

import br.com.vss.taskmanagerbackend.domain.user.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@EntityListeners(TaskListener.class)
public class Task {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "A descrição é obrigatória")
    @Length(min=3,max=40,message = "O tamanho da tarefa é inválido")
    private String description;

    @NotNull(message="A data da tarefa é obrigatória")
    @FutureOrPresent(message="A data da tarefa não pode ser no passado")
    private LocalDate whenToDo;

    private Boolean done =false;

    @ManyToOne
    @JoinColumn(name="app_user")
    //@NotNull(message ="O usuário da tarefa é obrigatório")
    @JsonIgnore
    private AppUser appUser;


    public Task(){}

    public Task(String description, LocalDate whenToDo, Boolean done) {
        this.description = description;
        this.whenToDo = whenToDo;
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

    public LocalDate getWhenToDo() {
        return whenToDo;
    }

    public void setWhenToDo(LocalDate whenToDo) {
        this.whenToDo = whenToDo;
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
