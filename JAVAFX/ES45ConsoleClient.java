import java.io.*;
import java.net.*;

public class ES45ConsoleClient{

    private Socket server;
    private Socket client;
    private DataInputStream input;
    private PrintStream output;
    
    public ES45ConsoleClient(){
        try {
            server = new Socket("127.0.0.1",5005);
            //client = server.accept();
            input = new DataInputStream(server.getInputStream());
            output = new PrintStream(server.getOutputStream());
            output.println("Can you hear me ?");
            String msg = input.readLine();
            System.out.println("Server Says: "+msg);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                server.close();
                output.close(); 
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ES45ConsoleClient();
    }
    
}
    

