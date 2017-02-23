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







    public static void main(String[] args) {
        int [] src = {9,7,5,3,1,2,4,6,8,0};

        quick_sort(src,0, src.length-1);
//        quick_3sort(src,0, src.length-1);
        show(src);
    }


    private static void quick_sort(int[] src, int lo, int hi) {
        if(lo>= hi)
            return;

        int h = partition(src,lo,hi);

        quick_sort(src,lo,h-1);
        quick_sort(src,h+1,hi);
    }
    // com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray.partition()
    private static int partition(int[] src, int lo, int hi) {
        int x = src[(lo+hi) >>> 1];
        int i= lo-1;
        int j=hi+1;

        while(true){
            while (src[--j] > x);
            while (src[++i] < x);
            if(i<j) {
                int tmp = src[i];
                src[i] = src[j];
                src[j] = tmp;
            }else
                return j;
        }
    }

    private static void quick_3sort(int[] src, int lo, int hi) {
        //快速排序因为 是 递归调用 ，一定要记得 退出递归的判断。
        if(lo>=hi)
            return;

        int key = src[lo];
        int lt=lo,i=lo+1,gt=hi;

        while(i<=gt){
            if(src[i]<src[lt])
                exch(src,i++,lt++);
            else if(src[i] > src[gt])
                exch(src,i,gt--);
            else
                i++;
        }

        quick_3sort(src,lo,lt-1);
        quick_3sort(src,gt+1,hi);
    }


}
