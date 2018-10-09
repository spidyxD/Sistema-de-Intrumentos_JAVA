
package instrumentos.presentacion.tipoinstrumento;

import instrumentos.entidades.TipoInstrumento;
import java.util.HashMap;

public class TipoInstrumentoModel extends java.util.Observable{
    TipoInstrumento current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;  
    public TipoInstrumentoModel(){}
        public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
    }
        
    public void init(){
        setCurrent(new TipoInstrumento());
        clearErrors();
    }
    public TipoInstrumento getCurrent() {
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

    public void setCurrent(TipoInstrumento current) {
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
