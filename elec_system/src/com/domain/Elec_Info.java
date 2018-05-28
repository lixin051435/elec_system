package com.domain;

import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.Math;




import net.sf.clipsrules.jni.Environment;

public class Elec_Info implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private double ia1; // 电流方向为正
	private double ia2; // 电流方向为负
	private double ib1; // 电流方向为正
	private double ib2; // 电流方向为负
	private double ic1; // 电流方向为正
	private double ic2; // 电流方向为负
	private String status;  //状态
	
	private static Environment clips;
	
	static{
		clips = new Environment();
		clips.loadFromResource("/net/sf/clipsrules/jni/examples/sudoku/resources/sudoku.clp");
		clips.loadFromResource("/net/sf/clipsrules/jni/examples/sudoku/resources/solve.clp");
	}
	

	public String createStatus(){
		return null;
	}
	public String getStatus() {
		File file = new File("res.txt");
		if (file.exists()) {
			file.delete();
		}
		String result = "无短路故障";
		//clips.load("/net/sf/clipsrules/jni/examples/sudoku/resources/sudoku.clp");
		clips.reset();
		clips.assertString(createClipString());
		clips.run();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("res.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String res = reader.readLine();
			if ("1".equals(res)) {
				result = "a单相接地短路  ";
			}else if ("2".equals(res)) {
				result = "b单相接地短路  ";
			}else if ("3".equals(res)) {
				result = "c单相接地短路  ";
			}else if ("4".equals(res)) {
				result = "abc三相接地短路";
			}else if ("5".equals(res)) {
				result = "ab相间短路  ";
			}else if ("6".equals(res)) {
				result = "ac相间短路";
			}else if ("7".equals(res)) {
				result = "bc相间短路";
			}else if ("8".equals(res)) {
				result = "ab接地短路";
			}else if ("9".equals(res)) {
				result = "bc接地短路";
			}else if ("10".equals(res)) {
				result = "ac接地短路";
			}
		} catch (Exception e) {
//			System.out.println("11");
		}finally{
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		status = result;
		return status;
	}
	public String createClipString(){
		String msg = "(eleinfo(ifa " + getIf("a") + ")(ifb "+ getIf("b") +")(ifc "+getIf("c")+")(ifab "+getIfab()+")(ifbc "+getIfbc()+")(ifac "+getIfac()+"))";
		return msg;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getIa1() {
		return ia1;
	}

	public void setIa1(double ia1) {
		this.ia1 = ia1;
	}

	public double getIa2() {
		return ia2;
	}

	public void setIa2(double ia2) {
		this.ia2 = ia2;
	}

	public double getIb1() {
		return ib1;
	}

	public void setIb1(double ib1) {
		this.ib1 = ib1;
	}

	public double getIb2() {
		return ib2;
	}

	public void setIb2(double ib2) {
		this.ib2 = ib2;
	}

	public double getIc1() {
		return ic1;
	}

	public void setIc1(double ic1) {
		this.ic1 = ic1;
	}

	public double getIc2() {
		return ic2;
	}

	public void setIc2(double ic2) {
		this.ic2 = ic2;
	}

	public double getIf(String type) {
		double res = 0.0;
		
		if ("a".equals(type)) {
			res = ia1 + ia2;
		}else if ("b".equals(type)) {
			res = ib1 + ib2;
		}else if ("c".equals(type)) {
			res = ic1 + ic2;
		}
		
		return res;
	}
	
	public double getIfab(){
		double res = 0.0;
		double cos =  ib1 + ib2 - 0.5 * ia1 - 0.5 * ia2;
		double sin = 0.5 * Math.sqrt(3) * (ia1 + ia2);
		res = Math.sqrt(cos * cos + sin * sin);
		return res;
	}
	public double getIfac(){
		double res = 0.0;
		double cos =  (ic1 + ic2 + ia1 + ia2) * (-0.5) ;
		double sin = 0.5 * Math.sqrt(3) * (ia1 + ia2 - ic1 - ic2);
		res = Math.sqrt(cos * cos + sin * sin);
		return res;
	}
	public double getIfbc(){
		double res = 0.0;
		double cos =  ib1 + ib2 - 0.5 * ic1 - 0.5 * ic2;
		double sin =  -0.5 * Math.sqrt(3) * (ic1 + ic2);
		res = Math.sqrt(cos * cos + sin * sin);
		return res;
	}

	@Override
	public String toString() {
		return "Elec_Info [date=" + date + ", ia1=" + ia1 + ", ia2=" + ia2
				+ ", ib1=" + ib1 + ", ib2=" + ib2 + ", ic1=" + ic1 + ", ic2="
				+ ic2 + "]";
	}
	public static void main(String[] args) {
		Elec_Info info = new Elec_Info();
		info.setIb1(10);
		info.setIb2(-1);
		System.out.println(info.getStatus());
	}
	
	
	

}
