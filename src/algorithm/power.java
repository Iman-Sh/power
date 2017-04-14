

package algorithm;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*---------------
iman shirali 9450016

mohammad hasan helali jula
*/

public class power {
        static int[] A;
        static int []B;
        static int []C;
        static int  alow, blow,ahigh,bhigh;
   public static void main(String []args){
       
       List<Integer> arr = new ArrayList<Integer>();
       arr=readfile();
       
       int a = (arr.get(0)+1);
       A = new int[a];
       B = new int[a];
       C = new int[(2*a)-1];
       int j = 0;
       
       for(int i=1 ; i<=a ; i++){
           A[j] = arr.get(i);
           j++;
       }
       j = 0;
       for(int i=(a + 1) ; i<=arr.size()-1 ; i++){
           B[j] = arr.get(i);
           j++;
       }
       
       
        alow = 0 ; blow = 0;
        ahigh = a-1 ; bhigh = a-1;
       polynomial(alow,ahigh,blow,bhigh);
       
       for(int  i=0 ;i<A.length ;i++){
           System.out.print(" "+A[i]);
       }
       System.out.print("\n");
       for(int  i=0 ;i<B.length ;i++){
           System.out.print(" "+B[i]);
       }
        System.out.print("\n");
        for(int i = 0; i< C.length ; i++){
            System.out.print(" "+C[i]);
        }
       
       
   }

    public static  void polynomial(int low1,int high1, int low2 , int high2)
    {
    
        int n,k;
        n=(high1-low1)+1;
        if(n==1)
            C[low1+low2]+=A[low1]*B[low2];
        else{
            k=n/2;
            polynomial(low1,low1+k-1,low2,low2+k-1);
            polynomial(low1,low1+k-1,low2+k,high2);
            polynomial(low1+k,high1,low2,low2+k-1);
            polynomial(low1+k,high1,low2+k,high2);
        }
    }
   
    public static ArrayList readfile(){
        String []ss=null;
        List<Integer> arr = new ArrayList<Integer>();
        try{
            InputStream fis = new FileInputStream("C:\\Users\\Iman SH\\Desktop\\zarib.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            
            String line;
            while(( line = br.readLine()) != null)
            {
                ss = line.split(", ");
                for(int i=0;i<ss.length;i++)
                {
                    arr.add(Integer.parseInt(ss[i]));
                }
            }
        }
       
        catch(Exception ex)
        {
            System.out.println("Exception :   " +ex);
        }
       return (ArrayList) arr;
   }
}

