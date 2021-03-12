package kr.or.ddit.member.main;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

/*
 - 회원을 관리하는 프로그램을 작성하시오.
 (오라클 DB의 MYMEMBER 테이블 이용)
 (회원 ID를 암호화 시켜서 DB에 저장하고, 화면에 보여줄 떄는 원래의 데이터로 복호화시켜서 보여준다.)

 - 아래 메뉴의 기능을 모두 구현하시오(CRUD 구현하기 연습)
 create read update delete

 - 작업선택 - 
 1. 자료추가
 2. 자료 삭제
 3. 자료 수정
 4. 전체 자료 출력
 0. 작업 끝
 ------------
 작업선택>>

 */
public class MemberController {

	Scanner s = new Scanner(System.in);
	MemberServiceImpl service = MemberServiceImpl.getInstance();
	private final String key = "zcxvbndlwo14adsasd6";

	public static void main(String[] args) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		// Controller는 Service 객체를 사용하기 떄문에Service변수가 필요하다.
		MemberController mc = new MemberController();

		mc.start();
	}

	void start() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		while (true) {
			System.out.println(" - 작업선택 - ");
			System.out.println(" 1. 자료추가");
			System.out.println(" 2. 자료 삭제");
			System.out.println(" 3. 자료 수정");
			System.out.println(" 4. 전체 자료 출력");
			System.out.println(" 5. 선택 수정");
			System.out.println(" 0. 작업 끝");
			System.out.println(" ------------");
			System.out.print(" 작업선택>>");
			String input = s.next();
			switch (input) {

			case "1":
				create();
				break;
			case "2":
				delete();
				break;
			case "3":
				update();
				break;
			case "4":
				read();
				break;
			case "5":
				updatePart();
				break;
			case "0":
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	private void updatePart() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String mem_id = "";
		do {
			System.out.println("수정할 회원 아이디를 입력하세요");
			mem_id = s.next();
			mem_id = encryptAES256(mem_id, key);
			if (service.getMemberCount(mem_id) != 1)
				System.out.println("존재하지 않는 회원 id입니다.");
		} while (service.getMemberCount(mem_id) != 1);

		String sql = "Update mymember Set ";
		System.out.println("수정할 항목을 고르세요.");
		System.out.println("1. 회원 이름");
		System.out.println("2. 회원 전화번호");
		System.out.println("3. 회원 주소");
		String input = s.next();
		String q = "";
		String updateField = "";
		switch (input) {
		case "1":
			updateField = "mem_name";
			q = "회원 이름을";
			break;
		case "2":
			updateField = "mem_tel";
			q = "회원 전화번호를";
			break;
		case "3":
			updateField = "mem_addr";
			q = "회원 주소를";
			break;
		}
		System.out.println(input);
		System.out.println("수정할 " + q + "입력하세요");
		s.nextLine();
		String ins = s.nextLine();

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("memid", mem_id);
		paramMap.put("field", updateField);
		paramMap.put("data", ins);

		int cnt = service.updatePartMember(paramMap);

		if (cnt == 1)
			System.out.println("정상적으로 수정되었습니다.");
		else
			System.out.println("수정에 실패했습니다.");
	}

	private void create() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String mem_id = "";
		do {
			System.out.println("추가할 회원 아이디를 입력하세요");
			mem_id = s.next();
			if (service.getMemberCount(mem_id) > 0)
				System.out.println("이미 존재하는 회원입니다.");
		} while (service.getMemberCount(mem_id) != 0);

		System.out.println("추가할 회원 이름을  입력하세요");
		String mem_name = s.next();
		System.out.println("추가할 회원 전화번호를  입력하세요");
		String mem_tel = s.next();
		s.nextLine();
		System.out.println("추가할 회원 주소를  입력하세요");
		String mem_addr = s.nextLine();

		
		mem_id = encryptAES256(mem_id, key);
		
		MemberVO memVo = new MemberVO();
		
		memVo.setMem_id(mem_id);
		memVo.setMem_name(mem_name);
		memVo.setMem_tel(mem_tel);
		memVo.setMem_addr(mem_addr);

		int cnt = service.insertMember(memVo);

		if (cnt == 1)
			System.out.println("정상적으로 추가되었습니다.");
		else
			System.out.println("추가에 실패했습니다.");
	}

	private void read() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		if (service.getAllMember() == null /* 오류가 난 경우 */
				| service.getAllMember().size() == 0 /* 데이터가 없는 경우 */) {
			System.out.println("등록된 회원이 없습니다.");
		} else {

			System.out.println("===============전체 멤버 목록=============");
			System.out.println("ID\tNAME\tTEL\t\tADDRESS");

			for (MemberVO mem : service.getAllMember()) {
				System.out.print(decryptAES256(mem.getMem_id(),key) + "\t" + mem.getMem_name()
						+ "\t" + mem.getMem_tel() + "\t" + mem.getMem_addr()
						+ "\n");
			}
			System.out.println("======================================");

		}
	}

	private void update() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String mem_id = "";
		do {
			System.out.println("수정할 회원 아이디를 입력하세요");
			mem_id = s.next();
			mem_id = encryptAES256(mem_id, key);
			if (service.getMemberCount(mem_id) != 1)
				System.out.println("존재하지 않는 회원 id입니다.");
		} while (service.getMemberCount(mem_id) != 1);

		System.out.println("수정할 회원 이름을  입력하세요");
		String mem_name = s.next();
		System.out.println("수정할 회원 전화번호를  입력하세요");
		String mem_tel = s.next();
		System.out.println("수정할 회원 주소를  입력하세요");
		String mem_addr = s.next();

		mem_id = encryptAES256(mem_id, key);
		
		MemberVO mem = new MemberVO();
		mem.setMem_id(mem_id);
		mem.setMem_name(mem_name);
		mem.setMem_tel(mem_tel);
		mem.setMem_addr(mem_addr);

		int cnt = service.updateMember(mem);

		if (cnt == 1)
			System.out.println("정상적으로 수정되었습니다.");
		else
			System.out.println("수정에 실패했습니다.");

	}

	private void delete() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String mem_id = "";
		do {
			System.out.println("삭제할 회원 아이디를 입력하세요");
			mem_id = s.next();
			mem_id = encryptAES256(mem_id, key);
			
			if (service.getMemberCount(mem_id) != 1)
				System.out.println("존재하지 않는 회원 id입니다.");
		} while (service.getMemberCount(mem_id) != 1);

		int cnt = service.deleteMember(mem_id);
		if (cnt == 1)
			System.out.println("정상적으로 삭제되었습니다.");
		else
			System.out.println("삭제에 실패했습니다.");
	}

	private static String encryptAES256(String str, String key)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String iv = key.substring(0, 16);
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = keyBytes.length; // =16

		// b의 0번째에 keyBytes의 0번째값을 len만큼 복사
		System.arraycopy(b, 0, keyBytes, 0, len);

		// 비밀키 생성
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		// Cipher객체 생성 및 초기화
		// 알고리즘/모드/패딩
		// CBC > Cipher Block Chaining Mode
		// 동일한 평문 블록과 암호문의 블록의 쌍이 발생하지 않도록 이전 단계의 암복호화한 결과가 현 단계에 영향을 주는 운영 모드
		// Padding : 마지막 블록이 블록의 기링와 항상 딱 맞아 떨어지지 않기 때문에 부족한 만큼을 0으로 채우거나 임의의 비트로 채워넣는 것
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

		byte[] ivBytes = new byte[16];

		// b의 0번째에 keyBytes의 0번째값을 len만큼 복사
		System.arraycopy(iv.getBytes(), 0, ivBytes, 0, ivBytes.length);

		// 옵션 종류에 맞게 초기화한다.
		// 옵션 종류 : ENCRYPT_MODE(암호화모드), DECRYPT_MODE(복호화모드)
		
		// 초기화 벡터(Initial Vector, IV)
		// 암호문이 패턴화 되지 않도록 사용하는 데이터
		// 첫 블록을 암호화할 떄 사용하는 값
		c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivBytes));

		// 암호문 생성
		byte[] encryped = c.doFinal(str.getBytes("UTF-8"));

		String enStr = Base64.getEncoder().encodeToString(encryped);

		return enStr;
	}
	
	/**
	 * encryptAES256()메서드로 암호화한 내용을 복호화하는 메서드
	 * @param str 복호화할 문자열
	 * @param key 암호키 문자열
	 * @return 복호화된 문자열(원본 문자열)
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static String decryptAES256(String str, String key) 
		throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
		InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
	String iv = key.substring(0, 16);
	byte[] keyBytes = new byte[16];
	byte[] b = key.getBytes("UTF-8");
	int len = keyBytes.length; // =16

	// b의 0번째에 keyBytes의 0번째값을 len만큼 복사
	System.arraycopy(b, 0, keyBytes, 0, len);

	// 비밀키 생성
	SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

	// Cipher객체 생성 및 초기화
	// 알고리즘/모드/패딩
	// CBC > Cipher Block Chaining Mode
	// 동일한 평문 블록과 암호문의 블록의 쌍이 발생하지 않도록 이전 단계의 암복호화한 결과가 현 단계에 영향을 주는 운영 모드
	// Padding : 마지막 블록이 블록의 기링와 항상 딱 맞아 떨어지지 않기 때문에 부족한 만큼을 0으로 채우거나 임의의 비트로 채워넣는 것
	Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

	byte[] ivBytes = new byte[16];

	// b의 0번째에 keyBytes의 0번째값을 len만큼 복사
	System.arraycopy(iv.getBytes(), 0, ivBytes, 0, ivBytes.length);

	// 옵션 종류에 맞게 초기화한다.
	// 옵션 종류 : ENCRYPT_MODE(암호화모드), DECRYPT_MODE(복호화모드)
	
	// 초기화 벡터(Initial Vector, IV)
	// 암호문이 패턴화 되지 않도록 사용하는 데이터
	// 첫 블록을 암호화할 떄 사용하는 값
	c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(ivBytes));
	
	// 복호화할 문자열 decoding해서 암호화된 byte배열을 구한다.
	byte[] byteStr = Base64.getDecoder().decode(str);

	//복호화된 데이터를 문자열로 변환하여 반환한다.
	return new String(c.doFinal(byteStr), "UTF-8");
	
	
	}
}
