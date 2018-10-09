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
public class TipoInstrumento {
    String codigo;
    String nombre;
    String unidad;

    public TipoInstrumento(String codigo, String nombre, String unidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidad = unidad;
    }

    public TipoInstrumento() {
        codigo = "";
        nombre = "";
        unidad = "";
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    @Override
    public String toString(){
      return this.getNombre();
    }
}
