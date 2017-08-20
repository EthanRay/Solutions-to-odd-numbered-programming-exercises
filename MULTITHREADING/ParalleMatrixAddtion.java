package JavaSyugyou0814;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParalleMatrixAddtion {
	
	public static double[][] parallelAddMatrix(double[][] a, double[][] b){
		double[][] result = new double[a.length][a[0].length];
		RecursiveAction task=new SumTask(a, b, result);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(task);
		return result;
	}
	private static class SumTask extends RecursiveAction{
		 private double[][] a;
		 private double[][] b;
		 private double[][] c;

		    public SumTask(double[][] a, double[][] b, double[][] c) {
		      this.a = a;
		      this.b = b;
		      this.c = c;
		    }
		protected void compute() {
			RecursiveAction[] tasks=new RecursiveAction[a.length];
			for(int i=0;i<a.length;++i)
				tasks[i]=new AddOneRow(i);
			invokeAll(tasks);
		}
		
		public class AddOneRow extends RecursiveAction{
			int i;
			public AddOneRow(int i) {
				this.i = i;
			}
			@Override
			protected void compute() {
				 for (int j = 0; j < a[0].length; j++)
			          c[i][j] = a[i][j] + b[i][j];
			      }
			}
		}
		
}
