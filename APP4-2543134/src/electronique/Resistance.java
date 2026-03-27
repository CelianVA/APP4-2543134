package electronique;

public class Resistance extends Composant {
   private double   resistance ;

    public Resistance(double resistance) {
        setResistance( resistance);
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        if (isResistanceValid(resistance)){
            this.resistance = resistance ;
        }
        else throw new IllegalArgumentException("la resistance n'est pas valide ");
    }
    public boolean isResistanceValid(double resistance) {
        if (resistance > 0 )return true;
        else return false ;
    }

    @Override
    public double calculerResistance() {
        return getResistance();
    }
}
