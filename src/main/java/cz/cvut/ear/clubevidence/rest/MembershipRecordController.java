package cz.cvut.ear.clubevidence.rest;

import cz.cvut.ear.clubevidence.model.CompetitionRecord;
import cz.cvut.ear.clubevidence.model.MembershipRecord;
import cz.cvut.ear.clubevidence.service.MembershipRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/rest/membership_records")
public class MembershipRecordController {
    MembershipRecordService membershipRecordService;
    @Autowired
    public MembershipRecordController(MembershipRecordService membershipRecordService){
        this.membershipRecordService = membershipRecordService;
    }

    @GetMapping(value = "/membership/{membershipId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MembershipRecord findMembershipById(@PathVariable Integer membershipId) {
        return membershipRecordService.findById(membershipId);
    }
}
