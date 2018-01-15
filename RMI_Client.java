import java.rmi.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.*;

public class RMI_Client {
	public static void main(String args[])
	{
		try
		{
			int choice;
			Scanner in =new Scanner(System.in);
			String name = "//"+args[0]+"/RMI_Server";
			RMI_Interface server =  (RMI_Interface) Naming.lookup(name);
			
			do
			{
 
				System.out.print("\n 1. Return Current Directory Path \n 2. Sort Array  \n 3. Echo Client \n 4. Check if File Exist \n 5. Matrix Multiplication \n 6. Exit \n Enter your choice:");
				choice = in.nextInt();
				
				switch(choice)
				{
					case 1:
					    System.out.println("\n Current working directory:"+server.pwd_command());
						break;
						
					case 2: 
						int size;
						System.out.print("\n Enter Size:");
						in.nextLine();
						size = in.nextInt();
						
						List<Integer> list = new ArrayList(); 
						for (int i=0;i<size;i++)
						{
							System.out.print("\n Enter Element "+(i+1)+":");
							in.nextLine();
							list.add(in.nextInt());
						}
						
					    System.out.println("\n Sorted Array:"+server.sort(list));
						break;
						
					case 3:
						String input;
						in.nextLine();
						System.out.print("\n Enter String:");
						input = in.nextLine();
						System.out.println("\n Echo:"+server.echo_client(input));
						break;
						
					case 4:
						String fileName;
						in.nextLine();
						System.out.print("\n Enter File Name:");
						fileName = in.nextLine();
						System.out.println("\n "+fileName+" : "+server.check_if_file_exist(fileName));
						break;
						
					case 5: 
						int matrix1_row,matrix2_row,matrix1_column,matrix2_column;
						//Matrix 1 Inputs
						System.out.print("\n Enter number of rows for matrix1:");
						in.nextLine();
						matrix1_row= in.nextInt();
						System.out.print("\n Enter number of columns for matrix1:");
						in.nextLine();
						matrix1_column = in.nextInt();
						int [][] matrix1 = new int[matrix1_row][matrix1_column];
						
						for(int i=0;i<matrix1_row;i++)
						{
							for(int j=0;j<matrix1_column;j++)
							{
								System.out.print("\n Matrix1["+i+"]["+j+"]:");
								in.nextLine();
								matrix1[i][j] = in.nextInt();
							}
						}
						
						//Matrix 2 Inputs
						System.out.print("\n Enter number of rows for matrix2:");
						in.nextLine();
						matrix2_row= in.nextInt();
						
						System.out.print("\n Enter number of columns for matrix2:");
						in.nextLine();
						matrix2_column = in.nextInt();
						
						int [][] matrix2 = new int[matrix2_row][matrix2_column];
						
						
						for(int i=0;i<matrix2_row;i++)
						{
							for(int j=0;j<matrix2_column;j++)
							{
								System.out.print("\n Matrix2["+i+"]["+j+"]:");
								in.nextLine();
								matrix2[i][j] = in.nextInt();
							}
						}
						
						//Result Matrix
						int[][] result = new int[matrix1_row][matrix2_column];
						try
						{
							result = server.Matrix_Multiplication(matrix1, matrix2);
						}
						// this catch block is to catch illegal input parameters for matrix multiplication
						catch(IllegalArgumentException ie) 
						{
							System.out.println(""+ ie.toString());
							break;
						}
						System.out.println("\n Matrix Multiplication");
						
						for(int i=0;i<matrix1_row;i++)
						{
							System.out.println("");
							for(int j=0;j<matrix2_column;j++)
							{
								System.out.print(" "+result[i][j]+ "\t");
							}
						}
						break;
						
					case 6:
						System.out.println("\n Exit");
					    break;
					    
					default:System.out.println("\n Wrong choice");
				}
				
			}while(choice!=6);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}		

}
