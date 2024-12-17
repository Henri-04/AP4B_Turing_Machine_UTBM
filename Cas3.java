public class Cas3 extends Scenario1 {

    public Cas3(int nb_verificateurs) {
        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "• Critère A : Le lieu est La Poudrière ou Axone.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",

                "• Critère A : L’organisateur est CrunchTime ou Gala.\n" +
                        "• Critère B : L’organisateur est AE ou SkiUT.\n" +
                        "• Critère C : L’organisateur est BDS uniquement.\n",

                "• Critère A : Le nombre d’invités est ≥ 100.\n" +
                        "• Critère B : Le nombre d’invités est ≤ 150.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n",

                "• Critère A : Si le lieu est La Poudrière, les invités doivent être ≥ 150.\n" +
                        "• Critère B : Si le lieu est Axone, les invités doivent être < 100.\n" +
                        "• Critère C : Si le lieu est MDE Sevenans, les invités doivent être ≥ 300.\n",

                "• Critère A : Si l’organisateur est CrunchTime, le lieu est La Poudrière ou Axone.\n" +
                        "• Critère B : Si l’organisateur est AE, le lieu est un Foyer.\n" +
                        "• Critère C : Si l’organisateur est Gala, le lieu est Axone uniquement.\n"
        };

        this.Final_answer = new String[]{"La Poudrière", "CrunchTime", "200"};
    }
}
