import java.util.Random;
import javax.swing.*;
import java.util.Arrays;
public class Exe3 {
	static boolean pesqui(int vetor[], int y){
		boolean axar = false;
		int i= 0;
		while(i < vetor.length && !axar){
		if(vetor[i]== y){
			axar = true;										
		}
		else
			i++;
		}	
		return axar;
		}
	static boolean pesquib(int vetor[], int y){
		boolean axar = false;
		int z = vetor.length/2;
	 	if(vetor[z]== y){
			axar = true;										
			}
	 	else
	     	if(z < vetor.length && !axar){
			axar = true;										
			}
			else
			if(z > vetor.length && !axar){
				axar = true;										
					}
			return axar;
		}
	static boolean pesquir(int vetor[], int y){
		boolean axar = false;
		int i= 0;
		if(i < vetor.length && !axar){
			if(vetor[i]== y){
				axar = true;	
		}
		else
			i++;
		}	
		return axar;
	}	
	static boolean pesquirb(int vetor[], int y){
		boolean axar = false;
		int z = vetor.length/2;
	 	if(vetor[z]== y){
			axar = true;										
			}
	 	else
	     	if(z < vetor.length && !axar){
			axar = true;										
			}
			else
			if(z > vetor.length && !axar){
				axar = true;										
					}
			return axar;
		}
	
	    public static final Random RND = new Random();
		 
		    private static void swap(Object[] array, int i, int j) {
		        Object tmp = array[i];
		        array[i] = array[j];
		        array[j] = tmp;
		    }
		 
		    private static <E extends Comparable<? super E>> int partition(E[] array, int begin, int end) {
		        int index = begin + RND.nextInt(end - begin + 1);
		        E pivot = array[index];
		        swap(array, index, end);
		        for (int i = index = begin; i < end; ++i) {
		            if (array[i].compareTo(pivot) <= 0) {
		                swap(array, index++, i);
		            }
		        }
		        swap(array, index, end);
		        return (index);
		    }
		 
		    private static <E extends Comparable<? super E>> void qsort(E[] array, int begin, int end) {
		        if (end > begin) {
		            int index = partition(array, begin, end);
		            qsort(array, begin, index - 1);
		            qsort(array, index + 1, end);
		        }
		    }
		 
		    public static <E extends Comparable<? super E>> void sort(E[] array) {
		        qsort(array, 0, array.length - 1);
		        Integer[] l1 = { 5, 1024, 1, 88, 0, 1024 };
		        System.out.println("l1  start:" + Arrays.toString(l1));
		        ex.sort(l1);
		        System.out.println("l1 sorted:" + Arrays.toString(l1));
		    }
		    
		
			public class buble{
			public void bubbleSort(int[] a) {
				  for (int i = 0; i < a.length-1; i++) {
				     for (int j = 0; j < a.length-1; j++) {
				        if (a[j] > a[j+1]) {
				           swap(a, j, j+1);
				        }
				     }
				  }
				}
				 
				private void swap(int[] a, int i, int j) {
				  int temp = a[i];
				  a[i] = a[j];
				  a[j] = temp;
				}
			}
			
			public static void SelectionSort(int[] v) {
				   int index_min,
				       aux;
				 
				   for (int i=0; i<v.length; i++) {
				       index_min = i;
				       for (int j=i+1; j<v.length; j++) {
				          if (v[j]<v[index_min]) {
				             index_min=j;
				          }
				       }
				       if(index_min != i){
				         aux = v[index_min];
				         v[index_min] = v[i];
				         v[i] = aux;
				       }
				 
				   }
			}
			
			public static void shellSort(Integer[] nums) {
				int n = nums.length;
				int h = n / 2;
				int c, j;
				while (h > 0) {
					for (int i = h; i < n; i++) {
						c = nums[i];
						j = i;
						while (j >= h && nums[j - h] > c) {
							nums[j] = nums[j - h];
							j = j - h;
							nums[j] = c;
						}	
					}
					h /= 2.2;
				}
			}
			
			   public static void merge(String[ ] args)
			   {
			      final String BLANKS = "  "; 
			      int i;                 
			      int[ ] data = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000 };
			     System.out.println("Here is the entire original array:");
			      for (i = 0; i < data.length; i++)
			         System.out.print(data[i] + BLANKS);
			      System.out.println( );
			      mergesort(data, 1, data.length-2);
			      System.out.println("I have sorted all but the first and last numbers.");
			      System.out.println("The numbers are now:");
			      for (i = 0; i < data.length; i++)
			         System.out.print(data[i] + BLANKS);
			      System.out.println( );
			   }
			   public static void mergesort(int[ ] data, int first, int n)
			   {
			      int n1;
			      int n2; 
			      if (n > 1)
			      {
			         n1 = n / 2;
			         n2 = n - n1;
			         mergesort(data, first, n1);      
			         mergesort(data, first + n1, n2); 
			         merge(data, first, n1, n2);
			      }
			   } 
			   private static void merge(int[ ] data, int first, int n1, int n2)
			   {
			      int[ ] temp = new int[n1+n2];
			      int copied  = 0; 
			      int copied1 = 0; 
			      int copied2 = 0; 
			      int i;
			      while ((copied1 < n1) && (copied2 < n2))
			      {
			         if (data[first + copied1] < data[first + n1 + copied2])
			            temp[copied++] = data[first + (copied1++)];
			         else
			            temp[copied++] = data[first + n1 + (copied2++)];
			      }
			      while (copied1 < n1)
			         temp[copied++] = data[first + (copied1++)];
			      while (copied2 < n2)
			         temp[copied++] = data[first + n1 + (copied2++)];
			      for (i = 0; i < n1+n2; i++)
			         data[first + i] = temp[i];
			   }

			    public static void radixSort(int[] arr){
			        if(arr.length == 0)
			            return;
			        int[][] np = new int[arr.length][2];
			        int[] q = new int[0x100];
			        int i,j,k,l,f = 0;
			        for(k=0;k<4;k++){
			            for(i=0;i<(np.length-1);i++)
			                np[i][1] = i+1;
			            np[i][1] = -1;
			            for(i=0;i<q.length;i++)
			                q[i] = -1;
			            for(f=i=0;i<arr.length;i++){
			                j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
			                if(q[j] == -1)
			                    l = q[j] = f;
			                else{
			                    l = q[j];
			                    while(np[l][1] != -1)
			                        l = np[l][1];
			                    np[l][1] = f;
			                    l = np[l][1];
			                }
			                f = np[f][1];
			                np[l][0] = arr[i];
			                np[l][1] = -1;
			            }
			            for(l=q[i=j=0];i<0x100;i++)
			                for(l=q[i];l!=-1;l=np[l][1])
			                        arr[j++] = np[l][0];
			        }
			        
			        
			    }

			    public static void central(String[] args){
			        int i;
			        int[] arr = new int[15];
			        System.out.print("original: ");
			        for(i=0;i<arr.length;i++){
			            arr[i] = (int)(Math.random() * 1024);
			            System.out.print(arr[i] + " ");
			        }
			        radixSort(arr);
			        System.out.print("\nsorted: ");
			        for(i=0;i<arr.length;i++)
			            System.out.print(arr[i] + " ");
			        System.out.println("\nDone ;-)");
			    }
	
	public static void main(String[]args){
		
		Random random = new Random();   
	int ver [] = new int[12];   
	int d;	
	for( int i = 0; i < 9; i++ ){
		d = random.nextInt(9);
	ver[i]= d;
		}
	int i;
	for(i =0; i <ver.length; i++){
		System.out.println(ver[i]);
		}
	
	int f = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opçoes" + "\n1 - Pesquisa" + "\n2 - Ordenaçao"));
	
	if	(f == 1){	
	int x = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opçao no menu:" +
	"\n1 - Pesquisa Sequencial" + "\n2 - Pesquisa Binaria" + "\n3 - Pesquisa Sequencial R" + "\n4 - Pesquisa Binaria R"));
        if(x == 1){
        	System.out.println(pesqui(ver,x));
        }
        if(x == 2){
        	System.out.println(pesquib(ver,x));
        }
        if(x == 3){
        	System.out.println(pesquir(ver,x));
        }
        if(x == 4){
        	System.out.println(pesquirb(ver,x));
        }
	     else
	    if(x==2){
	   int g = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opçao no menu:" +
	    			"\n1 - Pesquisa Sequencial" + "\n2 - Pesquisa Binaria" + "\n3 - Pesquisa Sequencial R" + "\n4 - Pesquisa Binaria R"));
	    	if(g==1){
	    	System.out.println(buble(ver,x));
	    	}
	    if(g==2){
	    	System.out.println(buble(ver,x));
	    }
		if(g==3){
	    	System.out.println(buble(ver,x));
	    	}
	    if(g==4){
	    	System.out.println(buble(ver,x));
	    }	if(g==5){
	    	System.out.println(buble(ver,x));
    	}
    if(g==2){
    	System.out.println(buble(ver,x));
    }

case 1: buble(ver, x);
System.out.println(pesqui(ver,x));
break;
case 2: pesquib (ver, x);
System.out.println(pesquib(ver,x));  
break;
case 3: pesquir(ver, x);
System.out.println(pesquir(ver,x));
break;
case 4: pesquirb(ver, x);
System.out.println(pesquirb(ver,x));
break;
case 5: (ver, x);
System.out.println(pesqui(ver,x));
break;
case 6: pesquib (ver, x);
System.out.println(pesquib(ver,x));  
break;
case 7: pesquir(ver, x);
System.out.println(pesquir(ver,x));
break;
case 8: pesquirb(ver, x);
System.out.println(pesquirb(ver,x));
break;

 }
}


