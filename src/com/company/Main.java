package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        /*
        int i = sc.nextInt();
        long l = sc.nextLong();
        double d = sc.nextDouble();
        String str = sc.next();
        String line = sc.nextLine();
        */
        for(int T = sc.nextInt(); T > 0; T--) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int dist = 0;
            int min;

            int V[] = new int[N];
            int E[][] = new int[N][N];

            for(int i = N; i > 0; i--) {
                V[i] = -1;
                for (int j = N; j > 0; j--)
                    E[i][j] = -1;
            }

            for(int i = M; i > 0; i--)
                E[sc.nextInt()][sc.nextInt()] = sc.nextInt();

            int i = 0;
            while(true) {
                min = E[i][0];
                for (int j = 1; j < N; j++) {
                    if (E[i][j] > 0) {
                        V[i] = j;
                        if(E[i][j] < min)
                            min = E[i][j];
                    }
                }
            }

        }

        out.close();
    }

    public static PrintWriter out;

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
