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
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentoModel;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Addiel
 */
public class InstrumentoController {
    InstrumentoModel model;
    InstrumentosModel modM;
    InstrumentoView view;
    Model domainModel;

    public InstrumentoController(InstrumentoView instView, InstrumentoModel model, Model domainModel) {
        model.init();
        this.model = model;
        this.view = instView;
        this.domainModel = domainModel;
        view.setController(this);
        view.setModel(model);
       
    }
    public void guardar() throws Exception{
        Instrumento nuevo = new Instrumento();
        List aux =  new ArrayList();
        aux.addAll(domainModel.tipoInstrumentoGetAll());
        TipoInstrumento t;
        nuevo.setDescripcion( Application.INSTRUMENTOVIEW.jDescField.getText());
        nuevo.setSerie( Application.INSTRUMENTOVIEW.jSerieField.getText());
        for(int i=0; i<aux.size();i++){
            t = (TipoInstrumento)aux.get(i);
            if( Application.INSTRUMENTOVIEW.jComboTipo.getSelectedItem().equals(t.getNombre()))
            nuevo.setTipo(t);
        }
       
        nuevo.setMaximo( parseInt(Application.INSTRUMENTOVIEW.jMaxField.getText()));
        nuevo.setMinimo( parseInt(Application.INSTRUMENTOVIEW.jMinField.getText()));
        nuevo.setTolerancia( parseInt(Application.INSTRUMENTOVIEW.jTolField.getText()));
        domainModel.InstrumentoAgregar(nuevo);
        Application.INSTRUMENTOVIEW.setVisible(true);
        InstrumentoModel InstrumentoModel = Application.INSTRUMENTOVIEW.getModel();
        InstrumentoModel.clearErrors();
        InstrumentoModel.setModo(Application.MODO_AGREGAR);
        //Application.INSTRUMENTOSVIEW.controller.getAll();
        this.preAgregar();
    }
           
      public void preAgregar(){
        List aux =  new ArrayList();
        aux.addAll(domainModel.tipoInstrumentoGetAll());
        Application.INSTRUMENTOVIEW.jComboTipo.removeAllItems();
        TipoInstrumento t;
        String s;
        for(int i=0; i<aux.size();i++){
        t = (TipoInstrumento)aux.get(i);
        s = t.getNombre();
        InstrumentoModel InstrumentoModel = Application.INSTRUMENTOVIEW.getModel();
        InstrumentoModel.clearErrors();
        InstrumentoModel.setModo(Application.MODO_AGREGAR);
        InstrumentoModel.setCurrent(new Instrumento());
        Application.INSTRUMENTOVIEW.jComboTipo.addItem(s);}       
        Application.INSTRUMENTOVIEW.setVisible(true);
        Application.INSTRUMENTOVIEW.toFront();
     }       
       
        
    }
    
    
    
    
    
    
    
    
   

   
    

