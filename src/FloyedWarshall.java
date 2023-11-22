import java.util.PriorityQueue;
import java.util.Scanner;

public class FloyedWarshall {

    private int[][] matrix;
    private PriorityQueue<Integer> pq;

    public FloyedWarshall(int[][]matrix, PriorityQueue pq)
    {
        this.matrix = matrix;
        this.pq = pq;
    }


    public void minLength(){

        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }

        int min = 10000;
        int sum;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            if (!pq.contains(i)&& i<matrix.length-1)
                i++;
            for (int j = 0; j < matrix.length; j++) {
                if (pq.contains(j))
                    sum += matrix[i][j];
            }
            min = min>sum?sum:min;
        }
        System.out.print(min);

    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int infinity = 10000;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int studentFreq = input.nextInt();
        int classFreq = input.nextInt();
        int pathFreq = input.nextInt();
        int[][] matrix = new int[classFreq][classFreq];
        for (int i = 0; i < classFreq; i++) {
            for (int j = 0; j < classFreq; j++) {
                matrix[i][j] = infinity;
            }
            matrix[i][i] = 0;
        }


        for (int i = 0; i < studentFreq; i++) {
            pq.add(input.nextInt() - 1);
        }

        for (int i = 0; i < pathFreq; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            matrix[a-1][b-1] = c;
            matrix[b-1][a-1] = c;
        }

        FloyedWarshall fw = new FloyedWarshall(matrix, pq);
        fw.minLength();


    }



}
