package wq.cdm.top.springbootdemos.dao.mappers;

import org.apache.ibatis.annotations.Mapper;

import wq.cdm.top.springbootdemos.dao.base.BaseMapper;
import wq.cdm.top.springbootdemos.dao.entity.UserHistory;

/**
 * @author wuqiao <wuqiao@kuaishou.com>
 * Created on 2022-06-28
 */
@Mapper
public interface UserHistoryMapper extends BaseMapper<UserHistory> {
}
