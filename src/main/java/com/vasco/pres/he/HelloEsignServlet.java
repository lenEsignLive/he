package com.vasco.pres.he;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.silanis.esl.sdk.DocumentPackage;
import com.silanis.esl.sdk.EslClient;
import com.silanis.esl.sdk.PackageId;

/**
 * hello esignlive servlet
 * get a package from esignlive and returns the status
 * @author lmudgett
 *
 */
public class HelloEsignServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String api = req.getParameter("api");
		String url = req.getParameter("url");
		String pid = req.getParameter("pid");
		PrintWriter p = resp.getWriter();
		try {
			EslClient eslClient = new EslClient(api, url);
			DocumentPackage dp = eslClient.getPackage(new PackageId(pid));
			p.write("<html><head><title>Hello eSignLive</title></head><body>");
			p.write("<h2 style='color:green'>Success</h2>");
			p.write("<div style='color:green'>Connection made and package returned.<br>Package status: " + dp.getStatus().name() + ".</div>");
			p.write("</body></html>");
		} catch(Exception e) {
			p.write("<html><head><title>Hello eSignLive</title></head><body>");
			p.write("<h2 style='color:red'>Error</h2>");
			p.write("<div style='color:red'>Unable to connect to eSignLive at URL: " + url +" with API KEY: " + api + 
					".<br>Details: " +e.getMessage() + ".</div>");
			p.write("</body></html>");
		}finally {
			p.close();
		}
	}
}
