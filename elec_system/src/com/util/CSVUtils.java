package com.util;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvWriter;
import com.domain.Elec_Info;


public class CSVUtils {

	public static void toExcel(ArrayList<Elec_Info> infos,String path){
		String csvFilePath = path;
		String[] csvContent = null;
		try {
			// 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);
			CsvWriter csvWriter = new CsvWriter(csvFilePath, ',',
					Charset.forName("gbk"));
			// 写表头
			String[] csvHeaders = { "时间", "ia1", "ia2", "ib1", "ib2",
					"ic1", "ic2", "状态" };
			csvWriter.writeRecord(csvHeaders);
			// 写内容
			for (int i = 0; i < infos.size(); i++) {
				csvContent = getStringArrayByEntity(infos.get(i));
				csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("--------CSV文件已经写入--------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String[] getStringArrayByEntity(Elec_Info elec_Info) {
		String[] strings = new String[8];
		strings[0] = elec_Info.getDate().toLocaleString();
		strings[1] = elec_Info.getIa1() + "";
		strings[2] = elec_Info.getIa2() + "";
		strings[3] = elec_Info.getIb1() + "";
		strings[4] = elec_Info.getIb2() + "";
		strings[5] = elec_Info.getIc1() + "";
		strings[6] = elec_Info.getIc2() + "";
		strings[7] = elec_Info.getStatus();
		
		return strings;
	}
	
}
