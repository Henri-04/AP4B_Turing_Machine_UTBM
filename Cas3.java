import java.util.HashMap;
import java.util.Map;

public class Cas3 extends Scenario2 {

    public Cas3(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A : Le lieu est La Poudrière ou Axone.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",
                "La Poudrière ou Axone"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A : L’organisateur est CrunchTime ou Gala.\n" +
                        "• Critère B : L’organisateur est AE ou SkiUT.\n" +
                        "• Critère C : L’organisateur est BDS uniquement.\n",
                "CrunchTime ou Gala"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice")
        };

        this.Final_answer = new String[]{"La Poudrière", "CrunchTime", "200"};
    }
}
