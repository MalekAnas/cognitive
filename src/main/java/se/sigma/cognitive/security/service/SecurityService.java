package se.sigma.cognitive.security.service;

public interface SecurityService  {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
