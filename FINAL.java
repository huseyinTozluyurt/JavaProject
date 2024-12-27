import java.util.Scanner;

public class project1 {

    static int getrow()
    {
        Scanner input =new Scanner(System.in);
        return input.nextInt();
    }
    
    static int getcolumn()
    {
        Scanner input =new Scanner(System.in);
        return input.nextInt();
    }
    
    static double getScalar()
    {
        Scanner input =new Scanner(System.in);
        return input.nextDouble();
    }
    
    static double[][] getMatrix(int row, int column)
    {
        Scanner input =new Scanner(System.in);
        double[][] matrix= new double [row][column];
        //getting the first matrix
        System.out.print("Enter your matrix: ");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                double arrayElement;
                arrayElement= input.nextDouble();
                matrix[i][j]=arrayElement;
            }
        }
        return matrix;
    }
    static void ascii()
    {
  		System.out.println("|  _________________  |");
  		System.out.println("| | JO           0. | |");
  		System.out.println("| |_________________| |");
  		System.out.println("|  ___ ___ ___   ___  |");
  		System.out.println("| | 7 | 8 | 9 | | + | |");
  		System.out.println("| |___|___|___| |___| |");
  		System.out.println("| | 4 | 5 | 6 | | - | |");
  		System.out.println("| |___|___|___| |___| |");
  		System.out.println("| | 1 | 2 | 3 | | x | |");
  		System.out.println("| |___|___|___| |___| |");
  		System.out.println("| | . | 0 | = | | / | |");
  		System.out.println("| |___|___|___| |___| |");
  		System.out.println("|_____________________|");
  	
  		System.out.println("Eren Can Gunel");
  		System.out.println("Huseyin Tozluyurt");
        System.out.println("Tan Demiryurek");
        System.out.println("Yigit Keser");
        System.out.println("Yigit Senoglu");
    }
  public static void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void printMatrix(double[][] matrix, int row, int column)
    {
        {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++)
                    System.out.print(matrix[i][j] + ", ");

                System.out.println();
            }
        }
    }
    
    static double[][] matrixAddition(double[][] matrix1,double[][] matrix2, int row, int column){
        double[][] matrix3 = new double[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrix3;
    }
    
    static double[][] matrixSubtraction(double[][] matrix1,double[][] matrix2, int row, int column){
        double[][] matrix3 = new double[row][column];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrix3;
    }
    
    static double[][] matrixMultiplication(double[][] matrix1,int rows1,int columns1,double[][] matrix2, int rows2, int columns2){
        double[][] matrix3 = new double[rows1][columns2];
        for(int i = 0; i < rows1; i++) {
            for(int j = 0; j < columns2; j++) {
                for(int k =0; k < rows2; k++) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrix3;
    }
    
    static  double[][] scalarDivision(double[][] matrix, int rows, int columns, double scalar)
    {
        double[][] matrix3 = new double[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix3[i][j] = matrix[i][j] / scalar;
            }
        }
        return matrix3;
    }
    
    static  double[][] scalarMultiplicaiton(double[][] matrix, int rows, int columns, double scalar)
    {
        double[][] matrix3 = new double[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix3[i][j] = matrix[i][j] * scalar;
            }
        }
        return matrix3;
    }
    
    static double[][] matrixTranspose(double[][] matrix, int rows, int columns)
    {
        double[][] matrix3 = new double[columns][rows];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {

                matrix3[j][i] = matrix[i][j];
            }
        }
        return matrix3;
    }
    
    static double[][] matrixInverse(double[][] matrix, int row, int column) 
    {
        double matrix3[][] = new double[row][column];
        double subMatrix[][] = new double[row][column];
        int index[] = new int[row];
        for (int i=0; i<column; ++i) 
        	subMatrix[i][i] = 1;
 
        gaussian(matrix, index);
 
        for (int i=0; i<row-1; ++i)
            for (int j=i+1; j<column; ++j)
                for (int k=0; k<column; ++k)
                	subMatrix[index[j]][k] -= matrix[index[j]][i]*subMatrix[index[i]][k];
 
        for (int i=0; i<row; ++i) 
        {
        	matrix3[row-1][i] = subMatrix[index[column-1]][i]/matrix[index[row-1]][column-1];
            for (int j=row-2; j>=0; --j) 
            {
            	matrix3[j][i] = subMatrix[index[j]][i];
                for (int k=j+1; k<column; ++k) 
                {
                	matrix3[j][i] -= matrix[index[j]][k]*matrix3[k][i];
                }
                matrix3[j][i] /= matrix[index[j]][j];
            }
        }
        return matrix3;
    }
 
    static void gaussian(double[][] matrix, int[] arr) 
    {
        int size = arr.length;
        double[] c = new double[size];
 
        for (int i=0; i<size; ++i) 
            arr[i] = i;
 
        for (int i=0; i<size; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<size; ++j) 
            {
                double c0 = Math.abs(matrix[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j=0; j<size-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<size; ++i) 
            {
                double pi0 = Math.abs(matrix[arr[i]][j]);
                pi0 /= c[arr[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = arr[j];
            arr[j] = arr[k];
            arr[k] = itmp;
            for (int i=j+1; i<size; ++i) 	
            {
                double pj = matrix[arr[i]][j]/matrix[arr[j]][j];
                 matrix[arr[i]][j] = pj;
                 for (int l=j+1; l<size; ++l)
                    matrix[arr[i]][l] -= pj*matrix[arr[j]][l];
            }
        }
    }
    
    static double matrixTrace(double[][] matrix, int row, int column)
    {
    	double result = 0;
    	
    	for(int i = 0; i < row; i++) {
    		result += matrix[i][i];
    	}
    	return result;
    }
    
    static double[][] removeRowCol(double[][] matrix, int rows1, int cols1, int rows2, int cols2) 
    {
        double[][] matrix3 = new double[rows1 - 1][cols1 - 1];
        int k = 0, l = 0;
        for (int i = 0; i < rows1; i++) {
            if (i == rows2)
                continue;
            for (int j = 0; j < cols1; j++) {
                if (j == cols2)
                    continue;
                matrix3[l][k] = matrix[i][j];
                k = (k + 1) % (rows1 - 1);
                if (k == 0)
                    l++;
            }
        }
        return matrix3;
    }
    
    static double determinant(double[][] result, int row, int col) 
    {
        if (row == 2)
            return result[0][0] * result[1][1] - result[0][1] * result[1][0];
        double determinant1 = 0, determinant2 = 0;
        for (int i = 0; i < row; i++) {
            int temp = 1, temp2 = 1;
            for (int j = 0; j < col; j++) {
                temp *= result[(i + j) % col][j];
                temp2 *= result[(i + j) % col][row - 1 - j];
            }
            determinant1 += temp;
            determinant2 += temp2;
        }
        return determinant1 - determinant2;
    }
    
    static double[][] matrixAdjoint(double[][] matrix, int row, int col) 
    {
        double[][] matrix3 = new double[row][col];
        if(row == 2 && col == 2) {
        	matrix3[0][0] = matrix[1][1];
        	matrix3[1][1] = matrix[0][0];
        	matrix3[0][1] = -matrix[0][1];
        	matrix3[1][0] = -matrix[1][0];
        	
        	return matrix3;
        }
        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < col; j++) {
                matrix3[i][j] = (Math.pow(-1, i + j) * determinant(removeRowCol(matrix, row, col, i, j), row - 1,col - 1));
            }
        }
        return matrixTranspose(matrix3, row, col);
    }
    
    static boolean matrixOrtho(double[][] matrix, int row, int col) 
    {
        double[][] matrixTr = new double[row][col];
        double[][] matrixInv = new double[row][col];

        matrixTr = matrixTranspose(matrix, row, col);
        matrixInv = matrixInverse(matrix, row, col);
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(matrixTr[i][j] != matrixInv[i][j]) {
        			return false;
        		}
        	}
        }
        return true;
    }
    
    static boolean myOption()
    {
        int menu;
        boolean p,q;
        do
        {
            Scanner input= new Scanner(System.in);
            System.out.printf("Press '1' for Menu or '0' to Exit: ");
            menu= input.nextInt();
            p=(menu==0);
            q=(menu==1);
        }while(  (p || !q) && (!p || q));//not XOR
        if (menu==1)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    
    public static void main(String[] args) {
    	while(true)
    	{
        Scanner input = new Scanner(System.in);
        int decision;
        ascii();
        do
        {
            System.out.println("Choose your matrix operation below: ");
            System.out.println("1-)Matrix addition\n2-)Matrix Subtraction\n3-)Matrix Multiplication\n4-)Scalar division of the matrix\n5-)Scalar multiplicaiton of the matrix" +
                    "\n6-)Transpose of the matrix\n7-)The inverse of the matrix\n8-)Trace of the matrix\n9-)Adjoint of the matrix\n10-)Check the matrix for Orthogonality\nPress 0 to exit program");
            System.out.print("Operation: ");
            decision=input.nextInt();
        }while(decision<0 || decision>10);
        clearConsole();
        int columns1, columns2, rows1, rows2;
        double[][] matrix1, matrix2, matrix3;
        double scalar;

        if(decision > 0 && decision <= 3)
        {
            System.out.println("Type row: ");
            rows1 = getrow();
            System.out.println("Type column: ");
            columns1 = getcolumn();
            matrix1 = getMatrix(rows1, columns1);
            System.out.println("Type row: ");
            rows2 = getrow();
            System.out.println("Type column: ");
            columns2 = getcolumn();
            matrix2 = getMatrix(rows2, columns2);

            switch(decision){
                case 1:
                	if(rows1 != rows2 || columns1 != columns2) {
                		System.out.println("ERROR!!! Please check if the matrix dimensions are the same.");
                		break;
                	}else {
            		System.out.println("First matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                    
            		System.out.println("Second matrix: ");
                    printMatrix(matrix2, rows2, columns2);

            		System.out.println("Resultant matrix: ");
                    matrix3 = matrixAddition(matrix1, matrix2, rows1, columns1);
                    printMatrix(matrix3, rows1, columns1);
                    break;
                	}
                case 2:
                	if(rows1 != rows2 || columns1 != columns2) {
                		System.out.println("ERROR!!! Please check if the matrix dimensions are the same.");
                		break;
                	}else {
            		System.out.println("First matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                    
            		System.out.println("Second matrix: ");
                    printMatrix(matrix2, rows2, columns2);

            		System.out.println("Resultant matrix: ");
                    matrix3 = matrixSubtraction(matrix1, matrix2, rows1, columns1);
                    printMatrix(matrix3, rows1, columns1);
                    break;
                	}
                case 3:
                    if (rows2 != columns1) {
                        System.out.println("\nMultiplication Not Possible");
                        break;
                    }
                    else
                    {
                		System.out.println("First matrix: ");
                        printMatrix(matrix1, rows1, columns1);
                        
                		System.out.println("Second matrix: ");
                        printMatrix(matrix2, rows2, columns2);

                		System.out.println("Resultant matrix: ");
                        matrix3 = matrixMultiplication(matrix1, rows1, columns1, matrix2, rows2, columns2);
                        printMatrix(matrix3 ,rows1, columns2);
                        break;
                    }
            }
        } else if (decision == 4 || decision == 5)
        {
            System.out.println("Type row: ");
            rows1 = getrow();
            System.out.println("Type column: ");
            columns1 = getcolumn();
            matrix1 = getMatrix(rows1, columns1);
            System.out.println("Type double Scalar: ");
            scalar = getScalar();

            switch (decision)
            {
                case 4:
            		System.out.println("First matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                    
            		System.out.println("Scalar: ");
            		System.out.print(scalar);

            		System.out.println("Resultant matrix: ");
                    matrix3 = scalarDivision(matrix1, rows1, columns1, scalar);
                    printMatrix(matrix3, rows1, columns1);
                    break;
                case 5:
            		System.out.println("First matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                    
            		System.out.println("Scalar: ");
            		System.out.print(scalar);

            		System.out.println("Resultant matrix: ");
                    matrix3 = scalarMultiplicaiton(matrix1, rows1, columns1, scalar);
                    printMatrix(matrix3, rows1, columns1);
                    break;
            }

        } else if(decision >= 6 && decision <= 10)
        {
            System.out.println("Type row: ");
            rows1 = getrow();
            System.out.println("Type column: ");
            columns1 = getcolumn();
            matrix1 = getMatrix(rows1, columns1);

            switch(decision)
            {
                case 6:
            		System.out.println("The matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                    
                	System.out.println("Transpose of the matrix: ");
                    matrix3 = matrixTranspose(matrix1, rows1, columns1);
                    printMatrix(matrix3, columns1, rows1);
                    break;
                case 7: 
            		System.out.println("The matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                    
                	System.out.println("Inverse of the matrix: ");
                	matrix3 = matrixInverse(matrix1, rows1, columns1);
                    printMatrix(matrix3, rows1, columns1);
                    break;
                case 8:
                    System.out.println("Trace of the matrix: ");
                    if(rows1 != columns1) {
                    	System.out.println("Please enter NxN matrix. ");
                    	break;
                    	}
                    printMatrix(matrix1, rows1, columns1);
                    System.out.println("TR -> ");
                	System.out.print(matrixTrace(matrix1, rows1, columns1));  
                	break;
                case 9:
            		System.out.println("The matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                    
                	System.out.println("Adjoint of the matrix: ");
                	matrix3 = matrixAdjoint(matrix1, rows1, columns1);
                    printMatrix(matrix3, rows1, columns1);
                    break;
                case 10:
                    System.out.println("The matrix: ");
                    printMatrix(matrix1, rows1, columns1);
                	if(matrixOrtho(matrix1, rows1, columns1) == true) {
                    	System.out.println("Matrix is Orthogonal.");
                    	break;
                	}else {
                		 System.out.println("Matrix is NOT Orthogonal.");
                		 break;
                	}
            }
        }
        else if( decision==0)
        {
        	System.out.println("End of the Programme. ");
        	break;
        }
        boolean menU;
        menU=myOption();
        if(menU==false)
        {
        	System.out.println("End of the Programme. ");
        	break;	        	
        }

    }
    }
}
