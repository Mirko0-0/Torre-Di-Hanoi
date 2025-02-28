import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColors.GREEN+"Benvenuto al gioco della Torre di Hanoi!");
        System.out.print(ConsoleColors.YELLOW+"Inserisci il numero di dischi (minimo 3): "+ConsoleColors.RESET);
        int numDischi = input.nextInt();
        if(numDischi < 3) {
            System.out.println(ConsoleColors.RED+"Il numero minimo di dischi è 3. Verranno usati 3 dischi."+ConsoleColors.RESET);
            numDischi = 3;
        }
        Colonne colonne = new Colonne(numDischi);
        int mosse = 0;
        boolean giocoFinito = false;
        while(!giocoFinito) {
            System.out.print(ConsoleColors.RESET);
            colonne.stampaTorri();
            System.out.println(ConsoleColors.CYAN+"Mosse effettuate: " + mosse);
            System.out.println(ConsoleColors.GREEN+"Scegli un'azione: ");
            System.out.println(ConsoleColors.YELLOW+"1. Sposta un disco");
            System.out.println(ConsoleColors.YELLOW+"2. Esci");
            System.out.print(ConsoleColors.BLUE+"Scelta: ");
            int scelta = input.nextInt();

            switch(scelta) {
                case 1:
                    System.out.print(ConsoleColors.GREEN+"Inserisci torre di origine (1, 2, 3): ");
                    int origine = input.nextInt();
                    System.out.print(ConsoleColors.GREEN+"Inserisci torre di destinazione (1, 2, 3): ");
                    int destinazione = input.nextInt();

                    if(origine < 1 || origine > 3 || destinazione < 1 || destinazione > 3) {
                        System.out.println(ConsoleColors.RED+"Torre non valida! Riprova.");
                        break;
                    }
                    if(origine == destinazione) {
                        System.out.println(ConsoleColors.RED+"La torre di origine e destinazione sono uguali! Riprova.");
                        break;
                    }
                    if (colonne.spostaDisco(origine, destinazione)) {
                        mosse++;
                    } else {
                        System.out.println("Mossa non valida! Controlla che il disco possa essere spostato.");
                    }
                    
                    if (colonne.isVittoria(numDischi)) {
                        colonne.stampaTorri();
                        System.out.println(ConsoleColors.GREEN+"Complimenti, hai vinto in " + mosse + " mosse!");
                        giocoFinito = true;
                    }
                    break;
                case 2:
                    System.out.println(ConsoleColors.GREEN+"Uscita dal gioco.");
                    giocoFinito = true;
                    break;
                default:
                    System.out.println(ConsoleColors.RED+"Scelta non valida! Riprova.");
            }
        }
    }
}