package learn_sort;

/**
 * Created by yuan on 2017/2/18
 *
 *
 *
 */



public class HeapSort {

    private static void show(int [] src){
        for(int i : src){
            System.out.println(i);
        }
    }

    private static void exch(int [] src, int i, int j){
        int tmp = src[i-1];
        src[i-1] = src[j-1];
        src[j-1] = tmp;
    }


    public static void main(String[] args) {
        int [] src = {9,7,5,3,1,2,4,6,8,0};

        heap_sort(src);

        show(src);
    }

    private static void heap_sort(int[] src) {
        int N = src.length;
        for(int k=N/2;k>=1;k--){
            sink(src,k,N);
        }
        while(N>1){
            exch(src,1,N);
            N--;
            sink(src,1,N);
        }

    }

    private static void sink(int[] src, int k, int n) {
        while((k)*2 <= n){
            int j =(k)*2;
            if(j<n && src[j-1] < src[j])
                j++;

            if(src[k-1]>src[j-1])
                break;
            exch(src,k,j);
            k=j;
        }
    }

}
