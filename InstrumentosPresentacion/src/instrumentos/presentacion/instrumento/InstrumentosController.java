/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.instrumento;

import instrumentos.entidades.Instrumento;
import instrumentos.entidades.TipoInstrumento;
import instrumentos.logic.Model;
import instrumentos.presentacion.Application;
import instrumentos.presentacion.calibracion.CalibracionesModel;
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentoModel;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class InstrumentosController {
    InstrumentosModel model;
    CalibracionesModel modelC;
    InstrumentosView view;
    Model domainModel;

    public InstrumentosController(InstrumentosView instView, InstrumentosModel model, Model domainModel) {
        model.init();
        this.model = model;
        this.view = instView;
        this.domainModel = domainModel;
        view.setController(this);
        view.setModel(model);
    }

   
    public void eliminar(int row) throws Exception{
        Instrumento seleccionada = model.getInstrumentos().getRowAt(row); 
        try {
            domainModel.InstrumentoEliminar(seleccionada);
            this.getAll();
        } catch (Exception ex) { }
    }
    public void preAgregar(){
        List aux =  new ArrayList();
        aux.addAll(domainModel.tipoInstrumentoGetAll());
        Application.INSTRUMENTOVIEW.jComboTipo.removeAllItems();
        Application.INSTRUMENTOVIEW.jDescField.setText("");
        Application.INSTRUMENTOVIEW.jMaxField.setText("");
        Application.INSTRUMENTOVIEW.jMinField.setText("");
        Application.INSTRUMENTOVIEW.jSerieField.setEditable(true);
        Application.INSTRUMENTOVIEW.jSerieField.setText("");
        Application.INSTRUMENTOVIEW.jTolField.setText("");
        TipoInstrumento t;
        String s;
        for(int i=0; i<aux.size();i++){
        t = (TipoInstrumento)aux.get(i);
        s = t.getNombre();
        Application.INSTRUMENTOVIEW.jComboTipo.addItem(s);}
        Application.INSTRUMENTOVIEW.setVisible(true);
        Application.INSTRUMENTOVIEW.toFront();
    }
    
    public void buscar() throws Exception {
        model.getFilter().setSerie(view.Jserie.getText());
        model.clearErrors();
        List<Instrumento> rows = new ArrayList();
        rows = domainModel.InstrumentoSearch(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("Jserie", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setInstrumentos(rows);
    }
    public void getAll() throws Exception{
      List aux3 =  new ArrayList();
      aux3.addAll(domainModel.tipoInstrumentoGetAll());
      List<TipoInstrumento> ti = new ArrayList();
        ti = aux3;
      List<Instrumento> aux = new ArrayList();
      aux.addAll(domainModel.InstrumentoGetAll());
      List tipos = new ArrayList();
      tipos.addAll(domainModel.tipo());
      List<TipoInstrumento> help =  new ArrayList();
      
      for(int i=0;i<aux.size();i++){
          help.add(new TipoInstrumento());
          help.get(i).setCodigo((String) tipos.get(i));
          aux.get(i).setTipo(help.get(i));
          for(int h=0; h<ti.size();h++){
          if(aux.get(i).getTipo().getCodigo().equals(ti.get(h).getCodigo())){
              aux.get(i).getTipo().setNombre(ti.get(h).getNombre());
          }    
         }
      }
      model.setInstrumentos(aux);
    }
    public Instrumento getInstrumetoSelec(int row){
         Instrumento seleccionado = model.getInstrumentos().getRowAt(row);
         return seleccionado;
    }
    public void searchCalibraciones(int row){
      List aux = new ArrayList();
      Instrumento seleccionado = model.getInstrumentos().getRowAt(row); 
      getInstrumetoSelec(row);
      aux.addAll(domainModel.CalibracionGetByInstrumento(seleccionado));
      Application.CALIBRACIONES_VIEW.getModel().setCalibraciones(aux);
      Application.CALIBRACIONES_VIEW.jTipoInstFld.setText(seleccionado.getDescripcion());
      Application.CALIBRACIONES_VIEW.setVisible(true);
    }
    public void preUpdate(int row) throws Exception{
        Instrumento seleccionado = model.getInstrumentos().getRowAt(row);
        Application.INSTRUMENTOVIEW.jDescField.setText(seleccionado.getDescripcion());
        Application.INSTRUMENTOVIEW.jSerieField.setText(seleccionado.getSerie());
        Application.INSTRUMENTOVIEW.jSerieField.setEditable(false);
        Application.INSTRUMENTOVIEW.jMaxField.setText(String.valueOf(seleccionado.getMaximo()));
        Application.INSTRUMENTOVIEW.jMinField.setText(String.valueOf(seleccionado.getMinimo()));
        Application.INSTRUMENTOVIEW.jTolField.setText(String.valueOf(seleccionado.getTolerancia()));
        List aux =  new ArrayList();
        aux.addAll(domainModel.tipoInstrumentoGetAll());
        Application.INSTRUMENTOVIEW.jComboTipo.removeAllItems();
        TipoInstrumento t;
        String s;
        for(int i=0; i<aux.size();i++){
        t = (TipoInstrumento)aux.get(i);
        s = t.getNombre();
        Application.INSTRUMENTOVIEW.jComboTipo.addItem(s);}
        Application.INSTRUMENTOVIEW.jComboTipo.setSelectedItem(seleccionado.getTipo().getNombre());
        TipoInstrumentoModel tipoInstrumentoModel = Application.TIPOINSTRUMENTO_VIEW.getModel();
        tipoInstrumentoModel.clearErrors();
        Application.INSTRUMENTOVIEW.setVisible(true);
       
   }
     public void update(int row) throws Exception{
        Instrumento update = model.getInstrumentos().getRowAt(row);
        List aux =  new ArrayList();
        aux.addAll(domainModel.tipoInstrumentoGetAll());
        TipoInstrumento t;
        update.setDescripcion( Application.INSTRUMENTOVIEW.jDescField.getText());
        update.setSerie( Application.INSTRUMENTOVIEW.jSerieField.getText());
        for(int i=0; i<aux.size();i++){
            t = (TipoInstrumento)aux.get(i);
            if( Application.INSTRUMENTOVIEW.jComboTipo.getSelectedItem().equals(t.getNombre()))
            update.setTipo(t);
        }
        update.setMaximo( parseInt(Application.INSTRUMENTOVIEW.jMaxField.getText()));
        update.setMinimo( parseInt(Application.INSTRUMENTOVIEW.jMinField.getText()));
        update.setTolerancia( parseInt(Application.INSTRUMENTOVIEW.jTolField.getText()));
        //System.out.println(update.getDescripcion()+ "-"+update.getMaximo() +"-"+ update.getMinimo() +"-"+ update.getSerie()+"-"+ update.getTipo().getCodigo()+ "-"+update.getTolerancia());
        this.domainModel.InstrumentoActualizar(update);
      
        TipoInstrumentoModel tipoInstrumentoModel = Application.TIPOINSTRUMENTO_VIEW.getModel();
        tipoInstrumentoModel.clearErrors();
        tipoInstrumentoModel.setModo(Application.MODO_EDITAR);
        Application.INSTRUMENTOSVIEW.signal=false;
        this.getAll();
    }
    public void salir(){
        domainModel.close();
    }

    
    
}
