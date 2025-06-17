import java.util.*;
class Switch1{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        boolean continueCalc=true;
        while(continueCalc){
            try{
                int op,n;
                double a=0,m=0;
                System.out.println("enter no digits..::");
                n=s.nextInt();
                if(n<=0){
                    System.out.println("enter the digit greater than 0");
                }
                for(int i=1;i<=n;i++){
                    System.out.println("enter the value"+i);
                    a=s.nextDouble();
                    System.out.println("enter option");
                    op=s.nextInt();
                    switch(op){
                        case 1:if(op==1)
                        m+=a;
                        break;
                        case 2:if(op==2)
                        m-=a;
                        break;
                        case 3:if(op==3)
                        m*=a;
                        break;
                        case 4:if(op==4)
                        m/=a;
                        break;
                        case 5:if(op==5)
                        m%=a;
                        break;
                    }
                    a=m;
                }
                System.out.println("solution is.."+a);
            }
            catch(InputMismatchException e){
                System.out.println("invalid number..please enter another digit.");
                s.nextLine();
            }
            catch(ArithmeticException e){
                System.out.println("Invalid number..enter another one"+e.getMessage());
            }
            catch(Exception e){
                System.out.println("invalid number..enter another value"+e.getMessage());
            }
            System.out.println("continue more...(yes/no):");
            String ch=s.next();
            if(!ch.equalsIgnoreCase("yes")){
                continueCalc=false;
                System.out.println("calculator existed");
            }
        }
        s.close();
    }
}
