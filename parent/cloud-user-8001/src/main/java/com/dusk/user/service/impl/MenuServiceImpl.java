package com.dusk.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dusk.user.domain.Menu;
import com.dusk.user.mapper.MenuMapper;
import com.dusk.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public Menu getMenuById(Integer id) {
        return menuMapper.getMenuById(id);
    }

    public List<Menu> getMenuListByLevelAndStatus(Integer level, Integer status) {
        return menuMapper.getMenuListByLevelAndStatus(level, status);
    }
}




