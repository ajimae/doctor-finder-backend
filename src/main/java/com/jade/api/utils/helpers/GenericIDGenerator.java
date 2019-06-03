package com.jade.api.utils.helpers;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GenericIDGenerator implements IdentifierGenerator {

  public static final String generatorName = "myGenerator";

  @Override
  public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
    return FireBasePushIdGenerator.getFirebaseId();
  }
}
