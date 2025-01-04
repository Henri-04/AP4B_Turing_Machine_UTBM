import java.util.HashMap;
import java.util.Map;

public class Cas2 extends Scenario1 {

    public Cas2(int nb_verificateurs) {
        super(nb_verificateurs);

        Map<String, String> result1 = melangerCritèresEtReponses(
                "• Critère A : Le lieu est Foyer Montbéliard ou Axone.\n" +
                        "• Critère B : Le lieu est La Poudrière ou MDE Sevenans.\n" +
                        "• Critère C : Le lieu est Foyer Belfort uniquement.\n",
                "La Poudrière ou MDE Sevenans"
        );

        Map<String, String> result2 = melangerCritèresEtReponses(
                "• Critère A : L’organisateur est AE ou BDS.\n" +
                        "• Critère B : L’organisateur est Gala ou CrunchTime.\n" +
                        "• Critère C : L’organisateur est SkiUT uniquement.\n",
                "AE ou BDS"
        );

        this.verfificateurs = new String[]{
                result1.get("verificateur"),
                result2.get("verificateur")
        };

        this.correctChoices = new String[]{
                result1.get("correctChoice"),
                result2.get("correctChoice")
        };

        this.Final_answer = new String[]{"Foyer Montbéliard", "AE", "250"};
    }
}
