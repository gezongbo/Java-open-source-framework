<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  
    This is my JSP page. <br>
    <!-- 表单 -->
    <!-- 
    <form action="my02/test03_6_3.action" method="get">
                     姓名：<input type="text" name="name"/>  <br/>
    	年龄：<input type="text" name="age"/>   <br/>
    	兴趣爱好：
    	篮球<input type="checkbox" name="like" value="lq"/>
    	足球<input type="checkbox" name="like" value="zq"/>
    	读书<input type="checkbox" name="like" value="ds"/>
    	<br/>
    	小狗的名字：<input type="text" name="dname"/>   <br/>
    	小狗的年龄：<input type="text" name="dage"/>  <br/>
    	<input type="submit" value="提交"/>
     </form>
     -->
      <form action="my02/test04.action" method="post">
                     姓名：<input type="text" name="name"/>  <br/>
    	年龄：<input type="text" name="age"/>   <br/>
    	兴趣爱好：
    	篮球<input type="checkbox" name="like" value="lq"/>
    	足球<input type="checkbox" name="like" value="zq"/>
    	读书<input type="checkbox" name="like" value="ds"/>
    	<br/>
    	小狗的名字：<input type="text" name="dog.dname"/>   <br/>
    	小狗的年龄：<input type="text" name="dog.dage"/>  <br/>
    	<input type="submit" value="提交"/>
      </form>
  </body>
</html>
