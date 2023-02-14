package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.TblRecordDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblRecordMapper extends BaseMapper<TblRecordDAO> {

}