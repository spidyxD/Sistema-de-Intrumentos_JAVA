
package instrumentos.presentacion.tipoinstrumento;
import instrumentos.entidades.TipoInstrumento;
import instrumentos.logic.Model;
import instrumentos.presentacion.Application;
import java.util.ArrayList;
import java.util.List;

public class TipoInstrumentosController {
    Model domainModel;
    TipoInstrumentosView view;
    TipoInstrumentosModel model;

    public TipoInstrumentosController(TipoInstrumentosView tipoInstrumentosView, TipoInstrumentosModel model, Model domainModel) {
        model.init();
        this.domainModel= domainModel;
        this.view = tipoInstrumentosView;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void buscar() throws Exception{
         
        model.getFilter().setCodigo(view.getCodigo_tf().getText());
        model.clearErrors();
        List<TipoInstrumento> rows =  domainModel.tipoInstrumentoSearch(model.getFilter());//tipoInstrumentoGet(model.getFilter().getCodigo());
        if (rows.isEmpty() && !Application.TIPOINSTRUMENTOS_VIEW.signal){
            model.getErrores().put("nombreFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setTipoInstrumentos(rows);
    }
    public void searchAll() throws Exception{
      List aux = new ArrayList();
      aux.addAll(domainModel.tipoInstrumentoGetAll());
      model.setTipoInstrumentos(aux);
    }
    public void preAgregar(){
        Application.TIPOINSTRUMENTO_VIEW.codigo_tf.setEditable(true);
        Application.TIPOINSTRUMENTO_VIEW.codigo_tf.setText("");
        Application.TIPOINSTRUMENTO_VIEW.nombre_tf.setText("");
        Application.TIPOINSTRUMENTO_VIEW.unidad_tf.setText("");
        TipoInstrumentoModel tipoInstrumentoModel = Application.TIPOINSTRUMENTO_VIEW.getModel();
        tipoInstrumentoModel.clearErrors();
        tipoInstrumentoModel.setModo(Application.MODO_AGREGAR);
        tipoInstrumentoModel.setCurrent(new TipoInstrumento());
        Application.TIPOINSTRUMENTO_VIEW.setVisible(true);
        Application.TIPOINSTRUMENTO_VIEW.toFront();
    }
    
    public void borrar(int row) throws Exception{
        TipoInstrumento seleccionado = model.getTipoInstrumentos().getRowAt(row); 
        domainModel.tipoInstrumentoDelete(seleccionado);
        this.searchAll();
        
     }
    public void agregar() throws Exception{
         Application.TIPOINSTRUMENTO_VIEW.setVisible(true);
         this.buscar();
    }
   public void preUpdate(int row) throws Exception{
        TipoInstrumento seleccionado = model.getTipoInstrumentos().getRowAt(row); 
        Application.TIPOINSTRUMENTO_VIEW.codigo_tf.setText(seleccionado.getCodigo());
        Application.TIPOINSTRUMENTO_VIEW.codigo_tf.setEditable(false);
        Application.TIPOINSTRUMENTO_VIEW.nombre_tf.setText(seleccionado.getNombre());
        Application.TIPOINSTRUMENTO_VIEW.unidad_tf.setText(seleccionado.getUnidad());
        TipoInstrumentoModel tipoInstrumentoModel = Application.TIPOINSTRUMENTO_VIEW.getModel();
        tipoInstrumentoModel.clearErrors();
        tipoInstrumentoModel.setModo(Application.MODO_EDITAR);
        Application.TIPOINSTRUMENTO_VIEW.setVisible(true);
       
       
   }
}
