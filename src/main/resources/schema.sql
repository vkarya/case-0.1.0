CREATE TABLE Location (
    id integer NOT NULL,
    code VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    longitude double precision,
    latitude double precision,
    parent integer,
    CONSTRAINT pk_location PRIMARY KEY (id),
    CONSTRAINT location_translation FOREIGN KEY (parent)
        REFERENCES Location (id)
);

CREATE INDEX fki_parent
    ON Location (parent);

CREATE TABLE Translation (
    id integer NOT NULL,
    location integer NOT NULL,
    language VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR NOT NULL,
    CONSTRAINT pk_translation PRIMARY KEY (id),
    CONSTRAINT fk_translation_location FOREIGN KEY (location)
      REFERENCES Location (id)
);

CREATE INDEX fki_translation_location
    ON Translation (location);