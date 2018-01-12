package org.artsicleprojects.textadventure;

import org.artsicleprojects.ArtUtils.ArtUtils;

public class Time {
    public Integer MINUTES = 0;
    public Integer HOURS = 0;
    public Integer SECONDS = 0;
    public void addTime(Integer seconds, Integer minutes, Integer hours) {
        MINUTES += minutes;
        HOURS += hours;
        SECONDS += seconds;
        saveTime();
    }
    public void saveTime() {
        if(MINUTES > 60) {
            HOURS++;
            MINUTES = 1;
        }
        if(HOURS > 23) {
            HOURS = 0;
        }
        if(SECONDS > 60) {
            SECONDS = 0;
            MINUTES++;
        }
    }
    public void addTime(Time time) {
        MINUTES += time.MINUTES;
        HOURS += time.HOURS;
        SECONDS += time.SECONDS;
        ArtUtils.println(MINUTES + " " + time.MINUTES);
        saveTime();
    }
    public Time(Integer seconds, Integer minutes, Integer hours) {
        SECONDS = seconds;
        MINUTES = minutes;
        HOURS = hours;
        saveTime();
    }

    @Override
    public String toString() {
        String hour = HOURS.toString();
        String minute = MINUTES.toString();
        String second = SECONDS.toString();
        if(hour.length() == 1) {
            hour = "0" + hour;
        }
        if(minute.length() == 1) {
            minute = "0" + minute;
        }
        if(second.length() == 1) {
            second = "0" + second;
        }
        return hour + ":" + minute + "." + second;
    }
}
