package contests.yandex.weekend_offer.first.matrix;


import java.io.*;

import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(reader);
        int n = scanner.nextInt();
        int size = n * 2 + 1;
        int[][] arr = new int[size][size];
        int tmp = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 1)
                    arr[i][j] = tmp++;
            }
        }

        tmp = -1;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (i == j)
                    arr[i][j] = 0;
                else if ((i + j) % 2 == 0)
                    arr[i][j] = tmp--;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j != size - 1)
                    System.out.print(arr[i][j] + " ");
                else
                    System.out.print(arr[i][j] + "\n");
            }
        }

        reader.close();
        writer.close();
    }
}
