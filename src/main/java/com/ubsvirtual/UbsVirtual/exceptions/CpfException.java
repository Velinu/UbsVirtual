package com.ubsvirtual.UbsVirtual.exceptions;

public class CpfException extends Exception{
    public CpfException(){
        super("O CPF informado não é valido");
    }
}
