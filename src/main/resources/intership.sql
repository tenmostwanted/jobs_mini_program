SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE Internships (
                             id bigint AUTO_INCREMENT PRIMARY KEY,
                             company_name VARCHAR(100) NOT NULL,
                             industry VARCHAR(100) Not NULL,
                             company_type VARCHAR(50) not null ,
                             position VARCHAR(100) not null ,
                             location VARCHAR(100) not null,
                             salary DECIMAL(10, 2) not null,
                             description TEXT,
                             requirements TEXT,
                             contact_info VARCHAR(100),
                             posted_by int,  -- 外键关联 Users 表
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             FOREIGN KEY (posted_by) REFERENCES user(id) ON DELETE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='实习咨询';


CREATE TABLE Favorites (
                           id bigint AUTO_INCREMENT PRIMARY KEY,
                           user_id int,  -- 外键关联 Users 表
                           internship_id bigint,  -- 外键关联 Internships 表
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
                           FOREIGN KEY (internship_id) REFERENCES Internships(id) ON DELETE CASCADE
);




-- 为 Internships 表的常用查询字段添加索引
CREATE INDEX idx_company_name ON Internships (company_name);
CREATE INDEX idx_industry ON Internships (industry);
CREATE INDEX idx_location ON Internships (location);

-- 为 Favorites 表中的 user_id 和 internship_id 添加组合索引
CREATE INDEX idx_user_internship ON Favorites (user_id, internship_id);



INSERT INTO Internships (company_name, industry, company_type, position, location, salary, description, requirements, contact_info, posted_by)
VALUES
    ('Tencent', 'Technology', 'Private', 'Software Engineer Intern', 'Shenzhen, China', 8000.00, 'Develop and maintain software systems.', 'Proficient in Java and Python.', 'hr@tencent.com', 4),
    ('Alibaba', 'E-commerce', 'Private', 'Data Analyst Intern', 'Hangzhou, China', 7000.00, 'Analyze data trends and report to senior management.', 'Strong skills in SQL and Excel.', 'jobs@alibaba.com', 5),
    ('Baidu', 'AI', 'Private', 'Machine Learning Intern', 'Beijing, China', 8500.00, 'Work on cutting-edge AI technologies.', 'Familiar with TensorFlow and deep learning.', 'hr@baidu.com', 6);


ALTER TABLE Internships
    ADD COLUMN position_type VARCHAR(50) COMMENT '实习类型（远程、线下）',
    ADD COLUMN acquisitions TEXT COMMENT '实习收获',
    ADD COLUMN company_logo VARCHAR(255) COMMENT '公司logo',
    ADD COLUMN application_deadline DATETIME COMMENT '投递截止日期',
    ADD COLUMN picture VARCHAR(255) COMMENT '图片',
    ADD COLUMN memo TEXT COMMENT '备注';



-- 确保没有 NULL 值
UPDATE Internships SET position_type = '线下' WHERE position_type IS NULL;
UPDATE Internships SET memo = '' WHERE memo IS NULL;

-- 设置为 NOT NULL
ALTER TABLE Internships
    MODIFY COLUMN position_type VARCHAR(50) NOT NULL,
    MODIFY COLUMN memo TEXT NOT NULL;

UPDATE  Internships Set acquisitions = '1' where acquisitions is NULL;
UPDATE  Internships Set company_logo = ' 1' where acquisitions is NULL;
UPDATE  Internships Set application_deadline = '1 ' where acquisitions is NULL;

ALTER Table Internships
    modify column acquisitions TEXT not null,
    # modify column company_logo VARCHAR(255) COMMENT '公司logo' not null,
    modify COLUMN application_deadline DATETIME COMMENT '投递截止日期' not null;
