package com.payease.controller;

import com.payease.service.UserService;
import com.payease.vo.EsUesrVO;
import com.payease.vo.UserVo;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;


/**
 * Created by hrym13 on 2018/4/4.
 */
@Controller
@RequestMapping("/home")
public class UserController extends HttpServlet {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/findAllUser")
    @ResponseBody
    public List findAllUser() {
        List<UserVo> list = userService.findAllUser();
        return list;
    }
    
    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/loginQ")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/login")
    public String hello(Map<String, Object> map) {
        map.put("msg", "Hello Thymeleafss");
        return "login";
    }
    
    @RequestMapping("/findUserByUserName")
    public ModelAndView findUserByUserName(UserVo userVo) {
        ModelAndView mav = new ModelAndView();
        UserVo us = userService.findUserByUserName(userVo);
        mav.addObject("us", us);
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping("/findAllEsUser")
    @ResponseBody
    public Iterable<EsUesrVO> findAllEsUser() {
        return userService.findAllEsUser();
    }
    
    @RequestMapping("/testSearchUserById")
    @ResponseBody
    public Iterable<EsUesrVO> testSearchUserById(EsUesrVO esUesrVO){
        
        return userService.testSearchUserById(esUesrVO);
    }
    
    @RequestMapping("/findFlockBackUserListByType")
    @ResponseBody
    public Map<String,Object> findFlockBackUserListByType (Integer type, Integer uuid){
    
        return userService.findFlockBackUserListByType(type,uuid);
    }
    
    /**
     * 文件下载
     * @param response
     * @return
     */
//    @RequestMapping("/testDownById")
//    @ResponseBody
//    public HttpServletResponse IOdown(HttpServletResponse response){
//
//        HttpServletResponse s=null;
//        try {
//            s =   CreateExcel.testDown(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
//        return s;
//    }
    /**
     * 文件下载
     * @param
     * @return
     */
//    @RequestMapping("/testDown")
//    @ResponseBody
//    public String IOdownss(){
//
//     String s =  CreateExcel.genarateExcel();
//        return s;
//    }
    
        //文件下载：导出excel表
        @RequestMapping(value = "/exportExcel",method = RequestMethod.GET)
        @ResponseBody
        public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
            //一、从后台拿数据
            if (null == request || null == response)
            {
                return;
            }
//            List<VipConsumes> list = null;
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
//            int consumesType = Integer.parseInt(request.getParameter("consumesType"));
//            int conPaymentStatus =Integer.parseInt(request.getParameter("conPaymentStatus"));
//
//            VipConsumesExample example = new VipConsumesExample();
//            if(consumesType!=0 && conPaymentStatus!=0){
//                example.createCriteria().andTimeBetween(startTime, endTime).andConsumeTypeEqualTo(consumesType).andStatusEqualTo(conPaymentStatus);
//            }else if(consumesType ==0 && conPaymentStatus!=0) {
//                example.createCriteria().andTimeBetween(startTime, endTime).andStatusEqualTo(conPaymentStatus);
//            }else if(consumesType!=0 && conPaymentStatus==0){
//                example.createCriteria().andTimeBetween(startTime, endTime).andConsumeTypeEqualTo(consumesType);
//            }else {
//                example.createCriteria().andTimeBetween(startTime, endTime);
//            }
//            list = this.vipConsumesDao.selectByExample(example);
            //二、 数据转成excel
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-download");
            
            String fileName = "用户数据备份.xlsx";
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 第一步：定义一个新的工作簿
            XSSFWorkbook wb = new XSSFWorkbook();
            // 第二步：创建第一个Sheet页
            XSSFSheet sheet = wb.createSheet("用户总计");
            sheet.setDefaultRowHeight((short) (2 * 256));//设置行高
            sheet.setColumnWidth(0, 4000);//设置列宽
            sheet.setColumnWidth(1,5500);
            sheet.setColumnWidth(2,5500);
            sheet.setColumnWidth(3,5500);
            sheet.setColumnWidth(11,3000);
            sheet.setColumnWidth(12,3000);
            sheet.setColumnWidth(13,3000);
            XSSFFont font = wb.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 16);
    
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell = row.createCell(0);
            cell.setCellValue("用户昵称 ");
            cell = row.createCell(1);
            cell.setCellValue("修行时间 ");
            cell = row.createCell(2);
            cell.setCellValue("功课门数");
            cell = row.createCell(3);
            cell.setCellValue("累计报数");
            cell = row.createCell(4);
    
            XSSFRow rows;
            XSSFCell cells;
            for (int i = 0; i <10; i++) {
                // 第三步：在这个sheet页里创建一行
                rows = sheet.createRow(i+1);
                // 第四步：在该行创建一个单元格
                cells = rows.createCell(0);
                // 第五步：在该单元格里设置值
                cells.setCellValue("用户昵称");
        
                cells = rows.createCell(1);
                cells.setCellValue("修行时间");
                cells = rows.createCell(2);
                cells.setCellValue("功课门数");
                cells = rows.createCell(3);
                cells.setCellValue("累计报数");
                cells = rows.createCell(4);
            }
    
            // 第二步：创建第二个Sheet页
            XSSFSheet sheet1 = wb.createSheet("用户功课详细");
            sheet1.setDefaultRowHeight((short) (2 * 256));//设置行高
            sheet1.setColumnWidth(0, 4000);//设置列宽
            sheet1.setColumnWidth(1,5500);
            sheet1.setColumnWidth(2,5500);
            sheet1.setColumnWidth(3,5500);
            sheet1.setColumnWidth(11,3000);
            sheet1.setColumnWidth(12,3000);
            sheet1.setColumnWidth(13,3000);
            XSSFFont font1 = wb.createFont();
            font1.setFontName("宋体");
            font1.setFontHeightInPoints((short) 16);
    
            XSSFRow row1 = sheet1.createRow(0);
            XSSFCell cell1 = row1.createCell(0);
            cell1.setCellValue("功课名称 ");
            cell1 = row1.createCell(1);
            cell1.setCellValue("累计报数 ");
            cell1 = row1.createCell(2);
            cell1.setCellValue("功课状态");
    
            XSSFRow rows1;
            XSSFCell cells1;
            for (int i = 0; i <104857; i++) {
                // 第三步：在这个sheet页里创建一行
                rows1 = sheet1.createRow(i+1);
                // 第四步：在该行创建一个单元格
                cells1 = rows1.createCell(0);
                // 第五步：在该单元格里设置值
                cells1.setCellValue("阿弥陀佛");
        
                cells1 = rows1.createCell(1);
                cells1.setCellValue("207640");
                cells1 = rows1.createCell(2);
                if (1 == 2) {
                    cells1.setCellValue("删除");
            
                } else {
                    cells1.setCellValue("未删除");
                }
            }
            // 第二步：创建第三个Sheet页
            XSSFSheet sheet2 = wb.createSheet("报数详细");
            sheet2.setDefaultRowHeight((short) (2 * 256));//设置行高
            sheet2.setColumnWidth(0, 4000);//设置列宽
            sheet2.setColumnWidth(1,5500);
            sheet2.setColumnWidth(2,5500);
            sheet2.setColumnWidth(3,5500);
            XSSFFont font2 = wb.createFont();
            font2.setFontName("宋体");
            font2.setFontHeightInPoints((short) 16);
    
            XSSFRow row2 = sheet1.createRow(0);
            XSSFCell cell2 = row1.createCell(0);
            cell2.setCellValue("功课名称 ");
            cell2 = row2.createCell(1);
            cell2.setCellValue("报数 ");
            cell2 = row2.createCell(2);
            cell2.setCellValue("报数时间");
    
            XSSFRow rows2;
            XSSFCell cells2;
            for (int i = 0; i <10; i++) {
                // 第三步：在这个sheet页里创建一行
                rows2 = sheet2.createRow(i+1);
                // 第四步：在该行创建一个单元格
                cells2 = rows2.createCell(0);
                // 第五步：在该单元格里设置值
                cells2.setCellValue("阿弥陀佛");
        
                cells2 = rows2.createCell(1);
                cells2.setCellValue("207640");
                cells2 = rows2.createCell(2);
                if (1 == 2) {
                    cells2.setCellValue("删除");
            
                } else {
                    cells2.setCellValue("未删除");
                }
            }
            
            
            try {
                OutputStream out = response.getOutputStream();
                wb.write(out);
                out.close();
                wb.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    
}
