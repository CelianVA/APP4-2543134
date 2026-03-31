import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class InterfaceUtilisateur {
    public static final char fSep = File.separatorChar;
    private static final String pathIn = System.getProperty("user.dir") + fSep +"APP4-2543134"+ fSep + "src"+ fSep + "donnees";

    public void affichage() {
        File dossier = new File(pathIn);
        File[] fichiers = dossier.listFiles();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue");
        System.out.println("Vous avez " + FichierDispo().length +"fichier disponible"+ Arrays.toString(FichierDispo()) + "\n" +"Veuiller choisir un des fichier en selectionant son numero préceédement attribuer");
        int choix = sc.nextInt();
        System.out.println("vous avez choisis le fichier "+ FichierDispo()[choix]);


    }

    private String[] FichierDispo() {
        File dossier = new File(pathIn);
        File[] fichiers = dossier.listFiles();
        String[] Fichiers = new String[fichiers.length];
        for (int i = 0; i < fichiers.length; i++) {
            Fichiers[i]="fichier "+i+"  "+fichiers[i].getName();
        }
        return Fichiers ;
    }
}
