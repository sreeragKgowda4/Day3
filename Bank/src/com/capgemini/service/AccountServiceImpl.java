package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(int accountNumber,int amount)throws InsufficientInitialAmountException
	{
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		
		if(accountRepository.save(account))
		{
			return account;
		}
		
		return null;
			}
	
	
	@Override
	public int deposit(int accountNumber, int amount) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub


		
Account account=accountRepository.searchAccount(accountNumber);
		
		if(account==null)
		{
			throw new InvalidAccountNumberException();
		}
		
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}
		
		
		
	
	
	
	
	@Override
	public int withdraw(int accountNumber, int amount) throws InvalidAccountNumberException, InsufficientBalanceException {

		

	Account account = accountRepository.searchAccount(accountNumber);
	
	if(account==null)
	{
		throw new InvalidAccountNumberException();
	}
	
	if((account.getAmount()-amount)>=0)
	{
		account.setAmount(account.getAmount()-amount);
		return account.getAmount();
	}
	
	throw new InsufficientBalanceException();

	
}
	
}
