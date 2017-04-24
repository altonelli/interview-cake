import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;


public class MergeMeetingTimes {

    public static class Meeting implements Comparable<Meeting> {

      int startTime;
      int endTime;

      public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
      }

      public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
      }

      @Override
      public int compareTo (Meeting other) {
        if (this.startTime - other.startTime != 0) {
          return this.startTime - other.startTime;
        }
        return this.endTime - other.endTime;
      }
    }

    public static Meeting[] mergeRanges (Meeting[] meetings) {
        ArrayList<Meeting> oldMeetingList = new ArrayList<Meeting>(Arrays.asList(meetings));
        Collections.sort(oldMeetingList);

        int rollingStart = oldMeetingList.get(0).startTime;
        int rollingFinish = oldMeetingList.get(0).endTime;
        ArrayList<Meeting> newMeetingList = new ArrayList<Meeting>();

        for (int i = 1; i < oldMeetingList.size(); i++) {
            Meeting meeting = oldMeetingList.get(i);
            if (meeting.startTime >= rollingStart && meeting.startTime > rollingFinish) {
                Meeting newMeeting = new Meeting(rollingStart, rollingFinish);
                newMeetingList.add(newMeeting);
                rollingStart = meeting.startTime;
                rollingFinish = meeting.endTime;
            } else if (meeting.startTime >= rollingStart && meeting.endTime > rollingFinish) {
                rollingFinish = meeting.endTime;
            }
        }

        newMeetingList.add(new Meeting(rollingStart,rollingFinish));

        return newMeetingList.toArray(new Meeting[newMeetingList.size()]);
    }

    public static void main(String[] args) {
        System.out.println("Main Test Case");
        Meeting[] input = new Meeting[]{new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};
        Meeting[] output = mergeRanges(input);

        for (Meeting meeting : output) {
            System.out.println(meeting.toString());
        }

        System.out.println("Gotcha");
        Meeting[] input1 = new Meeting[]{new Meeting(1, 2), new Meeting(2, 3)};
        Meeting[] output1 = mergeRanges(input1);

        for (Meeting meeting : output1) {
            System.out.println(meeting.toString());
        }

        System.out.println("Gotcha Again");
        Meeting[] input2 = new Meeting[]{new Meeting(1, 5), new Meeting(2, 3)};
        Meeting[] output2 = mergeRanges(input2);

        for (Meeting meeting : output2) {
            System.out.println(meeting.toString());
        }


        System.out.println("Final Gotcha");
        Meeting[] input3 = new Meeting[]{new Meeting(1, 10), new Meeting(2, 6), new Meeting(3, 5), new Meeting(7, 9)};
        Meeting[] output3 = mergeRanges(input3);

        for (Meeting meeting : output3) {
            System.out.println(meeting.toString());
        }
    }
}