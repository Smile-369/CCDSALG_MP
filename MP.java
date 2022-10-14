import java.util.*;
public class MP {
    static MergeSort ms= new MergeSort();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Input=sc.nextLine();
        String[] Sorted=suffixArrayCreation(Input);
        String[] temp = suffixArrayCreation(Input);;
        for(int i = 0 ; i<Sorted.length;i++){
            System.out.printf("%d %s \n",i+1,Sorted[i]);
        }
        System.out.printf("\n");

        ms.mergeSort(Sorted,0,Sorted.length-1);
        int[] Index=Index(Sorted,temp);
        for(int i = 0 ; i<Sorted.length;i++){
            System.out.printf("%d %s\n",Index[i]+1,Sorted[i]);
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
