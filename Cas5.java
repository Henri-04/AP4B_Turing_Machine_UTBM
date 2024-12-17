public class Cas5 extends Scenario1 {

    public Cas5(int nb_verificateurs) {
        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "• Critère A : Le lieu est MDE Sevenans ou La Poudrière.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",

                "• Critère A : L’organisateur est SkiUT ou AE.\n" +
                        "• Critère B : L’organisateur est CrunchTime uniquement.\n" +
                        "• Critère C : L’organisateur est Gala ou BDS.\n",

                "• Critère A : Le nombre d’invités est ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Le nombre d’invités est ≥ 200.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n",

                "• Critère A : Si le lieu est MDE Sevenans, l’organisateur est SkiUT ou CrunchTime.\n" +
                        "• Critère B : Si le lieu est La Poudrière, l’organisateur est AE uniquement.\n" +
                        "• Critère C : Si le lieu est Axone, l’organisateur est BDS.\n",

                "• Critère A : Si les invités sont 120, le lieu est MDE Sevenans ou Axone.\n" +
                        "• Critère B : Si les invités sont 200, le lieu est La Poudrière.\n" +
                        "• Critère C : Si les invités sont 350, le lieu est un Foyer.\n",

                "• Critère A : Si l’organisateur est SkiUT, le nombre d’invités doit être ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Si l’organisateur est CrunchTime, le nombre d’invités doit être < 100.\n" +
                        "• Critère C : Si l’organisateur est AE, le nombre d’invités doit être > 300.\n",
        };

        this.Final_answer = new String[]{"MDE Sevenans", "SkiUT", "120"};
    }
}
