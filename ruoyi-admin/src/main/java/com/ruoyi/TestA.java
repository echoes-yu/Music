package com.ruoyi;

public class TestA {
    public static void main(String[] args) {


        int  x=-123;
//
//        int rev = 0;
//        while (x != 0) {
//            int pop = x % 10;
//            x /= 10;
//            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
//                System.out.println(0);
//            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
//                System.out.println(0);
//            rev = rev * 10 + pop;
//        }
//
//        System.out.println("结果");
//        System.out.println(rev);


        StringBuffer s=new StringBuffer();
        int a=Math.abs(x);
        for(int i=0;i<String.valueOf(x).length();i++){
            int a1=a%10;
            a=a/10;
            s.append(a1);
        }
        try{
            int result =(x>0?1:-1)*Integer.parseInt(s.toString());
            double min=-Integer.MIN_VALUE;
            double max=Integer.MAX_VALUE;
            if (result<min||result>max){
                System.out.println(0);
            }
            System.out.println(result);

        }catch(Exception e){
            System.out.println("Exception");

        }
    }
}
