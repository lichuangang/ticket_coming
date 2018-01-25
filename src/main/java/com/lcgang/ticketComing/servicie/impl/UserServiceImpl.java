package com.lcgang.ticketComing.servicie.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcgang.framework.dto.wx.Coordinate;
import com.lcgang.ticketComing.dtos.auth.SetLocationParam;
import com.lcgang.ticketComing.mapper.UsersMapper;
import com.lcgang.ticketComing.models.Users;
import com.lcgang.ticketComing.servicie.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void test() {
        Users u = new Users();
        u.setCreateTime(new Date());
        u.setOpenid("test1");
        u.setUpdateTime(new Date());
        usersMapper.insert(u);
    }

    @Override
    public void setUserLocation(SetLocationParam param) {
        Users u = usersMapper.selectByPrimaryKey(param.getOpenId());
        if (u == null) {
            u=new Users();
            u.setOpenid(param.getOpenId());
            u.setLatitude(param.getLatitude());
            u.setLongitude(param.getLongitude());
            u.setGeohash("xxxxxx");
            u.setCreateTime(new Date());
            u.setUpdateTime(new Date());
            usersMapper.insert(u);
        } else {
            u.setLatitude(param.getLatitude());
            u.setLongitude(param.getLongitude());
            //todo:生成geohash
            u.setGeohash("xxxxxx");
            u.setUpdateTime(new Date());
            usersMapper.updateByPrimaryKey(u);
        }
    }

    @Override
    public Coordinate getCoordinate(String openId) {
        Users u = usersMapper.selectByPrimaryKey(openId);
        if (u == null) {
            return null;
        }

        return new Coordinate(u.getLatitude(), u.getLongitude());
    }
}
