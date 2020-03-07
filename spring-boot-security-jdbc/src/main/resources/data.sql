 insert into users values('user','$2a$10$CrCNsBq/yD3.165JMlYcsuH1Oppmt8k.Tnq22KrHD2Wdhs7QP9Jcy',true); /*password*/
 insert into users values('admin','$2a$10$CrCNsBq/yD3.165JMlYcsuH1Oppmt8k.Tnq22KrHD2Wdhs7QP9Jcy',true);

 insert into authorities values('user','ROLE_USER');
 insert into authorities values('admin','ROLE_USER');
 insert into authorities values('admin','ROLE_ADMIN');

