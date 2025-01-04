import java.util.HashMap;
import java.util.Map;

public class Cas4 extends Scenario2 {

    public Cas4(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le lieu est La Poudrière ou Foyer Montbéliard.\n" +
                        "• Critère B : Le lieu est Foyer Belfort ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Axone uniquement.\n",
                "La Poudrière ou Foyer Montbéliard"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A (vrai) : L’organisateur est BDS ou Gala.\n" +
                        "• Critère B : L’organisateur est AE ou CrunchTime.\n" +
                        "• Critère C : L’organisateur est SkiUT uniquement.\n",
                "BDS ou Gala"
        );

        Map<String, String> result3 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le nombre d’invités est < 150.\n" +
                        "• Critère B : Le nombre d’invités est > 250.\n" +
                        "• Critère C : Le nombre d’invités est ≥ 150.\n",
                "< 150"
        );

        Map<String, String> result4 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si le lieu est La Poudrière, l’organisateur est BDS ou Gala.\n" +
                        "• Critère B : Si le lieu est Foyer Montbéliard, l’organisateur est AE.\n" +
                        "• Critère C : Si le lieu est Axone, l’organisateur est SkiUT.\n",
                "BDS ou Gala"
        );

        Map<String, String> result5 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si le nombre d’invités est 100, le lieu est La Poudrière.\n" +
                        "• Critère B : Si le nombre d’invités est 200, le lieu est MDE Sevenans.\n" +
                        "• Critère C : Si le nombre d’invités est < 100, le lieu est Axone.\n",
                "La Poudrière"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur"),
                result3.get("verificateur"),
                result4.get("verificateur"),
                result5.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice"),
                result3.get("correctChoice"),
                result4.get("correctChoice"),
                result5.get("correctChoice")
        };

        this.Final_answer = new String[]{"La Poudrière", "BDS", "100"};
    }
}
