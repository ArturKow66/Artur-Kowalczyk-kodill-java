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

    @DisplayName("Test: findByListName()")
    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");
        Product product3 = new Product("Product3");

        Item item1 = new Item(new BigDecimal(100), 2, new BigDecimal(200));
        Item item2 = new Item(new BigDecimal(50), 4, new BigDecimal(200));
        Item item3 = new Item(new BigDecimal(25), 8, new BigDecimal(200));

        Invoice invoice1 = new Invoice("0001/01");

        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product2.getItems().add(item2);
        product3.getItems().add(item2);
        product3.getItems().add(item3);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);

        //When
        productDao.save(product1);
        int product1Id = product1.getId();
        productDao.save(product2);
        int product2Id = product2.getId();
        productDao.save(product3);
        int product3Id = product3.getId();

        itemDao.save(item1);
        int item1Id = item1.getId();
        itemDao.save(item2);
        int item2Id = item2.getId();
        itemDao.save(item3);
        int item3Id = item3.getId();

        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();

        //Then
        Assertions.assertNotEquals(0, product1Id);
        Assertions.assertNotEquals(0, product2Id);
        Assertions.assertNotEquals(0, product3Id);

        Assertions.assertNotEquals(0, item1Id);
        Assertions.assertNotEquals(0, item2Id);
        Assertions.assertNotEquals(0, item3Id);

        Assertions.assertNotEquals(0, invoice1Id);

        //CleanUp
        try {
            productDao.deleteById(product1Id);
            productDao.deleteById(product2Id);
            productDao.deleteById(product3Id);
            itemDao.deleteById(item1Id);
            itemDao.deleteById(item2Id);
            itemDao.deleteById(item3Id);
            invoiceDao.deleteById(invoice1Id);
        } catch (Exception e) {
            //do nothing
        }
    }
}
