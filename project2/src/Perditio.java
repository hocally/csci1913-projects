public class Perditio {
    static long ones = 0;
    static long nots = 0;
    public static void main(String args[]) {
        for(int i = 0; i < 500000; i++) {
            Tableau tableau = new Tableau();
            if (tableau.play()) {
                ones++;
            } else {
                nots++;
            }
            System.out.println(nots);
        }
    }
}

