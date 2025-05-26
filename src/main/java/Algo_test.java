import java.util.Scanner;
import java.util.*;

public class Algo_test {

     void test(int number)
    {

        while (true) {
            System.out.println("Guess a number: ");


            Random r = new Random();
            int r1 = r.nextInt(100);

            if (number == r1) {
                System.out.println("Correct");
                break;
            }
            else {
                System.out.println("Not correct, value was: "+ r1);
            }
        }

    }


    public static void main(String[] args) {
        Algo_test t = new Algo_test();
        t.test(12);

    }
}
