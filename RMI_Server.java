
import java.io.File;
import java.util.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server extends UnicastRemoteObject implements RMI_Interface {

	protected RMI_Server() throws RemoteException {
		super();
	}

	public String pwd_command() throws RemoteException {                                                                                                                                                                                                                                                                         
		return System.getProperty("user.dir");
	}
	
	public List<Integer> sort(List<Integer> list) throws RemoteException {
		Collections.sort(list);
		return list;
	}

	public String echo_client(String input) throws RemoteException {
		return input;
	}

	public String check_if_file_exist(String fileName) throws RemoteException {
		String result;
		File file = new File(fileName);
		if (file.exists() && file.isFile())
		{
			result = "File Exist";
		}
		else
		{
			result = "File Does Not Exist";			
		}
		return result;
	}


	public int[][] Matrix_Multiplication(int[][] matrix1, int[][] matrix2)
			throws RemoteException {
        int matrix1_rows = matrix1.length;
        int matrix1_columns = matrix1[0].length;
        int matrix2_rows = matrix2.length;
        int matrix2_columns = matrix2[0].length;

        if (matrix1_columns != matrix2_rows) 
        {
            throw new IllegalArgumentException("Matrix1 columns " + matrix1_columns + " did not match matrix2 rows " + matrix2_rows);
        }

        int[][] result = new int[matrix1_rows][matrix2_columns];
        for (int i = 0; i < matrix1_rows; i++) {
            for (int j = 0; j < matrix2_columns; j++) {
                result[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix1_rows; i++) { 
            for (int j = 0; j < matrix2_columns; j++) { 
                for (int k = 0; k < matrix1_columns; k++) { 
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
	}
	
	public static void main(String[] args) {
		//System.setSecurityManager(new RMISecurityManager());
		
		try{
			//Create an instance of Server				
			System.out.println("Creating a Server!");	
			String name = "RMI_Server";				
			RMI_Server server = new RMI_Server();
			System.out.println("Binding it to name:" + name);
			Naming.rebind(name, server);		
			System.out.println("Server is Ready!");	
			
		} catch (Exception e){			
			System.out.println("Exception Occurred: " + e.getMessage());	
			e.printStackTrace();
	}		

	}

}
