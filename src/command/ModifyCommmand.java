package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class ModifyCommmand implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.update(id, name, title, content);
		ArrayList<BoardDTO> dtos = dao.list();
		request.setAttribute("list", dtos);	
	}
}
