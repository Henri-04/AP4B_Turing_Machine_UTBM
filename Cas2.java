import java.util.HashMap;
import java.util.Map;

public class Cas2 extends Scenario1 {

    public Cas2(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "• Critère B : Le lieu est La Poudrière ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",
                "Foyer Montbéliard ou Axone"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A (vrai) : L’organisateur est AE ou BDS.\n" +
                        "• Critère B : L’organisateur est Gala ou CrunchTime.\n" +
                        "• Critère C : L’organisateur est SkiUT uniquement.\n",
                "AE ou BDS"
        );

        Map<String, String> result3 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le nombre d’invités est ≥ 200.\n" +
                        "• Critère B : Le nombre d’invités est < 100.\n" +
                        "• Critère C : Le nombre d’invités est ≥ 150 et ≤ 200.\n",
                "≥ 200"
        );

        Map<String, String> result4 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si l’organisateur est AE, le lieu est Foyer Montbéliard ou La Poudrière.\n" +
                        "• Critère B : Si l’organisateur est SkiUT, le lieu est Axone.\n" +
                        "• Critère C : Si l’organisateur est BDS, le lieu est MDE Sevenans.\n",
                "Foyer Montbéliard ou La Poudrière"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur"),
                result3.get("verificateur"),
                result4.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice"),
                result3.get("correctChoice"),
                result4.get("correctChoice")
        };

        this.Final_answer = new String[]{"Foyer Montbéliard", "AE", "250"};
    }
}
