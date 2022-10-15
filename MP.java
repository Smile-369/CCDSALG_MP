import java.util.*;
public class MP {
    static MergeSort ms= new MergeSort();
    static BubbleSort bs= new BubbleSort();

    public static void main(String[] args) {
        int n= 128*(int) Math.pow(2,0);
        String Input=createRandomString(n);
        String[] bubbleSorted=suffixArrayCreation(Input);
        String[] mergeSorted=suffixArrayCreation(Input);
        String[] temp = suffixArrayCreation(Input);;

        System.out.printf("\n");

        bs.bubbleSort(bubbleSorted);
        int[] Index=Index(bubbleSorted,temp);
        System.out.printf("Bubble Sort: ");
        for(int i = 0 ; i<bubbleSorted.length;i++){
            System.out.printf(" %d ",Index[i]+1);
            if(i==bubbleSorted.length-1){
                System.out.printf("\n");
            }
        }
        ms.mergeSort(mergeSorted,0, mergeSorted.length-1);
        System.out.printf("Merge Sort: ");
        int[] Index2=Index(mergeSorted,temp);
        for(int i = 0 ; i<mergeSorted.length;i++){
            System.out.printf(" %d ",Index2[i]+1);
        }
    }
    static String[] suffixArrayCreation(String Input){
        String[] Final = new String[Input.length()];
        String temp = Input;
        for(int i= 0;i<Input.length();i++){
            temp = Input.substring(i, Input.length());
            Final[i]=temp;
        }

        return Final;
    }
    public static String createRandomString(int n){
        String Input ="acgt";
        StringBuilder s = new StringBuilder(n);
        for ( int i=0; i<n; i++) {


            int ch = (int)(Input.length() * Math.random());



            s.append(Input.charAt(ch));

        }

        return s.toString();

    }
    public static int[] Index(String[] Sorted, String[] Original){
        int[] Indexes=new int[Sorted.length];
        for(int i=0;i<Sorted.length;i++){
            for(int j = 0; j< Original.length;j++){
                if(Sorted[i].equals(Original[j])){
                    Indexes[i]=j;
                }
            }
        }
        return Indexes;
    }


}
 class MergeSort {

    public static String[] mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return a;
        }
        int mid = (from + to) / 2;

        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
        return a;
    }


    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;
        String[] b = new String[n];
        int i1 = from;
        int i2 = mid + 1;
        int j = 0;

        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }


        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }

        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }

        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }
}
class BubbleSort{
    public static void bubbleSort(String[] a){
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (a[j].compareTo(a[j+1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
    }
}
