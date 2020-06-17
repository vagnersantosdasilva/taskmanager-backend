package br.com.vss.taskmanagerbackend.domain.task;

public class DuplicateTaskException extends Exception{
    public DuplicateTaskException(String message){
        super(message);
    }
}
