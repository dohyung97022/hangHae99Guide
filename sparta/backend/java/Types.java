// 메인의 기본 구조
public class Types {
    public static void main(String[]args){
        // 기본 자료형
        short s = -32000; // -32,768 ~ 32,767
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        int i = 2100000000; // -21억 ~ 21억
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        long l = (long)Math.pow(10,18) * 9; // -10^18*9 ~ 10^18*9
        System.out.println(l);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

        // 상수형
        float floatType = 1.11f; // 정밀도는 7이다.
        double doubleType = 1.11; // 정밀도는 15이다.

        // 문자형
        char charType = 'a';

        // 논리형
        boolean boolType = true;

        // 참조 자료형
        String stringType = "abc";
        stringType = "";
    }
}
