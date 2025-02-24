package cz.cvut.ear.clubevidence.exception;

public class UserAlreadyExists extends ExceptionGeneral{
    public UserAlreadyExists(String message){

    }

    public static UserAlreadyExists create(Object username){
        return new UserAlreadyExists("User with " + username + "already exists");
    }
}
