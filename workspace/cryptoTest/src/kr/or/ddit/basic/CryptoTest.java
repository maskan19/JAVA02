package kr.or.ddit.basic;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {

	private static final String key = "wer456we4r56w456e";// 16글자 이상, 16자만 사용, 16자보다 짧은 경우 오류
	public static void main(String[] args)
			throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String plainText = "AFWQAEQF";

//		String key = "wer456we4r56w456e";// 16글자 이상, 16자만 사용, 16자보다 짧은 경우 오류

		System.out.println("MD5 : " + CryptoUtil.md5(plainText));
		System.out.println("SHA-256 : " + CryptoUtil.sha256(plainText));
		System.out.println("SHA-512 : " + CryptoUtil.sha512(plainText));

		String result = CryptoUtil.encryptAES256(plainText, key);
		String result2 = CryptoUtil.decryptAES256(result, key);
		System.out.println("원본 데이터 : " + plainText); //AFWQAEQF
		System.out.println("암호화된 데이터 : " + result); //D6tfypaINAzxpxEh2zSaVg==
		System.out.println("복호화된 데이터 : " + result2); //AFWQAEQF

	
	}

}
