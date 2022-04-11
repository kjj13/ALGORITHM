/**
MySQL 제어문 종류
1. IF(조건,a,b)
    조건 true : a
    조건 false : b
    
2. IFNULL(a,b)
    a is null : a
    a is not null :b

3. NULLIF(a,b)
    a == b : null
    a != b : a

4. CASE-WHEN-THEN-END
    CASE
        WHEN 조건 THEN A
        WHEN 조건 THEN B
        ELSE C
    END
**/

-- 코드를 입력하세요
#1. IF
SELECT ANIMAL_TYPE, IF(NAME is null,"No name",NAME) as NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

#2. IFNULL
SELECT ANIMAL_TYPE, IFNULL(NAME,"No name") as NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

#3. CASE
SELECT ANIMAL_TYPE,
    CASE
        WHEN NAME IS NULL THEN "No name"
        ELSE NAME
    END AS NAME,
    SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
    
