package cn.bdqn.random;

import java.util.Random;

public class RandomNum {

    public static int next(int min,int max){
        Random random=new Random();
        return  random.nextInt(max-min+1)+min;
    }
    public static int next(int n){
        Random random=new Random();
        return  random.nextInt(n);
    }
}
