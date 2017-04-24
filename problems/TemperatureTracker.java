

public class TemperatureTracker {

    public class TempTracker {
        private int max;
        private int min;
        private int mean;
        private int[] counts;
        private int count;

        public TempTracker(){
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;

            this.mean = Integer.MIN_VALUE;
            this.count = 0;

            this.mode = Integer.MIN_VALUE;
            this.modeCount = 0;

            this.counts = new int[111];
            Arrays.fill(this.counts,0);
        }

        public TempTracker(int temp){
            this.max = temp;
            this.min = temp;

            this.mean = temp;
            this.count++;

            this.mode = temp;
            this.modeCount = 1;

            this.counts = new int[111];
            Arrays.fill(this.counts,0);
            this.counts[temp]++;
        }

        public void insert(int newTemp) {
            if (newTemp > this.max) {
                this.max = newTemp;
            }
            if (newTemp < this.min) {
                this.min = newTemp;
            }
            this.mean = ((mean * count) + newTemp) / count++;
            this.count[newTemp]++;

            if (count[newTemp] > modeCount) {
                this.mode =  newTemp;
                modeCount = count[newTemp];
            }

        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }

        public int getMean() {
            return mean;
        }

        public int getMode() {
            return mode;
        }

    }


    public static void main(String[] args) {

    }
}