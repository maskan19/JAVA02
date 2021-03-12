package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 문제) 10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
 * 말은  Horse라는 이름의 쓰레드 클래스로 작성하는데 이 클래스는 
 * 말 이름(String), 등수(int), 현재위치값(int)을 멤버 변수로 갖는다.
 * 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.(Comparable 인터페이스 구현)
 * 경기 구간은 1~50 구간으로 되어 있다.
 * 
 * 경기가 진행되는 중간 중간에 각각의 말들의 위치를 아래와 같이 나타내시오.
 * 예시)
 * 01번말 : -->------------------
 * 02번말 : ----->---------------
 * :
 * 10번말 : ---->----------------
 * 
 * 경기가 끝나면 등수 순으로 출력한다.
 * 
 */
public class ThreadTest12 {
	public static boolean goal = false;
	public static int horserank = 0;

	public static void main(String[] args) {

		List<Thread> race = new ArrayList<>();
		List<Horse> horses = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			Horse h1 = new Horse(i);
			Thread th1 = new Thread(h1);
			horses.add(h1);
			race.add(th1);
			/* th1.start(); */}
		for (int i = 1; i <= 10; i++) {
			race.get(i - 1).start();
		}

		while (horserank<10) {
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.print(horses.get(i - 1).horsename + " : ");
					for (int j = 1; j <= 50; j++) {
						if (horses.get(i - 1).location == j) {
							System.out.print(">");
						} else
							System.out.print("-");
					}
					System.out.println();
				}
				Thread.sleep(200);
				System.out.println();
			} catch (Exception e) {

			}
			System.out.println();

		}

		Collections.sort(horses);
		int i = 1;
		for (Horse rn : horses) {
			System.out.format("%02d등  : " + rn.horsename, i);
			i++;
			System.out.println();
		}

	}

}

class Horse implements Comparable<Horse>, Runnable {

	String horsename;
	int rank;
	int location;

	public String getHorsename() {
		return horsename;
	}

	public void setHorsename(String horsename) {
		this.horsename = horsename;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Horse [horsename=" + horsename + ", rank=" + rank
				+ ", location=" + location + "]";
	}

	public Horse(int horsenum) {
		this.horsename = String.format("%02d번말", horsenum);
		this.rank = 1;
		this.location = 1;
	}

	@Override
	public int compareTo(Horse h) {
		return new Integer(rank).compareTo(h.rank);
	}

	@Override
	public void run() {

		try {
			while (true) {
				Thread.sleep((int) (Math.random() * 7 * 200));
				this.location++;
				if(location >50){
					ThreadTest12.horserank++;
//					ThreadTest12.goal = true;
					this.rank =ThreadTest12.horserank;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
