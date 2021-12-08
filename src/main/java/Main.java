import java.util.*;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {

    private Integer startTime;
    private Integer endTime;
    private Integer meetingMinutes;
    private Integer schedule2Pointer = 0;

    public String testMethod() {
        return "method";
    }

    public List<String> getPossibleScheduleTimes(List<List<String>> schedules, List<String> bounds, String meetingLength) {
        var complementaryTimeBlocks = new ArrayList<String>();

        var schedule1 = schedules.get(0);
        var schedule2 = schedules.get(1);

        var schedule1Free = new ArrayList<TimeRange>();
        var schedule2Free = new ArrayList<TimeRange>();

        var originalStartTime = this.translateToMinutes(bounds.get(0));
        this.startTime = this.translateToMinutes(bounds.get(0));
        this.endTime = this.translateToMinutes(bounds.get(1));
        this.meetingMinutes = this.translateToMinutes(meetingLength);

        if (schedule1.size() > schedule2.size()) {
            // traverse the smaller schedule first
            var temp = schedule2;
            schedule2 = schedule1;
            schedule1 = temp;
        }

        for (var i = 0; i < schedule1.size(); i++) {
            var time = schedule1.get(i);
            var timeRange = this.parseTimeRange(time);
            var lastTimeBlockerToThisMeeting = (timeRange.startTime - startTime);
            var hasFreeSpace = lastTimeBlockerToThisMeeting >= meetingMinutes;

            if (hasFreeSpace) {
                schedule1Free.add(new TimeRange(startTime, timeRange.startTime));
            }
            startTime = timeRange.endTime;

            if (i == schedule1.size()-1) {
                if((endTime - timeRange.endTime) >= meetingMinutes ) {
                    schedule1Free.add(new TimeRange(timeRange.endTime, endTime));
                }
            }
        }

        startTime = originalStartTime;

        for (var i = 0; i < schedule2.size(); i++) {
            var time = schedule2.get(i);
            var timeRange = this.parseTimeRange(time);
            var lastTimeBlockerToThisMeeting = (timeRange.startTime - startTime);
            var hasFreeSpace = lastTimeBlockerToThisMeeting >= meetingMinutes;

            if (hasFreeSpace) {
                schedule2Free.add(new TimeRange(startTime, timeRange.startTime));
            }
            startTime = timeRange.endTime;

            if (i == schedule2.size()-1) {
                if((endTime - timeRange.endTime) >= meetingMinutes ) {
                    schedule2Free.add(new TimeRange(timeRange.endTime, endTime));
                }
            }
        }

        for (var free1: schedule1Free) {
            for (var free2: schedule2Free) {
                var isFree2WraparoundFree1 = free1.startTime >= free2.startTime && free1.endTime <= free2.endTime;
                var isFree2InnerBlockOfFree1 = free1.startTime <= free2.startTime && free1.endTime >= free2.endTime;
                var isFree2AtStartOfFree1 = free1.startTime >= free2.startTime && free2.endTime <= free1.endTime;
                var isFree2AtTheEndOfFree1 = free1.startTime <= free2.startTime && free2.endTime >= free1.endTime;
                if (isFree2WraparoundFree1) {
                    complementaryTimeBlocks.add(free1.toTimeString());
                } else if (isFree2InnerBlockOfFree1) {
                    if ((free2.endTime - free2.startTime) >=meetingMinutes) {
                        complementaryTimeBlocks.add(free2.toTimeString());
                    }
                } else if (isFree2AtStartOfFree1) {
                    if ((free2.endTime - free1.startTime) >= meetingMinutes) {
                        complementaryTimeBlocks.add(new TimeRange(free1.startTime, free2.endTime).toTimeString());
                    }
                } else if (isFree2AtTheEndOfFree1) {
                    if ((free1.endTime - free2.startTime) >= meetingMinutes) {
                        complementaryTimeBlocks.add(new TimeRange(free2.startTime, free1.endTime).toTimeString());
                    }
                }
            }
        }

        return complementaryTimeBlocks;
    }

    private TimeRange parseTimeRange(String time) {
        var rangeSplit = time.split("-");
        var startTime = this.translateToMinutes(rangeSplit[0]);
        var endTime = this.translateToMinutes(rangeSplit[1]);
        return new TimeRange(startTime, endTime);
    }

    private Integer translateToMinutes(String time) {
        var hoursAndMinutes = time.split(":");
        var hours = Integer.parseInt(hoursAndMinutes[0]);
        var minutes = Integer.parseInt(hoursAndMinutes[1]);

        return hours*60 + minutes;
    }
}

class TimeRange {
    public Integer startTime;
    public Integer endTime;

    public TimeRange(Integer s, Integer e) {
        this.startTime = s;
        this.endTime = e;
    }

    public String toTimeString() {
        return this.timeIntegerToMilitaryTime(this.startTime) + "-"+ this.timeIntegerToMilitaryTime(this.endTime);
    }

    private String timeIntegerToMilitaryTime(Integer time) {
        var hours = time / 60;
        var minutes = time % 60;

        var hourString = hours == 0 ? "00" : hours + "";
        var minuteString = minutes == 0 ? "00": minutes + "";
        return hourString+":"+minuteString;
    }
}
