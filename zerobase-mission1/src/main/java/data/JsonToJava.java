package data;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonToJava {
	
	public long loadWifi() {
		
		String result = "";
		
		try {
			DAO dao = new DAO();
			URL url = new URL("http://openapi.seoul.go.kr:8088/50534c754f6f66673431627a705148/json/TbPublicWifiInfo/1/10/");
			
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			result = bf.readLine();
			
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject)parser.parse(result);
			JSONObject info = (JSONObject)obj.get("TbPublicWifiInfo");
			long total = (long) info.get("list_total_count");
			long blocks = (long) Math.ceil((double) total / (double) 1000);
			
			
			Connection connection = dao.connectDb();
			
			dao.clear(connection);
			
			dao.beginTran(connection);
			
			for(int i = 0; i <= blocks; i++) {
				
				long start = 1 + 1000 * i;
				long end = Math.min(start + 999, total);
				
				bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				result = bf.readLine();
				parser = new JSONParser();
				url = new URL("http://openapi.seoul.go.kr:8088/50534c754f6f66673431627a705148/json/TbPublicWifiInfo/"+ start + "/" + end + "/");
				obj = (JSONObject)parser.parse(result);
				info = (JSONObject)obj.get("TbPublicWifiInfo"); 
				
				JSONArray row = (JSONArray)info.get("row");
				
				for(int j = 0; j < row.size(); j++) {
					JSONObject temp = (JSONObject)row.get(j);

					DTO dto = new DTO((String) temp.get("X_SWIFI_MGR_NO"), 0, (String) temp.get("X_SWIFI_WRDOFC"), (String) temp.get("X_SWIFI_MAIN_NM"), (String) temp.get("X_SWIFI_ADRES1"), (String) temp.get("X_SWIFI_ADRES2"), (String) temp.get("X_SWIFI_INSTL_FLOOR"),
							(String) temp.get("X_SWIFI_INSTL_TY"), (String) temp.get("X_SWIFI_INSTL_MBY"), (String) temp.get("X_SWIFI_SVC_SE"), (String) temp.get("X_SWIFI_CMCWR"), (String) temp.get("X_SWIFI_CNSTC_YEAR"), (String) temp.get("X_SWIFI_INOUT_DOOR"), (String) temp.get("X_SWIFI_REMARS3"),
							(String) temp.get("LAT"), (String) temp.get("LNT"), (String) temp.get("WORK_DTTM")); 
					
					dao.load(connection, dto);
					
				}
			
			}
			
			dao.endTran(connection);
			dao.closeDb(connection);
			
			return total;
		
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}
}
