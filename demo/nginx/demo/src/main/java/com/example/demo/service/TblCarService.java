package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dao.TblCarDAO;
import com.example.demo.dao.TblRecordVO;

import java.util.List;

public interface TblCarService extends IService<TblCarDAO> {
    String addRecord(TblCarDAO tblCarDAO) throws RuntimeException;

    List<TblRecordVO> getRecords();

    TblRecordVO getRecordById(Long id);
}
