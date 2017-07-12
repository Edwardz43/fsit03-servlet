package tw.ed.beans;

import java.io.Serializable;

public class GuessNumModel implements Serializable{
	private String answer;
	private int len;
	public GuessNumModel() {}
	
	public void setLen(int len) {
		this.len = len;
	}
	
	public void setAnswer(int len) {
		answer="";
		this.len = len;
		boolean[] check = new boolean[10];
		int[] poker = new int[len];
		int temp;
		for(int i=0;i<poker.length;i++){
			do{
				temp = (int)(Math.random()*10);
			}while(check[temp]);
			
			poker[i] = temp;
			check[temp]=true;
		}
		StringBuffer ret = new StringBuffer();
		for(int v :poker) ret = ret.append(v);
		answer =  ret.toString();
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public int getLen() {
		return len;
	}
	
	public String getResult(String g) {
		int A, B; A = B =0;
		//比對輸入格式  長度  完全正確才繼續
		if(g.matches("^[0-9]{"+len+"}$")) {
			for (int i =0 ; i < g.length(); i++){
				if(g.charAt(i) == answer.charAt(i) ){
					A++;
				}else if(answer.indexOf(g.charAt(i))!=-1){
					B++;
				}
			}
		}else return "輸入格式錯誤! 請確認";		
		return A + "A" + B + "B";
	}
}
