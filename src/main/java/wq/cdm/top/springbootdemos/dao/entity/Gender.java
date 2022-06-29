package wq.cdm.top.springbootdemos.dao.entity;

import javax.persistence.Id;

import lombok.Data;

/**
 * @author wuqiao
 * Created on 2022-06-29
 */
@Data
public class Gender {
    @Id
    private Long id;
    private Integer value;
    private String desc;
}
