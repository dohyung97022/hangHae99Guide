import java.util.Arrays;

public class Arrray {
    public static void main(String[] args) {
        // int 의 초기값은 0 입니다.
        int[] intEmptyArrray = new int[5];
        System.out.println(Arrays.toString(intEmptyArrray));

        int[] intArray = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(intArray));

        // String 의 초기값은 null 입니다.
        String[] stringEmptyArray = new String[5];
        System.out.println(Arrays.toString(stringEmptyArray));

        String[] season = {"봄", "여름", "가을", "겨울"};
        System.out.println(Arrays.toString(season));

        System.out.println(season.length);
    }
}
