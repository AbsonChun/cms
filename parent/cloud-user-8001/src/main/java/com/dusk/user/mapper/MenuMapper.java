package com.dusk.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dusk.user.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity generator..Menu
 */
public interface MenuMapper extends BaseMapper<Menu> {

    Menu getMenuById(Integer id);

    List<Menu> getMenuListByLevelAndStatus(@Param("level") Integer level, @Param("status") Integer status);

}




