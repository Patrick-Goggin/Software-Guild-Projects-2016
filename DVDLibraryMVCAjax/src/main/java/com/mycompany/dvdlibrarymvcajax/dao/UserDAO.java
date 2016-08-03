/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrarymvcajax.dao;
import java.util.ArrayList;

import java.util.List;
import com.mycompany.dvdlibrarymvcajax.dto.User;

/**
 *
 * @author apprentice
 */
public interface UserDAO {
    public void addUser(User newUser);

    public void deleteUser(String username);
    
    public List<User> getAllUsers();
}
