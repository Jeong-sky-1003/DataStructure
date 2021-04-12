package barkingdog.chap04;

import caseStudy.MyStart;

public class Example01 implements MyStart {

    final int MAX = 10;
    // 다음 원소가 들어갈 위치를 가리킴
    // 구현 편의상 next에서 가장 큰 값에 1을 더한 상태로 초기화하겠음
    int unused = 6;

    int []datas = null;
    int []pre = null;
    int []next = null;

    public Example01() {
        datas = new int[]{-1, 65, 13, 0, 21, 17};
        pre = new int[]{-1, 2, 0, 0, 1, 4};
        next = new int[]{2, 4, 1, 0, 5, -1};
    }

    @Override
    public void start() throws Exception {
        traverse();
        insert(1,30);
        traverse();
        erase(1);
        traverse();
    }

    private void traverse() {

        StringBuilder builder = new StringBuilder();

        int cur = next[0];
        while (cur != -1) {
            int data = datas[cur];
            builder.append( data + " ");
            cur = next[cur];
        }

        System.out.println(builder.toString());

    }

    private void insert(int addr, int num) {
        // addr은 연결 리스트 상에서 두 번째가 아닌, 해당 원소의 주소가 2번지

        int []tmpDatas = datas.clone();
        int []tmpPre = pre.clone();
        int []tmpNext = next.clone();

        this.datas = new int[datas.length + 1];
        this.pre = new int[datas.length + 1];
        this.next = new int[datas.length + 1];

        int nextVar = tmpNext[addr];
        for (int i=0; i < unused+1; i++) {

            if ( i < unused ) {
                this.datas[i] = tmpDatas[i];
                this.pre[i] = tmpPre[i];
                this.next[i] = tmpNext[i];
            } else {
                this.datas[i] = num;
                this.pre[i] = addr;
                this.next[i] = nextVar;
            }

        }

        this.next[addr] = unused;
        this.pre[nextVar] = unused++;

    }

    private void erase (int addr) {
        // addr은 연결 리스트 상에서 두 번째가 아닌, 해당 원소의 주소가 2번지

        int preIndex = pre[addr];
        int nextIndex = next[addr];

        // pre 위치는 더미변수로 -1이 없다는 것이 보장되지만,
        // next의 위치는 마지막 원소를 지우는 상황에서 -1일 수 있기 때문임
        if (next[preIndex] != -1)
            next[preIndex] = nextIndex;

        pre[nextIndex] = preIndex;

    }

}
