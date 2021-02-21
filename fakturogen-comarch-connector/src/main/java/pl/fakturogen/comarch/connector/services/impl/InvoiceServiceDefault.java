package pl.fakturogen.comarch.connector.services.impl;

import pl.fakturogen.comarch.connector.converters.InvoiceDTOConverter;
import pl.fakturogen.comarch.connector.dto.InvoiceComarchDTO;
import pl.fakturogen.comarch.connector.ApiConnector;

public class InvoiceServiceDefault {

    private ApiConnector apiConnector;
    private InvoiceDTOConverter invoiceDTOConverter;


    public InvoiceComarchDTO getInvoiceById(long id){



        return new InvoiceComarchDTO();
    }
}
