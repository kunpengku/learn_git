package learn_sort;

/**
 * Created by yuan on 2017/2/18.
 * 快速排序 ，因为真的很快
 * 尤其是面对随机的数组时候，
 * 因此，数组规模越大，越应该用快速排序，
 * 如果数组规模很小，则可以是用选择排序。
 *
 * 春夏秋冬，进入最好在冬天，离开一定在夏天。
 */



public class QuickSort {

    private static void show(int [] src){
        for(int i : src){
            System.out.println(i);
        }
    }

    private static void exch(int [] src, int i, int j){
        int tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }

    static int partition(int [] src, int lo, int hi){
        int key = src[lo];
        int i=lo;
        int j=hi;
        while(i!=j){
            while(src[j] >= key && i<j)
                j--;
            while(src[i] <= key && i<j)
                i++;
            if(i!=j)
                exch(src,i,j);
        }
        exch(src,i,lo);

        return i;
    }

    static void quick_sort(int [] src, int lo, int hi){
        if(lo>=hi)
            return;
        int k = partition(src,lo,hi);

        quick_sort(src,lo, k-1);
        quick_sort(src,k+1,hi);

    }

    static void quick_3sort(int [] src, int lo, int hi){
        if(lo >= hi)
            return;

        int key = src[lo];
        int lt = lo;
        int gt = hi;
        int i = lt+1;
        
        while(i<=gt){
            if(src[i] < key)
                exch(src,i++,lt++);
            else if(src[i] > key)
                exch(src,i,gt--);
            else
                i++;
        }

        quick_3sort(src,lo,lt-1);
        quick_3sort(src,gt+1, hi);


    }
    public static void main(String[] args) {
        int [] src = {9,7,5,3,1,2,4,6,8,0};

//        quick_sort(src,0, src.length-1);
        quick_3sort(src,0, src.length-1);
        show(src);
    }
}
