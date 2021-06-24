public class Operators {
    public static void main(String[] args) {
        // 사칙연산
        int a = 10;
        int b = 5;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a/b);
        System.out.println(a%b);
        System.out.println(a*b);

        a += b;
        System.out.println(a);
        a -= b;
        System.out.println(a);

        // 조건 연산
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a >= b);

        boolean c = true;
        boolean d = false;
        System.out.println(c && d);
        System.out.println(c || d);
    }
}
