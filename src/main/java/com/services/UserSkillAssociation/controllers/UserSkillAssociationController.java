package com.services.UserSkillAssociation.controllers;

import com.services.UserSkillAssociation.RESTapi.RequestingFromSkillsMS;
import com.services.UserSkillAssociation.entity.UserSkillAssociationEntity;
import com.services.UserSkillAssociation.services.UserSkillAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@ResponseBody
@RequestMapping("/api/v1/association")
public class UserSkillAssociationController {
    @Autowired
    UserSkillAssociationService _userSkillAssociationService;
    @Autowired
    RequestingFromSkillsMS _requestingFromSkillsMS;

    @PostMapping("/VerifySkill")
    public boolean verifySkill(@RequestBody Map<String, String> skill){
        return _requestingFromSkillsMS.existsBySkill(skill.get("skill"));
    }
    @GetMapping("/getAssociation")
    public ResponseEntity<List<UserSkillAssociationEntity>> get(){
        return _userSkillAssociationService.getAllAssociations();
    }

    @PostMapping("/addAssociation")
    public ResponseEntity post(@RequestBody UserSkillAssociationEntity userSkillAssociationEntity){
        return _userSkillAssociationService.addUSAs(userSkillAssociationEntity);
    }

       @DeleteMapping("/deleteAssociation/{id}")
    public ResponseEntity delete(@PathVariable int id){
        return _userSkillAssociationService.deleteUSAs(id);}

    @PutMapping("/updateAssociation")
    public ResponseEntity update(@RequestBody UserSkillAssociationEntity userSkillAssociationEntity){
        return _userSkillAssociationService.updateUSAs(userSkillAssociationEntity);
    }
}

