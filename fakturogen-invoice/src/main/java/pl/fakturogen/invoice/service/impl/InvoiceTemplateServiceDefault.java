package pl.fakturogen.invoice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fakturogen.invoice.dao.entity.InvoiceTemplate;
import pl.fakturogen.invoice.dao.repository.InvoiceTemplateRepository;
import pl.fakturogen.invoice.service.InvoiceTemplateService;
import pl.fakturogen.invoice.service.exception.InvoiceTemplateCreateException;
import pl.fakturogen.invoice.service.exception.InvoiceTemplateException;
import pl.fakturogen.invoice.service.exception.InvoiceTemplateUpdateException;
import pl.fakturogen.invoice.service.mapper.InvoiceTemplateMapper;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author damian
 */

@Service
@Slf4j
public class InvoiceTemplateServiceDefault implements InvoiceTemplateService {

    InvoiceTemplateRepository invoiceTemplateRepository;
    InvoiceTemplateMapper invoiceTemplateMapper;

    @Autowired
    public InvoiceTemplateServiceDefault(InvoiceTemplateRepository itr, InvoiceTemplateMapper itm) {
        invoiceTemplateRepository = itr;
        invoiceTemplateMapper = itm;
    }

    @Override
    public InvoiceTemplateDTO create(InvoiceTemplateDTO invoiceTemplateDTO) throws InvoiceTemplateException {
        try {
            InvoiceTemplate invoiceTemplate = invoiceTemplateMapper.from(invoiceTemplateDTO);
            InvoiceTemplate savedInvoiceTemplate = invoiceTemplateRepository.save(invoiceTemplate);
            return invoiceTemplateMapper.from(savedInvoiceTemplate);
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new InvoiceTemplateCreateException("Error during saving InvoiceTemplate to database");
        }
    }

    @Override
    public Optional<InvoiceTemplateDTO> read(Long id) throws InvoiceTemplateException {
        return Optional.empty();
    }

    @Override
    public List<InvoiceTemplateDTO> readAll() throws InvoiceTemplateException {
        try {
            List<InvoiceTemplate> invoiceTemplateAll = invoiceTemplateRepository.findAll();
            return invoiceTemplateAll.stream()
                    .map(invoiceTemplateMapper::from)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new InvoiceTemplateException("Error during reading all InvoiceTemplates from database");
        }
    }

    @Override
    public void update(InvoiceTemplateDTO invoiceTemplateDTO, Long id) throws InvoiceTemplateException {

        try {
            Optional<InvoiceTemplate> invoiceTemplateOptional = invoiceTemplateRepository.findById(id);
            invoiceTemplateOptional.orElseThrow(() ->
                    new InvoiceTemplateException("InvoiceTemplate with id: " + id + " not found"));
            invoiceTemplateDTO.setId(id);
            InvoiceTemplate invoiceTemplateToUpdate = invoiceTemplateMapper.from(invoiceTemplateDTO);
            invoiceTemplateRepository.save(invoiceTemplateToUpdate);
        } catch (Exception ex) {
            log.warn(ex.getMessage(), ex);
            throw new InvoiceTemplateUpdateException("Error during updating InvoiceTemplate");
        }
    }

    @Override
    public void delete(InvoiceTemplateDTO invoiceTemplateDTO, Long id) throws InvoiceTemplateException {

    }
}
