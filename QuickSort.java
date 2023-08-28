package DataStructureInterviewPreparation;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int arr[] = {8 , 5 , 9 , 3 , 23 , 1};
        int n = arr.length;
        qs(arr , 0 , n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void qs(int arr[] , int start , int end){

        if(start < end){

            int pivotIndex = partition(arr , start , end);
            qs(arr , start , pivotIndex-1);
            qs(arr , pivotIndex+1 , end);

        }




    }

    public static int partition(int arr[] , int start , int end){

        int pivot = arr[start];
        int i = start;
        int j = end;

        while(i < j){

            while(arr[i] <= pivot && i <= end-1){

                i++;

            }

            while(arr[j] > pivot && j >= start+1){

                j--;
            }

            if(i < j) {
                int temp  =arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }



        int temp = arr[start];
        arr[start] = arr[j];
        arr[j] = temp;

        return j;



    }
}
