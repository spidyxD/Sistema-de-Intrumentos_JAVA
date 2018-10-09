
package instrumentos.presentacion.tipoinstrumento;
import instrumentos.entidades.TipoInstrumento;
import instrumentos.logic.Model;
import instrumentos.presentacion.Application;
import java.util.List;

public class TipoInstrumentoController {
    Model domainModel;    
    TipoInstrumentoView view;
    TipoInstrumentoModel model;
    public TipoInstrumentoController(TipoInstrumentoView view, TipoInstrumentoModel model, Model domainModel) {
        model.init();
        this.domainModel= domainModel;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void guardar(){
        TipoInstrumentosModel tipoInstrumentosModel=Application.TIPOINSTRUMENTOS_VIEW.getModel();
        TipoInstrumento nuevo= new TipoInstrumento();
        model.clearErrors();
        nuevo.setCodigo(view.getCodigo_tf().getText());
        if (view.getCodigo_tf().getText().length()==0){
            model.getErrores().put("codigo", "Codigo requerido");
        }
        nuevo.setNombre(view.getNombre_tf().getText());
        if (view.getNombre_tf().getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        nuevo.setUnidad(view.getUnidad_tf().getText());
        if (view.getUnidad_tf().getText().length()==0){
            model.getErrores().put("unidad", "Unidad requerida");
        }
        List<TipoInstrumento> tiposDeInstrumento;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        
                        domainModel.tipoInstrumentoAdd(nuevo);
                        model.setMensaje("TIPO DE INSTRUMENTO AGREGADO ");
                        model.setCurrent(new TipoInstrumento());
                        Application.TIPOINSTRUMENTOS_VIEW.controller.searchAll();
                        tipoInstrumentosModel.clearErrors();
                        
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.tipoInstrumentoUpdate(nuevo);
                        model.setMensaje("TIPO DE INSTRUMENTO ACTUALIZADO");
                        model.setCurrent(nuevo);
                        Application.TIPOINSTRUMENTOS_VIEW.controller.searchAll();
                        tiposDeInstrumento=(List<TipoInstrumento>) domainModel.tipoInstrumentoGet(tipoInstrumentosModel.getFilter().getCodigo());
                        tipoInstrumentosModel.setTipoInstrumentos(tiposDeInstrumento);
                        break;
                }
            }
            catch(Exception e){
                model.setCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
        
    }
    

   
}
