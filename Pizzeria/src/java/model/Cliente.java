/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Deku
 */
public class Cliente {
    private int id_cliente;
    private String dni;
    private String name;
    private String apellido;

    public Cliente(int id_cliente, String dni, String name,String apellido) {
        this.id_cliente = id_cliente;
        this.dni = dni;
        this.name = name;
        this.apellido = apellido;
    }

    public Cliente(String dni, String name,String apellido) {
        this.dni = dni;
        this.name = name;
        this.apellido = apellido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
