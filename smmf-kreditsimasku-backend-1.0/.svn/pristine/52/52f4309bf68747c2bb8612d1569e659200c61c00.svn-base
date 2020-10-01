CREATE TABLE public.branch
(
    branch_id bigint NOT NULL,
    code character varying(32) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    city character varying(50) COLLATE pg_catalog."default",
	is_active character(1) COLLATE pg_catalog."default",
	note character varying(255) COLLATE pg_catalog."default",
	create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    organization_id bigint,
    email character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT branch_pkey PRIMARY KEY (branch_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.branch
    OWNER to postgres;

CREATE SEQUENCE public.branch_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.branch_seq
    OWNER TO postgres;
    
-- Table: public.branch_class

-- DROP TABLE public.branch_class;

CREATE TABLE public.branch_class
(
    branch_class_id bigint NOT NULL,
    code character varying(10) COLLATE pg_catalog."default",
    approvel_otr double precision,
    approvel_level_1 double precision,
    approvel_level_2 double precision,
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    --organization_id bigint,
    CONSTRAINT branch_class_pkey PRIMARY KEY (branch_class_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.branch_class
    OWNER to postgres;



-- SEQUENCE: public.branch_class_seq

-- DROP SEQUENCE public.branch_class_seq;

CREATE SEQUENCE public.branch_class_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.branch_class_seq
    OWNER TO postgres;
    
-- Table: public.lookup

-- DROP TABLE public.lookup;

CREATE TABLE public.lookup
(
    lookup_id bigint NOT NULL,
    category character varying(32) COLLATE pg_catalog."default",
    code character varying(32) COLLATE pg_catalog."default",
    short_name character varying(32) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT lookup_pkey PRIMARY KEY (lookup_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.lookup
    OWNER to postgres;

-- Index: ix_lookup

-- DROP INDEX public.ix_lookup;

CREATE INDEX ix_lookup
    ON public.lookup USING btree
    (category COLLATE pg_catalog."default", code COLLATE pg_catalog."default", short_name COLLATE pg_catalog."default", name COLLATE pg_catalog."default", lookup_id)
    TABLESPACE pg_default;



-- SEQUENCE: public.lookup_seq

-- DROP SEQUENCE public.lookup_seq;

CREATE SEQUENCE public.lookup_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.lookup_seq
    OWNER TO postgres; 
    

-- Table: public.organization

-- DROP TABLE public.organization;

CREATE TABLE public.organization
(
    organization_id bigint NOT NULL,
    name character varying(64) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    city character varying(64) COLLATE pg_catalog."default",
    postal_code character varying(12) COLLATE pg_catalog."default",
    province character varying(64) COLLATE pg_catalog."default",
    telephone character varying(16) COLLATE pg_catalog."default",
    email character varying(64) COLLATE pg_catalog."default",
    url character varying(64) COLLATE pg_catalog."default",
    npwp character varying(32) COLLATE pg_catalog."default",
    npwp_date date,
    CONSTRAINT organization_pkey PRIMARY KEY (organization_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.organization
    OWNER to postgres;
    

CREATE SEQUENCE public.organization_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;
    
ALTER SEQUENCE public.organization_seq
    OWNER to postgres;

-- Table: public.organization_setup

-- DROP TABLE public.organization_setup;

CREATE TABLE public.organization_setup
(
    organization_id bigint NOT NULL,
    setup_date date,
    number_of_digit integer,
    sod_limit integer,
    default_user_pass_duration integer,
    user_pass_history integer,
    min_user_pass_length integer,
    timeout_admin bigint,
    timeout_user bigint,
    timeout_server bigint,
    max_login_attempt integer,
    CONSTRAINT organization_setup_pkey PRIMARY KEY (organization_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.organization_setup
    OWNER to postgres;

-- Index: ix_organization_setup

-- DROP INDEX public.ix_organization_setup;

CREATE INDEX ix_organization_setup
    ON public.organization_setup USING btree
    (organization_id, setup_date)
    TABLESPACE pg_default;



-- SEQUENCE: public.organization_setup_seq

-- DROP SEQUENCE public.organization_setup_seq;

CREATE SEQUENCE public.organization_setup_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.organization_setup_seq
    OWNER TO postgres; 
    
-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE public.product
(
    product_id bigint NOT NULL,
    code character varying(20) COLLATE pg_catalog."default",
    name character varying(128) COLLATE pg_catalog."default",
    minimum_opening_amount double precision,
    maximum_opening_amount double precision,
    interest_type character varying(16) COLLATE pg_catalog."default",
    minimum_age integer,
    maximum_age integer,
    minimum_term integer,
    maximum_term integer,
    description character varying(255) COLLATE pg_catalog."default",
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    collateral_type_id bigint,
    term_frequency_id bigint,
    --workflow_id bigint,
    organization_id bigint,
    is_active character(1) COLLATE pg_catalog."default",
    term_payment bigint,
    minimum_payment double precision,
    leaseback_channeling character(1) COLLATE pg_catalog."default",
    non_leaseback_channeling character(1) COLLATE pg_catalog."default",
    non_leaseback_sumber_pendanaan character varying(255) COLLATE pg_catalog."default",
    leaseback_sumber_pendanaan character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_pkey PRIMARY KEY (product_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;

-- Index: ix_product 

-- DROP INDEX public.ix_product;

CREATE INDEX ix_product
    ON public.product USING btree
    (collateral_type_id, product_id, name COLLATE pg_catalog."default", code COLLATE pg_catalog."default", is_active COLLATE pg_catalog."default")
    TABLESPACE pg_default;



-- SEQUENCE: public.product_seq

-- DROP SEQUENCE public.product_seq;

CREATE SEQUENCE public.product_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.product_seq
    OWNER TO postgres;
    
-- Table: public.report_access

-- DROP TABLE public.report_access;

CREATE TABLE public.report_access
(
    report_access_id bigint NOT NULL,
    report_name character varying(30) COLLATE pg_catalog."default",
    report_level integer,
    report_access_time integer,
    CONSTRAINT report_access_pkey PRIMARY KEY (report_access_id),
    CONSTRAINT unique_report_access UNIQUE (report_name, report_level)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.report_access
    OWNER to postgres;



-- SEQUENCE: public.report_access_seq

-- DROP SEQUENCE public.report_access_seq;

CREATE SEQUENCE public.report_access_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.report_access_seq
    OWNER TO postgres; 
    
-- Table: public.role

-- DROP TABLE public.role;

CREATE TABLE public.role
(
    role_id bigint NOT NULL,
    role_name character varying(32) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    is_show_bank_balance character(1) COLLATE pg_catalog."default",
    is_show_application_status character(1) COLLATE pg_catalog."default",
    is_show_product character(1) COLLATE pg_catalog."default",
    is_show_cash_bank character(1) COLLATE pg_catalog."default",
    is_show_new_application character(1) COLLATE pg_catalog."default",
    is_show_new_personal_corporate character(1) COLLATE pg_catalog."default",
    is_numeric character(1) COLLATE pg_catalog."default",
    default_user_pass_duration integer,
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    CONSTRAINT role_pkey PRIMARY KEY (role_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.role
    OWNER to postgres;

-- Index: ix_role

-- DROP INDEX public.ix_role;

CREATE INDEX ix_role
    ON public.role USING btree
    (role_id, role_name COLLATE pg_catalog."default")
    TABLESPACE pg_default; 



-- SEQUENCE: public.role_seq

-- DROP SEQUENCE public.role_seq;

CREATE SEQUENCE public.role_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.role_seq
    OWNER TO postgres;
    
create table role_parent(role_id bigint, parent_id bigint);

create table role_role_group(role_id bigint, role_group_id bigint);
    
-- Table: public.status

-- DROP TABLE public.status;

CREATE TABLE public.status
(
    status_id bigint NOT NULL,
    type character varying(40) COLLATE pg_catalog."default",
    code character varying(40) COLLATE pg_catalog."default",
    name character varying(40) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT status_pkey PRIMARY KEY (status_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.status
    OWNER to postgres;

-- Index: ix_status

-- DROP INDEX public.ix_status;

CREATE INDEX ix_status
    ON public.status USING btree
    (status_id, type COLLATE pg_catalog."default", code COLLATE pg_catalog."default", name COLLATE pg_catalog."default")
    TABLESPACE pg_default;
 


-- SEQUENCE: public.status_seq

-- DROP SEQUENCE public.status_seq;

CREATE SEQUENCE public.status_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.status_seq
    OWNER TO postgres;
    
-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    user_id bigint NOT NULL,
    user_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    user_pass character varying(64) COLLATE pg_catalog."default",
    is_active character(1) COLLATE pg_catalog."default",
    is_supervisor character(1) COLLATE pg_catalog."default",
    is_sso character(1) COLLATE pg_catalog."default",
    user_type character varying(16) COLLATE pg_catalog."default",
    ip character varying(16) COLLATE pg_catalog."default",
    rsa character varying(64) COLLATE pg_catalog."default",
    printer character varying(32) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(32) COLLATE pg_catalog."default",
    handphone character varying(32) COLLATE pg_catalog."default",
    organization_id bigint,
    branch_id bigint,
    --old_user_name character varying(255) COLLATE pg_catalog."default",
    --is_new character(1) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    insurance_vendor_id bigint,
    --is_login character(1) COLLATE pg_catalog."default",
    sales_category character varying(30) COLLATE pg_catalog."default",
    last_login_time timestamp without time zone,
    employee_id bigint,
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    parent_id bigint,
    login_attempt_counter integer,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT unique_user_name UNIQUE (user_name)
 
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;

-- Index: ix_users

-- DROP INDEX public.ix_users;

CREATE INDEX ix_users
    ON public.users USING btree
    (user_id, user_name COLLATE pg_catalog."default", is_active COLLATE pg_catalog."default", user_type COLLATE pg_catalog."default", branch_id, organization_id, is_sso COLLATE pg_catalog."default")
    TABLESPACE pg_default;



-- SEQUENCE: public.users_seq

-- DROP SEQUENCE public.users_seq;

CREATE SEQUENCE public.users_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.users_seq
    OWNER TO postgres;
    
-- Table: public.user_detail

-- DROP TABLE public.user_detail;

CREATE TABLE public.user_detail
(
    user_detail_id bigint NOT NULL,
    user_id bigint NOT NULL,
    birth_date date,
    join_date date,
    bank_name character varying(30) COLLATE pg_catalog."default",
    account_number character varying(30) COLLATE pg_catalog."default",
    account_name character varying(128) COLLATE pg_catalog."default",
    bank_branch character varying(30) COLLATE pg_catalog."default",
    telephone1 character varying(20) COLLATE pg_catalog."default",
    telephone2 character varying(20) COLLATE pg_catalog."default",
    mobile1 character varying(20) COLLATE pg_catalog."default",
    mobile2 character varying(20) COLLATE pg_catalog."default",
    address1 character varying(255) COLLATE pg_catalog."default",
    city character varying(255) COLLATE pg_catalog."default",
    postal_code character varying(7) COLLATE pg_catalog."default",
    --user_file_id bigint,
    idcard_number character varying(25) COLLATE pg_catalog."default",
    birth_place character varying(128) COLLATE pg_catalog."default",
    mother_maiden_name character varying(128) COLLATE pg_catalog."default",
    gender character varying(1) COLLATE pg_catalog."default",
    id_expiry_date date,
    open_on timestamp without time zone,
    CONSTRAINT user_detail_pkey PRIMARY KEY (user_detail_id),
    CONSTRAINT unique_user_detail UNIQUE (user_id)
 
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_detail
    OWNER to postgres;



-- SEQUENCE: public.user_detail_seq

-- DROP SEQUENCE public.user_detail_seq;

CREATE SEQUENCE public.user_detail_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.user_detail_seq
    OWNER TO postgres;
    
-- Table: public.user_login

-- DROP TABLE public.user_login;

CREATE TABLE public.user_login
(
    user_login_id bigint NOT NULL,
    user_id bigint,
    user_name character varying(100) COLLATE pg_catalog."default",
    user_type character varying(16) COLLATE pg_catalog."default",
    login_time timestamp without time zone,
    branch_id bigint,
    branch_name character varying(255) COLLATE pg_catalog."default",
    ip character varying(32) COLLATE pg_catalog."default",
    server character varying(50) COLLATE pg_catalog."default",
    browser character varying(32) COLLATE pg_catalog."default",
    CONSTRAINT user_login_pkey PRIMARY KEY (user_login_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_login
    OWNER to postgres;

 

-- SEQUENCE: public.user_login_seq

-- DROP SEQUENCE public.user_login_seq;

CREATE SEQUENCE public.user_login_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.user_login_seq
    OWNER TO postgres;
    
-- Table: public.user_logging

-- DROP TABLE public.user_logging;

CREATE TABLE public.user_logging
(
    user_logging_id bigint NOT NULL,
    user_name character varying(128) COLLATE pg_catalog."default",
    branch character varying(128) COLLATE pg_catalog."default",
    ip character varying(20) COLLATE pg_catalog."default",
    computer_name character varying(128) COLLATE pg_catalog."default",
    hostname character varying(128) COLLATE pg_catalog."default",
    is_trusted_ip character(1) COLLATE pg_catalog."default",
    is_trusted_action character(1) COLLATE pg_catalog."default",
    access_date date,
    access_time timestamp without time zone,
    action character varying(255) COLLATE pg_catalog."default",
    parameter character varying(1024) COLLATE pg_catalog."default",
    branch_id bigint,
    view_id bigint,
    CONSTRAINT user_logging_pkey PRIMARY KEY (user_logging_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_logging
    OWNER to postgres;
 


-- SEQUENCE: public.user_logging_seq

-- DROP SEQUENCE public.user_logging_seq;

CREATE SEQUENCE public.user_logging_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.user_logging_seq
    OWNER TO postgres;
    
-- Table: public.user_password_history

-- DROP TABLE public.user_password_history;

CREATE TABLE public.user_password_history
(
    user_password_history_id bigint NOT NULL,
    user_id bigint NOT NULL,
    old_user_pass character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_pass_change_date date NOT NULL,
    CONSTRAINT user_password_history_pkey PRIMARY KEY (user_password_history_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_password_history
    OWNER to postgres;


 
-- SEQUENCE: public.user_password_history_seq

-- DROP SEQUENCE public.user_password_history_seq;

CREATE SEQUENCE public.user_password_history_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.user_password_history_seq
    OWNER TO postgres;
    
-- Table: public.users_history

-- DROP TABLE public.users_history;

CREATE TABLE public.users_history
(
    user_history_id bigint NOT NULL,
    branch_id bigint,
    user_name character varying(32) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on date,
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    user_id bigint,
    role_id bigint,
    is_active character(1) COLLATE pg_catalog."default",
    user_employee_log_id bigint,
    CONSTRAINT users_history_pkey PRIMARY KEY (user_history_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users_history
    OWNER to postgres;

 

-- SEQUENCE: public.users_history_seq

-- DROP SEQUENCE public.users_history_seq;

CREATE SEQUENCE public.users_history_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.users_history_seq
    OWNER TO postgres;
    
CREATE TABLE public.user_role
(
    user_id bigint,
    role_id bigint
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_role
    OWNER to postgres;
    
-- Table: public.views

-- DROP TABLE public.views;

CREATE TABLE public.views
(
    view_id bigint NOT NULL,
    view_name character varying(255) COLLATE pg_catalog."default",
    link character varying(255) COLLATE pg_catalog."default",
    is_view character(1) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    parent_id bigint,
    is_trusted_action character(1) COLLATE pg_catalog."default",
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    CONSTRAINT views_pkey PRIMARY KEY (view_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.views
    OWNER to postgres;

-- Index: ix_views
 
-- DROP INDEX public.ix_views;

CREATE INDEX ix_views
    ON public.views USING btree
    (parent_id, is_view COLLATE pg_catalog."default", view_id, view_name COLLATE pg_catalog."default")
    TABLESPACE pg_default;



-- SEQUENCE: public.views_seq

-- DROP SEQUENCE public.views_seq;

CREATE SEQUENCE public.views_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.views_seq
    OWNER TO postgres;
    
-- Table: public.view_block_multiple

-- DROP TABLE public.view_block_multiple;

CREATE TABLE public.view_block_multiple
(
    view_block_multiple_id bigint NOT NULL,
    view_id bigint NOT NULL,
    is_active character(1) COLLATE pg_catalog."default",
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    CONSTRAINT view_block_multiple_pkey PRIMARY KEY (view_block_multiple_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.view_block_multiple
    OWNER to postgres;

 

-- SEQUENCE: public.view_block_multiple_seq

-- DROP SEQUENCE public.view_block_multiple_seq;

CREATE SEQUENCE public.view_block_multiple_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.view_block_multiple_seq
    OWNER TO postgres;
    
-- Table: public.view_block_multiple_history

-- DROP TABLE public.view_block_multiple_history;

CREATE TABLE public.view_block_multiple_history
(
    view_block_multiple_history_id bigint NOT NULL,
    view_id bigint NOT NULL,
    create_by character varying(255) COLLATE pg_catalog."default",
    create_on timestamp without time zone,
    change_by character varying(255) COLLATE pg_catalog."default",
    change_on timestamp without time zone,
    CONSTRAINT view_block_multiple_history_pkey PRIMARY KEY (view_block_multiple_history_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.view_block_multiple_history
    OWNER to postgres;

 

-- SEQUENCE: public.view_block_multiple_his_seq

-- DROP SEQUENCE public.view_block_multiple_his_seq;

CREATE SEQUENCE public.view_block_multiple_his_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 20;

ALTER SEQUENCE public.view_block_multiple_his_seq
    OWNER TO postgres;
    
CREATE TABLE public.role_view
(
    role_id bigint,
    view_id bigint,
    view_seq bigint
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.role_view
    OWNER to postgres;