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
public class OverDueFine {
    @Autowired
    BorrowService borrowService;

    @Scheduled(cron = "0 0 0 * * ?")    // 每天对逾期的借阅惩罚
    public void checkIsOverDue() {
        List<BorrowInfo> borrowInfos = borrowService.searchAllBorrow();
        for (BorrowInfo borrowInfo : borrowInfos) {
            if (borrowInfo.getIsOverDue().equals("已逾期")) {
                borrowInfo.setOverDueFine(borrowInfo.getOverDueFine() + 0.5);
                borrowService.updateBorrow(borrowInfo);
            }
        }
    }
}