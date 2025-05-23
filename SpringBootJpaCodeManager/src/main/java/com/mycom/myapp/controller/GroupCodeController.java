package com.mycom.myapp.controller;

import com.mycom.myapp.dto.CodeResultDto;
import com.mycom.myapp.dto.GroupCodeDto;
import com.mycom.myapp.entity.GroupCode;
import com.mycom.myapp.service.GroupCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GroupCodeController {

    private final GroupCodeService groupCodeService;

    // 페이징된 목록
    @GetMapping("/groupcodes")
    public CodeResultDto listGroupCode(
            @RequestParam("pageNumber") int pageNumber,
            @RequestParam("pageSize") int pageSize){
        return groupCodeService.listGroupCode(pageNumber, pageSize);
    }

    // 상세
    @GetMapping("/groupcodes/{groupCode}")
    public CodeResultDto detailGroupCode(@PathVariable("groupCode") String groupCode){
        return groupCodeService.detailGroupCode(groupCode);
    }

    // 등록
    @PostMapping("/groupcodes")
    public CodeResultDto insertGroupCode(GroupCode groupCode){ // 이 부분은 dto로 받아서 엔티티로 전환하는 방식으로 사용하는것도 가능(좀더체계적)
        return groupCodeService.insertGroupCode(groupCode);
    }

    // 수정
    @PutMapping("/groupcodes")
    public CodeResultDto updateGroupCode(GroupCode groupCode){
        return groupCodeService.updateGroupCode(groupCode);
    }

    // 삭제
    @DeleteMapping("/groupcodes/{groupCode}")
    public CodeResultDto deleteGroupCode(@PathVariable("groupCode") String groupCode){
        return groupCodeService.deleteGroupCode(groupCode);
    }

    // count
    @GetMapping("/groupcodes/count")
    public CodeResultDto countGroupCode(){
        return groupCodeService.countGroupCode();
    }

}