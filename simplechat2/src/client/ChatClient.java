// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.*;
import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient{
  
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public ChatClient(String host, int port, ChatIF clientUI) throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
    clientUI.display(msg.toString());
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message){
      if (!this.isConnected()){
        if (message.startsWith("#login")){
          try {
            openConnection();
          } 
          catch (IOException e) {
            System.err.println("Erreur dans le login");
            e.printStackTrace();
          }
        }

        if (message.startsWith("#sethost")){
          String[] words = message.split(" ");
          this.setHost(words[1]);
          clientUI.display("Host changé en : " + words[1]);
        }

        if (message.startsWith("#setport")){
          String[] word = message.split(" ");
          int newPort = Integer.valueOf(word[1]);
          this.setPort(newPort);
          clientUI.display("Port changé en : " + newPort);
        }
      }
      else{
        if (message.startsWith("#login")){
          clientUI.display("Vous etes déjà connecté");
        }
        if (message.startsWith("#logout")){
          try{
            closeConnection();
          }
          catch (IOException e){
            System.err.println("Erreur dans le logout");
            e.printStackTrace();
          }
        }
      }
      if (message.startsWith("#quit")){
        try{
          closeConnection();
          System.exit(0);
        }
        catch (IOException e){
          System.err.println("Erreur dans le quit");
          e.printStackTrace();
        }
      }
      if (message.startsWith("#gethost")){
        clientUI.display("Current Host : " + this.getHost());
      }

      if (message.startsWith("#getport")){
        clientUI.display("Current Port : " + this.getPort());
      }

      if (this.isConnected()){
        try{
          sendToServer(message);
        }
        catch(IOException e){
          clientUI.display("Could not send message to server.  Terminating client.");
        }
      }
  }

  protected void connectionEstablished() {
    clientUI.display("Connexion réussie !");
  }
  
  protected void connectionClosed(){
    clientUI.display("Connexion fermée ! ");
  }

  protected void connectionException(Exception exception){
    clientUI.display("Il y a probleme ici ! ");
  }

}
//End of ChatClient class
