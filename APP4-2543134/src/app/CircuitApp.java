package app;

import electronique.Circuit;
import electronique.Composant;

import java.io.File;
import java.io.IOException;

public class CircuitApp {
    public static final char fSep = File.separatorChar;
    public static void main(String[] args) throws IOException {
        InterfaceUtilisateur n = new InterfaceUtilisateur();
        String dossierName = n.affichage();
        String pathname = System.getProperty("user.dir") + fSep + "APP4-2543134" + fSep + "src" + fSep + "donnees" + fSep + dossierName;
        CircuitBuilder circuitBuilder = new CircuitBuilder();

        Composant circuit = circuitBuilder.constuireCircuit(pathname);
        Double resitanceTotal = circuit.calculerResistance();
        System.out.println(resitanceTotal);
        n.recomencer();
    }

}
