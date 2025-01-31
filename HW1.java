
/*
 * *** PLACE YOUR NAME / SECTION  HERE ***
 *
 * Homework # 1 (Programming Assignment). This Java class defines some basic
 * manipulation operations on Linked-Lists and Stacks.
 *
 * Additionally, there are two algorithm analysis methods where you need
 * to return a specified number as provided in comments of each method indicating
 * the complexity of the code shown. The testing routine will be looking for a
 * specific number returned.
 */

import java.util.Stack;

public class HW1 {

    /*
     * Class LinkedList
     *
     * This class builds a singly linked list. Each node of the linked-list
     * contains a single integer values.
     *
     * Methods:
     *  - void   sortInserted(val)     - Inserts value 'val' into the linked-list in
     *                                   sorted fashion
     *  - void   removeElementsLT(val) - Removed values in the linked-list that are less
     *                                   than 'val'
     *  - void   removeElement(val)    - Removes all values in the linked list of
     *                                   value 'val'
     *  - String toString()            - coverts and returns the linked-lists as a string
     *                                   delimited by brackets []
     *
     */

    static class LinkedList {
        static class Node {
            int data;
            Node next;

            Node(int d)  {        // Constructor
                data = d;
                next = null;
            }
        }
        Node head;                // head of Linked-list


        /*
         * Method sortedInsert() - this method will insert a new node to the
         * linked list containing the value specific in teh parameter 'data'.
         * The newly inserted node will be inserted in sorted order within
         * the linked-list.
         *
         */
        public void sortedInsert ( int data ) {
            Node new_node = new Node(data);

            new_node.next = null;

            // Special case for head node.
            if (this.head == null || head.data >= new_node.data ) {
                new_node.next = head;
                head = new_node;
            } else {
                // locate the node before the point of insertion
                Node current = this.head;

                // Identify where to place the item to insert
                while (current.next != null && current.next.data < data) {
                    current = current.next;
                }
                new_node.next = current.next;
                current.next = new_node;
            }

            return;
        }


        /*
         * Method removeElementsLT() - this method removes all nodes that contain a
         * value that is less than the provided parameter 'ltValue'.
         *
         * The method will invoke the method removeElements for each element
         * found in the linked-list that is less than thr parameter value passed.
         */
        public void removeElementsLT ( int ltValue ) {
            //while loop that runs as long as the head does not equal null and the head element is less than the input
            //it sets the head to the next node if the condition is true removing the head of the list. 
            while (head != null && head.data < ltValue) {
                head = head.next;
            }

            Node cursor = this.head; //cursor node created to keep trakc of the iteration of the list
            //while loop that goes through the list and searches fdor the nodes that are less than the input. 
            //if the node is found it is deleted by linking the previous node to the node after the node to be deleted.
            while(cursor != null && cursor.next != null) {
                cursor = cursor.next;
                if(cursor.next != null && cursor.next.data < ltValue) {
                    cursor.next = cursor.next.next;
                } else {
                    cursor = cursor.next;
                }

                }

            // YOUR CODE GOES HERE

            return;
        }


        /*
         * Method removeElement() - this method removes all nodes that contain a
         * value equal to the value the provided parameter 'value'.
         */

        public void removeElement ( int value ) {

            Node cursor = this.head;// node that keeps track of the iteration in the loop
            // while loop that iterates trhough the linkedlist 
            while(cursor != null) {
                //if statement that checks if the next node in the list is not null and if the data is equal to the input value
                //if the condition is true then it removes the element from the list. else it moves on to the next element 
                if(cursor.next != null && cursor.next.data == value) {
                    cursor.next = cursor.next.next;
                } else {
                    cursor = cursor.next;
                }
            }

            // YOUR CODE GOES HERE

            return;
        }


        /*
         * Method toString() - this is a helper method for printing / constructing
         * a string object from the linked-list.
         */
        public String toString () // Method to output the LinkedList as a String
        {
            String output = "[";
            Node currNode = this.head;
            while (currNode != null) {
                output += currNode.data + " ";
                currNode = currNode.next;
            }
            return output.trim() + "]";
        }

    } // End class LinkedList




    /*
     * Class Stacks
     *
     * This class utilizes the Java Common Framework Library Stack class.
     *
     * The intent of this class is to write methods which utilize the Java
     * library's Stack class. You need to utilize this library class in
     * your solution.
     *
     * Methods:
     *  - boolean isPalindrome(string)   - method returns true or false if 'string'
     *                                     is a palindrome
     *  - int     findlargestK(stack, k) - method accepts a stack and returns the
     *                                     the largest index in the stack containing
     *                                     value 'k' (stack index starts at 0)
     *
     */

    static class Stacks {

        /*
         * Method isPalindrome() - This method will return the boolean value 'true'
         * or 'false' on if the passed in parameter string is a palindrome or not.
         *
         * The routine should be case insensitive! Meaning 'RaCe cAr' is a palindrome.
         * Moreover, spaces are ignore, so both 'race car' and 'racecar' are plaindromes.
         *
         * The method should utilize the provided Stack class.
         */
        public static boolean isPalindrome(String input) {

            Stack<Character> stack = new Stack<>();
            input = input.toLowerCase().replaceAll("\\s+", "");

            //for loop that runs as long as the length of the input string provided. 
            //inside the loop each character from the is pushed on to the stack prvided.           
            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }
            //another for loop that runs as long as the length of the list 
            //it then pops each character of the string in a LIFO motion resulting in the string being read backwards
            //if statement is used with the ciondition comapring the first letters with the last letters of the string working towards the middle of the string
            //if each letter is equal to eachother the function will return true. if not then it will rteturn false. 
            for ( int i = 0; i < input.length(); i++) {
                if (stack.pop() != input.charAt(i)) {
                    return false;
                }
            }
            
            // Your CODE GOES HERE

        }


        /*
         * Method findLargestk() - This method will return the largest index
         * position in the stack for the value specified by the parameter 'k'.
         *
         * Note that the bottom of the stack is index location 0. So it you push
         * on to the stack the values 3 4 9 4 4 7 4, in that order. And you pass the
         * value '4' for the parameter k, then the largest index position is index
         * location 6.
         *
         * The method should utilize the provided Stack class. This method should NOT
         * destroy the passed in stack, meaning when the method returns, the passed in
         * stack should be identical to when this method is passed. One trick as you
         * pop elements off the passed in stack, place them in a temp stack. Then when
         * completed, place them all back in teh original stack.
         */
        public static int findLargestK(Stack<Integer> stack, int k) {

            int maxIndex = 0; //keeps track of the max index for the integer k
            int index = stack.size() -1; // keeps track of the current index 
            boolean found = false; //boolean created to keep trakc if the integer is already found

            //new stack created to keep the past stack the same and copy the stack back into the origianl stack
            Stack<Integer> newStack = new Stack<>();

            //while loop that runs as long as the original stack is not empty. 
            while(!stack.isEmpty()) {
                int num = stack.pop(); //keeps track of the integer that is poped off from the original stack.
                //if statement checks if the integer poped off is the same as the integer k and also if the 
                //found boolean is still false indicating that the integer has not already been found previously
                //if the condition is true it sets the max index to the current index and sets found to true 
                //so that if the sam enumber appears again it is not processed and the index is not updated
                if(num == k && !found) {
                    maxIndex = index; 
                    found = true;
                }

                newStack.push(num); //pushes the number into the new stack just to hold the integer while the other numbers are processed
                index--; // index is decreased by 1 
            }
            
            //while lloop is used to push the integers back onto the orginal stack that was being used and provided in the input
            while(!newStack.isEmpty()) {
                stack.push(newStack.pop());
                
            }

            return maxIndex;


            // YOUR CODE GOES HERE
        }

    }  // End class Stacks



    /*******************************
     *
     * Algorithm Analysis
     *
     * Below are two methods, algorithmAnalysis1 and algorithmAnalysis2.
     * Modify the return statement to return the correct option number.
     *
     *********************************/

    public static int algorithmAnalysis1(int n, int m) {
        int a = 0, b = 0;

        for (int i=0; i < n; i++)
            a+= Math.random();

        for (int j=0; j < m; j++)
            b+= Math.random();

        /*
         * Select the correct option listed below:
         *   1. O(N * M) time, O(1) space
         *   2. O(N + M) time, O(N + M) space
         *   3. O(N + M) time, O(1) space
         *   4. O(N * M) time, O(N + M) space
         *
         * TODO: return the answer (which option is correct), in the return statement
        */

        // RETURN THE CORRECT OPTION NUMBER LISTED ABOVE
        return 3;
    }


    public static int algorithmAnalysis2(int n) {
        int i, j, k = 0;
        for (i = n/2; i <= n; i++)
            for ( j = 2; j <= n; j = j*2 )
                k+= n/2;

        /*
         * Select the correct option listed below:
         *   1. O(N) time
         *   2. O(N log N) time
         *   3. O(N^2) time
         *   4. O(N^2Log n) time
         *
         * TODO: return the answer (which option is correct), in the return statement
         */

        // RETURN THE CORRECT OPTION LISTED ABOVE
        return 2;
    }

}

