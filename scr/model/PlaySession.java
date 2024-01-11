package model;
import controler.Alertable;

import java.util.concurrent.TimeUnit;

public class PlaySession implements Alertable {
    private long startTime;
    private long endTime;
    private Bow bow;
    private Customer customer;
    public static final int FIRST_HOUR_PRICE = 150000;
    public static final int SECOND_HOUR_PRICE = 100000;
    public static final int THIRD_HOUR_PRICE = 50000;
    public static final int THRESHOLD = 30;

    public PlaySession() {
    }

    public PlaySession(Bow bow, Customer customer) {
        this.bow = bow;
        this.customer = customer;
    }

    public PlaySession(Bow bow) {
        this.bow = bow;
    }
    public void startSession() {
        if (this.startTime != 0L) {
            alert("Session already start!");
            return;
        }
        this.startTime = System.currentTimeMillis();
        alert("Start playing");
    }
    public void endSesstion() {
        this.endTime = System.currentTimeMillis();
        alert("End playing");
    }
    public int getPrice() {
        long playTime = endTime - startTime;
        int playMinute = (int)TimeUnit.MICROSECONDS.toMinutes(playTime);
        int playHour = (int) playMinute / 60;
        int oddMinute = playMinute % 60;
        if (playHour < 1) {
            return FIRST_HOUR_PRICE + bow.getPrice();
        } else if (playHour < 2) {
            if (oddMinute < THRESHOLD) {
                return FIRST_HOUR_PRICE + bow.getPrice();
            }
            return FIRST_HOUR_PRICE + SECOND_HOUR_PRICE + bow.getPrice();
        } else if (playHour < 3) {
            if (oddMinute < THRESHOLD) {
                return FIRST_HOUR_PRICE + SECOND_HOUR_PRICE + bow.getPrice();
            }
            return FIRST_HOUR_PRICE + SECOND_HOUR_PRICE + THIRD_HOUR_PRICE + bow.getPrice();
        } else
        if (oddMinute < THRESHOLD) {
            return FIRST_HOUR_PRICE + SECOND_HOUR_PRICE + THIRD_HOUR_PRICE * (playHour - 2) + bow.getPrice();
        }
        return FIRST_HOUR_PRICE + SECOND_HOUR_PRICE + THIRD_HOUR_PRICE * (playHour - 1) + bow.getPrice();
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Bow getBow() {
        return bow;
    }

    public void setBow(Bow bow) {
        this.bow = bow;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void alert(String mess) {
        System.out.println(mess);
    }

    @Override
    public String toString() {
        return "PlaySession{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", bow=" + bow +
                ", customer=" + customer +
                '}';
    }
}
