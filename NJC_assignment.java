String dbURL = "jdbc:mysql://localhost:3306/MovieDB”;
String username = "root";
String password = "secret";
 
try {
 
    Connection conn = DriverManager.getConnection(dbURL, username, password);
 
    if (conn != null) {
        System.out.println("Connected");
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}

String sql = "INSERT INTO Movies(movie_name, lead_actor, actress_name, director_name, year_of_release) VALUES (?, ?, ?, ?, ?)”;
 
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, “x”);
statement.setString(2, “y”);
statement.setString(3, “z”);
statement.setString(4, “a”);
statement.setString(5, “2020”);
 
int rowsInserted = statement.executeUpdate();
if (rowsInserted > 0) {
    System.out.println("A new user was inserted successfully!");
}


String sql = "SELECT * FROM Movies”;
 
Statement statement = conn.createStatement();
ResultSet result = statement.executeQuery(sql);
 
int count = 0;
 
while (result.next()){
    String movie_name = result.getString(2);
    String lead_actor = result.getString(3);
    String actress_name = result.getString(“actress_name”);
    String director_name = result.getString(“director_name”);
Integer year_of_release = result.getInt(“year_of_release”);
 
    String output = "User #%d: %s - %s - %s - %s";
    System.out.println(String.format(output, ++count, movie_name, lead_actor, actress_name, director_name, year_of_release));
}
