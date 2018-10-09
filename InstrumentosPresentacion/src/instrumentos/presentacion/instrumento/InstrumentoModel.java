/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.instrumento;

import instrumentos.entidades.Instrumento;
import java.util.HashMap;

/**
 *
 * @author Addiel
 */
public class InstrumentoModel extends java.util.Observable{
    Instrumento current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public InstrumentoModel() {}
    public void clearErrors(){
        setErrores(new HashMap<>());
        setMensaje("");
    }
    
   public void init(){
        setCurrent(new Instrumento());
        clearErrors();
    }
    public Instrumento getCurrent() {
        return current;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getModo() {
        return modo;
    }

    public void setCurrent(Instrumento current) {
        this.current = current;
        setChanged();
        notifyObservers();   
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
        
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
