/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.tipoinstrumento;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import instrumentos.entidades.TipoInstrumento;
public class TipoInstrumentoTableModel extends AbstractTableModel{
    List<TipoInstrumento> rows;
    int[] cols;
    public  TipoInstrumentoTableModel(int[] cols, List<TipoInstrumento> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case CODIGO: return String.class;
            case NOMBRE: return String.class;
            case UNIDAD: return String.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        TipoInstrumento ti = rows.get(row);
        switch (cols[col]){
            case CODIGO: return ti.getCodigo();
            case NOMBRE: return ti.getNombre();
            case UNIDAD: return ti.getUnidad();
            default: return "";
        }
    }

    public TipoInstrumento getRowAt(int row) {
        return rows.get(row);
    }
    
    public List<TipoInstrumento> getRows() {
        return rows;
    }
    
    public static final int CODIGO=0;
    public static final int NOMBRE=1;
    public static final int UNIDAD=2;
    
    
    String[] colNames = new String[3];
    private void initColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE]= "Nombre";
        colNames[UNIDAD]= "Unidad";
    }
            
}