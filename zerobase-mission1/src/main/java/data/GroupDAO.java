package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO {

    public void add(GroupDTO gDto) {
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
                
            String sql = "insert into BK_GROUP(GROUP_NAME, ORDER_OF, ADD_DT) " +
                    "values (?, ?, datetime('now', 'localtime'))";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, gDto.getGroupName());
            preparedStatement.setInt(2, gDto.getOrder());
           
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
    
    public void edit(GroupDTO gDto) {
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
            
            String sql =  "update BK_GROUP" +
                    " set GROUP_NAME = ?, ORDER_OF = ?, EDIT_DT = datetime('now', 'localtime')" +
            		" where GROUP_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, gDto.getGroupName());
            preparedStatement.setInt(2, gDto.getOrder());
            preparedStatement.setInt(3, gDto.getGroupId());
           
            preparedStatement.executeUpdate();

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
            
            String sql = "delete from BK_GROUP" +
            		" where GROUP_ID = ?";

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
    
    
    public List<GroupDTO> showGroup() {
    	
    	
    	List<GroupDTO> groupList = new ArrayList<>();
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
            		+ " FROM BK_GROUP"
            		+ " ORDER BY ORDER_OF";
            
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            
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
        return groupList;
    }
    
public GroupDTO detail(int no) {
    	
    	
    	GroupDTO gDto = new GroupDTO();
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
            		+ " FROM BK_GROUP"
            		+ " WHERE GROUP_ID = ?";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, no);
            rs = preparedStatement.executeQuery();
            
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
        return gDto;
	}
}
