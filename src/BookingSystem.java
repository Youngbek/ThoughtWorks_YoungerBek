import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/9/11.
 */
public class BookingSystem {
    private String bookingNum;
    private HashMap<Date,String> bookingInfo;


    public boolean bookingInfoCheck(String bookingInfo){
        String[] infoArray=bookingInfo.split(" ");
        Date beforeTime;
        Date behindTime;
        Date firstTime;
        Date lastTime;
        HashMap<String,String> bookingNumHp=new HashMap<>();
        if(infoArray.length>=4){
            try {
                String date_str =infoArray[1];
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                Date date = dateFormat.parse(date_str);

            } catch (Exception ex){
                System.out.println("Error: the booking is invalid!");
                return false;
            }
            if(!"A".equals(infoArray[3])&&!"B".equals(infoArray[3])&&!"C".equals(infoArray[3])&&!"D".equals(infoArray[3])){
                System.out.println("Error: the booking is invalid!");
                return false;
            }
            String[] time=infoArray[2].split("~");
            SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");

            try{
                beforeTime=timeFormat.parse(time[0]);
                behindTime=timeFormat.parse(time[1]);
                firstTime=timeFormat.parse("9:00");
                lastTime=timeFormat.parse("22:00");
                if(beforeTime.before(firstTime)||beforeTime.after(lastTime)||
                        behindTime.before(firstTime)||behindTime.after(lastTime)
                        ||beforeTime.equals(behindTime)){
                    System.out.println("Error: the booking is invalid!");
                    return false;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(infoArray.length==5&&!"C".equals(infoArray[4])){
                System.out.println("Error: the booking is invalid!");
                return false;
            }
            System.out.println("Success: the booking is accepted!");
            return true;
        }else{
            System.out.println("Error: the booking is invalid!");
            return false;
        }

    }


    /**
     * 根据Date型的日期参数，并判断是否是周末
     * @param date yyyy-MM-dd 格式的 Date 类日期
     * @return 如果是周末，就返回1，如果是周一到周五，就返回0；
     */
    public  static int getWeekOfDate(Date date){
        ArrayList<String> weekend=new ArrayList<String>();
        weekend.add("星期六");
        weekend.add("星期日");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        if(weekend.contains(week)){
            return 1;
        }else return 0;

    }


    public static void main(String[] args) throws Exception{
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        new BookingSystem().bookingInfoCheck(str);
    }
}
