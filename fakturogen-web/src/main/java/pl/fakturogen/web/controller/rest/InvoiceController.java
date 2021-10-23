package pl.fakturogen.web.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.exception.ComarchConnectorException;
import pl.fakturogen.comarch.connector.exception.ComarchConverterException;
import pl.fakturogen.comarch.connector.model.ComarchItem;
import pl.fakturogen.comarch.connector.services.ComarchInvoiceService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private ComarchInvoiceService comarchInvoiceService;

    public InvoiceController(ComarchInvoiceService comarchInvoiceService) {
        this.comarchInvoiceService = comarchInvoiceService;
    }

    @GetMapping("/getAll")
    public List<ComarchInvoiceDTO> getInvoices() throws ComarchConnectorException {
        return comarchInvoiceService.readAll();
    }

    @GetMapping("/get/{id}")
    public ComarchInvoiceDTO getInvoice(@PathVariable long id) throws Exception {
        return comarchInvoiceService.read(id);
    }

    @PostMapping("/save/")
    public ResponseEntity save() throws ComarchConverterException {
        ComarchItem item1 = new ComarchItem();
        item1.setProductId(11392139);
        item1.setQuantity(1.0000);
        item1.setProductCurrencyPrice(4500.00);

        ComarchItem item2 = new ComarchItem();
        item2.setProductId(11392135);
        item2.setQuantity(2.0000);
        item2.setProductCurrencyPrice(35501.00);

        List<ComarchItem> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);

        ComarchInvoiceDTO comarchInvoiceDTO = new ComarchInvoiceDTO();
        comarchInvoiceDTO.setPurchasingPartyId(13353087);
        comarchInvoiceDTO.setPaymentTypeId(10301768);
        comarchInvoiceDTO.setItems(itemList);

        Long newInvoiceId = comarchInvoiceService.create(comarchInvoiceDTO);

        return ResponseEntity.ok("Id:" + newInvoiceId);
    }
}
