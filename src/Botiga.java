import java.util.Scanner;

public class Botiga {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] clients = new String[1000][4];

        String llistaRefAndDesc[][] = new String[1000][2];
        int llistaStock[] = new int[1000];
        float llistaPreus[] = new float[1000];
/*

        llistaRefAndDesc[0][0] = "XCDOF3455";
        llistaRefAndDesc[0][1] = "Monitor LG 14";
        llistaStock[0] = 3;
        llistaPreus[0] = 4.56f;

        llistaRefAndDesc[1][0] = "XCDOF444445";
        llistaRefAndDesc[1][1] = "Ratoli Logitech";
        llistaStock[1] = 5;
        llistaPreus[1] = 2.67f;

*/


        int indexPersones = 0;
        int indexProductes = 0;

        int opcio;

        boolean bucle = true;

        while (bucle) {
            System.out.println("Clients Existents: " + indexPersones);
            System.out.println("#######################");
            System.out.println("         MENU          ");
            System.out.println("#######################");
            System.out.println("# 0 - Sortir          #");
            System.out.println("# 1 - Afegir client   #");
            System.out.println("# 2 - Mostrar clients   #");
            System.out.println("# 3 - Afegir stock    #");
            System.out.println("#######################");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 0:
                    bucle = false;
                    break;

                case 1:

                    String numTelefon;
                    System.out.print("Telefon: ");
                    numTelefon = sc.nextLine();
                    boolean clientExistent = false;
                    for (int i = 0; i < indexPersones; i++) {
                        if (clients[i][0].equalsIgnoreCase(numTelefon)) {
                            clientExistent = true;
                            break;
                        }
                    }
                    if (clientExistent) {
                        System.out.println("Client existent");
                    } else {
                        clients[indexPersones][0] = numTelefon;
                        System.out.print("Nom Complert: ");
                        clients[indexPersones][1] = sc.nextLine();
                        System.out.print("Adreça ");
                        clients[indexPersones][2] = sc.nextLine();
                        System.out.print("Poblacio: ");
                        clients[indexPersones][3] = sc.nextLine();
                        indexPersones++;
                    }

                    break;

                case 2:
                    for(int i=0; i<indexPersones;i++){
                        for(int j=0;j<clients[0].length;j++){
                            System.out.println(clients[i][j]+" ");
                        }
                        System.out.println();
                    }
                case 3:
                    int filaQueOcupaElProducte = 0;
                    String referencia;
                    System.out.print("Referència: ");
                    referencia = sc.nextLine();
                    boolean producteExistent = false;
                    for (int i = 0; i < indexProductes; i++) {
                        if (llistaRefAndDesc[i][0].equalsIgnoreCase(referencia)) {
                            producteExistent = true;
                            filaQueOcupaElProducte = i;
                            break;
                        }
                    }
                    if (producteExistent) {
                        //EL PRODUCTE JA ESTÀ EN STOCK
                        int quantitatActual = llistaStock[filaQueOcupaElProducte];
                        System.out.print("Introdueix la quantitat que t'ha arribat: ");
                        int quantitatQueArriba = sc.nextInt();
                        sc.nextLine();
                        llistaStock[filaQueOcupaElProducte] = quantitatActual + quantitatQueArriba;
                        System.out.println("Quantitat en stock: " + llistaStock[filaQueOcupaElProducte]);

                    } else {
                        //EL PRODUCTE NO ESTÀ EN STOCK. DEMANEM DADES PER AFEGIR-LO.
                        llistaRefAndDesc[indexProductes][0] = referencia;
                        System.out.print("Descripció: ");
                        llistaRefAndDesc[indexProductes][1] = sc.nextLine();
                        System.out.print("Quantitat que arriba: ");
                        llistaStock[indexProductes] = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Preu Producte: ");
                        llistaPreus[indexProductes] = sc.nextFloat();
                        sc.nextLine();
                        indexProductes++;


                    }
                    break;

            }


        }


    }

}
