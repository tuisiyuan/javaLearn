package com.mashibing.mapper;

import com.mashibing.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<Account> listAll();

}
