import java.util.ArrayList;

public class Pila <T>{
    private ArrayList <T> lista =  new ArrayList<>();
    private int id;

    public Pila(int id){
        this.id=id;
    }
    public void push(T elemento){
        lista.add(elemento);
    }

    public T pop(){
        int num = lista.size();
        if(num>0){
            return lista.remove(num-1);
        }
        return null;
    }

    public T top(){
        int num = lista.size();
        if(num>0){
            return lista.get(num-1);
        }
        return null;
    }

    public int size(){
        return lista.size();
    }

    public ArrayList<T> getElements() {
        return new ArrayList<>(lista);
    }

    public boolean isEmpty(){
        return lista.isEmpty();
    }

    @Override
    public String toString() {
        return "Pila{" +
                "lista=" + lista +
                '}';
    }


}
