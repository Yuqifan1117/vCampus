package client.socket;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import vcampus.vo.*;
public class clientSocket {
	public Request sendRequestToServer (Request clientRequest ) {
		try {
			
			//client request connection to local host at port 8888"192.168.0.189"
			Socket socket = new Socket("127.0.0.1", 8888);
			//set the connection timeout
			socket.setSoTimeout(1000);
			//create request to be sent to server as ObjectOutputStream
			ObjectOutputStream request = new ObjectOutputStream(socket.getOutputStream());
			request.writeObject(clientRequest);
			request.flush();
			//shut down the output stream
			socket.shutdownOutput();
			
			
			//get the input stream response from server
			ObjectInputStream response = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			Request object = (Request)response.readObject();
			//shut down the output stream
			response.close();
			//shut down socket;
			socket.close();
			
			if (object != null) {
				return object;
			}
		}
		
		catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
