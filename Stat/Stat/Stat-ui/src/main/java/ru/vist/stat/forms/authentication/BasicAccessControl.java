package ru.vist.stat.forms.authentication;

import ru.vist.model.domain.sys.User;
import ru.vist.stat.VistUI;
import ru.vist.stat.db.Init;

public class BasicAccessControl implements AccessControl {

    @Override
    public boolean signIn(String username, String password) {
        if (username == null || username.isEmpty())
            return false;
        User user = Init.verifyUser(username, password);
        if (user == null) {
            System.out.println(" reslt = false");

            return false;
        }
        System.out.println(" reslt = true");
        VistUI.get().setApplCaption(username);
        CurrentUser.set(username);
        return true;
    }

    @Override
    public boolean isUserSignedIn() {
        return !CurrentUser.get().isEmpty();
    }

    @Override
    public boolean isUserInRole(String role) {
        if ("admin".equals(role)) {
            return getPrincipalName().equals("admin");
        }
        return true;
    }

    @Override
    public String getPrincipalName() {
        return CurrentUser.get();
    }

}
