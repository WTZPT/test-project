package org.demo.test.account;

public interface AccountManager {
	Account findAccountForUser(String userId); // ����id�����˻�
	void updateAccount(Account account); // �������ݿ��е��˻���Ϣ
}
