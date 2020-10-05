package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class ContentShowCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.contentView(id);
		
		request.setAttribute("content", dto);
	}

}
