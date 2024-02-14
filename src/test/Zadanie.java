package test;

public class Zadanie {
    protected int poprawne;
    protected String odp1, odp2, odp3, odp4;
    protected String pytanie;
    protected String nazwa_pliku;

    Zadanie(int poprawne_odp, String odp1_i, String odp2_i, String odp3_i, String odp4_i, String pytanie_i, String nazwa_pliku_i){
        poprawne = poprawne_odp;
        odp1 = odp1_i;
        odp2 = odp2_i;
        odp3 = odp3_i;
        odp4 = odp4_i;
        pytanie = pytanie_i;
        nazwa_pliku = nazwa_pliku_i;

    }

}
