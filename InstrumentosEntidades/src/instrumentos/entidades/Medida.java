/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.entidades;

/**
 *
 * @author LENOVO
 */
public class Medida {
    int calibraciion;
    int referencia;
    int lectura;
    int medida;

    public Medida(int number, int reference, int lect, int measures) {
        this.calibraciion = number;
        this.referencia = reference;
        this.lectura = lect;
        this.medida = measures;
    }

    public Medida() {
        calibraciion = 0;
        referencia =0;
        lectura = 0;
        medida = 0;
    }

    public int getCalibracion() {
        return calibraciion;
    }

    public void setCalibracion(int numero) {
        this.calibraciion = numero;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getLectura() {
        return lectura;
    }

    public void setLectura(int lectura) {
        this.lectura = lectura;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

   
    
    
}
