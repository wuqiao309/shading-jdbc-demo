package wq.cdm.top.springbootdemos.dao.base;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wuqiao <wuqiao@kuaishou.com>
 * Created on 2022-06-28
 */
public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, IdsMapper<T>, MySqlMapper<T> {
}
