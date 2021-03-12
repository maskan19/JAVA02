package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class fortest {

	public static void main(String[] args) {
		List<String> lprod = new ArrayList<String>();
		lprod.add("a");
		lprod.add("b");
		lprod.add("c");
		lprod.add("d");
		int i = lprod.size();
		for (String lp : lprod) {
			i--;
			System.out.print("{" + lp + "}");
			if (i > 0)
				System.out.print(",");
		}
		
	}
}
