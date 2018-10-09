/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.calibracion;

import instrumentos.entidades.Calibracion;
import java.util.HashMap;

/**
 *
 * @author Addiel
 */
public class CalibracionModel  extends java.util.Observable{
    Calibracion current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;

    public CalibracionModel() {}
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
    }
    
   public void init(){
        setCurrent(new Calibracion());
        clearErrors();
    }
    public Calibracion getCurrent() {
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

    public void setCurrent(Calibracion current) {
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
