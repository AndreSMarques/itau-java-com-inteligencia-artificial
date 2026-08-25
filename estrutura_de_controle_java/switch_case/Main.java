import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
        System.out.println("Infore um número de 1 até 7");
        var option = scanner.nextInt();

        switch (option) {
            case 1 -> System.out.println("domingo");
            case 2 -> System.out.println("segunda");
            case 3 -> System.out.println("terça");
            case 4 -> System.out.println("quarta");
            case 5 -> System.out.println("quinta");
            case 6 -> System.out.println("sexta");
            case 7 -> System.out.println("sabado");
            default -> System.out.println("Opção invalida");
                
        }

        // switch (option) {
        //     case 1:
        //         System.out.println("Domingo");
        //         break;
        //     case 2:
        //         System.out.println("Segunda-Feira");
        //         break;
        //     case 3:
        //         System.out.println("Terça-Feira");
        //         break;
        //     case 4:
        //         System.out.println("Quarta-Feira");
        //         break;
        //     case 5:
        //         System.out.println("Quinta-Feira");
        //         break;
        //     case 6:
        //         System.out.println("Sexta-Feira");
        //         break;
        //     case 7:
        //         System.out.println("Sábado");
        //         break;
        
        //     default:
        //         System.out.println("Opção invalida");
        //         break;
        // }
	}
}
