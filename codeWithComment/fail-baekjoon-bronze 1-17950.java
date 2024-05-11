// 문제 구상
/*
 * 산의 높이 H, 1cm 줄어들면 x배 된다. / 처음 크기는 1이다.
 * (1 ≤ H ≤ 106, 1 ≤ x ≤ 100)
 * 첫줄에서 H와 x가 주어지고, 2번째부터 주는 수는 높이가 i-1일 때 공의 수다.
 * 각 공들이 땅에 도착했을 때 모은 공의 크기의 합을 구하여라
 * 10^9 + 7로 나눈 나머지를 출력하라.
 *
 * 각 줄의 수에서 x^n을 해주면 된다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        // 기본적으로 코딩테스트의 경우 입력에서 문제가 생길 경우가 있기 BufferedReader로 입력받는다.
        // BufferedReader 객체를 불러온다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // H와 x를 입력받는다. 이때 다시 H와 x로 쪼갤 것이기에 편하게 배열로 변환해둔다.
        String[] hx = br.readLine().split(" ");
        // H와 x로 쪼개고 이를 정수로 변환해준다.
        int H = Integer.parseInt(hx[0]);
        int x = Integer.parseInt(hx[1]);

        // 결과를 출력해야 될 result를 sum으로 나타낸다.
        // 이때, int의 범위를 넘어설 수 있기에 long 자료형을 사용한다.
        long sum = 0;

        // 10^9 + 7로 나눈 나머지를 답으로 구해야 하기에 미리 적어둔다.
        int DIV = 1000000007;

        // 스노우볼 갯수를 한 곳에 모아준다.
        int[] snowballCounts = new int[H];
        for (int i = 0; i < H;i++) {
            snowballCounts[i] = Integer.parseInt(br.readLine());
        }

        // H만큼 입력이 이루어지기에 반복문을 통해 입력을 받는다.
        for(int i = 1; i <= H; i++) {
            // 우선 눈덩이 크기를 구한다. getSquare에서 long의 크기의 값이 나오고, 갯수를 같이 곱한다음 DIV를 해준다.
            // 총합에서 DIV로 나눈 나머지와 각 값의 나머지의 합을 다시 DIV로 나눈 나머지의 합은 언제나 같으므로 문제 없다.
            // 코드의 효율화를 위해 sum에 바로 더해준다.
            System.out.println(getSquare(x, i));
            sum += getSquare(x, i) * snowballCounts[i-1] % DIV;
        }

        // 결과를 출력해준다.
        System.out.println(sum % DIV);
    }

    // 제곱해주는 함수, Math.pow는 double을 반환하기에 함수로 구현했다.
    // 최대로 나올 수 있는 값인 100^(10^6)은 long은 넘을 수 없기에 그냥 구하면 된다.
    // 일반 제곱은 O(N)의 시간 복잡도를 가지기에 효율화 해서 O(logN)의 복잡도를 가진 정복 분할 곱하기를 사용한다.
    // x는 밑, i는 지수
    public static long getSquare(int x, int i) {
        // 지수가 0인 경우 (종료 조건).
        if (i == 0) {
            return 1;
        }
        // 반으로 나눈 거듭제곱 계산.
        long res = getSquare(x,i / 2);
        // 지수가 짝수인 경우.
        if (i % 2 ==0) {
            return res * res;
        }
        // 지수가 홀수인 경우
        else {
            return res * res * x;
        }
    }
}
