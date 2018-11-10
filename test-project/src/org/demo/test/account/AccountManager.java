package org.demo.test.account;

public interface AccountManager {
	Account findAccountForUser(String userId); // 根据id查找账户
	void updateAccount(Account account); // 更新数据库中的账户信息
}
