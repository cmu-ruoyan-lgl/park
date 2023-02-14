package com.example.demo.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_car")
public class TblCarDAO {
    @TableField("id")
    private Integer id;

    /**
    * 车牌号
    */
    @TableField("car_num")
    private String carNum;

    /**
    * 车名字
    */
    @TableField("car_name")
    private String carName;

    /**
     * 出入
     */
    @TableField(exist = false)
    private Integer inOut;

}