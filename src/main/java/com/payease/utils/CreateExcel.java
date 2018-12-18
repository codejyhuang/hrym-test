package com.payease.utils;
import java.io.*;



import javax.servlet.http.HttpServletResponse;

/**
 * Created by hrym13 on 2018/12/6.
 */
public class CreateExcel {
    public static void main(String[] args) {
//        try {
//            testDown(null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
//        genarateExcel();
    
    
    }
    
    public static HttpServletResponse download(String path, HttpServletResponse response) {
       
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
            
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
    
//    public static HttpServletResponse testDown ( HttpServletResponse response)
//            throws IOException, RowsExceededException, WriteException{
//
//        //1:创建excel文件
//        File file=new File("/Users/hrym13/Desktop/test/test.xls");
//        System.out.println(file.getAbsolutePath());
//        file.createNewFile();
//
//        //2:创建工作簿
//        WritableWorkbook workbook=Workbook.createWorkbook(file);
//        //3:创建sheet,设置第二三四..个sheet，依次类推即可
//        WritableSheet sheet=workbook.createSheet("用户管理", 0);
//        //4：设置titles
//        String[] titles={"编号","账号","密码","用户名","哈哈"};
//        //5:单元格
//        Label label=null;
//        //6:给第一行设置列名
//        for(int i=0;i<titles.length;i++){
//            //x,y,第一行的列名
//            label=new Label(i,0,titles[i]);
//            //7：添加单元格
//            sheet.addCell(label);
//        }
//        //8：模拟数据库导入数据
//        for(int i=1;i<10;i++){
//            //添加编号，第二行第一列
//            label=new Label(0,i,i+"");
//            sheet.addCell(label);
//
//            //添加账号
//            label=new Label(1,i,"10010"+i);
//            sheet.addCell(label);
//
//            //添加密码
//            label=new Label(2,i,"123456");
//            sheet.addCell(label);
//            //添加密码
//            label=new Label(3,i,"123456");
//            sheet.addCell(label);
//        }
//
//        //写入数据，一定记得写入数据，不然你都开始怀疑世界了，excel里面啥都没有
//        workbook.write();
//        //最后一步，关闭工作簿
//        workbook.close();
//        download(file.getAbsolutePath(),null);
//        return response;
//    }
//
//    public static  String genarateExcel() {
//
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("企业信息管理");
//
//        HSSFRow row = sheet.createRow(0);
//        HSSFCellStyle style = workbook.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//        // 生成表头
//        HSSFCell cell = row.createCell(0);
//        cell.setCellValue("企业名称");
//        cell.setCellStyle(style);
//        cell = row.createCell(1);
//        cell.setCellValue("状态");
//        cell.setCellStyle(style);
//        cell = row.createCell(2);
//        cell.setCellValue("法人代表");
//        cell.setCellStyle(style);
//        cell = row.createCell(3);
//        cell.setCellValue("创建时间");
//
////        List<Info> list = super.copyList(infoDao.selectAll(),Info.class);
//        for (int i = 0; i < 10; i++) {
//            row = sheet.createRow(i + 1);
//            row.createCell(0).setCellValue("哈哈");
//            if ("1".equals(1)) {
//                row.createCell(1).setCellValue("正常");
//            }else {
//                row.createCell(1).setCellValue("不启用");
//            }
//
//            row.createCell(2).setCellValue("是是是");
//            row.createCell(3).setCellValue("111"+i);
//
//        }
//
//        String filePath = "home.xls";
//        try {
//            FileOutputStream fout = new FileOutputStream(filePath);
//            workbook.write(fout);
//            fout.close();
////            ExcelOperaation.showFileInfo(fout);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String urlPath = "/Users/hrym13/IdeaProjects/girl/src/main/resources/test.xls";
//
//        return urlPath;
//    }
}
