package fun.other.innovecs.task.to;

import java.math.BigDecimal;

public class Operation {
    Long from;
    Long to;
    BigDecimal amount;
    OperationStatus status;


    public Operation(Long from, Long to, BigDecimal amount, OperationStatus status) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.status = status;
    }

    public Operation() {
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }
}
