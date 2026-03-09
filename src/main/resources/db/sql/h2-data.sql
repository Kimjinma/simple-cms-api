-- TODO data
-- example
insert into members (name, last_modified_date) values('bob', now());


INSERT INTO users (username, password, role, created_date) 
VALUES ('admin', '{noop}1234', 'ROLE_ADMIN', CURRENT_TIMESTAMP);

INSERT INTO users (username, password, role, created_date) 
VALUES ('user1', '{noop}1234', 'ROLE_USER', CURRENT_TIMESTAMP);

-- 초기 샘플 게시글 세팅
INSERT INTO contents (title, description, view_count, created_date, created_by)
VALUES ('첫 번째 테스트 게시글', '안녕하세요. CMS API 테스트 중입니다.', 0, CURRENT_TIMESTAMP, 'admin');
