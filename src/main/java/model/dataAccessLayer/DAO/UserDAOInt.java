/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dataAccessLayer.entity.ItiStoreYUser;

/**
 *
 * @author Eman-PC
 */
public interface UserDAOInt {

    public boolean addUser(ItiStoreYUser user);
    
    public boolean addAllUserInterest(ItiStoreYUser user);
    
    public boolean hasInterests(ItiStoreYUser user);

    public boolean editProfile(ItiStoreYUser user);

    public boolean isEmailExist(String email);
    
    public Long getUserIdByEmail(String email);

    public ItiStoreYUser getUserById(Long id) throws SQLException;

    public ItiStoreYUser checkLogin(String email, String password);

    public ArrayList<ItiStoreYUser> getUserList();

    public boolean deleteUserInterests(ItiStoreYUser user);
}
