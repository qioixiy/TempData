package com.xxx.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FprCap.*;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.biz.impl.CustomerListBizImpl;
import cn.fingerdata.bizz.CustomerListBiz;
import com.xxx.db.*;
import com.xxx.utils.algorithm;
import com.xxx.utils.algorithm.FINGER_TYPE;
import com.xxx.utils.algorithm.algorithmInput;

import java.sql.*;

/**
 * Servlet implementation class FinData
 */
@WebServlet("/FinData")
public class FinData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletCtx = config.getServletContext();
		
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinData() {
		super();
		// TODO Auto-generated constructor stub
	}

	private FINGER_TYPE IntToFINGER_TYPE(int i)
	{
		//Wt, Ws, We, Wc, Wd, Wi, Wp, Rp, Wl, Rl, U, R, Lf, Rf, As, Ae, At, Au, Ar, Wx, Ux, Ax

		FINGER_TYPE t = FINGER_TYPE.values()[i];
		
		return t;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("FinData enter");
		
		int userid = 2;
		
		String sql = String.format("SELECT * FROM `tempinter` WHERE userid = %d", userid);
		System.out.println(sql);
		try{
			Connection conn=(new jdbc()).GetConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			String L1temp, L1RCL, L1RCR, L2temp, L2RCL, L2RCR, L3temp, L3RCL, L3RCR, L4temp, L4RCL, L4RCR, L5temp, L5RCL, L5RCR;
			String R1temp, R1RCL, R1RCR, R2temp, R2RCL, R2RCR, R3temp, R3RCL, R3RCR, R4temp, R4RCL, R4RCR, R5temp, R5RCL, R5RCR;
			
			while (rs.next()) {
				L1temp = rs.getString("L1temp");
				L1RCL = rs.getString("L1RCL");
				L1RCR = rs.getString("L1RCR");
				L2temp = rs.getString("L2temp");
				L2RCL = rs.getString("L2RCL");
				L2RCR = rs.getString("L2RCR");
				L3temp = rs.getString("L3temp");
				L3RCL = rs.getString("L3RCL");
				L3RCR = rs.getString("L3RCR");
				L4temp = rs.getString("L4temp");
				L4RCL = rs.getString("L4RCL");
				L4RCR = rs.getString("L4RCR");
				L5temp = rs.getString("L5temp");
				L5RCL = rs.getString("L5RCL");
				L5RCR = rs.getString("L5RCR");
				
				R1temp = rs.getString("R1temp");
				R1RCL = rs.getString("R1RCL");
				R1RCR = rs.getString("R1RCR");
				R2temp = rs.getString("R2temp");
				R2RCL = rs.getString("R2RCL");
				R2RCR = rs.getString("R2RCR");
				R3temp = rs.getString("R3temp");
				R3RCL = rs.getString("R3RCL");
				R3RCR = rs.getString("R3RCR");
				R4temp = rs.getString("R4Ttemp");
				R4RCL = rs.getString("R4RCL");
				R4RCR = rs.getString("R4RCR");
				R5temp = rs.getString("R5temp");
				R5RCL = rs.getString("R5RCL");
				R5RCR = rs.getString("R5RCR");
				
				algorithm malgorithm = new algorithm();
				algorithm.algorithmInput input = malgorithm.new algorithmInput();
				input.mFingerDataLeft[0].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(L1temp).intValue());
				input.mFingerDataLeft[0].RcBig = Float.parseFloat(L1RCL);
				input.mFingerDataLeft[0].RcSmall = Float.parseFloat(L1RCR);
				input.mFingerDataLeft[1].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(L2temp).intValue());
				input.mFingerDataLeft[1].RcBig = Float.parseFloat(L2RCL);
				input.mFingerDataLeft[1].RcSmall = Float.parseFloat(L2RCR);
				input.mFingerDataLeft[2].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(L3temp).intValue());
				input.mFingerDataLeft[2].RcBig = Float.parseFloat(L3RCL);
				input.mFingerDataLeft[2].RcSmall = Float.parseFloat(L3RCR);
				input.mFingerDataLeft[3].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(L4temp).intValue());
				input.mFingerDataLeft[3].RcBig = Float.parseFloat(L4RCL);
				input.mFingerDataLeft[3].RcSmall = Float.parseFloat(L4RCR);
				input.mFingerDataLeft[4].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(L5temp).intValue());
				input.mFingerDataLeft[4].RcBig = Float.parseFloat(L5RCL);
				input.mFingerDataLeft[4].RcSmall = Float.parseFloat(L5RCR);

				input.mFingerDataRight[0].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(R1temp).intValue());
				input.mFingerDataRight[0].RcBig = Float.parseFloat(R1RCL);
				input.mFingerDataRight[0].RcSmall = Float.parseFloat(R1RCR);
				input.mFingerDataRight[1].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(R2temp).intValue());
				input.mFingerDataRight[1].RcBig = Float.parseFloat(R2RCL);
				input.mFingerDataRight[1].RcSmall = Float.parseFloat(R2RCR);
				input.mFingerDataRight[2].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(R3temp).intValue());
				input.mFingerDataRight[2].RcBig = Float.parseFloat(R3RCL);
				input.mFingerDataRight[2].RcSmall = Float.parseFloat(R3RCR);
				input.mFingerDataRight[3].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(R4temp).intValue());
				input.mFingerDataRight[3].RcBig = Float.parseFloat(R4RCL);
				input.mFingerDataRight[3].RcSmall = Float.parseFloat(R4RCR);
				input.mFingerDataRight[4].mFINGER_TYPE = IntToFINGER_TYPE(Integer.valueOf(R5temp).intValue());
				input.mFingerDataRight[4].RcBig = Float.parseFloat(R5RCL);
				input.mFingerDataRight[4].RcSmall = Float.parseFloat(R5RCR);

				algorithm.algorithmOutput output = malgorithm.Run(input);
				
				System.out.println(output);

				request.setAttribute("FinData", output);
				
				RequestDispatcher drDispatcher = request.getRequestDispatcher("files/FinData.jsp");
				drDispatcher.forward(request, response);
			}
		}catch(Exception  e){
			e.printStackTrace();
		}finally {
			;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
