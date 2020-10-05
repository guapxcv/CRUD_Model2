package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class DeleteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(id);
		ArrayList<BoardDTO> dtos = dao.list();
		request.setAttribute("list", dtos);
	}

}
