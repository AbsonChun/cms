package com.dusk.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dusk.user.domain.Menu;

import java.util.List;

/**
 *
 */
public interface MenuService extends IService<Menu> {

    public Menu getMenuById(Integer id);

    public List<Menu> getMenuListByLevelAndStatus(Integer level, Integer status);
}
