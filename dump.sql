-- Table: public."Students"

-- DROP TABLE public."Students";

CREATE TABLE public."Students"
(
  firstname character varying(255) NOT NULL,
  lastname character varying(255) NOT NULL,
  sex character varying(5) NOT NULL,
  borndate date NOT NULL,
  id integer NOT NULL DEFAULT nextval('"Students_id_seq"'::regclass),
  CONSTRAINT students_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Students"
  OWNER TO postgres;