import java.util.HashMap;
import java.util.Map;

public class Cas4 extends Scenario2 {

    public Cas4(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A : Le lieu est La Poudrière ou Foyer Montbéliard.\n" +
                        "• Critère B : Le lieu est Foyer Belfort ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Axone uniquement.\n",
                "La Poudrière ou Foyer Montbéliard"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A : L’organisateur est BDS ou Gala.\n" +
                        "• Critère B : L’organisateur est AE ou CrunchTime.\n" +
                        "• Critère C : L’organisateur est SkiUT uniquement.\n",
                "BDS ou Gala"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice")
        };

        this.Final_answer = new String[]{"La Poudrière", "BDS", "100"};
    }
}
