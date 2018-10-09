/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class Instrumento {
    String serie;
    TipoInstrumento tipo;
    String descripcion;
    int minimo;
    int maximo;
    int tolerancia;
    List<Calibracion> calibraciones;
    public Instrumento() {
       serie = "";
       tipo = new TipoInstrumento();
       descripcion = "";
       minimo =0;
       maximo=0;
       tolerancia=0;
       calibraciones  = new ArrayList();
    }

    public Instrumento(String serie, TipoInstrumento tipo, String descripcion, int minimo, int maximo, int tolerancia) {
        this.serie = serie;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.minimo = minimo;
        this.maximo = maximo;
        this.tolerancia = tolerancia;
    }
    
    
     
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public TipoInstrumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstrumento tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }

    public List<Calibracion> getCalibraciones() {
        return calibraciones;
    }

    public void setCalibraciones(List<Calibracion> calibraciones) {
        this.calibraciones = calibraciones;
    }
    
}
