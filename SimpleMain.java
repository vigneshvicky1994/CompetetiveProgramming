public class SimpleMain {
    public static void main(String[] args){
        IntList list = new IntList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(10);
        list.add(6);

        list.display();
        list.sort();
        list.display();
        list.add(9);
        System.out.println("Median is" + list.findMedian());

    }
}
