package learn_sort;

import java.util.Map;

/**
 * Created by yuan on 2017/2/18
 * 归并排序采用了分治的思想
 * 如果 lo-mid 和 mid+1-hi 是两个有序序列，那么将两个有序序列合成一个
 * 更大的有序序列的方法是 merge(a, lo, mid, hi)
 *
 * 另一方面，如果一个序列，无限的细分，最后会分成每个子序列只有一个元素，
 * 一个元素本身就是有序的，然后再将这些 有序的序列合并起来，算法就完成了。
 *
 */



public class MergeSort {

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

    //这种归并排序 是 自顶向下。
    static void merge_sort(int [] src, int lo, int hi){
        if(lo >= hi)
            return;

        int mid = lo + (hi-lo)/2;
        merge_sort(src,lo, mid);
        merge_sort(src,mid+1,hi);

        merge(src,lo,mid,hi);
    }

    static void merge(int []src, int lo, int mid, int hi){
        int [] aux = new int[src.length];

        for(int i=lo;i<=hi;i++){
            aux[i] = src[i];
        }

        int i=lo;
        int j=mid+1;

        for(int k=lo;k<=hi;k++){
            if(i>mid)
                src[k] = aux[j++];
            else if(j>hi)
                src[k] = aux[i++];
            else if(aux[i] < aux[j])
                src[k] = aux[i++];
            else
                src[k] = aux[j++];


        }

    }

    //自底向上的 归并排序

    static void merge_sort_v2(int [] src){
        int N = src.length;
        for(int sz = 1; sz<N; sz = sz+sz){
            for(int lo=0; lo<N-sz; lo += sz+sz){
                //需要注意的是 最后一组的，后半段可能小于前半段 所以用 Math.min(N-1, lo+sz+sz-1), 不然会超过最大的长度
                merge(src, lo, lo+sz-1, Math.min(N-1,lo+sz+sz-1));
            }
        }
    }

    public static void main(String[] args) {
        int [] src = {9,7,5,3,1,2,4,6,8,0};

//        merge_sort(src,0, src.length-1);
        merge_sort_v2(src);
        show(src);
    }
}
