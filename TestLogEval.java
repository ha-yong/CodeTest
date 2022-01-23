package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class Test_LogEval {

	//想定処理時間のチェック
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	//logLevelDebugメソッドのテスト1
	//目的：値チェック
	//assertEqualsの引数①に想定値を入力し、テストを行ってください。
	@Test
	public void testLogLevelDebug() {
		assertEquals("想定値を入力してください", new LogEvaluation().logLevelDebug());
	}
	
	//logParse(String key) のテスト01
	//目的：値チェック
	//assertEqualsの引数①に想定値を入力し、テストを行ってください。
	@Test
	public void testLogParse01() throws IllegalAccessException {
		assertEquals("想定値を入力してください", new LogEvaluation().logParse("default"));
	}

	//logParse(String key) のテスト02
	//目的：値チェック
	//assertEqualsの引数①に想定値を入力し、テストを行ってください。
	@Test
	public void testLogParse02() throws IllegalAccessException {
		assertEquals("想定値を入力してください", new LogEvaluation().logParse("user"));
	}
	
	//logParse(String key) のテスト03
	//目的：DBアクセスの例外チェック
	//assertEqualsの引数①に想定値を入力し、テストを行ってください。
	@Test(expected = IllegalAccessException.class)
	public void testLogParse03() {
		try {
			new LogEvaluation().logParse("user");
		} catch (IllegalAccessException e) {
			assertEquals("Database loading error",e.getMessage());
		}
	}
		
	//logParse(String key) のテスト04
	//目的：想定外の値が入った時の例外チェック
	//assertEqualsの引数①に想定値を入力し、テストを行ってください。
	@Test(expected = IllegalAccessException.class)
	public void testLogParse04() {
		try {
			new LogEvaluation().logParse("test");
		} catch (IllegalAccessException e) {
			assertEquals("Incorrect key",e.getMessage());
		}
	}
	
	//logParse()のテスト
	//目的：値チェック
	//assertEqualsの引数①に想定値を入力し、テストを行ってください。
	@Test
	public void testLogParse() throws IllegalAccessException {
		assertEquals("想定値を入力してください", new LogEvaluation().logParse());
	}
	

	
}
