package org.demo.test.account;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class TestAccountService{

	private AccountManager mockAccountManager; // mock�Ķ��󡣺���EasyMock���ֻ��mock�ӿڶ���
	private AccountService accountService;
	
	@Before
	public void setUp(){
		// ����createMock������������һ��mock��ģ��AccountManager
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
		// ʹ��EasyMock��������������Ԥ�ڵķ���
		// �������ķ���ֵ����Ϊvoid�����Ǿ���mock objict�ϵ��ô˷���
		mockAccountManager.updateAccount(senderAccount);
		mockAccountManager.updateAccount(beneficiaryAccount);
		
		// �����������κ����͵Ķ���������Ҫʹ��EasyMock API�е�expect��andReturn����
		expect(mockAccountManager.findAccountForUser("1"))
									.andReturn(senderAccount);
		expect(mockAccountManager.findAccountForUser("2"))
									.andReturn(beneficiaryAccount);
		
		// We're done defining the expectation
		// ��Ҫ����replay������������
		replay(mockAccountManager);
		
		
		accountService.transfer("1", "2",  50);
		
		assertEquals(150, senderAccount.getBalance());
		assertEquals(150, beneficiaryAccount.getBalance());	
	}

	
/*	@After
	// ʹ��EasyMock�����ǿ���ͨ���κ�mock object������verify������
	// ����֤���������ķ�������Ԥ�ڱ�������
	public void tearDown(){
		verify(mockAccountManager);
	}
*/
}
