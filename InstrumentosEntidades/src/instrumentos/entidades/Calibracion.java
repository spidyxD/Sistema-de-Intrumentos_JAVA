/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.entidades;

// Comentario de prueba

import java.util.Date;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class Calibracion {
    int numero;
    Instrumento instrumento;
    Date fecha;
    int mediciones;
    List<Medida> medidas;

    public Calibracion() {
        numero =0;
        instrumento = new Instrumento();
        fecha = null;
        mediciones = 0;
        medidas = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMediciones() {
        return mediciones;
    }

    public void setMediciones(int mediciones) {
        this.mediciones = mediciones;
    }

    public List<Medida> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }
    
}
