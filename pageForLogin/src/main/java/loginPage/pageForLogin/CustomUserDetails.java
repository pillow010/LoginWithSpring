package loginPage.pageForLogin;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Custom implementation of the UserDetails interface.
 */
public class CustomUserDetails implements UserDetails {

    private User user;

    /**
     * Constructs a new CustomUserDetails object with the specified User.
     *
     * @param user the User object representing the authenticated user
     */
    public CustomUserDetails(User user) {
        this.user = user;
    }

    /**
     * Returns the authorities granted to the user.
     *
     * @return the authorities (roles) granted to the user
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the user's password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return the user's email (username)
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return true if the user's account is not expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     *
     * @return true if the user is not locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     *
     * @return true if the user's credentials are not expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     *
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Returns the full name of the user.
     *
     * @return the user's full name (first name + last name)
     */
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }
}

