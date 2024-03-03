package dsandalgosimpl;
import java.util.*;


public class DSAndAlgos {

    public static void printArr(List<Integer> arr){
        for (var a : arr
             ) {
            System.out.printf("%d, ", a);
        }
        System.out.println();
    }

    public static void bubbleSort(ArrayList<Integer> arr){
        int ptr = 0;

        for (int i = 0; i < arr.size(); i++) {
            for(int j = 0; j < arr.size()-ptr-1; j++) {
                if(arr.get(j) > arr.get(j+1)){
                    Integer temp = arr.get(j+1);
                    arr.set(j+1, arr.get(j));
                    arr.set(j, temp);
                }
            }
            ptr++;
        }
        System.out.println();
        printArr(arr);
    }


    public static void insertionSort(ArrayList<Integer> arr){
        Integer max = null;
        Integer maxIndex = -1;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size()-i ; j++) {
                if( max == null || arr.get(j) > max) {
                    maxIndex = j;
                    max = arr.get(j);
                }
            }

            //swap
            Integer temp = arr.get(arr.size()-i-1);
            arr.set(arr.size()-i-1, arr.get(maxIndex));
            arr.set(maxIndex,temp);

            maxIndex = -1;
            max = null;
        }

        System.out.println();
        printArr(arr);
    }

    public static void insertHeap(ArrayList<Integer> arr, Integer value){
        arr.add(value);
        long current = arr.size()-1;
        long parent = (current-1)/2;
        while(arr.get((int) parent) < arr.get((int) current) && parent >=0){
            System.out.println(parent + " "+ current);
            Integer temp = arr.get((int) parent);
            arr.set((int) parent, arr.get((int) current));
            arr.set((int) current, temp);
            current = parent;
            parent = (current-1)/2;
        }

        arr.sort((Integer a, Integer b)->-1);

        printArr(arr);
    }

    public static void heapify(){
        ArrayList<Integer> arr;
        // comparator using lambda
        PriorityQueue<String> q = new PriorityQueue<String>(
                (String a,String b)->{
                    if (a.length() < b.length())
                        return -1;
                    else return 1;
                });
        q.add("Hello");
        q.add("Hellsdfdsfdso");
        q.add("Helo");
        q.add("Hellodsfdsfdsfdsfsdf");
        q.add("Hlo");

        while (q.size() != 0) {
            System.out.println(q.remove());
        }



    }


    public static void main(String[] args) {

        System.out.println("Hello, world");

        int[] arr = new int[50];

        //arr.length;

        String s = "anagram";
        String t = "nagaram";
        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(mp.get(s.charAt(i)) == null)
                mp.put(s.charAt(i), 1);
            else mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
        }

        mp.forEach((k,v)->{
            System.out.println(k+": "+v);
        });

        boolean result = false;
        for (int i = 0; i < t.length(); i++) {
            if(mp.get(t.charAt(i)) == null){
                result = false;
                break;
            }
            if(mp.get(s.charAt(i))-1 < 0){ result = false; break;}
            if(mp.get(s.charAt(i))-1 == 0){ mp.remove(s.charAt(i));}
            else mp.replace(s.charAt(i), mp.get(s.charAt(i))-1);
        }




//        for (int i = 0; i <mp.size() ; i++) {
//            System.out.println(mp.get());
//        }
        // DSAndAlgos.bubbleSort(new ArrayList<>(Arrays.asList(5,4,3,2,1,45,6,7)));
//        DSAndAlgos.insertionSort(new ArrayList<>(Arrays.asList(5,4,3,2,1,45,6,7)));
//        insertHeap(new ArrayList<>(Arrays.asList(5,4,3,2,1)), 45);
        //        printArr(new ArrayList<>(Arrays.asList(1,2,3,4)));

//        heapify();
    }

}
