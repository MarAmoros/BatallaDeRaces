package raceWar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {

		public static void main(String[] args) {
			String url = "jdbc:mysql://localhost/race_war?serverTimezone=UTC";
			String user = "root";
			String password = "mysql8024";
			String query = "select * from warriors";
			ArrayList<Character> characters = new ArrayList<Character>();
			
			characters.add(new Human("Carlos", "image1.png"));
			characters.add(new Dwarf("Friendo", "image2.png"));
			characters.add(new Elf("Ricardo", "image3.png"));

			
			//Load driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Establish connection to database
				Connection con = DriverManager.getConnection(url, user, password);
				String update = "";
				
				//Insert
				update = "Insert into warriors (warrior_id,warrior_name,warrior_image_path,warrior_race) values (?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(update);
				
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs;
				
				rs = st.executeQuery(query);
				rs = st.getResultSet();
				rs.last();
				int id = rs.getInt(1);
				
				
				for (Character c: characters) {
					id += 1;
					c.setId(id);
				}
				
				for (Character c: characters) {
					pst.setInt(1, c.getId());
					pst.setString(2, c.getName());
					pst.setString(3, c.getImage_path());
					pst.setString(4, c.getRace());
					pst.executeUpdate();
				}
				
//				update = "Delete from warriors where id=?";
//				pst = con.prepareStatement(update);
//				for (Character c: characters) {
//					pst.setInt(1, c.getId());
//					pst.executeUpdate();
//				}
				
				//SELECT
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);
				while(rs.next()) {
					System.out.print("ID: " + rs.getInt(1));
					System.out.println("    NAME: " + rs.getString(2));
					System.out.println("    RACE: " + rs.getString(4));
				}
			
			} catch (ClassNotFoundException e) {
				System.out.println("Driver could not be loaded");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Connection cannot be stablished");
				e.printStackTrace();
			}

		}

	}
