<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<% 
	//洗牌
	boolean[] check = new boolean[52];	// 0 - 51: false
	int[] poker = new int[52]; // 0- 51: 0
	int temp; int counter=0;
	for (int i=0; i<52; i++){
		do{
			temp = (int)(Math.random()*52);
			counter++;
		}while (check[temp]);
		
		poker[i] = temp;
		check[temp] = true;
		//System.out.println(temp);
	}
	// 發牌 => 四個玩家 => 每家有13張
	int[][] player = new int[4][13];
	for (int i=0; i<poker.length; i++){
		player[i%4][i/4] = poker[i];
	}
	String[] suits = {
			//用span來設定顏色
			"<span style='color:black'>&spades;",
			"<span style='color:red'>&hearts;",
			"<span style='color:red'>&diams;",
			"<span style='color:black'>&clubs;"};
	String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K "}; // values[0]

%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table.items{
    font-color:red;
}
table.items>tr>td{
    font-color:red;
}
</style>
</head>
<body>

<table border='1' width='100%'>
	<tr>
	<%	
		for (int[] cards : player){
			out.print("<tr>");
			Arrays.sort(cards);
			for (int card : cards){
				out.print("<td>");
				out.print(suits[card/13] + values[card%13] +" ");
				out.print("</span></td>");//尾巴要包</span>
			}
			out.print("</tr>");
		}
	%>
	</tr>
</table>
</body>
</html>