public class Loop {
    public static void main(String[] args) {
        // for
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum++;
        }
        System.out.println(sum);

        // for each
        String[] days = {"Monday", "Tuesday", "Thursday", "Wednesday", "Friday", "Saturday", "Sunday"};
        for (String day: days) {
            System.out.println(day);
        }

        // while
        int i = 0;
        while (i<10){
            i++;
            System.out.println(i);
        }
        while (i-- > 0){
            System.out.println(i);
        }
    }
}
