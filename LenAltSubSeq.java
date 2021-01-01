
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {

    }


    ArrayList<Integer> GetAns(ArrayList<Integer> arr) {
        ArrayList<Integer> increas = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> decreasing = new ArrayList<>();
        int last_max = arr.size() - 1;
        boolean flag_min;

        int last_min = arr.size() - 1;
        boolean flag_max;
        for (int i = 0; i < arr.size(); i++) {
            increas.add(1);
            decreasing.add(1);
        }

        for (int i = arr.size() - 2; i >= 0; i--) {
            flag_max = false;
            flag_min = false;
            for (int k = i + 1; k < arr.size(); ++k) {
                if (arr.get(i) > arr.get(k) && increas.get(i) <= decreasing.get(k)) {
                    flag_max = true;
                    increas.set(i, decreasing.get(k));
                } else if (decreasing.get(i) <= increas.get(k) && arr.get(i) < arr.get(k)) {
                    flag_min = true;
                    decreasing.set(i, increas.get(k));

                }
                // can go from the end to [i] and [i] > [next]
                increas.set(i, flag_max ? increas.get(i) + 1 : increas.get(i));
                // can go from the end to [i] and [i] < [next]
                decreasing.set(i, flag_min ? decreasing.get(i) + 1 : decreasing.get(i));
                if (decreasing.get(i) >= decreasing.get(last_min)) {
                    last_min = i;
                }

                if (increas.get(i) >= increas.get(last_max)) {
                    last_max = i;
                }

            }
        }
        int length = increas.get(last_max);
        flag_max = true;
        flag_min = false;
        int starts_from = last_max;
        if ((increas.get(last_max) < decreasing.get(last_min)) ||
                (Objects.equals(increas.get(last_max), decreasing.get(last_min)) && last_max > last_min)) {
            flag_min = true;
            flag_max = false;
            starts_from = last_min;
            length = decreasing.get(starts_from);
        }

        for (int i = starts_from; i < arr.size(); ++i) {
            if (i == starts_from || (flag_max && arr.get(i) > ans.get(ans.size() - 1)) ||
                    (flag_min && arr.get(i) < ans.get(ans.size() - 1))) {
            }
            if (!flag_max && flag_min && decreasing.get(i) == length) {
                length -= 1;
                flag_max = true;
                flag_min = false;
                ans.add(arr.get(i));
            } else {
                if (flag_max && !flag_min && increas.get(i) == length) {
                    length -= 1;
                    flag_max = false;
                    flag_min = true;
                    ans.add(arr.get(i));
                }
            }
        }
        return ans;
    }
}

