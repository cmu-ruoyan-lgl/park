package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.TblCarDAO;
import com.example.demo.dao.TblRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TblCarMapper extends BaseMapper<TblCarDAO> {
    List<TblRecordVO> getRecords();

    TblRecordVO getRecordById(@Param("id") Long id);
}