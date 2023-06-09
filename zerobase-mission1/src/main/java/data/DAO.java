package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	public Connection connectDb() {
		
		String url = "jdbc:sqlite:/Users/g/Desktop/코딩/Mission1_DB.db";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
                e.printStackTrace();  
        }
        
        return connection;
	}
        
    public void closeDb(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void beginTran(Connection connection) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("begin transaction;");
			preparedStatement.execute();
			
			 if (preparedStatement != null && !preparedStatement.isClosed()) {
	                preparedStatement.close();
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void endTran(Connection connection) {
        
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("end transaction;");
			preparedStatement.execute();
			
			if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }

    public void load(Connection connection, DTO dto) {
    	
      
            String sql =  "insert into WIFI(MAN_NUM, DISTANCE, LOC_GU, WIFI_NAME, LOC_AD, LOC_AD2, LOC_FLOOR,"
            		+ "						INST_TYPE, INST_AD, SERVICE, NET_TYPE, INST_YEAR, INOUT, ENVIR,"
            		+ "						COOR_X, COOR_Y, WORK_DT) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = null;
            
			try {
				preparedStatement = connection.prepareStatement(sql);
				
			    preparedStatement.setString(1, dto.getManNum());
	            preparedStatement.setFloat(2, dto.getDist());
	            preparedStatement.setString(3, dto.getLocGu());
	            preparedStatement.setString(4, dto.getWifiName());
	            preparedStatement.setString(5, dto.getLocAd());
	            preparedStatement.setString(6, dto.getLocAd2());
	            if (dto.getLocFloor() == null) {
	            	preparedStatement.setNull(7,Types.INTEGER);
	            } else  {
	            	 preparedStatement.setString(7, dto.getLocFloor());
	            }
	            preparedStatement.setString(8, dto.getInstType());
	            preparedStatement.setString(9, dto.getInstAd());
	            preparedStatement.setString(10, dto.getService());
	            preparedStatement.setString(11, dto.getNetType());
	            if (dto.getInstYear() == null) {
	            	preparedStatement.setNull(12,Types.INTEGER);
	            } else  {
	            	preparedStatement.setInt(12, dto.getInstYear());
	            }
	            
	            preparedStatement.setString(13, dto.getInOut());
	            preparedStatement.setString(14, dto.getEnvir());
	            preparedStatement.setFloat(15, dto.getCoorX());
	            preparedStatement.setFloat(16, dto.getCoorY());
	            preparedStatement.setString(17, dto.getWorkDt());
	            
	          
	           preparedStatement.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
        

           try {
               if (preparedStatement != null && !preparedStatement.isClosed()) {
                   preparedStatement.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

    } 

  
    
    public void clear(Connection connection) {
 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from WIFI;");
			preparedStatement.execute();
		
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
          
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public ArrayList<ArrayList> distList() {
    	ArrayList<ArrayList> result = new ArrayList<>();
    	
    	Connection connection = connectDb();
    	
        String sql = "SELECT MAN_NUM, COOR_X, COOR_Y FROM WIFI";

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
		try {
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
	        
	        int idx = 0; 
	        while(rs.next()) {
	        	result.add(new ArrayList());
	        	result.get(idx).add(rs.getString("MAN_NUM"));
	        	result.get(idx).add(rs.getFloat("COOR_X"));
	        	result.get(idx).add(rs.getFloat("COOR_Y"));
	        	idx++;
	        }
	       
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeDb(connection);    
    	
    	
    	return result;
    }
    
    public void updateDist(float curX, float curY) {
    	
    	Connection connection = connectDb();
        ArrayList<ArrayList> list = distList();

        beginTran(connection);
        
        PreparedStatement preparedStatement = null;
        for(int i = 0; i < list.size(); i++) {
        	String sql = "UPDATE WIFI "
            		+ "SET "
            		+ "DISTANCE = ? "
            		+ "WHERE MAN_NUM = ?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setFloat(1, (float) Math.sqrt(Math.pow((float) list.get(i).get(1) - curX, 2) + Math.pow((float) list.get(i).get(2) - curY,  2)));
	            preparedStatement.setString(2, (String) list.get(i).get(0));
	            preparedStatement.execute();
	            
	           
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           
        }
        
        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        endTran(connection);
    	closeDb(connection);

    }
    
    public List<DTO> showNearWifi() {
    	
    	
    	List<DTO> wifiList = new ArrayList<>();
        
        Connection connection = connectDb();

        try {
        	
            String sql =  "SELECT MAN_NUM, DISTANCE, LOC_GU, WIFI_NAME, LOC_AD, LOC_AD2, LOC_FLOOR, INST_TYPE, INST_AD, SERVICE, NET_TYPE, INST_YEAR, INOUT, ENVIR, COOR_X, COOR_Y, WORK_DT" 
            		+ " FROM WIFI"
            		+ " ORDER BY DISTANCE"
            		+ " LIMIT 20";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
               
            while(rs.next()) {
	           	String manNum = rs.getString("MAN_NUM");
	           	float dist = rs.getFloat("DISTANCE"); 
	           	String locGu = rs.getString("LOC_GU");
	           	String wifiName = rs.getString("WIFI_NAME");
	           	String locAd = rs.getString("LOC_AD");
	           	String locAd2 = rs.getString("LOC_AD2");
	           	String locFloor = rs.getString("LOC_FLOOR");
	           	String instType = rs.getString("INST_TYPE");
	           	String instAd = rs.getString("INST_AD");
	           	String service = rs.getString("SERVICE");
	           	String netType = rs.getString("NET_TYPE");
	           	int instYear = rs.getInt("INST_YEAR");
	           	String inOut = rs.getString("INOUT");
	           	String envir = rs.getString("ENVIR");
	           	float coorX = rs.getFloat("COOR_X");
	           	float coorY = rs.getFloat("COOR_Y");
	           	String workDt = rs.getString("WORK_DT");
	           	
	           	DTO dto = new DTO();
	           	dto.setManNum(manNum);
	           	dto.setDist(dist);
	           	dto.setLocGu(locGu);
	           	dto.setWifiName(wifiName);
	           	dto.setLocAd(locAd);
	           	dto.setLocAd2(locAd2);
	           	dto.setLocFloor(locFloor);
	           	dto.setInstType(instType);
	           	dto.setInstAd(instAd);
	           	dto.setService(service);
	           	dto.setNetType(netType);
	           	dto.setInstYear(instYear);
	           	dto.setInOut(inOut);
	           	dto.setEnvir(envir);
	           	dto.setCoorX(coorX);
	           	dto.setCoorY(coorY);
	           	dto.setWorkDt(workDt);
	           	
	           	wifiList.add(dto);
           }
          

           try {
               if (rs != null && !rs.isClosed()) {
                   rs.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           try {
               if (preparedStatement != null && !preparedStatement.isClosed()) {
                   preparedStatement.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        closeDb(connection);
        return wifiList;
    }
    
    public DTO detail(String no) {
    	
    	DTO dto = new DTO();
        Connection connection = connectDb();
            
        
        try {
	            String sql =  "SELECT *" 
	            		+ " FROM WIFI"
	            		+ " WHERE MAN_NUM = ?";
	            
	        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        	preparedStatement.setString(1, no);
	            ResultSet rs = preparedStatement.executeQuery();
	            
	        	String manNum = rs.getString("MAN_NUM");
	        	float dist = rs.getFloat("DISTANCE"); 
	        	String locGu = rs.getString("LOC_GU");
	        	String wifiName = rs.getString("WIFI_NAME");
	        	String locAd = rs.getString("LOC_AD");
	        	String locAd2 = rs.getString("LOC_AD2");
	        	String locFloor = rs.getString("LOC_FLOOR");
	        	String instType = rs.getString("INST_TYPE");
	        	String instAd = rs.getString("INST_AD");
	        	String service = rs.getString("SERVICE");
	        	String netType = rs.getString("NET_TYPE");
	        	int instYear = rs.getInt("INST_YEAR");
	        	String inOut = rs.getString("INOUT");
	        	String envir = rs.getString("ENVIR");
	        	float coorX = rs.getFloat("COOR_X");
	        	float coorY = rs.getFloat("COOR_Y");
	        	String workDt = rs.getString("WORK_DT");
	        	
	        	
	        	dto.setManNum(manNum);
	        	dto.setDist(dist);
	        	dto.setLocGu(locGu);
	        	dto.setWifiName(wifiName);
	        	dto.setLocAd(locAd);
	        	dto.setLocAd2(locAd2);
	        	dto.setLocFloor(locFloor);
	        	dto.setInstType(instType);
	        	dto.setInstAd(instAd);
	        	dto.setService(service);
	        	dto.setNetType(netType);
	        	dto.setInstYear(instYear);
	        	dto.setInOut(inOut);
	        	dto.setEnvir(envir);
	        	dto.setCoorX(coorX);
	        	dto.setCoorY(coorY);
	        	dto.setWorkDt(workDt);       
	
	        
	            try {
	                if (rs != null && !rs.isClosed()) {
	                    rs.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	
	            try {
	                if (preparedStatement != null && !preparedStatement.isClosed()) {
	                    preparedStatement.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        closeDb(connection);
        return dto;
    }
}
