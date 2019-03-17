import java.util.*;
import java.lang.*;

class DiffieUsers{
  public static void main(String[] args) {
    int p;
    int q;


    int a1,a2,a3;
    int a1_pu,a2_pu,a3_pu;
    Integer[] common_12=new Integer[2];
    Integer[] common_23=new Integer[2];
    Integer[] common_31=new Integer[2];
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a prime number : ");
    p=sc.nextInt();
    if(!is_prime(p))
    {
        System.out.println(p+" is not a prime number ! Try again with a prime number.");
    }
    else
    {
    q=primitive_root(p);
    System.out.println("The smallest primitive root of "+p+" is : "+q+".");

    // System.out.println("Enter the number of users:");
    // int users=sc.nextInt();

    // Integer[] secret=new Integer[users];
    // Integer[] publik=new Integer[users];
    // Integer[] common=new Integer[users];
    //
    //
    // for(int i=0;i<users;i++)
    // {
    //   System.out.println("User "+i+" choose your secret key!");
    //   secret[i]=sc.nextInt();
    //   //public key
    //   publik[i]=(int)(Math.pow(q,secret[i])%p);
    //
    // }
    // System.out.println("The public keys are : "+Arrays.toString(publik));
    // System.out.println("The secret keys are : "+Arrays.toString(secret));
    //
    // for(int i=0;i<users;i++)
    // {
    //   common[i]=(int)(Math.pow(publik[i+1],secret[i])%p);
    //   if(i==(users-1))
    //   {
    //     common[users-1]=(int)(Math.pow(publik[0],secret[users-1])%p);
    //   }
    // }
    // System.out.println("The exchanged keys are : "+Arrays.toString(common));
    //




    System.out.println("a1, enter your secret key : ");
    a1=sc.nextInt();
    System.out.println("a2, enter your secret key : ");
    a2=sc.nextInt();
    System.out.println("a3, enter your secret key : ");
    a3=sc.nextInt();
    System.out.println(" The secret keys are :\na1 : "+a1+"\na2 : "+a2+"\na3 : "+a3);

    //public key
    a1_pu = (int)(Math.pow(q,a1)%p);
    a2_pu = (int)(Math.pow(q,a2)%p);
    a3_pu = (int)(Math.pow(q,a3)%p);
    System.out.println(" The public keys are :\na1 : "+a1_pu+"\na2 : "+a2_pu+"\na3 : "+a3_pu);

    System.out.println("\nKey Exchange between a1 and a2 :");
    common_12[0]=(int)Math.pow(a2_pu,a1)%p;
    common_12[1]=(int)Math.pow(a1_pu,a2)%p;
    System.out.println(common_12[0]+"\n"+common_12[1]);

    System.out.println("\nKey Exchange between a2 and a3 :");
    common_23[0]=(int)Math.pow(a3_pu,a2)%p;
    common_23[1]=(int)Math.pow(a2_pu,a3)%p;
    System.out.println(common_23[0]+"\n"+common_23[1]);

    System.out.println("\nKey Exchange between a3 and a1 :");
    common_31[0]=(int)Math.pow(a1_pu,a3)%p;
    common_31[1]=(int)Math.pow(a3_pu,a1)%p;
    System.out.println(common_31[0]+"\n"+common_31[1]);
    }
  }



  static int primitive_root(int p){
    boolean flag=true;
    int root=0;
    for(int i=2;i<p;i++)
    {
      ArrayList<Integer> a1=new ArrayList<Integer>();

      for(int j=0;j<p;j++)
      {

        double temp=Math.pow(i,j);
        temp=temp%p;
        int temp2=(int)temp;
        if(a1.contains(temp2))
        {
          break;
        }

        else{
          a1.add(temp2);
        }


        if(a1.size()==(p-1))
        {
          root=i;
          break;
        }

        //j loop
      }

      System.out.println(a1);

          if(root!=0){
          System.out.println(root);
          break;
        }
//i loop
    }


return root;
  }



  static boolean is_prime(int n)
  {
    boolean flag=true;
    int m=n/2;
    for(int i=2;i<=m;i++)
    {
      if(n%i==0)
      {
        flag=false;
        break;
      }
      else
      {
        flag=true;
      }
    }
    return flag;
  }


}





/*

E:\TE\VI
λ java Diffie
Enter a prime number :
57
57 is not a prime number ! Try again with a prime number.

-------------------------------------------------------------------
E:\TE\VI
λ java Diffie
Enter a prime number :
59
[1, 2, 4, 8, 16, 32, 5, 10, 20, 40, 21, 42, 25, 50, 41, 23, 46, 33, 7, 14, 28, 56, 53, 47, 35, 11, 22, 44, 29, 58, 57, 55, 51, 43, 27, 54, 49, 39, 19, 38, 17, 34, 9, 18, 36, 13, 26, 52, 45, 31, 3, 6, 12, 24, 48, 37, 15, 30]
2
The smallest primitive root of 59 is : 2.
a1, enter your secret key :
23
a2, enter your secret key :
45
a3, enter your secret key :
16
 The secret keys are :
a1 : 23
a2 : 45
a3 : 16
 The public keys are :
a1 : 47
a2 : 13
a3 : 46

Key Exchange between a1 and a2 :
54
54

Key Exchange between a2 and a3 :
54
54

Key Exchange between a3 and a1 :
54
54

E:\TE\VI


*/
