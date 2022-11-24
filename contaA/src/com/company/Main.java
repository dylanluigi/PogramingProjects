package com.company;

public class Main {

    public static void main(String[] args) {

        int numero;

        System.out.println("Benvingut al programa al conta A.");
        numero = contaAcatch();

        System.out.println("Has introduit "+numero+" a's.");

    }

    static Integer contaA(){

        LT lt = new LT();

        int numero = 0;

        char lletraLlegida = ' ';

        System.out.println("Escriu una lletra: ");

        do {

            lletraLlegida = lt.llegirCaracter();

            if (lletraLlegida == 'a') {
                numero++;
            }


        }while (lletraLlegida!='.');

        return numero;
    }


    static Integer contaAcatch(){

        LT lt = new LT();
        int numero=0;
        boolean numeroTrue = false;
        Character lletraLlegida = ' ';


        do {
            //
            try {
                do {

                    System.out.print("Escriu una lletra: ");
                    lletraLlegida = lt.llegirCaracter();

                    if (lletraLlegida == 'a') {
                        numero++;
                    }

                }while (lletraLlegida!='.');

                numeroTrue = true;

            }catch (Exception e){
                System.out.println("No has introduit una lletra!");
            }
        }while (!numeroTrue);

        return numero;
    }



}
