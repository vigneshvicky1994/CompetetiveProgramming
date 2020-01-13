import java.util.Arrays;
import java.util.Collections;

public class IntList {
    int[] num;
    int ptr;
    IntList(){
        num = new int[100];
        ptr = 0;
    }
    public void add( int x){
        if(ptr >=100 ) {
            System.out.println("Array Size Exceeds..");
            return;
        }
        num[ptr] = x;
        ptr++;
    }
    public void display(){
        for(int i=0;i<ptr;i++){

            System.out.println(num[i]);
        }
    }
    public void sort(){
        Arrays.sort(num);
    }
    public int findMedian(){
        this.sort();
        if(num.length % 2 == 0){
            int mid = num.length/2;
            int avg = (num[mid] + num[mid + 1])/2;
            return avg;

        }else{
            int mid = num.length/2;
            return num[mid];
        }
    }
}
