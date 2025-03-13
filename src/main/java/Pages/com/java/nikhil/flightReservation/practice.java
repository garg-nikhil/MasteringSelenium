package Pages.com.java.nikhil.flightReservation;
import java.util.Scanner;

public class practice {


        public static int[] interchange(int[] arr) {
            int n = arr.length;
            int[] answer = new int[n]; // Ensuring correct size

            for (int i = 0; i < n; i++) {
                answer[arr[i]] = i;  // Correctly mapping value to index
            }

            return answer;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            // Read the size of the array
            int arr_size = in.nextInt();
            int[] arr = new int[arr_size];

            // Read the array elements
            for (int i = 0; i < arr_size; i++) {
                arr[i] = in.nextInt();
            }

            // Process the interchange
            int[] result = interchange(arr);

            // Print the result correctly without extra spaces
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            in.close();
        }
    }


