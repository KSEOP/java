-- IN������
-- �������� �� �߿��� ��� �ϳ��� ���� ��ġ�ϴ� ���� ��

-- �����ȣ�� 7369�̰ų�, 7521�̰ų�, 7782���� ����� �˻�

-- 1 STEP
SELECT* FROM EMP WHERE EMPNO=7369;
SELECT* FROM EMP WHERE EMPNO=7521;
SELECT* FROM EMP WHERE EMPNO=7782;
-- 3�� �����ϴ� ���� ������ ���.

-- 2 STEP
SELECT * FROM EMP WHERE EMPNO=7369 OR EMPNO=7521 OR EMPNO=7782; 

-- 3 STEP
SELECT * FROM EMP WHERE EMPNO IN(7369, 7521, 7782); 

-- ////////////////
-- ��� ��ȣ�� 7369�� �ƴϰ�, 7521�� �ƴϰ� 7782�� �ƴ� ����� �˻�.
SELECT * FROM EMP WHERE EMPNO NOT IN(7369, 7521, 7782);
-- �� �����ڷ� �ٲٱ�.
SELECT * FROM EMP WHERE EMPNO !=7369 AND EMPNO !=7521 AND EMPNO !=7782;
-- ������ �� ������ ����. --> NULL�� �ִ� �÷��� ������ �� �Ұ�����.
-- AND �� �ٷ�� �͵��� ��� ������ �������.
-- �� IN�� �� ��, NULL ���� �ؾ���.



-- ���� �Լ� :: SUBSTR()
-- SUBSTR(���ڿ�, ������ġ, ������ ����)
SELECT SUBSTR('HelloWorld',6) FROM DUAL; -- ���ⰳ�� �Ⱦ��� ������ �� ����.

-- WOR ����
SELECT SUBSTR('HelloWorld',6,3) FROM DUAL;

SELECT SUBSTR('HelloWorld',-4,2) FROM DUAL;

-- EMP���̺��� ����� �̸��� N���� ������ ����� �˻� :: SUBSTR(), LIKE() ���
SELECT ENAME FROM EMP
WHERE SUBSTR(ENAME,-1,1)='N';

SELECT ENAME FROM EMP
WHERE SUBSTR(LOWER(ENAME),-1,1)='n';

SELECT ENAME FROM EMP
WHERE ENAME LIKE '%N';

-- EMP���̺��� ������� �Ի�⵵�� �˻�
SELECT SUBSTR(HIREDATE,1,2) �⵵ FROM EMP;

-- TRIM() :: ������ �����ϴ� �Լ�
SELECT RTRIM('JAMES GOSLING            ') NAME FROM DUAL;
SELECT LTRIM('            JAMES GOSLING') NAME FROM DUAL;
SELECT TRIM('      JAMES GOSLING       ') NAME FROM DUAL;

--REPLACE(): 
SELECT REPLACE(JOB, 'MAN', 'PERSON') NEWJOB FROM EMP
WHERE JOB='SALESMAN';

--TRIM ��� REPLACE�� 
SELECT REPLACE('         JAMES   GOSLING  IS   GOOD    ',' ','') MESSAGE FROM DUAL;


--�����Լ���

--ROUND
/*
2��° ���ڰ� 2�� �ǹ̴� �Ҽ��� ���� 2�ڸ� ���� ���ڸ� ��Ÿ����� ��
�̷��� �Ǳ� ���ؼ��� �Ҽ��� ���� 3�ڸ����� ���������� �ݿø��� ����ȴ�.
*/
SELECT ROUND(45.923, 2) FROM DUAL; -- 2�� �Ҽ��� 2�ڸ� ���� ����ϰڴ�. == 3° �ڸ����� �ݿø� �ϰڴ�.

SELECT ROUND(45.923, 0) FROM DUAL; -- ����ǥ�� / ����Ʈ

SELECT ROUND(45.923) FROM DUAL; -- ����Ʈ ����� ��.

/*
2��° ���� ���� ������ ������,

45 . 923
. ���� �߽����� �� �� ��... ������ �Ž��� �ö�.
<<����� ���� �޸� �ش� �ڸ����� �ٷ� �ݿø��� �Ͼ.>>
*/
SELECT ROUND(45.923, -1) FROM DUAL;

-- FLOOR() :: ����(�Ҽ��� �Ʒ��� ����)

SELECT FLOOR(45.923) FROM DUAL;

-- SELECT FLOOR(45.923, 2) FROM DUAL; -- ������. FLOOR�� �ڸ����� ���� ����. �Ҽ����� ������ �� �������� �������.
SELECT FLOOR(7.6) FROM DUAL;

-- TRUNC() :: ����. FLOOR�� �������� "�ڸ��� ����" ����. == ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923) FROM DUAL;

SELECT TRUNC(45.923, 0) FROM DUAL;

SELECT TRUNC(45.923, 2) FROM DUAL; -- �Ҽ��� 2° �ڸ����� ���, �̸��� ����

-- CEIL()::�ø� / FLOOR()�� �ݴ� :: �ڸ��� ���� �ȵ�.

SELECT CEIL(45.923) FROM DUAL; -- �ڸ��� �����ȵ� == ������ ��Ÿ���ڴ�.

SELECT CEIL(45.923,2) FROM DUAL; -- �� ���� �߻�.

--

SELECT GREATEST(1,2,3) FROM DUAL; -- �ִ밪 �ϳ� ���
SELECT LEAST(1,2,3) FROM DUAL; -- �ּڰ� �ϳ� ���


-- ��¥ �Լ�
SELECT SYSDATE FROM DUAL;

SELECT SYSTIMESTAMP FROM DUAL;

-- ���÷� ����. 100��
SELECT SYSDATE+100 FROM DUAL;
SELECT SYSDATE+1 ���� FROM DUAL;
SELECT SYSDATE-1 ���� FROM DUAL;

-- �����е��� �׵��� ��ƿ��� ����
-- ���ÿ���, ������� ����.
SELECT TRUNC(SYSDATE-TO_DATE('94/04/06')) ��ƿ»��� FROM DUAL;

SELECT TRUNC(SYSDATE-TO_DATE('2000/04/17')) ��ƿ»��� FROM DUAL;

SELECT EXTRACT(DAY FROM SYSDATE) ����, EXTRACT(MONTH FROM SYSDATE) ��, EXTRACT(YEAR FROM SYSDATE) �⵵ FROM DUAL;

--���� 7 ����� �̸�, �Ի���, �Ի�⵵, �Ի� �� ������ ��ȸ�϶�.
SELECT ENAME, HIREDATE, EXTRACT(YEAR FROM HIREDATE) "YEAR", EXTRACT(MONTH FROM HIREDATE) "MONTH" FROM EMP;

--�ٹ� ���� ��� 69P
SELECT ENAME, HIREDATE, SYSDATE, MONTHS_BETWEEN(SYSDATE, HIREDATE) �ٹ�����, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE),0) T�ٹ����� FROM EMP
WHERE DEPTNO = 10
ORDER BY 4;

--�Ի����ڷκ��� ���ƿ��� �ݿ���, ����� ���
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE, '�ݿ���') ���ƿ��±ݿ���, 
       NEXT_DAY(HIREDATE, '�����') ���ƿ�������� 
FROM EMP;

-- ��¥�� ��¥ ������ ������ :: MONTHS_BETWEEN(DAY1, DAY2)
-- EMP ���̺��� ����� �Ի��� ���κ��� 2023�� 07/25 �� ������ ���� ���� ��.
SELECT TRUNC(MONTHS_BETWEEN(HIREDATE, '2023/07/25')) FROM EMP;
-- TO_DATE �Ƚ�µ��� �ڵ� ����ȯ�� ����.
-- 1. ����� ����ȯ
-- 2. �ڵ� ����ȯ V
-- �ᱣ���� ������.
-- 1. �� ���� �ڸ��� �ٲ۴�
-- 2. ABS() ���� ����.
SELECT ABS(TRUNC(MONTHS_BETWEEN(HIREDATE, '2023/07/25'))) FROM EMP;

-- 3�ڸ� ���� , ���
SELECT EMPNO, ENAME, JOB, SAL, TO_CHAR(SAL, '999,999')
FROM EMP
WHERE DEPTNO = 20
ORDER BY SAL DESC;

-- YYYY MM DD ���� ���
SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY"��" MM"��" DD"��"') �Ի�����
FROM EMP
WHERE DEPTNO=20
ORDER BY HIREDATE DESC;

-- 77P ���� 7 ���� ����



-- �Ϲ��Լ� :: DECODE()
-- EMP ���̺��� ������ PRESIDENT / ����,
--               ������ MANAGER / ������,
--               ������ ANALYST / �м���,
--                         ��Ÿ / ����, 
--                         ALIAS = �����з�

SELECT EMPNO, ENAME, 
        DECODE(JOB, 'ANALYST', '�м���',
                    'PRESIDENT', '����',
                    'MANAGER', '������',
                    '����') AS �����з�
        FROM EMP;
--
SELECT EMPNO, ENAME,
        DECODE(SAL, '5000', 'OWNER �޿�', '3000', '��ױ޿�', '�Ϲݱ޿�') AS �޿�����
FROM EMP;
--
-- CASE WHEN ����
SELECT EMPNO, ENAME, SAL, CASE WHEN SAL=(SELECT MAX(SAL) FROM EMP) THEN 'OWNER �޿�'
                               WHEN SAL=3000 THEN '��ױ޿�'
                               ELSE '�Ϲݱ޿�' END "�޿�����" -- ELSE ó�� �����ָ� �� �� ���̽��� NULL�� ��.
FROM EMP;












