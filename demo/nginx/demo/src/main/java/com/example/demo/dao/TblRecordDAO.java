package com.example.demo.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_record")
public class TblRecordDAO {
    private Integer id;

    private Integer carId;

    private Integer inOut;

    private Date startTime;

    private Date entTime;
}