import java.util.Scanner;

public class Fechas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String regex = "^([0-2][0-9]|3[01])-(0[1-9]|1[0-2])-[0-2][0-9]{3}+$" +
                "|^([0-2][0-9]|3[01])/(0[1-9]|1[0-2])/[0-2][0-9]{3}+$";
        String fecha = "";

        do {
            System.out.println("Escribe una fecha de modo XX-XX-XXXX o XX/XX/XXXX");

            fecha = sc.next();
        }while (!fecha.matches(regex));



        if(fecha.matches(regex)){
            System.out.println("Fecha introducida correctamente");
        } else{
            System.out.println("Fecha no válida");
        }
    }
}
