package wq.cdm.top.springbootdemos.dao.entity;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

/**
 * @author wuqiao <wuqiao@kuaishou.com>
 * Created on 2022-06-28
 */
@Data
public class UserHistory {
    @Id
    private Long id;
    private Long uid;
    private Date visitTime;
}
