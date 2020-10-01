

insert into users(user_id,user_name,user_pass,is_active, is_supervisor, is_sso, user_type, organization_id,login_attempt_counter) values(1,'admin','5A16FC3F8BF4F3A90ACF67D06D06836EABEB519F','T','F','F','ADMINISTRATOR',1,0);
insert into role(role_id,role_name, default_user_pass_duration, is_numeric ) values('1','admin',0,'N');
insert into user_role(user_id,role_id) values('1','1');

INSERT INTO public.organization(
	organization_id, name, address, city, postal_code, province, telephone)
	VALUES (1, 'PT. SINARMAS MULTIFINANCE', 'Jl. MH. Thamrin 3', 'Jakarta', '60111', 'DKI Jakarta', '021345678');
	
insert into organization_setup (organization_id, setup_date, number_of_digit, sod_limit, timeout_admin, timeout_user,timeout_server, default_user_pass_duration, user_pass_history, min_user_pass_length, max_login_attempt) 
values (1, '2019-01-01', 0,5,120,120,250,0,2,8,20);
	
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (1, 'Home', '/home.do', 'Y', '', NULL, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (2, 'Logoff', '/logoff.do', 'N', '', NULL, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (3, 'Admin', '', 'Y', '', NULL, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (4, 'User', '/user/list.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (5, 'User form', '/user/form.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (6, 'User save', '/user/save.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (7, 'User detail', '/user/detail.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (8, 'Role', '/role/list.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (9, 'Role form', '/role/form.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (10, 'Role save', '/role/save.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) 
VALUES (11, 'Reset Login Attempt', '/user/resetLoginAttempt.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (12, 'Role detail', '/role/detail.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (13, 'View', '/view/list.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (14, 'View form', '/view/form.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (15, 'View save', '/view/save.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (16, 'View delete', '/view/delete.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (17, 'View detail', '/view/detail.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (18, 'Change Password', '/user/changePassword.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (19, 'Change Password Save', '/user/changePasswordSave.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (20, 'Organization', '/organization/list.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (21, 'Organization form', '/organization/form.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (22, 'Organization save', '/organization/save.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (23, 'Organization delete', '/organization/delete.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (24, 'Organization detail', '/organization/detail.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (25, 'Organization show image', '/organization/showImage.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (26, 'Lookup', '/lookup/list.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (27, 'Lookup create', '/lookup/create.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (28, 'Lookup insert', '/lookup/insert.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (29, 'Lookup edit', '/lookup/edit.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (30, 'Lookup update', '/lookup/update.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (31, 'Lookup detail', '/lookup/detail.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (32, 'Branch', '/branch/list.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (33, 'Branch create', '/branch/create.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (34, 'Branch insert', '/branch/insert.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (35, 'Branch edit', '/branch/edit.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (36, 'Branch update', '/branch/update.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (37, 'Branch detail', '/branch/detail.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (38, 'User Password form', '/user/passwordForm.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (39, 'User Password save', '/user/passwordSave.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (40, 'Status', '/status/list.do', 'Y', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (41, 'Status create', '/status/create.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (42, 'Status insert', '/status/insert.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (43, 'Status edit', '/status/edit.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (44, 'Status update', '/status/update.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (45, 'Status detail', '/status/detail.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (46, 'Organization first setup', '/organizationSetup/form.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);
INSERT INTO views (view_id, view_name, link, is_view, description, parent_id, is_trusted_action, create_by, create_on, change_by, change_on) VALUES (47, 'Organization first setup save', '/organizationSetup/save.do', 'N', '', 3, 'T', NULL, NULL, NULL, NULL);

INSERT INTO role_view VALUES (1,1,0);
INSERT INTO role_view VALUES (1,2,1);
INSERT INTO role_view VALUES (1,3,2);
INSERT INTO role_view VALUES (1,4,3);
INSERT INTO role_view VALUES (1,5,4);
INSERT INTO role_view VALUES (1,6,5);
INSERT INTO role_view VALUES (1,7,6);
INSERT INTO role_view VALUES (1,8,7);
INSERT INTO role_view VALUES (1,9,8);
INSERT INTO role_view VALUES (1,10,9);
INSERT INTO role_view VALUES (1,11,10);
INSERT INTO role_view VALUES (1,12,11);
INSERT INTO role_view VALUES (1,13,12);
INSERT INTO role_view VALUES (1,14,13);
INSERT INTO role_view VALUES (1,15,14);
INSERT INTO role_view VALUES (1,16,15);
INSERT INTO role_view VALUES (1,17,16);
INSERT INTO role_view VALUES (1,18,17);
INSERT INTO role_view VALUES (1,19,18);
INSERT INTO role_view VALUES (1,20,19);
INSERT INTO role_view VALUES (1,21,20);
INSERT INTO role_view VALUES (1,22,21);
INSERT INTO role_view VALUES (1,23,22);
INSERT INTO role_view VALUES (1,24,23);
INSERT INTO role_view VALUES (1,25,24);
INSERT INTO role_view VALUES (1,26,25);
INSERT INTO role_view VALUES (1,27,26);
INSERT INTO role_view VALUES (1,28,27);
INSERT INTO role_view VALUES (1,29,28);
INSERT INTO role_view VALUES (1,30,29);
INSERT INTO role_view VALUES (1,31,30);
INSERT INTO role_view VALUES (1,32,31);
INSERT INTO role_view VALUES (1,33,32);
INSERT INTO role_view VALUES (1,34,33);
INSERT INTO role_view VALUES (1,35,34);
INSERT INTO role_view VALUES (1,36,35);
INSERT INTO role_view VALUES (1,37,36);
INSERT INTO role_view VALUES (1,38,37);
INSERT INTO role_view VALUES (1,39,38);
INSERT INTO role_view VALUES (1,40,39);
INSERT INTO role_view VALUES (1,41,40);
INSERT INTO role_view VALUES (1,42,41);
INSERT INTO role_view VALUES (1,43,42);
INSERT INTO role_view VALUES (1,44,43);
INSERT INTO role_view VALUES (1,45,44);
INSERT INTO role_view VALUES (1,46,45);
INSERT INTO role_view VALUES (1,47,46);
