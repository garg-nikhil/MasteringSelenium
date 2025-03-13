package Pages.com.java.nikhil.flightReservation;

import java.util.*;

public class Solution {
    static class DisjointSet {
        private Map<String, String> parent;

        public DisjointSet() {
            parent = new HashMap<>();
        }

        public String find(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
            }
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x))); // Path compression
            }
            return parent.get(x);
        }

        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY); // Merge clusters
            }
        }

        public int getNumberOfClusters() {
            Set<String> clusters = new HashSet<>();
            for (String node : parent.keySet()) {
                clusters.add(find(node)); // Find root representative
            }
            return clusters.size();
        }
    }

    public static int numDevices(int[][] locCord) {
        DisjointSet ds = new DisjointSet();

        for (int i = 0; i < locCord.length; i++) {
            String point1 = locCord[i][0] + "," + locCord[i][1];
            String point2 = locCord[i][2] + "," + locCord[i][3];

            ds.union(point1, point2); // Merge both locations
        }

        return ds.getNumberOfClusters(); // Count unique connected components
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int locCord_row = in.nextInt();
        int locCord_col = in.nextInt();
        int[][] locCord = new int[locCord_row][locCord_col];

        for (int i = 0; i < locCord_row; i++) {
            for (int j = 0; j < locCord_col; j++) {
                locCord[i][j] = in.nextInt();
            }
        }

        int result = numDevices(locCord);
        System.out.println(result);

        in.close();
    }
}

