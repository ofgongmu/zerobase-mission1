package test;

import java.sql.*;

public class DAO {
	
//	public void dbSelect() {
//        String url = "jdbc:sqlite://localhost:3306/MISSION1_DB";
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//
//
//        try {
//            connection = DriverManager.getConnection(url);
//
//            String sql = "select member_type, user_id, password, name " +
//                    "from member " +
//                    "where member_type = ? ";
//
//            preparedStatement = connection.prepareStatement(sql);
//            
//
//            rs = preparedStatement.executeQuery();
//
//            while(rs.next()) {
//                String memberType = rs.getString("member_type");
//                String userId = rs.getString("user_id");
//                String password = rs.getString("password");
//                String name = rs.getString("name");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null && !rs.isClosed()) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (preparedStatement != null && !preparedStatement.isClosed()) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (connection != null && !connection.isClosed()) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void load(DTO dto) {
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

            preparedStatement = connection.prepareStatement("delete from WIFI;");
            preparedStatement.execute();
            
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            String sql =  "insert into WIFI(MAN_NUM, DISTANCE, LOC_GU, WIFI_NAME, LOC_AD, LOC_AD2, LOC_FLOOR,"
            		+ "						INST_TYPE, INST_AD, SERVICE, NET_TYPE, INST_YEAR, INOUT, ENVIR,"
            		+ "						COOR_X, COOR_Y, WORK_DT) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, cast(? as DATETIME))";

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
            	 preparedStatement.setInt(7, dto.getLocFloor());
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
            
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
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
    
    public void clear() {
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

            preparedStatement = connection.prepareStatement("delete from WIFI;");
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

    public void dbEdit() {
        String url = "jdbc:mariadb://localhost:3306/testdb";
        String dbUserId = "testuser";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "update member " +
                    "set " +
                    "password = ? " +
                    "where member_type = ? " +
                    "and user_id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);

            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
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

//    public void withdraw(DTO dto) {
//        String url = "jdbc:mariadb://localhost:3306/testdb";
//        String dbUserId = "testuser";
//        String dbPassword = "zerobase";
//
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//
//        try {
//            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
//
//            String sql = "delete from member " +
//                    "where member_type = ? and user_id = ?";
//
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, member.getMemberType());
//            preparedStatement.setString(2, member.getUserId());
//
//            int affected = preparedStatement.executeUpdate();
//            if (affected > 0) {
//                System.out.println("삭제 성공");
//            } else {
//                System.out.println("삭제 실패");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null && !rs.isClosed()) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (preparedStatement != null && !preparedStatement.isClosed()) {
//                    preparedStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (connection != null && !connection.isClosed()) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

}
