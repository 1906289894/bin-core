package com.core.tools.entity;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.*;
import java.util.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

/**
 * <p>
 *
 * </p>
 *
 * @author wb
 * @since 2022-11-29
 */
@Getter
@Setter
@EqualsAndHashCode
@TableName("city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 城市id
     */
    @TableField("city_id")
    private Integer cityId;

    /**
     * 父类id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 城市编码
     */
    @TableField("city_code")
    private String cityCode;

    /**
     * 城市名称
     */
    @TableField("city")
    private String city;

    public City(Integer id, String cityCode) {
        this.id = id;
        this.cityCode = cityCode;
    }

    public City() {
    }

    public static void main(String[] args) {
    }

    public static Date getFirstDate(int oneYear) {
        LocalDate firstDay = LocalDate.of(oneYear, Month.APRIL, 1).with(firstDayOfYear());
        return Date.from(firstDay.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getLastDate(int oneYear) {
        LocalDate lastDay = LocalDate.of(oneYear, Month.APRIL, 1).with(lastDayOfYear());
        return Date.from(lastDay.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
