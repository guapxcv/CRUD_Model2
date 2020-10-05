package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class ContentCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int readCount = Integer.parseInt(request.getParameter("readCount"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.contentView(id, readCount);
		request.setAttribute("content_view", dto);
	}

}
