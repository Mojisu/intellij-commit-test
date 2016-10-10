package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = null;
        File file;
        try {
            file = new File("C:\\Users\\MO\\IdeaProjects\\intellij-commit-test\\src\\com\\company\\input");
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Scanner sc = new Scanner(System.in);

        for (int T = sc.nextInt(); T > 0; T--) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int V[] = new int[N];
            int E[][] = new int[N][N];

            for (int i = N - 1; i >= 0; i--) {
                V[i] = 0;
                for (int j = N - 1; j >= 0; j--)
                    E[i][j] = -1;
            }

            for (int i = M - 1; i >= 0; i--)
                E[sc.nextInt()][sc.nextInt()] = sc.nextInt();

            int i = 0;
            int min = -1;
            int idx = -1;

            while (true) {
                // update distance and minimum distance
                for (int j = 0; j < N; j++) {
                    if (E[i][j] != -1 && (V[j] > V[i] + E[i][j] || V[j] == 0)) {
                        V[j] = V[i] + E[i][j];
                        if (min == -1 || min > V[j]) {
                            min = V[j];
                            idx = j;
                        }
                    }
                }
                if (idx == N - 1)
                    break;
                else {
                    i = idx;
                    min = -1;
                    continue;
                }
            }
            System.out.println(min);
        }
    }
}