import java.util.HashMap;
import java.util.Map;

public class Cas6 extends Scenario3 {

    public Cas6(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le lieu est Axone ou La Poudrière.\n" +
                        "• Critère B : Le lieu est MDE Sevenans ou Foyer Belfort.\n" +
                        "• Critère C : Le lieu est Foyer Montbéliard uniquement.\n",
                "Axone ou La Poudrière"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A (vrai) : L’organisateur est Gala ou SkiUT.\n" +
                        "• Critère B : L’organisateur est AE ou BDS.\n" +
                        "• Critère C : L’organisateur est CrunchTime uniquement.\n",
                "Gala ou SkiUT"
        );

        Map<String, String> result3 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le nombre d’invités est ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Le nombre d’invités est < 100.\n" +
                        "• Critère C : Le nombre d’invités est ≥ 200.\n",
                "≥ 100 et ≤ 150"
        );

        Map<String, String> result4 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si le lieu est Axone, l’organisateur est Gala ou SkiUT.\n" +
                        "• Critère B : Si le lieu est La Poudrière, l’organisateur est AE ou BDS.\n" +
                        "• Critère C : Si le lieu est Foyer Montbéliard, l’organisateur est CrunchTime.\n",
                "Gala ou SkiUT"
        );

        Map<String, String> result5 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si l’organisateur est Gala, le nombre d’invités est ≤ 150.\n" +
                        "• Critère B : Si l’organisateur est SkiUT, le nombre d’invités est > 150.\n" +
                        "• Critère C : Si l’organisateur est AE, le nombre d’invités est ≥ 200.\n",
                "≤ 150"
        );

        Map<String, String> result6 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si le lieu est Axone, le nombre d’invités est ≤ 150.\n" +
                        "• Critère B : Si le lieu est La Poudrière, le nombre d’invités est > 150.\n" +
                        "• Critère C : Si le lieu est MDE Sevenans, le nombre d’invités est ≥ 200.\n",
                "≤ 150"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur"),
                result3.get("verificateur"),
                result4.get("verificateur"),
                result5.get("verificateur"),
                result6.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice"),
                result3.get("correctChoice"),
                result4.get("correctChoice"),
                result5.get("correctChoice"),
                result6.get("correctChoice")
        };

        this.Final_answer = new String[]{"Axone", "Gala", "150"};
    }
}
