import java.util.*;
class Pascal{
  public static void main(String[] args){
     Scanner s=new Scanner(System.in);
     System.out.println("enter rows");
     int rows=s.nextInt();
     s.close();
     for(int i=0;i<rows;i++){
        for(int j=0;j<rows-i;j++){
           System.out.print(" ");
        }
        int m=1;
        for(int k=0;k<=i;k++){
           System.out.print(m+" ");
           m=m*(i-k)/(k+1);
        }
        System.out.println();
     }
  }
}
 
