package learn_queue;

/**
 * Created by yuan on 2017/2/22.
 */
public class MaxPQ {
    private int [] pq;
    private int N = 0;

    public MaxPQ(int N){
        pq = new int[N];
    }

    public void insert(int key){
        pq[++N] = key;
        swim(N);
    }

    private void swim(int k) {
        while(k>1 && pq[k] > pq[k/2]){
            exch(k,k/2);
            k=k/2;
        }
    }


    public int delMax(){
        int max = pq[1];
        exch(1,N--);
        sink(1);

        pq[N+1]=0;

        return max;
    }

    private void sink(int k) {
        while(2*k < N){
            int j= 2*k;
            if(j<N && pq[j] < pq[j+1])
                j++;
            if(pq[j] < pq[k])
                break;
            exch(j,k);
            k=j;
        }
    }


    private void exch(int i, int j){
        int tmp=pq[i];
        pq[i]=pq[j];
        pq[j] = tmp;
    }


    public static void main(String[] args) {
        MaxPQ a = new MaxPQ(10);

        a.insert(6);
        a.insert(6);
        a.insert(5);
        a.insert(3);
        a.insert(17);
        a.insert(2);

        for(int i=0;i<6;i++){
            System.out.println(a.delMax());
        }

    }
}
