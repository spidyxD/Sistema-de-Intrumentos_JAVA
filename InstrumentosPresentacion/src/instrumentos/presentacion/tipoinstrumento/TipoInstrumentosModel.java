
// ***
package instrumentos.presentacion.tipoinstrumento;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import instrumentos.entidades.TipoInstrumento;

public class TipoInstrumentosModel extends Observable {
    TipoInstrumento filter;
    TipoInstrumentoTableModel tipoInstrumentos;
    HashMap<String, String> errores;
    String mensaje;
    public TipoInstrumentosModel() {
    }
    
    public void init() {
        filter = new TipoInstrumento();
        ArrayList<TipoInstrumento> rows = new ArrayList<>();
        this.setTipoInstrumentos(rows);
        clearErrors();
    }
    
    public void setTipoInstrumentos(List<TipoInstrumento> ti) {
        int[] cols = {
            TipoInstrumentoTableModel.CODIGO,
            TipoInstrumentoTableModel.NOMBRE,
            TipoInstrumentoTableModel.UNIDAD
        };
        this.tipoInstrumentos = new TipoInstrumentoTableModel(cols, ti);
        setChanged();
        notifyObservers();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public void addObserver(Observer o) {

        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
    public TipoInstrumento getFilter() {
        return filter;
    }

    public void setFilter(TipoInstrumento filter) {
        this.filter = filter;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }
    
      public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje(""); 
    }
    
    public TipoInstrumentoTableModel getTipoInstrumentos() {
        return tipoInstrumentos;
    }
}