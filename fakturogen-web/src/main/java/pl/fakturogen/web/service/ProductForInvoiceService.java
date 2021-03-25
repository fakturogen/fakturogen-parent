package pl.fakturogen.web.service;

import org.springframework.stereotype.Service;
import pl.fakturogen.comarch.connector.dto.ComarchInvoiceDTO;
import pl.fakturogen.comarch.connector.dto.ComarchProductDTO;
import pl.fakturogen.comarch.connector.mapper.FakturogenProductMapper;
import pl.fakturogen.comarch.connector.services.ComarchProductService;
import pl.fakturogen.invoice.service.ProductService;
import pl.fakturogen.invoice.web.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductForInvoiceService {
    private ComarchProductService comarchProductService;
    private FakturogenProductMapper fakturogenProductMapper;
    private ProductService productService;

    public ProductForInvoiceService(ComarchProductService comarchProductService, FakturogenProductMapper fakturogenProductMapper, ProductService productService) {
        this.comarchProductService = comarchProductService;
        this.fakturogenProductMapper = fakturogenProductMapper;
        this.productService = productService;
    }

    public List<ProductDTO> getProduct(ComarchInvoiceDTO comarchInvoiceDTO) {

        List<ComarchProductDTO> items = comarchInvoiceDTO.getItems();
        List<ProductDTO> productDTOList = items.stream()
                .map(i -> {
                    Long productId = i.getId();
                    ComarchProductDTO comarchProductDTO = comarchProductService.read(productId).orElseThrow(() -> new RuntimeException("Product not found")); //TODO exception handler
                    ProductDTO productDTO = fakturogenProductMapper.from(comarchProductDTO);
                    return productService.findByExternalId(productId).orElse(productDTO);
                })
                .collect(Collectors.toList());

        return productDTOList;
    }
}
