package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientInitialAmountException;
	
	int deposit(int accountNumber, int amount) throws InvalidAccountNumberException;
	int withdraw(int accountNumber, int amount) throws InvalidAccountNumberException,InsufficientBalanceException;

}