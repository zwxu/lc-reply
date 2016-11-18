package com.ustc.zwxu.lc.reply.web.controller.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class StringTest { 
	private int id;
	public void func(String str1, String str2) {
					int i = 1;
				if("Hello World!".equals(str1)) {
					i = str1.indexOf("World");
				}
				if(i > 0) {
						if(str2.equals("Hello World!")) {
							i = str2.indexOf(str1);
						}
					}
				System.out.println(i);
			}

    public static void main(String args[]) { 
    	String haha="year";
    	haha=haha+4.05+"%";
        System.out.println("转换后的时间为：" + haha);
    	String query_sql = "select a.ID from t_plan_execute as a where a.STATUS='F' and TIMESTAMPDIFF(hour,a.UPDATE_TIME,now()) =1 and a.UPDATE_TIME <= CONCAT(curdate(),' ','21:00:00') "
    			+ "and (SELECT b.STATUS from t_plan as b where b.ID=a.PLAN_ID) = 'I' order by ID limit 20";
    	System.out.println(query_sql); 
    	StringTest demo=new StringTest();
    	demo.func(null, null);
        //在池中和堆中分别创建String对象"abc",s1指向堆中对象 
        String s1 = new String("abc"); 
        //s2直接指向池中对象"abc" 
        String s2 = "abc"; 
        //在堆中新创建"abc"对象，s3指向该对象 
        String s3 = new String("abc"); 
        //在池中创建对象"ab" 和 "c"，并且s4指向池中对象"abc" 
        String s4 = "ab" + "c"; 
        //c指向池中对象"c" 
        String c = "c"; 
        //在堆中创建新的对象"abc"，并且s5指向该对象 
        String s5 = "ab" + c; 
        

        String s6 = "ab".concat("c"); 
        String s7 = "ab".concat(c); 
        //s8指向池中对象"c" 
        String s8 = "ab";
      //在堆中创建新的对象"abc"，并且s8指向该对象 
        s8 += "c";

        System.out.println("------------实串-----------"); 
        System.out.println(s1 == s2); //false 
        System.out.println(s1 == s3); //false 
        System.out.println(s2 == s3); //false 
        System.out.println(s2 == s4); //true 
        System.out.println(s2 == s5); //false 
        System.out.println(s2 == s6); //false 
        System.out.println(s2 == s8); //false 
        System.out.println(s5 == s8); //false 

        String b1 = new String(""); 
        String b2 = ""; 
        String b3 = new String(""); 
        String b4 = "".intern(); 
        String b5 = "" + ""; 
        String b6 = "".concat(""); 
        String b7 = "  ".trim(); 
        String b8 = "  "; 
        String b9 = "    ".trim(); 

        System.out.println("------------空串-----------"); 
        System.out.println(b1 == b2);  //false 
        System.out.println(b1 == b3);  //false 
        System.out.println(b2 == b3);  //false 
        System.out.println(b2 == b4);  //true 
        System.out.println(b2 == b5);  //true* 
        System.out.println(b2 == b6);  //true* 
        System.out.println(b2 == b7);  //false* 
        System.out.println("-----a----"); 
        System.out.println(b2.equals(b7));  //true 
        System.out.println(b7 == b8);  //false 
        System.out.println(b7 == b9);  //false 
        System.out.println(b7.equals(b9)); //true 
        System.out.println(b9 == null);//false 

        System.out.println("b8.trim():"); 
        for (byte b : b8.getBytes()) { 
            System.out.print(">>>" + (int) b + " "); 
        } 
        System.out.println("\nb8.trim():"); 
        for (byte b : b8.trim().getBytes()) { 
            System.out.print(">>>" + (int) b + " "); 
        } 
        System.out.println("\nb9.trim():"); 
        for (byte b : b9.trim().getBytes()) { 
            System.out.print(">>>" + (int) b + " "); 
        } 
    } 
}
