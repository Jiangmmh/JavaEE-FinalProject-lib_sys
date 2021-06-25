package task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pojo.BorrowInfo;
import service.BorrowService;

import javax.ejb.Schedule;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class CheckIsOverDue {
    @Autowired
    BorrowService borrowService;

    @Scheduled(cron = "0 0 * * * ?")    // 每分钟执行一次逾期检查
    public void checkIsOverDue() {
        List<BorrowInfo> borrowInfos = borrowService.searchAllBorrow();
        Date date = new Date();
        Timestamp curDate = new Timestamp(date.getTime());

        for (BorrowInfo borrowInfo : borrowInfos) {
            if (borrowInfo.getIsOverDue().equals("未逾期")) {
                long remDay = (borrowInfo.getReturnDate().getTime() - curDate.getTime()) / (1000*60);
                if (remDay < 1) {
                    borrowInfo.setIsOverDue("已逾期");
                    borrowService.updateBorrow(borrowInfo);
                }
            }
        }
    }
}
