/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.calibracion.Medida;

import instrumentos.entidades.Medida;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Addiel
 */
public class MedidaTableModel extends AbstractTableModel{
    List<Medida> rows;
    int[] cols;

    public  MedidaTableModel(int[] cols, List<Medida> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public MedidaTableModel() {
        this.cols = new int[2];
        this.rows = new ArrayList();
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
            case 0: case 1: case 2:
                return Integer.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    @Override
    public int getRowCount() {
        return rows.size();
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        Medida obj = rows.get(row);
        switch (cols[col]){
            //case MEDIDA: return obj.getMedida();
            case REFERENCIA: return obj.getReferencia();
            case LECTURA: return obj.getLectura();
            default: return "";
        }
    }    

    @Override
    public void setValueAt(Object value, int row, int col) {
        Medida obj = rows.get(row);
        switch (cols[col]){
            //case MEDIDA: {obj.setMedida((int)value); break;}
            case REFERENCIA: {obj.setReferencia((int)value); break;}
            case LECTURA: {obj.setLectura( (int) value); break;}
            default: ;
        }        
    }   
    
    public Medida getRowAt(int row) {
        return rows.get(row);
    }
    public List<Medida> getRows() {
        return rows;
    }

    public void setRows(List<Medida> rows) {
        this.rows = rows;
    }
    @Override
    public boolean isCellEditable(int row,int col){
        return true;
    }
    //public static final int MEDIDA=0;
    public static final int REFERENCIA=0;
    public static final int LECTURA=1;
 
   
    String[] colNames = new String[2];
    private void initColNames(){
        //colNames[MEDIDA]= "Medida";
        colNames[REFERENCIA]= "Referencia";
        colNames[LECTURA]= "Lectura";
    }
            
}
