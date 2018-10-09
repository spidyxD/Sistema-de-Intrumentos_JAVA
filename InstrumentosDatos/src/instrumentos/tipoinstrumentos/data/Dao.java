/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.tipoinstrumentos.data;

import instrumentos.entidades.Calibracion;
import instrumentos.entidades.Instrumento;
import instrumentos.entidades.Medida;
import instrumentos.entidades.TipoInstrumento;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class Dao {
    RelDatabase db;
    
    public Dao(){
        db= new RelDatabase();
    }
    
    // ====== METODOS PARA TIPOINSTRUMENTO ======
    public List<TipoInstrumento> tipoInstrumentoSearch(TipoInstrumento filtro) {
        List<TipoInstrumento> resultado = new ArrayList<>();
        try {
             String sql="select * from TipoInstrumento where codigo='%s'";
            sql=String.format(sql,filtro.getCodigo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(tipoInstrumento(rs));
            }
        } catch (SQLException ex) { }
        return resultado;
    }
     public TipoInstrumento TipoInstrumentoGet(String codigo) throws Exception{
        String sql="select * from TipoInstrumento where codigo='%s'";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return tipoInstrumento(rs);
        }
        else{
            throw new Exception ("Tipo Instrumento no Existe");
        }
    }
    public Collection<TipoInstrumento> TipoInstrumentoGetAll(){
        Vector<TipoInstrumento> tipos=new Vector<>();
        try {
            String sql="select * from TipoInstrumento";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                tipos.add(tipoInstrumento(rs));
            }
        } catch (SQLException ex) { }
        return tipos;        
    } 
    
    //Valores que se muestran en pantalla
    private TipoInstrumento tipoInstrumento(ResultSet rs){
        try {
            TipoInstrumento ti= new TipoInstrumento();
            ti.setCodigo(rs.getString("codigo"));
            ti.setNombre(rs.getString("nombre"));
            ti.setUnidad(rs.getString("unidad"));
            return ti;
        } catch (SQLException ex) {
            return null;
        }
    }
   
    public void TipoInstrumentoDelete(TipoInstrumento t) throws Exception{
        String sql="delete from TipoInstrumento where codigo='%s'";
        sql = String.format(sql,t.getCodigo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Tipo Instrumento no existe");
        }
    }

    public void TipoInstrumentoAdd(TipoInstrumento t) throws Exception{
        String sql="insert into TipoInstrumento (codigo, nombre, unidad)"+
                "values('%s','%s','%s')";
        sql=String.format(sql,t.getCodigo(),t.getNombre(),t.getUnidad());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Tipo Instrumento ya existe");
        }
    }

    public void TipoInstrumentoUpdate(TipoInstrumento t) throws Exception{
        String sql="update TipoInstrumento set nombre='%s',unidad='%s' "+
                "where codigo='%s'";
        sql=String.format(sql,t.getNombre(),t.getUnidad(),t.getCodigo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Tipo Instrumento no existe");
        }
    }
    private String tipoS(ResultSet rs){
        try {
            String s= new String();
            s = (rs.getString("tipo"));
           
            return s;
        } catch (SQLException ex) {
            return null;
        }
    }
    public Collection<String> getTiposActuales()throws Exception{
         Vector<String> tipos=new Vector<>();
         try {
            String sql="select tipo from instrumento";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                tipos.add(tipoS(rs));
            }
        } catch (SQLException ex) { }
        return tipos;
    } 
    
    // ====== METODOS PARA INSTRUMENTO ======
    private Instrumento instrumento(ResultSet rs) {
        try {
            Instrumento i = new Instrumento();
            i.setSerie(rs.getString("serie"));
            i.setTipo(tipoInstrumento(rs));
            i.setDescripcion(rs.getString("descripcion"));
            i.setMinimo(rs.getInt("minimo"));
            i.setMaximo(rs.getInt("maximo"));
            i.setTolerancia(rs.getInt("tolerancia"));
            return i;
        } catch (SQLException ex) {
            return null;
        }
    }
    public List<String> tipoIns(){ 
        String sql="select tipo from instrumento";
        ResultSet rs =  db.executeQuery(sql);
        String s= "";
        s = tipoInstrumento(rs).getNombre();
        List<String> aux = new ArrayList();
        aux.add(s);
        return aux;
    }
    public List<Instrumento> InstrumentoSearch(Instrumento filtro) {
         List<Instrumento> resultado = new ArrayList<>();
         try {
             String sql="select * from "+
                     "instrumento i inner join tipoinstrumento t on i.tipo=t.codigo "+
                     "where i.serie like '%%%s%%'";
             sql=String.format(sql,filtro.getSerie());
             ResultSet rs =  db.executeQuery(sql);
             while (rs.next()) {
                 resultado.add(instrumento(rs));
             }
         } catch (SQLException ex) { }
                return resultado;
    }
    
    public Collection<Instrumento> InstrumentosGetAll() {
        Vector<Instrumento> resultado = new Vector<>();
        try {
            String sql = "select * from Instrumento";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(instrumento(rs));
            }
        } catch (SQLException ex) {
            
        }
        return resultado;
    }
    
    public void InstrumentoAdd(Instrumento i) throws Exception {
        String sql="insert into Instrumento (serie, tipo, descripcion, minimo, maximo, tolerancia) "+
                "values('%s','%s','%s','%d','%d','%d')";
        sql=String.format(sql,i.getSerie(),i.getTipo().getCodigo(),i.getDescripcion(),i.getMinimo(), i.getMaximo(), i.getTolerancia());
                
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Instrumento ya existe");
        }
    }
    
    public void InstrumentoUpdate(Instrumento i) throws Exception {
        //ojo al orden en q se colocan el format con lo q se quiere actualizar
        String sql ="update instrumento set tipo='%s',descripcion='%s'," +
                "minimo='%d',maximo='%d',tolerancia='%d' where serie='%s'";
        
        sql=String.format(sql,i.getTipo().getCodigo(),i.getDescripcion(),i.getMinimo(), i.getMaximo(), i.getTolerancia(),i.getSerie());
        
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception(String.format(""));
        }
    }
    public void InstrumentoDelete(Instrumento i) throws Exception {
        String sql = "delete from instrumento where serie='%s'";
        sql = String.format(sql, i.getSerie());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Instrumento no existe");
        }
    }
        // ====== METODOS PARA CALIBRACION ======
    public Collection<Calibracion> CalibracionGetByInstrmento(Instrumento seleccionado) {
        List<Calibracion> resultado = new ArrayList<>();
        try {
         String sql="select * from "+
                    "calibracion "+
                    "where instrumento like '%%%s%%'";
            sql=String.format(sql,seleccionado.getSerie());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Calibracion(rs));
            }
        } catch (SQLException ex) { }
        return resultado;
    }
     public Collection<Calibracion> CalibracionGetALL() {
        List<Calibracion> resultado = new ArrayList<>();
        try {
         String sql="select * from "+
                    "calibracion ";
            sql=String.format(sql);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(Calibracion(rs));
            }
        } catch (SQLException ex) { }
        return resultado;
    }
    private Calibracion Calibracion(ResultSet rs) {
         try {
            Calibracion ca= new Calibracion();
            ca.setNumero(rs.getInt("numero"));
            ca.setFecha(rs.getDate("fecha"));
            ca.setMediciones(rs.getInt("mediciones"));
            ca.setInstrumento(instrumento(rs));
            return ca;
        } catch (SQLException ex) {
            return null;
        }
    }
    public void CalibracionAdd(Calibracion nuevo) throws Exception {
       String sql="insert into calibracion (numero, instrumento, fecha, mediciones) "+
                "values('%d','%s','%s','%d')";
        int año = nuevo.getFecha().getYear()+1900;
        String fecha = año+"-"+nuevo.getFecha().getMonth()+"-"+nuevo.getFecha().getDay();
        sql=String.format(sql,nuevo.getNumero(),nuevo.getInstrumento().getSerie(),fecha,nuevo.getMediciones());
               
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Calibracion ya existe");
        }
    }
    public void CalibracionUpdate(Calibracion update) throws Exception {
        String sql = "update calibracion set fecha='%s', mediciones='%d'"
        +" where numero ='%d'";
        int año = update.getFecha().getYear()+1900;
        String fecha = año+"-"+update.getFecha().getMonth()+"-"+update.getFecha().getDay();
        sql=String.format(sql,fecha,update.getMediciones(), update.getNumero());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("calibracion no existe");
        }
    }
    public void CalibracionDelete(Calibracion seleccionada)  throws Exception{
        String sql = "delete from calibracion where fecha='%s'";
        sql = String.format(sql, seleccionada.getFecha());
        int count = db.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Calibracion no existe");
        }
    }
    
    // ====== METODOS PARA MEDIDA ======
    private Medida medida(ResultSet rs) {
        try {
            Medida m = new Medida();
            m.setCalibracion(rs.getInt("calibracion"));
            m.setReferencia(rs.getInt("referencia"));
            m.setLectura(rs.getInt("lectura"));
            m.setMedida(rs.getInt("medida"));
            return m;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public List<Medida> MedidaGet(String calibracion) throws Exception {
        List<Medida> result = new ArrayList();
        try{
        String sql = "select * from medida m where m.calibracion= '%s'";
        sql = String.format(sql, calibracion);
        ResultSet rs = db.executeQuery(sql);
        Medida aux;
        while(rs.next()){
            aux = medida(rs);
            aux.setCalibracion(parseInt(calibracion));
            result.add(aux);
        }
        }catch(SQLException ex){}
        return result;
    }

    public void MedidaAdd(Medida m) throws Exception{
        String sql="insert into medida (calibracion, medida, referencia, lectura )"+
                "values('%d','%d','%d','%d')";
        sql=String.format(sql,m.getCalibracion(), m.getMedida(), m.getReferencia(), m.getLectura());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Medida ya existe");
        }
    }

    public void MedidaUpdate(Medida m) throws Exception{
        String sql="update medida set referencia='%d', lectura='%d' "+
                "where calibracion='%d'";
        sql=String.format(sql, m.getReferencia(), m.getLectura(), m.getCalibracion());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Medida no existe");
        }
    }
    
    public void MedidaDelete(Medida m) throws Exception{
        String sql="delete from Medida where calibracion='%d'";
        sql = String.format(sql, m.getCalibracion());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Medida no existe");
        }
    }
    public  void close(){
    }

   

    

   

    

    

    
}