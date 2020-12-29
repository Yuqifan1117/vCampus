package client.socket;
import vcampus.vo.*;
import vcampus.server.*;
import vcampus.server.socket.Server;
import client.socket.*;
public class test {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		
		Request testSample=new Request();
		testSample.setRequest_ID(913);
		clientSocket Sample=new clientSocket();
		Request Result=Sample.sendRequestToServer(testSample);
		System.out.println(Result.getRequest_ID());
	}
}
