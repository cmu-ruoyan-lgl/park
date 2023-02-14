package com.example.demo.controller;

import com.example.demo.dao.Result;

import com.example.demo.dao.TblCarDAO;
import com.example.demo.dao.TblRecordVO;
import com.example.demo.service.TblCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    TblCarService tblCarService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public Result test(@RequestBody TblCarDAO tblCarDAO) throws RuntimeException {
        String s = tblCarService.addRecord(tblCarDAO);
        return Result.ok(s);
    }

    @GetMapping("/records")
    public Result getRecord(){
        List<TblRecordVO> records = tblCarService.getRecords();
        return Result.ok("success",records);
    }

    @GetMapping("/{id}")
    public Result getRecordById(@PathVariable("id") Long id){
        return Result.ok("success",tblCarService.getRecordById(id));
    }

}
