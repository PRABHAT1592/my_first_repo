package com.cusat.xyz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrimeSer extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public PrimeSer() {
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		int num= Integer.parseInt(request.getParameter("val"));
		int i=0;
		for(int p=2;p<=num;p++) {
			if(num%p==0) {
				i++;
			}
		}
		if(i==1) {
			pw.println("prime number");
		}
   	 	else {
   	 		pw.println("not a Prime Number");
   	 	}				
	}
}
