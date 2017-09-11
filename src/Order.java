import java.util.Date;

/**
 * Created by Administrator on 2017/9/11.
 */
public class Order {
    private int userId;
    private Date bookingDate;
    private String bookingNum;

    public Order() {
    }

    public Order(int userId, Date bookingDate, String bookingNum) {
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.bookingNum = bookingNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }
}
