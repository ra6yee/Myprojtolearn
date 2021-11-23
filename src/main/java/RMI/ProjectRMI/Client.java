package src.java.RMI.ProjectRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static final  String UNIQUE_BINDING_NAME="serv.calc";

    public static void main(String[] args) throws RemoteException, NotBoundException {
        final Registry registry= LocateRegistry.getRegistry(2099);
    Calculator calculator=(Calculator) registry.lookup(UNIQUE_BINDING_NAME);
    int rezult=calculator.multiple(20,2);
        System.out.println(rezult);
    }
}
