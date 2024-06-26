package com.myrepo.mybanking.services.Implementation;

import com.myrepo.mybanking.exceptions.NotFoundException;
import com.myrepo.mybanking.models.BankAccount;
import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.repositories.BankUserRepository;
import com.myrepo.mybanking.services.BankUserService;
import com.myrepo.mybanking.utils.PasswordHashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankUserServiceImpl implements BankUserService {
    private final BankUserRepository bankUserRepository;

    @Override
    public Optional<BankUser> findById(Long id) {
        if (id == null || id < 0) {
//            throw new NotFoundException("Id was not found.");
            return Optional.empty();
        } else {
            return bankUserRepository.findById(id);
        }
    }

    @Override
    public void saveBankUser(BankUser bankUser) {
        bankUserRepository.save(bankUser);
    }

    @Override
    public void hashBankUserPassword(BankUser bankUser) {

        String pw = bankUser.getPassword();

        PasswordHashUtil passwordHashUtil = new PasswordHashUtil();
        String hashedPw = passwordHashUtil.createHash(pw);

        bankUser.setPassword(hashedPw);
        bankUser.setConfirmpassword(hashedPw);

        saveBankUser(bankUser);
    }



    @Override
    public Optional<BankUser> findByUsername(String username) {

        return bankUserRepository.findByUsername(username);

    }

    public boolean isUserTableEmpty(){
        return !bankUserRepository.findAll().isEmpty();
    }

    @Override
    public boolean validateHash(BankUser bankUser, String password) {

        String hash = bankUser.getPassword();

        PasswordHashUtil pwHashUtil = new PasswordHashUtil();

        return pwHashUtil.verifyHash(hash,password);
    }

    @Override
    public Integer numberOfAccounts(BankUser bankUser) {

        return bankUser.getBankAccountList().size();
    }

    @Override
    public Integer totalBalance(BankUser bankUser) {
        int total = 0;
        for (BankAccount acc : bankUser.getBankAccountList()){
            total += acc.getAccountBalance();
        }
        return total;
    }


}
