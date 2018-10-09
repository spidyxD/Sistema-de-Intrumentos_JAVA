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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Addiel
 */
public class InstrumentosTableModel extends AbstractTableModel{
    List<Instrumento> rows;
    int[] cols;
    Model domainModel;
    
    public  InstrumentosTableModel(int[] cols, List<Instrumento> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    //@Override
    public int getColumnCount() {
        return cols.length;
    }

   // @Override
    public String getColumnName(int col){
        return colNames[cols[col]];
    }

   // @Override
    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case SERIE: return String.class;
            case TIPO: return String.class;
            case DESC: return String.class;
            case MAX: return String.class;
            case MIN: return String.class;
            case TOL: return String.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
   // @Override
    public int getRowCount() {
        return rows.size();
    }

   
    @Override
    public Object getValueAt(int row, int col) {
        Instrumento inst = rows.get(row);
        switch (cols[col]){
            case SERIE: return inst.getSerie();
            case TIPO: return inst.getTipo().getNombre();
            case DESC: return inst.getDescripcion();
            case MAX: return  inst.getMaximo();
            case MIN: return  inst.getMinimo();
            case TOL: return  inst.getTolerancia();
            default: return "";
        }
    }    
    public String tipos(Instrumento i,int row) throws Exception{
        List<String>  tipos = new ArrayList();
        String s = "";
             //tipos = domainModel.tipoIns();
            // s = tipos.get(row);
        return s;
    }
    public Instrumento getRowAt(int row) {
        return rows.get(row);
    }

    public List<Instrumento> getRows() {
        return rows;
    }

    
    public static final int SERIE=0;
    public static final int TIPO=1;
    public static final int DESC=2;
    public static final int MAX=3;
    public static final int MIN=4;
    public static final int TOL=5;

    
    String[] colNames = new String[6];
    private void initColNames(){
        colNames[SERIE]= "Serie";
        colNames[DESC]= "Descripción";
        colNames[TIPO]= "Tipo";
        colNames[MAX]= "Maximo";
        colNames[MIN]= "Minimo";
        colNames[TOL]= "Tolerancia";
    
    }
            
}
 

 
