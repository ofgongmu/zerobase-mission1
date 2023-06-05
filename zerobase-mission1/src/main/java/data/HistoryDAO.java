package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {

    public void update(HistoryDTO hDto) {
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
            
            String sql =  "insert into HISTORY(COOR_X, COOR_Y, INQUIRY_DT) " +
                    "values (?, ?, datetime('now', 'localtime'))";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, hDto.getCoorX());
            preparedStatement.setFloat(2, hDto.getCoorY());
           
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
            
            String sql = "delete from HISTORY" +
            		" where HISTORY_ID = ?";

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
    
    
    public List<HistoryDTO> showHistory() {
    	
    	
    	List<HistoryDTO> historyList = new ArrayList<>();
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
            		+ " FROM HISTORY";
            
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	int historyId = rs.getInt("HISTORY_ID");
            	float coorX = rs.getFloat("COOR_X");
            	float coorY = rs.getFloat("COOR_Y");
            	String inquiryDt = rs.getString("INQUIRY_DT");
            	
            	HistoryDTO hDto = new HistoryDTO();
            	hDto.setHistoryId(historyId);
            	hDto.setCoorX(coorX);
            	hDto.setCoorY(coorY);
            	hDto.setInquiryDt(inquiryDt);
            	
            	historyList.add(hDto);
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
        return historyList;
    }
}
