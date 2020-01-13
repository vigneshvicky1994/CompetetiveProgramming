import java.util.HashMap;
import java.util.Stack;

public class printnexthigh {
    public static void main(String args[]){
        int[] arr ={16, 17, 4, 3, 5, 2}; //{17, 5, 5, 5, 2, -1}
        printNextHighelement(arr);

    }

    private static void printNextHighelement(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        stack.push(arr[0]);
        for (int i= 1; i<arr.length;i++){
            int next = arr[i];

            if(!stack.isEmpty()){
                int element = stack.pop();
                if( next < element){
                    stack.push(element);
                    stack.push(next);
                }
                else{
                    while(element < next){
                        hmap.put(element,next);
                        System.out.println("The Next Greatest element for " + element + "-->" + next);
                        if(!stack.isEmpty()) {
                            element = stack.pop();
                        }
                        else{
                            break;
                        }
                    }
                    stack.push(next);
                }

            }


        }
        while(!stack.isEmpty()){
            int element = stack.pop();
            hmap.put(element,-1);
            System.out.println("The Next Greatest element for " + element + "-->" + "-1");
        }
        System.out.println(hmap.toString());
    }


}
