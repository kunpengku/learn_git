package learn_sort;

/**
 * Created by fupeng on 2017/4/10.
 */


public class quick_sort {

    private static void show(int [] src){
        for(int i : src){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int [] src = {9,7,5,3,1,2,4,6,8,0};
//        quick(src,0,src.length-1);
        quick_v3(src,0,src.length-1);

        show(src);
    }

    private static void quick_v3(int[] src, int lo, int hi) {
        if(lo>=hi)
            return;

        int lt=lo, gt=hi, i=lo+1;
        int key=src[lo];
        while(i<=gt){
            if(src[i] < key)
                swap(src,i++,lt++);
            else if(src[i] > key)
                swap(src,i,gt--);
            else
                i++;
        }

        quick_v3(src,lo, lt-1);
        quick_v3(src,gt+1, hi);
    }

    private static void quick(int[] src, int lo, int hi) {
        if(lo>=hi){
            return;
        }

        int k  = partition(src,lo,hi);

        quick(src,lo,k-1);
        quick(src,k+1,hi);
    }

    private static int partition(int[] src, int lo, int hi) {
        int i=lo-1, j=hi+1;
        int key = src[(lo+hi)>>>1];

        while(true){
            while(src[--j] > key);
            while (src[++i] < key);
            if(i<j)
                swap(src,i,j);
            else
                return j;
        }
    }

    private static void swap(int[] src, int i, int j) {
        int tmp=src[i];
        src[i]=src[j];
        src[j] = tmp;
    }
}
