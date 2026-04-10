package app;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class InterfaceUtilisateur {
    public static final char fSep = File.separatorChar;
    private static final String pathIn = System.getProperty("user.dir") + fSep +"APP4-2543134"+ fSep + "src"+ fSep + "donnees";

    public String affichage() {
        File dossier = new File(pathIn);
        File[] fichiers = dossier.listFiles();
        Scanner sc = new Scanner(System.in);
        System.out.println("Vous avez " + FichierDispo().length +" fichier disponible"+ Arrays.toString(FichierDispo()));
        while(true){
        try{
            System.out.println( "Veuiller choisir un des fichiers en selectionant son numero précédement attribuer");
            int choix = sc.nextInt();
            if (choix >0 & choix < FichierDispo().length ){
                System.out.println("vous avez choisis le fichier "+choix+" "+ FichierDispo()[choix-1]);

                return FichierDispo()[choix];

            }
            throw new IllegalArgumentException();

        }
        catch (Exception e){
            System.out.println("Mauvais argument entrer un nouvelle argument");
            sc.nextLine();

        }

        }

    }
    public void recomencer() {
        Scanner sc = new Scanner(System.in);
        int rep;
        while (true){
            System.out.println("Entrer 1 pour recomencer \n Entrer 2 pour sortir du programme");
            rep = sc.nextInt();
            try {
                if (rep==1){
                affichage();
            }
            else if (rep==2) {
                break;
            }
            throw new IllegalArgumentException();
            }
            catch (Exception e) {

                System.out.println("Mauvais argument entrer un nouvelle argument");
                sc.nextLine();
            }


        }
    }

    private String[] FichierDispo() {
        File dossier = new File(pathIn);
        File[] fichiers = dossier.listFiles();
        String[] Fichiers = new String[fichiers.length];
        for (int i = 0; i < fichiers.length; i++) {
            Fichiers[i]=fichiers[i].getName();
        }
        return Fichiers ;
    }
}
