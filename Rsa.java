import java.util.*;
import java.lang.*;
import java.math.*;
public class Rsa{
    public static void main(String[] args){
        double p;
        double q;
        double n;
        double phi;
        double d;
        double k=2;
        double c;
        Scanner sc=new Scanner(System.in);
        //public key
        System.out.println("Enter the value of p :");
        p=sc.nextDouble();
        System.out.println("Enter the value of q :");
        q=sc.nextDouble();
        System.out.println("p : "+p+" q : "+q);
       n=p*q;
       System.out.println("n = "+n);
        //private key
       phi=(p-1)*(q-1);
        System.out.println("phi = "+phi);

  //e and phi are coprime
        double e=2.0;
       while(e<phi){
           if(gcd(e,phi)==1){
               break;
           }
           else{
               e++;
           }
       }


        System.out.println("e = "+e);

        d=(k*phi+1)/e;
        System.out.println("d : \n"+d);

        System.out.println("Enter the message :");
        String msg=sc.nextLine();
        char[] msg1=new char[msg.length()];
        for(int i=0;i<msg.length();i++)
        {
            msg1[i]=msg.charAt(i);
            System.out.print(msg1[i]);
        }
        // System.out.println(Arrays.toString(msg1)+"  msg length:"+msg1.length);


        double[] asc_val=new double[msg1.length];
        //print ascii values
        for(int i=0;i<msg1.length;i++)
        {
            int ascii=msg1[i];
            asc_val[i]=ascii;
            System.out.println(msg1[i]+" = "+asc_val[i]);
        }



        int e_int=(int)e;
        int n_int=(int)n;
//encrypting
        System.out.println("\nencrypting text");
        double[] cipher=new double[msg1.length];
        for(int i=0;i<msg1.length;i++)
        {
          double temp=Math.pow(asc_val[i],e);
          cipher[i]=(temp%n);
          System.out.println(i+"  "+cipher[i] );
        }


//decrypting
        System.out.println("\ndecrypting cipher : ");
        double[] decrypt=new double[msg1.length];
        for(int i=0;i<msg1.length;i++)
        {
          BigInteger big_ciph=BigInteger.valueOf((int)cipher[i]);
          BigInteger big_dec=big_ciph.pow((int)d).mod(BigInteger.valueOf((int)n));
          decrypt[i]=big_dec.intValue();
          System.out.println(i+"  "+decrypt[i]);

        }

        for(int i=0;i<msg1.length;i++)
        {

          System.out.print((char)decrypt[i]);
        }



    //end main
    }


    //gcd method
    static double gcd(double a, double b)
    {
      if(a==0)
      {
        return b;
      }
      else if(b==0)
      {
        return a;
      }
      else if(a==b)
      {
        return a;
      }
      else if(a>b)
      {
        return gcd(a-b,b);
      }
      else{
        return gcd(a,b-a);
      }
    }
    //end of class
}


/*
E:\TE\VI
λ java Rsa
Enter the value of p :
53
Enter the value of q :
89
p : 53.0 q : 89.0
n = 4717.0
phi = 4576.0
e = 3.0
d : 3051.0
Enter the message :
HI
[H, I]  msg length:2
H = 72.0
I = 73.0

encrypting text
0  605.0
1  2223.0

decrypting cipher :
0  72.0
1  73.0
HI
E:\TE\VI
λ
*/
