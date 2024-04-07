package com.myrepo.mybanking.services.Implementation;

import com.myrepo.mybanking.models.BankAccount;
import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.repositories.BankAccountRepository;
import com.myrepo.mybanking.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;


    @Override
    public void saveBankAccount(BankAccount bankAccount) {

        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void setupBankAccount(BankUser bankUser) {

        BankAccount bankAccount = new BankAccount();
        bankAccountRepository.save(bankAccount);

        startBankAccount(bankUser, bankAccount);
    }
    public void startBankAccount(BankUser bankUser, BankAccount bankAccount){
        bankAccount.startAccount(bankUser);

        bankAccountRepository.save(bankAccount);
    }

    public void createBankAccount(BankUser bankUser, String accountName) {

        BankAccount bankAccount = new BankAccount();
        bankAccountRepository.save(bankAccount);

        bankAccount.createAccount(bankUser, accountName);
        bankAccountRepository.save(bankAccount);

    }

    @Override
    public void depositBankAccount(BankAccount bankAccount, Integer amount) {

        bankAccount.depositAccount(amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public Optional<BankAccount> findBankAccountByName(String accountName) {
        return bankAccountRepository.findBankAccountByAccountName(accountName);
    }

}
