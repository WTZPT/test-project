package org.demo.test.account;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class TestAccountService{

	private AccountManager mockAccountManager; // mock的对象。核心EasyMock框架只能mock接口对象
	private AccountService accountService;
	
	@Before
	public void setUp(){
		// 调用createMock方法，来创建一个mock来模拟AccountManager
		mockAccountManager = createMock("mockAccountManager", 
				AccountManager.class);	
		accountService = new AccountService();
		accountService.setAccountmanager(mockAccountManager);
		
	}
	
	@Test
	public void testTransferOK() {
		
		Account senderAccount = new Account("1", 200);
		Account beneficiaryAccount = new Account("2", 100);
		
		// Start defining the expectations
		// 使用EasyMock我们有两种声明预期的方法
		// 当方法的返回值类型为void，我们就在mock objict上调用此方法
		mockAccountManager.updateAccount(senderAccount);
		mockAccountManager.updateAccount(beneficiaryAccount);
		
		// 当方法返回任何类型的对象，我们需要使用EasyMock API中的expect和andReturn方法
		expect(mockAccountManager.findAccountForUser("1"))
									.andReturn(senderAccount);
		expect(mockAccountManager.findAccountForUser("2"))
									.andReturn(beneficiaryAccount);
		
		// We're done defining the expectation
		// 需要调用replay方法类声明它
		replay(mockAccountManager);
		
		
		accountService.transfer("1", "2",  50);
		
		assertEquals(150, senderAccount.getBalance());
		assertEquals(150, beneficiaryAccount.getBalance());	
	}

	
/*	@After
	// 使用EasyMock，我们可以通过任何mock object来调用verify方法，
	// 以验证我们声明的方法调用预期被触发了
	public void tearDown(){
		verify(mockAccountManager);
	}
*/
}
