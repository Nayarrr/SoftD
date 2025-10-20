import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.ChatIF;
import server.EchoServer;

public class ServerConsole implements ChatIF{

    final public static int DEFAULT_PORT = 5555;


    EchoServer server;

      /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
    public ServerConsole(int port) {
        try {
            this.server = new EchoServer(port, this);
        } catch (IOException e) {
            System.err.println("Constructor of ServerConsole");
            e.printStackTrace();
        }
    }

    @Override
    public void display(String message){
        System.out.println("> " + message);
    }

    public void accept(){
        try
        {
        BufferedReader fromConsole = 
            new BufferedReader(new InputStreamReader(System.in));
        String message;

        while (true) 
        {
            message = fromConsole.readLine();
            server.handleMessageFromServerUI(message);
        }
        } 
        catch (Exception ex) 
        {
        System.out.println
            ("Unexpected error while reading from console!");
        }
    }

    public static void main(String[] args) {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    ServerConsole sv = new ServerConsole(port);
    
    try 
    {
      sv.server.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }

}