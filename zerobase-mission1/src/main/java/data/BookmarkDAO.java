package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDAO {

    public void add(BookmarkDTO bDto) {
        String url = "jdbc:sqlite:/Users/g/Desktop/코딩/Mission1_DB.db";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        

        try {
            connection = DriverManager.getConnection(url);
                
            String sql = "insert into BK_WIFI(GROUP_NAME, WIFI_NAME, ADD_DT) " +
                    "values (?, ?, datetime('now', 'localtime'))";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bDto.getGroupName());
            preparedStatement.setString(2, bDto.getWifiName());
           
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
            	System.out.println("성공");
            } else {
            	System.out.println("실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    
    public void delete(int id) {
        String url = "jdbc:sqlite:/Users/g/Desktop/코딩/Mission1_DB.db";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url);
            
            String sql = "delete from BK_WIFI" +
            		" where BK_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    
    
    public List<BookmarkDTO> showBookmark() {
    	
    	
    	List<BookmarkDTO> bookmarkList = new ArrayList<>();
        String url = "jdbc:sqlite:/Users/g/Desktop/코딩/Mission1_DB.db";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        

        try {
            connection = DriverManager.getConnection(url);
            
            String sql =  "SELECT *" 
            		+ " FROM BK_WIFI";
            
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	int bookmarkId = rs.getInt("BK_ID");
            	String groupName = rs.getString("GROUP_NAME");
            	String wifiName = rs.getString("WIFI_NAME");
            	String addDt = rs.getString("ADD_DT");
            	
            	BookmarkDTO bDto = new BookmarkDTO();
            	bDto.setBookmarkId(bookmarkId);
            	bDto.setGroupName(groupName);
            	bDto.setWifiName(wifiName);
            	bDto.setAddDt(addDt);
            	
            	bookmarkList.add(bDto);
            }
           

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookmarkList;
    }
    
public BookmarkDTO detail(int no) {
    	
    	
    	BookmarkDTO bDto = new BookmarkDTO();
        String url = "jdbc:sqlite:/Users/g/Desktop/코딩/Mission1_DB.db";

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        

        try {
            connection = DriverManager.getConnection(url);
            
            String sql =  "SELECT *" 
            		+ " FROM BK_WIFI"
            		+ " WHERE BK_ID = ?";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, no);
            rs = preparedStatement.executeQuery();
            
        	int bookmarkId = rs.getInt("BK_ID");
        	String groupName = rs.getString("GROUP_NAME");
        	String wifiName = rs.getString("WIFI_NAME");
        	String addDt = rs.getString("ADD_DT");
        	
        	bDto.setBookmarkId(bookmarkId);
        	bDto.setGroupName(groupName);
        	bDto.setWifiName(wifiName);
        	bDto.setAddDt(addDt);
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bDto;
	}
}
