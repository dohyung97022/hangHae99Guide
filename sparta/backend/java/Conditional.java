public class Conditional {
    public static void main(String[] args) {
        // if else
        int a = 100;
        int b = 150;
        if (a > 50){
            System.out.println("a is > 50");
        } else {
            System.out.println("a is not > 50");
        }

        // switch
        char score = 'A';
        switch (score){
            case 'A':
                System.out.println("good job!");
                break;
            case 'B':
                System.out.println("you are average");
                break;
            case 'C':
                System.out.println("study harder");
                break;
        }

        // 3항 연산자
        int i = 10;
        String result = (i < 10) ? "10보다 작습니다." : "10보다 큽니다.";
        System.out.println(result);
    }
}
