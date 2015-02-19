package application;

import java.net.URL;

import static java.util.Collections.list;



import java.util.ResourceBundle;
import java.util.StringTokenizer;

import Model.LectureUVFichier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Caroline Chabert
 */
public class SapForViewController implements Initializable {
    @FXML
    private Tab formations;
    @FXML
    private ListView<String> listUV;
    @FXML
    private TextArea descrArea;
    @FXML
    private TextArea infoArea;
    @FXML
    private ListView<String> sessionArea;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    // le clic sur l'onglet formation déclenche l'apparition des UV
    @FXML
    private void OnClicFormation(Event event) {
    	LectureUVFichier fichierUV = new LectureUVFichier("ressources/UVname", 0);
    	ObservableList<String> items =FXCollections.observableArrayList (fichierUV.getListUV());
    	listUV.setItems(items);
    }
    
    // le clic sur chaque UV entraine l'apparition de la description et des sessions
    @FXML
    void OnClicUV(Event event) {
    	
    	String items =listUV.getSelectionModel().getSelectedItem();
    	
    	LectureUVFichier fichierDescr = new LectureUVFichier("ressources/Descr"+ items, 0);
    	String description = fichierDescr.getDescription();
    	descrArea.setText(description);

    	LectureUVFichier fichierSession = new LectureUVFichier("ressources/Session"+ items, 0);
    	
    	ObservableList<String> itemssession =FXCollections.observableArrayList (fichierSession.getListSession());
    	sessionArea.setItems(itemssession);
    	
    }
    
    // le clic sur chaque session entraine l'apparition des infos détaillées
    @FXML
    void OnClicSession(Event event) {
    	String items =sessionArea.getSelectionModel().getSelectedItem();
    	
    	StringTokenizer lst = new StringTokenizer(items);
    	String mot = lst.nextToken();
    	LectureUVFichier fichierInfo = new LectureUVFichier("ressources/Info"+ mot, 0);
    	String info = fichierInfo.getDescription();
    	infoArea.setText(info);
      
  
    }
}