package cn.yc.yam.servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.yc.yam.dao.impl.AdminDao;
import cn.yc.yam.entitly.Goods;
public class GoodsUpLoad extends HttpServlet {

	private static final long serialVersionUID = -7744625344830285257L;
	 private String uploadPath;
	 private static String imgurl = "";
	 static String goodsimg = null;
	 Date startdate;
	 Date enddate;

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  goodsimg = null;
	 }
	 
	 public void init(ServletConfig config) {
	  // 获取在web.xml中设置的一个初始化路径参数
		 uploadPath = config.getInitParameter("uploadPath");
		 File file =new File(uploadPath);    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file .mkdir();    
		} else   
		{  
		    System.out.println("//目录存在");  
		}  
	 }
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("utf-8");
	  String fb = request.getParameter("fb");
	  PrintWriter out = response.getWriter();
	 /* uploadPath = request.getServletContext().getRealPath("/photos/upimg/")+"\\";
System.out.println(request.getServletContext().getRealPath("/photos/upimg/")+"\\");*/
	  if(!fb.equals("ok")) {
		  Long times = new Date().getTime();
		  int statue = 1;

			 DiskFileItemFactory factory = new DiskFileItemFactory();
			  ServletFileUpload upload = new ServletFileUpload(factory);
			  try {
			   List items = upload.parseRequest(request);
			   Iterator itr = items.iterator();
			   while (itr.hasNext()) {
			    FileItem item = (FileItem) itr.next();
			    if (item.isFormField()) {
			    //判断上传的是不是文件
			     System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
			    } else {
			     if (item.getName() != null && !item.getName().equals("")) {
			      System.out.println("上传文件的大小:" + item.getSize());
			      System.out.println("上传文件的类型:" + item.getContentType());
			      // item.getName()返回上传文件在客户端的完整路径名称
			      System.out.println("上传文件的名称:" + item.getName());
			      if(item.getName().endsWith("jpg")||item.getName().endsWith("png")||item.getName().endsWith("bmp")||item.getName().endsWith("gif")||item.getName().endsWith("jpeg")){
			    	  String[] s = item.getName().split("\\.");
			    	  goodsimg = times.toString() + "."+s[s.length-1];
			    	  imgurl = uploadPath + goodsimg ;
				      File tempFile = new File(imgurl);
				      item.write(tempFile);
				      String jsonimgurl = "http://localhost:8080/Yam/goodsimg/" + goodsimg ;
				      System.out.println("上传文件成功！");
				      String json1 = "{\"imgurl\":" + "\"" + jsonimgurl + "\"" + "," + "\"status\":" + "\"" + "上传图片成功" + "\"" + "," + "\"uploadPath\":" + "\"" + imgurl + "\"" + "}";
				      //			   "{\"imgurl\":" + "\"" + jsonimgurl + "\"" + "," + "\"status\":" + "\"" + "上传图片成功" + "\"" + "," + "\"uploadPath\":" + "\"" + imgurl + "\"" + "}";
				      out.write(json1);
			      }
			      else {
			    	  System.out.println("上传的不是图片");
			    	  String json2 = "{\"imgurl\":" + "\"" + "null" + "\"" + "," + "\"status\":" + "\"" + "请上传正确的图片格式" + "\"" + "}";
				      out.write(json2);
			      }
		//上传文件的保存路径
			     }else{
			    	 System.out.println("没有选择上传文件！");
			     }
			    }
			   }
			  }catch(FileUploadException e){
			   e.printStackTrace();
			  } catch (Exception e) {
			   e.printStackTrace();
			   System.out.print("上传文件失败！");
			   String json3 = "{'statue':2" + "}";
			   out.write(json3);
			  }
	  }else{
		  String goodsname = request.getParameter("goodsname");
		  String property1 = request.getParameter("property1");
		  int price = Integer.parseInt(request.getParameter("price"));
		  String desc = request.getParameter("desc");
		  Date date  = new Date();
		  
		  Goods goods = new Goods();
		  goods.setImgurl(imgurl);
		  goods.setInfo(desc);
		  goods.setName(goodsname);
		  goods.setPrice(price);
		  goods.setType(property1);
		  goods.setUptime(date);
System.out.println("iii"+imgurl);
		  boolean flag = new AdminDao().upGoods(goods);
		  if(flag){
			  String str = "true";
			  response.setContentType("text/html;charset=UTF-8");
			  out.write(str);
		  }
		  else{
			  String str = "false";
			  response.setContentType("text/html;charset=UTF-8");
			  out.write(str);
		  }
	  }
		  
	 }
	
}
