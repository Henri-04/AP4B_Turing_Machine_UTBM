import java.util.HashMap;
import java.util.Map;

public class Cas5 extends Scenario3 {

    public Cas5(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A : Le lieu est MDE Sevenans ou La Poudrière.\n" +
                        "• Critère B : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",
                "MDE Sevenans ou La Poudrière"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A : L’organisateur est SkiUT ou AE.\n" +
                        "• Critère B : L’organisateur est CrunchTime uniquement.\n" +
                        "• Critère C : L’organisateur est Gala ou BDS.\n",
                "SkiUT ou AE"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice")
        };

        this.Final_answer = new String[]{"MDE Sevenans", "SkiUT", "120"};
    }
}
