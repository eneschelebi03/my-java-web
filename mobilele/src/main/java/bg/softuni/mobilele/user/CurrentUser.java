package bg.softuni.mobilele.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String name;
    private boolean logged;
    private String email;

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLogged() {
        return logged;
    }

    public boolean isAnonymous() {
        return !isLogged();
    }

    public CurrentUser setLogged(boolean logged) {
        this.logged = logged;
        return this;
    }

    public void clear() {
        name =  null;
        email = null;
        logged = false;
    }

    public String getEmail() {
        return email;
    }

    public CurrentUser setEmail(String email) {
        this.email = email;
        return this;
    }
}
