import java.rmi.*;
import java.util.*;

public interface RMI_Interface extends Remote
{
	String pwd_command() throws RemoteException;
	List<Integer> sort(List<Integer> list) throws RemoteException;
	String echo_client(String input) throws RemoteException;
	String check_if_file_exist(String fileName) throws RemoteException;
	int [][] Matrix_Multiplication(int[][] matrix1, int[][] matrix2) throws RemoteException;
}
