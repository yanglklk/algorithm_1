package com.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxUtils {
	
	/**
	 * 各种uuid集合转换为字符串 例如 'aaa','bbb','ccc'
	 * 主要用于sql 查询条件 in 时超出2100限制
	 * @param uuids
	 * @return
	 */
	public static String getUuidStr(List<String> uuids){
		StringBuffer uuidStr=new StringBuffer();
		if(!CollectionUtils.isEmpty(uuids)){
			for(String uuid:uuids){
				uuidStr.append("'").append(uuid).append("'").append(",");
			}
			
		}
		if(StringUtils.isNotBlank(uuidStr.toString())){
			return uuidStr.substring(0, uuidStr.toString().length()-1);
		}else{
			return "";
		}
	}

	public static void setStringTotxt(String data,String fileName ){
		try {

			File file = new File(fileName);

			//if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			//true = append file
			FileWriter fileWritter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
