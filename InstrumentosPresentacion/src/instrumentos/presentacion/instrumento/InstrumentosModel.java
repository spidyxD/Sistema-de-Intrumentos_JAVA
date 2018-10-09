/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.instrumento;

import instrumentos.entidades.Instrumento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Addiel
 */
public class InstrumentosModel extends Observable {
    Instrumento filter;
    InstrumentosTableModel instrumentos;
    HashMap<String, String> errores;
    String mensaje;

    public InstrumentosModel() {
    }
    
    public void init() {
        filter = new Instrumento();
        ArrayList<Instrumento> rows = new ArrayList<>();
        this.setInstrumentos(rows);
        clearErrors();
    }

    public InstrumentosTableModel getInstrumentos() {
        return instrumentos;
    }
     public void setInstrumentos(List<Instrumento> instrumento) {
      int[] cols = {
            InstrumentosTableModel.SERIE,
            InstrumentosTableModel.TIPO,
            InstrumentosTableModel.DESC,
            InstrumentosTableModel.MIN,
            InstrumentosTableModel.MAX,
            InstrumentosTableModel.TOL
            
        };
        this.instrumentos = new InstrumentosTableModel(cols, instrumento);
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
     public Instrumento getFilter() {
        return filter;
    }

    public void setFilter(Instrumento filter) {
        this.filter = filter;
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
