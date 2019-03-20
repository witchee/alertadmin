package com.example.demo.service;

import java.util.List;

public interface ISpecialService {

    public List getSpecialByUserid(Integer userid);

    public Integer addSpecial(Integer userid,String special_name);

    public Integer deleteSpecial(Integer userid,String special_name);
}
