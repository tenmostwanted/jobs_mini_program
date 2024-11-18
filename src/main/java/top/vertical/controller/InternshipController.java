package top.vertical.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.vertical.common.R;
import top.vertical.pojo.Internship;
import top.vertical.service.InternshipService;

import java.util.List;

@RestController
@RequestMapping("/api/internship")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    // 发布实习信息
    @PostMapping("insertInternship")
    public R<Internship> insertInternship(@RequestBody Internship internship){
        Internship savadInternship = internshipService.insertInternship(internship);
        return R.success(savadInternship);
    }

    // 删除实习信息
    @DeleteMapping("deleteInternship/{id}")
    public R<Internship> deleteInternship(@PathVariable Long id){
       int deleteInternship = internshipService.deleteInternship(id);
       if (deleteInternship != 1)
        return R.error("delete failed");
       return R.success();
    }

    // 修改实习信息
    @PutMapping("updateInternship")
    public R<Internship> updateInternship(@RequestBody Internship internship){
        int updateInternship = internshipService.updateInternship(internship);
        if (updateInternship != 1)
            return R.error("update failed");
        return R.success();
    }

//    //分页展示所有实习咨询 分页未完成
    @GetMapping("getAllInternship")
    public R<List<Internship>> getAllInternship(){
        List<Internship> internship = internshipService.getAllInternships();
        return R.success(internship);
    }


    // 查询实习咨询by ID
    @GetMapping("getInternshipDetails/{id}")
    public R<Internship> getInternshipDetailsById(@PathVariable Long id) {
        Internship internshipDetails = internshipService.getInternshipById(id);
        if (internshipDetails == null)
            return R.error("id not found");
        return R.success(internshipDetails);
        }





    // 按类型筛选实习信息
    @GetMapping("/filterByType")
    public R<List<Internship>> filterInternshipsByType(@RequestParam String CompanyType) {
        List<Internship> internships = internshipService.getInternshipsByType(CompanyType);
        return R.success(internships);
    }

    // 按关键词搜索实习信息
    @GetMapping("/search")
    public R<List<Internship>> searchInternships(@RequestParam String keyword) {
        List<Internship> internships = internshipService.searchInternships(keyword);
        return R.success(internships);
    }



}




