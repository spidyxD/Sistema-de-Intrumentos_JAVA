/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.logic;

import instrumentos.entidades.Calibracion;
import instrumentos.entidades.TipoInstrumento;
import instrumentos.entidades.Instrumento;
import instrumentos.entidades.Medida;
import instrumentos.tipoinstrumentos.data.Dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Escinf
 */
public class Model {
    private Dao dao;
    private HashMap<String,TipoInstrumento> list=new HashMap();
    private HashMap<String,Instrumento> list2=new HashMap(); 
    private HashMap<String,Calibracion> list3=new HashMap(); 
    private HashMap<String,Medida> list4=new HashMap(); 
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }
    private Model(){
        dao = new Dao();
    }
    
    // ====== METODOS DE TIPOINSTRUMENTO ======
    public Collection<TipoInstrumento> tipoInstrumentoGetAll(){
        return dao.TipoInstrumentoGetAll();
    } 
    public TipoInstrumento tipoInstrumentoGet(String codigo) throws Exception{
        return dao.TipoInstrumentoGet(codigo);
    }
    public void tipoInstrumentoAdd(TipoInstrumento ti) throws Exception{
        dao.TipoInstrumentoAdd(ti);
    }
    public void tipoInstrumentoUpdate(TipoInstrumento ti) throws Exception{
        dao.TipoInstrumentoUpdate(ti);
    }
    public void tipoInstrumentoDelete(TipoInstrumento ti) throws Exception{
        dao.TipoInstrumentoDelete(ti);
    }    
    public List<TipoInstrumento> tipoInstrumentoSearch(TipoInstrumento filtro){
        return dao.tipoInstrumentoSearch(filtro);
    }
    public Collection<String> tipo()throws Exception{
        return dao.getTiposActuales();
    }
    
    // ====== METODOS DE INSTRUMENTO ======
    public List<Instrumento> InstrumentoSearch(Instrumento filtro){
        return dao.InstrumentoSearch(filtro);
    }
   public List<String> tipoIns(){
       return dao.tipoIns();
   }
    public Collection<Instrumento> InstrumentoGetAll() {
        return dao.InstrumentosGetAll();    
    }

    public void InstrumentoAgregar(Instrumento nuevo) throws Exception{
        dao.InstrumentoAdd(nuevo);
    }

    public void InstrumentoActualizar(Instrumento nuevo)  throws Exception{
        dao.InstrumentoUpdate(nuevo);
    }

    public void InstrumentoEliminar(Instrumento seleccionada) throws Exception{
        dao.InstrumentoDelete(seleccionada);
    }
     // ====== METODOS DE CALIBRACION ======
    public Collection<Calibracion> CalibracionGetByInstrumento(Instrumento seleccionada) {
          return dao.CalibracionGetByInstrmento(seleccionada);
     }
    public Collection<Calibracion> CalibracionGetAll() {
          return dao.CalibracionGetALL();
     }
    public void CalibracionesEliminar(Calibracion seleccionada) throws Exception{
         dao.CalibracionDelete(seleccionada);
    }
    public void CalibracionesAgregar(Calibracion nuevo) throws Exception{
        dao.CalibracionAdd(nuevo);
    }

    public void CalibracionesActualizar(Calibracion update) throws Exception{
        dao.CalibracionUpdate(update);
    }


    public List<Calibracion> CalibracionesSearch(Instrumento seleccionado) {
       List<Calibracion> aux = new ArrayList();
       aux.addAll(dao.CalibracionGetByInstrmento(seleccionado));
       return aux;
    }
     // ====== METODOS DE MEDIDA ======
    
    public List<Medida> getMedida(String numero) throws Exception {
          return dao.MedidaGet(numero);
     }
    
    public void MedidaAgregar(List<Medida> med)throws Exception {
        for(int i=0; i<med.size();i++){
            dao.MedidaAdd(med.get(i));
        }
    }
    public void MedidaDelete(Medida m) throws Exception{
        dao.MedidaDelete(m);
    }
    public void updateMedida(List<Medida> med) throws Exception{
          for(int i=0; i<med.size();i++){
            dao.MedidaUpdate(med.get(i));
        }
    }
    public void close(){
        dao.close();
    }
 
}
