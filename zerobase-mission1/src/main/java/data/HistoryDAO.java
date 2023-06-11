package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO extends DAO {

    public void update(HistoryDTO hDto) {

        Connection connection = connectDb();
       
        String sql =  "insert into HISTORY(COOR_X, COOR_Y, INQUIRY_DT) " +
                "values (?, ?, datetime('now', 'localtime'))";

        
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, hDto.getCoorX());
            preparedStatement.setFloat(2, hDto.getCoorY());
           
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
            
        String sql = "delete from HISTORY" +
        		" where HISTORY_ID = ?";
 
        try {
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
    
    
    public List<HistoryDTO> showHistory() {
    	
    	
    	List<HistoryDTO> historyList = new ArrayList<>();
        
        Connection connection = connectDb();
         
        String sql =  "SELECT *" 
        		+ " FROM HISTORY";
        
        try {
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        ResultSet rs = preparedStatement.executeQuery();
	        
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
        return historyList;
    }
}
