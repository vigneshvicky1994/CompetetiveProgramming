class RemoveLastList {

    public void display() {
        Node itr = head;
        while(itr != null ){
            System.out.println(itr.data);
            itr = itr.next;
        }
    }

    private class Node{
        private int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    private Node head;
    private Node curr;

    public RemoveLastList(){
        head = null;
    }

    public void removeLast(){
        if(head == null){
            return;
        }
        Node iterator = head;
        Node prev = null;
        while(iterator.next != null){
            prev = iterator;
            iterator = iterator.next;
        }
        if(prev != null){
            prev.next = null;
        }
        else{
            head = null;
        }

    }
    public void addElement(int data){
        Node temp = new Node(data);
        if(curr == null && head == null){
            head = temp;
            curr = temp;
        }else{
            curr.next = temp;
            curr = curr.next;
        }

    }


}
public class MainClass{
    public static void main(String[] args){
        RemoveLastList list = new RemoveLastList();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);
        list.addElement(6);

        list.display();

        //method to delete the last node called
        list.removeLast();

        // check the list entries

        list.display();


    }
}



