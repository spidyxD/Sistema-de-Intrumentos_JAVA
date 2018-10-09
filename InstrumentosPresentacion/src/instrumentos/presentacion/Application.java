
package instrumentos.presentacion;
import instrumentos.logic.Model;
import instrumentos.presentacion.calibracion.CalibracionesController;
import instrumentos.presentacion.calibracion.CalibracionModel;
import instrumentos.presentacion.calibracion.CalibracionesModel;
import instrumentos.presentacion.calibracion.CalibracionesView;
import instrumentos.presentacion.calibracion.Medida.MedidasModel;
import instrumentos.presentacion.instrumento.InstrumentoModel;
import instrumentos.presentacion.instrumento.InstrumentoController;
import instrumentos.presentacion.instrumento.InstrumentoView;
import instrumentos.presentacion.instrumento.InstrumentosModel;
import instrumentos.presentacion.instrumento.InstrumentosController;
import instrumentos.presentacion.instrumento.InstrumentosView;
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentoController;
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentoModel;
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentoView;
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentosController;
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentosModel;
import instrumentos.presentacion.tipoinstrumento.TipoInstrumentosView;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Application {

    public static void main (String[] args) {
        Model domainModel = Model.instance();
 
        AppView appView= new AppView();
        
        TipoInstrumentoModel tipoInstrumentoModel = new TipoInstrumentoModel();
        TipoInstrumentosModel tipoInstrumentosModel = new TipoInstrumentosModel();
        
     
        TipoInstrumentosView tipoInstrumentosView= new TipoInstrumentosView();
        TIPOINSTRUMENTOS_VIEW=tipoInstrumentosView;
        TipoInstrumentosController tipoInstrumentoscontroller = new TipoInstrumentosController(tipoInstrumentosView,tipoInstrumentosModel,domainModel);
        appView.addInternalFrame(tipoInstrumentosView);

        
        TipoInstrumentoView tipoInstrumentoView = new TipoInstrumentoView();
        TIPOINSTRUMENTO_VIEW=tipoInstrumentoView;
        TipoInstrumentoController tipoinstrumentocontroller = new TipoInstrumentoController(tipoInstrumentoView,tipoInstrumentoModel,domainModel);
        appView.addInternalFrame(tipoInstrumentoView);
 
      
        
        InstrumentosModel InstrumentosModel= new InstrumentosModel();
       
        InstrumentoModel InstrumentoModel = new InstrumentoModel();
       
        CalibracionesModel CalibracionesModel = new CalibracionesModel();
        
        MedidasModel MedidasModel = new MedidasModel();
        
        InstrumentoView instView = new InstrumentoView();
        INSTRUMENTOVIEW = instView;
        InstrumentoController Instrumentocontroller = new InstrumentoController(instView,InstrumentoModel,domainModel);
        appView.addInternalFrame(instView);
        InstrumentosView instrumsView = new InstrumentosView();
        INSTRUMENTOSVIEW = instrumsView;
        InstrumentosController Instrumentoscontroller = new InstrumentosController(instrumsView,InstrumentosModel,domainModel);
        appView.addInternalFrame(instrumsView);
        CalibracionesView calView = new CalibracionesView();
        CALIBRACIONES_VIEW = calView;
        CalibracionesController  Calibracionescontroller = new  CalibracionesController(calView,CalibracionesModel,MedidasModel,domainModel);
        appView.addInternalFrame(calView);
        appView.setVisible(true);
    }
    public static TipoInstrumentoView TIPOINSTRUMENTO_VIEW;
    public static TipoInstrumentosView TIPOINSTRUMENTOS_VIEW;    
    public static InstrumentoView INSTRUMENTOVIEW;
    public static InstrumentosView INSTRUMENTOSVIEW;  
    public static CalibracionesView CALIBRACIONES_VIEW;
    public static final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
}
