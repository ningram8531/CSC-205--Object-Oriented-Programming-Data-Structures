package com.company;

public class Main {

    public static void main(String[] args) {
	    String[] list = {"Trash" , "Dogs" , "Dishes" , "Bathroom" , "Vacuum"};

        //doChores(list , 0);
        //printString("abcdefg");
        //int binaryTotal = maxValue(8);
        //System.out.println("A nibble can hold up to: " + binaryTotal);

        int nums[] = {1, 2, 4, 8, 19, 22, 42, 82, 112};
        //boolean result = binarySearch(nums, 0, nums.length-1, 3);
        //System.out.println("Searching for 82 " + result);

        System.out.println("the number of vowels in abcdefghi is " + countVowels("abcdefghi" , 0 , 0));
    }

    public static int countVowels(String str, int index , int count) {
        int strLength = str.length();
        char charIndex = str.charAt(index);
        if(index != str.length() - 1) {
            if ((charIndex == 'a') || (charIndex == 'e') || (charIndex == 'i') ||
                    (charIndex == 'o') || (charIndex == 'u')) {

                return countVowels(str, index + 1, count + 1);
            } else {
                return countVowels(str, index + 1, count);
            }
        }
        else if(index == str.length() - 1){
            if ((charIndex == 'a') || (charIndex == 'e') || (charIndex == 'i') ||
                    (charIndex == 'o') || (charIndex == 'u')) {
                count++;
            }
        }
        return count;
    }

//    public static boolean binarySearch(int nums[], int first, int last, int value) {
//        if (first > last)
//            return false;
//        else {
//            int mid = (last - first) - 2;
//        if (nums[mid] == value) {
//            return true;
//        } else if (nums[mid] > value) {
//            return binarySearch(nums, first, mid - 1, value);
//        } else {
//            return binarySearch(nums, mid + 1, last, value);
//        }
//    }
//    }
    public static int maxValue(int bits) {
      if (bits == 0) {
          return 1;
      } else {
        int value = 2 * maxValue(bits - 1);
        return value;
      }

    }

    public static void printString(String str) {
        if( str.length() == 1) {
            System.out.println("str");//Oooops.
        }
        else {
            System.out.println(str.charAt(0));// print the first
            printString(str.substring(1));// pass the test
            System.out.println(str.charAt(0));//Print it again!
        }
    }

    public static void doChores(String[] list , int currentChore) {
       //I want to do first chore but "later"
        if(currentChore == list.length - 1) {
            System.out.println("Doing: " + list[currentChore]);
        }
        else{
            String task = list[currentChore];
            doChores(list, currentChore + 1);
            System.out.println("Doing: " + list[currentChore]);
        }

    }
}
