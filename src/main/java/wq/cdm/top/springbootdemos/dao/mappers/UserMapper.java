package wq.cdm.top.springbootdemos.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import wq.cdm.top.springbootdemos.dao.base.BaseMapper;
import wq.cdm.top.springbootdemos.dao.entity.User;
import wq.cdm.top.springbootdemos.dao.entity.UserHistory;
import wq.cdm.top.springbootdemos.dao.language_dirver.CollectionDriver;
import wq.cdm.top.springbootdemos.dao.model.GenderCount;

/**
 * @author wuqiao <wuqiao@kuaishou.com>
 * Created on 2022-06-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Lang(CollectionDriver.class)
    @Select({
            "select h.* from user u ",
            "left join user_history h on u.uid = h.uid ",
            "where u.uid in (#{uids})"
    })
    List<UserHistory> selectUserHistorys(List<Long> uids);

    @Lang(CollectionDriver.class)
    @Select({
            "select g.`desc` `genderDesc`,  count(*) `count` from `user` u ",
            "left join `gender` g on u.`gender` = g.`value` ",
            "where u.`uid` in (#{uids}) ",
            "group by g.`desc` "
    })
    List<GenderCount> genderCount(List<Long> uids);
}
