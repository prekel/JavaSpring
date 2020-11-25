--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: furniture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.furniture (
    id integer NOT NULL,
    type character varying(60) NOT NULL,
    model character varying(60) NOT NULL,
    manufacturer character varying(60) NOT NULL,
    cost numeric(15,2) NOT NULL,
    height double precision
);


ALTER TABLE public.furniture OWNER TO postgres;

--
-- Name: furniture_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.furniture_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.furniture_id_seq OWNER TO postgres;

--
-- Name: furniture_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.furniture_id_seq OWNED BY public.furniture.id;


--
-- Name: furniture id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.furniture ALTER COLUMN id SET DEFAULT nextval('public.furniture_id_seq'::regclass);


--
-- Data for Name: furniture; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.furniture (id, type, model, manufacturer, cost, height) FROM stdin;
4	qwe	qwe1	qwe2	5.31	123.3214
6	Шкаф	Шкафчик-3001	Япо	23.31	151
7	Шкаф	Шкафчик-3001	Япо	23.31	151
8	Шкаф	Шкафчик-3001	Япо	23.31	151
9	Шкаф	Шкафчик-3001	Япо	23.31	151
10	Шкаф	Шкафчик-3001	Япо	23.31	151
11	Шкаф	Шкафчик-3001	Япо	23.31	151
13	Шкаф	Шкафчик-3001	Япо	23.31	151
14	Шкаф	Шкафчик-3001	Япо	23.31	151
15	Шкаф	Шкафчик-3001	Япо	23.31	151
16	Шкаф	Шкафчик-3001	Япо	23.31	151
17	Шкаф	Шкафчик-3001	Япо	23.31	151
18	Шкаф	Шкафчик-3001	Япо	23.31	151
19	Шкаф	Шкафчик-3001	Япо	23.31	151
20	Шкаф	Шкафчик-3001	Япо	23.31	151
21	Шкаф	Шкафчик-3003	Япо	23.31	151
23	Шкаф	Шкафчик-3003	Япо	23.31	151
24	Шкаф	Шкафчик-3003	Япо	23.31	151
25	Шкаф	Шкафчик-3003	Япо	23.31	151
26	Шкаф	Шкафчик-3003	Япо	23.31	151
27	Шкаф	Шкафчик-3003	Япо	23.31	151
28	Шкаф	Шкафчик-3003	Япо	23.31	151
29	Шкаф	Шкафчик-3003	Япо	23.31	151
30	Шкаф	Шкафчик-3003	Япо	23.31	151
31	Шкаф	Шкафчик-3003	Япо	23.31	151
32	Шкаф	Шкафчик-3003	Япо	23.31	151
33	Шкаф	Шкафчик-3003	Япо	23.31	151
36	Шкаф	Шкафчик-3003	Япо	23.31	151
37	Шкаф	Шкафчик-3003	Япо	23.31	151
38	Шкаф	Шкафчик-3003	Япо	23.31	151
39	Шкаф	Шкафчик-3003	Япо	23.31	151
40	шкаф	4001	qwe	123.32	123
41	шкаф	4001	qwe	123.32	123
42	Шкаф	Шкафчик-3003	Япо	23.31	151
43	Шкаф	Шкафчик-3003	Япо	23.31	151
44	Шкаф	Шкафчик-3003	Япо	23.31	151
47	qwe	qwe	qw	1.20	1
48	qwe	qwer	qwert	12.12	1234
49	qwe	qwe	qwe	123.12	12.345
35	qwe	qwe	qwe	123.11	213
50	edited1	qwe	qwe	123.12	1
22	1	2	2	3.04	45
51	qwe	qwer	qw	123.34	12
52	123	123	123	123.00	123
53	qwe	qwer	qwert	123.00	123
55	qwe	qwer	qwert	123.00	123
3	qwe123	qwer	qwert	123.00	123
56	123	123	123	123.00	123
57	q	a	z	1.00	23
59	q	a	z	1.00	23
60	q	a	z	1.00	23
61	q	a	z	1.00	23
62	q	a	z	1.00	23
58	123	312	312	12.00	23
63	12	12	13	1212.00	123
64	asd	asd	asd	123.00	12
54	йцу	s	s	123.00	123
5	Шкаф	Шкафчик-3000	Япо1	23.45	150
\.


--
-- Name: furniture_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.furniture_id_seq', 64, true);


--
-- Name: furniture furniture_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.furniture
    ADD CONSTRAINT furniture_pk PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

