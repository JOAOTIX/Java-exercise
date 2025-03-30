/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Deku
 */
public class Usuario {

    private int userID;
    private String user;
    private String name;

    public Usuario(String user, String name) {
        this.user = user;
        this.name = name;
    }
    public Usuario(int userID, String user, String name) {
        this.userID = userID;
        this.user = user;
        this.name = name;
    }
      public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }
}
