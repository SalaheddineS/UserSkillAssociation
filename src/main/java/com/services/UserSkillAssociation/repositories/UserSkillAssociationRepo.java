package com.services.UserSkillAssociation.repositories;


import com.services.UserSkillAssociation.entity.UserSkillAssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillAssociationRepo extends JpaRepository<UserSkillAssociationEntity, Integer> {
        boolean existsByUserEmailAndSkillId(String userEmail, int skillId);


}
