public class Cas6 extends Scenario1 {

    public Cas6(int nb_verificateurs) {
        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "• Critère A (vrai) : Le lieu est Axone ou La Poudrière.\n" +
                        "• Critère B : Le lieu est MDE Sevenans ou Foyer Belfort.\n" +
                        "• Critère C : Le lieu est Foyer Montbéliard uniquement.\n" +
                        "(Options restantes après test : Axone, La Poudrière.)",

                "• Critère A (vrai) : L’organisateur est Gala ou SkiUT.\n" +
                        "• Critère B : L’organisateur est AE ou BDS.\n" +
                        "• Critère C : L’organisateur est CrunchTime uniquement.\n" +
                        "(Options restantes après test : Gala ou SkiUT.)",

                "• Critère A (vrai) : Le nombre d’invités est ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Le nombre d’invités est < 100.\n" +
                        "• Critère C : Le nombre d’invités est ≥ 200.\n" +
                        "(Options restantes après test : 150 invités.)",

                "• Critère A (vrai) : Si le lieu est Axone, l’organisateur est Gala ou SkiUT.\n" +
                        "• Critère B : Si le lieu est La Poudrière, l’organisateur est AE ou BDS.\n" +
                        "• Critère C : Si le lieu est Foyer Montbéliard, l’organisateur est CrunchTime.\n" +
                        "(Options restantes après test : Confirme Axone et Gala.)",

                "• Critère A (vrai) : Si l’organisateur est Gala, le nombre d’invités est ≤ 150.\n" +
                        "• Critère B : Si l’organisateur est SkiUT, le nombre d’invités est > 150.\n" +
                        "• Critère C : Si l’organisateur est AE, le nombre d’invités est ≥ 200.\n" +
                        "(Options restantes après test : Confirme 150 invités et Gala.)",

                "• Critère A (vrai) : Si le lieu est Axone, le nombre d’invités est ≤ 150.\n" +
                        "• Critère B : Si le lieu est La Poudrière, le nombre d’invités est > 150.\n" +
                        "• Critère C : Si le lieu est MDE Sevenans, le nombre d’invités est ≥ 200.\n" +
                        "(Options restantes après test : Confirme 150 invités et Axone.)"
        };

        this.Final_answer = new String[]{"Axone", "Gala", "150"};
    }
}
