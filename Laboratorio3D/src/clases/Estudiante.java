/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Estudiante {
     private int codigo,nota1,nota2;
     private String nombre;
     public Estudiante(int code,String name,int n1,int n2){
         this.codigo=code;
         this.nombre=name;
         this.nota1=n1;
         this.nota2=n2;
     }
     public Estudiante(int code,String name){
         this(code,name,88,88);
     }
     public Estudiante(){
         this(8888,"ninguno");
     }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
}
