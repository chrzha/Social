package com.chrzha.social.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chrzha.social.entity.PatentsInfo;
import com.chrzha.social.service.DataCatchService;

@Controller
@RequestMapping(value = "/download")
public class DownloadController {

	@Autowired
	private DataCatchService dataCatchService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String download(@RequestParam("fileName") String fileName)
			throws FileNotFoundException {

		String filePath = "F:/" + fileName + ".xls";

		List<PatentsInfo> list = dataCatchService.getPatents();
		// 创建excel
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建sheet
		HSSFSheet sheet = wb.createSheet("PATENTS记录");

		// 创建一行
		HSSFRow rowTitle = sheet.createRow(0);

		// 创建标题栏样式
		HSSFCellStyle styleTitle = wb.createCellStyle();
		styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中
		HSSFFont fontTitle = wb.createFont();
		// 宋体加粗
		fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		fontTitle.setFontName("宋体");
		fontTitle.setFontHeight((short) 200);
		styleTitle.setFont(fontTitle);

		// 在行上创建1列
		HSSFCell cellTitle = rowTitle.createCell(0);
		cellTitle.setCellValue("记录编号");
		cellTitle.setCellStyle(styleTitle);

		// 在行上创建2列
		cellTitle = rowTitle.createCell(1);
		cellTitle.setCellValue("专利号");
		cellTitle.setCellStyle(styleTitle);

		cellTitle = rowTitle.createCell(2);
		cellTitle.setCellValue("专利名称");
		cellTitle.setCellStyle(styleTitle);

		cellTitle = rowTitle.createCell(3);
		cellTitle.setCellValue("发明人");
		cellTitle.setCellStyle(styleTitle);

		cellTitle = rowTitle.createCell(4);
		cellTitle.setCellValue("摘要");
		cellTitle.setCellStyle(styleTitle);

		cellTitle = rowTitle.createCell(5);
		cellTitle.setCellValue("超链接");
		cellTitle.setCellStyle(styleTitle);

		cellTitle = rowTitle.createCell(6);
		cellTitle.setCellValue("备注");
		cellTitle.setCellStyle(styleTitle);

		HSSFCellStyle styleCenter = wb.createCellStyle();
		styleCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中

		for (int i = 0; i < list.size(); i++) {

			PatentsInfo item = list.get(i);
			HSSFRow row = sheet.createRow(i + 1);
			row.setHeightInPoints(20);

			HSSFCell cell = row.createCell(0);
			cell.setCellValue(i + 1);
			cell.setCellStyle(styleCenter);

			cell = row.createCell(1);
			cell.setCellValue(item.getPatentNumber());
			cell.setCellStyle(styleCenter);

			cell = row.createCell(2);
			cell.setCellValue(item.getPatentName());
			cell.setCellStyle(styleCenter);

			cell = row.createCell(3);
			cell.setCellValue(item.getOwnerName());
			cell.setCellStyle(styleCenter);

			cell = row.createCell(4);
			cell.setCellValue(item.getAbstractContent());
			cell.setCellStyle(styleCenter);

			cell = row.createCell(5);
			cell.setCellValue(item.getPatentUrl());
			cell.setCellStyle(styleCenter);

			cell = row.createCell(6);
			cell.setCellValue(item.getVersion());
			cell.setCellStyle(styleCenter);
		}
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		FileOutputStream fout = new FileOutputStream(filePath);
		try {
			wb.write(fout);
			fout.close();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("导出完成！");

		return "success";
	}

}
