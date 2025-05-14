import java.util.Stack;
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.Clipboard;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Home extends Application{

    Scene myScene;
    BorderPane bpane;
    Label Num_Spot;

    @Override
    public void init() throws Exception {
        super.init(); 
        bpane=new BorderPane();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        myScene=new Scene(bpane,700,500);
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Entry-Exit Gate");
        primaryStage.show();
    }

    public static void main(String[] args) {
        
        Application.launch(args);
    }
    
}
