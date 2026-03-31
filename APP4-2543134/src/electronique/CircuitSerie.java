package electronique;

import java.util.List;

public class CircuitSerie extends Circuit{
    private List<Composant> composants;

    public CircuitSerie(List<Composant> composants) {
        setResistance(composants);
    }

    public List<Composant> getResistance() {
        return  composants;
    }

    public void setResistance(List<Composant> composants) {
        this.composants = composants ;


        }

    public boolean isResistanceValid(double resistance) {
        if (resistance > 0 )return true;
        else return false ;
    }


    @Override
    public double calculerResistance() {
        double resistance = 0;
        for (int i = 0; i < composants.size(); i++) {
           resistance += composants.get(i).calculerResistance();
        }
        return resistance;
    }
}
