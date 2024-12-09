public class Cas2 extends Scenario1 {

    public Cas2(int nb_verificateurs) {

        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "•\tCritère A (vrai) : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "•\tCritère B : Le lieu est La Poudrière ou MDE Sevenans.\n" +
                        "•\tCritère C : Le lieu est Foyer Belfort uniquement.\n" +
                        "(Options restantes après test : Foyer Montbéliard, Axone.)",

                "•\tCritère A (vrai) : L’organisateur est AE ou BDS.\n" +
                        "•\tCritère B : L’organisateur est Gala ou CrunchTime.\n" +
                        "•\tCritère C : L’organisateur est SkiUT uniquement.\n" +
                        "(Options restantes après test : AE ou BDS.)",

                "•\tCritère A (vrai) : Le nombre d’invités est ≥ 200.\n" +
                        "•\tCritère B : Le nombre d’invités est < 100.\n" +
                        "•\tCritère C : Le nombre d’invités est ≥ 150 et ≤ 200.\n" +
                        "(Options restantes après test : 250 invités.)",

                "•\tCritère A (vrai) : Si l’organisateur est AE, le lieu est Foyer Montbéliard ou La Poudrière.\n" +
                        "•\tCritère B : Si l’organisateur est SkiUT, le lieu est Axone.\n" +
                        "•\tCritère C : Si l’organisateur est BDS, le lieu est MDE Sevenans.\n" +
                        "(Options restantes après test : Confirme Foyer Montbéliard et AE.)"
        };

        this.Final_answer = new String[]{"Foyer Montbéliard", "AE", "250"};
    }
}
