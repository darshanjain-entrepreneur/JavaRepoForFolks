package DataStructureInterviewPreparation;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void merge(int arr[] , int start , int end){

        if(start >= end){
            return;
        }

        int mid = (start+end)/2;

        merge(arr , start , mid);
        merge(arr , mid+1 , end);

        merging(arr , start , mid , end);


    }

    public static void merging(int arr[] , int start , int mid , int end) {

        ArrayList<Integer> ll = new ArrayList<>();

        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {

            if (arr[left] <= arr[right]) {
                ll.add(arr[left]);
                left++;


            } else {

                ll.add(arr[right]);
                right++;
            }

        }

        while(left <= mid){

            ll.add(arr[left]);
            left++;
        }

        while(right <= end){

            ll.add(arr[right]);
            right++;
        }

        for(int i = start; i <= end; i++){

            arr[i]  =  ll.get(i - start);
        }

    }


    public static void main(String[] args) {

        int arr[] = {87 , 0 , 0 , 0};
        int n = arr.length-1;

        merge(arr , 0 , n);

        System.out.println(Arrays.toString(arr));
    }
}
