-- ���� ����
-- EMPLOYEE | DEPARTMENT 2���� ����
-- CTAS

DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

CREATE TABLE EMPLOYEE
AS
(SELECT * FROM EMP);


CREATE TABLE DEPARTMENT
AS
(SELECT * FROM DEPT);

-- ���̺� ���� Ȯ��
DESC EMPLOYEE;
DESC DEPARTMENT;
-- CTAS�� ������ �� ����, NOT NULL Ȯ���� �Ұ���. (�������� �ȵ�����)
-- PK(�⺻Ű) ���������� ���̺� �߰�.
-- EMPLOYEE, DEPARTMENT ���̺� �⺻Ű ���������� �߰���.
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);


DELETE EMPLOYEE WHERE EMPNO=7369;
SELECT * FROM EMPLOYEE;

-- 20�� �μ��� �����ϴ���, 20�� �μ����� �ٹ��ϴ� ������ �״���̴�.
-- �̰���, EMPLOYEE ���̺�� DEPARTMENT ���̺��� ����,(RELATIONAL) �Ǿ����� �ʱ� ������.
-- FK ���������� �߰��ؾ���.
DELETE DEPARTMENT WHERE DEPTNO =20;
SELECT * FROM DEPARTMENT;

-------------------------------------------
-- 3. �ܷ�Ű �������� �߰��ϱ�. (�̷��� �ִ°��� x)
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno);

-- FK�� �����Ǿ� �ִ� ���̺��� �ڽ��̶�� ���� �ȴ�. ���� ���°� ���°� �������� ���� ���̰� �θ��� ��.


DELETE EMPLOYEE WHERE EMPNO=7369;
SELECT * FROM EMPLOYEE;

DELETE DEPARTMENT WHERE DEPTNO =20;
SELECT * FROM DEPARTMENT;

-- ORA-02292: ���Ἲ ��������(MYKB.EMPLOYEE_DEPTNO_FK)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
-- PK�� ���� ��, = �⺻Ű�� ���� ������, EMPLOYEE�� DEPT-- �� �ƹ� ������ ���⿡, 20 �μ� ���ַ��� ������ ��� ��������.
-- FK�� �θ� �θ� ���̺��� ���� �� ����. �ڽ� ������ �� ���̸� �׿���. �̰͵� ���Ϸ���, FK �������� �� �� CASCADE �ɼ��� �ָ��.

-- ���
-- FK ���� ������ �߰��ϸ�, �ڽ��� �ִ� �θ����̺� ���� �ȵ�.
-- �ڽ� ���ڵ� ���� ���� ��, �θ� ���ڵ� ���� �����ؾ��ϳ�, �̷� ���� �״�� ���ִ� �ɼ��� ON DELETE CASCADE
-- FK���������� ������ �� ON DELETE CASCADE �ɼ��� �Բ� �����ؾ� �Ѵ�.

-- ON DELETE �������� FK �߰�.
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno) ON DELETE CASCADE;

DELETE EMPLOYEE WHERE EMPNO=7369;
SELECT * FROM EMPLOYEE;

DELETE DEPARTMENT WHERE DEPTNO =20;
SELECT * FROM DEPARTMENT;




