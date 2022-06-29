package wq.cdm.top.springbootdemos.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import wq.cdm.top.springbootdemos.dao.entity.User;
import wq.cdm.top.springbootdemos.dao.entity.UserHistory;
import wq.cdm.top.springbootdemos.dao.mappers.UserHistoryMapper;
import wq.cdm.top.springbootdemos.dao.mappers.UserMapper;
import wq.cdm.top.springbootdemos.dao.model.GenderCount;

/**
 * @author wuqiao <wuqiao@kuaishou.com>
 * Created on 2022-06-28
 */
@Service
@Slf4j
public class TestService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserHistoryMapper userHistoryMapper;

    @PostConstruct
    public void init() {
        log.info("=====================================");
        List<Long> uids = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setGender(ThreadLocalRandom.current().nextInt(3));
            userMapper.insertUseGeneratedKeys(user);
            log.info("hash:{}, user:{}", user.getUid() % 4, user.toString());
            uids.add(user.getUid());
            for (int j = 0; j < 2; j++) {
                insertHistory(user);
            }
        }
        log.info("=====================================");
        uids.stream().collect(Collectors.groupingBy(e -> e % 4)).forEach((hash, shardUids) -> {
            List<UserHistory> histories = userMapper.selectUserHistorys(shardUids);
            histories.forEach(e -> {
                log.info("hash:{}, history:{}", e.getUid() % 4, e.toString());
            });

            List<GenderCount> genderCounts = userMapper.genderCount(shardUids);
            genderCounts.forEach(e -> {
                log.info("genderCount:{}", e.toString());
            });
            log.info("=====================================");
        });
    }

    private void insertHistory(User user) {
        UserHistory userHistory = new UserHistory();
        userHistory.setUid(user.getUid());
        userHistory.setVisitTime(new Date(System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(100000)));
        userHistoryMapper.insertSelective(userHistory);
    }
}
