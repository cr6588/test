package com.cheny.test.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cheny.web.bean.Order;

@Controller
public class TestAction {

//    @Autowired
//    private UserService userService;
 
    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response){
        // 1.创建一个 workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        // 2.创建一个 worksheet
        HSSFSheet worksheet = workbook.createSheet("test");
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = worksheet.createRow((short)0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);
        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string你确定"));
        row.createCell(3).setCellValue(true);
        row = worksheet.createRow((short)1);
        Cell cell1 = row.createCell(0);
        cell1.setCellValue(1);
        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string阿朵司法所地方"));
        row.createCell(3).setCellValue(true);
        String fileName = "t1";
        try {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-Disposition", "inline; filename=" + fileName + ".xls");
        // 确保发送的当前文本格式
        response.setContentType("application/vnd.ms-excel");

        // 7. 输出流
        TestAction.write(response, worksheet);
    }
    private static void write(HttpServletResponse response, HSSFSheet worksheet) {

        try {
            // Retrieve the output stream
            ServletOutputStream outputStream = response.getOutputStream();
            // Write to the output stream
            worksheet.getWorkbook().write(outputStream);
            // 清除缓存
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RequestMapping("/testHiberate")
//    public String getHiber(Map<String, Object> model) {
//        Integer num = userService.userCount();
//        model.put("userCount", num);
//        return "/test/hiber";
//    }
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }
    @RequestMapping("/addDataTest")
    @ResponseBody
    public void addDataTest(@RequestBody Order order) {
        System.out.println("1");
    }
}
