package top.vertical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vertical.common.R;
import top.vertical.mapper.InternshipMapper;
import top.vertical.pojo.Internship;
import java.util.List;

@Service
public class InternshipService {
    @Autowired
    private InternshipMapper internshipMapper;

public Internship insertInternship(Internship internship) {
        // 调用 Mapper 层的插入方法
        int rowsAffected = internshipMapper.insertInternship(internship);
        // 判断插入是否成功
        if (rowsAffected > 0) {
            return internship;
        } else {
            throw new RuntimeException("Failed to insert internship.");
        }
    }
//展示
    public List<Internship> getAllInternships() {
        return internshipMapper.getAllInternships();
    }


//按id查询实习咨询
    public Internship getInternshipById(Long id) {
        return internshipMapper.getInternshipById(id);
    }

//按id删除实习咨询
    public int deleteInternship(Long id) {
        return internshipMapper.deleteInternship(id);
    }

    // 更新实习咨询
    public int updateInternship(Internship internship) {
        return internshipMapper.updateInternship(internship);
    }

// 按公司类型 筛选
    public List<Internship> getInternshipsByType(String companyType) {
    return internshipMapper.getInternshipsByType(companyType);
    }


    // 按关键词 搜索实习咨询

    public List<Internship> searchInternships(String keyword) {
    return internshipMapper.searchInternships(keyword);
    }



}


