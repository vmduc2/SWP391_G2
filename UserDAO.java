public class UserDAO extends DBContext {
public Customer getCustomersByID(String CustomerID) {
        String sql = "SELECT * FROM Customers where CustomerID = ?";
        Customer h = new Customer();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, CustomerID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                h.setCustomerID(rs.getString("CustomerID"));
                h.setName(rs.getString("Name"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return h;
    }
}
