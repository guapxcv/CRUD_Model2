package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.BoardCommand;
import command.ContentCommand;
import command.ContentShowCommand;
import command.DeleteCommand;
import command.ListCommand;
import command.ModifyCommmand;
import command.WriteCommand;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actioDo");
		
		request.setCharacterEncoding("utf8");
		
		String viewPage = null;
		BoardCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/list.do")){ // 글 목록 
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			
		}else if(com.equals("/write_view.do")) { //글작성 페이지 호출 
			viewPage = "write_view.jsp";
			
		}else if(com.equals("/write.do")) { // 글작성 처리 
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		}else if(com.equals("/content_view.do")){ // 글 내용보기 
			command = new ContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
			
		}else if(com.equals("/modify_view.do")) { // 글수정 페이지 호출 
			command = new ContentShowCommand();
			command.execute(request, response);
			viewPage = "modify_view.jsp";
			
		}else if(com.equals("/modify.do")) { // 글 수정 처
			command = new ModifyCommmand();
			command.execute(request, response);
			viewPage = "list.do";

		}else if(com.equals("/delete.do")) { // 글 삭제 처리
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		}else {
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	} 
	

}
