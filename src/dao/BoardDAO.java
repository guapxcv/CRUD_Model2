package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import dto.BoardDTO;

public class BoardDAO {

	private DataSource dataSource;

	private BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/TestDB");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}

	public void write(String name, String title, String content) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			String query = "insert into test.mvc_board (name, title, content) values(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, content);
			int rn = ps.executeUpdate();
			if(rn != 0) {
				System.out.println("write success");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void update(int id, String name, String title, String content) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			String query = "update test.mvc_board set name=?,title=?,content=? where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setInt(4, id);
			int rn = ps.executeUpdate();
			if(rn != 0) {
				System.out.println("update success");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void delete(int id) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			String query = "delete from test.mvc_board where id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			int rn = ps.executeUpdate();
			if(rn != 0) {
				System.out.println("delete success");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<BoardDTO> list() {
		
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query = "select * from test.mvc_board";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int readCount = rs.getInt("readCount");
				Date date  = rs.getDate("date");
				
				BoardDTO dto = new BoardDTO(id, name, title, content, readCount, date);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return dtos;
	}
	public BoardDTO contentView(int _id, int readCnt) {
		BoardDTO dto = null;		
		Connection conn = null;
		Connection conn2 = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			conn2 = dataSource.getConnection();
			
			String query = "select * from test.mvc_board where id=?";
			String query2 = "update test.mvc_board set readCount=? where id=?";
			ps = conn.prepareStatement(query);
			ps2 = conn2.prepareStatement(query2);
			
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int readCount = rs.getInt("readCount");
				Date date  = rs.getDate("date");
				
				dto = new BoardDTO(id, name, title, content, readCount, date);
				ps2.setInt(1, readCount+1);
				ps2.setInt(2, id);
				int rn = ps2.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null && ps2 != null) {
				try {
					ps.close();
					ps2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(conn != null && conn2 != null) {
				try {
					conn.close();
					conn2.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}
		return dto;
	}
	
	public BoardDTO contentView(int _id) {
		BoardDTO dto = null;		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			String query = "select * from test.mvc_board where id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int readCount = rs.getInt("readCount");
				Date date  = rs.getDate("date");
				
				dto = new BoardDTO(id, name, title, content, readCount, date);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}
		return dto;
	}
	
	
}