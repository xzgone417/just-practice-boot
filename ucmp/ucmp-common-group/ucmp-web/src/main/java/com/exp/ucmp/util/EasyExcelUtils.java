package com.exp.ucmp.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;

import io.swagger.annotations.ApiOperation;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description: excel导出工具类
 * @date 2022/11/16 13:58
 */
public class EasyExcelUtils {

    @SuppressWarnings("rawtypes")
    public static void webWriteExcel(HttpServletResponse response, List objects, Class clazz, String fileName) throws IOException {
        String sheetName = fileName;
        webWriteExcel(response, objects, clazz, fileName, sheetName, null);
    }

    public static void webWriteExcel(HttpServletResponse response, List objects, Class clazz, String fileName, WriteHandler writeHandler) throws IOException {
        String sheetName = fileName;
        webWriteExcel(response, objects, clazz, fileName, sheetName, writeHandler);
    }

    @SuppressWarnings("rawtypes")
    public static void webWriteExcel(HttpServletResponse response, List objects, Class clazz, String fileName, String sheetName, WriteHandler writeHandler) throws IOException {
        fileName = URLEncoder.encode(fileName,"utf-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".xlsx");
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
//        headWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        headWriteCellStyle.setDataFormat((short) 49);
        // 背景设置为白
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
//        WriteFont headWriteFont = new WriteFont();
//        headWriteFont.setFontHeightInPoints((short)11);
//        headWriteFont.setColor((short)9);
//        headWriteCellStyle.setWriteFont(headWriteFont);

        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            EasyExcel.write(outputStream, clazz).registerWriteHandler(horizontalCellStyleStrategy).head(clazz).
            registerWriteHandler(writeHandler).sheet(sheetName).doWrite(objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
    }

    @SuppressWarnings("rawtypes")
    public static ByteArrayOutputStream obsWriteExcel(List objects, Class clazz, String fileName) throws IOException {
        String sheetName = fileName;
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景设置为白
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            EasyExcel.write(byteArrayOutputStream, clazz).registerWriteHandler(horizontalCellStyleStrategy).sheet(sheetName).doWrite(objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            byteArrayOutputStream.close();
        }
        return byteArrayOutputStream;
    }

    @SuppressWarnings("rawtypes")
    public static void webWriteExcel(HttpServletResponse response, List objects, Class clazz, String fileName, String sheetName) throws IOException {
        fileName = URLEncoder.encode(fileName,"utf-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + ".xlsx");
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景设置为白
        headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            EasyExcel.write(outputStream, clazz).registerWriteHandler(horizontalCellStyleStrategy).head(clazz).sheet(sheetName).doWrite(objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
    }
}
