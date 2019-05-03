/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 * Tracks current user and returns to requesting JSP
 * @author Zach
 */
@Singleton
@LocalBean
@Startup
public class LoginBean {
    
    private String userName = "None";
    
    public void setUserName(String user)
    {
        this.userName = user;
    }
    
    public String getCurrentUser()
    {
        return userName;
    }
}
