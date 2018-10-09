/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.calibracion;

import instrumentos.entidades.Calibracion;
import instrumentos.entidades.Medida;
import instrumentos.presentacion.calibracion.Medida.MedidaTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Addiel
 */
public class CalibracionesModel extends Observable{
    Calibracion filter;
    Medida filter2;
    CalibracionesTableModel calibraciones;
    MedidaTableModel medidas;
    HashMap<String, String> errores;
    String mensaje; 

    public CalibracionesModel() {
    }
    
    public void init() {
        filter = new Calibracion();
        filter2 = new Medida();
        ArrayList<Calibracion> rows = new ArrayList<>();
        this.setCalibraciones(rows);
        ArrayList<Medida> rows2 = new ArrayList<>();
        this.setMedidas(rows2);
        clearErrors();
    }

      public CalibracionesTableModel getCalibraciones() {
        return calibraciones;
    }  

    public MedidaTableModel getMedidas() {
        return medidas;
    }
      
     public void setCalibraciones(List<Calibracion> cali) {
      int[] cols = {
            CalibracionesTableModel.FECHA,
            CalibracionesTableModel.MEDICIONES,
            
            
        };
        this.calibraciones = new CalibracionesTableModel(cols, cali);
        setChanged();
        notifyObservers();
    }
    public HashMap<String, String> getErrores() {
        return errores;
    }
    public void setMedidas(List<Medida> med){
        int[] cols = {
            //MedidaTableModel.MEDIDA,
            MedidaTableModel.LECTURA,
            MedidaTableModel.REFERENCIA,
            
            
        };
        this.medidas = new MedidaTableModel(cols, med);
        setChanged();
        notifyObservers();
    
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
     public Calibracion getFilter() {
        return filter;
    }

    public void setFilter(Calibracion filter) {
        this.filter = filter;
    }

    public Medida getFilter2() {
        return filter2;
    }

    public void setFilter2(Medida filter2) {
        this.filter2 = filter2;
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
