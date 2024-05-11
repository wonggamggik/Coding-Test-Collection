import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] hx = br.readLine().split(" ");
        int H = Integer.parseInt(hx[0]);
        int x = Integer.parseInt(hx[1]);
      
        long sum = 0;
        int DIV = 1000000007;

        int[] snowballCounts = new int[H];
        for (int i = 0; i < H;i++) {
            snowballCounts[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= H; i++) {
            System.out.println(getSquare(x, i));
            sum += getSquare(x, i) * snowballCounts[i-1] % DIV;
        }

        System.out.println(sum % DIV);
    }
  
    public static long getSquare(int x, int i) {
        if (i == 0) {
            return 1;
        }
        long res = getSquare(x,i / 2);
        if (i % 2 ==0) {
            return res * res;
        }
        else {
            return res * res * x;
        }
    }
}
