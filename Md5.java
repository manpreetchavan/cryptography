import java.math.BigInteger;
import java.util.*;

public class Md5{
    public static void main(String[] args){


    Scanner sc=new Scanner(System.in);
    String plaintext=new String();
    System.out.println("Enter the plain text");
    plaintext = sc.nextLine();
    System.out.println("plaintext is \n"+plaintext);
    String binarypt=new String();
    binarypt=binarypt(plaintext);
    System.out.println("Binary of plaintext is :\n"+binarypt);
    System.out.println(binarypt.length());
    int binaryptlen=binarypt.length();
    String pt448=new String();
    pt448=append_zeroes(binarypt,448);
    System.out.println("The plaintext in 448 bits is :\n"+pt448);
    System.out.println(pt448.length());
    int len_dec;
    double exp=Math.pow(2,64);
    len_dec=(int)binaryptlen%(int)exp;
    System.out.println("Length bits in decimal are :"+ len_dec);
    String len64=len64(len_dec);
    System.out.println("The Length bits are :\n"+len64);
    String Maintext=pt448+len64;
    System.out.println("The 512 bit plaintext is :\n"+Maintext);
    System.out.println(Maintext.length());
    
    System.out.println(Maintext.substring(0,32).length());
    String[] M=words(Maintext);

    String MDigest=function(M);
 System.out.println("\nThe message digest is:\n"+MDigest+"\n"+MDigest.length());

//end main method
}

static String[] words(String mt){
String[] array_of_words=new String[16];    
    for(int i=0;i<=15;i++){
       
        int index=i*32;
        String temp=mt.substring(index,index+32);
        array_of_words[i]=temp;

    }
    System.out.println(Arrays.toString(array_of_words));
    return array_of_words;

//endmethod
}

static String binarypt(String plaintext){
    byte[] bytespt = plaintext.getBytes();
    BigInteger pt_bin_big=new BigInteger(bytespt);
    String binarypt=pt_bin_big.toString(2);
    binarypt='0'+binarypt;
    return binarypt;
    
//endmethod    
}

static String append_zeroes(String pt,int n){
    String binpt448 = pt + '1';
    int lenpt=binpt448.length();
    while(lenpt!=n)
    {
        binpt448=binpt448 + '0';
        lenpt++;

    }
    return binpt448;

//endmethod
}

static String len64(int dec){
   String len_bin=Integer.toBinaryString(dec);
   System.out.println(len_bin);
   int len_bin_len=len_bin.length();
   System.out.println(len_bin_len);
   for(int i=0;i<64-len_bin_len;i++){
       len_bin+='0';
   }
   System.out.println(len_bin.length());
   return len_bin;

//endmethod
}

static String function(String[] M){
    int A=0x243F6A88;
    int B=0x85A308D3;
    int C=0x13198A2E;
    int D=0x03707344;
    int[] K=new int[]{0x3A39CE37, 0xD3FAF5CF, 0xABC27737, 0x5AC52D1B,
		        0x5CB0679E, 0x4FA33742, 0xD3822740, 0x99BC9BBE,
	            0xD5118E9D, 0xBF0F7315, 0xD62D1C7E, 0xC700C47B,			            0xB78C1B6B, 0x21A19045, 0xB26EB1BE, 0x6A366EB4,
	            0x5748AB2F, 0xBC946E79, 0xC6A376D2, 0x6549C2C8,
	            0x530FF8EE, 0x468DDE7D, 0xD5730A1D, 0x4CD04DC6,
	            0x2939BBDB, 0xA9BA4650, 0xAC9526E8, 0xBE5EE304,
	            0xA1FAD5F0, 0x6A2D519A, 0x63EF8CE2, 0x9A86EE22,
	            0xC089C2B8, 0x43242EF6, 0xA51E03AA, 0x9CF2D0A4,
	            0x83C061BA, 0x9BE96A4D, 0x8FE51550, 0xBA645BD6,
	            0x2826A2F9, 0xA73A3AE1, 0x4BA99586, 0xEF5562E9,
	            0xC72FEFD3, 0xF752F7DA, 0x3F046F69, 0x77FA0A59,
	            0x80E4A915, 0x87B08601, 0x9B09E6AD, 0x3B3EE593,
	            0xE990FD5A, 0x9E34D797, 0x2CF0B7D9, 0x022B8B51,
	            0x96D5AC3A, 0x017DA67D, 0xD1CF3ED6, 0x7C7D2D28,
	            0x1F9F25CF, 0xADF2B89B, 0x5AD6B472, 0x5A88F54C};

    Random rand=new Random();
   // int[] N=new int[64];
    //N=M;
    int F=0;
    int blockno=0;
    
    for(int i=0;i<64;i++){
        if(i<=15){
            F=(B & C) | (~B & D);
            blockno=i;
        }
        else if(i>=16 && i<32){
            F=(D & B) | (~D & C);
            blockno=((5*i) +1)%16;
        }
        else if(i>=32 && i<48){
            F=(B ^ C ^ D);
            blockno=((3*i) + 5)%16;
        }
        else if(i>=48 && i<64){
            F=C ^ (B | ~D);
            blockno=(7*i)%16;
        }

        int s=rand.nextInt(32);
        String hex8="";
        for(int x=0;x<4;x++){
            int index=x*8;
            String temp=M[blockno].substring(index,index+8);
            hex8+=Integer.toHexString(Integer.parseInt(temp,2));
        }
      //  String int_to_hex="0x"+Integer.toHexString(str_to_int);
        //int hex=(hex)(int_to_hex);

        F = F + A + K[i];
        F = F + (int)Long.parseLong(hex8,16);
        A = D;
        D = C;
        C = B;
        B = B + shift(F,s+1);

    }

    String a=Integer.toBinaryString(A);
    String b=Integer.toBinaryString(B);
    String c=Integer.toBinaryString(C);  
    String d=Integer.toBinaryString(D);
    String digest=a+b+c+d;

    return digest;
//endmethod
}

static int shift(int m, int n){
    return (m << n) | (m >> (32 - n));
}

//end of class
}