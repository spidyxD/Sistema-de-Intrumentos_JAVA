/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.calibracion;

import instrumentos.entidades.Calibracion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Addiel
 */
public class CalibracionesTableModel  extends AbstractTableModel{
    List<Calibracion> rows;
    int[] cols;
     public  CalibracionesTableModel(int[] cols, List<Calibracion> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    @Override
    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case FECHA: return String.class;
            case MEDICIONES: return String.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    @Override
    public int getRowCount() {
        return rows.size();
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        Calibracion obj = rows.get(row);
        switch (cols[col]){
            case FECHA: return obj.getFecha();
            case MEDICIONES: return obj.getMediciones();
            default: return "";
        }
    }    
    
    public Calibracion getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int FECHA=0;
    public static final int MEDICIONES=1;
    String[] colNames = new String[2];
    private void initColNames(){
        colNames[FECHA]= "Fecha";
        colNames[MEDICIONES]= "Mediciones";
        
       
    }
}
