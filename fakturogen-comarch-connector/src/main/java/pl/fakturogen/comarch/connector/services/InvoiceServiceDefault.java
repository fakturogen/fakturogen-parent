package pl.fakturogen.comarch.connector.services;

import pl.fakturogen.comarch.connector.converters.dto.InvoiceComarchDTO;

public class InvoiceServiceDefault {


    public InvoiceComarchDTO getInvoiceById(long id){
        return new InvoiceComarchDTO();
    }
}
