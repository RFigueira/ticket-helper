package br.com.codepampa.model;

import java.io.Serializable;


public interface BaseModel<PK extends Serializable> extends Serializable {
    PK getId();
}