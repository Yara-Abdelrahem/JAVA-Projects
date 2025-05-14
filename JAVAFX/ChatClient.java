import java.io.*;
import java.net.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform ;
public class ChatClient extends Application  {     
    Scene myS;
    BorderPane bpane;
    FlowPane flowPane;
    static TextArea ChatArea;
    TextArea SendMsgArea;
    Button SendButton;
    static ChatClientHandler chathandler;
    
        //UI
        public void init() throws Exception {
                ChatArea = new TextArea();
    
                SendMsgArea = new TextArea();
                SendMsgArea.setMaxHeight(50.0);
    
                SendButton = new Button("Send");
    
                flowPane = new FlowPane(25,10,SendMsgArea, SendButton);
                flowPane.setPrefHeight(60); 
                
                bpane=new BorderPane();
                bpane.setTop(ChatArea);
                bpane.setBottom(flowPane); 
    
            }
            @Override
            public void start(Stage primaryStage) throws Exception {
                
                Scene scene = new Scene(bpane, 700,500);
                primaryStage.setTitle("Chat Application");
                primaryStage.setScene(scene);
                primaryStage.show();
    
                
                SendButton.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        chathandler.output.println(SendMsgArea.getText());
                        SendMsgArea.clear();
                    }
                });
            }
            public void appendMessage(String message) {
                ChatArea.appendText("Server: " + message + "\n");
            }
            public static void main(String[] args) {
            chathandler = new ChatClientHandler();
        Application.launch(args);
    }
    
}
    

class ChatClientHandler extends Thread {
    Socket server;
    DataInputStream input;
    PrintStream output;

    public ChatClientHandler(){
        try {
            server = new Socket("127.0.0.1",5005);
            input = new DataInputStream(server.getInputStream());
            output = new PrintStream(server.getOutputStream());
            //output.println("Can you hear me ?");
            this.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        String msg;
        try {
            while (true) {
                msg = input.readLine();
                System.out.println("Server Says: "+ msg);
                final String message =msg;
                Platform.runLater(() -> {
                    ChatClient.ChatArea.appendText("Server: " + message+ "\n");
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}