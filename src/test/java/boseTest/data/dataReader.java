package boseTest.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

public class dataReader {
	
	public List<HashMap<Object, Object>> getJsonToHashMap() throws IOException {
		//Read Json as String
		String jstring=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"src\\test\\java\\boseTest\\data\\purchaseOrder.json"), StandardCharsets.UTF_8) ;
	//Convert String to HashMap
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<Object,Object>> data=mapper.readValue(jstring, new TypeReference<List<HashMap<Object,Object>>>(){});
	return data;
	}

}
