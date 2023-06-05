package com.core.tools.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class DmpInventoryDetailDto {
    private String Id;
    private String VersionCode;
    private String BillCodeValue;
    private String BillName;
    private String Unit;
    private String ParentCode;
    private String ChapterCode;
    private String IsLeaf;
    private String IsChapter;
    private String Remark;
    private String SortNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime CreateTime;
    private String CreateCnName;
    private String CreateAccount;
    private List<DmpInventoryDetailDto> children;
    private Map<DmpInventoryDetailDto, List<Field>> detailDtoListMap;
    private String CreateRemark;
}