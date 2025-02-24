package cz.cvut.ear.clubevidence.security;

import cz.cvut.ear.clubevidence.model.User;
import cz.cvut.ear.clubevidence.security.model.UserDetails;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static User getCurrentUser() {
        final UserDetails ud = getCurrentUserDetails();
        return ud != null ? ud.getUser() : null;
    }

    public static UserDetails getCurrentUserDetails() {
        final SecurityContext context = SecurityContextHolder.getContext();
        if (context.getAuthentication() != null && context.getAuthentication().getPrincipal() instanceof UserDetails) {
            return (UserDetails) context.getAuthentication().getPrincipal();
        } else {
            return null;
        }
    }

    public static boolean isAuthenticatedAnonymously() {
        return getCurrentUserDetails() == null;
    }

}