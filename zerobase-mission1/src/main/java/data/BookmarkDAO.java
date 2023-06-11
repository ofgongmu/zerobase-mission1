package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDAO extends DAO {

    public void add(BookmarkDTO bDto) {

        Connection connection = connectDb();

        try {
            
            String sql = "insert into BK_WIFI(GROUP_NAME, WIFI_NAME, ADD_DT) " +
                    "values (?, ?, datetime('now', 'localtime'))";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bDto.getGroupName());
            preparedStatement.setString(2, bDto.getWifiName());
           
            preparedStatement.executeUpdate();
         
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        closeDb(connection);

    }
    
    public void delete(int id) {
        
        Connection connection = connectDb();
       
        try {
            
            String sql = "delete from BK_WIFI" +
            		" where BK_ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
        }
        
        closeDb(connection);

    }
    
    
    public List<BookmarkDTO> showBookmark() {
    	
    	
    	List<BookmarkDTO> bookmarkList = new ArrayList<>();
        
        Connection connection = connectDb();
       
        try {
            
            String sql =  "SELECT *" 
            		+ " FROM BK_WIFI";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
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
           
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        closeDb(connection);
        return bookmarkList;
    }
    
public BookmarkDTO detail(int no) {
    	
    	
    	BookmarkDTO bDto = new BookmarkDTO();
       
        Connection connection = connectDb();

        try {
            String sql =  "SELECT *" 
            		+ " FROM BK_WIFI"
            		+ " WHERE BK_ID = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, no);
            ResultSet rs = preparedStatement.executeQuery();
            
        	int bookmarkId = rs.getInt("BK_ID");
        	String groupName = rs.getString("GROUP_NAME");
        	String wifiName = rs.getString("WIFI_NAME");
        	String addDt = rs.getString("ADD_DT");
        	
        	bDto.setBookmarkId(bookmarkId);
        	bDto.setGroupName(groupName);
        	bDto.setWifiName(wifiName);
        	bDto.setAddDt(addDt);
        	
        	if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        	
        	if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } 
       
        closeDb(connection);
        return bDto;
	}
}
