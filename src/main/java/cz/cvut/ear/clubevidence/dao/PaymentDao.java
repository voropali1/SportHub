package cz.cvut.ear.clubevidence.dao;

import cz.cvut.ear.clubevidence.model.Payment;
import org.springframework.stereotype.Repository;


@Repository
public class PaymentDao extends BaseDao<Payment>{
    public PaymentDao(){
        super(Payment.class);
    }

}
