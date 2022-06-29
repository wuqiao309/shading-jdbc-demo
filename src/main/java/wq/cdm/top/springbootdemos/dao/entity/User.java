package wq.cdm.top.springbootdemos.dao.entity;

import javax.persistence.Id;

import lombok.Data;

/**
 * @author wuqiao <wuqiao@kuaishou.com>
 * Created on 2022-06-28
 */
@Data
public class User {
    @Id
    private Long uid;
    private String name;
    private Integer gender;
}
