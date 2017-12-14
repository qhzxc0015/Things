package server;

import impl.HelloServiceImpl;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmiInterface.HelloService;

public class RMIServer {
	
	public static void main(String[] args) throws Exception {
       /* int port = 1099;
        String url = "rmi://localhost:1099/server.HelloServiceImpl";
        LocateRegistry.createRegistry(port);
        Naming.rebind(url, new HelloServiceImpl());*/
		new RMIServer().run();
    }
	
	public void run(){
		HelloService service = new HelloServiceImpl();
		try {
			HelloService rStub = (HelloService) UnicastRemoteObject.exportObject(service, 0);
			Registry registry = LocateRegistry.createRegistry(8888);
			registry.bind("remoteServer", rStub);
			System.err.println("datanode remoteServer ready");
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
