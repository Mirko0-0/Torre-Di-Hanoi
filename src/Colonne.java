class Colonne {
    private Pila<Disco> torre1;
    private Pila<Disco> torre2;
    private Pila<Disco> torre3;
    private int numDischi;

    public Colonne(int numDischi) {
        this.numDischi=numDischi;
        torre1 = new Pila<>(1);
        torre2 = new Pila<>(2);
        torre3 = new Pila<>(3);
        for (int i = numDischi; i >= 1; i--) {
            torre1.push(new Disco(i));
        }
    }

    public boolean spostaDisco(int origine, int destinazione) {
        Pila<Disco> torreOrigine = getTorre(origine);
        Pila<Disco> torreDestinazione = getTorre(destinazione);
        if (torreOrigine == null || torreDestinazione == null)
            return false;
        if (torreOrigine.isEmpty())
            return false;

        Disco discoDaSpostare = torreOrigine.top();
        
        
        if (!torreDestinazione.isEmpty() && torreDestinazione.top().getDimensione() < discoDaSpostare.getDimensione())
            return false;

        torreDestinazione.push(torreOrigine.pop());
        return true;
    }

    public Pila<Disco> getTorre(int n) {
        switch(n) {
            case 1: return torre1;
            case 2: return torre2;
            case 3: return torre3;
            default: return null;
        }
    }

    public void stampaTorri() {
        /*
        System.out.println("Torre 1: " + torre1.getLista());
        System.out.println("Torre 2: " + torre2.getLista());
        System.out.println("Torre 3: " + torre3.getLista());
         */
        int tmpsz1,tmpsz2,tmpsz3;
        for (int i = numDischi; i >= 0; i--) {
            String s1 = " ";
            String s2 = " ";
            String s3 = " ";

            if (i < torre1.getLista().size())
                s1 = torre1.getLista().get(i).toString() + " ";
            if (i < torre2.getLista().size())
                s2 = torre2.getLista().get(i).toString() + " ";
            if (i < torre3.getLista().size())
                s3 = torre3.getLista().get(i).toString() + " ";

            System.out.println("        "+s1 + "              " + s2 + "              " + s3);
        }
        System.out.println("    Colonna1    -   Colonna2    -   Colonna3");

        System.out.println("size:   "+torre1.getLista().size()+"               "+torre2.getLista().size()+"               "+torre3.getLista().size());
    }

    public boolean isVittoria(int numDischi) {
        return (torre2.size() == numDischi || torre3.size() == numDischi);
    }
}