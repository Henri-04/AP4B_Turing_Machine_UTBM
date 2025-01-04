import java.util.HashMap;
import java.util.Map;

public class Cas3 extends Scenario2 {

    public Cas3(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le lieu est La Poudrière ou Axone.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",
                "La Poudrière ou Axone"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A (vrai) : L’organisateur est CrunchTime ou Gala.\n" +
                        "• Critère B : L’organisateur est AE ou SkiUT.\n" +
                        "• Critère C : L’organisateur est BDS uniquement.\n",
                "CrunchTime ou Gala"
        );

        Map<String, String> result3 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le nombre d’invités est ≥ 100.\n" +
                        "• Critère B : Le nombre d’invités est ≤ 150.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n",
                "≥ 100"
        );

        Map<String, String> result4 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si le lieu est La Poudrière, les invités doivent être ≥ 150.\n" +
                        "• Critère B : Si le lieu est Axone, les invités doivent être < 100.\n" +
                        "• Critère C : Si le lieu est MDE Sevenans, les invités doivent être ≥ 300.\n",
                "≥ 150"
        );

        Map<String, String> result5 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si l’organisateur est CrunchTime, le lieu est La Poudrière ou Axone.\n" +
                        "• Critère B : Si l’organisateur est AE, le lieu est un Foyer.\n" +
                        "• Critère C : Si l’organisateur est Gala, le lieu est Axone uniquement.\n",
                "La Poudrière ou Axone"
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

        this.Final_answer = new String[]{"La Poudrière", "CrunchTime", "200"};
    }
}
