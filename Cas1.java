
public class Cas1 extends Scenario1{

    public Cas1(int nb_verificateurs){


        super(nb_verificateurs);


        this.verfificateurs = new String[] {
                "• Critère A : Le lieu est un Foyer.\n" +
                        "• Critère B : Le lieu est Axone ou La Poudrière.\n" +
                        "• Critère C : Le lieu est MDE Sevenans uniquement.\n",

                "• Critère A : L’organisateur est BDS ou CrunchTime.\n" +
                        "• Critère B : L’organisateur est AE uniquement.\n" +
                        "• Critère C : L’organisateur est Gala ou SkiUT.\n",

                "• Critère A : Le nombre d’invités est ≤ 100.\n" +
                        "• Critère B : Le nombre d’invités est > 200.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n"
        };



        this.Final_answer = new String[]{"Foyer Belfort","BDS","75"};

    }



}
