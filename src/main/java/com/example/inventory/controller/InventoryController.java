package com.example.inventory.controller;

import com.example.inventory.domain.ExportInfo;
import com.example.inventory.util.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    @RequestMapping("excel")
    public void exportExcel(HttpServletResponse response) {
        List<ExportInfo> list = getList();
        String fileName = "一个 Excel 文件";
        String sheetName = "第一个 sheet";
        ExcelUtil.writeExcel(response, list, fileName, sheetName, new ExportInfo());
    }

    private List<ExportInfo> getList() {
        List<ExportInfo> exportInfos = new ArrayList<>();
        ExportInfo info = new ExportInfo();
        info.setAddress("asd");
        info.setAge(String.valueOf(18));
        info.setName("asdasd");
        exportInfos.add(info);
        return exportInfos;
    }
}
