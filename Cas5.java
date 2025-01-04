import java.util.HashMap;
import java.util.Map;

public class Cas5 extends Scenario3 {

    public Cas5(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le lieu est MDE Sevenans ou La Poudrière.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",
                "MDE Sevenans ou La Poudrière"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A (vrai) : L’organisateur est SkiUT ou AE.\n" +
                        "• Critère B : L’organisateur est CrunchTime uniquement.\n" +
                        "• Critère C : L’organisateur est Gala ou BDS.\n",
                "SkiUT ou AE"
        );

        Map<String, String> result3 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le nombre d’invités est ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Le nombre d’invités est ≥ 200.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n",
                "≥ 100 et ≤ 150"
        );

        Map<String, String> result4 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si le lieu est MDE Sevenans, l’organisateur est SkiUT ou CrunchTime.\n" +
                        "• Critère B : Si le lieu est La Poudrière, l’organisateur est AE uniquement.\n" +
                        "• Critère C : Si le lieu est Axone, l’organisateur est BDS.\n",
                "SkiUT ou CrunchTime"
        );

        Map<String, String> result5 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si les invités sont 120, le lieu est MDE Sevenans ou Axone.\n" +
                        "• Critère B : Si les invités sont 200, le lieu est La Poudrière.\n" +
                        "• Critère C : Si les invités sont 350, le lieu est un Foyer.\n",
                "MDE Sevenans"
        );

        Map<String, String> result6 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si l’organisateur est SkiUT, le nombre d’invités doit être ≥ 100 et ≤ 150.\n" +
                        "• Critère B : Si l’organisateur est CrunchTime, le nombre d’invités doit être < 100.\n" +
                        "• Critère C : Si l’organisateur est AE, le nombre d’invités doit être > 300.\n",
                "≥ 100 et ≤ 150"
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

        this.Final_answer = new String[]{"MDE Sevenans", "SkiUT", "120"};
    }
}
