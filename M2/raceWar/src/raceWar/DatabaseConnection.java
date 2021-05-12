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
			String url = "jdbc:mysql://localhost/race_war2?serverTimezone=UTC";
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
				String update;
				
				//Insert
				update = "Insert into warriors (warrior_id,warrior_name,warrior_image_path,warrior_race) values (?,?,?,?)";
				PreparedStatement pst;
				
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs;
				
//------------------------------------------
//SAMPLE QUERIES
				
				
				//CREATE WARRIOR
//				String warrior_name = "Pepe";
//				String warrior_image = "imagen.png";
//				int warrior_race = 1;
//				
//				rs = st.executeQuery("select * from warriors");
//				rs = st.getResultSet();
//				
//				rs.moveToInsertRow();
//				rs.updateString(2, warrior_name);
//				rs.updateString(3, warrior_image);
//				rs.updateInt(4, warrior_race);
//				rs.insertRow();
				
				
				//SHOW WARRIORS
//				pst = con.prepareStatement(query);
//				rs = pst.executeQuery(query);
//				while(rs.next()) {
//					System.out.print("ID: " + rs.getInt(1));
//					System.out.println("    NAME: " + rs.getString(2));
//					System.out.println("    RACE: " + rs.getString(4));
//				}
//				
			
			
//---------------------------------------------
				
//AFTER BATTLE
		//STORE BATTLE INFO
				//get battle info
//				int pid = 1;
//				int wid = 4;
//				int wwid = 5;
//				int oid = 5;
//				int owid = 2;
//				int dc = 50;
//				int dr = 25;
//				int bp = 30;
				
				//save battle info
//				rs = st.executeQuery("select * from battle");
//				rs = st.getResultSet();
//				rs.moveToInsertRow();
//				rs.updateInt(2, pid);
//				rs.updateInt(3, wid);
//				rs.updateInt(4, wwid);
//				rs.updateInt(5, oid);
//				rs.updateInt(6, owid);
//				rs.updateInt(7, dc);
//				rs.updateInt(9, dr);
//				rs.updateInt(9, bp);
//				rs.insertRow();
				
	//FIGHT AGAIN?
		//YES
			//WIN
				//save score in variable
			//LOSE
				//store ranking info
//				rs = st.executeQuery("select * from ranking");
//				rs = st.getResultSet();
//				rs.moveToInsertRow();
//				rs.updateInt(1, pid);
//				rs.updateInt(2, bp);
//				rs.updateInt(3, wid);
//				rs.insertRow();
//				//create player with new name
//				rs = st.executeQuery("select * from players");
//				rs = st.getResultSet();
//				rs.moveToInsertRow();
//				rs.updateString(2, "same name as before");
//				rs.insertRow();
		//NO
				//store ranking info
//				rs = st.executeQuery("select * from ranking");
//				rs = st.getResultSet();
//				rs.moveToInsertRow();
//				rs.updateInt(1, pid);
//				rs.updateInt(2, bp);
//				rs.updateInt(3, wid);
//				rs.insertRow();
			
				
				
//----------------------------------------------------------------				
				
		//RANKING
				//GET PLAYER NAMES
				ArrayList<String> players = new ArrayList<String>();
				pst = con.prepareStatement("select * from players");
				rs = pst.executeQuery();
				while(rs.next())
					players.add(rs.getString(2));
				
				//SHOW TOP 10
				pst = con.prepareStatement("select * from ranking order by player_points desc");
				rs = pst.executeQuery();
				
				int ranking_num = 0;
				
				while(rs.next() && ranking_num < 10) {
					ranking_num += 1;
					String name = players.get(rs.getInt(1)-1);
					
					System.out.print(ranking_num);
					System.out.print(")  NAME: " + name);
					System.out.print("|    SCORE: " + rs.getInt(2));
					System.out.print("|    WARRIOR: " + rs.getInt(3));
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
