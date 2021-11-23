package src.java.RMI.ProjectRMI;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//это класс сервер
 class ServerImpl implements Calculator {

    @Override
    public int multiple(int x, int y)throws RemoteException {
        return x*y;
    }
}
//это интерфейс, необходим потому что технология rmi  основана на прокси динамическом, которая в свою очередь, нработает с интерфейсами
interface Calculator extends Remote{
 int multiple(int x, int y) throws RemoteException;
}
// теперь создаем непосредственно сервер программу
public class Server{
     public static final  String UNIQUE_BINDING_NAME="serv.calc";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        final ServerImpl si=new ServerImpl();
        final Registry registry= LocateRegistry.createRegistry(2099);
        Remote stub= UnicastRemoteObject.exportObject(si,0);
        registry.bind(UNIQUE_BINDING_NAME,stub);
Thread.sleep(Integer.MAX_VALUE);
    }
}