public class ValidateArray {
    
    public static void main(String[] args){
        int arr[] = {1,100,24,2};

        System.out.println(validate(arr));
    }

    private static boolean validate(int[] arr) {
        for(int i=0;i<arr.length;i++)
            if(arr[i] >100 || arr[i] < 0)
                return false;
        return true;
    }
}
