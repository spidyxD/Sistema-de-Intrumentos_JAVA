/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.calibracion;

import instrumentos.entidades.Calibracion;
import instrumentos.entidades.Medida;
import instrumentos.logic.Model;
import instrumentos.presentacion.Application;
import instrumentos.presentacion.calibracion.Medida.MedidasModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Addiel
 */
public class CalibracionesController {
    Model domainModel;
    CalibracionesView view;
    CalibracionesModel model;
    MedidasModel modelM;
    List<Medida> med;
    int numero = 1;
    public CalibracionesController(CalibracionesView calView, CalibracionesModel model,MedidasModel modelM,Model domainModel) {
        model.init();
        modelM.init();
        this.domainModel = domainModel;
        this.view = calView;
        this.model = model;
        this.modelM = modelM;
        view.setController(this);
        view.setModel(model);
        view.setModMs(modelM);
    }
    
    
    public void preAgregar(int row) throws Exception{
        Application.CALIBRACIONES_VIEW.flag = true;
        Application.CALIBRACIONES_VIEW.jTFldFecha.setText("");
        Application.CALIBRACIONES_VIEW.jTFldMedida.setText("");
        //Application.CALIBRACIONES_VIEW.jTabMedidas.setValueAt("", row, 0);
         //Application.CALIBRACIONES_VIEW.jTabMedidas.setValueAt("", row, 1);
        Application.CALIBRACIONES_VIEW.jTFldFecha.setFocusable(true);
        Application.CALIBRACIONES_VIEW.jTFldFecha.setEditable(true);
        Application.CALIBRACIONES_VIEW.jTFldMedida.setFocusable(true);
        Application.CALIBRACIONES_VIEW.jTFldMedida.setEditable(true);
        
    }
     public void preAddCalibracion(int row) throws Exception{
        Calibracion seleccionada = model.getCalibraciones().getRowAt(row); 
        Application.CALIBRACIONES_VIEW.jTFldFecha.setText("");
        Application.CALIBRACIONES_VIEW.jTFldMedida.setText("");
        Application.CALIBRACIONES_VIEW.jTFldFecha.setFocusable(true);
        Application.CALIBRACIONES_VIEW.jTFldFecha.setEditable(true);
        Application.CALIBRACIONES_VIEW.jTFldMedida.setFocusable(true);
        Application.CALIBRACIONES_VIEW.jTFldMedida.setEditable(true);
        Application.CALIBRACIONES_VIEW.jTFldFecha.setText(seleccionada.getFecha().toString());
        Application.CALIBRACIONES_VIEW.jTFldMedida.setText(String.valueOf(seleccionada.getMediciones()));
     }
     public void eliminarCalibracion(int row) throws Exception{
        Calibracion seleccionada = model.getCalibraciones().getRowAt(row); 
        domainModel.CalibracionesEliminar(seleccionada);
        this.buscarCalibracion();
    }
    public void agregarCalibracion() throws Exception{
        buscarCalibracion();
        List aux  = new ArrayList();
        aux.addAll(domainModel.CalibracionGetAll());
        numero = aux.size()+1;
        Calibracion nuevo = new Calibracion();
        if(Application.CALIBRACIONES_VIEW.jTFldFecha.getText().length() == 0){
            model.getErrores().put("fecha", "fecha requerida");
        }
        else{
        nuevo.setFecha(giveFormatDate(Application.CALIBRACIONES_VIEW.jTFldFecha.getText()));}
        nuevo.setMediciones(parseInt(Application.CALIBRACIONES_VIEW.jTFldMedida.getText()));
        nuevo.setNumero(numero+1);
        List help = new ArrayList();
        help.addAll(domainModel.InstrumentoGetAll());
        for(int i=0;i<help.size();i++){
        
        nuevo.setInstrumento(Application.INSTRUMENTOSVIEW.controller.getInstrumetoSelec(Application.INSTRUMENTOSVIEW.row));
        }
        domainModel.CalibracionesAgregar(nuevo);
        
        addMedida(nuevo);
        CalibracionModel calibracionModel = Application.CALIBRACIONES_VIEW.getModC();
        this.buscarCalibracion();
        //calibracionModel.clearErrors();
        //calibracionModel.setModo(Application.MODO_AGREGAR);
    }
    public void UpdateCalibracion(int row) throws Exception{
        Calibracion seleccionada = model.getCalibraciones().getRowAt(row); 
        seleccionada.setMediciones(parseInt(Application.CALIBRACIONES_VIEW.jTFldMedida.getText()));
        if(Application.CALIBRACIONES_VIEW.jTFldFecha.getText().length() == 0){
            model.getErrores().put("fecha", "fecha requerida");
        }else{
        seleccionada.setFecha(giveFormatDate(view.jTFldFecha.getText()));
        }
        this.domainModel.CalibracionesActualizar(seleccionada);
        UpdateMedida(row);
        CalibracionModel calibracionModel = Application.CALIBRACIONES_VIEW.getModC();
        //calibracionModel.setModo(Application.MODO_EDITAR);
        //calibracionModel.clearErrors();
        this.buscarCalibracion();
     }
    public void buscarCalibracion() {
        model.getFilter().getInstrumento().setSerie(view.jTipoInstFld.getText());
        model.clearErrors();
        List<Calibracion> rows = new ArrayList(); 
        rows.addAll(domainModel.CalibracionGetByInstrumento(Application.INSTRUMENTOSVIEW.controller.getInstrumetoSelec(Application.INSTRUMENTOSVIEW.row)));
        numero = rows.size();
        if (rows.isEmpty()){
            model.getErrores().put("JDescipcion", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
    }
    public Date giveFormatDate(String fech) throws ParseException{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha  = (Date)ft.parse(fech);
        System.out.println(fecha);
        return fecha;
    }
   
    public void preAddMedida(int cant){
        
        med = new ArrayList();
        for(int i=0;i<cant;i++){
           med.add(new Medida());
        }
        modelM.getMedidas().setRows(med);
        Application.CALIBRACIONES_VIEW.jTabMedidas.setModel(modelM.getMedidas());
        int row = Application.CALIBRACIONES_VIEW.jTabMedidas.getSelectedRow(); 
        int col = Application.CALIBRACIONES_VIEW.jTabMedidas.getSelectedColumn();
        Application.CALIBRACIONES_VIEW.jTabMedidas.isCellEditable(row, col);
    }
    public void preUpdateMedida(List<Medida> med){
        int cant = parseInt(Application.CALIBRACIONES_VIEW.jTFldMedida.getText());
        modelM.getMedidas().setRows(med);
        Application.CALIBRACIONES_VIEW.jTabMedidas.setModel(modelM.getMedidas());
        int row = Application.CALIBRACIONES_VIEW.jTabMedidas.getSelectedRow(); 
        int col = Application.CALIBRACIONES_VIEW.jTabMedidas.getSelectedColumn();
        Application.CALIBRACIONES_VIEW.jTabMedidas.isCellEditable(row, col);
    }
    public void buscarMedidas(int row) throws Exception{
       Calibracion seleccionada = model.getCalibraciones().getRowAt(row);
       String cali = String.valueOf(seleccionada.getNumero());
       preUpdateMedida(domainModel.getMedida(cali));
    }
    public void addMedida(Calibracion nueva) throws Exception{
        List<Medida> aux = new ArrayList();
        int medidas = parseInt(Application.CALIBRACIONES_VIEW.jTFldMedida.getText());
        for(int i=0; i<medidas;i++){
            
            aux.add(new Medida());
            aux.get(i).setMedida(i+1);
            aux.get(i).setCalibracion(nueva.getNumero());
            aux.get(i).setLectura((int)Application.CALIBRACIONES_VIEW.jTabMedidas.getValueAt(i, 0));
            aux.get(i).setReferencia((int)Application.CALIBRACIONES_VIEW.jTabMedidas.getValueAt(i, 1));
        }
        
        domainModel.MedidaAgregar(aux);
    }

    public void UpdateMedida(int row) throws Exception {
        Calibracion seleccionada = model.getCalibraciones().getRowAt(row);
         List<Medida> aux = new ArrayList();
        int medidas = parseInt(Application.CALIBRACIONES_VIEW.jTFldMedida.getText());
        for(int i=0; i<medidas;i++){
            aux.add(new Medida());
            aux.get(i).setMedida(i+1);
            aux.get(i).setCalibracion(seleccionada.getNumero());
            aux.get(i).setLectura((int)Application.CALIBRACIONES_VIEW.jTabMedidas.getValueAt(i, 0));
            aux.get(i).setReferencia((int)Application.CALIBRACIONES_VIEW.jTabMedidas.getValueAt(i, 1));
        }
        seleccionada.setMedidas(aux);
        domainModel.updateMedida(seleccionada.getMedidas());
      
    }
    public void deleteMedida(int row) throws Exception{
         Calibracion seleccionada = model.getCalibraciones().getRowAt(row); 
         for(int i=0;i<seleccionada.getMediciones();i++){
         domainModel.MedidaDelete(seleccionada.getMedidas().get(i));}
    }
    public void salir(){
        domainModel.close();
    }
}
