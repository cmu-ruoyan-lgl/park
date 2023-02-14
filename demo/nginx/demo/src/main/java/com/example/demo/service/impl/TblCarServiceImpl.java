package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.TblRecordDAO;
import com.example.demo.dao.TblRecordVO;
import com.example.demo.mapper.TblRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.annotation.Resource;

import com.example.demo.dao.TblCarDAO;
import com.example.demo.mapper.TblCarMapper;
import com.example.demo.service.TblCarService;

import java.util.Date;
import java.util.List;

@Service
public class TblCarServiceImpl extends ServiceImpl<TblCarMapper, TblCarDAO> implements TblCarService {

    @Autowired
    TblRecordMapper tblRecordMapper;

    Integer io_way;

    @Override
    public String addRecord(TblCarDAO tblCarDAO) throws RuntimeException {
        TblCarDAO oldRecord = baseMapper.selectOne(Wrappers.<TblCarDAO>lambdaQuery().eq(TblCarDAO::getCarNum, tblCarDAO.getCarNum()));
        if (oldRecord != null) {
            TblRecordDAO recordDAO = tblRecordMapper.selectOne(Wrappers.<TblRecordDAO>lambdaQuery().eq(TblRecordDAO::getCarId, oldRecord.getId()));
            if (recordDAO != null) {
                if (tblCarDAO.getInOut() == 1) {
                    if (recordDAO.getInOut() == 1||recordDAO.getInOut() == 2||recordDAO.getInOut() == 3||recordDAO.getInOut() == 4) {
                        return "当前车辆已入闸";
                    }
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(1).build();
                    tblRecordMapper.insert(build);
                    return "success";
                } else if (tblCarDAO.getInOut() == 2) {
                    if (recordDAO.getInOut() == 1||recordDAO.getInOut() == 2||recordDAO.getInOut() == 3||recordDAO.getInOut() == 4) {
                        return "当前车辆已入闸";
                    }
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(2).build();
                    tblRecordMapper.insert(build);
                    return "success";
                } else if (tblCarDAO.getInOut() == 3) {
                    if (recordDAO.getInOut() == 1||recordDAO.getInOut() == 2||recordDAO.getInOut() == 3||recordDAO.getInOut() == 4) {
                        return "当前车辆已入闸";
                    }
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(3).build();
                    tblRecordMapper.insert(build);
                    return "success";
                } else if (tblCarDAO.getInOut() == 4) {
                    if (recordDAO.getInOut() == 1||recordDAO.getInOut() == 2||recordDAO.getInOut() == 3||recordDAO.getInOut() == 4) {
                        return "当前车辆已入闸";
                    }
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(4).build();
                    tblRecordMapper.insert(build);
                    return "success";
                } else {
                    if (recordDAO.getInOut() == 0) {
                        return "当前车辆已出闸";
                    }
                    io_way = recordDAO.getInOut();
                    recordDAO.setInOut(0);
                    recordDAO.setEntTime(new Date());
                    tblRecordMapper.updateById(recordDAO);
                    return recordDAO.getId().toString();
                }
            } else {
                if (tblCarDAO.getInOut() == 0) {
                    return "当前车辆未入闸";
                } else if(tblCarDAO.getInOut() == 1){
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(1).build();
                    tblRecordMapper.insert(build);
                    return "success";
                } else if(tblCarDAO.getInOut() == 2){
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(2).build();
                    tblRecordMapper.insert(build);
                    return "success";
                } else if(tblCarDAO.getInOut() == 3){
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(3).build();
                    tblRecordMapper.insert(build);
                    return "success";
                } else {
                    TblRecordDAO build = TblRecordDAO.builder().carId(oldRecord.getId()).startTime(new Date()).inOut(4).build();
                    tblRecordMapper.insert(build);
                    return "success";
                }
            }
        } else {
            if (tblCarDAO.getInOut() == 0) {
                return "当前车辆未入闸";
            } else if(tblCarDAO.getInOut() == 1){
                TblCarDAO build = TblCarDAO.builder().carName(tblCarDAO.getCarName()).carNum(tblCarDAO.getCarNum()).build();
                baseMapper.insert(build);
                TblRecordDAO recordDAO = TblRecordDAO.builder().carId(build.getId()).startTime(new Date()).inOut(1).build();
                tblRecordMapper.insert(recordDAO);
                return "success";
            } else if(tblCarDAO.getInOut() == 2){
                TblCarDAO build = TblCarDAO.builder().carName(tblCarDAO.getCarName()).carNum(tblCarDAO.getCarNum()).build();
                baseMapper.insert(build);
                TblRecordDAO recordDAO = TblRecordDAO.builder().carId(build.getId()).startTime(new Date()).inOut(2).build();
                tblRecordMapper.insert(recordDAO);
                return "success";
            } else if(tblCarDAO.getInOut() == 3){
                TblCarDAO build = TblCarDAO.builder().carName(tblCarDAO.getCarName()).carNum(tblCarDAO.getCarNum()).build();
                baseMapper.insert(build);
                TblRecordDAO recordDAO = TblRecordDAO.builder().carId(build.getId()).startTime(new Date()).inOut(3).build();
                tblRecordMapper.insert(recordDAO);
                return "success";
            } else {
                TblCarDAO build = TblCarDAO.builder().carName(tblCarDAO.getCarName()).carNum(tblCarDAO.getCarNum()).build();
                baseMapper.insert(build);
                TblRecordDAO recordDAO = TblRecordDAO.builder().carId(build.getId()).startTime(new Date()).inOut(4).build();
                tblRecordMapper.insert(recordDAO);
                return "success";
            }
        }
    }

    @Override
    public List<TblRecordVO> getRecords() {
        List<TblRecordVO> records = baseMapper.getRecords();
        if (CollectionUtils.isNotEmpty(records)) {
            records.stream().forEach(p -> {
                if (p.getInOutNum() == 0) {
                    p.setInOut("出闸");
                } else if(p.getInOutNum() == 1){
                    p.setInOut("按次入闸");
                } else if(p.getInOutNum() == 2){
                    p.setInOut("按小时入闸");
                } else if(p.getInOutNum() == 3){
                    p.setInOut("按时间段入闸");
                } else {
                    p.setInOut("按阶梯入闸");
                }
            });
        }
        return records;
    }

    @Override
    public TblRecordVO getRecordById(Long id) {
        TblRecordVO recordById = baseMapper.getRecordById(id);
        if (recordById.getInOutNum() == 0) {
            recordById.setInOut("出闸");
            long timeMills = recordById.getOutTime().getTime() - recordById.getInTime().getTime();
            recordById.setTime(String.valueOf(Math.ceil((float) timeMills / (1000 * 60 * 60))));
            if(io_way == 1){
                recordById.setIo(20);
            } else if (io_way == 2){
                int ans = (int)Math.ceil((float) timeMills / (1000 * 60 * 60)) * 10;
                recordById.setIo(ans);
            } else if (io_way == 3){
                Calendar calendar = Calendar.getInstance();

                Calendar a = Calendar.getInstance();
                a.set(Calendar.HOUR_OF_DAY, 12); //设置自己今天想得到的点数
                a.set(Calendar.MINUTE, 0);
                a.set(Calendar.SECOND, 0);

                Calendar b = Calendar.getInstance();
                b.set(Calendar.HOUR_OF_DAY, 18); //设置自己今天想得到的点数
                b.set(Calendar.MINUTE, 0);
                b.set(Calendar.SECOND, 0);

                long num_a = a.getTimeInMillis();
                long num_b = b.getTimeInMillis();
                long num_begin = recordById.getInTime().getTime();
                long num_end = recordById.getOutTime().getTime();

                int ans = 0;
                if(num_begin <= num_a) ans += 15;
                if(num_end >= num_a) ans += 20;
                recordById.setIo(ans);
            } else {
                int tim = (int)Math.ceil((float) timeMills / (1000 * 60 * 60));
                int ans = 0;
                if(tim<=1) ans = 15 * tim;
                else if(tim<=3) ans = 15 * 1 + 10 * (tim - 1);
                else ans = 15 * 1 + 10 * 2 + 5 * (tim - 3);
                recordById.setIo(ans);
            }
        }else if(recordById.getInOutNum() == 1){
            recordById.setInOut("按次入闸");
        }else if(recordById.getInOutNum() == 2){
            recordById.setInOut("按小时入闸");
        }else if(recordById.getInOutNum() == 3){
            recordById.setInOut("按时间段入闸");
        }else {
            recordById.setInOut("按阶梯入闸");
        }
        return recordById;
    }
}
