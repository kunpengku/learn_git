package learn_sort;

/**
 * Created by yuan on 2017/2/18
 *  所有的排序，都基于一个可以比较的事实，就像人一样，一定有一方面是可以比较的，这样才会有排序出来。
 *  插入排序是什么思想呢？
 *  插入排序，首先认为第一个元素是有序的，当然了， 一个元素，即是最大的，也是最小的。
 *  把第二个元素和第一个比较，如果小于第一个元素，那么和第一个元素换一下，否则就不动了，
 *  这样就把前两个元素，排序了。
 *  那么对于第三个元素，怎么办呢？这时候，前面的元素，都已经有序了，
 *  问题就变成了，把第三个元素插入 一个有序的整体中的问题。
 *  只需要从后，依次向前比较，因为最前面的是最小的，最后面的是最大的。
 *  所以，如果，第三个元素，小于某个元素，那么就可以，和该元素换一个，
 *  然后继续和前一个比较，如果还是小于，那么再换一下，
 *  那么，如果发现大于某个元素时，这是，就是它的正确位置，就不用动了，这第三个元素就排序完成了，
 *  以此类推，可以把后面的元素，都找到应该插入的地方，这样排序就结束了。
 *
 */



public class InsertSort {

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

        insert_sort(src);

        show(src);
    }

    private static void insert_sort(int[] src) {
        int N = src.length;
        for(int i=1; i<N; i++){
            for(int j=i; j>=1 && src[j ] < src[j-1];j--)
                exch(src,j,j-1);
        }
    }
}
