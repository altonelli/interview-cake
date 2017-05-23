public class FindMissingDrone {
    private static int findDrone (int[] drones) {
        int tracker = 0;
        for (int drone : drones) {
            tracker ^= drone;
        }
        return tracker;
    }

    public static void main(String[] args) {
        int[] drones = new int[]{2,5,4,3,8,7,5,6,9,2,5,4,3,8,5,6,9};

        int missingDrone = findDrone(drones);

        System.out.println(missingDrone);
    }
}