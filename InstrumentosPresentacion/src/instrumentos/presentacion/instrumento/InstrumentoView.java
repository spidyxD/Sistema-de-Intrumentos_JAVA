/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.instrumento;

import instrumentos.entidades.Instrumento;
import instrumentos.presentacion.Application;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Addiel
 */
public class InstrumentoView extends JInternalFrame implements java.util.Observer{
    InstrumentoController controller;
    InstrumentoModel model;
    
    /**
     * Creates new form InstrumentoView
     */
    public InstrumentoView() {
        super();
        initComponents();
        
    }
    InstrumentoModel getModel() {
       return model;
    }
    public JComboBox<String> getjComboTipo() {
        return jComboTipo;
    }

    public void setjComboTipo(JComboBox<String> jComboTipo) {
        this.jComboTipo = jComboTipo;
    }

    public JTextField getjDescField() {
        return jDescField;
    }

    public void setjDescField(JTextField jDescField) {
        this.jDescField = jDescField;
    }

    public JTextField getjMaxField() {
        return jMaxField;
    }

    public void setjMaxField(JTextField jMaxField) {
        this.jMaxField = jMaxField;
    }

    public JTextField getjMinField() {
        return jMinField;
    }

    public void setjMinField(JTextField jMinField) {
        this.jMinField = jMinField;
    }

    public JTextField getjSerieField() {
        return jSerieField;
    }

    public void setjSerieField(JTextField jSerieField) {
        this.jSerieField = jSerieField;
    }

    public JTextField getjTolField() {
        return jTolField;
    }

    public void setjTolField(JTextField jTolField) {
        this.jTolField = jTolField;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSerie = new javax.swing.JLabel();
        jDescrip = new javax.swing.JLabel();
        jMin = new javax.swing.JLabel();
        jMax = new javax.swing.JLabel();
        jTol = new javax.swing.JLabel();
        jSerieField = new javax.swing.JTextField();
        jMinField = new javax.swing.JTextField();
        jDescField = new javax.swing.JTextField();
        jMaxField = new javax.swing.JTextField();
        jTipo = new javax.swing.JLabel();
        jTolField = new javax.swing.JTextField();
        jComboTipo = new javax.swing.JComboBox<>();
        jSave = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Instrumento");
        setMaximumSize(new java.awt.Dimension(330, 374));
        setMinimumSize(new java.awt.Dimension(330, 374));

        jSerie.setText("Serie");

        jDescrip.setText("Descripción");

        jMin.setText("Minimo");

        jMax.setText("Máximo");

        jTol.setText("Tolerancia");

        jTipo.setText("Tipo");

        jComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/instrumentos/presentacion/icons/save.png"))); // NOI18N
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/instrumentos/presentacion/icons/cancel.png"))); // NOI18N
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDescrip)
                                    .addComponent(jSerie)
                                    .addComponent(jTipo)
                                    .addComponent(jMin))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMax)
                                    .addComponent(jTol))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboTipo, 0, 155, Short.MAX_VALUE)
                            .addComponent(jDescField)
                            .addComponent(jSerieField)
                            .addComponent(jMinField)
                            .addComponent(jMaxField)
                            .addComponent(jTolField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jSave)
                        .addGap(62, 62, 62)
                        .addComponent(jCancel)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSerie)
                    .addComponent(jSerieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDescrip)
                    .addComponent(jDescField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTipo)
                    .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMin)
                    .addComponent(jMinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMax)
                    .addComponent(jMaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTol)
                    .addComponent(jTolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSave)
                    .addComponent(jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveActionPerformed
        try{  
            
        if(!Application.INSTRUMENTOSVIEW.signal){
            this.controller.guardar();
            JOptionPane.showMessageDialog(this, "Instrumento Agregado!", "",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Application.INSTRUMENTOSVIEW.controller.update(Application.INSTRUMENTOSVIEW.row);
           JOptionPane.showMessageDialog(this, "Instrumento Actualizado!", "",JOptionPane.INFORMATION_MESSAGE);
            Application.INSTRUMENTOSVIEW.signal=false;
        }
          
        }
        catch (Exception ex) {
            Logger.getLogger(InstrumentosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSaveActionPerformed

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstrumentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstrumentoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancel;
    public javax.swing.JComboBox<String> jComboTipo;
    public javax.swing.JTextField jDescField;
    private javax.swing.JLabel jDescrip;
    private javax.swing.JLabel jMax;
    public javax.swing.JTextField jMaxField;
    private javax.swing.JLabel jMin;
    public javax.swing.JTextField jMinField;
    private javax.swing.JButton jSave;
    private javax.swing.JLabel jSerie;
    public javax.swing.JTextField jSerieField;
    private javax.swing.JLabel jTipo;
    private javax.swing.JLabel jTol;
    public javax.swing.JTextField jTolField;
    // End of variables declaration//GEN-END:variables
 public void setModel(InstrumentoModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(InstrumentoController controller) {
        this.controller = controller;
    }
    @Override
    public void update(java.util.Observable updatedModel,Object parametros) {
        Instrumento iC=model.getCurrent();
       
        this.jSerieField.setEnabled(model.getModo()==Application.MODO_AGREGAR);
        jSerieField.setText(iC.getSerie());
        
        if (model.getErrores().get("serie")!=null){
            jSerie.setBorder(Application.BORDER_ERROR);
            jSerie.setToolTipText(model.getErrores().get("serie"));
        }
        else{
            jSerie.setBorder(null);
            jSerie.setToolTipText("");
        }
        jDescField.setText(iC.getDescripcion());
        if (model.getErrores().get("descripcion")!=null){
            jDescrip.setBorder(Application.BORDER_ERROR);
            jDescrip.setToolTipText(model.getErrores().get("descripcion"));
        }
        else{
           jDescrip.setBorder(null);
           jDescrip.setToolTipText("");
        }
        jComboTipo.setSelectedItem(iC.getTipo());
        if (model.getErrores().get("tipo")!=null){
            jComboTipo.setBorder(Application.BORDER_ERROR);
            jComboTipo.setToolTipText(model.getErrores().get("tipo"));
        }
        else{
           jComboTipo.setBorder(null);
           jComboTipo.setToolTipText("");
        }
         jMaxField.setText(iC.getDescripcion());
        if (model.getErrores().get("maximo")!=null){
            jMax.setBorder(Application.BORDER_ERROR);
            jMax.setToolTipText(model.getErrores().get("maximo"));
        }
        else{
           jMax.setBorder(null);
           jMax.setToolTipText("");
        }
        jMinField.setText(iC.getDescripcion());
        if (model.getErrores().get("minimo")!=null){
            jMin.setBorder(Application.BORDER_ERROR);
            jMin.setToolTipText(model.getErrores().get("minimo"));
        }
        else{
           jMin.setBorder(null);
           jMin.setToolTipText("");
        }
        jTolField.setText(iC.getDescripcion());
        if (model.getErrores().get("tolerancia")!=null){
            jTol.setBorder(Application.BORDER_ERROR);
            jTol.setToolTipText(model.getErrores().get("tolerancia"));
        }
        else{
           jTol.setBorder(null);
           jTol.setToolTipText("");
        }
        this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
}
