package tw.ed.j2ee;

public class Brad21 {
	private int x, y, op;
	
	public Brad21(String x, String y, String op) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		this.op = Integer.parseInt(op);
	}
	public int cal() {
		int res = 0;
		switch (op) {
			case 1:res = x + y;break;
			case 2:res = x - y;break;
			case 3:res = x * y;break;
			case 4:res = x / y;break;
		}
		return res;
	}
}
