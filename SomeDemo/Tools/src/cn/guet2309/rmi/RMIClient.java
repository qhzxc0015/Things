package cn.guet2309.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiInterface.HelloService;

public class RMIClient {
	public static void main(String[] args) throws Exception {
        /*String url = "rmi://localhost:1099/demo.zookeeper.remoting.server.HelloServiceImpl";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.say("jeck");
        System.out.println(result);*/
		new RMIClient().run();
    }
	
	public void run(){
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 8888);
			HelloService service = (HelloService) registry.lookup("remoteServer");
			String result = service.say("jeck");
			System.out.println(result);
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
