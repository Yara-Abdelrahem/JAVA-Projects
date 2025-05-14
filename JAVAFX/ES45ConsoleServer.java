import java.io.*;
import java.net.*;

public class ES45ConsoleServer{

    private ServerSocket server;
    private Socket client;
    private DataInputStream input;
    private PrintStream output;
    
    public ES45ConsoleServer(){
        try {
            server = new ServerSocket(5005);
            client = server.accept();
            input = new DataInputStream(client.getInputStream());
            output = new PrintStream(client.getOutputStream());
            String msg = input.readLine();
            System.out.println("Client Says: "+msg);
            output.println("Hello from server");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                server.close();
                client.close();
                output.close(); 
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ES45ConsoleServer();
    }
    
}
    

