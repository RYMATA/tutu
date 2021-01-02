import java.io.*;
import java.util.Scanner;

public class BSam {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            int temp = Integer.parseInt(bufferedReader.readLine());
            int x = Integer.parseInt(bufferedReader.readLine());
            String[] mas1 = bufferedReader.readLine().split(" ");
            int[] mas = new int[temp];
             for(int i =0; i < temp; i++){
                 mas[i] = Integer.parseInt(mas1[i]);
             }
            System.out.println(search(0,mas.length-1,mas,x));
        } catch (IOException e) {
            e.printStackTrace();
        }


        }


    public static int search(int left, int right, int[] mas, int x){

        int mid = (left + right)/2;
        if(x == mas[mid]){
            return mid;
        }
        if(right < left){
            return -1;
        }

        if(mas[left] < mas[mid]){
            if(x >= mas[left] && x < mas[mid]){
                return search(left,mid-1,mas,x);
            }
            else{
                return search(mid+1,right,mas,x);
            }
        } else if(mas[mid] < mas[left]){
            if(x > mas[mid] && x <= mas[right]){
                return search(mid+1,right,mas,x);
            }else{
                return search(left,mid-1,mas,x);
            }
        }
        else if(mas[left] == mas[mid]) {
                if(mas[mid] != mas[left]){
                    return search(mid+1,right,mas,x);
                }else{
                    int res = search(left, mid-1,mas,x);
                    if(res == -1){
                        return search(mid+1,right,mas,x);
                    } else{
                        return res;
                    }
                }
        }
        return -1;
    }
}

