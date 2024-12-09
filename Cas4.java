public class Cas4 extends Scenario1 {

    public Cas4(int nb_verificateurs) {
        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "• Critère A (vrai) : Le lieu est La Poudrière ou Foyer Montbéliard.\n" +
                        "• Critère B : Le lieu est Foyer Belfort ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Axone uniquement.\n" +
                        "(Options restantes après test : La Poudrière, Foyer Montbéliard.)",

                "• Critère A (vrai) : L’organisateur est BDS ou Gala.\n" +
                        "• Critère B : L’organisateur est AE ou CrunchTime.\n" +
                        "• Critère C : L’organisateur est SkiUT uniquement.\n" +
                        "(Options restantes après test : BDS ou Gala.)",

                "• Critère A (vrai) : Le nombre d’invités est < 150.\n" +
                        "• Critère B : Le nombre d’invités est > 250.\n" +
                        "• Critère C : Le nombre d’invités est ≥ 150.\n" +
                        "(Options restantes après test : 100 invités.)",

                "• Critère A (vrai) : Si le lieu est La Poudrière, l’organisateur est BDS ou Gala.\n" +
                        "• Critère B : Si le lieu est Foyer Montbéliard, l’organisateur est AE.\n" +
                        "• Critère C : Si le lieu est Axone, l’organisateur est SkiUT.\n" +
                        "(Options restantes après test : Confirme La Poudrière et BDS.)",

                "• Critère A (vrai) : Si le nombre d’invités est 100, le lieu est La Poudrière.\n" +
                        "• Critère B : Si le nombre d’invités est 200, le lieu est MDE Sevenans.\n" +
                        "• Critère C : Si le nombre d’invités est < 100, le lieu est Axone.\n" +
                        "(Options restantes après test : Confirme 100 invités et La Poudrière.)"
        };

        this.Final_answer = new String[]{"La Poudrière", "BDS", "100"};
    }
}
