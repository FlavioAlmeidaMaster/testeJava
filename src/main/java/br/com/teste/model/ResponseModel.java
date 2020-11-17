package br.com.teste.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ResponseModel {

  private Integer codigo;
  private String mensagem;
  private Date dtHr;
  private String detalhes;
  @JsonInclude(Include.NON_NULL)
  private Object modelObject;

  public ResponseModel(Integer codigo, String mensagem, String detalhes) {
    this.codigo = codigo;
    this.mensagem = mensagem;
    this.dtHr = new Date();
    this.detalhes = detalhes;
  }

  public ResponseModel(Integer codigo, String mensagem) {
    this.codigo = codigo;
    this.mensagem = mensagem;
    this.dtHr = new Date();
  }


  public ResponseModel(Integer codigo, String mensagem, Date dtHr, String detalhes) {
    super();
    this.codigo = codigo;
    this.mensagem = mensagem;
    this.dtHr = dtHr;
    this.detalhes = detalhes;
  }

  public ResponseModel(Integer codigo, String mensagem, Object modelObject) {
    super();
    this.codigo = codigo;
    this.mensagem = mensagem;
    this.modelObject = modelObject;
  }

  public static ResponseModel sucesso(Object modelObject, String msg) {
    if (!isPacoteModel(modelObject)) {
      throw new RuntimeException("Erro de configuração na resposta");
    }
    return new ResponseModel(1, msg, modelObject);
  }

  public static ResponseModel falha(String msg, String detalhes) {
    return new ResponseModel(99, msg, detalhes);
  }

  public static ResponseModel falha(String msg) {
    return new ResponseModel(99, msg);
  }

  public static boolean isPacoteModel(Object modelObject) {
    return modelObject == null || modelObject.getClass().getPackage().getName()
        .equals(ResponseModel.class.getPackage().getName());
  }

}

