package com.myrepo.mybanking.services.Implementation;

import com.myrepo.mybanking.exceptions.NotFoundException;
import com.myrepo.mybanking.models.BankUser;
import com.myrepo.mybanking.repositories.BankUserRepository;
import com.myrepo.mybanking.services.BankUserService;
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
}
