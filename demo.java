import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;
import java.lang.Thread;

public class demo {

    private static Logger log = LogManager.getLogger();
    public static void main(String[] args){
       Date time1 = new Date();
       long time11 = time1.getTime();
       try {
           for (int i = 1; i <= 100; i++) {
               log.fatal("Fatal Display" + i);
               Thread.sleep(1);
           }
       }catch(InterruptedException e){
           e.printStackTrace();
        }
        Date time2 = new Date();
        long time21 = time2.getTime();
        System.out.println("运行时间"+(time21-time11)+"ms");
    }
}
