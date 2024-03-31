package com.myrepo.mybanking.services.Implementation;

import com.myrepo.mybanking.models.BankAccount;
import com.myrepo.mybanking.repositories.BankAccountRepository;
import com.myrepo.mybanking.services.BankAccountService;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;

    @Override
    public void saveBankAccount(BankAccount bankAccount) {

        bankAccountRepository.save(bankAccount);
    }

}
