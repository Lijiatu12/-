
package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberInfo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "Qingshen123";
        String databaseName = "member_info";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                conn.createStatement().execute("USE " + databaseName);

                String insertSQL = "INSERT INTO member (name, birthDate, maritalstatus, address, alivestatus, deathDate) VALUES (?, ?, ?, ?, ?, ?)";

                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    insertPerson(pstmt, "李卫国", "1950年2月15日", "已婚", "山东省烟台市", "已故", "2019年4月3日");
                    insertPerson(pstmt, "李卫民", "1953年4月30日", "已婚", "山东省烟台市", "已故", "2020年3月23日");
                    insertPerson(pstmt, "李强国", "1970年5月1日", "已婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李强军", "1972年8月21日", "已婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李庆国", "1975年6月22日", "已婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李自强", "1978年4月26日", "已婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李建强", "1983年10月18日", "已婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李想", "1992年2月15日", "已婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李耀", "1995年5月4日", "已婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李曼诗", "1998年7月16日", "未婚", "山东省青岛市", "健在", null);
                    insertPerson(pstmt, "李平安", "2000年1月1日", "未婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李菲", "2004年3月4日", "未婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李易", "2005年12月12日", "未婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李书瑶", "2015年9月3日", "未婚", "山东省烟台市", "健在", null);
                    insertPerson(pstmt, "李柏恩", "2018年4月2日", "未婚", "山东省烟台市", "健在", null);

                } catch (SQLException ex) {
                    System.out.println("Error inserting data: " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error connecting to the database: " + ex.getMessage());
        }
    }

    private static void insertPerson(PreparedStatement pstmt, String name, String birthDate, String maritalStatus,
                                     String address, String aliveStatus, String deathDate) throws SQLException {
        pstmt.setString(1, name);
        pstmt.setString(2, birthDate);
        pstmt.setString(3, maritalStatus);
        pstmt.setString(4, address);
        pstmt.setString(5, aliveStatus);
        pstmt.setString(6, deathDate);
        pstmt.executeUpdate();
    }
}
