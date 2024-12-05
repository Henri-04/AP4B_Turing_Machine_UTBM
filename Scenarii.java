//PAS TOUT LAISSER EN PUBLIC


//mettre en abstract
 public class  Scenarii {

    static int ID = 0;

    //PRIVATE
    private int id;

    //PROTECTED
    protected int nb_verificateurs;

    protected String[] verfificateurs;
    // de la forme
    // {"Règle 1", "Regle 2",..., "Règle n"}

    //PUBLIC
    public String[] Final_answer;
    // de la forme
    // {"Axone", "AE", "150"}

    //TEST
    public int getID(){
        return this.id;
    }

    // Constructeur
    public Scenarii ()
    {

        this.nb_verificateurs = 0;
        //TEST
        this.id = ++ID;
        this.verfificateurs = new String[]{"Règle 1", "Regle 2","...", "Règle n"};  //A implementer à la main
        //this.verfificateurs = new String[0];  //A implementer à la main
        this.Final_answer = new String[0];

    }


/*

    DECLA
    String[] fruits;

    INIT
    fruits = new String[]{"Pomme", "Banane", "Cerise"};

*/



}

