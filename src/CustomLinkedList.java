public class CustomLinkedList <L>{
    private Node<L> head ; //reference

    private Node<L> toe ; //reference

    private int size = 0;

    static class Node<L>{
        //this inner class has two parameters; one is the value and the other one is a reference to the next node.
        Node<L> next; //reference to the next node.
        L value; //value
        Node(L value){
            this.value = value;
        }
    }

    //This method gets the value by index.
    public L get(int index){
        Node <L> nodeObject = head;
        while (nodeObject != null) {
            if(index == 0){
                return nodeObject.value;
            }
            nodeObject = nodeObject.next;
            index--
            ;
        }
        return null;
    }

    //This method adds the 1st element.
    //When a user enters any data, it creates a new node object.
    //Then it creates a link.
    //The head is pointed to the start of the link.
    //If the toe is null then a reference of the last element is added to it.
    public void addFirst(L vl){
        Node<L> nodeObject = new Node<>(vl);
        nodeObject.next = head;
        head = nodeObject;

        if(toe==null){
            toe = nodeObject;
        }
        size++;
    }

    //The 1st node is added from this method.
    //This method calls the addFirst method to check whether the toe of the last node is null or not.
    //addFirst method is called for one more reason,that is adding the 1st node.
    //The method then creates a new node.
    //Adds the created node to the next toe.
    //Moves the toe to the end by assigning the toe a node.
    public void addLast(L vl){
        if(toe==null){
            addFirst(vl);
            return;
        }
        size++;
        Node<L> nodeObject = new Node<>(vl);
        toe.next = nodeObject;
        toe = nodeObject;
    }

    //This method deletes a node searching by value.
    public void delete(L val) {
        Node<L>nodeObject = head;
        Node<L>prev = null;

        if (nodeObject != null && nodeObject.value == val) {
            head = nodeObject.next;
            size--;
            return;
        }
        while (nodeObject != null && nodeObject.value != val) {
            prev = nodeObject;
            nodeObject = nodeObject.next;
        }
        if (nodeObject == null) return;

        prev.next = nodeObject.next;
        size--;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node<L> nodeObject = head;
        while(nodeObject!=null){
            builder.append(nodeObject.value).append("->");
            if(nodeObject==toe) builder.append("Done!");
            nodeObject = nodeObject.next;
        }
        return builder.toString();
    }

    //It returns the size of the CustomLinkedList.
    public int getSize() {
        return size;
    }
}
