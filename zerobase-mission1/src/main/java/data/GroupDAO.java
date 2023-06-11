package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends DAO {

    public void add(GroupDTO gDto) {

        Connection connection = connectDb();
        
        try {
                
	        String sql = "insert into BK_GROUP(GROUP_NAME, ORDER_OF, ADD_DT) " +
	                "values (?, ?, datetime('now', 'localtime'))";
	
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, gDto.getGroupName());
	        preparedStatement.setInt(2, gDto.getOrder());
	       
	        preparedStatement.executeUpdate();
            
	       if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
	       }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        closeDb(connection);
    }
    
    public void edit(GroupDTO gDto) {
   
        Connection connection = connectDb();
        
        try {
          
            String sql =  "update BK_GROUP" +
                    " set GROUP_NAME = ?, ORDER_OF = ?, EDIT_DT = datetime('now', 'localtime')" +
            		" where GROUP_ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, gDto.getGroupName());
            preparedStatement.setInt(2, gDto.getOrder());
            preparedStatement.setInt(3, gDto.getGroupId());
           
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
          
            
            String sql = "delete from BK_GROUP" +
            		" where GROUP_ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
             }
          

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        closeDb(connection);

    }
    
    
    public List<GroupDTO> showGroup() {
    	
    	
    	List<GroupDTO> groupList = new ArrayList<>();

        Connection connection = connectDb();
        

        try { 
            String sql =  "SELECT *" 
            		+ " FROM BK_GROUP"
            		+ " ORDER BY ORDER_OF";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	int groupId = rs.getInt("GROUP_ID");
            	String groupName = rs.getString("GROUP_NAME");
            	int order = rs.getInt("ORDER_OF");
            	String addDt = rs.getString("ADD_DT");
            	String editDt = rs.getString("EDIT_DT");
            	
            	GroupDTO gDto = new GroupDTO();
            	gDto.setGroupId(groupId);
            	gDto.setGroupName(groupName);
            	gDto.setOrder(order);
            	gDto.setAddDt(addDt);
            	gDto.setEditDt(editDt);
            	
            	groupList.add(gDto);
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
        return groupList;
    }
    
public GroupDTO detail(int no) {
    	
    	
    	GroupDTO gDto = new GroupDTO();
       
        Connection connection = connectDb(); 

        try { 
            
            String sql =  "SELECT *" 
            		+ " FROM BK_GROUP"
            		+ " WHERE GROUP_ID = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, no);
            ResultSet rs = preparedStatement.executeQuery();
            
        	int groupId = rs.getInt("GROUP_ID");
        	String groupName = rs.getString("GROUP_NAME");
        	int order = rs.getInt("ORDER_OF");
        	String addDt = rs.getString("ADD_DT");
        	String editDt = rs.getString("EDIT_DT");
        	
        	gDto.setGroupId(groupId);
        	gDto.setGroupName(groupName);
        	gDto.setOrder(order);
        	gDto.setAddDt(addDt);
        	gDto.setEditDt(editDt);
        	
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
        return gDto;
	}
}
