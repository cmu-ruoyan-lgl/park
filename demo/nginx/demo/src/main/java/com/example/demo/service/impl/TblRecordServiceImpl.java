package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.demo.dao.TblRecordDAO;
import com.example.demo.mapper.TblRecordMapper;
import com.example.demo.service.TblRecordService;
@Service
public class TblRecordServiceImpl extends ServiceImpl<TblRecordMapper,TblRecordDAO> implements TblRecordService{

}
