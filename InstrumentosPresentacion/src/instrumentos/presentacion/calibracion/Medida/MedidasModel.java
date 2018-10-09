/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.calibracion.Medida;

import instrumentos.entidades.Medida;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Addiel
 */
public class MedidasModel extends Observable{
    Medida filter;
    MedidaTableModel medidas ;
    HashMap<String, String> errores;
    String mensaje; 

    public MedidasModel() {
    }
    public void init() {
        filter = new Medida();
        ArrayList<Medida> rows = new ArrayList<>();
        this.setMedidas(rows);
        clearErrors();
    }
    public Medida getFilter() {
        return filter;
    }

    public void setFilter(Medida filter) {
        this.filter = filter;
    }

    public MedidaTableModel getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> med) {
         int[] cols = {
            //MedidaTableModel.MEDIDA,
            MedidaTableModel.LECTURA,
            MedidaTableModel.REFERENCIA,
            
            
        };
        this.medidas = new MedidaTableModel(cols, med);
        setChanged();
        notifyObservers();
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void clearErrors() {
        setErrores(new HashMap<>());
        setMensaje(""); 
    }
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
   
    
}
