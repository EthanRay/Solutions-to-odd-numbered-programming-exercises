package JavaSyugyou0814;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMatrixMultplication {
	
	public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b)
	{
		 double[][] result = new double[a.length][b[0].length];
		 RecursiveAction task=new SumTask(a, b, result);
		 ForkJoinPool pool=new ForkJoinPool();
		 pool.invoke(task);
		 return result;
	}
	
	
	public static double[][] multiplyMatrix(double[][] a, double[][] b)
	 {
		 double[][] result = new double[a.length][b[0].length];
		    for (int i = 0; i < result.length; i++)
		      for (int j = 0; j < result[0].length; j++) 
		        for (int k = 0; k < a[0].length; k++)
		          result[i][j] += a[i][k] * b[k][j];
		    
		    return result;
	 }
	
	private static class SumTask extends RecursiveAction
	{
		private double[][] a;
	    private double[][] b;
	    private double[][] c;

	    public SumTask(double[][] a, double[][] b, double[][] c) {
	      this.a = a;
	      this.b = b;
	      this.c = c;
	    }

		protected void compute() {
			ArrayList<RecursiveAction>tasks=new ArrayList<RecursiveAction>();
			for(int i=0;i<c.length;++i)
				for(int j=0;j<c[0].length;++j)
					tasks.add(null);
		}
	    
	    public class MultiplyOneRow extends RecursiveAction
	    {
	    	int i,j;
	    	
	    	 public MultiplyOneRow(int i, int j) {
	    	        this.i = i;
	    	        this.j = j;
	    	      }
			protected void compute() {
				c[i][j] = 0;
		        for (int k = 0; k < a[0].length; k++)
		          c[i][j] += a[i][k] * b[k][j];
			}
	    	
	    }
	    
	    
	}
}
