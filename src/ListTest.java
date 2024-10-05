//this is the test class to test the custom linked list and it's functionalities
public class ListTest {
    public static void main(String[] args) {
        CustomLinkedList<Integer>list = new CustomLinkedList<>();
        System.out.println("Getting size when the list is empty: "+list.getSize());
        list.addLast(1);
        list.addLast(3);
        list.addLast(5);
        list.addLast(9);
        System.out.println();
        System.out.println("Getting the list after adding elements"+list.toString());
        System.out.println();
        System.out.println("Size after adding elements: " + list.getSize());
        list.delete(5);
        list.delete(10);
        System.out.println();
        System.out.println("List after deleting 5 and 10 from it: "+list.toString());

        System.out.println("List size after deleting elements: "+list.getSize());
        System.out.println();
        System.out.println("getting a value by index: "+list.get(0));

    }
}
