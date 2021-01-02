

import javax.management.remote.JMXServerErrorException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String[] mas = s.split(" ");
        int len =0;

        sort(mas,0,mas.length-1);

        for(String t : mas){
            System.out.print(t);
        }

    }

    public static void sort(String[] mas, int l, int r){
        if(l < r){
            int m = (l + r)/2;

            sort(mas,l,m);
            sort(mas,m + 1, r);

            merge(mas,l,m,r);
        }
    }

    private static void merge(String[] mas, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m ;

        String L[] = new String[n1];
        String R[] = new String[n2];

        for(int i = 0; i < n1; i++){
            L[i] = mas[i + l];
        }
        for(int i = 0; i < n2; i++){
            R[i] = mas[m + 1 + i];
        }

        int i =0;
        int j =0;
        int k = l;

        while(i < n1 && j < n2){
            if(compare2(L[i],R[j]) == -1){
                mas[k] = L[i];
                i++;
            } else{
                mas[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            mas[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            mas[k] = R[j];
            j++;
            k++;
        }

    }


    public static int compare2(String o1, String o2) {
        String v1 = o1 + o2;
        String v2 = o2 + o1;
        return Integer.compare(Integer.parseInt(v2), Integer.parseInt(v1));
    }
}
