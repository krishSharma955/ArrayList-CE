package ArrayList;

import java.util.ArrayList;

public class PairSum2 {
    public static boolean bruteForce(ArrayList<Integer> list, int target) { //Time Complexity - O(N^2)
        for(int i = 0; i<list.size(); i++) {
            for(int j = i+1; j<list.size(); j++) {
                if(list.get(i)+list.get(j)==target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twoPointer(ArrayList<Integer> list, int target) { //Time Complexity - O(N)
        int pivot = -1;
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i)>list.get(i+1)) {
                pivot = i;
                break;
            }
        }
        int left = pivot+1;
        int right = pivot;
        while(left!=right) {
            if(list.get(left)+list.get(right)==target) {
                return true;
            }
            else if(list.get(left)+list.get(right)<target) {
                left = (left+1)%(list.size());
            }
            else {
                right = ((list.size())+right-1)%(list.size());
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //Rotated & Sorted ArrayList
        //11,15,6,8,9,10
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 14;

        System.out.println(bruteForce(list, target));

        System.out.println(twoPointer(list, target));
    }
}
