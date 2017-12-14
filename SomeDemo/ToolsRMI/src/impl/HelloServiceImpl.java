package impl;

import java.rmi.RemoteException;

import rmiInterface.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String say(String name) throws RemoteException {
		System.out.println(name);
		 return String.format("Hello %s", name);
	}

}
