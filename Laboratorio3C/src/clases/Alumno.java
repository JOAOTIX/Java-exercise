/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Alumno {
    public int codigo,nota1,nota2;
    public String nombre;
    
    public Alumno(int code,String name,int note_one, int note_two){
        this.codigo=code;
        this.nombre=name;
        this.nota1=note_one;
        this.nota2=note_two;
    }
    
    public double Promedio(){
        return (nota1+nota2)/2.0;
    }
}
