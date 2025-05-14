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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class Notepad extends Application {

    Scene myS;

    BorderPane bpane;
    MenuBar mbar;
    Menu file;
    MenuItem new_item;
    MenuItem open_item;
    MenuItem save_item;
    MenuItem exit_item;

    Menu edit;
    MenuItem undo;
    MenuItem cut;
    MenuItem copy;
    MenuItem paste;
    MenuItem delete;
    MenuItem selectall;

    Menu help;
    MenuItem about;
    Alert alert ;

    TextArea text_area;

    FileChooser fileChooser;

    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    private void openLowLevel(Stage primaryStage) {
        fileChooser.setTitle("Open");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try {
                FileInputStream fis = new FileInputStream(file);
                int size = fis.available();
                byte[] b = new byte[size];
                fis.read(b);
                text_area.setText(new String(b));
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace(); // Handle file not found
            } catch (IOException e) {
                e.printStackTrace(); // Handle IO errors
            }
        }

    }
    private void saveLowLevel(Stage primaryStage){
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        File file =fileChooser.showSaveDialog(primaryStage);
        if(file != null)
        {
            try{
                FileOutputStream fos = new FileOutputStream(file);
                byte[] b = text_area.getText().getBytes();
                fos.write(b);
                fos.close();
            }catch (FileNotFoundException e) {
                e.printStackTrace(); // Handle file not found
            } catch (IOException e) {
                e.printStackTrace(); // Handle IO errors
            }
        }
        
    }


    private void openHighLevel(Stage primaryStage) {
        fileChooser.setTitle("Open");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try {
                DataInputStream fis = new DataInputStream(new FileInputStream(file));
                String text =fis.readUTF();
                text_area.setText(text);
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace(); // Handle file not found
            } catch (IOException e) {
                e.printStackTrace(); // Handle IO errors
            }
        }

    }
    private void saveHighLevel(Stage primaryStage){
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        File file =fileChooser.showSaveDialog(primaryStage);
        if(file != null)
        {
            try{
                DataOutputStream fos = new DataOutputStream(new FileOutputStream(file));
                fos.writeUTF(text_area.getText().toString());
            }catch (FileNotFoundException e) {
                e.printStackTrace(); // Handle file not found
            } catch (IOException e) {
                e.printStackTrace(); // Handle IO errors
            }
        }
        
    }


    @Override
    public void init() throws Exception {
        super.init(); 
        text_area= new TextArea();
        new_item=new MenuItem("New");
        open_item = new MenuItem("Open");
        save_item = new MenuItem("Save");
        exit_item = new MenuItem("Exit");
        
        file=new Menu("File");
        file.getItems().addAll(new_item ,open_item, save_item ,new SeparatorMenuItem() ,exit_item);

        fileChooser = new FileChooser();
        
        undo = new MenuItem("Undo");
        cut = new MenuItem("Cut");
        copy = new MenuItem("Copy");
        paste=new MenuItem("Paste");
        delete = new MenuItem("Delete");
        selectall = new MenuItem("Select All");
        
        edit=new Menu("Edit");
        edit.getItems().addAll(undo ,new SeparatorMenuItem(), cut , copy , paste , delete ,new SeparatorMenuItem() ,selectall);
        
        about = new MenuItem("About Notepad");
        help=new Menu("Help");
        help.getItems().addAll(about);

        mbar=new MenuBar();
        mbar.getMenus().addAll(file , edit , help);
        bpane=new BorderPane();
        bpane.setTop(mbar);
        bpane.setCenter(text_area);

    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        myS=new Scene(bpane,700,500);
        primaryStage.setScene(myS);
        primaryStage.setTitle("ES45 Notepad");
        primaryStage.show();

        text_area.textProperty().addListener((obs, oldText, newText) -> {
            if (!oldText.equals(newText)) {
                undoStack.push(oldText);  // Save previous state
            }
        });
        
        // Node
        new_item.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println(text_area.getText());
                text_area.clear();
           }
        });
        open_item.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //openLowLevel(primaryStage);
                openHighLevel(primaryStage);
           }
        });
        save_item.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //saveLowLevel(primaryStage);
                saveHighLevel(primaryStage);
           }
        });

        undo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            if (!undoStack.isEmpty()) {
                redoStack.push(text_area.getText());
                text_area.setText(undoStack.pop()); 
                }
            }
        });

        cut.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            String selectedText = text_area.getSelectedText();
            if (!selectedText.isEmpty()) {
                text_area.cut();
                
                }
            }
        });
        
        copy.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String selectedText = text_area.getSelectedText();
                if (!selectedText.isEmpty()) {
                    text_area.copy();
                }
            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String selectedText = text_area.getSelectedText();
                if (!selectedText.isEmpty()) {
                    int start = text_area.getSelection().getStart();
                    int end = text_area.getSelection().getEnd();
                    text_area.deleteText(start, end);
                }
            }
        });
        paste.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                if (clipboard.hasString()) {
                    text_area.paste();
                }
            }
        });
        selectall.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                text_area.selectAll();
            }
        });

        exit_item.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        about.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

        alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("About Notepad");
                alert.setHeaderText(null);
                alert.setContentText("Notepad with ES 45 :)");
                alert.showAndWait();
            }
        });        
        
    }
    public static void main(String[] args) {
        
        Application.launch(args);
    }
}
