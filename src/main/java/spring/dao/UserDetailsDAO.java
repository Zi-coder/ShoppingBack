package spring.dao;


import spring.modal.UserDetails;

public interface UserDetailsDAO {
    String saveUserDetails(UserDetails userDetails);
    String getUserDetails(String username);
}
