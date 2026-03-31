package electronique;

import java.util.List;

public class CircuitParallele extends Circuit{
    private List<Composant> composants;

    public CircuitParallele(List<Composant> composants) {
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
            resistance += 1/composants.get(i).calculerResistance();
        }
        return 1/resistance;
    }
}
