package pl.fakturogen.invoice.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.fakturogen.invoice.dao.entity.Customer;
import pl.fakturogen.invoice.dao.entity.InvoiceTemplate;
import pl.fakturogen.invoice.dao.entity.Product;
import pl.fakturogen.invoice.web.dto.CustomerDTO;
import pl.fakturogen.invoice.web.dto.InvoiceTemplateDTO;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTemplateMapperTest {

    private InvoiceTemplate invoiceTemplate;
    private InvoiceTemplate invTempEmpty;
    private InvoiceTemplateDTO invoiceTemplateDTO;
    private InvoiceTemplateDTO invTempEmptyDTO;
    private InvoiceTemplateMapper invoiceTemplateMapper;

    @BeforeEach
    public void init() {
        invoiceTemplateMapper = new InvoiceTemplateMapper();

        LocalDate issueDate = LocalDate.of(2021, 1, 20);
        LocalDate saleDate = LocalDate.of(2021, 2, 1);
        Customer customer = new Customer();
        customer.setName("CUSTOMER NAME");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("CUSTOMER NAME");
        Product product1 = new Product();
        product1.setName("PRODUCT ONE");
        Product product2 = new Product();
        product2.setName("TWO PRODUCT");

        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setName("PRODUCT ONE");
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setName("TWO PRODUCT");

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        List<ProductDTO> productDTOList = new ArrayList<>();
        productDTOList.add(productDTO1);
        productDTOList.add(productDTO2);

        invoiceTemplate = new InvoiceTemplate();
        invoiceTemplate.setId(1L);
        invoiceTemplate.setIssueDate(issueDate);
        invoiceTemplate.setSaleDate(saleDate);

        invoiceTemplate.setPaymentMethod("TEST PAYMENT METHOD");
        invoiceTemplate.setPriceTotal(999_111.0);
        invoiceTemplate.setPriceTax(111_111.0);
        invoiceTemplate.setPriceNet(888_000.0);
        invoiceTemplate.setDiscountAmount(20.00);
        invoiceTemplate.setCustomer(customer);
        invoiceTemplate.setProducts(productList);

        invoiceTemplateDTO = new InvoiceTemplateDTO();
        invoiceTemplateDTO.setId(1L);
        invoiceTemplateDTO.setIssueDate(issueDate);
        invoiceTemplateDTO.setSaleDate(saleDate);
        invoiceTemplateDTO.setPaymentMethod("TEST PAYMENT METHOD");
        invoiceTemplateDTO.setPriceTotal(999_111.0);
        invoiceTemplateDTO.setPriceTax(111_111.0);
        invoiceTemplateDTO.setPriceNet(888_000.0);
        invoiceTemplateDTO.setDiscountAmount(20.00);
        invoiceTemplateDTO.setCustomer(customerDTO);
        invoiceTemplateDTO.setProducts(productDTOList);

        invTempEmpty = new InvoiceTemplate();
        invTempEmptyDTO = new InvoiceTemplateDTO();
    }

    @Nested
    class invoiceTemplateToDTO {
        @Test
        public void givenInvoiceTemplate_ShouldReturnDTO() {
            InvoiceTemplateDTO invoiceTemplateDTOActual = invoiceTemplateMapper.from(invoiceTemplate);
            assertEquals(invoiceTemplateDTO, invoiceTemplateDTOActual);
        }

        @Test
        public void givenInvoiceTemplateOneProduct_ShouldReturnDTOWithOneProduct() {
            List<Product> oneProductList = new ArrayList<>();
            Product productOne = new Product();
            productOne.setName("ONE PRODUCT");
            oneProductList.add(productOne);
            invoiceTemplate.setProducts(oneProductList);

            List<ProductDTO> oneProductDTOList = new ArrayList<>();
            ProductDTO productDTOOne = new ProductDTO();
            productDTOOne.setName("ONE PRODUCT");
            oneProductDTOList.add(productDTOOne);
            invoiceTemplateDTO.setProducts(oneProductDTOList);

            InvoiceTemplateDTO invoiceTemplateDTOActual = invoiceTemplateMapper.from(invoiceTemplate);
            assertEquals(invoiceTemplateDTO, invoiceTemplateDTOActual);
        }

        @Test
        public void givenInvoiceTemplateEmpty_ShouldReturnDTO() {
            InvoiceTemplateDTO invoiceTemplateDTOActual = invoiceTemplateMapper.from(invTempEmpty);
            assertEquals(invTempEmptyDTO, invoiceTemplateDTOActual);
        }
    }

    @Nested
    class DTOtoInvoiceTemplate {
        @Test
        public void givenDTO_ShouldReturnInvoiceTemplate() {
            InvoiceTemplate invoiceTemplateActual = invoiceTemplateMapper.from(invoiceTemplateDTO);
            assertEquals(invoiceTemplate, invoiceTemplateActual);
        }

        @Test
        public void givenDTOOneProduct_ShouldReturnITOneProduct() {
            List<Product> oneProductList = new ArrayList<>();
            Product productOne = new Product();
            productOne.setName("THE ONLY ONE PRODUCT");
            oneProductList.add(productOne);
            invoiceTemplate.setProducts(oneProductList);

            List<ProductDTO> oneProductDTOList = new ArrayList<>();
            ProductDTO productDTOOne = new ProductDTO();
            productDTOOne.setName("THE ONLY ONE PRODUCT");
            oneProductDTOList.add(productDTOOne);
            invoiceTemplateDTO.setProducts(oneProductDTOList);

            InvoiceTemplate invoiceTemplateResult = invoiceTemplateMapper.from(invoiceTemplateDTO);
            assertEquals(invoiceTemplate, invoiceTemplateResult);
        }

        @Test
        public void givenDTOEmpty_ShouldReturnInvoiceTemplateEmpty() {
            InvoiceTemplate invoiceTemplateActual = invoiceTemplateMapper.from(invTempEmptyDTO);
            assertEquals(invTempEmpty, invoiceTemplateActual);
        }
    }

}