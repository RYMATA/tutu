
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class QueueStack {
    public class MyStack<V> {

        private ArrayList<V> list;

        public MyStack() {
            this.list = new ArrayList<>();
        }

        public void push(V val) {
            this.list.add(val);
        }

        public int size() {
            return this.list.size();
        }

        public V firstElement() {
            return this.list.get(0);
        }

        public void removeElement(V firstElement) {
            this.list.remove(this.list.get(0));
        }
    }




    private MyStack<Integer> stack;

    public QueueStack() {
        this.stack = new MyStack<Integer>();
    }


    public String put(int val){
        this.stack.push(val);
        return null;
    }

    public String get(){
        if(this.stack.size() == 0)
            return "error";

        int val = this.stack.firstElement();
        this.stack.removeElement(this.stack.firstElement());
        return String.valueOf(val);
    }

    public static void main(String[] args) {



        QueueStack queue = new QueueStack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int temp = 0;
        try {
            temp = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> ans = new ArrayList<>();

        for(int i =0; i < temp; i++){
            try {
                String[] comms;
                String s =  br.readLine();

                comms = s.split(" ");
                if(comms[0].equalsIgnoreCase("get")){
                    ans.add(queue.get());
                } else if(comms[0].equalsIgnoreCase("put")){
                    queue.put(Integer.parseInt(comms[1]));
                } else if(comms[0].equalsIgnoreCase("get_size")) {
                    ans.add(String.valueOf(queue.stack.size()));
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }


        }

        for(String t : ans){
            if(t != null){
                System.out.println(t);
            }

        }
    }
}
