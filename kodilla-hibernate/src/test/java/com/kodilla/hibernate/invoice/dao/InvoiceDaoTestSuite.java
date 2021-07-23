package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@DisplayName("InvoiceDao Test Suite")
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("The beginning of tests");
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("The end of all tests");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Execute test #" + testCounter);
    }

    @DisplayName("Test: invoiceDaoSave()")
    @Test
    void testInvoiceDaoSave() {
        //Given
        Item item1 = new Item(new BigDecimal(100), 2, new BigDecimal(200));
        Item item2 = new Item(new BigDecimal(50), 4, new BigDecimal(200));
        Item item3 = new Item(new BigDecimal(25), 8, new BigDecimal(200));

        Invoice invoice1 = new Invoice("0001/01");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);

        //When
        invoiceDao.save(invoice1);

        int invoice1Id = invoice1.getId();
        int item1Id = invoice1.getItems().get(0).getId();
        int item2Id = invoice1.getItems().get(1).getId();
        int item3Id = invoice1.getItems().get(2).getId();

        //Then
        Assertions.assertNotEquals(0, item1Id);
        Assertions.assertNotEquals(0, item2Id);
        Assertions.assertNotEquals(0, item3Id);
        Assertions.assertNotEquals(0, invoice1Id);

        /*
        //CleanUp
        try {
            itemDao.deleteById(item1Id);
            itemDao.deleteById(item2Id);
            itemDao.deleteById(item3Id);
            invoiceDao.deleteById(invoice1Id);
        } catch (Exception e) {
            //do nothing
        }*/
    }
    @DisplayName("Test: productDaoSave()")
    @Test
    void testProductDaoSave() {
        //Given
        Product product1 = new Product("Product1");

        Item item1 = new Item(new BigDecimal(100), 2, new BigDecimal(200));
        Item item2 = new Item(new BigDecimal(50), 4, new BigDecimal(200));

        product1.getItems().add(item1);
        product1.getItems().add(item2);

        //When
        productDao.save(product1);

        int product1Id = product1.getId();

        int item1Id = product1.getItems().get(0).getId();
        int item2Id = product1.getItems().get(1).getId();

        //Then
        Assertions.assertNotEquals(0, product1Id);
        Assertions.assertNotEquals(0, item1Id);
        Assertions.assertNotEquals(0, item2Id);

        /*
        //CleanUp
        try {
            productDao.deleteById(product1Id);
            itemDao.deleteById(item1Id);
            itemDao.deleteById(item2Id);
        } catch (Exception e) {
            //do nothing
        }*/
    }
}