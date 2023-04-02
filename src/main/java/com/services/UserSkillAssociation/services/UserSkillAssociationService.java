package com.services.UserSkillAssociation.services;


import com.services.UserSkillAssociation.entity.UserSkillAssociationEntity;
import com.services.UserSkillAssociation.repositories.UserSkillAssociationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillAssociationService {
    @Autowired
    UserSkillAssociationRepo _userSkillAssociationRepo;

    public ResponseEntity<List<UserSkillAssociationEntity>> getAllAssociations(){
        return ResponseEntity.ok().body(_userSkillAssociationRepo.findAll());
    }

    public ResponseEntity getAssociation(int id){
        return ResponseEntity.ok().body(_userSkillAssociationRepo.findById(id));
    }

    public ResponseEntity addUSAs(String email, String skill) {
        try {
            if(!(_userSkillAssociationRepo.existsByUserEmailOrSkill(email, skill))){
            UserSkillAssociationEntity usae = new UserSkillAssociationEntity(email, skill);
            _userSkillAssociationRepo.save(usae);
            return ResponseEntity.ok().body("Successfully added the association");}
            else return ResponseEntity.ok().body("Association already exists");

        } catch (Exception e) {
            throw new RuntimeException("Erro whilst adding the user, here are the details:" + e);
        }
    }
    public ResponseEntity deleteUSAs(int id){
        try{
            _userSkillAssociationRepo.deleteById(id);
            return ResponseEntity.ok().body("Successfully deleted the association");
        }catch (Exception e){
            throw new RuntimeException("Error while deleting the association, here are the details:" + e);
        }
    }

    public ResponseEntity updateUSAs(UserSkillAssociationEntity usae){
        try{
            _userSkillAssociationRepo.save(usae);
            return ResponseEntity.ok().body("Successfully updated the association");
        }catch (Exception e){
            throw new RuntimeException("Error while updating the association, here are the details:" + e);
        }
    }



}
