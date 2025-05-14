import java.io.*;
import java.net.*;
import java.util.Vector;


public class ChatServer {
    ServerSocket serverSocket;

    public ChatServer() {
        try{
            serverSocket = new ServerSocket(5005);
            while (true) {
                // To let more than 1 client connect
                Socket s = serverSocket.accept();
                new ChatHandler(s);
            }
        }catch (IOException e) {
                e.printStackTrace(); // Handle IO errors
            }
    }
    
    public static void main(String[] args) {
        new ChatServer();
    }
}


class ChatHandler extends Thread {
    DataInputStream dis;
    PrintStream ps; // recived msg
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();

    public ChatHandler(Socket cs) {
        try{
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            ChatHandler.clientsVector.add(this);
            ps.println("Hello from server");
            start();
        }
        catch (IOException e) {
            e.printStackTrace(); // Handle IO errors
        }
        
    }
    
    public void run() {
        try{
            while (true) {
                // Listen to incomming msg (from client)    
                String str = dis.readLine();
                if (str != null) {
                    System.out.println("Client Says: "+str);
                    // Send incomming msg to server
                    sendMessageToAll(str);
                }
            }
            
        }catch (IOException e) {
            e.printStackTrace(); // Handle IO errors
            }
        }
        
        void sendMessageToAll(String msg) {
            for (int i = 0; i < clientsVector.size(); i++) {
                // send msq for all client 
                clientsVector.get(i).ps.println(msg);
            }
    }
}



