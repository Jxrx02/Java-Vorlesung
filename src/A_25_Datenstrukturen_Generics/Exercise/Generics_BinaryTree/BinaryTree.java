package A_25_Datenstrukturen_Generics.Exercise.Generics_BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//extendes Comparable<T> => Kovarianz
public class BinaryTree <T extends Comparable<T>>{

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree() { }

    public boolean add (T newValue) {
        if (this.getValue() == null) { // letztes Element?
            this.value = newValue; // neues, leeres Element anhängen
            this.left = new BinaryTree<T>();
            this.right = new BinaryTree<T>();
            return true;
        } else {
            if (this.getValue().compareTo(newValue) > 0) {
                return left.add(newValue);
            } else return right.add(newValue);
        }

    }

    public List<T> traverse(){
        if(this.value == null){
            return new LinkedList<>();
        }
        else{
            List<T> list = left.traverse();
            list.add(this.value);
            list.addAll(this.right.traverse());
            return list;
        }
    }

    public T getValue(){
        return this.value;
    }


}

class TestBinaryTree{
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        Random random = new Random();
        random.nextInt(1,10);

        int collisions = 0;

        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(100);
            if(binaryTree.add(randomNumber)){
                System.out.println("Eingefügte Zahl: " + randomNumber);

            }else {
                collisions+=1;
            }
        }

        System.out.println("Traversierung des Binärbaums:");
        System.out.println(binaryTree.traverse());
        System.out.println("Collisionen: " + collisions);

    }
}
