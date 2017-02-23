package learn_sort;

/**
 * Created by yuan on 2017/2/18
 *
 * 有一个人叫DL shell，也就是希尔。改良了插入排序，
 * 认为每次比较一个，这样的速度太慢了，可以跨越一点。
 * shell 排序，把间隔，变为h，然后h每次见到，
 * 最后，当h减为1的时候， 就变成插入排序了
 *
 *
 */



public class ShellSort {

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

        shell_sort(src);

        show(src);
    }

    private static void shell_sort(int[] src) {
        int N = src.length;
        int h=1;
        while (h<N/3){
            h = h*3+1;
        }

        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i; j>=h && src[j] < src[j-h]; j= j-h){
                    exch(src,j,j-h);
                }
            }

            h=h/3;
        }
    }
}
