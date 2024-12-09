public class Cas5 extends Scenario1 {

    public Cas5(int nb_verificateurs) {
        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "• Critère A (vrai) : Le lieu est MDE Sevenans ou La Poudrière.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n" +
                        "(Options restantes après test : MDE Sevenans, La Poudrière.)",

                "• Critère A (vrai) : L’organisateur est SkiUT ou AE.\n" +
                        "• Critère B : L’organisateur est CrunchTime uniquement.\n" +
                        "• Critère C : L’organisateur est Gala ou BDS.\n" +
                        "(Options restantes après test : SkiUT, AE.)",

                "• Critère A (vrai) : Le nombre d’invités est ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Le nombre d’invités est ≥ 200.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n" +
                        "(Options restantes après test : 120 uniquement.)",

                "• Critère A (vrai) : Si le lieu est MDE Sevenans, l’organisateur est SkiUT ou CrunchTime.\n" +
                        "• Critère B : Si le lieu est La Poudrière, l’organisateur est AE uniquement.\n" +
                        "• Critère C : Si le lieu est Axone, l’organisateur est BDS.\n" +
                        "(Options restantes après test : Confirme MDE Sevenans et SkiUT.)",

                "• Critère A (vrai) : Si les invités sont 120, le lieu est MDE Sevenans ou Axone.\n" +
                        "• Critère B : Si les invités sont 200, le lieu est La Poudrière.\n" +
                        "• Critère C : Si les invités sont 350, le lieu est un Foyer.\n" +
                        "(Options restantes après test : Confirme 120 invités et MDE Sevenans.)",

                "• Critère A (vrai) : Si l’organisateur est SkiUT, le nombre d’invités doit être ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Si l’organisateur est CrunchTime, le nombre d’invités doit être < 100.\n" +
                        "• Critère C : Si l’organisateur est AE, le nombre d’invités doit être > 300.\n" +
                        "(Options restantes après test : Confirme 120 invités et SkiUT.)"
        };

        this.Final_answer = new String[]{"MDE Sevenans", "SkiUT", "120"};
    }
}
