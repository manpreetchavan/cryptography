class T{
    public static void main(String args[]){
         int A=0x243F6A88;
    int B=0x85A308D3;
    int C=0x13198A2E;
    int D=0x03707344;
    int str_to_int=Integer.parseInt("10");
        String int_to_hex=Integer.toHexString(str_to_int);
    
    int c=B+A+str_to_int;
    String d=Integer.toHexString(c);
    System.out.println(d);
    }
}