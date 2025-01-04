import java.util.HashMap;
import java.util.Map;

public class Cas1 extends Scenario1 {

    public Cas1(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le lieu est un Foyer.\n" +
                        "• Critère B : Le lieu est Axone ou La Poudrière.\n" +
                        "• Critère C : Le lieu est MDE Sevenans uniquement.\n",
                "un Foyer"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A (vrai) : L’organisateur est BDS ou CrunchTime.\n" +
                        "• Critère B : L’organisateur est AE uniquement.\n" +
                        "• Critère C : L’organisateur est Gala ou SkiUT.\n",
                "BDS ou CrunchTime"
        );

        Map<String, String> result3 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Le nombre d’invités est ≤ 100.\n" +
                        "• Critère B : Le nombre d’invités est > 200.\n" +
                        "• Critère C : Le nombre d’invités est < 50.\n",
                "≤ 100"
        );

        Map<String, String> result4 = melangerCritèresEtReponses(
                "• Critère A (vrai) : Si le lieu est le Foyer Belfort, l’organisateur est BDS ou AE.\n" +
                        "• Critère B : Si le lieu est Axone, l’organisateur est SkiUT uniquement.\n" +
                        "• Critère C : Si le lieu est MDE Sevenans, l’organisateur est CrunchTime.\n",
                "BDS ou AE"
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

        this.Final_answer = new String[]{"Foyer Belfort", "BDS", "75"};
    }
}
