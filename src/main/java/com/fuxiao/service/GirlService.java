package com.fuxiao.service;

import com.fuxiao.enums.ResultEnum;
import com.fuxiao.exception.GirlException;
import com.fuxiao.repository.GirlRepository;
import com.fuxiao.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("C");
        girlA.setAge(21);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("A");
        girlB.setAge(27);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();

        if (age < 10) {
            //你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 根据id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl getOne(Integer id) {
        return girlRepository.getOne(id);
    }
}
