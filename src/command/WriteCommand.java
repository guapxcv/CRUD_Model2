package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class WriteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.write(name, title, content);
		ArrayList<BoardDTO> dtos = dao.list();
		request.setAttribute("list", dtos);
		
	}

}
