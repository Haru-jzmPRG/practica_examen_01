public class App {
    public static final String RESET = "\033[0m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String PURPLE_BACKGROUND = "\033[45m";

    public static void main(String[] args) throws Exception {

        long min = 0;
        long max = 0;

        System.out.println("GRAOHIFY");
        System.out.println("===================");

        do {
            min = Long.parseLong(System.console().readLine("Introudce el valor mínimo del rango: "));
            max = Long.parseLong(System.console().readLine("Introudce el valor máximo del rango: "));
            if (min < 0 || max < 0)
                System.out.println("ERROR: los valores del rango deben ser mayores o iguales a cero.");
        } while (min < 0 || max < 0);

        if (min > max) {
            long aux = min;
            min = max;
            max = aux;
        }

        long aleatorio = (long) (Math.random() * (max - min + 1) + min);

        char opcion = System.console().readLine("Dibujo la gráfica em blanco y negro o en color (B | C): ")
                .toLowerCase().charAt(0);

        int codigoSalida;
        switch (opcion) {
            case 'b':
                codigoSalida = 1;
                break;
            case 'c':
                codigoSalida = 2;
                break;
            default:
                codigoSalida = 1;
                break;
        }

        int digito = 0;
        long volteado = 0;
        int digitoMayor = 0;
        int longitud = 0;

        if (codigoSalida == 1) {

            while (aleatorio > 0) {
                digito = (int) aleatorio % 10;
                volteado = (volteado * 10) + digito;

                if (digitoMayor < digito)
                    digitoMayor = digito;

                aleatorio /= 10;
                longitud++;

            }
            digito = 0;
            while (longitud > 0) {
                digito = (int) volteado % 10;
                volteado /= 10;
                longitud--;
                for (int i = 0; i < digitoMayor + 1; i++) {
                    System.out.print(" ---");
                }
                int aux = digito;
                System.out.println();
                for (int i = 0; i <= digitoMayor + 1; i++) {
                    if (i == 0) {
                        System.out.printf("| %d ", digito);
                    } else if (i < (digitoMayor + 1)) {
                        if (aux > 0) {
                            System.out.printf("| %s ", "*");
                            aux--;
                        } else {
                            System.out.printf("|   ");
                        }
                    } else {
                        System.out.printf("|");
                    }
                }
                System.out.println();

            }
            for (int i = 0; i < digitoMayor + 1; i++) {
                System.out.print(" ---");
            }
        } else {
            String caracter = " ";
            while (aleatorio > 0) {
                digito = (int) aleatorio % 10;
                volteado = (volteado * 10) + digito;

                if (digitoMayor < digito)
                    digitoMayor = digito;

                aleatorio /= 10;
                longitud++;

            }
            digito = 0;

            for (int i = 0; i <= digitoMayor + 1; i++) {

                        if (i == 0) {
                            System.out.printf("╔═");
                        } else if (i < (digitoMayor + 1)) {
                            System.out.printf("╦═");
                        } else {
                            System.out.printf("╗");
                        }
                    }
                    System.out.println();

            while (longitud > 0) {

                digito = (int) volteado % 10;

                switch (digito) {
                    case 0, 1, 2, 3, 4:
                        caracter = BLUE_BACKGROUND + " " + RESET;
                        break;
                    case 5, 6:
                        caracter = RED_BACKGROUND + " " + RESET;
                        break;
                    case 7, 8:
                        caracter = GREEN_BACKGROUND + " " + RESET;
                        break;
                    case 9:
                        caracter = PURPLE_BACKGROUND + " " + RESET;
                        break;
                }
                if (longitud > 0) {

                    int aux = digito;

                    for (int i = 0; i <= digitoMayor + 1; i++) {

                        if (i == 0) {
                            System.out.printf("║%d", digito);
                        } else if (i < (digitoMayor + 1)) {
                            if (aux > 0) {
                                System.out.printf("║%s", caracter);
                                aux--;
                            } else {
                                System.out.printf("║ ");
                            }
                        } else {
                            System.out.printf("║");
                        }
                    }
                    System.out.println();

                    if (longitud > 1) {
                        for (int i = 0; i <= digitoMayor + 1; i++) {
                            if (i == 0) {
                                System.out.printf("╠═");
                            } else if (i < (digitoMayor + 1)) {
                                System.out.printf("╬═");
                            } else {
                                System.out.printf("╣");
                            }
                        }
                        System.out.println();                        
                        volteado /= 10;
                    }
                }
                longitud--;
            }
            if (longitud == 0) {

                for (int i = 0; i <= digitoMayor + 1; i++) {

                    if (i == 0) {
                        System.out.printf("╚═");
                    } else if (i < (digitoMayor + 1)) {
                        System.out.printf("╩═");
                    } else {
                        System.out.printf("╝");
                    }
                }
            }
            
        }
    }
}