package spring.service;

import spring.modal.UserDetails;

public interface UserDetailsService {
    String saveUserDetails(UserDetails details);
    String getUserDetails(String username);
}
