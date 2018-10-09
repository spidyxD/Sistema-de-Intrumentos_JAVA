/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.presentacion.calibracion;

import instrumentos.logic.Model;

/**
 *
 * @author Addiel
 */
public class CalibracionController {
    CalibracionModel model;
    CalibracionesView view;
    Model domainModel;

    public CalibracionController(CalibracionModel model, CalibracionesView view, Model domainModel) {
        model.init();
        this.model = model;
        this.view = view;
        this.domainModel = domainModel;
       // view.setController(this);
        //view.setModel(model);
    }
            
}
    

