package learn_sort;

/**
 * Created by yuan on 2017/2/18.
 */


//选择排序，在全部n个人中选出 最好的一个人，排在最前面，
//第二步，在剩下的n-1个人中选出最好的一个，排序n-1的最前面
//第三部，在剩下的n-2个人里面选出最好的一个人，排在n-2个人的最前面。
//依次类推，最后剩下两个人的时候，选出一个，排在2个人的前面
//当剩下最后一个人的时候，就不用比较了，自然就是最后一名了。

//这是生活中比较常见的例子，比如买菜的时候，在一堆蔬菜中，就挑选最好的一个，
//你买走后，下一个人来挑，还是挑剩下的里面，最好的一个，只到最后一个倒霉的人来，发现，
//我靠，都被前面的挑光了，他很可能就不买了，走了，最后剩下的，就是最烂的一个无疑。
//这就是选择排序

public class SelectSort {

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

    private static void select_sort(int [] src){
        for(int i=0; i<src.length-1;i++){
            int min=i;
            for(int j=i+1;j<src.length;j++){
                if(src[j] < src[min]){
                    min=j;
                }
            }
            exch(src,i,min);
        }
    }
    public static void main(String[] args) {
        int [] src = {9,7,5,3,1,2,4,6,8,0};

        select_sort(src);

        show(src);
    }
}
