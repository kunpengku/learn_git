package learn_sort;

/**
 * Created by fupeng on 2017/5/2.
 */
public class TestSort {

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

//        select_sort(src);
//        merge_sort2(src,0, src.length-1);
        insert_sort(src);

        show(src);

    }

    private static void insert_sort(int[] src) {
        int len=src.length;

        for(int i=1; i<len;i++){
            for (int j=i;j>0 && src[j] < src[j-1];j--)
                exch(src,j,j-1);
        }

    }

    private static void merge_sort2(int[] src, int lo, int hi) {
        if(lo>=hi)
            return;

        int mid = (lo+hi)/2;
        merge_sort2(src,lo,mid);
        merge_sort2(src,mid+1,hi);

        merge2(src,lo,mid,hi);
    }

    private static void merge2(int[] src, int lo, int mid, int hi) {
        int i=lo, j=mid;
        int m=mid+1, n=hi;

        int []temp = new int[src.length];

        int k=0;
        while(i<=j && m<=n){
            if(src[i]<=src[m])
                temp[k++] = src[i++];
            else
                temp[k++] = src[m++];
        }
        while (i<=j)
            temp[k++] = src[i++];
        while (m<=n)
            temp[k++] = src[m++];

        for(i=0;i<k;i++)
            src[lo+i] = temp[i];
    }

    private static void select_sort(int[] src) {

        int len = src.length;
        for(int i=0; i<len-1;i++){
            int min=i;

            for(int j=i;j<len ;j++){
                if(src[j] <src[min]){
                    min=j;
                }
            }

            exch(src,min,i);
        }
    }
}
