package com.jpmc.midascore.repository;

import com.jpmc.midascore.entity.UserRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecordRepository extends CrudRepository<UserRecord, Long> {

    // ✅ This will let Spring Data JPA auto-generate the query!
    UserRecord findByName(String name);

}
