package com.rogeriopontesti.api.livraria.infrastructure.config;

public final class Labels {

    private static String erroNotFoundAutor = "Not found autor: ";
    private static String erroNotFoundEditora = "Not found editora: ";
    private static String erroNotFoundResenha = "Not found resenha: ";
    private static String erroNotFoundLivro = "Not found livro: ";
    private static String erroNullOrNonExistentId = "Null or non-existent ID";

    public static String getErroNotFoundAutor(String txt){
        return erroNotFoundAutor + txt;
    }

    public static String getErroNotFoundEditora(String txt){
        return erroNotFoundEditora + txt;
    }

    public static String getErroNotFoundResenha(String txt){
        return erroNotFoundResenha + txt;
    }

    public static String getErroNotFoundLivro(String txt){
        return erroNotFoundLivro + txt;
    }
    public static String getErroNullOrNonExistentId(){
        return erroNullOrNonExistentId;
    }
}
