package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class ListCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> dtos = dao.list();
		request.setAttribute("list", dtos);
	}
}
