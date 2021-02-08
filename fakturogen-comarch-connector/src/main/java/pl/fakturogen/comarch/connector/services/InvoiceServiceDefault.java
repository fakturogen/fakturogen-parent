package pl.fakturogen.comarch.connector.services;

import pl.fakturogen.comarch.connector.converters.InvoiceDTOConverter;
import pl.fakturogen.comarch.connector.converters.dto.InvoiceComarchDTO;
import pl.fakturogen.comarch.connector.dao.ApiConnector;

public class InvoiceServiceDefault {

    private ApiConnector apiConnector;
    private InvoiceDTOConverter invoiceDTOConverter;


    public InvoiceComarchDTO getInvoiceById(long id){



        return new InvoiceComarchDTO();
    }
}
