import java.util.HashMap;
import java.util.Map;

public class Cas1 extends Scenario1 {

    public Cas1(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A : Le lieu est un Foyer.\n" +
                        "• Critère B : Le lieu est Axone ou La Poudrière.\n" +
                        "• Critère C : Le lieu est MDE Sevenans uniquement.\n",
                "Axone ou La Poudrière"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A : L’organisateur est BDS ou CrunchTime.\n" +
                        "• Critère B : L’organisateur est AE uniquement.\n" +
                        "• Critère C : L’organisateur est Gala ou SkiUT.\n",
                "BDS ou CrunchTime"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice")
        };

        this.Final_answer = new String[]{"Foyer Belfort", "BDS", "75"};
    }
}
