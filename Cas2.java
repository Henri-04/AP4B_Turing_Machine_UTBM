public class Cas2 extends Scenario1 {

    public Cas2(int nb_verificateurs) {

        super(nb_verificateurs);

        this.verfificateurs = new String[]{
                "•\tCritère A : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "•\tCritère B : Le lieu est La Poudrière ou MDE Sevenans.\n" +
                        "•\tCritère C : Le lieu est Foyer Belfort uniquement.\n",


                "•\tCritère A : L’organisateur est AE ou BDS.\n" +
                        "•\tCritère B : L’organisateur est Gala ou CrunchTime.\n" +
                        "•\tCritère C : L’organisateur est SkiUT uniquement.\n"
                        ,

                "•\tCritère A : Le nombre d’invités est ≥ 200.\n" +
                        "•\tCritère B : Le nombre d’invités est < 100.\n" +
                        "•\tCritère C : Le nombre d’invités est ≥ 150 et ≤ 200.\n"
                        ,

                "•\tCritère A : Si l’organisateur est AE, le lieu est Foyer Montbéliard ou La Poudrière.\n" +
                        "•\tCritère B : Si l’organisateur est SkiUT, le lieu est Axone.\n" +
                        "•\tCritère C : Si l’organisateur est BDS, le lieu est MDE Sevenans.\n"
        };

        this.Final_answer = new String[]{"Foyer Montbéliard", "AE", "250"};
    }
}
