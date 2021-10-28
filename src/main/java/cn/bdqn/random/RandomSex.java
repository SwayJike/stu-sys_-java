package cn.bdqn.random;

import java.util.Random;

public class RandomSex {
    private  static String sexs="男女";
    public  static String next() {
        return String.valueOf(sexs.toCharArray()[RandomNum.next(sexs.length())]);
    }
}
