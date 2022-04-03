import java.time.DayOfWeek;
import java.util.ArrayList;

public abstract class Taak {
    private String naam;

    public Taak(String naam) {
        this.naam = naam;
    }


    class DagelijkseTaak extends Taak{
        private ArrayList<Tijd> tijdstippen;
        private ArrayList<DayOfWeek> dagen;

        public DagelijkseTaak (String naam, ArrayList<Tijd> tijdstippen, ArrayList<DayOfWeek> dagen) {
            super(naam);
            this.tijdstippen = tijdstippen;
            this.dagen = dagen;
        }
    }

    class WekelijkseTaak extends Taak{
        private Tijd tijdstip;
        private DayOfWeek dag;

        public WekelijkseTaak (String naam, Tijd tijdstip, DayOfWeek dag) {
            super(naam);
            this.tijdstip = tijdstip;
            this.dag = dag;
        }
    }

    class ConstanteTaak extends Taak{
        private Integer minimaleWaarde;
        private Integer maximaleWaarde;
        private Integer huidigeWaarde;

        public ConstanteTaak(String naam, Integer minimaleWaarde) {
            super(naam);
            this.minimaleWaarde = minimaleWaarde;
        }
    }

}
