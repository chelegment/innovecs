package fun.other.innovecs.task.service;

import fun.other.innovecs.task.dao.AccountDao;
import fun.other.innovecs.task.dao.OperationDao;
import fun.other.innovecs.task.to.Operation;

import fun.other.innovecs.task.to.Account.Account;
import fun.other.innovecs.task.to.OperationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static fun.other.innovecs.task.to.OperationStatus.DONE;
import static fun.other.innovecs.task.to.OperationStatus.INCORRECT_AMOUNT;
import static fun.other.innovecs.task.to.OperationStatus.SENT;

@Service

public class AccountService {
    @Autowired
    OperationDao operationDao;

    @Autowired
    AccountDao accountDao;

    /**
     * from - акаунт с которого необходимо списать сумму
     * <p>
     * to - акаунт на которые необходимо зачислить деньги
     * <p>
     * amount - сумма перевода с одного акаунта на другой
     */

    public void transferAmount(Account from, Account to, BigDecimal amount) {
        Operation currentOperation = new Operation(from.getId(), to.getId(), amount, OperationStatus.STARTED);
        operationDao.createOperation(currentOperation);
        if(from.sent(amount)){
            currentOperation.setStatus(SENT);
            operationDao.update(currentOperation);
        } else {
            currentOperation.setStatus(INCORRECT_AMOUNT);
            operationDao.update(currentOperation);
        }
        to.receive(amount);
        currentOperation.setStatus(DONE);
        operationDao.update(currentOperation);
    }
}
