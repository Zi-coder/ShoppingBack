package spring.dao;

import spring.modal.UsersList;

import java.util.List;

public interface UserListDAO {
    //saving a record in db
    String save (UsersList usersList);

    //getting a single record from db

    List<Object> get(String username);

    //get all records
    List<UsersList> list();
}
