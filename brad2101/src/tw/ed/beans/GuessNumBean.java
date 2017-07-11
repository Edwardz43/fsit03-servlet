package tw.ed.beans;

public class GuessNumBean {
	private String answer, len, result, guess, gameStatus="", hist="";

	public GuessNumBean() {}
	
	public void setLen(String len) {
		this.len = len;
	}
	
	public void setAnswer(String len) {
		answer="";result="";hist="";
		boolean[] check = new boolean[10];
		int[] poker = new int[Integer.parseInt(len)];
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
	
	public void setGuess(String guess) {
		this.guess = guess;
	}
	
	public void setResult(String guess) {
		int A, B; A = B =0;
		String g = this.guess;
		//比對輸入格式  長度  完全正確才繼續
		if(g.matches("^[0-9]{"+answer.length()+"}$")) {
			for (int i =0 ; i < g.length(); i++){
				if(g.charAt(i) == answer.charAt(i) ){
					A++;
				}else if(answer.indexOf(g.charAt(i))!=-1){
					B++;
				}
			}
			result = A + "A" + B + "B";
		}else result = "輸入格式錯誤! 請確認";		
	}
	
	public void setHist(String guess) {
		hist += guess +" : "+ this.result +"<br>";
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public String getLen() {
		return len;
	}
	
	public String getGameStatus() {
		if (this.result != null &&
				this.result.equals(this.len+"A0B")) return "Bingo !";
		return gameStatus;
	}
	
	public String getHist() {
		return hist;
	}
}
