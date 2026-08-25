import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);

        // for(var i=1; i<10; i ++){
        //     System.out.println(i);
        // }

        for(var i=0; i <=10; i ++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}