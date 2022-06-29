package wq.cdm.top.springbootdemos.dao.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import wq.cdm.top.springbootdemos.dao.base.BaseMapper;
import wq.cdm.top.springbootdemos.dao.entity.User;
import wq.cdm.top.springbootdemos.dao.entity.UserHistory;
import wq.cdm.top.springbootdemos.dao.language_dirver.CollectionDriver;

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
            "where u.uid = #{uid}"
    })
    List<UserHistory> selectUserHistorys(Long uid);
}
