/**
表A结构如下：
  p_id   p_num  s_id    
------  ------  --------
     1      10  01      
     1      12  02      
     2       8  01      
     3      11  01      
     3       8  03 
p_id为产品ID，p_num为产品库存量，s_id为仓库ID。请用SQL实现数据合并。结果为

p_id  s1_id  s2_id  s3_id
1     10     12     0
2     8      0      0
3     11     0      8

*/

SELECT 
  a1.p_id,  a1.p_num s1_id,
  (
    CASE
      WHEN a2.p_num IS NULL 
      THEN 0 
      ELSE a2.p_num 
    END
  ) s2_id,
  (
    CASE
      WHEN a3.p_num IS NULL 
      THEN 0 
      ELSE a3.p_num 
    END
  ) s3_id 
FROM
  (SELECT * FROM a WHERE s_id = '01') a1 
  LEFT JOIN 
  (SELECT * FROM a WHERE s_id = '02') a2 ON a1.p_id = a2.p_id 
  LEFT JOIN 
  (SELECT * FROM a WHERE s_id = '03') a3 ON a1.p_id = a3.p_id;