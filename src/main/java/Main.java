import java.util.ArrayList;

public class Main {

    public static Object lis(int[] arr) {
        int[] newArr = new int[arr.length];
        int[] solution = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            newArr[i] = 1;
            solution[i] = i;
        }

        // {3,2,5,6,1,10,7}
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(newArr[j]+1 > newArr[i]){
                        newArr[i] = newArr[j] +1;
                        solution[i] = j;
                    }
                }
            }
        }
        // max index
        int maxIndex = 0;
        for(int i = 0; i < newArr.length; i++){
            if(newArr[i] > newArr[maxIndex]){
                maxIndex = i;
            }
        }

        // print solution
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = solution[t];
        }while(t != newT);
        System.out.println();

        return newArr[maxIndex];
    }


    public static void main(String[] args) {

        int[] arr = {3,2,5,6,1,10,7};
        System.out.println(lis(arr));
    }

}