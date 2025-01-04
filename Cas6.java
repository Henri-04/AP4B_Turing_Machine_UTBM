import java.util.HashMap;
import java.util.Map;

public class Cas6 extends Scenario3 {

    public Cas6(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A : Le lieu est Axone ou La Poudrière.\n" +
                        "• Critère B : Le lieu est MDE Sevenans ou Foyer Belfort.\n" +
                        "• Critère C : Le lieu est Foyer Montbéliard uniquement.\n",
                "Axone ou La Poudrière"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A : L’organisateur est Gala ou SkiUT.\n" +
                        "• Critère B : L’organisateur est AE ou BDS.\n" +
                        "• Critère C : L’organisateur est CrunchTime uniquement.\n",
                "Gala ou SkiUT"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice")
        };

        this.Final_answer = new String[]{"Axone", "Gala", "150"};
    }
}
