import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Pila<Integer> t1 = new Pila(1);
        Pila<Disco> t2 = new Pila(2);
        Pila<Disco> t3 = new Pila(3);

        t1.push(1);
        t1.push(2);
        t1.push(3);
        ArrayList temp1 = t1.getElements();
            for(int i = 1; i<=temp1.size(); i++){
                System.out.println(temp1.get(i-1));
            }

    }
}