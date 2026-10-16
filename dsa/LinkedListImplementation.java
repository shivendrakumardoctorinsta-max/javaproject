package dsa;
public class LinkedListImplementation {
    Node head;
    int size;

    LinkedListImplementation(){
        this.size = 0;
    }
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head != null)
            newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node curNode = head;

        while (curNode.next != null) {
            curNode = curNode.next;
            
        }

        curNode.next = newNode;
    }

    public void printLL(){
        Node curNode = head;

        while (curNode != null) {
            System.out.print(curNode.data + "->");
            curNode = curNode.next;
            
        }

        System.out.print("null");
        System.out.println("");
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        head = head.next;
        size--;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        size--;

        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node last = head.next;
        

        while (last.next != null) {
            secondLast = secondLast.next;
            last = last.next;
            
        }

        secondLast.next = null;
    }

    public int size(){
        return size;
    }



    public static void main(String[] args) {
        LinkedListImplementation ll = new LinkedListImplementation();
        ll.addFirst("is");
        ll.addFirst("this");
        ll.addLast("list");
        
        ll.printLL();
        System.out.println("List size: "+ ll.size());
        ll.deleteFirst();
        ll.printLL();
        System.out.println("List size: "+ ll.size());
        ll.deleteLast();
        ll.printLL();
        
        System.out.println("List size: "+ ll.size());
        ll.addLast("list");
        System.out.println("List size: "+ ll.size());

    }
}
