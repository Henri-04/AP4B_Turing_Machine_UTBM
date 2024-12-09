public class Cas3 extends Scenario1 {

    public Cas3(int nb_verificateurs) {
        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "• Critère A (vrai) : Le lieu est La Poudrière ou Axone.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n" +
                        "(Options restantes après test : La Poudrière, Axone.)",

                "• Critère A (vrai) : L’organisateur est CrunchTime ou Gala.\n" +
                        "• Critère B : L’organisateur est AE ou SkiUT.\n" +
                        "• Critère C : L’organisateur est BDS uniquement.\n" +
                        "(Options restantes après test : CrunchTime, Gala.)",

                "• Critère A (vrai) : Le nombre d’invités est ≥ 100.\n" +
                        "• Critère B : Le nombre d’invités est ≤ 150.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n" +
                        "(Options restantes après test : 200 uniquement.)",

                "• Critère A (vrai) : Si le lieu est La Poudrière, les invités doivent être ≥ 150.\n" +
                        "• Critère B : Si le lieu est Axone, les invités doivent être < 100.\n" +
                        "• Critère C : Si le lieu est MDE Sevenans, les invités doivent être ≥ 300.\n" +
                        "(Options restantes après test : Confirme 200 invités et La Poudrière.)",

                "• Critère A (vrai) : Si l’organisateur est CrunchTime, le lieu est La Poudrière ou Axone.\n" +
                        "• Critère B : Si l’organisateur est AE, le lieu est un Foyer.\n" +
                        "• Critère C : Si l’organisateur est Gala, le lieu est Axone uniquement.\n" +
                        "(Options restantes après test : Confirme CrunchTime.)"
        };

        this.Final_answer = new String[]{"La Poudrière", "CrunchTime", "200"};
    }
}
